package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentAttrFacade {

	public InvokeResult getCmsContentAttr(String id);
	
	public InvokeResult creatCmsContentAttr(CmsContentAttrDTO cmsContentAttr);
	
	public InvokeResult updateCmsContentAttr(CmsContentAttrDTO cmsContentAttr);
	
	public InvokeResult removeCmsContentAttr(String id);
	
	public InvokeResult removeCmsContentAttrs(String[] ids);
	
	public List<CmsContentAttrDTO> findAllCmsContentAttr();
	
	public Page<CmsContentAttrDTO> pageQueryCmsContentAttr(CmsContentAttrDTO cmsContentAttr, int currentPage, int pageSize);
	
	public List<CmsContentAttrDTO> getCmsContentAttrByCId(String contentId);
	

}

