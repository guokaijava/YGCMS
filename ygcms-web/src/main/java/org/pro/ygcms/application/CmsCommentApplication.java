package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.comment.CmsComment;

public interface CmsCommentApplication {

	public CmsComment getCmsComment(Long id);
	
	public void creatCmsComment(CmsComment cmsComment);
	
	public void updateCmsComment(CmsComment cmsComment);
	
	public void removeCmsComment(CmsComment cmsComment);
	
	public void removeCmsComments(Set<CmsComment> cmsComments);
	
	public List<CmsComment> findAllCmsComment();
	
}

