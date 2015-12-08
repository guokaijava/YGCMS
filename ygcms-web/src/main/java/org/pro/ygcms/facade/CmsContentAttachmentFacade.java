package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentAttachmentFacade {

	public InvokeResult getCmsContentAttachment(Long id);
	
	public InvokeResult creatCmsContentAttachment(CmsContentAttachmentDTO cmsContentAttachment);
	
	public InvokeResult updateCmsContentAttachment(CmsContentAttachmentDTO cmsContentAttachment);
	
	public InvokeResult removeCmsContentAttachment(Long id);
	
	public InvokeResult removeCmsContentAttachments(Long[] ids);
	
	public List<CmsContentAttachmentDTO> findAllCmsContentAttachment();
	
	public Page<CmsContentAttachmentDTO> pageQueryCmsContentAttachment(CmsContentAttachmentDTO cmsContentAttachment, int currentPage, int pageSize);
	

}

