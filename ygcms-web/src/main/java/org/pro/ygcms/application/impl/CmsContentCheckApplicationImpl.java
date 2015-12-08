package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentCheckApplication;
import org.pro.ygcms.core.domain.content.CmsContentCheck;

@Named
@Transactional
public class CmsContentCheckApplicationImpl implements CmsContentCheckApplication {

	public CmsContentCheck getCmsContentCheck(Long id) {
		return CmsContentCheck.get(CmsContentCheck.class, id);
	}
	
	public void creatCmsContentCheck(CmsContentCheck cmsContentCheck) {
		cmsContentCheck.save();
	}
	
	public void updateCmsContentCheck(CmsContentCheck cmsContentCheck) {
		cmsContentCheck .save();
	}
	
	public void removeCmsContentCheck(CmsContentCheck cmsContentCheck) {
		if(cmsContentCheck != null){
			cmsContentCheck.remove();
		}
	}
	
	public void removeCmsContentChecks(Set<CmsContentCheck> cmsContentChecks) {
		for (CmsContentCheck cmsContentCheck : cmsContentChecks) {
			cmsContentCheck.remove();
		}
	}
	
	public List<CmsContentCheck> findAllCmsContentCheck() {
		return CmsContentCheck.findAll(CmsContentCheck.class);
	}
	
}
