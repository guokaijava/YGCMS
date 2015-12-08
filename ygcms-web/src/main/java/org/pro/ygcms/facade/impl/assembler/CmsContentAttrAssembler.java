package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentAttrAssembler {
	
	public static CmsContentAttrDTO  toDTO(CmsContentAttr  cmsContentAttr){
		if (cmsContentAttr == null) {
			return null;
		}
    	CmsContentAttrDTO result  = new CmsContentAttrDTO();
	    	result.setId (cmsContentAttr.getId());
     	    	result.setVersion (cmsContentAttr.getVersion());
     	    	result.setContentId (cmsContentAttr.getContentId());
     	    	result.setAttrName (cmsContentAttr.getAttrName());
     	    	result.setAttrValue (cmsContentAttr.getAttrValue());
     	    return result;
	 }
	
	public static List<CmsContentAttrDTO>  toDTOs(Collection<CmsContentAttr>  cmsContentAttrs){
		if (cmsContentAttrs == null) {
			return null;
		}
		List<CmsContentAttrDTO> results = new ArrayList<CmsContentAttrDTO>();
		for (CmsContentAttr each : cmsContentAttrs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentAttr  toEntity(CmsContentAttrDTO  cmsContentAttrDTO){
	 	if (cmsContentAttrDTO == null) {
			return null;
		}
	 	CmsContentAttr result  = new CmsContentAttr();
        result.setId (cmsContentAttrDTO.getId());
         result.setVersion (cmsContentAttrDTO.getVersion());
         result.setContentId (cmsContentAttrDTO.getContentId());
         result.setAttrName (cmsContentAttrDTO.getAttrName());
         result.setAttrValue (cmsContentAttrDTO.getAttrValue());
 	  	return result;
	 }
	
	public static List<CmsContentAttr> toEntities(Collection<CmsContentAttrDTO> cmsContentAttrDTOs) {
		if (cmsContentAttrDTOs == null) {
			return null;
		}
		
		List<CmsContentAttr> results = new ArrayList<CmsContentAttr>();
		for (CmsContentAttrDTO each : cmsContentAttrDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
