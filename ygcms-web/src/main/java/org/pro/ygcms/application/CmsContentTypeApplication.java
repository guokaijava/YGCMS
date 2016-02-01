package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentType;

public interface CmsContentTypeApplication {

	public CmsContentType getCmsContentType(String id);
	
	public void creatCmsContentType(CmsContentType cmsContentType);
	
	public void updateCmsContentType(CmsContentType cmsContentType);
	
	public void removeCmsContentType(CmsContentType cmsContentType);
	
	public void removeCmsContentTypes(Set<CmsContentType> cmsContentTypes);
	
	public List<CmsContentType> findAllCmsContentType();
	
}

