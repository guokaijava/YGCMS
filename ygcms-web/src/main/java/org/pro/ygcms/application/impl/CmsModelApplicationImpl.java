package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsModelApplication;
import org.pro.ygcms.core.domain.model.CmsModel;

@Named
@Transactional
public class CmsModelApplicationImpl implements CmsModelApplication {

	public CmsModel getCmsModel(Long id) {
		return CmsModel.get(CmsModel.class, id);
	}
	
	public void creatCmsModel(CmsModel cmsModel) {
		cmsModel.save();
	}
	
	public void updateCmsModel(CmsModel cmsModel) {
		cmsModel .save();
	}
	
	public void removeCmsModel(CmsModel cmsModel) {
		if(cmsModel != null){
			cmsModel.remove();
		}
	}
	
	public void removeCmsModels(Set<CmsModel> cmsModels) {
		for (CmsModel cmsModel : cmsModels) {
			cmsModel.remove();
		}
	}
	
	public List<CmsModel> findAllCmsModel() {
		return CmsModel.findAll(CmsModel.class);
	}
	
}
