package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentTxtAssembler {
	
	public static CmsContentTxtDTO  toDTO(CmsContentTxt  cmsContentTxt){
		if (cmsContentTxt == null) {
			return null;
		}
    	CmsContentTxtDTO result  = new CmsContentTxtDTO();
	    	result.setId (cmsContentTxt.getId());
     	    	result.setVersion (cmsContentTxt.getVersion());
     	    	result.setContentId (cmsContentTxt.getContentId());
     	    	result.setTxt (cmsContentTxt.getTxt());
     	    	result.setTxt1 (cmsContentTxt.getTxt1());
     	    	result.setTxt2 (cmsContentTxt.getTxt2());
     	    	result.setTxt3 (cmsContentTxt.getTxt3());
     	    return result;
	 }
	
	public static List<CmsContentTxtDTO>  toDTOs(Collection<CmsContentTxt>  cmsContentTxts){
		if (cmsContentTxts == null) {
			return null;
		}
		List<CmsContentTxtDTO> results = new ArrayList<CmsContentTxtDTO>();
		for (CmsContentTxt each : cmsContentTxts) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentTxt  toEntity(CmsContentTxtDTO  cmsContentTxtDTO){
	 	if (cmsContentTxtDTO == null) {
			return null;
		}
	 	CmsContentTxt result  = new CmsContentTxt();
        result.setId (cmsContentTxtDTO.getId());
         result.setVersion (cmsContentTxtDTO.getVersion());
         result.setContentId (cmsContentTxtDTO.getContentId());
         result.setTxt (cmsContentTxtDTO.getTxt());
         result.setTxt1 (cmsContentTxtDTO.getTxt1());
         result.setTxt2 (cmsContentTxtDTO.getTxt2());
         result.setTxt3 (cmsContentTxtDTO.getTxt3());
 	  	return result;
	 }
	
	public static List<CmsContentTxt> toEntities(Collection<CmsContentTxtDTO> cmsContentTxtDTOs) {
		if (cmsContentTxtDTOs == null) {
			return null;
		}
		
		List<CmsContentTxt> results = new ArrayList<CmsContentTxt>();
		for (CmsContentTxtDTO each : cmsContentTxtDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
