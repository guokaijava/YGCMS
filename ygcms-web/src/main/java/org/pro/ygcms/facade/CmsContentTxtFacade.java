package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentTxtFacade {

	public InvokeResult getCmsContentTxt(Long id);
	
	public InvokeResult creatCmsContentTxt(CmsContentTxtDTO cmsContentTxt);
	
	public InvokeResult updateCmsContentTxt(CmsContentTxtDTO cmsContentTxt);
	
	public InvokeResult removeCmsContentTxt(Long id);
	
	public InvokeResult removeCmsContentTxts(Long[] ids);
	
	public List<CmsContentTxtDTO> findAllCmsContentTxt();
	
	public Page<CmsContentTxtDTO> pageQueryCmsContentTxt(CmsContentTxtDTO cmsContentTxt, int currentPage, int pageSize);
	

}

