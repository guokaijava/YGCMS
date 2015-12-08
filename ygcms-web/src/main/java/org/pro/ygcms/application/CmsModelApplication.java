package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.model.CmsModel;

public interface CmsModelApplication {

	public CmsModel getCmsModel(Long id);
	
	public void creatCmsModel(CmsModel cmsModel);
	
	public void updateCmsModel(CmsModel cmsModel);
	
	public void removeCmsModel(CmsModel cmsModel);
	
	public void removeCmsModels(Set<CmsModel> cmsModels);
	
	public List<CmsModel> findAllCmsModel();
	
}

