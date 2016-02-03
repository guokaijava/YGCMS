package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.channel.*;

public class CmsTopicAssembler {
	
	public static CmsTopicDTO  toDTO(CmsTopic  cmsTopic){
		if (cmsTopic == null) {
			return null;
		}
    	CmsTopicDTO result  = new CmsTopicDTO();
	    	result.setId (cmsTopic.getId());
     	    	result.setVersion (cmsTopic.getVersion());
     	    	result.setChannelid (cmsTopic.getChannelid());
     	    	result.setTopicname (cmsTopic.getTopicname());
     	    	result.setShortname (cmsTopic.getShortname());
     	    	result.setKeywords (cmsTopic.getKeywords());
     	    	result.setDescription (cmsTopic.getDescription());
     	    	result.setTitleimg (cmsTopic.getTitleimg());
     	    	result.setContentimg (cmsTopic.getContentimg());
     	    	result.setTplcontent (cmsTopic.getTplcontent());
     	    	result.setPriority (cmsTopic.getPriority());
     	    	result.setIsrecommend (cmsTopic.getIsrecommend());
     	    return result;
	 }
	
	public static List<CmsTopicDTO>  toDTOs(Collection<CmsTopic>  cmsTopics){
		if (cmsTopics == null) {
			return null;
		}
		List<CmsTopicDTO> results = new ArrayList<CmsTopicDTO>();
		for (CmsTopic each : cmsTopics) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsTopic  toEntity(CmsTopicDTO  cmsTopicDTO){
	 	if (cmsTopicDTO == null) {
			return null;
		}
	 	CmsTopic result  = new CmsTopic();
        result.setId (cmsTopicDTO.getId());
         result.setVersion (cmsTopicDTO.getVersion());
         result.setChannelid (cmsTopicDTO.getChannelid());
         result.setTopicname (cmsTopicDTO.getTopicname());
         result.setShortname (cmsTopicDTO.getShortname());
         result.setKeywords (cmsTopicDTO.getKeywords());
         result.setDescription (cmsTopicDTO.getDescription());
         result.setTitleimg (cmsTopicDTO.getTitleimg());
         result.setContentimg (cmsTopicDTO.getContentimg());
         result.setTplcontent (cmsTopicDTO.getTplcontent());
         result.setPriority (cmsTopicDTO.getPriority());
         result.setIsrecommend (cmsTopicDTO.getIsrecommend());
 	  	return result;
	 }
	
	public static List<CmsTopic> toEntities(Collection<CmsTopicDTO> cmsTopicDTOs) {
		if (cmsTopicDTOs == null) {
			return null;
		}
		
		List<CmsTopic> results = new ArrayList<CmsTopic>();
		for (CmsTopicDTO each : cmsTopicDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
