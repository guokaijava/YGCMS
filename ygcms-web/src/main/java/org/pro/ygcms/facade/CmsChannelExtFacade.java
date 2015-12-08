package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsChannelExtFacade {

	public InvokeResult getCmsChannelExt(Long id);
	
	public InvokeResult creatCmsChannelExt(CmsChannelExtDTO cmsChannelExt);
	
	public InvokeResult updateCmsChannelExt(CmsChannelExtDTO cmsChannelExt);
	
	public InvokeResult removeCmsChannelExt(Long id);
	
	public InvokeResult removeCmsChannelExts(Long[] ids);
	
	public List<CmsChannelExtDTO> findAllCmsChannelExt();
	
	public Page<CmsChannelExtDTO> pageQueryCmsChannelExt(CmsChannelExtDTO cmsChannelExt, int currentPage, int pageSize);
	

}

