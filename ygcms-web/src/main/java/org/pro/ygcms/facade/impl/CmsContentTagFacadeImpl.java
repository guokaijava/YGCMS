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
import org.pro.ygcms.facade.impl.assembler.CmsContentTagAssembler;
import org.pro.ygcms.facade.CmsContentTagFacade;
import org.pro.ygcms.application.CmsContentTagApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentTagFacadeImpl implements CmsContentTagFacade {

	@Inject
	private CmsContentTagApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentTag(Long id) {
		return InvokeResult.success(CmsContentTagAssembler.toDTO(application.getCmsContentTag(id)));
	}
	
	public InvokeResult creatCmsContentTag(CmsContentTagDTO cmsContentTagDTO) {
		application.creatCmsContentTag(CmsContentTagAssembler.toEntity(cmsContentTagDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentTag(CmsContentTagDTO cmsContentTagDTO) {
		application.updateCmsContentTag(CmsContentTagAssembler.toEntity(cmsContentTagDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentTag(Long id) {
		application.removeCmsContentTag(application.getCmsContentTag(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentTags(Long[] ids) {
		Set<CmsContentTag> cmsContentTags= new HashSet<CmsContentTag>();
		for (Long id : ids) {
			cmsContentTags.add(application.getCmsContentTag(id));
		}
		application.removeCmsContentTags(cmsContentTags);
		return InvokeResult.success();
	}
	
	public List<CmsContentTagDTO> findAllCmsContentTag() {
		return CmsContentTagAssembler.toDTOs(application.findAllCmsContentTag());
	}
	
	public Page<CmsContentTagDTO> pageQueryCmsContentTag(CmsContentTagDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentTag from CmsContentTag _cmsContentTag   where 1=1 ");
	   	if (queryVo.getTagName() != null && !"".equals(queryVo.getTagName())) {
	   		jpql.append(" and _cmsContentTag.tagName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTagName()));
	   	}		
	   	if (queryVo.getRefCounter() != null) {
	   		jpql.append(" and _cmsContentTag.refCounter=?");
	   		conditionVals.add(queryVo.getRefCounter());
	   	}	
        Page<CmsContentTag> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentTagDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentTagAssembler.toDTOs(pages.getData()));
	}
	
	
}
