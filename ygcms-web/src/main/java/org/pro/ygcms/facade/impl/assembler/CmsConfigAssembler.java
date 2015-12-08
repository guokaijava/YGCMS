package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.config.*;

public class CmsConfigAssembler {
	
	public static CmsConfigDTO  toDTO(CmsConfig  cmsConfig){
		if (cmsConfig == null) {
			return null;
		}
    	CmsConfigDTO result  = new CmsConfigDTO();
	    	result.setId (cmsConfig.getId());
     	    	result.setVersion (cmsConfig.getVersion());
     	    	result.setContextPath (cmsConfig.getContextPath());
     	    	result.setServletPoint (cmsConfig.getServletPoint());
     	    	result.setPort (cmsConfig.getPort());
     	    	result.setDbFileUri (cmsConfig.getDbFileUri());
     	    	result.setIsUploadToDb (cmsConfig.getIsUploadToDb());
     	    	result.setDefImg (cmsConfig.getDefImg());
     	    	result.setLoginUrl (cmsConfig.getLoginUrl());
     	    	result.setProcessUrl (cmsConfig.getProcessUrl());
     	    	result.setMarkOn (cmsConfig.getMarkOn());
     	    	result.setMarkWidth (cmsConfig.getMarkWidth());
     	    	result.setMarkHeight (cmsConfig.getMarkHeight());
     	    	result.setMarkImage (cmsConfig.getMarkImage());
     	    	result.setMarkContent (cmsConfig.getMarkContent());
     	    	result.setMarkSize (cmsConfig.getMarkSize());
     	    	result.setMarkColor (cmsConfig.getMarkColor());
     	    	result.setMarkAlpha (cmsConfig.getMarkAlpha());
     	    	result.setMarkPosition (cmsConfig.getMarkPosition());
     	    	result.setMarkOffsetX (cmsConfig.getMarkOffsetX());
     	    	result.setMarkOffsetY (cmsConfig.getMarkOffsetY());
     	    	result.setCountClearTime (cmsConfig.getCountClearTime());
     	    	result.setCountCopyTime (cmsConfig.getCountCopyTime());
     	    	result.setDownloadCode (cmsConfig.getDownloadCode());
     	    	result.setDownloadTime (cmsConfig.getDownloadTime());
     	    	result.setEmailHost (cmsConfig.getEmailHost());
     	    	result.setEmailEncoding (cmsConfig.getEmailEncoding());
     	    	result.setEmailUsername (cmsConfig.getEmailUsername());
     	    	result.setEmailPassword (cmsConfig.getEmailPassword());
     	    	result.setEmailPersonal (cmsConfig.getEmailPersonal());
     	    	result.setEmailValidate (cmsConfig.getEmailValidate());
     	    	result.setViewOnlyChecked (cmsConfig.getViewOnlyChecked());
     	    return result;
	 }
	
	public static List<CmsConfigDTO>  toDTOs(Collection<CmsConfig>  cmsConfigs){
		if (cmsConfigs == null) {
			return null;
		}
		List<CmsConfigDTO> results = new ArrayList<CmsConfigDTO>();
		for (CmsConfig each : cmsConfigs) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsConfig  toEntity(CmsConfigDTO  cmsConfigDTO){
	 	if (cmsConfigDTO == null) {
			return null;
		}
	 	CmsConfig result  = new CmsConfig();
        result.setId (cmsConfigDTO.getId());
         result.setVersion (cmsConfigDTO.getVersion());
         result.setContextPath (cmsConfigDTO.getContextPath());
         result.setServletPoint (cmsConfigDTO.getServletPoint());
         result.setPort (cmsConfigDTO.getPort());
         result.setDbFileUri (cmsConfigDTO.getDbFileUri());
         result.setIsUploadToDb (cmsConfigDTO.getIsUploadToDb());
         result.setDefImg (cmsConfigDTO.getDefImg());
         result.setLoginUrl (cmsConfigDTO.getLoginUrl());
         result.setProcessUrl (cmsConfigDTO.getProcessUrl());
         result.setMarkOn (cmsConfigDTO.getMarkOn());
         result.setMarkWidth (cmsConfigDTO.getMarkWidth());
         result.setMarkHeight (cmsConfigDTO.getMarkHeight());
         result.setMarkImage (cmsConfigDTO.getMarkImage());
         result.setMarkContent (cmsConfigDTO.getMarkContent());
         result.setMarkSize (cmsConfigDTO.getMarkSize());
         result.setMarkColor (cmsConfigDTO.getMarkColor());
         result.setMarkAlpha (cmsConfigDTO.getMarkAlpha());
         result.setMarkPosition (cmsConfigDTO.getMarkPosition());
         result.setMarkOffsetX (cmsConfigDTO.getMarkOffsetX());
         result.setMarkOffsetY (cmsConfigDTO.getMarkOffsetY());
         result.setCountClearTime (cmsConfigDTO.getCountClearTime());
         result.setCountCopyTime (cmsConfigDTO.getCountCopyTime());
         result.setDownloadCode (cmsConfigDTO.getDownloadCode());
         result.setDownloadTime (cmsConfigDTO.getDownloadTime());
         result.setEmailHost (cmsConfigDTO.getEmailHost());
         result.setEmailEncoding (cmsConfigDTO.getEmailEncoding());
         result.setEmailUsername (cmsConfigDTO.getEmailUsername());
         result.setEmailPassword (cmsConfigDTO.getEmailPassword());
         result.setEmailPersonal (cmsConfigDTO.getEmailPersonal());
         result.setEmailValidate (cmsConfigDTO.getEmailValidate());
         result.setViewOnlyChecked (cmsConfigDTO.getViewOnlyChecked());
 	  	return result;
	 }
	
	public static List<CmsConfig> toEntities(Collection<CmsConfigDTO> cmsConfigDTOs) {
		if (cmsConfigDTOs == null) {
			return null;
		}
		
		List<CmsConfig> results = new ArrayList<CmsConfig>();
		for (CmsConfigDTO each : cmsConfigDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
