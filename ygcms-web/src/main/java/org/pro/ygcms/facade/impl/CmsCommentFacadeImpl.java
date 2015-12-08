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
import org.pro.ygcms.facade.impl.assembler.CmsCommentAssembler;
import org.pro.ygcms.facade.CmsCommentFacade;
import org.pro.ygcms.application.CmsCommentApplication;

import org.pro.ygcms.core.domain.comment.*;

@Named
public class CmsCommentFacadeImpl implements CmsCommentFacade {

	@Inject
	private CmsCommentApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsComment(Long id) {
		return InvokeResult.success(CmsCommentAssembler.toDTO(application.getCmsComment(id)));
	}
	
	public InvokeResult creatCmsComment(CmsCommentDTO cmsCommentDTO) {
		application.creatCmsComment(CmsCommentAssembler.toEntity(cmsCommentDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsComment(CmsCommentDTO cmsCommentDTO) {
		application.updateCmsComment(CmsCommentAssembler.toEntity(cmsCommentDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsComment(Long id) {
		application.removeCmsComment(application.getCmsComment(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsComments(Long[] ids) {
		Set<CmsComment> cmsComments= new HashSet<CmsComment>();
		for (Long id : ids) {
			cmsComments.add(application.getCmsComment(id));
		}
		application.removeCmsComments(cmsComments);
		return InvokeResult.success();
	}
	
	public List<CmsCommentDTO> findAllCmsComment() {
		return CmsCommentAssembler.toDTOs(application.findAllCmsComment());
	}
	
	public Page<CmsCommentDTO> pageQueryCmsComment(CmsCommentDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsComment from CmsComment _cmsComment   where 1=1 ");
	   	if (queryVo.getCommentUserId() != null) {
	   		jpql.append(" and _cmsComment.commentUserId=?");
	   		conditionVals.add(queryVo.getCommentUserId());
	   	}	
	   	if (queryVo.getReplyUserId() != null) {
	   		jpql.append(" and _cmsComment.replyUserId=?");
	   		conditionVals.add(queryVo.getReplyUserId());
	   	}	
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsComment.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
	   	if (queryVo.getSiteId() != null) {
	   		jpql.append(" and _cmsComment.siteId=?");
	   		conditionVals.add(queryVo.getSiteId());
	   	}	
	   	if (queryVo.getUps() != null) {
	   		jpql.append(" and _cmsComment.ups=?");
	   		conditionVals.add(queryVo.getUps());
	   	}	
	   	if (queryVo.getDowns() != null) {
	   		jpql.append(" and _cmsComment.downs=?");
	   		conditionVals.add(queryVo.getDowns());
	   	}	
	   	if (queryVo.getIsRecommend() != null) {
		   	jpql.append(" and _cmsComment.isRecommend is ?");
		   	conditionVals.add(queryVo.getIsRecommend());
	   	}	
	   	if (queryVo.getIsChecked() != null) {
		   	jpql.append(" and _cmsComment.isChecked is ?");
		   	conditionVals.add(queryVo.getIsChecked());
	   	}	
	   	if (queryVo.getScore() != null) {
	   		jpql.append(" and _cmsComment.score=?");
	   		conditionVals.add(queryVo.getScore());
	   	}	
        Page<CmsComment> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsCommentDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsCommentAssembler.toDTOs(pages.getData()));
	}
	
	
}
