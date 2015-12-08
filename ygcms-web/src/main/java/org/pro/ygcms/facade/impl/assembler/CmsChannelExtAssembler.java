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
         result.setFinalStep (cmsChannelExtDTO.getFinalStep());
         result.setAfterCheck (cmsChannelExtDTO.getAfterCheck());
         result.setIsStaticChannel (cmsChannelExtDTO.getIsStaticChannel());
         result.setIsStaticContent (cmsChannelExtDTO.getIsStaticContent());
         result.setIsAccessByDir (cmsChannelExtDTO.getIsAccessByDir());
         result.setIsListChild (cmsChannelExtDTO.getIsListChild());
         result.setPageSize (cmsChannelExtDTO.getPageSize());
         result.setChannelRule (cmsChannelExtDTO.getChannelRule());
         result.setContentRule (cmsChannelExtDTO.getContentRule());
         result.setLink (cmsChannelExtDTO.getLink());
         result.setTplChannel (cmsChannelExtDTO.getTplChannel());
         result.setTplContent (cmsChannelExtDTO.getTplContent());
         result.setTitleImg (cmsChannelExtDTO.getTitleImg());
         result.setContentImg (cmsChannelExtDTO.getContentImg());
         result.setHasTitleImg (cmsChannelExtDTO.getHasTitleImg());
         result.setHasContentImg (cmsChannelExtDTO.getHasContentImg());
         result.setTitleImgWidth (cmsChannelExtDTO.getTitleImgWidth());
         result.setTitleImgHeight (cmsChannelExtDTO.getTitleImgHeight());
         result.setContentImgWidth (cmsChannelExtDTO.getContentImgWidth());
         result.setContentImgHeight (cmsChannelExtDTO.getContentImgHeight());
         result.setCommentControl (cmsChannelExtDTO.getCommentControl());
         result.setAllowUpdown (cmsChannelExtDTO.getAllowUpdown());
         result.setIsBlank (cmsChannelExtDTO.getIsBlank());
         result.setTitle (cmsChannelExtDTO.getTitle());
         result.setKeywords (cmsChannelExtDTO.getKeywords());
         result.setDescription (cmsChannelExtDTO.getDescription());
         result.setAllowShare (cmsChannelExtDTO.getAllowShare());
         result.setAllowScore (cmsChannelExtDTO.getAllowScore());
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
