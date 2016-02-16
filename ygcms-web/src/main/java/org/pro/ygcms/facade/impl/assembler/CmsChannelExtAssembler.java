package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.channel.*;

public class CmsChannelExtAssembler {
	
	public static CmsChannelExtDTO  toDTO(CmsChannelExt  cmsChannelExt){
		if (cmsChannelExt == null) {
			return null;
		}
    	CmsChannelExtDTO result  = new CmsChannelExtDTO();
	    	result.setId (cmsChannelExt.getId());
     	    	result.setVersion (cmsChannelExt.getVersion());
     	    	result.setChannelId (cmsChannelExt.getChannelId());
     	    	result.setChannelName (cmsChannelExt.getChannelName());
     	    	result.setFinalStep (cmsChannelExt.getFinalStep());
     	    	result.setAfterCheck (cmsChannelExt.getAfterCheck());
     	    	result.setIsStaticChannel (cmsChannelExt.getIsStaticChannel());
     	    	result.setIsStaticContent (cmsChannelExt.getIsStaticContent());
     	    	result.setIsAccessByDir (cmsChannelExt.getIsAccessByDir());
     	    	result.setIsListChild (cmsChannelExt.getIsListChild());
     	    	result.setPageSize (cmsChannelExt.getPageSize());
     	    	result.setChannelRule (cmsChannelExt.getChannelRule());
     	    	result.setContentRule (cmsChannelExt.getContentRule());
     	    	result.setLink (cmsChannelExt.getLink());
     	    	result.setTplChannel (cmsChannelExt.getTplChannel());
     	    	result.setTplContent (cmsChannelExt.getTplContent());
     	    	result.setTitleImg (cmsChannelExt.getTitleImg());
     	    	result.setContentImg (cmsChannelExt.getContentImg());
     	    	result.setHasTitleImg (cmsChannelExt.getHasTitleImg());
     	    	result.setHasContentImg (cmsChannelExt.getHasContentImg());
     	    	result.setTitleImgWidth (cmsChannelExt.getTitleImgWidth());
     	    	result.setTitleImgHeight (cmsChannelExt.getTitleImgHeight());
     	    	result.setContentImgWidth (cmsChannelExt.getContentImgWidth());
     	    	result.setContentImgHeight (cmsChannelExt.getContentImgHeight());
     	    	result.setCommentControl (cmsChannelExt.getCommentControl());
     	    	result.setAllowUpdown (cmsChannelExt.getAllowUpdown());
     	    	result.setIsBlank (cmsChannelExt.getIsBlank());
     	    	result.setTitle (cmsChannelExt.getTitle());
     	    	result.setKeywords (cmsChannelExt.getKeywords());
     	    	result.setDescription (cmsChannelExt.getDescription());
     	    	result.setAllowShare (cmsChannelExt.getAllowShare());
     	    	result.setAllowScore (cmsChannelExt.getAllowScore());
     	    return result;
	 }
	
	public static List<CmsChannelExtDTO>  toDTOs(Collection<CmsChannelExt>  cmsChannelExts){
		if (cmsChannelExts == null) {
			return null;
		}
		List<CmsChannelExtDTO> results = new ArrayList<CmsChannelExtDTO>();
		for (CmsChannelExt each : cmsChannelExts) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsChannelExt  toEntity(CmsChannelExtDTO  cmsChannelExtDTO){
	 	if (cmsChannelExtDTO == null) {
			return null;
		}
	 	CmsChannelExt result  = new CmsChannelExt();
        result.setId (cmsChannelExtDTO.getId());
         result.setVersion (cmsChannelExtDTO.getVersion());
         result.setChannelId (cmsChannelExtDTO.getChannelId());
         result.setChannelName (cmsChannelExtDTO.getChannelName());
         result.setFinalStep (cmsChannelExtDTO.getFinalStep()==null?1:cmsChannelExtDTO.getFinalStep());
         result.setAfterCheck (cmsChannelExtDTO.getAfterCheck()==null?1:cmsChannelExtDTO.getAfterCheck());
         result.setIsStaticChannel (cmsChannelExtDTO.getIsStaticChannel()==null?"":cmsChannelExtDTO.getIsStaticChannel());
         result.setIsStaticContent (cmsChannelExtDTO.getIsStaticContent()==null?"":cmsChannelExtDTO.getIsStaticContent());
         result.setIsAccessByDir (cmsChannelExtDTO.getIsAccessByDir()==null?"":cmsChannelExtDTO.getIsAccessByDir());
         result.setIsListChild (cmsChannelExtDTO.getIsListChild()==null?"":cmsChannelExtDTO.getIsListChild());
         result.setPageSize (cmsChannelExtDTO.getPageSize()==null?20:cmsChannelExtDTO.getPageSize());
         result.setChannelRule (cmsChannelExtDTO.getChannelRule()==null?"":cmsChannelExtDTO.getChannelRule());
         result.setContentRule (cmsChannelExtDTO.getContentRule()==null?"":cmsChannelExtDTO.getContentRule());
         result.setLink (cmsChannelExtDTO.getLink()==null?"":cmsChannelExtDTO.getLink());
         result.setTplChannel (cmsChannelExtDTO.getTplChannel()==null?"":cmsChannelExtDTO.getTplChannel());
         result.setTplContent (cmsChannelExtDTO.getTplContent()==null?"":cmsChannelExtDTO.getTplContent());
         result.setTitleImg (cmsChannelExtDTO.getTitleImg()==null?"":cmsChannelExtDTO.getTitleImg());
         result.setContentImg (cmsChannelExtDTO.getContentImg()==null?"":cmsChannelExtDTO.getContentImg());
         result.setHasTitleImg (cmsChannelExtDTO.getHasTitleImg()==null?true:cmsChannelExtDTO.getHasTitleImg());
         result.setHasContentImg (cmsChannelExtDTO.getHasContentImg()==null?true:cmsChannelExtDTO.getHasContentImg());
         result.setTitleImgWidth (cmsChannelExtDTO.getTitleImgWidth()==null?100:cmsChannelExtDTO.getTitleImgWidth());
         result.setTitleImgHeight (cmsChannelExtDTO.getTitleImgHeight()==null?100:cmsChannelExtDTO.getTitleImgHeight());
         result.setContentImgWidth (cmsChannelExtDTO.getContentImgWidth()==null?100:cmsChannelExtDTO.getContentImgWidth());
         result.setContentImgHeight (cmsChannelExtDTO.getContentImgHeight()==null?100:cmsChannelExtDTO.getContentImgHeight());
         result.setCommentControl (cmsChannelExtDTO.getCommentControl()==null?1:cmsChannelExtDTO.getCommentControl());
         result.setAllowUpdown (cmsChannelExtDTO.getAllowUpdown()==null?true:cmsChannelExtDTO.getAllowUpdown());
         result.setIsBlank (cmsChannelExtDTO.getIsBlank()==null?true:cmsChannelExtDTO.getIsBlank());
         result.setTitle (cmsChannelExtDTO.getTitle()==null?"":cmsChannelExtDTO.getTitle());
         result.setKeywords (cmsChannelExtDTO.getKeywords()==null?"":cmsChannelExtDTO.getKeywords());
         result.setDescription (cmsChannelExtDTO.getDescription()==null?"":cmsChannelExtDTO.getDescription());
         result.setAllowShare (cmsChannelExtDTO.getAllowShare()==null?true:cmsChannelExtDTO.getAllowShare());
         result.setAllowScore (cmsChannelExtDTO.getAllowScore()==null?true:cmsChannelExtDTO.getAllowScore());
 	  	return result;
	 }
	
	public static List<CmsChannelExt> toEntities(Collection<CmsChannelExtDTO> cmsChannelExtDTOs) {
		if (cmsChannelExtDTOs == null) {
			return null;
		}
		
		List<CmsChannelExt> results = new ArrayList<CmsChannelExt>();
		for (CmsChannelExtDTO each : cmsChannelExtDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
