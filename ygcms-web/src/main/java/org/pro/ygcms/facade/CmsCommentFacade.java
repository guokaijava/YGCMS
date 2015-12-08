package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsCommentFacade {

	public InvokeResult getCmsComment(Long id);
	
	public InvokeResult creatCmsComment(CmsCommentDTO cmsComment);
	
	public InvokeResult updateCmsComment(CmsCommentDTO cmsComment);
	
	public InvokeResult removeCmsComment(Long id);
	
	public InvokeResult removeCmsComments(Long[] ids);
	
	public List<CmsCommentDTO> findAllCmsComment();
	
	public Page<CmsCommentDTO> pageQueryCmsComment(CmsCommentDTO cmsComment, int currentPage, int pageSize);
	

}

