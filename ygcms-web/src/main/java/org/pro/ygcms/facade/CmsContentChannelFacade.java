package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentChannelFacade {

	public InvokeResult getCmsContentChannel(Long id);
	
	public InvokeResult creatCmsContentChannel(CmsContentChannelDTO cmsContentChannel);
	
	public InvokeResult updateCmsContentChannel(CmsContentChannelDTO cmsContentChannel);
	
	public InvokeResult removeCmsContentChannel(Long id);
	
	public InvokeResult removeCmsContentChannels(Long[] ids);
	
	public List<CmsContentChannelDTO> findAllCmsContentChannel();
	
	public Page<CmsContentChannelDTO> pageQueryCmsContentChannel(CmsContentChannelDTO cmsContentChannel, int currentPage, int pageSize);
	

}

