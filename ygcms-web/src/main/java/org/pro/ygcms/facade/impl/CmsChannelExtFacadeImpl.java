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
import org.pro.ygcms.facade.impl.assembler.CmsChannelExtAssembler;
import org.pro.ygcms.facade.CmsChannelExtFacade;
import org.pro.ygcms.application.CmsChannelExtApplication;

import org.pro.ygcms.core.domain.channel.*;

@Named
public class CmsChannelExtFacadeImpl implements CmsChannelExtFacade {

	@Inject
	private CmsChannelExtApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsChannelExt(Long id) {
		return InvokeResult.success(CmsChannelExtAssembler.toDTO(application.getCmsChannelExt(id)));
	}
	
	public InvokeResult creatCmsChannelExt(CmsChannelExtDTO cmsChannelExtDTO) {
		application.creatCmsChannelExt(CmsChannelExtAssembler.toEntity(cmsChannelExtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsChannelExt(CmsChannelExtDTO cmsChannelExtDTO) {
		application.updateCmsChannelExt(CmsChannelExtAssembler.toEntity(cmsChannelExtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannelExt(Long id) {
		application.removeCmsChannelExt(application.getCmsChannelExt(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannelExts(Long[] ids) {
		Set<CmsChannelExt> cmsChannelExts= new HashSet<CmsChannelExt>();
		for (Long id : ids) {
			cmsChannelExts.add(application.getCmsChannelExt(id));
		}
		application.removeCmsChannelExts(cmsChannelExts);
		return InvokeResult.success();
	}
	
	public List<CmsChannelExtDTO> findAllCmsChannelExt() {
		return CmsChannelExtAssembler.toDTOs(application.findAllCmsChannelExt());
	}
	
	public Page<CmsChannelExtDTO> pageQueryCmsChannelExt(CmsChannelExtDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsChannelExt from CmsChannelExt _cmsChannelExt   where 1=1 ");
	   	if (queryVo.getChannelId() != null) {
	   		jpql.append(" and _cmsChannelExt.channelId=?");
	   		conditionVals.add(queryVo.getChannelId());
	   	}	
	   	if (queryVo.getChannelName() != null && !"".equals(queryVo.getChannelName())) {
	   		jpql.append(" and _cmsChannelExt.channelName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getChannelName()));
	   	}		
	   	if (queryVo.getFinalStep() != null) {
	   		jpql.append(" and _cmsChannelExt.finalStep=?");
	   		conditionVals.add(queryVo.getFinalStep());
	   	}	
	   	if (queryVo.getAfterCheck() != null) {
	   		jpql.append(" and _cmsChannelExt.afterCheck=?");
	   		conditionVals.add(queryVo.getAfterCheck());
	   	}	
	   	if (queryVo.getIsStaticChannel() != null && !"".equals(queryVo.getIsStaticChannel())) {
	   		jpql.append(" and _cmsChannelExt.isStaticChannel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsStaticChannel()));
	   	}		
	   	if (queryVo.getIsStaticContent() != null && !"".equals(queryVo.getIsStaticContent())) {
	   		jpql.append(" and _cmsChannelExt.isStaticContent like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsStaticContent()));
	   	}		
	   	if (queryVo.getIsAccessByDir() != null && !"".equals(queryVo.getIsAccessByDir())) {
	   		jpql.append(" and _cmsChannelExt.isAccessByDir like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsAccessByDir()));
	   	}		
	   	if (queryVo.getIsListChild() != null && !"".equals(queryVo.getIsListChild())) {
	   		jpql.append(" and _cmsChannelExt.isListChild like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsListChild()));
	   	}		
	   	if (queryVo.getPageSize() != null) {
	   		jpql.append(" and _cmsChannelExt.pageSize=?");
	   		conditionVals.add(queryVo.getPageSize());
	   	}	
	   	if (queryVo.getChannelRule() != null && !"".equals(queryVo.getChannelRule())) {
	   		jpql.append(" and _cmsChannelExt.channelRule like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getChannelRule()));
	   	}		
	   	if (queryVo.getContentRule() != null && !"".equals(queryVo.getContentRule())) {
	   		jpql.append(" and _cmsChannelExt.contentRule like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getContentRule()));
	   	}		
	   	if (queryVo.getLink() != null && !"".equals(queryVo.getLink())) {
	   		jpql.append(" and _cmsChannelExt.link like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLink()));
	   	}		
	   	if (queryVo.getTplChannel() != null && !"".equals(queryVo.getTplChannel())) {
	   		jpql.append(" and _cmsChannelExt.tplChannel like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTplChannel()));
	   	}		
	   	if (queryVo.getTplContent() != null && !"".equals(queryVo.getTplContent())) {
	   		jpql.append(" and _cmsChannelExt.tplContent like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTplContent()));
	   	}		
	   	if (queryVo.getTitleImg() != null && !"".equals(queryVo.getTitleImg())) {
	   		jpql.append(" and _cmsChannelExt.titleImg like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTitleImg()));
	   	}		
	   	if (queryVo.getContentImg() != null && !"".equals(queryVo.getContentImg())) {
	   		jpql.append(" and _cmsChannelExt.contentImg like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getContentImg()));
	   	}		
	   	if (queryVo.getHasTitleImg() != null) {
		   	jpql.append(" and _cmsChannelExt.hasTitleImg is ?");
		   	conditionVals.add(queryVo.getHasTitleImg());
	   	}	
	   	if (queryVo.getHasContentImg() != null) {
		   	jpql.append(" and _cmsChannelExt.hasContentImg is ?");
		   	conditionVals.add(queryVo.getHasContentImg());
	   	}	
	   	if (queryVo.getTitleImgWidth() != null) {
	   		jpql.append(" and _cmsChannelExt.titleImgWidth=?");
	   		conditionVals.add(queryVo.getTitleImgWidth());
	   	}	
	   	if (queryVo.getTitleImgHeight() != null) {
	   		jpql.append(" and _cmsChannelExt.titleImgHeight=?");
	   		conditionVals.add(queryVo.getTitleImgHeight());
	   	}	
	   	if (queryVo.getContentImgWidth() != null) {
	   		jpql.append(" and _cmsChannelExt.contentImgWidth=?");
	   		conditionVals.add(queryVo.getContentImgWidth());
	   	}	
	   	if (queryVo.getContentImgHeight() != null) {
	   		jpql.append(" and _cmsChannelExt.contentImgHeight=?");
	   		conditionVals.add(queryVo.getContentImgHeight());
	   	}	
	   	if (queryVo.getCommentControl() != null) {
	   		jpql.append(" and _cmsChannelExt.commentControl=?");
	   		conditionVals.add(queryVo.getCommentControl());
	   	}	
	   	if (queryVo.getAllowUpdown() != null) {
		   	jpql.append(" and _cmsChannelExt.allowUpdown is ?");
		   	conditionVals.add(queryVo.getAllowUpdown());
	   	}	
	   	if (queryVo.getIsBlank() != null) {
		   	jpql.append(" and _cmsChannelExt.isBlank is ?");
		   	conditionVals.add(queryVo.getIsBlank());
	   	}	
	   	if (queryVo.getTitle() != null && !"".equals(queryVo.getTitle())) {
	   		jpql.append(" and _cmsChannelExt.title like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTitle()));
	   	}		
	   	if (queryVo.getKeywords() != null && !"".equals(queryVo.getKeywords())) {
	   		jpql.append(" and _cmsChannelExt.keywords like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getKeywords()));
	   	}		
	   	if (queryVo.getDescription() != null && !"".equals(queryVo.getDescription())) {
	   		jpql.append(" and _cmsChannelExt.description like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDescription()));
	   	}		
	   	if (queryVo.getAllowShare() != null) {
		   	jpql.append(" and _cmsChannelExt.allowShare is ?");
		   	conditionVals.add(queryVo.getAllowShare());
	   	}	
	   	if (queryVo.getAllowScore() != null) {
		   	jpql.append(" and _cmsChannelExt.allowScore is ?");
		   	conditionVals.add(queryVo.getAllowScore());
	   	}	
        Page<CmsChannelExt> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsChannelExtDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsChannelExtAssembler.toDTOs(pages.getData()));
	}
	
	
}
