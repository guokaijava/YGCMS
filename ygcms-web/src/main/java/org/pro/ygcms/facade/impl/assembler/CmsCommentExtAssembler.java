package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.comment.*;

public class CmsCommentExtAssembler {
	
	public static CmsCommentExtDTO  toDTO(CmsCommentExt  cmsCommentExt){
		if (cmsCommentExt == null) {
			return null;
		}
    	CmsCommentExtDTO result  = new CmsCommentExtDTO();
	    	result.setId (cmsCommentExt.getId());
     	    	result.setVersion (cmsCommentExt.getVersion());
     	    	result.setCommentId (cmsCommentExt.getCommentId());
     	    	result.setIp (cmsCommentExt.getIp());
     	    	result.setText (cmsCommentExt.getText());
     	    	result.setReply (cmsCommentExt.getReply());
     	    return result;
	 }
	
	public static List<CmsCommentExtDTO>  toDTOs(Collection<CmsCommentExt>  cmsCommentExts){
		if (cmsCommentExts == null) {
			return null;
		}
		List<CmsCommentExtDTO> results = new ArrayList<CmsCommentExtDTO>();
		for (CmsCommentExt each : cmsCommentExts) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsCommentExt  toEntity(CmsCommentExtDTO  cmsCommentExtDTO){
	 	if (cmsCommentExtDTO == null) {
			return null;
		}
	 	CmsCommentExt result  = new CmsCommentExt();
        result.setId (cmsCommentExtDTO.getId());
         result.setVersion (cmsCommentExtDTO.getVersion());
         result.setCommentId (cmsCommentExtDTO.getCommentId());
         result.setIp (cmsCommentExtDTO.getIp());
         result.setText (cmsCommentExtDTO.getText());
         result.setReply (cmsCommentExtDTO.getReply());
 	  	return result;
	 }
	
	public static List<CmsCommentExt> toEntities(Collection<CmsCommentExtDTO> cmsCommentExtDTOs) {
		if (cmsCommentExtDTOs == null) {
			return null;
		}
		
		List<CmsCommentExt> results = new ArrayList<CmsCommentExt>();
		for (CmsCommentExtDTO each : cmsCommentExtDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
