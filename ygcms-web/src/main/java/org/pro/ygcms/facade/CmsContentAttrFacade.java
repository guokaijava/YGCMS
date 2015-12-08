package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentAttrFacade {

	public InvokeResult getCmsContentAttr(Long id);
	
	public InvokeResult creatCmsContentAttr(CmsContentAttrDTO cmsContentAttr);
	
	public InvokeResult updateCmsContentAttr(CmsContentAttrDTO cmsContentAttr);
	
	public InvokeResult removeCmsContentAttr(Long id);
	
	public InvokeResult removeCmsContentAttrs(Long[] ids);
	
	public List<CmsContentAttrDTO> findAllCmsContentAttr();
	
	public Page<CmsContentAttrDTO> pageQueryCmsContentAttr(CmsContentAttrDTO cmsContentAttr, int currentPage, int pageSize);
	

}

