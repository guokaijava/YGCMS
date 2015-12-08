package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.comment.CmsCommentExt;

public interface CmsCommentExtApplication {

	public CmsCommentExt getCmsCommentExt(Long id);
	
	public void creatCmsCommentExt(CmsCommentExt cmsCommentExt);
	
	public void updateCmsCommentExt(CmsCommentExt cmsCommentExt);
	
	public void removeCmsCommentExt(CmsCommentExt cmsCommentExt);
	
	public void removeCmsCommentExts(Set<CmsCommentExt> cmsCommentExts);
	
	public List<CmsCommentExt> findAllCmsCommentExt();
	
}

