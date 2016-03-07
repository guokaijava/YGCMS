package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentTxtApplication;
import org.pro.ygcms.core.domain.content.CmsContentTxt;

@Named
@Transactional
public class CmsContentTxtApplicationImpl implements CmsContentTxtApplication {

	public CmsContentTxt getCmsContentTxt(String id) {
		return CmsContentTxt.get(CmsContentTxt.class, id);
	}
	
	public void creatCmsContentTxt(CmsContentTxt cmsContentTxt) {
		cmsContentTxt.save();
	}
	
	public void updateCmsContentTxt(CmsContentTxt cmsContentTxt) {
		cmsContentTxt .save();
	}
	
	public void removeCmsContentTxt(CmsContentTxt cmsContentTxt) {
		if(cmsContentTxt != null){
			cmsContentTxt.remove();
		}
	}
	
	public void removeCmsContentTxts(Set<CmsContentTxt> cmsContentTxts) {
		for (CmsContentTxt cmsContentTxt : cmsContentTxts) {
			cmsContentTxt.remove();
		}
	}
	
	public List<CmsContentTxt> findAllCmsContentTxt() {
		return CmsContentTxt.findAll(CmsContentTxt.class);
	}
	
	public CmsContentTxt getCmsContentTxtByCId(String contentId){
		List<CmsContentTxt> cmsContentTxtList = CmsContentTxt.findByProperty(CmsContentTxt.class, "contentId", contentId);
		if(cmsContentTxtList.size()>0){
			return cmsContentTxtList.get(0);
		}
		return null;
	}
}
