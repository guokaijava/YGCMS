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
import org.pro.ygcms.facade.impl.assembler.CmsConfigItemAssembler;
import org.pro.ygcms.facade.CmsConfigItemFacade;
import org.pro.ygcms.application.CmsConfigItemApplication;

import org.pro.ygcms.core.domain.config.*;

@Named
public class CmsConfigItemFacadeImpl implements CmsConfigItemFacade {

	@Inject
	private CmsConfigItemApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsConfigItem(Long id) {
		return InvokeResult.success(CmsConfigItemAssembler.toDTO(application.getCmsConfigItem(id)));
	}
	
	public InvokeResult creatCmsConfigItem(CmsConfigItemDTO cmsConfigItemDTO) {
		application.creatCmsConfigItem(CmsConfigItemAssembler.toEntity(cmsConfigItemDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsConfigItem(CmsConfigItemDTO cmsConfigItemDTO) {
		application.updateCmsConfigItem(CmsConfigItemAssembler.toEntity(cmsConfigItemDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsConfigItem(Long id) {
		application.removeCmsConfigItem(application.getCmsConfigItem(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsConfigItems(Long[] ids) {
		Set<CmsConfigItem> cmsConfigItems= new HashSet<CmsConfigItem>();
		for (Long id : ids) {
			cmsConfigItems.add(application.getCmsConfigItem(id));
		}
		application.removeCmsConfigItems(cmsConfigItems);
		return InvokeResult.success();
	}
	
	public List<CmsConfigItemDTO> findAllCmsConfigItem() {
		return CmsConfigItemAssembler.toDTOs(application.findAllCmsConfigItem());
	}
	
	public Page<CmsConfigItemDTO> pageQueryCmsConfigItem(CmsConfigItemDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsConfigItem from CmsConfigItem _cmsConfigItem   where 1=1 ");
	   	if (queryVo.getConfigId() != null) {
	   		jpql.append(" and _cmsConfigItem.configId=?");
	   		conditionVals.add(queryVo.getConfigId());
	   	}	
	   	if (queryVo.getField() != null && !"".equals(queryVo.getField())) {
	   		jpql.append(" and _cmsConfigItem.field like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getField()));
	   	}		
	   	if (queryVo.getItemLabel() != null && !"".equals(queryVo.getItemLabel())) {
	   		jpql.append(" and _cmsConfigItem.itemLabel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getItemLabel()));
	   	}		
	   	if (queryVo.getPriority() != null) {
	   		jpql.append(" and _cmsConfigItem.priority=?");
	   		conditionVals.add(queryVo.getPriority());
	   	}	
	   	if (queryVo.getDefValue() != null && !"".equals(queryVo.getDefValue())) {
	   		jpql.append(" and _cmsConfigItem.defValue like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDefValue()));
	   	}		
	   	if (queryVo.getOptValue() != null && !"".equals(queryVo.getOptValue())) {
	   		jpql.append(" and _cmsConfigItem.optValue like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOptValue()));
	   	}		
	   	if (queryVo.getTextSize() != null && !"".equals(queryVo.getTextSize())) {
	   		jpql.append(" and _cmsConfigItem.textSize like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTextSize()));
	   	}		
	   	if (queryVo.getAreaRows() != null && !"".equals(queryVo.getAreaRows())) {
	   		jpql.append(" and _cmsConfigItem.areaRows like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAreaRows()));
	   	}		
	   	if (queryVo.getAreaCols() != null && !"".equals(queryVo.getAreaCols())) {
	   		jpql.append(" and _cmsConfigItem.areaCols like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAreaCols()));
	   	}		
	   	if (queryVo.getHelp() != null && !"".equals(queryVo.getHelp())) {
	   		jpql.append(" and _cmsConfigItem.help like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHelp()));
	   	}		
	   	if (queryVo.getHelpPosition() != null && !"".equals(queryVo.getHelpPosition())) {
	   		jpql.append(" and _cmsConfigItem.helpPosition like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getHelpPosition()));
	   	}		
	   	if (queryVo.getDataType() != null) {
	   		jpql.append(" and _cmsConfigItem.dataType=?");
	   		conditionVals.add(queryVo.getDataType());
	   	}	
	   	if (queryVo.getIsRequired() != null) {
		   	jpql.append(" and _cmsConfigItem.isRequired is ?");
		   	conditionVals.add(queryVo.getIsRequired());
	   	}	
	   	if (queryVo.getCategory() != null) {
	   		jpql.append(" and _cmsConfigItem.category=?");
	   		conditionVals.add(queryVo.getCategory());
	   	}	
        Page<CmsConfigItem> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsConfigItemDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsConfigItemAssembler.toDTOs(pages.getData()));
	}
	
	
}
