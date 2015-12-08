package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentChannel;

public interface CmsContentChannelApplication {

	public CmsContentChannel getCmsContentChannel(Long id);
	
	public void creatCmsContentChannel(CmsContentChannel cmsContentChannel);
	
	public void updateCmsContentChannel(CmsContentChannel cmsContentChannel);
	
	public void removeCmsContentChannel(CmsContentChannel cmsContentChannel);
	
	public void removeCmsContentChannels(Set<CmsContentChannel> cmsContentChannels);
	
	public List<CmsContentChannel> findAllCmsContentChannel();
	
}

