package org.pro.ygcms.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;
import org.pro.ygcms.core.web.Constants;
import org.pro.ygcms.facade.CmsContentAttrFacade;
import org.pro.ygcms.facade.CmsContentChannelFacade;
import org.pro.ygcms.facade.CmsContentCheckFacade;
import org.pro.ygcms.facade.CmsContentExtFacade;
import org.pro.ygcms.facade.CmsContentFacade;
import org.pro.ygcms.facade.CmsContentTopicFacade;
import org.pro.ygcms.facade.CmsContentTxtFacade;
import org.pro.ygcms.facade.CmsContentTypeFacade;
import org.pro.ygcms.facade.CmsModelItemFacade;
import org.pro.ygcms.facade.dto.CmsChannelAttrDTO;
import org.pro.ygcms.facade.dto.CmsChannelDTO;
import org.pro.ygcms.facade.dto.CmsChannelExtDTO;
import org.pro.ygcms.facade.dto.CmsChannelTxtDTO;
import org.pro.ygcms.facade.dto.CmsContentAttrDTO;
import org.pro.ygcms.facade.dto.CmsContentChannelDTO;
import org.pro.ygcms.facade.dto.CmsContentCheckDTO;
import org.pro.ygcms.facade.dto.CmsContentDTO;
import org.pro.ygcms.facade.dto.CmsContentExtDTO;
import org.pro.ygcms.facade.dto.CmsContentInfoDTO;
import org.pro.ygcms.facade.dto.CmsContentTopicDTO;
import org.pro.ygcms.facade.dto.CmsContentTxtDTO;
import org.pro.ygcms.facade.dto.CmsTopicDTO;
import org.pro.ygcms.facade.impl.assembler.CmsTopicFacade;
import org.pro.ygcms.web.util.RequestUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/CmsContent")
public class CmsContentController {
		
	@Inject
	private CmsContentFacade cmsContentFacade;
	@Inject
	private CmsContentExtFacade cmsContentExtFacade;
	@Inject
	private CmsContentAttrFacade cmsContentAttrFacade;
	@Inject
	private CmsContentTxtFacade cmsContentTxtFacade;
	@Inject
	private CmsContentCheckFacade cmsContentCheckFacade;
	@Inject
	private CmsContentChannelFacade cmsContentChannelFacade;
	@Inject
	private CmsContentTopicFacade cmsContentTopicFacade;
	@Inject
	private CmsModelItemFacade cmsModelItemFacade;
	@Inject
	private CmsTopicFacade cmsTopicFacade;
	@Inject
	private CmsContentTypeFacade cmsContentTypeFacade;
	
	@ResponseBody
	@RequestMapping("/toAdd")
	public Map<String,Object> toAdd(@RequestParam String modelId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tplList", cmsModelItemFacade.getItemsByModelId(modelId,0));
		map.put("topicList", cmsTopicFacade.findAllCmsTopic());
		map.put("typeList", cmsContentTypeFacade.findAllCmsContentType());
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public InvokeResult add(CmsContentExtDTO cmsContentExtDTO,HttpServletRequest req) {
		
		CmsContentDTO cmsContentDTO = new CmsContentDTO();
		cmsContentDTO.setUserId(CurrentUser.getUserAccount());
		cmsContentDTO.setChannelId(cmsContentExtDTO.getChannelId());
		cmsContentDTO.setTypeId(cmsContentExtDTO.getTypeId());
		cmsContentDTO.setModelId(cmsContentExtDTO.getModelId());
		cmsContentDTO.setSiteId(cmsContentExtDTO.getSiteId());
		cmsContentDTO.setTopLevel(cmsContentExtDTO.getTopLevel());
		// 是否有标题图
		cmsContentDTO.setHasTitleImg(!StringUtils.isBlank(cmsContentExtDTO.getTitleImg()));
		cmsContentDTO.setStatus((short)Constants.CONTENT_CHECK_CHECKING);
		cmsContentDTO.init();
		// 插入成功后返回Id
		String content_id = cmsContentFacade.creatCmsContent(cmsContentDTO);
		
		//新增CmsContentExtDTO
		cmsContentExtDTO.setContentId(content_id);
		if (cmsContentExtDTO.getReleaseDate() == null) {
			cmsContentExtDTO.setReleaseDate(cmsContentDTO.getSortDate());
		}
		cmsContentExtDTO.init();
		cmsContentExtFacade.creatCmsContentExt(cmsContentExtDTO);
		
		//新增CmsContentAttrDTO
		Map<String,String> map = RequestUtils.getRequestMap(req, "attr_");
		for(String str : map.keySet()){
			CmsContentAttrDTO cmsContentAttrDTO = new CmsContentAttrDTO();
			cmsContentAttrDTO.setAttrName(str);
			cmsContentAttrDTO.setAttrValue(map.get(str));
			cmsContentAttrDTO.setContentId(content_id);
			cmsContentAttrFacade.creatCmsContentAttr(cmsContentAttrDTO);
		}
		
		//新增CmsContentTxtDTO
		CmsContentTxtDTO cmsContentTxtDTO = new CmsContentTxtDTO();
		cmsContentExtDTO.setTxt(cmsContentExtDTO.getTxt());
		if (!cmsContentTxtDTO.isAllBlank()) {
			cmsContentTxtDTO.setContentId(content_id);
			cmsContentTxtDTO.init();
			cmsContentTxtFacade.creatCmsContentTxt(cmsContentTxtDTO);
		}
		
		//新增CmsContentCheckDTO
		CmsContentCheckDTO cmsContentCheckDTO = new CmsContentCheckDTO();
		cmsContentCheckDTO.setContentId(content_id);
		cmsContentCheckDTO.init();
		cmsContentCheckFacade.creatCmsContentCheck(cmsContentCheckDTO);
		
		/*//新增CmsContentTagDTO
		String[] tagArr = StringUtils.split(cmsContentExtDTO.getTagStr(), ",");
		CmsContentTagDTO cmsContentTagDTO = new CmsContentTagDTO();
		cmsContentTagDTO.setTagName(cmsContentExtDTO.getTagStr());
		cmsContentTagFacade.creatCmsContentTag(cmsContentTagDTO);*/
		
		//新增CmsContentChannelDTO
		CmsContentChannelDTO cmsContentChannelDTO = new CmsContentChannelDTO();
		cmsContentChannelDTO.setContentId(content_id);
		cmsContentChannelDTO.setChannelId(cmsContentExtDTO.getChannelId());
		cmsContentChannelFacade.creatCmsContentChannel(cmsContentChannelDTO);
		
		//新增CmsContentTopicDTO
		if(cmsContentExtDTO.getTopicId()!=null){
			CmsContentTopicDTO cmsContentTopicDTO = new CmsContentTopicDTO();
			cmsContentTopicDTO.setContentId(content_id);
			cmsContentTopicDTO.setTopicId(cmsContentExtDTO.getTopicId());
			cmsContentTopicFacade.creatCmsContentTopic(cmsContentTopicDTO);
		}
		return InvokeResult.success();
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public InvokeResult update(CmsContentDTO cmsContentDTO,HttpServletRequest req) {
		// 插入CmsContent
//		return cmsContentFacade.updateCmsContent(cmsContentDTO);
		System.out.println(223);
		return InvokeResult.success();
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page<CmsContentInfoDTO> pageJson(CmsContentDTO cmsContentDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsContentInfoDTO> all = cmsContentFacade.pageQueryCmsContent(cmsContentDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] idArrs = ids.split(",");
        return cmsContentFacade.removeCmsContents(idArrs);
//		return InvokeResult.success();
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public Map<String, Object> get(@PathVariable String id) {
		CmsContentDTO cmsContent = (CmsContentDTO)cmsContentFacade.getCmsContent(id).getData();
		CmsContentExtDTO CmsContentExt = cmsContentExtFacade.getCmsContentExtByCId(id);
		List<CmsContentAttrDTO> cmsContentAttr = cmsContentAttrFacade.getCmsContentAttrByCId(id);
		CmsContentTxtDTO cmsContentTxt  = cmsContentTxtFacade.getCmsContentTxtByCId(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tplList", cmsModelItemFacade.getItemsByModelId(cmsContent.getModelId(),0));
		map.put("topicList", cmsTopicFacade.findAllCmsTopic());
		map.put("typeList", cmsContentTypeFacade.findAllCmsContentType());
		map.put("cmsContent",cmsContent);
		map.put("CmsContentExt", CmsContentExt);
		map.put("cmsContentAttr", cmsContentAttr);
		map.put("cmsContentTxt", cmsContentTxt);
		return map;
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
