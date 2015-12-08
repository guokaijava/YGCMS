package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.site.CmsSite;

public interface CmsSiteApplication {

	public CmsSite getCmsSite(String id);
	
	public void creatCmsSite(CmsSite cmsSite);
	
	public void updateCmsSite(CmsSite cmsSite);
	
	public void removeCmsSite(CmsSite cmsSite);
	
	public void removeCmsSites(Set<CmsSite> cmsSites);
	
	public List<CmsSite> findAllCmsSite();
	
}

