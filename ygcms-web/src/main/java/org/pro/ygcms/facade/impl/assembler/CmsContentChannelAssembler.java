package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentChannelAssembler {
	
	public static CmsContentChannelDTO  toDTO(CmsContentChannel  cmsContentChannel){
		if (cmsContentChannel == null) {
			return null;
		}
    	CmsContentChannelDTO result  = new CmsContentChannelDTO();
	    	result.setId (cmsContentChannel.getId());
     	    	result.setVersion (cmsContentChannel.getVersion());
     	    	result.setChannelId (cmsContentChannel.getChannelId());
     	    	result.setContentId (cmsContentChannel.getContentId());
     	    return result;
	 }
	
	public static List<CmsContentChannelDTO>  toDTOs(Collection<CmsContentChannel>  cmsContentChannels){
		if (cmsContentChannels == null) {
			return null;
		}
		List<CmsContentChannelDTO> results = new ArrayList<CmsContentChannelDTO>();
		for (CmsContentChannel each : cmsContentChannels) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentChannel  toEntity(CmsContentChannelDTO  cmsContentChannelDTO){
	 	if (cmsContentChannelDTO == null) {
			return null;
		}
	 	CmsContentChannel result  = new CmsContentChannel();
        result.setId (cmsContentChannelDTO.getId());
         result.setVersion (cmsContentChannelDTO.getVersion());
         result.setChannelId (cmsContentChannelDTO.getChannelId());
         result.setContentId (cmsContentChannelDTO.getContentId());
 	  	return result;
	 }
	
	public static List<CmsContentChannel> toEntities(Collection<CmsContentChannelDTO> cmsContentChannelDTOs) {
		if (cmsContentChannelDTOs == null) {
			return null;
		}
		
		List<CmsContentChannel> results = new ArrayList<CmsContentChannel>();
		for (CmsContentChannelDTO each : cmsContentChannelDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
