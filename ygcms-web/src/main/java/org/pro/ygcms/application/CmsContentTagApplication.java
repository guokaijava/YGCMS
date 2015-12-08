package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentTag;

public interface CmsContentTagApplication {

	public CmsContentTag getCmsContentTag(Long id);
	
	public void creatCmsContentTag(CmsContentTag cmsContentTag);
	
	public void updateCmsContentTag(CmsContentTag cmsContentTag);
	
	public void removeCmsContentTag(CmsContentTag cmsContentTag);
	
	public void removeCmsContentTags(Set<CmsContentTag> cmsContentTags);
	
	public List<CmsContentTag> findAllCmsContentTag();
	
}

