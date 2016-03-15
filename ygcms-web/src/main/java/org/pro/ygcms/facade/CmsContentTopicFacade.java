package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsContentTopicFacade {

	public InvokeResult getCmsContentTopic(String id);
	
	public InvokeResult creatCmsContentTopic(CmsContentTopicDTO cmsContentTopic);
	
	public InvokeResult updateCmsContentTopic(CmsContentTopicDTO cmsContentTopic);
	
	public InvokeResult removeCmsContentTopic(String id);
	
	public InvokeResult removeCmsContentTopics(String[] ids);
	
	public List<CmsContentTopicDTO> findAllCmsContentTopic();
	
	public Page<CmsContentTopicDTO> pageQueryCmsContentTopic(CmsContentTopicDTO cmsContentTopic, int currentPage, int pageSize);
	
	public CmsContentTopicDTO getCmsContentTopicByCId(String contentId);
	
	public InvokeResult removeCmsContentTopicsByCId(String contentId);

}

