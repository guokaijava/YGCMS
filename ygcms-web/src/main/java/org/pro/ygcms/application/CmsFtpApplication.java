package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.ftp.CmsFtp;

public interface CmsFtpApplication {

	public CmsFtp getCmsFtp(Long id);
	
	public void creatCmsFtp(CmsFtp cmsFtp);
	
	public void updateCmsFtp(CmsFtp cmsFtp);
	
	public void removeCmsFtp(CmsFtp cmsFtp);
	
	public void removeCmsFtps(Set<CmsFtp> cmsFtps);
	
	public List<CmsFtp> findAllCmsFtp();
	
}

