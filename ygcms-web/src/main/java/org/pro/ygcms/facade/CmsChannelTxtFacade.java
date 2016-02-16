package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsChannelTxtFacade {

	public InvokeResult getCmsChannelTxt(Long id);
	
	public InvokeResult creatCmsChannelTxt(CmsChannelTxtDTO cmsChannelTxt);
	
	public InvokeResult updateCmsChannelTxt(CmsChannelTxtDTO cmsChannelTxt);
	
	public InvokeResult removeCmsChannelTxt(Long id);
	
	public InvokeResult removeCmsChannelTxts(Long[] ids);
	
	public List<CmsChannelTxtDTO> findAllCmsChannelTxt();
	
	public Page<CmsChannelTxtDTO> pageQueryCmsChannelTxt(CmsChannelTxtDTO cmsChannelTxt, int currentPage, int pageSize);

	public CmsChannelTxtDTO getCmsChannelTxtByCid(String id);

	public void removeCmsChannelTxtByCid(String channelId);
	

}

