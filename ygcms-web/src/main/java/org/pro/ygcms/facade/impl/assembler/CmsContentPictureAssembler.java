package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentPictureAssembler {
	
	public static CmsContentPictureDTO  toDTO(CmsContentPicture  cmsContentPicture){
		if (cmsContentPicture == null) {
			return null;
		}
    	CmsContentPictureDTO result  = new CmsContentPictureDTO();
	    	result.setId (cmsContentPicture.getId());
     	    	result.setVersion (cmsContentPicture.getVersion());
     	    	result.setContentId (cmsContentPicture.getContentId());
     	    	result.setPriority (cmsContentPicture.getPriority());
     	    	result.setImgPath (cmsContentPicture.getImgPath());
     	    	result.setDescription (cmsContentPicture.getDescription());
     	    return result;
	 }
	
	public static List<CmsContentPictureDTO>  toDTOs(Collection<CmsContentPicture>  cmsContentPictures){
		if (cmsContentPictures == null) {
			return null;
		}
		List<CmsContentPictureDTO> results = new ArrayList<CmsContentPictureDTO>();
		for (CmsContentPicture each : cmsContentPictures) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentPicture  toEntity(CmsContentPictureDTO  cmsContentPictureDTO){
	 	if (cmsContentPictureDTO == null) {
			return null;
		}
	 	CmsContentPicture result  = new CmsContentPicture();
        result.setId (cmsContentPictureDTO.getId());
         result.setVersion (cmsContentPictureDTO.getVersion());
         result.setContentId (cmsContentPictureDTO.getContentId());
         result.setPriority (cmsContentPictureDTO.getPriority());
         result.setImgPath (cmsContentPictureDTO.getImgPath());
         result.setDescription (cmsContentPictureDTO.getDescription());
 	  	return result;
	 }
	
	public static List<CmsContentPicture> toEntities(Collection<CmsContentPictureDTO> cmsContentPictureDTOs) {
		if (cmsContentPictureDTOs == null) {
			return null;
		}
		
		List<CmsContentPicture> results = new ArrayList<CmsContentPicture>();
		for (CmsContentPictureDTO each : cmsContentPictureDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
