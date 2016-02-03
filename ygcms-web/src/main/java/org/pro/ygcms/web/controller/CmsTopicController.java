package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.CmsTopicDTO;
import org.pro.ygcms.facade.impl.assembler.CmsTopicFacade;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsTopic")
public class CmsTopicController {
		
	@Inject
	private CmsTopicFacade cmsTopicFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsTopicDTO cmsTopicDTO) {
		return cmsTopicFacade.creatCmsTopic(cmsTopicDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsTopicDTO cmsTopicDTO) {
		return cmsTopicFacade.updateCmsTopic(cmsTopicDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsTopicDTO cmsTopicDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsTopicDTO> all = cmsTopicFacade.pageQueryCmsTopic(cmsTopicDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] value = ids.split(",");
        String[] idArrs = new String[value.length];
        for (int i = 0; i < value.length; i ++) {
        					idArrs[i] = value[i];
			        				        }
        return cmsTopicFacade.removeCmsTopics(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable String id) {
		return cmsTopicFacade.getCmsTopic(id);
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
