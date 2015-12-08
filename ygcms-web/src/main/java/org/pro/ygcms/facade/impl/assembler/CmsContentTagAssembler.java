package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentTagAssembler {
	
	public static CmsContentTagDTO  toDTO(CmsContentTag  cmsContentTag){
		if (cmsContentTag == null) {
			return null;
		}
    	CmsContentTagDTO result  = new CmsContentTagDTO();
	    	result.setId (cmsContentTag.getId());
     	    	result.setVersion (cmsContentTag.getVersion());
     	    	result.setTagName (cmsContentTag.getTagName());
     	    	result.setRefCounter (cmsContentTag.getRefCounter());
     	    return result;
	 }
	
	public static List<CmsContentTagDTO>  toDTOs(Collection<CmsContentTag>  cmsContentTags){
		if (cmsContentTags == null) {
			return null;
		}
		List<CmsContentTagDTO> results = new ArrayList<CmsContentTagDTO>();
		for (CmsContentTag each : cmsContentTags) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentTag  toEntity(CmsContentTagDTO  cmsContentTagDTO){
	 	if (cmsContentTagDTO == null) {
			return null;
		}
	 	CmsContentTag result  = new CmsContentTag();
        result.setId (cmsContentTagDTO.getId());
         result.setVersion (cmsContentTagDTO.getVersion());
         result.setTagName (cmsContentTagDTO.getTagName());
         result.setRefCounter (cmsContentTagDTO.getRefCounter());
 	  	return result;
	 }
	
	public static List<CmsContentTag> toEntities(Collection<CmsContentTagDTO> cmsContentTagDTOs) {
		if (cmsContentTagDTOs == null) {
			return null;
		}
		
		List<CmsContentTag> results = new ArrayList<CmsContentTag>();
		for (CmsContentTagDTO each : cmsContentTagDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
