package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentTxtFacade {

	public InvokeResult getCmsContentTxt(String id);
	
	public InvokeResult creatCmsContentTxt(CmsContentTxtDTO cmsContentTxt);
	
	public InvokeResult updateCmsContentTxt(CmsContentTxtDTO cmsContentTxt);
	
	public InvokeResult removeCmsContentTxt(String id);
	
	public InvokeResult removeCmsContentTxts(String[] ids);
	
	public List<CmsContentTxtDTO> findAllCmsContentTxt();
	
	public Page<CmsContentTxtDTO> pageQueryCmsContentTxt(CmsContentTxtDTO cmsContentTxt, int currentPage, int pageSize);
	
	public CmsContentTxtDTO getCmsContentTxtByCId(String contentId);
	

}

