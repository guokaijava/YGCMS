package org.pro.ygcms.facade;

import java.util.List;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsChannelFacade {

	public InvokeResult getCmsChannel(String id);
	
	public String creatCmsChannel(CmsChannelDTO cmsChannel);
	
	public InvokeResult updateCmsChannel(CmsChannelExtDTO cmsChannelExtDTO);
	
	public InvokeResult removeCmsChannel(String id);
	
	public InvokeResult removeCmsChannels(String[] ids);
	
	public List<CmsChannelDTO> findAllCmsChannel();
	
	public Page<CmsChannelDTO> pageQueryCmsChannel(CmsChannelDTO cmsChannel, int currentPage, int pageSize);

	public CmsChannelInfoDTO getChannelTree(String siteId);

	public Page<CmsChannelDTO> getChildChannel(String pid);

	public CmsChannelDTO getChannelDetail(String cid);
	

}

