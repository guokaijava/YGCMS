package org.pro.ygcms.facade.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.QueryChannelService;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.application.CmsContentAttachmentApplication;
import org.pro.ygcms.core.domain.content.CmsContentAttachment;
import org.pro.ygcms.facade.CmsContentAttachmentFacade;
import org.pro.ygcms.facade.dto.CmsContentAttachmentDTO;
import org.pro.ygcms.facade.impl.assembler.CmsContentAttachmentAssembler;

@Named
public class CmsContentAttachmentFacadeImpl implements CmsContentAttachmentFacade {

	@Inject
	private CmsContentAttachmentApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentAttachment(String id) {
		return InvokeResult.success(CmsContentAttachmentAssembler.toDTO(application.getCmsContentAttachment(id)));
	}
	
	public InvokeResult creatCmsContentAttachment(CmsContentAttachmentDTO cmsContentAttachmentDTO) {
		application.creatCmsContentAttachment(CmsContentAttachmentAssembler.toEntity(cmsContentAttachmentDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentAttachment(CmsContentAttachmentDTO cmsContentAttachmentDTO) {
		application.updateCmsContentAttachment(CmsContentAttachmentAssembler.toEntity(cmsContentAttachmentDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentAttachment(String id) {
		application.removeCmsContentAttachment(application.getCmsContentAttachment(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentAttachments(String[] ids) {
		Set<CmsContentAttachment> cmsContentAttachments= new HashSet<CmsContentAttachment>();
		for (String id : ids) {
			cmsContentAttachments.add(application.getCmsContentAttachment(id));
		}
		application.removeCmsContentAttachments(cmsContentAttachments);
		return InvokeResult.success();
	}
	
	public List<CmsContentAttachmentDTO> findAllCmsContentAttachment() {
		return CmsContentAttachmentAssembler.toDTOs(application.findAllCmsContentAttachment());
	}
	
	public Page<CmsContentAttachmentDTO> pageQueryCmsContentAttachment(CmsContentAttachmentDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentAttachment from CmsContentAttachment _cmsContentAttachment   where 1=1 ");
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsContentAttachment.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
	   	if (queryVo.getPriority() != null) {
	   		jpql.append(" and _cmsContentAttachment.priority=?");
	   		conditionVals.add(queryVo.getPriority());
	   	}	
	   	if (queryVo.getAttachmentPath() != null && !"".equals(queryVo.getAttachmentPath())) {
	   		jpql.append(" and _cmsContentAttachment.attachmentPath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttachmentPath()));
	   	}		
	   	if (queryVo.getAttachmentName() != null && !"".equals(queryVo.getAttachmentName())) {
	   		jpql.append(" and _cmsContentAttachment.attachmentName like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getAttachmentName()));
	   	}		
	   	if (queryVo.getFilename() != null && !"".equals(queryVo.getFilename())) {
	   		jpql.append(" and _cmsContentAttachment.filename like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFilename()));
	   	}		
	   	if (queryVo.getDownloadCount() != null) {
	   		jpql.append(" and _cmsContentAttachment.downloadCount=?");
	   		conditionVals.add(queryVo.getDownloadCount());
	   	}	
        Page<CmsContentAttachment> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentAttachmentDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentAttachmentAssembler.toDTOs(pages.getData()));
	}

	@Override
	public List<CmsContentAttachmentDTO> getCmsContentAttachmentByCId(String id) {
		return CmsContentAttachmentAssembler.toDTOs(application.getCmsContentAttachmentByCid(id));
	}
	
	
}
