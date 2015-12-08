package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentAssembler {
	
	public static CmsContentDTO  toDTO(CmsContent  cmsContent){
		if (cmsContent == null) {
			return null;
		}
    	CmsContentDTO result  = new CmsContentDTO();
	    	result.setId (cmsContent.getId());
     	    	result.setVersion (cmsContent.getVersion());
     	    	result.setChannelId (cmsContent.getChannelId());
     	    	result.setUserId (cmsContent.getUserId());
     	    	result.setTypeId (cmsContent.getTypeId());
     	    	result.setModelId (cmsContent.getModelId());
     	    	result.setSiteId (cmsContent.getSiteId());
     	    	result.setSortDate (cmsContent.getSortDate());
     	    	result.setTopLevel (cmsContent.getTopLevel());
     	    	result.setHasTitleImg (cmsContent.getHasTitleImg());
     	    	result.setIsRecommend (cmsContent.getIsRecommend());
     	    	result.setStatus (cmsContent.getStatus());
     	    	result.setViewsDay (cmsContent.getViewsDay());
     	    	result.setCommentsDay (cmsContent.getCommentsDay());
     	    	result.setDownloadsDay (cmsContent.getDownloadsDay());
     	    	result.setUpsDay (cmsContent.getUpsDay());
     	    	result.setScore (cmsContent.getScore());
     	    return result;
	 }
	
	public static List<CmsContentDTO>  toDTOs(Collection<CmsContent>  cmsContents){
		if (cmsContents == null) {
			return null;
		}
		List<CmsContentDTO> results = new ArrayList<CmsContentDTO>();
		for (CmsContent each : cmsContents) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContent  toEntity(CmsContentDTO  cmsContentDTO){
	 	if (cmsContentDTO == null) {
			return null;
		}
	 	CmsContent result  = new CmsContent();
        result.setId (cmsContentDTO.getId());
         result.setVersion (cmsContentDTO.getVersion());
         result.setChannelId (cmsContentDTO.getChannelId());
         result.setUserId (cmsContentDTO.getUserId());
         result.setTypeId (cmsContentDTO.getTypeId());
         result.setModelId (cmsContentDTO.getModelId());
         result.setSiteId (cmsContentDTO.getSiteId());
         result.setSortDate (cmsContentDTO.getSortDate());
         result.setTopLevel (cmsContentDTO.getTopLevel());
         result.setHasTitleImg (cmsContentDTO.getHasTitleImg());
         result.setIsRecommend (cmsContentDTO.getIsRecommend());
         result.setStatus (cmsContentDTO.getStatus());
         result.setViewsDay (cmsContentDTO.getViewsDay());
         result.setCommentsDay (cmsContentDTO.getCommentsDay());
         result.setDownloadsDay (cmsContentDTO.getDownloadsDay());
         result.setUpsDay (cmsContentDTO.getUpsDay());
         result.setScore (cmsContentDTO.getScore());
 	  	return result;
	 }
	
	public static List<CmsContent> toEntities(Collection<CmsContentDTO> cmsContentDTOs) {
		if (cmsContentDTOs == null) {
			return null;
		}
		
		List<CmsContent> results = new ArrayList<CmsContent>();
		for (CmsContentDTO each : cmsContentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
