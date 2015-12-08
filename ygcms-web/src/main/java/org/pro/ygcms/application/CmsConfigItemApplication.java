package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.config.CmsConfigItem;

public interface CmsConfigItemApplication {

	public CmsConfigItem getCmsConfigItem(Long id);
	
	public void creatCmsConfigItem(CmsConfigItem cmsConfigItem);
	
	public void updateCmsConfigItem(CmsConfigItem cmsConfigItem);
	
	public void removeCmsConfigItem(CmsConfigItem cmsConfigItem);
	
	public void removeCmsConfigItems(Set<CmsConfigItem> cmsConfigItems);
	
	public List<CmsConfigItem> findAllCmsConfigItem();
	
}

