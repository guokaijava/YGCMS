package org.pro.ygcms.facade.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.QueryChannelService;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.application.CmsChannelApplication;
import org.pro.ygcms.core.domain.channel.CmsChannel;
import org.pro.ygcms.facade.CmsChannelFacade;
import org.pro.ygcms.facade.dto.CmsChannelDTO;
import org.pro.ygcms.facade.dto.CmsChannelExtDTO;
import org.pro.ygcms.facade.dto.CmsChannelInfoDTO;
import org.pro.ygcms.facade.impl.assembler.CmsChannelAssembler;

@Named
@SuppressWarnings("unchecked")
public class CmsChannelFacadeImpl implements CmsChannelFacade {

	@Inject
	private CmsChannelApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsChannel(String id) {
		return InvokeResult.success(CmsChannelAssembler.toDTO(application.getCmsChannel(id)));
	}
	/**
	 * 新增栏目
	 */
	public String creatCmsChannel(CmsChannelDTO cmsChannelDTO) {
		CmsChannel pcmsChannel = application.getCmsChannel(cmsChannelDTO.getParentId());
		if(pcmsChannel!=null){
			// 更新其他栏目左值
			String updLftSql = "update  CmsChannel _cmsChannel set _cmsChannel.lft = _cmsChannel.lft+2 where _cmsChannel.lft > "+pcmsChannel.getRgt()+" and _cmsChannel.siteId = '"+pcmsChannel.getSiteId()+"'";  
			application.execJpqlSql(updLftSql);
			// 更新其他栏目右值
			String updRgtSql = "update  CmsChannel _cmsChannel set _cmsChannel.rgt = _cmsChannel.rgt+2 where _cmsChannel.rgt >= "+pcmsChannel.getRgt()+" and _cmsChannel.siteId = '"+pcmsChannel.getSiteId()+"'";  
			application.execJpqlSql(updRgtSql);
			cmsChannelDTO.setLft(pcmsChannel.getRgt());
			cmsChannelDTO.setRgt(pcmsChannel.getRgt()+1);
			cmsChannelDTO.setId(UUID.randomUUID().toString());
			application.creatCmsChannel(CmsChannelAssembler.toEntity(cmsChannelDTO));
			return cmsChannelDTO.getId();
		}else{
			cmsChannelDTO.setLft(0);
			cmsChannelDTO.setRgt(1);
			cmsChannelDTO.setId(UUID.randomUUID().toString());
			cmsChannelDTO.setChannelName("根节点");
			application.creatCmsChannel(CmsChannelAssembler.toEntity(cmsChannelDTO));
			return cmsChannelDTO.getId();
		}
	}
	
	public InvokeResult updateCmsChannel(CmsChannelExtDTO cmsChannelExtDTO) {
		CmsChannel cmsChannel = application.getCmsChannel(cmsChannelExtDTO.getChannelId());
		cmsChannel.setChannelName(cmsChannelExtDTO.getChannelName());
		cmsChannel.setChannelPath(cmsChannelExtDTO.getChannelPath());
		cmsChannel.setPriority(cmsChannelExtDTO.getPriority());
		cmsChannel.setIsDisplay(cmsChannelExtDTO.getIsDisplay());
		application.updateCmsChannel(cmsChannel);
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannel(String id) {
		CmsChannel cmsChannel = application.getCmsChannel(id);
		int offset = cmsChannel.getRgt() - cmsChannel.getLft() +1 ;
		// 更新其他栏目左值
		String updLftSql = "update  CmsChannel _cmsChannel set _cmsChannel.lft = _cmsChannel.lft - "+offset+" where _cmsChannel.lft > "+cmsChannel.getLft()+" and _cmsChannel.siteId = '"+cmsChannel.getSiteId()+"'";  
		application.execJpqlSql(updLftSql);
		// 更新其他栏目右值
		String updRgtSql = "update  CmsChannel _cmsChannel set _cmsChannel.rgt = _cmsChannel.rgt - "+offset+" where _cmsChannel.rgt > "+cmsChannel.getRgt()+" and _cmsChannel.siteId = '"+cmsChannel.getSiteId()+"'";  
		application.execJpqlSql(updRgtSql);
		application.removeCmsChannel(application.getCmsChannel(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannels(String[] ids) {
		Set<CmsChannel> cmsChannels= new HashSet<CmsChannel>();
		for (String id : ids) {
			cmsChannels.add(application.getCmsChannel(id));
		}
		application.removeCmsChannels(cmsChannels);
		return InvokeResult.success();
	}
	
	public List<CmsChannelDTO> findAllCmsChannel() {
		return CmsChannelAssembler.toDTOs(application.findAllCmsChannel());
	}
	
	public Page<CmsChannelDTO> pageQueryCmsChannel(CmsChannelDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsChannel from CmsChannel _cmsChannel   where 1=1 ");
	   	if (queryVo.getChannelPath() != null && !"".equals(queryVo.getChannelPath())) {
	   		jpql.append(" and _cmsChannel.channelPath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getChannelPath()));
	   	}		
	   	if (queryVo.getHasContent() != null) {
	   		jpql.append(" and _cmsChannel.hasContent=?");
	   		conditionVals.add(queryVo.getHasContent());
	   	}	
	   	if (queryVo.getIsDisplay() != null) {
	   		jpql.append(" and _cmsChannel.isDisplay=?");
	   		conditionVals.add(queryVo.getIsDisplay());
	   	}	
	   	
		Page<CmsChannel> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsChannelDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsChannelAssembler.toDTOs(pages.getData()));
	}

	@Override
	public CmsChannelInfoDTO getChannelTree(String siteId) {
		StringBuilder jpql = new StringBuilder("SELECT NEW org.pro.ygcms.facade.dto.CmsChannelInfoDTO"
				+ "(cc.id,cc.channelName,cc.siteId,cc.parentId) FROM CmsChannel cc "
				+ "WHERE cc.siteId='"+siteId+"' and cc.parentId = 0 order by cc.priority,cc.id ");
		CmsChannelInfoDTO top = (CmsChannelInfoDTO) getQueryChannelService().createJpqlQuery(jpql.toString()).singleResult();
		jpql = new StringBuilder("SELECT NEW org.pro.ygcms.facade.dto.CmsChannelInfoDTO"
				+ "(cc.id,cc.channelName,cc.siteId,cc.parentId) FROM CmsChannel cc  "
				+ "WHERE cc.siteId='"+siteId+"' order by cc.priority,cc.id ");
		List<CmsChannelInfoDTO> all = getQueryChannelService().createJpqlQuery(jpql.toString()).list();
		LinkedHashMap<String, CmsChannelInfoDTO> map = new LinkedHashMap<String, CmsChannelInfoDTO>();
		if(top!=null){
			map.put(top.getId(), top);
			for (CmsChannelInfoDTO cmsChannelInfoDTO : all) {
				map.put(cmsChannelInfoDTO.getId(), cmsChannelInfoDTO);
			}
			for (CmsChannelInfoDTO cmsChannelInfoDTO : all) {
				String pid = cmsChannelInfoDTO.getPid();
				if (pid == null || map.get(pid) == null) {
					continue;
				}
				map.get(pid).getChildren().add(cmsChannelInfoDTO);
			}
			return map.get(top.getId());
		}else{
			return null;
		}
	}

	@Override
	public Page<CmsChannelDTO> getChildChannel(String pid) {
	   	StringBuilder jpql = new StringBuilder("select _cmsChannel from CmsChannel _cmsChannel   where 1=1 and _cmsChannel.parentId = '"+pid+"' order by _cmsChannel.priority");
		Page<CmsChannel> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setPage(0, Integer.MAX_VALUE)
		   .pagedList();
        return new Page<CmsChannelDTO>(pages.getStart(), pages.getResultCount(),Integer.MAX_VALUE, CmsChannelAssembler.toDTOs(pages.getData()));
	}

	@Override
	public CmsChannelDTO getChannelDetail(String cid) {
		// TODO Auto-generated method stub
		return null;
	}
}
