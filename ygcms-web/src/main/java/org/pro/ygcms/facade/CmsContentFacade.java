package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentFacade {

	public InvokeResult getCmsContent(String id);
	
	public String creatCmsContent(CmsContentDTO cmsContent);
	
	public InvokeResult updateCmsContent(CmsContentDTO cmsContent);
	
	public InvokeResult removeCmsContent(String id);
	
	public InvokeResult removeCmsContents(String[] ids);
	
	public List<CmsContentDTO> findAllCmsContent();
	
	public Page<CmsContentInfoDTO> pageQueryCmsContent(CmsContentDTO cmsContent, int currentPage, int pageSize);
	

}

