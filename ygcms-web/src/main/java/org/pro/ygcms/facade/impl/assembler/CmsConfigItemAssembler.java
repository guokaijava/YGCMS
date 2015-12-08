package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.config.*;

public class CmsConfigItemAssembler {
	
	public static CmsConfigItemDTO  toDTO(CmsConfigItem  cmsConfigItem){
		if (cmsConfigItem == null) {
			return null;
		}
    	CmsConfigItemDTO result  = new CmsConfigItemDTO();
	    	result.setId (cmsConfigItem.getId());
     	    	result.setVersion (cmsConfigItem.getVersion());
     	    	result.setConfigId (cmsConfigItem.getConfigId());
     	    	result.setField (cmsConfigItem.getField());
     	    	result.setItemLabel (cmsConfigItem.getItemLabel());
     	    	result.setPriority (cmsConfigItem.getPriority());
     	    	result.setDefValue (cmsConfigItem.getDefValue());
     	    	result.setOptValue (cmsConfigItem.getOptValue());
     	    	result.setTextSize (cmsConfigItem.getTextSize());
     	    	result.setAreaRows (cmsConfigItem.getAreaRows());
     	    	result.setAreaCols (cmsConfigItem.getAreaCols());
     	    	result.setHelp (cmsConfigItem.getHelp());
     	    	result.setHelpPosition (cmsConfigItem.getHelpPosition());
     	    	result.setDataType (cmsConfigItem.getDataType());
     	    	result.setIsRequired (cmsConfigItem.getIsRequired());
     	    	result.setCategory (cmsConfigItem.getCategory());
     	    return result;
	 }
	
	public static List<CmsConfigItemDTO>  toDTOs(Collection<CmsConfigItem>  cmsConfigItems){
		if (cmsConfigItems == null) {
			return null;
		}
		List<CmsConfigItemDTO> results = new ArrayList<CmsConfigItemDTO>();
		for (CmsConfigItem each : cmsConfigItems) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsConfigItem  toEntity(CmsConfigItemDTO  cmsConfigItemDTO){
	 	if (cmsConfigItemDTO == null) {
			return null;
		}
	 	CmsConfigItem result  = new CmsConfigItem();
        result.setId (cmsConfigItemDTO.getId());
         result.setVersion (cmsConfigItemDTO.getVersion());
         result.setConfigId (cmsConfigItemDTO.getConfigId());
         result.setField (cmsConfigItemDTO.getField());
         result.setItemLabel (cmsConfigItemDTO.getItemLabel());
         result.setPriority (cmsConfigItemDTO.getPriority());
         result.setDefValue (cmsConfigItemDTO.getDefValue());
         result.setOptValue (cmsConfigItemDTO.getOptValue());
         result.setTextSize (cmsConfigItemDTO.getTextSize());
         result.setAreaRows (cmsConfigItemDTO.getAreaRows());
         result.setAreaCols (cmsConfigItemDTO.getAreaCols());
         result.setHelp (cmsConfigItemDTO.getHelp());
         result.setHelpPosition (cmsConfigItemDTO.getHelpPosition());
         result.setDataType (cmsConfigItemDTO.getDataType());
         result.setIsRequired (cmsConfigItemDTO.getIsRequired());
         result.setCategory (cmsConfigItemDTO.getCategory());
 	  	return result;
	 }
	
	public static List<CmsConfigItem> toEntities(Collection<CmsConfigItemDTO> cmsConfigItemDTOs) {
		if (cmsConfigItemDTOs == null) {
			return null;
		}
		
		List<CmsConfigItem> results = new ArrayList<CmsConfigItem>();
		for (CmsConfigItemDTO each : cmsConfigItemDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
