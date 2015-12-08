package org.pro.ygcms.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.core.common.CmsConstants;
import org.pro.ygcms.facade.CmsResourceFacade;
import org.pro.ygcms.facade.dto.CmsFileDTO;
import org.pro.ygcms.facade.dto.CmsResourceDTO;
import org.pro.ygcms.web.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsResource")
public class CmsResourceController {
	
	@Inject
	private CmsResourceFacade cmsResourceFacade;
	
	
	@ResponseBody
	@RequestMapping("/tree")
	public Map<String, Object> getOrgTree(HttpServletRequest request) {
		String realpath=CommonUtil.getPath(request,CmsConstants.RES_PATH+"/www");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resoureceTree", cmsResourceFacade.getChild(realpath));
		return dataMap;
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public Page<CmsResourceDTO> getFileList(HttpServletRequest request,@RequestParam("path") String dname) {
		String realpath="";
		if(dname.equals("")){
			realpath=CommonUtil.getPath(request,CmsConstants.RES_PATH+"/www");
		}else{
			realpath = CommonUtil.getPath(request,dname.substring(dname.indexOf(CmsConstants.RES_PATH+"/www")));
		}
		return new Page<CmsResourceDTO>(0,Integer.MAX_VALUE,cmsResourceFacade.getListFileByPDir(realpath));
	}
	
	@ResponseBody
	@RequestMapping("/addDir")
	public InvokeResult addDir(HttpServletRequest request,@RequestParam("path") String dname){
		String path = CommonUtil.getPath(request,dname.substring(dname.indexOf(CmsConstants.RES_PATH+"/www")));
		return cmsResourceFacade.save(path, null, true);
	}
	
	@ResponseBody
	@RequestMapping("/addFile")
	public InvokeResult addFile(HttpServletRequest request,@RequestParam("path") String dname,CmsFileDTO dto){
		String path = CommonUtil.getPath(request,dname.substring(dname.indexOf(CmsConstants.RES_PATH+"/www")));
		return cmsResourceFacade.save(path, dto.getContent(), false);
	}

	
	@ResponseBody
	@RequestMapping("/delDirOrFile")
	public InvokeResult delDirOrFile(HttpServletRequest request,@RequestParam String ids){
		String[] value = ids.split(",");
        String[] idArrs = new String[value.length];
        for (int i = 0; i < value.length; i ++) {
        	   idArrs[i] = CommonUtil.getPath(request,value[i].substring(value[i].indexOf(CmsConstants.RES_PATH+"/www")));
		}
        return cmsResourceFacade.delete(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/rename")
	public InvokeResult rename(HttpServletRequest request,@RequestParam("opath") String oname,@RequestParam("npath") String nname){
		String opath = CommonUtil.getPath(request,oname.substring(oname.indexOf(CmsConstants.RES_PATH+"/www")));
		String npath = CommonUtil.getPath(request,nname.substring(nname.indexOf(CmsConstants.RES_PATH+"/www")));
        return cmsResourceFacade.rename(opath, npath);
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public InvokeResult getFile(HttpServletRequest request,@RequestParam("path") String oname){
		String opath = CommonUtil.getPath(request,oname.substring(oname.indexOf(CmsConstants.RES_PATH+"/www")));
        return cmsResourceFacade.get(opath);
	}
	
	@ResponseBody
	@RequestMapping("/upload")
	public InvokeResult uploadFile(HttpServletRequest request,@RequestParam("path") String oname){
		String opath = CommonUtil.getPath(request,oname.substring(oname.indexOf(CmsConstants.RES_PATH+"/www")));
        return cmsResourceFacade.get(opath);
	}
}
