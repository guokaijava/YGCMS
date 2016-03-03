package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentCheckAssembler {
	
	public static CmsContentCheckDTO  toDTO(CmsContentCheck  cmsContentCheck){
		if (cmsContentCheck == null) {
			return null;
		}
    	CmsContentCheckDTO result  = new CmsContentCheckDTO();
	    	result.setId (cmsContentCheck.getId());
     	    	result.setVersion (cmsContentCheck.getVersion());
     	    	result.setContentId (cmsContentCheck.getContentId());
     	    	result.setCheckStep (cmsContentCheck.getCheckStep());
     	    	result.setCheckOpinion (cmsContentCheck.getCheckOpinion());
     	    	result.setIsRejected (cmsContentCheck.getIsRejected());
     	    	result.setReviewer (cmsContentCheck.getReviewer());
     	    	result.setCheckDate (cmsContentCheck.getCheckDate());
     	    return result;
	 }
	
	public static List<CmsContentCheckDTO>  toDTOs(Collection<CmsContentCheck>  cmsContentChecks){
		if (cmsContentChecks == null) {
			return null;
		}
		List<CmsContentCheckDTO> results = new ArrayList<CmsContentCheckDTO>();
		for (CmsContentCheck each : cmsContentChecks) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentCheck  toEntity(CmsContentCheckDTO  cmsContentCheckDTO){
	 	if (cmsContentCheckDTO == null) {
			return null;
		}
	 	CmsContentCheck result  = new CmsContentCheck();
	 	result.setId (cmsContentCheckDTO.getId());
	 	result.setVersion (cmsContentCheckDTO.getVersion());
	 	result.setContentId (cmsContentCheckDTO.getContentId());
	 	result.setCheckStep (cmsContentCheckDTO.getCheckStep());
	 	result.setCheckOpinion (cmsContentCheckDTO.getCheckOpinion());
	 	result.setIsRejected (cmsContentCheckDTO.getIsRejected());
	 	if(cmsContentCheckDTO.getReviewer()!=null){
	 		result.setReviewer (cmsContentCheckDTO.getReviewer());
	 	}
	 	result.setCheckDate (cmsContentCheckDTO.getCheckDate());
 	  	return result;
	 }
	
	public static List<CmsContentCheck> toEntities(Collection<CmsContentCheckDTO> cmsContentCheckDTOs) {
		if (cmsContentCheckDTOs == null) {
			return null;
		}
		
		List<CmsContentCheck> results = new ArrayList<CmsContentCheck>();
		for (CmsContentCheckDTO each : cmsContentCheckDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
