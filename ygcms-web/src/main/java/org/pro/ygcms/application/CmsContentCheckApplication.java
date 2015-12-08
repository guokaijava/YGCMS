package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentCheck;

public interface CmsContentCheckApplication {

	public CmsContentCheck getCmsContentCheck(Long id);
	
	public void creatCmsContentCheck(CmsContentCheck cmsContentCheck);
	
	public void updateCmsContentCheck(CmsContentCheck cmsContentCheck);
	
	public void removeCmsContentCheck(CmsContentCheck cmsContentCheck);
	
	public void removeCmsContentChecks(Set<CmsContentCheck> cmsContentChecks);
	
	public List<CmsContentCheck> findAllCmsContentCheck();
	
}

