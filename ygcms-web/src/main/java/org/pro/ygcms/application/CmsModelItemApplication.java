package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.model.CmsModelItem;

public interface CmsModelItemApplication {

	public CmsModelItem getCmsModelItem(Long id);
	
	public void creatCmsModelItem(CmsModelItem cmsModelItem);
	
	public void updateCmsModelItem(CmsModelItem cmsModelItem);
	
	public void removeCmsModelItem(CmsModelItem cmsModelItem);
	
	public void removeCmsModelItems(Set<CmsModelItem> cmsModelItems);
	
	public List<CmsModelItem> findAllCmsModelItem();
	
}

