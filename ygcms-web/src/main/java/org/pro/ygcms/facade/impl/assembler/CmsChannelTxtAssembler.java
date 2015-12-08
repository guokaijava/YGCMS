package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.channel.*;

public class CmsChannelTxtAssembler {
	
	public static CmsChannelTxtDTO  toDTO(CmsChannelTxt  cmsChannelTxt){
		if (cmsChannelTxt == null) {
			return null;
		}
    	CmsChannelTxtDTO result  = new CmsChannelTxtDTO();
	    	result.setId (cmsChannelTxt.getId());
     	    	result.setVersion (cmsChannelTxt.getVersion());
     	    	result.setChannelId (cmsChannelTxt.getChannelId());
     	    	result.setTxt (cmsChannelTxt.getTxt());
     	    	result.setTxt1 (cmsChannelTxt.getTxt1());
     	    	result.setTxt2 (cmsChannelTxt.getTxt2());
     	    	result.setTxt3 (cmsChannelTxt.getTxt3());
     	    return result;
	 }
	
	public static List<CmsChannelTxtDTO>  toDTOs(Collection<CmsChannelTxt>  cmsChannelTxts){
		if (cmsChannelTxts == null) {
			return null;
		}
		List<CmsChannelTxtDTO> results = new ArrayList<CmsChannelTxtDTO>();
		for (CmsChannelTxt each : cmsChannelTxts) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsChannelTxt  toEntity(CmsChannelTxtDTO  cmsChannelTxtDTO){
	 	if (cmsChannelTxtDTO == null) {
			return null;
		}
	 	CmsChannelTxt result  = new CmsChannelTxt();
        result.setId (cmsChannelTxtDTO.getId());
         result.setVersion (cmsChannelTxtDTO.getVersion());
         result.setChannelId (cmsChannelTxtDTO.getChannelId());
         result.setTxt (cmsChannelTxtDTO.getTxt());
         result.setTxt1 (cmsChannelTxtDTO.getTxt1());
         result.setTxt2 (cmsChannelTxtDTO.getTxt2());
         result.setTxt3 (cmsChannelTxtDTO.getTxt3());
 	  	return result;
	 }
	
	public static List<CmsChannelTxt> toEntities(Collection<CmsChannelTxtDTO> cmsChannelTxtDTOs) {
		if (cmsChannelTxtDTOs == null) {
			return null;
		}
		
		List<CmsChannelTxt> results = new ArrayList<CmsChannelTxt>();
		for (CmsChannelTxtDTO each : cmsChannelTxtDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
