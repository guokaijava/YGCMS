package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentTxt;

public interface CmsContentTxtApplication {

	public CmsContentTxt getCmsContentTxt(Long id);
	
	public void creatCmsContentTxt(CmsContentTxt cmsContentTxt);
	
	public void updateCmsContentTxt(CmsContentTxt cmsContentTxt);
	
	public void removeCmsContentTxt(CmsContentTxt cmsContentTxt);
	
	public void removeCmsContentTxts(Set<CmsContentTxt> cmsContentTxts);
	
	public List<CmsContentTxt> findAllCmsContentTxt();
	
}

