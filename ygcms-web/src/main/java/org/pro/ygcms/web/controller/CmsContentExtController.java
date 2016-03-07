package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsContentExtFacade;
import org.pro.ygcms.facade.dto.CmsContentExtDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsContentExt")
public class CmsContentExtController {
		
	@Inject
	private CmsContentExtFacade cmsContentExtFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public String add(CmsContentExtDTO cmsContentExtDTO) {
		return cmsContentExtFacade.creatCmsContentExt(cmsContentExtDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsContentExtDTO cmsContentExtDTO) {
		return cmsContentExtFacade.updateCmsContentExt(cmsContentExtDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsContentExtDTO cmsContentExtDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsContentExtDTO> all = cmsContentExtFacade.pageQueryCmsContentExt(cmsContentExtDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] idArrs = ids.split(",");
        return cmsContentExtFacade.removeCmsContentExts(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable String id) {
		return cmsContentExtFacade.getCmsContentExt(id);
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
