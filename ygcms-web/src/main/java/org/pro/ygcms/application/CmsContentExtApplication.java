package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentExt;

public interface CmsContentExtApplication {

	public CmsContentExt getCmsContentExt(Long id);
	
	public void creatCmsContentExt(CmsContentExt cmsContentExt);
	
	public void updateCmsContentExt(CmsContentExt cmsContentExt);
	
	public void removeCmsContentExt(CmsContentExt cmsContentExt);
	
	public void removeCmsContentExts(Set<CmsContentExt> cmsContentExts);
	
	public List<CmsContentExt> findAllCmsContentExt();
	
}

