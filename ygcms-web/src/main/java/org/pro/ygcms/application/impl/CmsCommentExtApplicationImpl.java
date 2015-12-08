package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsCommentExtApplication;
import org.pro.ygcms.core.domain.comment.CmsCommentExt;

@Named
@Transactional
public class CmsCommentExtApplicationImpl implements CmsCommentExtApplication {

	public CmsCommentExt getCmsCommentExt(Long id) {
		return CmsCommentExt.get(CmsCommentExt.class, id);
	}
	
	public void creatCmsCommentExt(CmsCommentExt cmsCommentExt) {
		cmsCommentExt.save();
	}
	
	public void updateCmsCommentExt(CmsCommentExt cmsCommentExt) {
		cmsCommentExt .save();
	}
	
	public void removeCmsCommentExt(CmsCommentExt cmsCommentExt) {
		if(cmsCommentExt != null){
			cmsCommentExt.remove();
		}
	}
	
	public void removeCmsCommentExts(Set<CmsCommentExt> cmsCommentExts) {
		for (CmsCommentExt cmsCommentExt : cmsCommentExts) {
			cmsCommentExt.remove();
		}
	}
	
	public List<CmsCommentExt> findAllCmsCommentExt() {
		return CmsCommentExt.findAll(CmsCommentExt.class);
	}
	
}
