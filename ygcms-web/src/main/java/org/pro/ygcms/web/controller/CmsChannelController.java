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
import org.pro.ygcms.facade.CmsChannelAttrFacade;
import org.pro.ygcms.facade.CmsChannelExtFacade;
import org.pro.ygcms.facade.CmsChannelFacade;
import org.pro.ygcms.facade.CmsChannelTxtFacade;
import org.pro.ygcms.facade.CmsModelItemFacade;
import org.pro.ygcms.facade.dto.CmsChannelAttrDTO;
import org.pro.ygcms.facade.dto.CmsChannelDTO;
import org.pro.ygcms.facade.dto.CmsChannelExtDTO;
import org.pro.ygcms.facade.dto.CmsChannelTxtDTO;
import org.pro.ygcms.facade.dto.CmsSiteDTO;
import org.pro.ygcms.web.util.RequestUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsChannel")
public class CmsChannelController {
	@Inject
	private CmsChannelFacade cmsChannelFacade;
	@Inject
	private CmsChannelExtFacade cmsChannelExtFacade;
	@Inject
	private CmsChannelAttrFacade cmsChannelAttrFacade;
	@Inject
	private CmsChannelTxtFacade cmsChannelTxtFacade;
	@Inject
	private CmsModelItemFacade cmsModelItemFacade;
	
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
	@RequestMapping(value="/addChannel",method=RequestMethod.POST)
	public InvokeResult addChannel(CmsChannelExtDTO cmsChannelExtDTO,HttpServletRequest req) {
		// 插入CmsChannel
		CmsChannelDTO cmsChannelDTO = new CmsChannelDTO();
		cmsChannelDTO.setChannelName(cmsChannelExtDTO.getChannelName());
		cmsChannelDTO.setParentId(cmsChannelExtDTO.getParentId());
		cmsChannelDTO.setChannelPath(cmsChannelExtDTO.getChannelPath());
		cmsChannelDTO.setPriority(cmsChannelExtDTO.getPriority());
		cmsChannelDTO.setSiteId(cmsChannelExtDTO.getSiteId());
		cmsChannelDTO.setModelId(cmsChannelExtDTO.getModelId());
		cmsChannelDTO.setIsDisplay(cmsChannelExtDTO.getIsDisplay());
		// 插入成功后返回Id
		String cid = cmsChannelFacade.creatCmsChannel(cmsChannelDTO);
		// 插入CmsChannelExt
		cmsChannelExtDTO.setChannelId(cid);
		cmsChannelExtFacade.creatCmsChannelExt(cmsChannelExtDTO);
		// 插入CmsChannelAttr
		Map<String,String> map = RequestUtils.getRequestMap(req, "attr_");
		for(String str : map.keySet()){
			CmsChannelAttrDTO attrDTO = new CmsChannelAttrDTO();
			attrDTO.setAttrName(str);
			attrDTO.setAttrValue(map.get(str));
			attrDTO.setChannelId(cid);
			cmsChannelAttrFacade.creatCmsChannelAttr(attrDTO);
		}
		// 插入CmsChannelTxt
		CmsChannelTxtDTO cmsChannelTxt = new CmsChannelTxtDTO();
		cmsChannelTxt.setChannelId(cid);
		cmsChannelTxt.setTxt(cmsChannelExtDTO.getTxt());
		cmsChannelTxtFacade.creatCmsChannelTxt(cmsChannelTxt);
		
		return InvokeResult.success();
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public InvokeResult update(CmsChannelExtDTO cmsChannelExtDTO,HttpServletRequest req) {
			    // 更新CmsChannel
				cmsChannelFacade.updateCmsChannel(cmsChannelExtDTO);
				// 插入CmsChannelExt
				cmsChannelExtFacade.updateCmsChannelExt(cmsChannelExtDTO);
				// 插入CmsChannelAttr
				Map<String,String> map = RequestUtils.getRequestMap(req, "attr_");
				for(String str : map.keySet()){
					CmsChannelAttrDTO attrDTO = new CmsChannelAttrDTO();
					attrDTO.setAttrName(str);
					attrDTO.setAttrValue(map.get(str));
					attrDTO.setChannelId(cmsChannelExtDTO.getChannelId());
					cmsChannelAttrFacade.updateCmsChannelAttr(attrDTO);
				}
				// 插入CmsChannelTxt
				CmsChannelTxtDTO cmsChannelTxt = new CmsChannelTxtDTO();
				cmsChannelTxt.setChannelId(cmsChannelExtDTO.getChannelId());
				cmsChannelTxt.setTxt(cmsChannelExtDTO.getTxt());
				cmsChannelTxtFacade.updateCmsChannelTxt(cmsChannelTxt);
				return InvokeResult.success();
	}
	
	@ResponseBody
	@RequestMapping("/delChannel")
	public InvokeResult delChannel(HttpServletRequest req) {
		String id = (String)req.getParameter("id");
		// 删除Txt
		cmsChannelTxtFacade.removeCmsChannelTxtByCid(id);
		// 删除Attr
		cmsChannelAttrFacade.removeCmsChannelAttrByCid(id);
		// 删除Ext
		cmsChannelExtFacade.removeCmsChannelExtByCid(id);
		// 删除Channel
		cmsChannelFacade.removeCmsChannel(id);
		return InvokeResult.success();
	}
	
	@ResponseBody
	@RequestMapping("/getChannel")
	public Map<String, Object> getChannel(HttpServletRequest req) {
		String id = (String)req.getParameter("id");
		CmsChannelDTO cmsChannel = (CmsChannelDTO)cmsChannelFacade.getCmsChannel(id).getData();
		CmsChannelExtDTO cmsChannelExt = cmsChannelExtFacade.getCmsChannelExtByCid(id);
		List<CmsChannelAttrDTO> cmsChannelAttr = cmsChannelAttrFacade.getCmsChannelAttrByCid(id);
		CmsChannelTxtDTO cmsChannelTxt  = cmsChannelTxtFacade.getCmsChannelTxtByCid(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tplList", cmsModelItemFacade.getItemsByModelId(cmsChannel.getModelId(),1));
		map.put("cmsChannel",cmsChannel);
		map.put("cmsChannelExt", cmsChannelExt);
		map.put("cmsChannelAttr", cmsChannelAttr);
		map.put("cmsChannelTxt", cmsChannelTxt);
		return map;
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
