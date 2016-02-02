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
import org.pro.ygcms.facade.impl.assembler.CmsModelItemAssembler;
import org.pro.ygcms.facade.CmsModelItemFacade;
import org.pro.ygcms.application.CmsModelItemApplication;

import org.pro.ygcms.core.domain.model.*;

@Named
public class CmsModelItemFacadeImpl implements CmsModelItemFacade {

	@Inject
	private CmsModelItemApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsModelItem(String id) {
		return InvokeResult.success(CmsModelItemAssembler.toDTO(application.getCmsModelItem(id)));
	}
	
	public InvokeResult creatCmsModelItem(CmsModelItemDTO cmsModelItemDTO) {
		application.creatCmsModelItem(CmsModelItemAssembler.toEntity(cmsModelItemDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsModelItem(CmsModelItemDTO cmsModelItemDTO) {
		application.updateCmsModelItem(CmsModelItemAssembler.toEntity(cmsModelItemDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsModelItem(String id) {
		application.removeCmsModelItem(application.getCmsModelItem(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsModelItems(String[] ids) {
		Set<CmsModelItem> cmsModelItems= new HashSet<CmsModelItem>();
		for (String id : ids) {
			cmsModelItems.add(application.getCmsModelItem(id));
		}
		application.removeCmsModelItems(cmsModelItems);
		return InvokeResult.success();
	}
	
	public List<CmsModelItemDTO> findAllCmsModelItem() {
		return CmsModelItemAssembler.toDTOs(application.findAllCmsModelItem());
	}
	
	@SuppressWarnings("unchecked")
	public Page<CmsModelItemDTO> pageQueryCmsModelItem(CmsModelItemDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsModelItem from CmsModelItem _cmsModelItem   where 1=1 ");
	   	if (queryVo.getModelid() != null) {
	   		jpql.append(" and _cmsModelItem.modelid=?");
	   		conditionVals.add(queryVo.getModelid());
	   	}	
	   	if (queryVo.getField() != null && !"".equals(queryVo.getField())) {
	   		jpql.append(" and _cmsModelItem.field like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getField()));
	   	}		
	   	if (queryVo.getItemlabel() != null && !"".equals(queryVo.getItemlabel())) {
	   		jpql.append(" and _cmsModelItem.itemlabel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getItemlabel()));
	   	}		
	   	if (queryVo.getPriority() != null) {
	   		jpql.append(" and _cmsModelItem.priority=?");
	   		conditionVals.add(queryVo.getPriority());
	   	}	
	   	if (queryVo.getDefvalue() != null && !"".equals(queryVo.getDefvalue())) {
	   		jpql.append(" and _cmsModelItem.defvalue like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDefvalue()));
	   	}		
	   	if (queryVo.getOptvalue() != null && !"".equals(queryVo.getOptvalue())) {
	   		jpql.append(" and _cmsModelItem.optvalue like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptvalue()));
	   	}		
	   	if (queryVo.getTextsize() != null && !"".equals(queryVo.getTextsize())) {
	   		jpql.append(" and _cmsModelItem.textsize like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTextsize()));
	   	}		
	   	if (queryVo.getArearows() != null && !"".equals(queryVo.getArearows())) {
	   		jpql.append(" and _cmsModelItem.arearows like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getArearows()));
	   	}		
	   	if (queryVo.getAreacols() != null && !"".equals(queryVo.getAreacols())) {
	   		jpql.append(" and _cmsModelItem.areacols like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAreacols()));
	   	}		
	   	if (queryVo.getHelp() != null && !"".equals(queryVo.getHelp())) {
	   		jpql.append(" and _cmsModelItem.help like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHelp()));
	   	}		
	   	if (queryVo.getHelpposition() != null && !"".equals(queryVo.getHelpposition())) {
	   		jpql.append(" and _cmsModelItem.helpposition like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHelpposition()));
	   	}		
	   	if (queryVo.getDatatype() != null) {
	   		jpql.append(" and _cmsModelItem.datatype=?");
	   		conditionVals.add(queryVo.getDatatype());
	   	}	
	   	if (queryVo.getIssingle() != null) {
	   		jpql.append(" and _cmsModelItem.issingle=?");
	   		conditionVals.add(queryVo.getIssingle());
	   	}	
	   	if (queryVo.getIschannel() != null) {
	   		jpql.append(" and _cmsModelItem.ischannel=?");
	   		conditionVals.add(queryVo.getIschannel());
	   	}	
	   	if (queryVo.getIscustom() != null) {
	   		jpql.append(" and _cmsModelItem.iscustom=?");
	   		conditionVals.add(queryVo.getIscustom());
	   	}	
	   	if (queryVo.getIsdisplay() != null) {
	   		jpql.append(" and _cmsModelItem.isdisplay=?");
	   		conditionVals.add(queryVo.getIsdisplay());
	   	}	
	   	if (queryVo.getCard() != null) {
	   		jpql.append(" and _cmsModelItem.card=?");
	   		conditionVals.add(queryVo.getCard());
	   	}	
	   	jpql.append(" order by _cmsModelItem.priority");
	   	
		Page<CmsModelItem> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsModelItemDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsModelItemAssembler.toDTOs(pages.getData()));
	}

	@Override
	public List<CmsModelItemDTO> getItemsByModelId(String id,int ischannel) {
		return CmsModelItemAssembler.toDTOs(application.findCmsModelItemByModelId(id,ischannel));
	}
	
	
}
