package org.pro.ygcms.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.facade.impl.assembler.CmsContentTopicAssembler;
import org.pro.ygcms.facade.CmsContentTopicFacade;
import org.pro.ygcms.application.CmsContentTopicApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentTopicFacadeImpl implements CmsContentTopicFacade {

	@Inject
	private CmsContentTopicApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentTopic(String id) {
		return InvokeResult.success(CmsContentTopicAssembler.toDTO(application.getCmsContentTopic(id)));
	}
	
	public InvokeResult creatCmsContentTopic(CmsContentTopicDTO cmsContentTopicDTO) {
		application.creatCmsContentTopic(CmsContentTopicAssembler.toEntity(cmsContentTopicDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentTopic(CmsContentTopicDTO cmsContentTopicDTO) {
		application.updateCmsContentTopic(CmsContentTopicAssembler.toEntity(cmsContentTopicDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentTopic(String id) {
		application.removeCmsContentTopic(application.getCmsContentTopic(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentTopics(String[] ids) {
		Set<CmsContentTopic> cmsContentTopics= new HashSet<CmsContentTopic>();
		for (String id : ids) {
			cmsContentTopics.add(application.getCmsContentTopic(id));
		}
		application.removeCmsContentTopics(cmsContentTopics);
		return InvokeResult.success();
	}
	
	public List<CmsContentTopicDTO> findAllCmsContentTopic() {
		return CmsContentTopicAssembler.toDTOs(application.findAllCmsContentTopic());
	}
	
	public Page<CmsContentTopicDTO> pageQueryCmsContentTopic(CmsContentTopicDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentTopic from CmsContentTopic _cmsContentTopic   where 1=1 ");
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsContentTopic.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
	   	if (queryVo.getTopicId() != null) {
	   		jpql.append(" and _cmsContentTopic.topicId=?");
	   		conditionVals.add(queryVo.getTopicId());
	   	}	
        @SuppressWarnings("unchecked")
		Page<CmsContentTopic> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentTopicDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentTopicAssembler.toDTOs(pages.getData()));
	}
	
	public CmsContentTopicDTO getCmsContentTopicByCId(String contentId){
		CmsContentTopicDTO cmsContentTopicDTO = CmsContentTopicAssembler.toDTO(application.getCmsContentTopicByCId(contentId));
		return cmsContentTopicDTO;
	}
	
	public InvokeResult removeCmsContentTopicsByCId(String contentId){
		CmsContentTopic cmsContentTopic = application.getCmsContentTopicByCId(contentId);
		application.removeCmsContentTopic(cmsContentTopic);
		return InvokeResult.success();
	}
}
