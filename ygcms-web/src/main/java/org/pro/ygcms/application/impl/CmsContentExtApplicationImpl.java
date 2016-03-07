package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentExtApplication;
import org.pro.ygcms.core.domain.content.CmsContentExt;

@Named
@Transactional
public class CmsContentExtApplicationImpl implements CmsContentExtApplication {

	public CmsContentExt getCmsContentExt(String id) {
		return CmsContentExt.get(CmsContentExt.class, id);
	}
	
	public void creatCmsContentExt(CmsContentExt cmsContentExt) {
		cmsContentExt.save();
	}
	
	public void updateCmsContentExt(CmsContentExt cmsContentExt) {
		cmsContentExt .save();
	}
	
	public void removeCmsContentExt(CmsContentExt cmsContentExt) {
		if(cmsContentExt != null){
			cmsContentExt.remove();
		}
	}
	
	public void removeCmsContentExts(Set<CmsContentExt> cmsContentExts) {
		for (CmsContentExt cmsContentExt : cmsContentExts) {
			cmsContentExt.remove();
		}
	}
	
	public List<CmsContentExt> findAllCmsContentExt() {
		return CmsContentExt.findAll(CmsContentExt.class);
	}
	
	public CmsContentExt getCmsContentExtByCId(String contentId){
		CmsContentExt cmsContentExt = CmsContentExt.findByProperty(CmsContentExt.class, "contentId", contentId).get(0);
		return cmsContentExt;
	}
	
}
