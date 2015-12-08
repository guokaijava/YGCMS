package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.config.CmsConfigAttr;

public interface CmsConfigAttrApplication {

	public CmsConfigAttr getCmsConfigAttr(Long id);
	
	public void creatCmsConfigAttr(CmsConfigAttr cmsConfigAttr);
	
	public void updateCmsConfigAttr(CmsConfigAttr cmsConfigAttr);
	
	public void removeCmsConfigAttr(CmsConfigAttr cmsConfigAttr);
	
	public void removeCmsConfigAttrs(Set<CmsConfigAttr> cmsConfigAttrs);
	
	public List<CmsConfigAttr> findAllCmsConfigAttr();
	
}

