package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsSiteFacade;
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
@RequestMapping("/CmsSite")
public class CmsSiteController {
		
	@Inject
	private CmsSiteFacade cmsSiteFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsSiteDTO cmsSiteDTO) {
		System.out.println("#############");
	    System.out.println(cmsSiteDTO.getDomain());
		return cmsSiteFacade.creatCmsSite(cmsSiteDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsSiteDTO cmsSiteDTO) {
		return cmsSiteFacade.updateCmsSite(cmsSiteDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsSiteDTO cmsSiteDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsSiteDTO> all = cmsSiteFacade.pageQueryCmsSite(cmsSiteDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
        return cmsSiteFacade.removeCmsSites(value);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable String id) {
		return cmsSiteFacade.getCmsSite(id);
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
