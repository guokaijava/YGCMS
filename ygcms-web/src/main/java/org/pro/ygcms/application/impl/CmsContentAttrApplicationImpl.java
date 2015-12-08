package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentAttrApplication;
import org.pro.ygcms.core.domain.content.CmsContentAttr;

@Named
@Transactional
public class CmsContentAttrApplicationImpl implements CmsContentAttrApplication {

	public CmsContentAttr getCmsContentAttr(Long id) {
		return CmsContentAttr.get(CmsContentAttr.class, id);
	}
	
	public void creatCmsContentAttr(CmsContentAttr cmsContentAttr) {
		cmsContentAttr.save();
	}
	
	public void updateCmsContentAttr(CmsContentAttr cmsContentAttr) {
		cmsContentAttr .save();
	}
	
	public void removeCmsContentAttr(CmsContentAttr cmsContentAttr) {
		if(cmsContentAttr != null){
			cmsContentAttr.remove();
		}
	}
	
	public void removeCmsContentAttrs(Set<CmsContentAttr> cmsContentAttrs) {
		for (CmsContentAttr cmsContentAttr : cmsContentAttrs) {
			cmsContentAttr.remove();
		}
	}
	
	public List<CmsContentAttr> findAllCmsContentAttr() {
		return CmsContentAttr.findAll(CmsContentAttr.class);
	}
	
}
