package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsCommentExtFacade {

	public InvokeResult getCmsCommentExt(Long id);
	
	public InvokeResult creatCmsCommentExt(CmsCommentExtDTO cmsCommentExt);
	
	public InvokeResult updateCmsCommentExt(CmsCommentExtDTO cmsCommentExt);
	
	public InvokeResult removeCmsCommentExt(Long id);
	
	public InvokeResult removeCmsCommentExts(Long[] ids);
	
	public List<CmsCommentExtDTO> findAllCmsCommentExt();
	
	public Page<CmsCommentExtDTO> pageQueryCmsCommentExt(CmsCommentExtDTO cmsCommentExt, int currentPage, int pageSize);
	

}

