package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsSiteRoleApplication;
import org.pro.ygcms.core.domain.site.CmsSiteRole;

@Named
@Transactional
public class CmsSiteRoleApplicationImpl implements CmsSiteRoleApplication {

	public CmsSiteRole getCmsSiteRole(Long id) {
		return CmsSiteRole.get(CmsSiteRole.class, id);
	}
	
	public void creatCmsSiteRole(CmsSiteRole cmsSiteRole) {
		cmsSiteRole.save();
	}
	
	public void updateCmsSiteRole(CmsSiteRole cmsSiteRole) {
		cmsSiteRole .save();
	}
	
	public void removeCmsSiteRole(CmsSiteRole cmsSiteRole) {
		if(cmsSiteRole != null){
			cmsSiteRole.remove();
		}
	}
	
	public void removeCmsSiteRoles(Set<CmsSiteRole> cmsSiteRoles) {
		for (CmsSiteRole cmsSiteRole : cmsSiteRoles) {
			cmsSiteRole.remove();
		}
	}
	
	public List<CmsSiteRole> findAllCmsSiteRole() {
		return CmsSiteRole.findAll(CmsSiteRole.class);
	}
	
}
