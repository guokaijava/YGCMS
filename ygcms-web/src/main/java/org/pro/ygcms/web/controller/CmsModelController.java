package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsModelFacade;
import org.pro.ygcms.facade.dto.CmsModelDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsModel")
public class CmsModelController {
		
	@Inject
	private CmsModelFacade cmsModelFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsModelDTO cmsModelDTO) {
		return cmsModelFacade.creatCmsModel(cmsModelDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsModelDTO cmsModelDTO) {
		return cmsModelFacade.updateCmsModel(cmsModelDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsModelDTO cmsModelDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsModelDTO> all = cmsModelFacade.pageQueryCmsModel(cmsModelDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
        return cmsModelFacade.removeCmsModels(value);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable String id) {
		return cmsModelFacade.getCmsModel(id);
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
