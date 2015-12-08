package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentTagFacade {

	public InvokeResult getCmsContentTag(Long id);
	
	public InvokeResult creatCmsContentTag(CmsContentTagDTO cmsContentTag);
	
	public InvokeResult updateCmsContentTag(CmsContentTagDTO cmsContentTag);
	
	public InvokeResult removeCmsContentTag(Long id);
	
	public InvokeResult removeCmsContentTags(Long[] ids);
	
	public List<CmsContentTagDTO> findAllCmsContentTag();
	
	public Page<CmsContentTagDTO> pageQueryCmsContentTag(CmsContentTagDTO cmsContentTag, int currentPage, int pageSize);
	

}

