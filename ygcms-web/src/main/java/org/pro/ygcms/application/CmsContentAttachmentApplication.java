package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;

import  org.pro.ygcms.core.domain.content.CmsContentAttachment;

public interface CmsContentAttachmentApplication {

	public CmsContentAttachment getCmsContentAttachment(String id);
	
	public void creatCmsContentAttachment(CmsContentAttachment cmsContentAttachment);
	
	public void updateCmsContentAttachment(CmsContentAttachment cmsContentAttachment);
	
	public void removeCmsContentAttachment(CmsContentAttachment cmsContentAttachment);
	
	public void removeCmsContentAttachments(Set<CmsContentAttachment> cmsContentAttachments);
	
	public List<CmsContentAttachment> findAllCmsContentAttachment();

	public List<CmsContentAttachment> getCmsContentAttachmentByCid(String id);
	
}

