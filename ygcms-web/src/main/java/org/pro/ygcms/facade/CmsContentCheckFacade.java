package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentCheckFacade {

	public InvokeResult getCmsContentCheck(Long id);
	
	public InvokeResult creatCmsContentCheck(CmsContentCheckDTO cmsContentCheck);
	
	public InvokeResult updateCmsContentCheck(CmsContentCheckDTO cmsContentCheck);
	
	public InvokeResult removeCmsContentCheck(Long id);
	
	public InvokeResult removeCmsContentChecks(Long[] ids);
	
	public List<CmsContentCheckDTO> findAllCmsContentCheck();
	
	public Page<CmsContentCheckDTO> pageQueryCmsContentCheck(CmsContentCheckDTO cmsContentCheck, int currentPage, int pageSize);
	

}

