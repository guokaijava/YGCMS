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
import org.pro.ygcms.facade.impl.assembler.CmsContentExtAssembler;
import org.pro.ygcms.facade.CmsContentExtFacade;
import org.pro.ygcms.application.CmsContentExtApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentExtFacadeImpl implements CmsContentExtFacade {

	@Inject
	private CmsContentExtApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentExt(Long id) {
		return InvokeResult.success(CmsContentExtAssembler.toDTO(application.getCmsContentExt(id)));
	}
	
	public InvokeResult creatCmsContentExt(CmsContentExtDTO cmsContentExtDTO) {
		application.creatCmsContentExt(CmsContentExtAssembler.toEntity(cmsContentExtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentExt(CmsContentExtDTO cmsContentExtDTO) {
		application.updateCmsContentExt(CmsContentExtAssembler.toEntity(cmsContentExtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentExt(Long id) {
		application.removeCmsContentExt(application.getCmsContentExt(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentExts(Long[] ids) {
		Set<CmsContentExt> cmsContentExts= new HashSet<CmsContentExt>();
		for (Long id : ids) {
			cmsContentExts.add(application.getCmsContentExt(id));
		}
		application.removeCmsContentExts(cmsContentExts);
		return InvokeResult.success();
	}
	
	public List<CmsContentExtDTO> findAllCmsContentExt() {
		return CmsContentExtAssembler.toDTOs(application.findAllCmsContentExt());
	}
	
	public Page<CmsContentExtDTO> pageQueryCmsContentExt(CmsContentExtDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentExt from CmsContentExt _cmsContentExt   where 1=1 ");
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsContentExt.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
	   	if (queryVo.getTitle() != null && !"".equals(queryVo.getTitle())) {
	   		jpql.append(" and _cmsContentExt.title like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTitle()));
	   	}		
	   	if (queryVo.getShortTitle() != null && !"".equals(queryVo.getShortTitle())) {
	   		jpql.append(" and _cmsContentExt.shortTitle like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getShortTitle()));
	   	}		
	   	if (queryVo.getAuthor() != null && !"".equals(queryVo.getAuthor())) {
	   		jpql.append(" and _cmsContentExt.author like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAuthor()));
	   	}		
	   	if (queryVo.getOrigin() != null && !"".equals(queryVo.getOrigin())) {
	   		jpql.append(" and _cmsContentExt.origin like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOrigin()));
	   	}		
	   	if (queryVo.getOriginUrl() != null && !"".equals(queryVo.getOriginUrl())) {
	   		jpql.append(" and _cmsContentExt.originUrl like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getOriginUrl()));
	   	}		
	   	if (queryVo.getDescription() != null && !"".equals(queryVo.getDescription())) {
	   		jpql.append(" and _cmsContentExt.description like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDescription()));
	   	}		
	   	if (queryVo.getMediaPath() != null && !"".equals(queryVo.getMediaPath())) {
	   		jpql.append(" and _cmsContentExt.mediaPath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMediaPath()));
	   	}		
	   	if (queryVo.getMediaType() != null && !"".equals(queryVo.getMediaType())) {
	   		jpql.append(" and _cmsContentExt.mediaType like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMediaType()));
	   	}		
	   	if (queryVo.getTitleColor() != null && !"".equals(queryVo.getTitleColor())) {
	   		jpql.append(" and _cmsContentExt.titleColor like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTitleColor()));
	   	}		
	   	if (queryVo.getIsBold() != null) {
		   	jpql.append(" and _cmsContentExt.isBold is ?");
		   	conditionVals.add(queryVo.getIsBold());
	   	}	
	   	if (queryVo.getTitleImg() != null && !"".equals(queryVo.getTitleImg())) {
	   		jpql.append(" and _cmsContentExt.titleImg like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTitleImg()));
	   	}		
	   	if (queryVo.getContentImg() != null && !"".equals(queryVo.getContentImg())) {
	   		jpql.append(" and _cmsContentExt.contentImg like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getContentImg()));
	   	}		
	   	if (queryVo.getTypeImg() != null && !"".equals(queryVo.getTypeImg())) {
	   		jpql.append(" and _cmsContentExt.typeImg like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTypeImg()));
	   	}		
	   	if (queryVo.getLink() != null && !"".equals(queryVo.getLink())) {
	   		jpql.append(" and _cmsContentExt.link like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLink()));
	   	}		
	   	if (queryVo.getTplContent() != null && !"".equals(queryVo.getTplContent())) {
	   		jpql.append(" and _cmsContentExt.tplContent like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTplContent()));
	   	}		
	   	if (queryVo.getNeedRegenerate() != null) {
		   	jpql.append(" and _cmsContentExt.needRegenerate is ?");
		   	conditionVals.add(queryVo.getNeedRegenerate());
	   	}	
        Page<CmsContentExt> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentExtDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentExtAssembler.toDTOs(pages.getData()));
	}
	
	
}
