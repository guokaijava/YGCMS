package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsFtpApplication;
import org.pro.ygcms.core.domain.ftp.CmsFtp;

@Named
@Transactional
public class CmsFtpApplicationImpl implements CmsFtpApplication {

	public CmsFtp getCmsFtp(String id) {
		return CmsFtp.get(CmsFtp.class, id);
	}
	
	public void creatCmsFtp(CmsFtp cmsFtp) {
		cmsFtp.save();
	}
	
	public void updateCmsFtp(CmsFtp cmsFtp) {
		cmsFtp .save();
	}
	
	public void removeCmsFtp(CmsFtp cmsFtp) {
		if(cmsFtp != null){
			cmsFtp.remove();
		}
	}
	
	public void removeCmsFtps(Set<CmsFtp> cmsFtps) {
		for (CmsFtp cmsFtp : cmsFtps) {
			cmsFtp.remove();
		}
	}
	
	public List<CmsFtp> findAllCmsFtp() {
		return CmsFtp.findAll(CmsFtp.class);
	}
	
}
