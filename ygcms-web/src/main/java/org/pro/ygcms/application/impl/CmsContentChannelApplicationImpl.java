package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentChannelApplication;
import org.pro.ygcms.core.domain.content.CmsContentChannel;

@Named
@Transactional
public class CmsContentChannelApplicationImpl implements CmsContentChannelApplication {

	public CmsContentChannel getCmsContentChannel(Long id) {
		return CmsContentChannel.get(CmsContentChannel.class, id);
	}
	
	public void creatCmsContentChannel(CmsContentChannel cmsContentChannel) {
		cmsContentChannel.save();
	}
	
	public void updateCmsContentChannel(CmsContentChannel cmsContentChannel) {
		cmsContentChannel .save();
	}
	
	public void removeCmsContentChannel(CmsContentChannel cmsContentChannel) {
		if(cmsContentChannel != null){
			cmsContentChannel.remove();
		}
	}
	
	public void removeCmsContentChannels(Set<CmsContentChannel> cmsContentChannels) {
		for (CmsContentChannel cmsContentChannel : cmsContentChannels) {
			cmsContentChannel.remove();
		}
	}
	
	public List<CmsContentChannel> findAllCmsContentChannel() {
		return CmsContentChannel.findAll(CmsContentChannel.class);
	}
	
}
