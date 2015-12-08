package org.pro.ygcms.facade.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

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
	
	public InvokeResult creatCmsChannel(CmsChannelDTO cmsChannelDTO) {
		application.creatCmsChannel(CmsChannelAssembler.toEntity(cmsChannelDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsChannel(CmsChannelDTO cmsChannelDTO) {
		application.updateCmsChannel(CmsChannelAssembler.toEntity(cmsChannelDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannel(String id) {
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
				+ "(cc.id,cce.channelName,cc.siteId,cc.parentId) FROM CmsChannel cc , CmsChannelExt cce  "
				+ "WHERE cce.channelId = cc.id and cc.siteId="+siteId+" and cc.parentId = 0 order by cc.id ");
		CmsChannelInfoDTO top = (CmsChannelInfoDTO) getQueryChannelService().createJpqlQuery(jpql.toString()).singleResult();
		jpql = new StringBuilder("SELECT NEW org.pro.ygcms.facade.dto.CmsChannelInfoDTO"
				+ "(cc.id,cce.channelName,cc.siteId,cc.parentId) FROM CmsChannel cc , CmsChannelExt cce  "
				+ "WHERE cce.channelId = cc.id and cc.siteId="+siteId+" order by cc.id ");
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
	   	StringBuilder jpql = new StringBuilder("select _cmsChannel from CmsChannel _cmsChannel   where 1=1 and _cmsChannel.parentId = "+pid);
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
