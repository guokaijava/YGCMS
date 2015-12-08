package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsSiteFacade {

	public InvokeResult getCmsSite(String id);
	
	public InvokeResult creatCmsSite(CmsSiteDTO cmsSite);
	
	public InvokeResult updateCmsSite(CmsSiteDTO cmsSite);
	
	public InvokeResult removeCmsSite(String id);
	
	public InvokeResult removeCmsSites(String[] ids);
	
	public List<CmsSiteDTO> findAllCmsSite();
	
	public Page<CmsSiteDTO> pageQueryCmsSite(CmsSiteDTO cmsSite, int currentPage, int pageSize);
	

}

