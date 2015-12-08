package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentFacade {

	public InvokeResult getCmsContent(Long id);
	
	public InvokeResult creatCmsContent(CmsContentDTO cmsContent);
	
	public InvokeResult updateCmsContent(CmsContentDTO cmsContent);
	
	public InvokeResult removeCmsContent(Long id);
	
	public InvokeResult removeCmsContents(Long[] ids);
	
	public List<CmsContentDTO> findAllCmsContent();
	
	public Page<CmsContentDTO> pageQueryCmsContent(CmsContentDTO cmsContent, int currentPage, int pageSize);
	

}

