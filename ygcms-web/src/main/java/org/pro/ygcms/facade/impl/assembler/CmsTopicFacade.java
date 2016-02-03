package org.pro.ygcms.facade.impl.assembler;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsTopicFacade {

	public InvokeResult getCmsTopic(String id);
	
	public InvokeResult creatCmsTopic(CmsTopicDTO cmsTopic);
	
	public InvokeResult updateCmsTopic(CmsTopicDTO cmsTopic);
	
	public InvokeResult removeCmsTopic(String id);
	
	public InvokeResult removeCmsTopics(String[] ids);
	
	public List<CmsTopicDTO> findAllCmsTopic();
	
	public Page<CmsTopicDTO> pageQueryCmsTopic(CmsTopicDTO cmsTopic, int currentPage, int pageSize);
	

}

