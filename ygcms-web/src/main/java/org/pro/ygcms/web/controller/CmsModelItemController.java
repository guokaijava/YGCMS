package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsModelItemFacade;
import org.pro.ygcms.facade.dto.CmsModelItemDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsModelItem")
public class CmsModelItemController {
		
	@Inject
	private CmsModelItemFacade cmsModelItemFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsModelItemDTO cmsModelItemDTO) {
		return cmsModelItemFacade.creatCmsModelItem(cmsModelItemDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsModelItemDTO cmsModelItemDTO) {
		return cmsModelItemFacade.updateCmsModelItem(cmsModelItemDTO);
	}
	
	@ResponseBody
	@RequestMapping("/getItemsByPid/{pid}")
	public List<CmsModelItemDTO> getItemsByPid(@PathVariable String pid) {
		return cmsModelItemFacade.getItemsByModelId(pid,1);
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsModelItemDTO cmsModelItemDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsModelItemDTO> all = cmsModelItemFacade.pageQueryCmsModelItem(cmsModelItemDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
        return cmsModelItemFacade.removeCmsModelItems(value);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable String id) {
		return cmsModelItemFacade.getCmsModelItem(id);
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
