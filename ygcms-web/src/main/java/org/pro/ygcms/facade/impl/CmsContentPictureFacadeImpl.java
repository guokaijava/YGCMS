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
import org.pro.ygcms.facade.impl.assembler.CmsContentPictureAssembler;
import org.pro.ygcms.facade.CmsContentPictureFacade;
import org.pro.ygcms.application.CmsContentPictureApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentPictureFacadeImpl implements CmsContentPictureFacade {

	@Inject
	private CmsContentPictureApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentPicture(Long id) {
		return InvokeResult.success(CmsContentPictureAssembler.toDTO(application.getCmsContentPicture(id)));
	}
	
	public InvokeResult creatCmsContentPicture(CmsContentPictureDTO cmsContentPictureDTO) {
		application.creatCmsContentPicture(CmsContentPictureAssembler.toEntity(cmsContentPictureDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentPicture(CmsContentPictureDTO cmsContentPictureDTO) {
		application.updateCmsContentPicture(CmsContentPictureAssembler.toEntity(cmsContentPictureDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentPicture(Long id) {
		application.removeCmsContentPicture(application.getCmsContentPicture(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentPictures(Long[] ids) {
		Set<CmsContentPicture> cmsContentPictures= new HashSet<CmsContentPicture>();
		for (Long id : ids) {
			cmsContentPictures.add(application.getCmsContentPicture(id));
		}
		application.removeCmsContentPictures(cmsContentPictures);
		return InvokeResult.success();
	}
	
	public List<CmsContentPictureDTO> findAllCmsContentPicture() {
		return CmsContentPictureAssembler.toDTOs(application.findAllCmsContentPicture());
	}
	
	public Page<CmsContentPictureDTO> pageQueryCmsContentPicture(CmsContentPictureDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentPicture from CmsContentPicture _cmsContentPicture   where 1=1 ");
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsContentPicture.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
	   	if (queryVo.getPriority() != null) {
	   		jpql.append(" and _cmsContentPicture.priority=?");
	   		conditionVals.add(queryVo.getPriority());
	   	}	
	   	if (queryVo.getImgPath() != null && !"".equals(queryVo.getImgPath())) {
	   		jpql.append(" and _cmsContentPicture.imgPath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getImgPath()));
	   	}		
	   	if (queryVo.getDescription() != null && !"".equals(queryVo.getDescription())) {
	   		jpql.append(" and _cmsContentPicture.description like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDescription()));
	   	}		
        Page<CmsContentPicture> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentPictureDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentPictureAssembler.toDTOs(pages.getData()));
	}
	
	
}
