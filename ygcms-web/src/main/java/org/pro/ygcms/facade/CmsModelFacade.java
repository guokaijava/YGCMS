package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsModelFacade {

	public InvokeResult getCmsModel(Long id);
	
	public InvokeResult creatCmsModel(CmsModelDTO cmsModel);
	
	public InvokeResult updateCmsModel(CmsModelDTO cmsModel);
	
	public InvokeResult removeCmsModel(Long id);
	
	public InvokeResult removeCmsModels(Long[] ids);
	
	public List<CmsModelDTO> findAllCmsModel();
	
	public Page<CmsModelDTO> pageQueryCmsModel(CmsModelDTO cmsModel, int currentPage, int pageSize);
	

}

