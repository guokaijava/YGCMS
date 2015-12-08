package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.channel.CmsChannelExt;

public interface CmsChannelExtApplication {

	public CmsChannelExt getCmsChannelExt(Long id);
	
	public void creatCmsChannelExt(CmsChannelExt cmsChannelExt);
	
	public void updateCmsChannelExt(CmsChannelExt cmsChannelExt);
	
	public void removeCmsChannelExt(CmsChannelExt cmsChannelExt);
	
	public void removeCmsChannelExts(Set<CmsChannelExt> cmsChannelExts);
	
	public List<CmsChannelExt> findAllCmsChannelExt();
	
}

