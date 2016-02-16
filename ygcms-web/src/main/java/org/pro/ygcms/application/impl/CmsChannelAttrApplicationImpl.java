package org.pro.ygcms.application.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;

import org.pro.ygcms.application.CmsChannelAttrApplication;
import org.pro.ygcms.core.domain.channel.CmsChannelAttr;
import org.springframework.transaction.annotation.Transactional;

@Named
@Transactional
public class CmsChannelAttrApplicationImpl implements CmsChannelAttrApplication {

	public CmsChannelAttr getCmsChannelAttr(String id) {
		return CmsChannelAttr.get(CmsChannelAttr.class, id);
	}
	
	public void creatCmsChannelAttr(CmsChannelAttr cmsChannelAttr) {
		cmsChannelAttr.save();
	}
	
	public void updateCmsChannelAttr(CmsChannelAttr cmsChannelAttr) {
		cmsChannelAttr .save();
	}
	
	public void removeCmsChannelAttr(CmsChannelAttr cmsChannelAttr) {
		if(cmsChannelAttr != null){
			cmsChannelAttr.remove();
		}
	}
	
	public void removeCmsChannelAttrs(Set<CmsChannelAttr> cmsChannelAttrs) {
		for (CmsChannelAttr cmsChannelAttr : cmsChannelAttrs) {
			cmsChannelAttr.remove();
		}
	}
	
	public List<CmsChannelAttr> findAllCmsChannelAttr() {
		return CmsChannelAttr.findAll(CmsChannelAttr.class);
	}

	@Override
	public List<CmsChannelAttr> getCmsChannelAttrByCid(String id) {
		return CmsChannelAttr.findByProperty(CmsChannelAttr.class, "channelId", id);
	}

	@Override
	public void execJpqlSql(String updLftSql) {
		CmsChannelAttr.updateByJpql(updLftSql);
	}

	@Override
	public CmsChannelAttr getCmsChannelAttrByName(CmsChannelAttr cmsChannelAttr) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("channelId", cmsChannelAttr.getChannelId());
		map.put("attrName", cmsChannelAttr.getAttrName());
		List<CmsChannelAttr> list = CmsChannelAttr.findByProperties(CmsChannelAttr.class, map);
		return list.size()>0?list.get(0):null;
	}
	
}
