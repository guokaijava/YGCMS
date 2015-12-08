package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsChannelTxtFacade;
import org.pro.ygcms.facade.dto.CmsChannelTxtDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsChannelTxt")
public class CmsChannelTxtController {
		
	@Inject
	private CmsChannelTxtFacade cmsChannelTxtFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsChannelTxtDTO cmsChannelTxtDTO) {
		return cmsChannelTxtFacade.creatCmsChannelTxt(cmsChannelTxtDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsChannelTxtDTO cmsChannelTxtDTO) {
		return cmsChannelTxtFacade.updateCmsChannelTxt(cmsChannelTxtDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsChannelTxtDTO cmsChannelTxtDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsChannelTxtDTO> all = cmsChannelTxtFacade.pageQueryCmsChannelTxt(cmsChannelTxtDTO, page, pagesize);
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
        return cmsChannelTxtFacade.removeCmsChannelTxts(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return cmsChannelTxtFacade.getCmsChannelTxt(id);
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
