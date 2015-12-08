package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsConfigAttrFacade;
import org.pro.ygcms.facade.dto.CmsConfigAttrDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsConfigAttr")
public class CmsConfigAttrController {
		
	@Inject
	private CmsConfigAttrFacade cmsConfigAttrFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsConfigAttrDTO cmsConfigAttrDTO) {
		return cmsConfigAttrFacade.creatCmsConfigAttr(cmsConfigAttrDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsConfigAttrDTO cmsConfigAttrDTO) {
		return cmsConfigAttrFacade.updateCmsConfigAttr(cmsConfigAttrDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsConfigAttrDTO cmsConfigAttrDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsConfigAttrDTO> all = cmsConfigAttrFacade.pageQueryCmsConfigAttr(cmsConfigAttrDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
        Long[] idArrs = new Long[value.length];
        for (int i = 0; i < value.length; i ++) {
        	        					idArrs[i] = Long.parseLong(value[i]);
						        }
        return cmsConfigAttrFacade.removeCmsConfigAttrs(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return cmsConfigAttrFacade.getCmsConfigAttr(id);
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
