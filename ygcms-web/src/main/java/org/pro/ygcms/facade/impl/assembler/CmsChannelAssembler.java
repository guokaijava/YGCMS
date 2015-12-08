package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.channel.*;

public class CmsChannelAssembler {
	
	public static CmsChannelDTO  toDTO(CmsChannel  cmsChannel){
		if (cmsChannel == null) {
			return null;
		}
    	CmsChannelDTO result  = new CmsChannelDTO();
	    	result.setId (cmsChannel.getId());
     	    	result.setVersion (cmsChannel.getVersion());
     	    	result.setChannelPath (cmsChannel.getChannelPath());
     	    	result.setHasContent (cmsChannel.getHasContent());
     	    	result.setIsDisplay (cmsChannel.getIsDisplay());
     	    	result.setLft (cmsChannel.getLft());
     	    	result.setModelId (cmsChannel.getModelId());
     	    	result.setParentId (cmsChannel.getParentId());
     	    	result.setPriority (cmsChannel.getPriority());
     	    	result.setRgt (cmsChannel.getRgt());
     	    	result.setSiteId (cmsChannel.getSiteId());
     	    	result.setChannelName(cmsChannel.getChannelName());
     	    return result;
	 }
	
	public static List<CmsChannelDTO>  toDTOs(Collection<CmsChannel>  cmsChannels){
		if (cmsChannels == null) {
			return null;
		}
		List<CmsChannelDTO> results = new ArrayList<CmsChannelDTO>();
		for (CmsChannel each : cmsChannels) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsChannel  toEntity(CmsChannelDTO  cmsChannelDTO){
	 	if (cmsChannelDTO == null) {
			return null;
		}
	 	CmsChannel result  = new CmsChannel();
        result.setId (cmsChannelDTO.getId());
         result.setVersion (cmsChannelDTO.getVersion());
         result.setChannelPath (cmsChannelDTO.getChannelPath());
         result.setHasContent (cmsChannelDTO.getHasContent());
         result.setIsDisplay (cmsChannelDTO.getIsDisplay());
         result.setLft (cmsChannelDTO.getLft());
         result.setModelId (cmsChannelDTO.getModelId());
         result.setParentId (cmsChannelDTO.getParentId());
         result.setPriority (cmsChannelDTO.getPriority());
         result.setRgt (cmsChannelDTO.getRgt());
         result.setSiteId (cmsChannelDTO.getSiteId());
         result.setChannelName(cmsChannelDTO.getChannelName());
 	  	return result;
	 }
	
	public static List<CmsChannel> toEntities(Collection<CmsChannelDTO> cmsChannelDTOs) {
		if (cmsChannelDTOs == null) {
			return null;
		}
		
		List<CmsChannel> results = new ArrayList<CmsChannel>();
		for (CmsChannelDTO each : cmsChannelDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
