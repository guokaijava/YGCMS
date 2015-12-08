package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsConfigApplication;
import org.pro.ygcms.core.domain.config.CmsConfig;

@Named
@Transactional
public class CmsConfigApplicationImpl implements CmsConfigApplication {

	public CmsConfig getCmsConfig(Long id) {
		return CmsConfig.get(CmsConfig.class, id);
	}
	
	public void creatCmsConfig(CmsConfig cmsConfig) {
		cmsConfig.save();
	}
	
	public void updateCmsConfig(CmsConfig cmsConfig) {
		cmsConfig .save();
	}
	
	public void removeCmsConfig(CmsConfig cmsConfig) {
		if(cmsConfig != null){
			cmsConfig.remove();
		}
	}
	
	public void removeCmsConfigs(Set<CmsConfig> cmsConfigs) {
		for (CmsConfig cmsConfig : cmsConfigs) {
			cmsConfig.remove();
		}
	}
	
	public List<CmsConfig> findAllCmsConfig() {
		return CmsConfig.findAll(CmsConfig.class);
	}
	
}
