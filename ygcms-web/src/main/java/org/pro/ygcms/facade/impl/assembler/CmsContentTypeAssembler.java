package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentTypeAssembler {
	
	public static CmsContentTypeDTO  toDTO(CmsContentType  cmsContentType){
		if (cmsContentType == null) {
			return null;
		}
    	CmsContentTypeDTO result  = new CmsContentTypeDTO();
	    	result.setId (cmsContentType.getId());
     	    	result.setVersion (cmsContentType.getVersion());
     	    	result.setTypename (cmsContentType.getTypename());
     	    	result.setImgwidth (cmsContentType.getImgwidth());
     	    	result.setImgheight (cmsContentType.getImgheight());
     	    	result.setHasimage (cmsContentType.getHasimage());
     	    	result.setIsdisabled (cmsContentType.getIsdisabled());
     	    return result;
	 }
	
	public static List<CmsContentTypeDTO>  toDTOs(Collection<CmsContentType>  cmsContentTypes){
		if (cmsContentTypes == null) {
			return null;
		}
		List<CmsContentTypeDTO> results = new ArrayList<CmsContentTypeDTO>();
		for (CmsContentType each : cmsContentTypes) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentType  toEntity(CmsContentTypeDTO  cmsContentTypeDTO){
	 	if (cmsContentTypeDTO == null) {
			return null;
		}
	 	CmsContentType result  = new CmsContentType();
        result.setId (cmsContentTypeDTO.getId());
         result.setVersion (cmsContentTypeDTO.getVersion());
         result.setTypename (cmsContentTypeDTO.getTypename());
         result.setImgwidth (cmsContentTypeDTO.getImgwidth());
         result.setImgheight (cmsContentTypeDTO.getImgheight());
         result.setHasimage (cmsContentTypeDTO.getHasimage());
         result.setIsdisabled (cmsContentTypeDTO.getIsdisabled());
 	  	return result;
	 }
	
	public static List<CmsContentType> toEntities(Collection<CmsContentTypeDTO> cmsContentTypeDTOs) {
		if (cmsContentTypeDTOs == null) {
			return null;
		}
		
		List<CmsContentType> results = new ArrayList<CmsContentType>();
		for (CmsContentTypeDTO each : cmsContentTypeDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
