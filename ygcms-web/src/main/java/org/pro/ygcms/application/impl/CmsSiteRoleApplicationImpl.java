package org.pro.ygcms.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;

import org.pro.ygcms.application.CmsSiteRoleApplication;
import org.pro.ygcms.core.domain.site.CmsSiteRole;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public CmsSiteRole getCmsSiteRoleByCondition(Long roleId, String siteid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleid", roleId);
		map.put("siteid", siteid);
		return CmsSiteRole.findByProperties(CmsSiteRole.class, map).get(0);
	}
	
}
