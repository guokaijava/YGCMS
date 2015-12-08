package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsConfigItemApplication;
import org.pro.ygcms.core.domain.config.CmsConfigItem;

@Named
@Transactional
public class CmsConfigItemApplicationImpl implements CmsConfigItemApplication {

	public CmsConfigItem getCmsConfigItem(Long id) {
		return CmsConfigItem.get(CmsConfigItem.class, id);
	}
	
	public void creatCmsConfigItem(CmsConfigItem cmsConfigItem) {
		cmsConfigItem.save();
	}
	
	public void updateCmsConfigItem(CmsConfigItem cmsConfigItem) {
		cmsConfigItem .save();
	}
	
	public void removeCmsConfigItem(CmsConfigItem cmsConfigItem) {
		if(cmsConfigItem != null){
			cmsConfigItem.remove();
		}
	}
	
	public void removeCmsConfigItems(Set<CmsConfigItem> cmsConfigItems) {
		for (CmsConfigItem cmsConfigItem : cmsConfigItems) {
			cmsConfigItem.remove();
		}
	}
	
	public List<CmsConfigItem> findAllCmsConfigItem() {
		return CmsConfigItem.findAll(CmsConfigItem.class);
	}
	
}
