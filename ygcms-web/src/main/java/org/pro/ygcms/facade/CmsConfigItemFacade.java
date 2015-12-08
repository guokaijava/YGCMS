package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsConfigItemFacade {

	public InvokeResult getCmsConfigItem(Long id);
	
	public InvokeResult creatCmsConfigItem(CmsConfigItemDTO cmsConfigItem);
	
	public InvokeResult updateCmsConfigItem(CmsConfigItemDTO cmsConfigItem);
	
	public InvokeResult removeCmsConfigItem(Long id);
	
	public InvokeResult removeCmsConfigItems(Long[] ids);
	
	public List<CmsConfigItemDTO> findAllCmsConfigItem();
	
	public Page<CmsConfigItemDTO> pageQueryCmsConfigItem(CmsConfigItemDTO cmsConfigItem, int currentPage, int pageSize);
	

}

