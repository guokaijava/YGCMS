package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentTypeApplication;
import org.pro.ygcms.core.domain.content.CmsContentType;

@Named
@Transactional
public class CmsContentTypeApplicationImpl implements CmsContentTypeApplication {

	public CmsContentType getCmsContentType(String id) {
		return CmsContentType.get(CmsContentType.class, id);
	}
	
	public void creatCmsContentType(CmsContentType cmsContentType) {
		cmsContentType.save();
	}
	
	public void updateCmsContentType(CmsContentType cmsContentType) {
		cmsContentType .save();
	}
	
	public void removeCmsContentType(CmsContentType cmsContentType) {
		if(cmsContentType != null){
			cmsContentType.remove();
		}
	}
	
	public void removeCmsContentTypes(Set<CmsContentType> cmsContentTypes) {
		for (CmsContentType cmsContentType : cmsContentTypes) {
			cmsContentType.remove();
		}
	}
	
	public List<CmsContentType> findAllCmsContentType() {
		return CmsContentType.findAll(CmsContentType.class);
	}
	
}
