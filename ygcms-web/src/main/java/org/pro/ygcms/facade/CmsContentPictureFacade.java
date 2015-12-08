package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentPictureFacade {

	public InvokeResult getCmsContentPicture(Long id);
	
	public InvokeResult creatCmsContentPicture(CmsContentPictureDTO cmsContentPicture);
	
	public InvokeResult updateCmsContentPicture(CmsContentPictureDTO cmsContentPicture);
	
	public InvokeResult removeCmsContentPicture(Long id);
	
	public InvokeResult removeCmsContentPictures(Long[] ids);
	
	public List<CmsContentPictureDTO> findAllCmsContentPicture();
	
	public Page<CmsContentPictureDTO> pageQueryCmsContentPicture(CmsContentPictureDTO cmsContentPicture, int currentPage, int pageSize);
	

}

