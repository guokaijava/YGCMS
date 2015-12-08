package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.model.*;

public class CmsModelAssembler {
	
	public static CmsModelDTO  toDTO(CmsModel  cmsModel){
		if (cmsModel == null) {
			return null;
		}
    	CmsModelDTO result  = new CmsModelDTO();
	    	result.setId (cmsModel.getId());
     	    	result.setVersion (cmsModel.getVersion());
     	    	result.setModelname (cmsModel.getModelname());
     	    	result.setModelpath (cmsModel.getModelpath());
     	    	result.setTplchannelprefix (cmsModel.getTplchannelprefix());
     	    	result.setTplcontentprefix (cmsModel.getTplcontentprefix());
     	    	result.setTitleimgwidth (cmsModel.getTitleimgwidth());
     	    	result.setTitleimgheight (cmsModel.getTitleimgheight());
     	    	result.setContentimgwidth (cmsModel.getContentimgwidth());
     	    	result.setContentimgheight (cmsModel.getContentimgheight());
     	    	result.setPriority (cmsModel.getPriority());
     	    	result.setHascontent (cmsModel.getHascontent());
     	    	result.setIsdisabled (cmsModel.getIsdisabled());
     	    	result.setIsdef (cmsModel.getIsdef());
     	    return result;
	 }
	
	public static List<CmsModelDTO>  toDTOs(Collection<CmsModel>  cmsModels){
		if (cmsModels == null) {
			return null;
		}
		List<CmsModelDTO> results = new ArrayList<CmsModelDTO>();
		for (CmsModel each : cmsModels) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsModel  toEntity(CmsModelDTO  cmsModelDTO){
	 	if (cmsModelDTO == null) {
			return null;
		}
	 	CmsModel result  = new CmsModel();
        result.setId (cmsModelDTO.getId());
         result.setVersion (cmsModelDTO.getVersion());
         result.setModelname (cmsModelDTO.getModelname());
         result.setModelpath (cmsModelDTO.getModelpath());
         result.setTplchannelprefix (cmsModelDTO.getTplchannelprefix());
         result.setTplcontentprefix (cmsModelDTO.getTplcontentprefix());
         result.setTitleimgwidth (cmsModelDTO.getTitleimgwidth());
         result.setTitleimgheight (cmsModelDTO.getTitleimgheight());
         result.setContentimgwidth (cmsModelDTO.getContentimgwidth());
         result.setContentimgheight (cmsModelDTO.getContentimgheight());
         result.setPriority (cmsModelDTO.getPriority());
         result.setHascontent (cmsModelDTO.getHascontent());
         result.setIsdisabled (cmsModelDTO.getIsdisabled());
         result.setIsdef (cmsModelDTO.getIsdef()==null?0:cmsModelDTO.getIsdef());
 	  	return result;
	 }
	
	public static List<CmsModel> toEntities(Collection<CmsModelDTO> cmsModelDTOs) {
		if (cmsModelDTOs == null) {
			return null;
		}
		
		List<CmsModel> results = new ArrayList<CmsModel>();
		for (CmsModelDTO each : cmsModelDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
