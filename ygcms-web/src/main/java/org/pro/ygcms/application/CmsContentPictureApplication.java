package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentPicture;

public interface CmsContentPictureApplication {

	public CmsContentPicture getCmsContentPicture(Long id);
	
	public void creatCmsContentPicture(CmsContentPicture cmsContentPicture);
	
	public void updateCmsContentPicture(CmsContentPicture cmsContentPicture);
	
	public void removeCmsContentPicture(CmsContentPicture cmsContentPicture);
	
	public void removeCmsContentPictures(Set<CmsContentPicture> cmsContentPictures);
	
	public List<CmsContentPicture> findAllCmsContentPicture();
	
}

