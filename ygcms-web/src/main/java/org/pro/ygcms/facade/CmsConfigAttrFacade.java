package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsConfigAttrFacade {

	public InvokeResult getCmsConfigAttr(Long id);
	
	public InvokeResult creatCmsConfigAttr(CmsConfigAttrDTO cmsConfigAttr);
	
	public InvokeResult updateCmsConfigAttr(CmsConfigAttrDTO cmsConfigAttr);
	
	public InvokeResult removeCmsConfigAttr(Long id);
	
	public InvokeResult removeCmsConfigAttrs(Long[] ids);
	
	public List<CmsConfigAttrDTO> findAllCmsConfigAttr();
	
	public Page<CmsConfigAttrDTO> pageQueryCmsConfigAttr(CmsConfigAttrDTO cmsConfigAttr, int currentPage, int pageSize);
	

}

