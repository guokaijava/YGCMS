package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentExtFacade {

	public InvokeResult getCmsContentExt(String id);
	
	public String creatCmsContentExt(CmsContentExtDTO cmsContentExt);
	
	public InvokeResult updateCmsContentExt(CmsContentExtDTO cmsContentExt);
	
	public InvokeResult removeCmsContentExt(String id);
	
	public InvokeResult removeCmsContentExts(String[] ids);
	
	public List<CmsContentExtDTO> findAllCmsContentExt();
	
	public Page<CmsContentExtDTO> pageQueryCmsContentExt(CmsContentExtDTO cmsContentExt, int currentPage, int pageSize);
	
	public CmsContentExtDTO getCmsContentExtByCId(String contentId);
	

}

