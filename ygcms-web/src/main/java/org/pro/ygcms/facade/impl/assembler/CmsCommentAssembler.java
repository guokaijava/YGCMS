package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.comment.*;

public class CmsCommentAssembler {
	
	public static CmsCommentDTO  toDTO(CmsComment  cmsComment){
		if (cmsComment == null) {
			return null;
		}
    	CmsCommentDTO result  = new CmsCommentDTO();
	    	result.setId (cmsComment.getId());
     	    	result.setVersion (cmsComment.getVersion());
     	    	result.setCommentUserId (cmsComment.getCommentUserId());
     	    	result.setReplyUserId (cmsComment.getReplyUserId());
     	    	result.setContentId (cmsComment.getContentId());
     	    	result.setSiteId (cmsComment.getSiteId());
     	    	result.setCreateTime (cmsComment.getCreateTime());
     	    	result.setReplyTime (cmsComment.getReplyTime());
     	    	result.setUps (cmsComment.getUps());
     	    	result.setDowns (cmsComment.getDowns());
     	    	result.setIsRecommend (cmsComment.getIsRecommend());
     	    	result.setIsChecked (cmsComment.getIsChecked());
     	    	result.setScore (cmsComment.getScore());
     	    return result;
	 }
	
	public static List<CmsCommentDTO>  toDTOs(Collection<CmsComment>  cmsComments){
		if (cmsComments == null) {
			return null;
		}
		List<CmsCommentDTO> results = new ArrayList<CmsCommentDTO>();
		for (CmsComment each : cmsComments) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsComment  toEntity(CmsCommentDTO  cmsCommentDTO){
	 	if (cmsCommentDTO == null) {
			return null;
		}
	 	CmsComment result  = new CmsComment();
        result.setId (cmsCommentDTO.getId());
         result.setVersion (cmsCommentDTO.getVersion());
         result.setCommentUserId (cmsCommentDTO.getCommentUserId());
         result.setReplyUserId (cmsCommentDTO.getReplyUserId());
         result.setContentId (cmsCommentDTO.getContentId());
         result.setSiteId (cmsCommentDTO.getSiteId());
         result.setCreateTime (cmsCommentDTO.getCreateTime());
         result.setReplyTime (cmsCommentDTO.getReplyTime());
         result.setUps (cmsCommentDTO.getUps());
         result.setDowns (cmsCommentDTO.getDowns());
         result.setIsRecommend (cmsCommentDTO.getIsRecommend());
         result.setIsChecked (cmsCommentDTO.getIsChecked());
         result.setScore (cmsCommentDTO.getScore());
 	  	return result;
	 }
	
	public static List<CmsComment> toEntities(Collection<CmsCommentDTO> cmsCommentDTOs) {
		if (cmsCommentDTOs == null) {
			return null;
		}
		
		List<CmsComment> results = new ArrayList<CmsComment>();
		for (CmsCommentDTO each : cmsCommentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
