package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentTagApplication;
import org.pro.ygcms.core.domain.content.CmsContentTag;

@Named
@Transactional
public class CmsContentTagApplicationImpl implements CmsContentTagApplication {

	public CmsContentTag getCmsContentTag(Long id) {
		return CmsContentTag.get(CmsContentTag.class, id);
	}
	
	public void creatCmsContentTag(CmsContentTag cmsContentTag) {
		cmsContentTag.save();
	}
	
	public void updateCmsContentTag(CmsContentTag cmsContentTag) {
		cmsContentTag .save();
	}
	
	public void removeCmsContentTag(CmsContentTag cmsContentTag) {
		if(cmsContentTag != null){
			cmsContentTag.remove();
		}
	}
	
	public void removeCmsContentTags(Set<CmsContentTag> cmsContentTags) {
		for (CmsContentTag cmsContentTag : cmsContentTags) {
			cmsContentTag.remove();
		}
	}
	
	public List<CmsContentTag> findAllCmsContentTag() {
		return CmsContentTag.findAll(CmsContentTag.class);
	}
	
}
