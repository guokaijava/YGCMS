package org.pro.ygcms.facade;

import java.util.List;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.*;

public interface CmsSiteRoleFacade {

	public InvokeResult getCmsSiteRole(Long id);
	
	public InvokeResult creatCmsSiteRole(CmsSiteRoleDTO cmsSiteRole);
	
	public InvokeResult updateCmsSiteRole(CmsSiteRoleDTO cmsSiteRole);
	
	public InvokeResult removeCmsSiteRole(Long id);
	
	public InvokeResult removeCmsSiteRoles(Long[] ids);
	
	public List<CmsSiteRoleDTO> findAllCmsSiteRole();
	
	public Page<CmsSiteRoleDTO> pageQueryCmsSiteRole(CmsSiteRoleDTO cmsSiteRole, int currentPage, int pageSize);

	public InvokeResult terminateSiteResourcesFromRole(Long roleId, String[] siteResourceIds);

	public InvokeResult grantSiteResourcesToRole(Long roleId, String[] siteResourceIds);

}

