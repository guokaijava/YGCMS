package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsContentPictureFacade;
import org.pro.ygcms.facade.dto.CmsContentPictureDTO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsContentPicture")
public class CmsContentPictureController {
		
	@Inject
	private CmsContentPictureFacade cmsContentPictureFacade;
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsContentPictureDTO cmsContentPictureDTO) {
		return cmsContentPictureFacade.creatCmsContentPicture(cmsContentPictureDTO);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsContentPictureDTO cmsContentPictureDTO) {
		return cmsContentPictureFacade.updateCmsContentPicture(cmsContentPictureDTO);
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page pageJson(CmsContentPictureDTO cmsContentPictureDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsContentPictureDTO> all = cmsContentPictureFacade.pageQueryCmsContentPicture(cmsContentPictureDTO, page, pagesize);
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
        return cmsContentPictureFacade.removeCmsContentPictures(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public InvokeResult get(@PathVariable Long id) {
		return cmsContentPictureFacade.getCmsContentPicture(id);
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
