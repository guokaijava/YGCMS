package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsChannelExtApplication;
import org.pro.ygcms.core.domain.channel.CmsChannelExt;

@Named
@Transactional
public class CmsChannelExtApplicationImpl implements CmsChannelExtApplication {

	public CmsChannelExt getCmsChannelExt(Long id) {
		return CmsChannelExt.get(CmsChannelExt.class, id);
	}
	
	public void creatCmsChannelExt(CmsChannelExt cmsChannelExt) {
		cmsChannelExt.save();
	}
	
	public void updateCmsChannelExt(CmsChannelExt cmsChannelExt) {
		cmsChannelExt.save();
	}
	
	public void removeCmsChannelExt(CmsChannelExt cmsChannelExt) {
		if(cmsChannelExt != null){
			cmsChannelExt.remove();
		}
	}
	
	public void removeCmsChannelExts(Set<CmsChannelExt> cmsChannelExts) {
		for (CmsChannelExt cmsChannelExt : cmsChannelExts) {
			cmsChannelExt.remove();
		}
	}
	
	public List<CmsChannelExt> findAllCmsChannelExt() {
		return CmsChannelExt.findAll(CmsChannelExt.class);
	}

	@Override
	public CmsChannelExt getCmsChannelExtByCid(String id) {
		return CmsChannelExt.findByProperty(CmsChannelExt.class, "channelId", id).get(0);
	}
	
}
