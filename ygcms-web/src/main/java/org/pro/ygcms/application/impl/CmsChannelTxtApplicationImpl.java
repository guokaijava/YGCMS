package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsChannelTxtApplication;
import org.pro.ygcms.core.domain.channel.CmsChannelTxt;

@Named
@Transactional
public class CmsChannelTxtApplicationImpl implements CmsChannelTxtApplication {

	public CmsChannelTxt getCmsChannelTxt(Long id) {
		return CmsChannelTxt.get(CmsChannelTxt.class, id);
	}
	
	public void creatCmsChannelTxt(CmsChannelTxt cmsChannelTxt) {
		cmsChannelTxt.save();
	}
	
	public void updateCmsChannelTxt(CmsChannelTxt cmsChannelTxt) {
		cmsChannelTxt .save();
	}
	
	public void removeCmsChannelTxt(CmsChannelTxt cmsChannelTxt) {
		if(cmsChannelTxt != null){
			cmsChannelTxt.remove();
		}
	}
	
	public void removeCmsChannelTxts(Set<CmsChannelTxt> cmsChannelTxts) {
		for (CmsChannelTxt cmsChannelTxt : cmsChannelTxts) {
			cmsChannelTxt.remove();
		}
	}
	
	public List<CmsChannelTxt> findAllCmsChannelTxt() {
		return CmsChannelTxt.findAll(CmsChannelTxt.class);
	}
	
}
