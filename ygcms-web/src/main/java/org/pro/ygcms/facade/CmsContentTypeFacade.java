package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentTypeFacade {

	public InvokeResult getCmsContentType(String id);
	
	public InvokeResult creatCmsContentType(CmsContentTypeDTO cmsContentType);
	
	public InvokeResult updateCmsContentType(CmsContentTypeDTO cmsContentType);
	
	public InvokeResult removeCmsContentType(String id);
	
	public InvokeResult removeCmsContentTypes(String[] ids);
	
	public List<CmsContentTypeDTO> findAllCmsContentType();
	
	public Page<CmsContentTypeDTO> pageQueryCmsContentType(CmsContentTypeDTO cmsContentType, int currentPage, int pageSize);
	

}

