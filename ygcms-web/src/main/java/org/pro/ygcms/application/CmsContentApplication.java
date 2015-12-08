package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContent;

public interface CmsContentApplication {

	public CmsContent getCmsContent(Long id);
	
	public void creatCmsContent(CmsContent cmsContent);
	
	public void updateCmsContent(CmsContent cmsContent);
	
	public void removeCmsContent(CmsContent cmsContent);
	
	public void removeCmsContents(Set<CmsContent> cmsContents);
	
	public List<CmsContent> findAllCmsContent();
	
}

