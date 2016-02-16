package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.channel.*;

public class CmsChannelAttrAssembler {
	
	public static CmsChannelAttrDTO  toDTO(CmsChannelAttr  cmsChannelAttr){
		if (cmsChannelAttr == null) {
			return null;
		}
    	CmsChannelAttrDTO result  = new CmsChannelAttrDTO();
	    	result.setId (cmsChannelAttr.getId());
     	    	result.setVersion (cmsChannelAttr.getVersion());
     	    	result.setChannelId (cmsChannelAttr.getChannelId());
     	    	result.setAttrName (cmsChannelAttr.getAttrName());
     	    	result.setAttrValue (cmsChannelAttr.getAttrValue());
     	    return result;
	 }
	
	public static List<CmsChannelAttrDTO>  toDTOs(Collection<CmsChannelAttr>  cmsChannelAttrs){
		if (cmsChannelAttrs == null) {
			return null;
		}
		List<CmsChannelAttrDTO> results = new ArrayList<CmsChannelAttrDTO>();
		for (CmsChannelAttr each : cmsChannelAttrs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsChannelAttr  toEntity(CmsChannelAttrDTO  cmsChannelAttrDTO){
	 	if (cmsChannelAttrDTO == null) {
			return null;
		}
	 	CmsChannelAttr result  = new CmsChannelAttr();
        result.setId (cmsChannelAttrDTO.getId());
         result.setVersion (cmsChannelAttrDTO.getVersion());
         result.setChannelId (cmsChannelAttrDTO.getChannelId());
         result.setAttrName (cmsChannelAttrDTO.getAttrName());
         result.setAttrValue (cmsChannelAttrDTO.getAttrValue());
 	  	return result;
	 }
	
	public static List<CmsChannelAttr> toEntities(Collection<CmsChannelAttrDTO> cmsChannelAttrDTOs) {
		if (cmsChannelAttrDTOs == null) {
			return null;
		}
		
		List<CmsChannelAttr> results = new ArrayList<CmsChannelAttr>();
		for (CmsChannelAttrDTO each : cmsChannelAttrDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
