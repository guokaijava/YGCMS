package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsModelItemApplication;
import org.pro.ygcms.core.domain.model.CmsModelItem;

@Named
@Transactional
public class CmsModelItemApplicationImpl implements CmsModelItemApplication {

	public CmsModelItem getCmsModelItem(String id) {
		return CmsModelItem.get(CmsModelItem.class, id);
	}
	
	public void creatCmsModelItem(CmsModelItem cmsModelItem) {
		cmsModelItem.save();
	}
	
	public void updateCmsModelItem(CmsModelItem cmsModelItem) {
		cmsModelItem .save();
	}
	
	public void removeCmsModelItem(CmsModelItem cmsModelItem) {
		if(cmsModelItem != null){
			cmsModelItem.remove();
		}
	}
	
	public void removeCmsModelItems(Set<CmsModelItem> cmsModelItems) {
		for (CmsModelItem cmsModelItem : cmsModelItems) {
			cmsModelItem.remove();
		}
	}
	
	public List<CmsModelItem> findAllCmsModelItem() {
		return CmsModelItem.findAll(CmsModelItem.class);
	}
	
}
