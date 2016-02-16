package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsChannelApplication;
import org.pro.ygcms.core.domain.channel.CmsChannel;

@Named
@Transactional
public class CmsChannelApplicationImpl implements CmsChannelApplication {

	public CmsChannel getCmsChannel(String id) {
		return CmsChannel.get(CmsChannel.class, id);
	}
	
	public void creatCmsChannel(CmsChannel cmsChannel) {
		cmsChannel.save();
	}
	
	public void updateCmsChannel(CmsChannel cmsChannel) {
		cmsChannel.save();
	}
	
	public void removeCmsChannel(CmsChannel cmsChannel) {
		if(cmsChannel != null){
			cmsChannel.remove();
		}
	}
	
	public void removeCmsChannels(Set<CmsChannel> cmsChannels) {
		for (CmsChannel cmsChannel : cmsChannels) {
			cmsChannel.remove();
		}
	}
	
	public List<CmsChannel> findAllCmsChannel() {
		return CmsChannel.findAll(CmsChannel.class);
	}

	@Override
	public void execJpqlSql(String updLftSql) {
		CmsChannel.updateByJpql(updLftSql);
	}
	
}
