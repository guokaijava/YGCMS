package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;

import  org.pro.ygcms.core.domain.channel.CmsChannelAttr;

public interface CmsChannelAttrApplication {

	public CmsChannelAttr getCmsChannelAttr(String id);
	
	public void creatCmsChannelAttr(CmsChannelAttr cmsChannelAttr);
	
	public void updateCmsChannelAttr(CmsChannelAttr cmsChannelAttr);
	
	public void removeCmsChannelAttr(CmsChannelAttr cmsChannelAttr);
	
	public void removeCmsChannelAttrs(Set<CmsChannelAttr> cmsChannelAttrs);
	
	public List<CmsChannelAttr> findAllCmsChannelAttr();

	public List<CmsChannelAttr> getCmsChannelAttrByCid(String id);

	public void execJpqlSql(String updLftSql);

	public CmsChannelAttr getCmsChannelAttrByName(CmsChannelAttr cmsChannelAttr);
	
}

