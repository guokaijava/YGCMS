package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentAttr;

public interface CmsContentAttrApplication {

	public CmsContentAttr getCmsContentAttr(String id);
	
	public void creatCmsContentAttr(CmsContentAttr cmsContentAttr);
	
	public void updateCmsContentAttr(CmsContentAttr cmsContentAttr);
	
	public void removeCmsContentAttr(CmsContentAttr cmsContentAttr);
	
	public void removeCmsContentAttrs(Set<CmsContentAttr> cmsContentAttrs);
	
	public List<CmsContentAttr> findAllCmsContentAttr();
	
	public List<CmsContentAttr> findAllCmsContentAttrByCId(String contentId);
	
}

