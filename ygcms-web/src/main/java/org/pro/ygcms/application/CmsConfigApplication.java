package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.config.CmsConfig;

public interface CmsConfigApplication {

	public CmsConfig getCmsConfig(Long id);
	
	public void creatCmsConfig(CmsConfig cmsConfig);
	
	public void updateCmsConfig(CmsConfig cmsConfig);
	
	public void removeCmsConfig(CmsConfig cmsConfig);
	
	public void removeCmsConfigs(Set<CmsConfig> cmsConfigs);
	
	public List<CmsConfig> findAllCmsConfig();
	
}

