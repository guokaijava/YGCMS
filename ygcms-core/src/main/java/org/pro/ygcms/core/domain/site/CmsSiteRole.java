package org.pro.ygcms.core.domain.site;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

@Entity
@Table(name="cms_site_role")
public class CmsSiteRole extends CmsAbstractEntity{

	private static final long serialVersionUID = -986957342130632033L;
	@Column(name="site_id")
	private String siteid;
	@Column(name="role_id")
	private Long roleid;
	
	public String getSiteid() {
		return siteid;
	}
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public CmsSiteRole(){}
	public CmsSiteRole(String siteid,Long roleid){
		this.siteid = siteid;
		this.roleid = roleid;
	}
	@Override
	public String[] businessKeys() {
		return null;
	}
	public static void grantSiteToRole(Long roleId, String siteid) {
		 getRepository().save(new CmsSiteRole(siteid,roleId));
	}
	public static void terminateSiteToRole(Long roleId, String siteid) {
		StringBuilder jpql = new StringBuilder("select _siterole from CmsSiteRole _siterole where _siterole.roleid = "+roleId+" and _siterole.siteid = "+siteid);
		List<CmsSiteRole>  list = getRepository().createJpqlQuery(jpql.toString()).list();
		if(list.size()>0){
			getRepository().remove(list.get(0));
		}
	}
	
}
