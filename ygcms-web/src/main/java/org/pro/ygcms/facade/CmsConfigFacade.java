package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsConfigFacade {

	public InvokeResult getCmsConfig(Long id);
	
	public InvokeResult creatCmsConfig(CmsConfigDTO cmsConfig);
	
	public InvokeResult updateCmsConfig(CmsConfigDTO cmsConfig);
	
	public InvokeResult removeCmsConfig(Long id);
	
	public InvokeResult removeCmsConfigs(Long[] ids);
	
	public List<CmsConfigDTO> findAllCmsConfig();
	
	public Page<CmsConfigDTO> pageQueryCmsConfig(CmsConfigDTO cmsConfig, int currentPage, int pageSize);
	

}

