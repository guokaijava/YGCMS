package org.pro.ygcms.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;
import java.text.MessageFormat;
import javax.inject.Inject;
import javax.inject.Named;
import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.facade.impl.assembler.CmsChannelAssembler;
import org.pro.ygcms.facade.impl.assembler.CmsContentAssembler;
import org.pro.ygcms.facade.CmsContentFacade;
import org.pro.ygcms.application.CmsContentApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentFacadeImpl implements CmsContentFacade {

	@Inject
	private CmsContentApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContent(Long id) {
		return InvokeResult.success(CmsContentAssembler.toDTO(application.getCmsContent(id)));
	}
	
	public String creatCmsContent(CmsContentDTO cmsContentDTO) {
		cmsContentDTO.setId(UUID.randomUUID().toString());
		application.creatCmsContent(CmsContentAssembler.toEntity(cmsContentDTO));
		return cmsContentDTO.getId();
	}
	
	public InvokeResult updateCmsContent(CmsContentDTO cmsContentDTO) {
		application.updateCmsContent(CmsContentAssembler.toEntity(cmsContentDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContent(Long id) {
		application.removeCmsContent(application.getCmsContent(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContents(Long[] ids) {
		Set<CmsContent> cmsContents= new HashSet<CmsContent>();
		for (Long id : ids) {
			cmsContents.add(application.getCmsContent(id));
		}
		application.removeCmsContents(cmsContents);
		return InvokeResult.success();
	}
	
	public List<CmsContentDTO> findAllCmsContent() {
		return CmsContentAssembler.toDTOs(application.findAllCmsContent());
	}
	
	public Page<CmsContentInfoDTO> pageQueryCmsContent(CmsContentDTO queryVo, int currentPage, int pageSize) {
	   	List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("SELECT NEW org.pro.ygcms.facade.dto.CmsContentInfoDTO( ");
	   	jpql.append(" _cmsContent.id,_cmsContentExt.title,_cmsContent.typeId,_cmsContentType.typename ");
	   	jpql.append(" ,_cmsContentExt.author,_cmsContent.viewsDay,_cmsContentExt.releaseDate,_cmsContent.status ) ");
	   	jpql.append(" FROM CmsContent _cmsContent,CmsContentExt _cmsContentExt,CmsChannel _cmsChannel,CmsChannel _parent ");
	   	jpql.append(" ,CmsContentType _cmsContentType ");
	   	jpql.append(" where 1=1 ");
	   	jpql.append(" AND _cmsContent.isDelete=0 ");
	   	jpql.append(" AND _cmsContent.id=_cmsContentExt.contentId ");
	   	jpql.append(" AND _cmsContent.channelId=_cmsChannel.id ");
	   	jpql.append(" AND _cmsContent.typeId=_cmsContentType.id ");
	   	if (queryVo.getChannelId() != null) {
	   		jpql.append(" and _cmsChannel.lft between _parent.lft and _parent.rgt ");
	   		jpql.append(" and _cmsChannel.siteId=_parent.siteId ");
	   		jpql.append(" and _parent.id=? ");
	   		conditionVals.add(queryVo.getChannelId());
	   	}	
	   	if (queryVo.getUserId() != null) {
	   		jpql.append(" and _cmsContent.userId=?");
	   		conditionVals.add(queryVo.getUserId());
	   	}	
	   	if (queryVo.getTypeId() != null) {
	   		jpql.append(" and _cmsContent.typeId=?");
	   		conditionVals.add(queryVo.getTypeId());
	   	}	
	   	if (queryVo.getModelId() != null) {
	   		jpql.append(" and _cmsContent.modelId=?");
	   		conditionVals.add(queryVo.getModelId());
	   	}	
	   	if (queryVo.getSiteId() != null) {
	   		jpql.append(" and _cmsContent.siteId=?");
	   		conditionVals.add(queryVo.getSiteId());
	   	}	
	   	if (queryVo.getTopLevel() != null) {
	   		jpql.append(" and _cmsContent.topLevel=?");
	   		conditionVals.add(queryVo.getTopLevel());
	   	}	
	   	if (queryVo.getHasTitleImg() != null) {
		   	jpql.append(" and _cmsContent.hasTitleImg is ?");
		   	conditionVals.add(queryVo.getHasTitleImg());
	   	}	
	   	if (queryVo.getIsRecommend() != null) {
		   	jpql.append(" and _cmsContent.isRecommend is ?");
		   	conditionVals.add(queryVo.getIsRecommend());
	   	}	
	   	if (queryVo.getStatus() != null) {
	   		jpql.append(" and _cmsContent.status=?");
	   		conditionVals.add(queryVo.getStatus());
	   	}	
	   	if (queryVo.getViewsDay() != null) {
	   		jpql.append(" and _cmsContent.viewsDay=?");
	   		conditionVals.add(queryVo.getViewsDay());
	   	}	
	   	if (queryVo.getCommentsDay() != null) {
	   		jpql.append(" and _cmsContent.commentsDay=?");
	   		conditionVals.add(queryVo.getCommentsDay());
	   	}	
	   	if (queryVo.getDownloadsDay() != null) {
	   		jpql.append(" and _cmsContent.downloadsDay=?");
	   		conditionVals.add(queryVo.getDownloadsDay());
	   	}	
	   	if (queryVo.getUpsDay() != null) {
	   		jpql.append(" and _cmsContent.upsDay=?");
	   		conditionVals.add(queryVo.getUpsDay());
	   	}	
	   	if (queryVo.getScore() != null) {
	   		jpql.append(" and _cmsContent.score=?");
	   		conditionVals.add(queryVo.getScore());
	   	}	
	   	
        @SuppressWarnings("unchecked")
		Page<CmsContentInfoDTO> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
        return new Page<CmsContentInfoDTO>(pages.getStart(), pages.getResultCount(),pageSize, pages.getData());
	}
	
	
}
