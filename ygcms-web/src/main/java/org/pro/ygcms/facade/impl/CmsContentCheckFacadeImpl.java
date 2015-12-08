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
import org.pro.ygcms.facade.impl.assembler.CmsContentCheckAssembler;
import org.pro.ygcms.facade.CmsContentCheckFacade;
import org.pro.ygcms.application.CmsContentCheckApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentCheckFacadeImpl implements CmsContentCheckFacade {

	@Inject
	private CmsContentCheckApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentCheck(Long id) {
		return InvokeResult.success(CmsContentCheckAssembler.toDTO(application.getCmsContentCheck(id)));
	}
	
	public InvokeResult creatCmsContentCheck(CmsContentCheckDTO cmsContentCheckDTO) {
		application.creatCmsContentCheck(CmsContentCheckAssembler.toEntity(cmsContentCheckDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentCheck(CmsContentCheckDTO cmsContentCheckDTO) {
		application.updateCmsContentCheck(CmsContentCheckAssembler.toEntity(cmsContentCheckDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentCheck(Long id) {
		application.removeCmsContentCheck(application.getCmsContentCheck(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentChecks(Long[] ids) {
		Set<CmsContentCheck> cmsContentChecks= new HashSet<CmsContentCheck>();
		for (Long id : ids) {
			cmsContentChecks.add(application.getCmsContentCheck(id));
		}
		application.removeCmsContentChecks(cmsContentChecks);
		return InvokeResult.success();
	}
	
	public List<CmsContentCheckDTO> findAllCmsContentCheck() {
		return CmsContentCheckAssembler.toDTOs(application.findAllCmsContentCheck());
	}
	
	public Page<CmsContentCheckDTO> pageQueryCmsContentCheck(CmsContentCheckDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentCheck from CmsContentCheck _cmsContentCheck   where 1=1 ");
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsContentCheck.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
	   	if (queryVo.getCheckStep() != null) {
	   		jpql.append(" and _cmsContentCheck.checkStep=?");
	   		conditionVals.add(queryVo.getCheckStep());
	   	}	
	   	if (queryVo.getCheckOpinion() != null && !"".equals(queryVo.getCheckOpinion())) {
	   		jpql.append(" and _cmsContentCheck.checkOpinion like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getCheckOpinion()));
	   	}		
	   	if (queryVo.getIsRejected() != null) {
		   	jpql.append(" and _cmsContentCheck.isRejected is ?");
		   	conditionVals.add(queryVo.getIsRejected());
	   	}	
	   	if (queryVo.getReviewer() != null) {
	   		jpql.append(" and _cmsContentCheck.reviewer=?");
	   		conditionVals.add(queryVo.getReviewer());
	   	}	
        Page<CmsContentCheck> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentCheckDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentCheckAssembler.toDTOs(pages.getData()));
	}
	
	
}
