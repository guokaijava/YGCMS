package org.pro.ygcms.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.openkoala.security.shiro.CurrentUser;
import org.pro.ygcms.facade.CmsChannelFacade;
import org.pro.ygcms.facade.CmsContentAttachmentFacade;
import org.pro.ygcms.facade.CmsContentAttrFacade;
import org.pro.ygcms.facade.CmsContentChannelFacade;
import org.pro.ygcms.facade.CmsContentCheckFacade;
import org.pro.ygcms.facade.CmsContentExtFacade;
import org.pro.ygcms.facade.CmsContentFacade;
import org.pro.ygcms.facade.CmsContentTopicFacade;
import org.pro.ygcms.facade.CmsContentTxtFacade;
import org.pro.ygcms.facade.CmsContentTypeFacade;
import org.pro.ygcms.facade.CmsModelItemFacade;
import org.pro.ygcms.facade.dto.CmsChannelDTO;
import org.pro.ygcms.facade.dto.CmsContentAttachmentDTO;
import org.pro.ygcms.facade.dto.CmsContentAttrDTO;
import org.pro.ygcms.facade.dto.CmsContentChannelDTO;
import org.pro.ygcms.facade.dto.CmsContentCheckDTO;
import org.pro.ygcms.facade.dto.CmsContentDTO;
import org.pro.ygcms.facade.dto.CmsContentExtDTO;
import org.pro.ygcms.facade.dto.CmsContentInfoDTO;
import org.pro.ygcms.facade.dto.CmsContentTopicDTO;
import org.pro.ygcms.facade.dto.CmsContentTxtDTO;
import org.pro.ygcms.facade.impl.assembler.CmsTopicFacade;
import org.pro.ygcms.web.util.Constants;
import org.pro.ygcms.web.util.DateTimeUtil;
import org.pro.ygcms.web.util.RequestUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONArray;

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
	@Inject
	private CmsChannelFacade cmsChannelFacade;
	@Inject
	private CmsContentAttachmentFacade cmsContentAttachmentFacade;
	
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
			cmsContentExtDTO.setReleaseDate(DateTimeUtil.Date2String(cmsContentDTO.getSortDate(), "yyyy-MM-dd"));
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
		cmsContentTxtDTO.setTxt(cmsContentExtDTO.getTxt());
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
	public InvokeResult update(CmsContentExtDTO cmsContentExtDTO,HttpServletRequest req) {
		// 更新CmsContent
		CmsContentDTO cmsContent = (CmsContentDTO)cmsContentFacade.getCmsContent(cmsContentExtDTO.getContentId()).getData();
		cmsContent.setTypeId(cmsContentExtDTO.getTypeId());//属性ID
		cmsContent.setTopLevel(cmsContentExtDTO.getTopLevel());//固顶级别
		// 是否有标题图
		cmsContent.setHasTitleImg(!StringUtils.isBlank(cmsContentExtDTO.getTitleImg()));
		cmsContentFacade.updateCmsContent(cmsContent);
		//更新CmsContentAttrDTO
		Map<String,String> map = RequestUtils.getRequestMap(req, "attr_");
		if(map!=null && map.size()>0){
			cmsContentAttrFacade.removeCmsContentAttrsByCId(cmsContentExtDTO.getContentId());
			for(String str : map.keySet()){
				CmsContentAttrDTO cmsContentAttrDTO = new CmsContentAttrDTO();
				cmsContentAttrDTO.setAttrName(str);
				cmsContentAttrDTO.setAttrValue(map.get(str));
				cmsContentAttrDTO.setContentId(cmsContentExtDTO.getContentId());
				cmsContentAttrFacade.creatCmsContentAttr(cmsContentAttrDTO);
			}
		}
		//更新CmsContentTxtDTO
		CmsContentTxtDTO cmsContentTxtDTO = cmsContentTxtFacade.getCmsContentTxtByCId(cmsContentExtDTO.getContentId());
		if(cmsContentTxtDTO==null){
			cmsContentTxtDTO = new CmsContentTxtDTO();
			cmsContentTxtDTO.setTxt(cmsContentExtDTO.getTxt());
			if (!cmsContentTxtDTO.isAllBlank()) {
				cmsContentTxtDTO.setContentId(cmsContentExtDTO.getContentId());
				cmsContentTxtDTO.init();
				cmsContentTxtFacade.creatCmsContentTxt(cmsContentTxtDTO);
			}
		}else{
			cmsContentExtDTO.setTxt(cmsContentExtDTO.getTxt());
			cmsContentTxtFacade.updateCmsContentTxt(cmsContentTxtDTO);
		}
		//更新CmsContentTopicDTO
		if(cmsContentExtDTO.getTopicId()!=null){
			cmsContentTopicFacade.removeCmsContentTopicsByCId(cmsContentExtDTO.getContentId());
			CmsContentTopicDTO cmsContentTopicDTO = new CmsContentTopicDTO();
			cmsContentTopicDTO.setContentId(cmsContentExtDTO.getContentId());
			cmsContentTopicDTO.setTopicId(cmsContentExtDTO.getTopicId());
			cmsContentTopicFacade.creatCmsContentTopic(cmsContentTopicDTO);
		}
		//更新CmsContentExtDTO
		cmsContentExtFacade.updateCmsContentExt(cmsContentExtDTO);
		return InvokeResult.success();
	}
	
	@ResponseBody
	@RequestMapping("/pageJson")
	public Page<CmsContentInfoDTO> pageJson(CmsContentExtDTO cced , CmsContentDTO cmsContentDTO, @RequestParam int page, @RequestParam int pagesize) {
		Page<CmsContentInfoDTO> all = cmsContentFacade.pageQueryCmsContent(cmsContentDTO, page, pagesize);
		return all;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public InvokeResult remove(@RequestParam String ids) {
		String[] idArrs = ids.split(",");
        return cmsContentFacade.removeCmsContents(idArrs);
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public Map<String, Object> get(@PathVariable String id) {
		CmsContentDTO cmsContent = (CmsContentDTO)cmsContentFacade.getCmsContent(id).getData();
		CmsContentExtDTO cmsContentExt = cmsContentExtFacade.getCmsContentExtByCId(id);
		List<CmsContentAttrDTO> cmsContentAttr = cmsContentAttrFacade.getCmsContentAttrByCId(id);
		CmsContentTxtDTO cmsContentTxt  = cmsContentTxtFacade.getCmsContentTxtByCId(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tplList", cmsModelItemFacade.getItemsByModelId(cmsContent.getModelId(),0));
		map.put("topicList", cmsTopicFacade.findAllCmsTopic());
		map.put("typeList", cmsContentTypeFacade.findAllCmsContentType());
		CmsChannelDTO cmsChannelDTO = (CmsChannelDTO) cmsChannelFacade.getCmsChannel(cmsContent.getChannelId()).getData();
		String channelName = cmsChannelDTO.getChannelName();
		CmsContentTopicDTO cmsContentTopic = cmsContentTopicFacade.getCmsContentTopicByCId(id);
		List<CmsContentAttachmentDTO> cmsContentAttachement = cmsContentAttachmentFacade.getCmsContentAttachmentByCId(id);
		map.put("channelName",channelName);
		map.put("cmsContent",cmsContent);
		map.put("cmsContentExt", cmsContentExt);
		map.put("cmsContentAttr", cmsContentAttr);
		map.put("cmsContentTxt", cmsContentTxt);
		map.put("cmsContentTopic", cmsContentTopic);
		map.put("cmsContentAttachment", cmsContentAttachement);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")
	public  String fileUpload(CmsContentAttachmentDTO cmsContentAttachment,HttpServletRequest request,@RequestParam("ufile") MultipartFile ufile) {
        	if(request.getHeader("content-type")!=null&&"application/x-www-form-urlencoded".equals(request.getHeader("content-type"))){
            	 return null;//不支持断点续传，直接返回null即可
        	}
        	JSONArray map = new JSONArray();
            if(!ufile.isEmpty()){
            	String localpath = Constants.BASEPICUPLOADPATH+DateTimeUtil.Date2String(new Date(),"YYYYMMDD");
                String serverPath=request.getSession().getServletContext().getRealPath("/");
                String originFileName=ufile.getOriginalFilename();
                String suffix=originFileName.split("\\.")[originFileName.split("\\.").length-1];
                String base64Name=UUID.randomUUID().toString()+"."+suffix;
                File file =  new File(serverPath+localpath,base64Name);
                try {
                    FileUtils.copyInputStreamToFile(ufile.getInputStream(),file);//存储文件
                    //WaterMarkUtil.pressImage(serverPath+Constants.WATER_IMG_PTAH, file.getAbsolutePath(), 0, 0);
                    cmsContentAttachment.setAttachmentPath(localpath+"/"+base64Name);
                    cmsContentAttachment.setAttachmentName(base64Name);
                    cmsContentAttachment.setFilename(originFileName);
                    cmsContentAttachment.setId(UUID.randomUUID().toString());
                    // 保存附件
                    cmsContentAttachmentFacade.creatCmsContentAttachment(cmsContentAttachment);
                } catch (IOException e) {
                    e.printStackTrace();
                }  
            }
            map.add(cmsContentAttachment);
        return map.toString();	
	}
	
	@ResponseBody
	@RequestMapping("/removefile/{id}")
	public  InvokeResult removeUFile(@PathVariable String id){
		return cmsContentAttachmentFacade.removeCmsContentAttachment(id);
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
