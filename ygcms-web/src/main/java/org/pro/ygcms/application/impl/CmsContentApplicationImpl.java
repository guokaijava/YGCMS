package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentApplication;
import org.pro.ygcms.core.domain.content.CmsContent;

@Named
@Transactional
public class CmsContentApplicationImpl implements CmsContentApplication {

	public CmsContent getCmsContent(Long id) {
		return CmsContent.get(CmsContent.class, id);
	}
	
	public void creatCmsContent(CmsContent cmsContent) {
		cmsContent.save();
	}
	
	public void updateCmsContent(CmsContent cmsContent) {
		cmsContent .save();
	}
	
	public void removeCmsContent(CmsContent cmsContent) {
		if(cmsContent != null){
			cmsContent.remove();
		}
	}
	
	public void removeCmsContents(Set<CmsContent> cmsContents) {
		for (CmsContent cmsContent : cmsContents) {
			cmsContent.remove();
		}
	}
	
	public List<CmsContent> findAllCmsContent() {
		return CmsContent.findAll(CmsContent.class);
	}
	
}
