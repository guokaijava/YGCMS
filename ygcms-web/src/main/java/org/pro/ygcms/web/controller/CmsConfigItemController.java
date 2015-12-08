package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsConfigItemFacade;
import org.pro.ygcms.facade.dto.CmsConfigItemDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsConfigItem")
public class CmsConfigItemController {
		
	@Inject
	private CmsConfigItemFacade cmsConfigItemFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsConfigItemDTO cmsConfigItemDTO) {
		return cmsConfigItemFacade.creatCmsConfigItem(cmsConfigItemDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsConfigItemDTO cmsConfigItemDTO) {
		return cmsConfigItemFacade.updateCmsConfigItem(cmsConfigItemDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsConfigItemDTO cmsConfigItemDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsConfigItemDTO> all = cmsConfigItemFacade.pageQueryCmsConfigItem(cmsConfigItemDTO, page, pagesize);
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
        return cmsConfigItemFacade.removeCmsConfigItems(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return cmsConfigItemFacade.getCmsConfigItem(id);
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
