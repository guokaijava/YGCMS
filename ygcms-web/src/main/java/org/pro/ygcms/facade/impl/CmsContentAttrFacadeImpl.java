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
import org.pro.ygcms.facade.impl.assembler.CmsContentAttrAssembler;
import org.pro.ygcms.facade.CmsContentAttrFacade;
import org.pro.ygcms.application.CmsContentAttrApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentAttrFacadeImpl implements CmsContentAttrFacade {

	@Inject
	private CmsContentAttrApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentAttr(String id) {
		return InvokeResult.success(CmsContentAttrAssembler.toDTO(application.getCmsContentAttr(id)));
	}
	
	public InvokeResult creatCmsContentAttr(CmsContentAttrDTO cmsContentAttrDTO) {
		application.creatCmsContentAttr(CmsContentAttrAssembler.toEntity(cmsContentAttrDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentAttr(CmsContentAttrDTO cmsContentAttrDTO) {
		application.updateCmsContentAttr(CmsContentAttrAssembler.toEntity(cmsContentAttrDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentAttr(String id) {
		application.removeCmsContentAttr(application.getCmsContentAttr(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentAttrs(String[] ids) {
		Set<CmsContentAttr> cmsContentAttrs= new HashSet<CmsContentAttr>();
		for (String id : ids) {
			cmsContentAttrs.add(application.getCmsContentAttr(id));
		}
		application.removeCmsContentAttrs(cmsContentAttrs);
		return InvokeResult.success();
	}
	
	public List<CmsContentAttrDTO> findAllCmsContentAttr() {
		return CmsContentAttrAssembler.toDTOs(application.findAllCmsContentAttr());
	}
	
	public Page<CmsContentAttrDTO> pageQueryCmsContentAttr(CmsContentAttrDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentAttr from CmsContentAttr _cmsContentAttr   where 1=1 ");
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsContentAttr.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
	   	if (queryVo.getAttrName() != null && !"".equals(queryVo.getAttrName())) {
	   		jpql.append(" and _cmsContentAttr.attrName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttrName()));
	   	}		
	   	if (queryVo.getAttrValue() != null && !"".equals(queryVo.getAttrValue())) {
	   		jpql.append(" and _cmsContentAttr.attrValue like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttrValue()));
	   	}		
        @SuppressWarnings("unchecked")
		Page<CmsContentAttr> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentAttrDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentAttrAssembler.toDTOs(pages.getData()));
	}
	
	public List<CmsContentAttrDTO> getCmsContentAttrByCId(String contentId){
		return CmsContentAttrAssembler.toDTOs(application.findAllCmsContentAttrByCId(contentId));
	}
	
	public InvokeResult removeCmsContentAttrsByCId(String contentId){
		List<CmsContentAttr> cmsContentAttrList = application.findAllCmsContentAttrByCId(contentId);
		Set<CmsContentAttr> cmsContentAttrSet = new HashSet<CmsContentAttr>();
		cmsContentAttrSet.addAll(cmsContentAttrList);
		application.removeCmsContentAttrs(cmsContentAttrSet);
		return InvokeResult.success();
	}
}
