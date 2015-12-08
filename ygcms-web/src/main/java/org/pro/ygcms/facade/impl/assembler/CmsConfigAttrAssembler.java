package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.config.*;

public class CmsConfigAttrAssembler {
	
	public static CmsConfigAttrDTO  toDTO(CmsConfigAttr  cmsConfigAttr){
		if (cmsConfigAttr == null) {
			return null;
		}
    	CmsConfigAttrDTO result  = new CmsConfigAttrDTO();
	    	result.setId (cmsConfigAttr.getId());
     	    	result.setVersion (cmsConfigAttr.getVersion());
     	    	result.setConfigId (cmsConfigAttr.getConfigId());
     	    	result.setAttrName (cmsConfigAttr.getAttrName());
     	    	result.setAttrValue (cmsConfigAttr.getAttrValue());
     	    return result;
	 }
	
	public static List<CmsConfigAttrDTO>  toDTOs(Collection<CmsConfigAttr>  cmsConfigAttrs){
		if (cmsConfigAttrs == null) {
			return null;
		}
		List<CmsConfigAttrDTO> results = new ArrayList<CmsConfigAttrDTO>();
		for (CmsConfigAttr each : cmsConfigAttrs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsConfigAttr  toEntity(CmsConfigAttrDTO  cmsConfigAttrDTO){
	 	if (cmsConfigAttrDTO == null) {
			return null;
		}
	 	CmsConfigAttr result  = new CmsConfigAttr();
        result.setId (cmsConfigAttrDTO.getId());
         result.setVersion (cmsConfigAttrDTO.getVersion());
         result.setConfigId (cmsConfigAttrDTO.getConfigId());
         result.setAttrName (cmsConfigAttrDTO.getAttrName());
         result.setAttrValue (cmsConfigAttrDTO.getAttrValue());
 	  	return result;
	 }
	
	public static List<CmsConfigAttr> toEntities(Collection<CmsConfigAttrDTO> cmsConfigAttrDTOs) {
		if (cmsConfigAttrDTOs == null) {
			return null;
		}
		
		List<CmsConfigAttr> results = new ArrayList<CmsConfigAttr>();
		for (CmsConfigAttrDTO each : cmsConfigAttrDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
