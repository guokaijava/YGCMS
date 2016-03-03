package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentExtFacade {

	public InvokeResult getCmsContentExt(Long id);
	
	public String creatCmsContentExt(CmsContentExtDTO cmsContentExt);
	
	public InvokeResult updateCmsContentExt(CmsContentExtDTO cmsContentExt);
	
	public InvokeResult removeCmsContentExt(Long id);
	
	public InvokeResult removeCmsContentExts(Long[] ids);
	
	public List<CmsContentExtDTO> findAllCmsContentExt();
	
	public Page<CmsContentExtDTO> pageQueryCmsContentExt(CmsContentExtDTO cmsContentExt, int currentPage, int pageSize);
	

}

