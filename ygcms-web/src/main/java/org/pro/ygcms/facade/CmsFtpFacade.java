package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsFtpFacade {

	public InvokeResult getCmsFtp(String id);
	
	public InvokeResult creatCmsFtp(CmsFtpDTO cmsFtp);
	
	public InvokeResult updateCmsFtp(CmsFtpDTO cmsFtp);
	
	public InvokeResult removeCmsFtp(String id);
	
	public InvokeResult removeCmsFtps(String[] ids);
	
	public List<CmsFtpDTO> findAllCmsFtp();
	
	public Page<CmsFtpDTO> pageQueryCmsFtp(CmsFtpDTO cmsFtp, int currentPage, int pageSize);
	

}

