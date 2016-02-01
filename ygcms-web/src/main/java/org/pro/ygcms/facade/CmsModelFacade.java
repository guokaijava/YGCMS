package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsModelFacade {

	public InvokeResult getCmsModel(String id);
	
	public InvokeResult creatCmsModel(CmsModelDTO cmsModel);
	
	public InvokeResult updateCmsModel(CmsModelDTO cmsModel);
	
	public InvokeResult removeCmsModel(String id);
	
	public InvokeResult removeCmsModels(String[] ids);
	
	public List<CmsModelDTO> findAllCmsModel();
	
	public Page<CmsModelDTO> pageQueryCmsModel(CmsModelDTO cmsModel, int currentPage, int pageSize);
	

}

