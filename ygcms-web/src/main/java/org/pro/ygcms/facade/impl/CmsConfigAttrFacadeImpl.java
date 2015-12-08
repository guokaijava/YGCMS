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
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.facade.impl.assembler.CmsConfigAttrAssembler;
import org.pro.ygcms.facade.CmsConfigAttrFacade;
import org.pro.ygcms.application.CmsConfigAttrApplication;

import org.pro.ygcms.core.domain.config.*;

@Named
public class CmsConfigAttrFacadeImpl implements CmsConfigAttrFacade {

	@Inject
	private CmsConfigAttrApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsConfigAttr(Long id) {
		return InvokeResult.success(CmsConfigAttrAssembler.toDTO(application.getCmsConfigAttr(id)));
	}
	
	public InvokeResult creatCmsConfigAttr(CmsConfigAttrDTO cmsConfigAttrDTO) {
		application.creatCmsConfigAttr(CmsConfigAttrAssembler.toEntity(cmsConfigAttrDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsConfigAttr(CmsConfigAttrDTO cmsConfigAttrDTO) {
		application.updateCmsConfigAttr(CmsConfigAttrAssembler.toEntity(cmsConfigAttrDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsConfigAttr(Long id) {
		application.removeCmsConfigAttr(application.getCmsConfigAttr(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsConfigAttrs(Long[] ids) {
		Set<CmsConfigAttr> cmsConfigAttrs= new HashSet<CmsConfigAttr>();
		for (Long id : ids) {
			cmsConfigAttrs.add(application.getCmsConfigAttr(id));
		}
		application.removeCmsConfigAttrs(cmsConfigAttrs);
		return InvokeResult.success();
	}
	
	public List<CmsConfigAttrDTO> findAllCmsConfigAttr() {
		return CmsConfigAttrAssembler.toDTOs(application.findAllCmsConfigAttr());
	}
	
	public Page<CmsConfigAttrDTO> pageQueryCmsConfigAttr(CmsConfigAttrDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsConfigAttr from CmsConfigAttr _cmsConfigAttr   where 1=1 ");
	   	if (queryVo.getConfigId() != null) {
	   		jpql.append(" and _cmsConfigAttr.configId=?");
	   		conditionVals.add(queryVo.getConfigId());
	   	}	
	   	if (queryVo.getAttrName() != null && !"".equals(queryVo.getAttrName())) {
	   		jpql.append(" and _cmsConfigAttr.attrName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttrName()));
	   	}		
	   	if (queryVo.getAttrValue() != null && !"".equals(queryVo.getAttrValue())) {
	   		jpql.append(" and _cmsConfigAttr.attrValue like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttrValue()));
	   	}		
        Page<CmsConfigAttr> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsConfigAttrDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsConfigAttrAssembler.toDTOs(pages.getData()));
	}
	
	
}
