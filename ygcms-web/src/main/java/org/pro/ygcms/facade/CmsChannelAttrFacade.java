package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsChannelAttrFacade {

	public InvokeResult getCmsChannelAttr(String id);
	
	public InvokeResult creatCmsChannelAttr(CmsChannelAttrDTO cmsChannelAttr);
	
	public InvokeResult updateCmsChannelAttr(CmsChannelAttrDTO cmsChannelAttr);
	
	public InvokeResult removeCmsChannelAttr(String id);
	
	public InvokeResult removeCmsChannelAttrs(String[] ids);
	
	public List<CmsChannelAttrDTO> findAllCmsChannelAttr();
	
	public Page<CmsChannelAttrDTO> pageQueryCmsChannelAttr(CmsChannelAttrDTO cmsChannelAttr, int currentPage, int pageSize);

	public List<CmsChannelAttrDTO> getCmsChannelAttrByCid(String id);

	public void removeCmsChannelAttrByCid(String channelId);
	

}

