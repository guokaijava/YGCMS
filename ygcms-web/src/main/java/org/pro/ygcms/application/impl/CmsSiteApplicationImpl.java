package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsSiteApplication;
import org.pro.ygcms.core.domain.site.CmsSite;

@Named
@Transactional
public class CmsSiteApplicationImpl implements CmsSiteApplication {

	public CmsSite getCmsSite(String id) {
		return CmsSite.get(CmsSite.class, id);
	}
	
	public void creatCmsSite(CmsSite cmsSite) {
		cmsSite.save();
	}
	
	public void updateCmsSite(CmsSite cmsSite) {
		cmsSite .save();
	}
	
	public void removeCmsSite(CmsSite cmsSite) {
		if(cmsSite != null){
			cmsSite.remove();
		}
	}
	
	public void removeCmsSites(Set<CmsSite> cmsSites) {
		for (CmsSite cmsSite : cmsSites) {
			cmsSite.remove();
		}
	}
	
	public List<CmsSite> findAllCmsSite() {
		return CmsSite.findAll(CmsSite.class);
	}
	
}
