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
import org.pro.ygcms.facade.impl.assembler.CmsModelAssembler;
import org.pro.ygcms.facade.CmsModelFacade;
import org.pro.ygcms.application.CmsModelApplication;

import org.pro.ygcms.core.domain.model.*;

@Named
public class CmsModelFacadeImpl implements CmsModelFacade {

	@Inject
	private CmsModelApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsModel(String id) {
		return InvokeResult.success(CmsModelAssembler.toDTO(application.getCmsModel(id)));
	}
	
	public InvokeResult creatCmsModel(CmsModelDTO cmsModelDTO) {
		application.creatCmsModel(CmsModelAssembler.toEntity(cmsModelDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsModel(CmsModelDTO cmsModelDTO) {
		application.updateCmsModel(CmsModelAssembler.toEntity(cmsModelDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsModel(String id) {
		application.removeCmsModel(application.getCmsModel(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsModels(String[] ids) {
		Set<CmsModel> cmsModels= new HashSet<CmsModel>();
		for (String id : ids) {
			cmsModels.add(application.getCmsModel(id));
		}
		application.removeCmsModels(cmsModels);
		return InvokeResult.success();
	}
	
	public List<CmsModelDTO> findAllCmsModel() {
		return CmsModelAssembler.toDTOs(application.findAllCmsModel());
	}
	
	public Page<CmsModelDTO> pageQueryCmsModel(CmsModelDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsModel from CmsModel _cmsModel   where 1=1 ");
	   	if (queryVo.getModelname() != null && !"".equals(queryVo.getModelname())) {
	   		jpql.append(" and _cmsModel.modelname like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getModelname()));
	   	}		
	   	if (queryVo.getModelpath() != null && !"".equals(queryVo.getModelpath())) {
	   		jpql.append(" and _cmsModel.modelpath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getModelpath()));
	   	}		
	   	if (queryVo.getTplchannelprefix() != null && !"".equals(queryVo.getTplchannelprefix())) {
	   		jpql.append(" and _cmsModel.tplchannelprefix like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTplchannelprefix()));
	   	}		
	   	if (queryVo.getTplcontentprefix() != null && !"".equals(queryVo.getTplcontentprefix())) {
	   		jpql.append(" and _cmsModel.tplcontentprefix like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTplcontentprefix()));
	   	}		
	   	if (queryVo.getTitleimgwidth() != null) {
	   		jpql.append(" and _cmsModel.titleimgwidth=?");
	   		conditionVals.add(queryVo.getTitleimgwidth());
	   	}	
	   	if (queryVo.getTitleimgheight() != null) {
	   		jpql.append(" and _cmsModel.titleimgheight=?");
	   		conditionVals.add(queryVo.getTitleimgheight());
	   	}	
	   	if (queryVo.getContentimgwidth() != null) {
	   		jpql.append(" and _cmsModel.contentimgwidth=?");
	   		conditionVals.add(queryVo.getContentimgwidth());
	   	}	
	   	if (queryVo.getContentimgheight() != null) {
	   		jpql.append(" and _cmsModel.contentimgheight=?");
	   		conditionVals.add(queryVo.getContentimgheight());
	   	}	
	   	if (queryVo.getPriority() != null) {
	   		jpql.append(" and _cmsModel.priority=?");
	   		conditionVals.add(queryVo.getPriority());
	   	}	
	   	if (queryVo.getHascontent() != null) {
	   		jpql.append(" and _cmsModel.hascontent=?");
	   		conditionVals.add(queryVo.getHascontent());
	   	}	
	   	if (queryVo.getIsdisabled() != null) {
	   		jpql.append(" and _cmsModel.isdisabled=?");
	   		conditionVals.add(queryVo.getIsdisabled());
	   	}	
	   	if (queryVo.getIsdef() != null) {
	   		jpql.append(" and _cmsModel.isdef=?");
	   		conditionVals.add(queryVo.getIsdef());
	   	}
	   	jpql.append(" order by _cmsModel.priority");
        Page<CmsModel> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsModelDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsModelAssembler.toDTOs(pages.getData()));
	}
	
	
}
