package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsCommentApplication;
import org.pro.ygcms.core.domain.comment.CmsComment;

@Named
@Transactional
public class CmsCommentApplicationImpl implements CmsCommentApplication {

	public CmsComment getCmsComment(Long id) {
		return CmsComment.get(CmsComment.class, id);
	}
	
	public void creatCmsComment(CmsComment cmsComment) {
		cmsComment.save();
	}
	
	public void updateCmsComment(CmsComment cmsComment) {
		cmsComment .save();
	}
	
	public void removeCmsComment(CmsComment cmsComment) {
		if(cmsComment != null){
			cmsComment.remove();
		}
	}
	
	public void removeCmsComments(Set<CmsComment> cmsComments) {
		for (CmsComment cmsComment : cmsComments) {
			cmsComment.remove();
		}
	}
	
	public List<CmsComment> findAllCmsComment() {
		return CmsComment.findAll(CmsComment.class);
	}
	
}
