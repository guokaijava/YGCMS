package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentPictureApplication;
import org.pro.ygcms.core.domain.content.CmsContentPicture;

@Named
@Transactional
public class CmsContentPictureApplicationImpl implements CmsContentPictureApplication {

	public CmsContentPicture getCmsContentPicture(Long id) {
		return CmsContentPicture.get(CmsContentPicture.class, id);
	}
	
	public void creatCmsContentPicture(CmsContentPicture cmsContentPicture) {
		cmsContentPicture.save();
	}
	
	public void updateCmsContentPicture(CmsContentPicture cmsContentPicture) {
		cmsContentPicture .save();
	}
	
	public void removeCmsContentPicture(CmsContentPicture cmsContentPicture) {
		if(cmsContentPicture != null){
			cmsContentPicture.remove();
		}
	}
	
	public void removeCmsContentPictures(Set<CmsContentPicture> cmsContentPictures) {
		for (CmsContentPicture cmsContentPicture : cmsContentPictures) {
			cmsContentPicture.remove();
		}
	}
	
	public List<CmsContentPicture> findAllCmsContentPicture() {
		return CmsContentPicture.findAll(CmsContentPicture.class);
	}
	
}
