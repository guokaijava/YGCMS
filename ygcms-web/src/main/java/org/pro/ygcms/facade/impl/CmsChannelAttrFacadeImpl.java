package org.pro.ygcms.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;
import javax.inject.Inject;
import javax.inject.Named;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsChannelAttrFacade;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.facade.impl.assembler.CmsChannelAttrAssembler;
import org.pro.ygcms.application.CmsChannelAttrApplication;

import org.pro.ygcms.core.domain.channel.*;

@Named
public class CmsChannelAttrFacadeImpl implements CmsChannelAttrFacade {

	@Inject
	private CmsChannelAttrApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsChannelAttr(String id) {
		return InvokeResult.success(CmsChannelAttrAssembler.toDTO(application.getCmsChannelAttr(id)));
	}
	
	public InvokeResult creatCmsChannelAttr(CmsChannelAttrDTO cmsChannelAttrDTO) {
		application.creatCmsChannelAttr(CmsChannelAttrAssembler.toEntity(cmsChannelAttrDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsChannelAttr(CmsChannelAttrDTO cmsChannelAttrDTO) {
		CmsChannelAttr cmsChannelAttr = application.getCmsChannelAttrByName(CmsChannelAttrAssembler.toEntity(cmsChannelAttrDTO));
		if(cmsChannelAttr==null){
			application.creatCmsChannelAttr(CmsChannelAttrAssembler.toEntity(cmsChannelAttrDTO));
		}else{
			cmsChannelAttr.setAttrValue(cmsChannelAttrDTO.getAttrValue());
			application.updateCmsChannelAttr(cmsChannelAttr);
		}
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannelAttr(String id) {
		application.removeCmsChannelAttr(application.getCmsChannelAttr(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannelAttrs(String[] ids) {
		Set<CmsChannelAttr> cmsChannelAttrs= new HashSet<CmsChannelAttr>();
		for (String id : ids) {
			cmsChannelAttrs.add(application.getCmsChannelAttr(id));
		}
		application.removeCmsChannelAttrs(cmsChannelAttrs);
		return InvokeResult.success();
	}
	
	public List<CmsChannelAttrDTO> findAllCmsChannelAttr() {
		return CmsChannelAttrAssembler.toDTOs(application.findAllCmsChannelAttr());
	}
	
	public Page<CmsChannelAttrDTO> pageQueryCmsChannelAttr(CmsChannelAttrDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsChannelAttr from CmsChannelAttr _cmsChannelAttr   where 1=1 ");
	   	if (queryVo.getId() != null && !"".equals(queryVo.getId())) {
	   		jpql.append(" and _cmsChannelAttr.id like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getId()));
	   	}		
	   	if (queryVo.getChannelId() != null && !"".equals(queryVo.getChannelId())) {
	   		jpql.append(" and _cmsChannelAttr.channelId like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getChannelId()));
	   	}		
	   	if (queryVo.getAttrName() != null && !"".equals(queryVo.getAttrName())) {
	   		jpql.append(" and _cmsChannelAttr.attrName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttrName()));
	   	}		
	   	if (queryVo.getAttrValue() != null && !"".equals(queryVo.getAttrValue())) {
	   		jpql.append(" and _cmsChannelAttr.attrValue like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttrValue()));
	   	}		
        @SuppressWarnings("unchecked")
		Page<CmsChannelAttr> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsChannelAttrDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsChannelAttrAssembler.toDTOs(pages.getData()));
	}

	@Override
	public void removeCmsChannelAttrByCid(String channelId) {
		application.removeCmsChannelAttrs(new HashSet<CmsChannelAttr>(application.getCmsChannelAttrByCid(channelId)));
	}

	@Override
	public List<CmsChannelAttrDTO> getCmsChannelAttrByCid(String id) {
		return CmsChannelAttrAssembler.toDTOs(application.getCmsChannelAttrByCid(id));
	}
	
	
}
