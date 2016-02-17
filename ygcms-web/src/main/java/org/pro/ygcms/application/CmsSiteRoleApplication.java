package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.site.CmsSiteRole;

public interface CmsSiteRoleApplication {

	public CmsSiteRole getCmsSiteRole(Long id);
	
	public void creatCmsSiteRole(CmsSiteRole cmsSiteRole);
	
	public void updateCmsSiteRole(CmsSiteRole cmsSiteRole);
	
	public void removeCmsSiteRole(CmsSiteRole cmsSiteRole);
	
	public void removeCmsSiteRoles(Set<CmsSiteRole> cmsSiteRoles);
	
	public List<CmsSiteRole> findAllCmsSiteRole();

	public CmsSiteRole getCmsSiteRoleByCondition(Long roleId, String str);
	
}

