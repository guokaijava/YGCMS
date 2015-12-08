package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsConfigAttrApplication;
import org.pro.ygcms.core.domain.config.CmsConfigAttr;

@Named
@Transactional
public class CmsConfigAttrApplicationImpl implements CmsConfigAttrApplication {

	public CmsConfigAttr getCmsConfigAttr(Long id) {
		return CmsConfigAttr.get(CmsConfigAttr.class, id);
	}
	
	public void creatCmsConfigAttr(CmsConfigAttr cmsConfigAttr) {
		cmsConfigAttr.save();
	}
	
	public void updateCmsConfigAttr(CmsConfigAttr cmsConfigAttr) {
		cmsConfigAttr .save();
	}
	
	public void removeCmsConfigAttr(CmsConfigAttr cmsConfigAttr) {
		if(cmsConfigAttr != null){
			cmsConfigAttr.remove();
		}
	}
	
	public void removeCmsConfigAttrs(Set<CmsConfigAttr> cmsConfigAttrs) {
		for (CmsConfigAttr cmsConfigAttr : cmsConfigAttrs) {
			cmsConfigAttr.remove();
		}
	}
	
	public List<CmsConfigAttr> findAllCmsConfigAttr() {
		return CmsConfigAttr.findAll(CmsConfigAttr.class);
	}
	
}
