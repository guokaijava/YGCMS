package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsModelItemFacade {

	public InvokeResult getCmsModelItem(Long id);
	
	public InvokeResult creatCmsModelItem(CmsModelItemDTO cmsModelItem);
	
	public InvokeResult updateCmsModelItem(CmsModelItemDTO cmsModelItem);
	
	public InvokeResult removeCmsModelItem(Long id);
	
	public InvokeResult removeCmsModelItems(Long[] ids);
	
	public List<CmsModelItemDTO> findAllCmsModelItem();
	
	public Page<CmsModelItemDTO> pageQueryCmsModelItem(CmsModelItemDTO cmsModelItem, int currentPage, int pageSize);
	

}

