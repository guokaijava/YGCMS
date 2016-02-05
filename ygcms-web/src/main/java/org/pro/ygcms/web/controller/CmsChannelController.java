package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;
import org.pro.ygcms.facade.CmsChannelExtFacade;
import org.pro.ygcms.facade.CmsChannelFacade;
import org.pro.ygcms.facade.dto.CmsChannelDTO;
import org.pro.ygcms.facade.dto.CmsChannelExtDTO;
import org.pro.ygcms.facade.dto.CmsSiteDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsChannel")
public class CmsChannelController {
		
	@Inject
	private CmsChannelFacade cmsChannelFacade;
	
	@Inject
	private CmsChannelExtFacade cmsChannelExtFacade;
	
	@ResponseBody
	@RequestMapping("/tree")
	public Map<String, Object> getChannelTree(HttpServletRequest request,@RequestParam String siteid) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("fileTree", cmsChannelFacade.getChannelTree(siteid));
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/getSitelist")
	public Map<String, Object> getSiteList(HttpServletRequest request) {
		List<CmsSiteDTO> siteIdList = CurrentUser.getCmsSiteList();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("sitelist",siteIdList);
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/getChildChannel/{pid}")
	public Page<CmsChannelDTO> getchildChannel(@PathVariable String pid) {
		Page<CmsChannelDTO> cclist =  cmsChannelFacade.getChildChannel(pid);
		return cclist;
	}
	
	@ResponseBody
	@RequestMapping("/getChannelDetail/{cid}")
	public Map<String, Object> getChannelDetail(@PathVariable String cid) {
		CmsChannelDTO ccd =   cmsChannelFacade.getChannelDetail(cid);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("ccd",ccd);
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsChannelExtDTO cmsChannelExtDTO,HttpServletRequest req) {
		// 插入CmsChannel
		
		// 插入CmsChannelExt
		
		// 插入CmsChannelTxt
		
		//return cmsChannelFacade.creatCmsChannel(cmsChannelDTO);
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsChannelDTO cmsChannelDTO) {
		return cmsChannelFacade.updateCmsChannel(cmsChannelDTO);
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
        return cmsChannelFacade.removeCmsChannels(value);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable String id) {
		return cmsChannelFacade.getCmsChannel(id);
	}
	
		
    @InitBinder    
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");    
        dateFormat.setLenient(false);    
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
        //CustomDateEditor 可以换成自己定义的编辑器。  
        //注册一个Date 类型的绑定器 。
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
    }
	
}
