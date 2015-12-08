package org.pro.ygcms.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.core.common.CmsConstants;
import org.pro.ygcms.facade.CmsTplManagerFacade;
import org.pro.ygcms.facade.dto.CmsFileDTO;
import org.pro.ygcms.facade.dto.CmsTplManagerDTO;
import org.pro.ygcms.web.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsTplManager")
public class CmsTplManagerController {
	
	@Inject
	private CmsTplManagerFacade cmsTplManageFacade;
	
	
	@ResponseBody
	@RequestMapping("/tree")
	public Map<String, Object> getOrgTree(HttpServletRequest request) {
		String realpath=CommonUtil.getPath(request,CmsConstants.TPL_BASE+"/www");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("fileTree", cmsTplManageFacade.getChild(realpath));
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public Page<CmsTplManagerDTO> getFileList(HttpServletRequest request,@RequestParam("path") String dname) {
		String realpath="";
		if(dname.equals("")){
			realpath=CommonUtil.getPath(request,CmsConstants.TPL_BASE+"/www");
		}else{
			realpath = CommonUtil.getPath(request,dname.substring(dname.indexOf(CmsConstants.TPL_BASE+"/www")));
		}
		return new Page<CmsTplManagerDTO>(0,Integer.MAX_VALUE,cmsTplManageFacade.getListFileByPDir(realpath));
	}
	
	@ResponseBody
	@RequestMapping("/addDir")
	public InvokeResult addDir(HttpServletRequest request,@RequestParam("path") String dname){
		String path = CommonUtil.getPath(request,dname.substring(dname.indexOf(CmsConstants.TPL_BASE+"/www")));
		return cmsTplManageFacade.save(path, null, true);
	}
	
	@ResponseBody
	@RequestMapping("/addFile")
	public InvokeResult addFile(HttpServletRequest request,@RequestParam("path") String dname,CmsFileDTO dto){
		String path = CommonUtil.getPath(request,dname.substring(dname.indexOf(CmsConstants.TPL_BASE+"/www")));
		return cmsTplManageFacade.save(path, dto.getContent(), false);
	}

	
	@ResponseBody
	@RequestMapping("/delDirOrFile")
	public InvokeResult delDirOrFile(HttpServletRequest request,@RequestParam String ids){
		String[] value = ids.split(",");
        String[] idArrs = new String[value.length];
        for (int i = 0; i < value.length; i ++) {
        	   idArrs[i] = CommonUtil.getPath(request,value[i].substring(value[i].indexOf(CmsConstants.TPL_BASE+"/www")));
		}
        return cmsTplManageFacade.delete(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/rename")
	public InvokeResult rename(HttpServletRequest request,@RequestParam("opath") String oname,@RequestParam("npath") String nname){
		String opath = CommonUtil.getPath(request,oname.substring(oname.indexOf(CmsConstants.TPL_BASE+"/www")));
		String npath = CommonUtil.getPath(request,nname.substring(nname.indexOf(CmsConstants.TPL_BASE+"/www")));
        return cmsTplManageFacade.rename(opath, npath);
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public InvokeResult getFile(HttpServletRequest request,@RequestParam("path") String oname){
		String opath = CommonUtil.getPath(request,oname.substring(oname.indexOf(CmsConstants.TPL_BASE+"/www")));
        return cmsTplManageFacade.get(opath);
	}
	
	@ResponseBody
	@RequestMapping("/upload")
	public InvokeResult uploadFile(HttpServletRequest request,@RequestParam("path") String oname){
		String opath = CommonUtil.getPath(request,oname.substring(oname.indexOf(CmsConstants.TPL_BASE+"/www")));
        return cmsTplManageFacade.get(opath);
	}
}
