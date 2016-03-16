package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentAttachmentApplication;
import org.pro.ygcms.core.domain.content.CmsContentAttachment;

@Named
@Transactional
public class CmsContentAttachmentApplicationImpl implements CmsContentAttachmentApplication {

	public CmsContentAttachment getCmsContentAttachment(String id) {
		return CmsContentAttachment.get(CmsContentAttachment.class, id);
	}
	
	public void creatCmsContentAttachment(CmsContentAttachment cmsContentAttachment) {
		cmsContentAttachment.save();
	}
	
	public void updateCmsContentAttachment(CmsContentAttachment cmsContentAttachment) {
		cmsContentAttachment .save();
	}
	
	public void removeCmsContentAttachment(CmsContentAttachment cmsContentAttachment) {
		if(cmsContentAttachment != null){
			cmsContentAttachment.remove();
		}
	}
	
	public void removeCmsContentAttachments(Set<CmsContentAttachment> cmsContentAttachments) {
		for (CmsContentAttachment cmsContentAttachment : cmsContentAttachments) {
			cmsContentAttachment.remove();
		}
	}
	
	public List<CmsContentAttachment> findAllCmsContentAttachment() {
		return CmsContentAttachment.findAll(CmsContentAttachment.class);
	}

	@Override
	public List<CmsContentAttachment> getCmsContentAttachmentByCid(String id) {
		return CmsContentAttachment.findByProperty(CmsContentAttachment.class, "contentId", id);
	}
	
}
