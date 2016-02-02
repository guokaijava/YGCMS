package org.pro.ygcms.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;

import org.pro.ygcms.application.CmsModelItemApplication;
import org.pro.ygcms.core.domain.model.CmsModelItem;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public List<CmsModelItem> findCmsModelItemByModelId(String id,int ischannel) {
		Map<String,Object> map = new HashMap<String,Object>();
	    map.put("modelid", id);
	    map.put("ischannel", ischannel);
		return CmsModelItem.findByProperties(CmsModelItem.class, map);
	}
	
}
