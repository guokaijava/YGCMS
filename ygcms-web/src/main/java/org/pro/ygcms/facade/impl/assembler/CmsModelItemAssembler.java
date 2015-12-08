package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.model.*;

public class CmsModelItemAssembler {
	
	public static CmsModelItemDTO  toDTO(CmsModelItem  cmsModelItem){
		if (cmsModelItem == null) {
			return null;
		}
    	CmsModelItemDTO result  = new CmsModelItemDTO();
	    	result.setId (cmsModelItem.getId());
     	    	result.setVersion (cmsModelItem.getVersion());
     	    	result.setModelid (cmsModelItem.getModelid());
     	    	result.setField (cmsModelItem.getField());
     	    	result.setItemlabel (cmsModelItem.getItemlabel());
     	    	result.setPriority (cmsModelItem.getPriority());
     	    	result.setDefvalue (cmsModelItem.getDefvalue());
     	    	result.setOptvalue (cmsModelItem.getOptvalue());
     	    	result.setTextsize (cmsModelItem.getTextsize());
     	    	result.setArearows (cmsModelItem.getArearows());
     	    	result.setAreacols (cmsModelItem.getAreacols());
     	    	result.setHelp (cmsModelItem.getHelp());
     	    	result.setHelpposition (cmsModelItem.getHelpposition());
     	    	result.setDatatype (cmsModelItem.getDatatype());
     	    	result.setIssingle (cmsModelItem.getIssingle());
     	    	result.setIschannel (cmsModelItem.getIschannel());
     	    	result.setIscustom (cmsModelItem.getIscustom());
     	    	result.setIsdisplay (cmsModelItem.getIsdisplay());
     	    	result.setCard (cmsModelItem.getCard());
     	    return result;
	 }
	
	public static List<CmsModelItemDTO>  toDTOs(Collection<CmsModelItem>  cmsModelItems){
		if (cmsModelItems == null) {
			return null;
		}
		List<CmsModelItemDTO> results = new ArrayList<CmsModelItemDTO>();
		for (CmsModelItem each : cmsModelItems) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsModelItem  toEntity(CmsModelItemDTO  cmsModelItemDTO){
	 	if (cmsModelItemDTO == null) {
			return null;
		}
	 	CmsModelItem result  = new CmsModelItem();
        result.setId (cmsModelItemDTO.getId());
         result.setVersion (cmsModelItemDTO.getVersion());
         result.setModelid (cmsModelItemDTO.getModelid());
         result.setField (cmsModelItemDTO.getField());
         result.setItemlabel (cmsModelItemDTO.getItemlabel());
         result.setPriority (cmsModelItemDTO.getPriority());
         result.setDefvalue (cmsModelItemDTO.getDefvalue());
         result.setOptvalue (cmsModelItemDTO.getOptvalue());
         result.setTextsize (cmsModelItemDTO.getTextsize());
         result.setArearows (cmsModelItemDTO.getArearows());
         result.setAreacols (cmsModelItemDTO.getAreacols());
         result.setHelp (cmsModelItemDTO.getHelp());
         result.setHelpposition (cmsModelItemDTO.getHelpposition());
         result.setDatatype (cmsModelItemDTO.getDatatype());
         result.setIssingle (cmsModelItemDTO.getIssingle());
         result.setIschannel (cmsModelItemDTO.getIschannel());
         result.setIscustom (cmsModelItemDTO.getIscustom());
         result.setIsdisplay (cmsModelItemDTO.getIsdisplay());
         result.setCard (cmsModelItemDTO.getCard());
 	  	return result;
	 }
	
	public static List<CmsModelItem> toEntities(Collection<CmsModelItemDTO> cmsModelItemDTOs) {
		if (cmsModelItemDTOs == null) {
			return null;
		}
		
		List<CmsModelItem> results = new ArrayList<CmsModelItem>();
		for (CmsModelItemDTO each : cmsModelItemDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
