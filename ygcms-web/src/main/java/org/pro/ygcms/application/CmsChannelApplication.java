package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.channel.CmsChannel;

public interface CmsChannelApplication {

	public CmsChannel getCmsChannel(String id);
	
	public void creatCmsChannel(CmsChannel cmsChannel);
	
	public void updateCmsChannel(CmsChannel cmsChannel);
	
	public void removeCmsChannel(CmsChannel cmsChannel);
	
	public void removeCmsChannels(Set<CmsChannel> cmsChannels);
	
	public List<CmsChannel> findAllCmsChannel();
	
}

