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
import org.pro.ygcms.facade.impl.assembler.CmsTopicAssembler;
import org.pro.ygcms.facade.impl.assembler.CmsTopicFacade;
import org.pro.ygcms.application.CmsTopicApplication;

import org.pro.ygcms.core.domain.channel.*;

@Named
public class CmsTopicFacadeImpl implements CmsTopicFacade {

	@Inject
	private CmsTopicApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsTopic(String id) {
		return InvokeResult.success(CmsTopicAssembler.toDTO(application.getCmsTopic(id)));
	}
	
	public InvokeResult creatCmsTopic(CmsTopicDTO cmsTopicDTO) {
		application.creatCmsTopic(CmsTopicAssembler.toEntity(cmsTopicDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsTopic(CmsTopicDTO cmsTopicDTO) {
		application.updateCmsTopic(CmsTopicAssembler.toEntity(cmsTopicDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsTopic(String id) {
		application.removeCmsTopic(application.getCmsTopic(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsTopics(String[] ids) {
		Set<CmsTopic> cmsTopics= new HashSet<CmsTopic>();
		for (String id : ids) {
			cmsTopics.add(application.getCmsTopic(id));
		}
		application.removeCmsTopics(cmsTopics);
		return InvokeResult.success();
	}
	
	public List<CmsTopicDTO> findAllCmsTopic() {
		return CmsTopicAssembler.toDTOs(application.findAllCmsTopic());
	}
	
	public Page<CmsTopicDTO> pageQueryCmsTopic(CmsTopicDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsTopic from CmsTopic _cmsTopic   where 1=1 ");
	   	if (queryVo.getId() != null && !"".equals(queryVo.getId())) {
	   		jpql.append(" and _cmsTopic.id like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getId()));
	   	}		
	   	if (queryVo.getChannelid() != null && !"".equals(queryVo.getChannelid())) {
	   		jpql.append(" and _cmsTopic.channelid like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getChannelid()));
	   	}		
	   	if (queryVo.getTopicname() != null && !"".equals(queryVo.getTopicname())) {
	   		jpql.append(" and _cmsTopic.topicname like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTopicname()));
	   	}		
	   	if (queryVo.getShortname() != null && !"".equals(queryVo.getShortname())) {
	   		jpql.append(" and _cmsTopic.shortname like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getShortname()));
	   	}		
	   	if (queryVo.getKeywords() != null && !"".equals(queryVo.getKeywords())) {
	   		jpql.append(" and _cmsTopic.keywords like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getKeywords()));
	   	}		
	   	if (queryVo.getDescription() != null && !"".equals(queryVo.getDescription())) {
	   		jpql.append(" and _cmsTopic.description like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDescription()));
	   	}		
	   	if (queryVo.getTitleimg() != null && !"".equals(queryVo.getTitleimg())) {
	   		jpql.append(" and _cmsTopic.titleimg like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTitleimg()));
	   	}		
	   	if (queryVo.getContentimg() != null && !"".equals(queryVo.getContentimg())) {
	   		jpql.append(" and _cmsTopic.contentimg like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getContentimg()));
	   	}		
	   	if (queryVo.getTplcontent() != null && !"".equals(queryVo.getTplcontent())) {
	   		jpql.append(" and _cmsTopic.tplcontent like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTplcontent()));
	   	}		
	   	if (queryVo.getPriority() != null) {
	   		jpql.append(" and _cmsTopic.priority=?");
	   		conditionVals.add(queryVo.getPriority());
	   	}	
	   	if (queryVo.getIsrecommend() != null) {
	   		jpql.append(" and _cmsTopic.isrecommend=?");
	   		conditionVals.add(queryVo.getIsrecommend());
	   	}	
        Page<CmsTopic> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsTopicDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsTopicAssembler.toDTOs(pages.getData()));
	}
	
	
}
