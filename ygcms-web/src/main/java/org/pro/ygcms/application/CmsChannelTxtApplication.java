package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.channel.CmsChannelTxt;

public interface CmsChannelTxtApplication {

	public CmsChannelTxt getCmsChannelTxt(Long id);
	
	public void creatCmsChannelTxt(CmsChannelTxt cmsChannelTxt);
	
	public void updateCmsChannelTxt(CmsChannelTxt cmsChannelTxt);
	
	public void removeCmsChannelTxt(CmsChannelTxt cmsChannelTxt);
	
	public void removeCmsChannelTxts(Set<CmsChannelTxt> cmsChannelTxts);
	
	public List<CmsChannelTxt> findAllCmsChannelTxt();
	
}

