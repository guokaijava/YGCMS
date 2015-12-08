package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentTopicAssembler {
	
	public static CmsContentTopicDTO  toDTO(CmsContentTopic  cmsContentTopic){
		if (cmsContentTopic == null) {
			return null;
		}
    	CmsContentTopicDTO result  = new CmsContentTopicDTO();
	    	result.setId (cmsContentTopic.getId());
     	    	result.setVersion (cmsContentTopic.getVersion());
     	    	result.setContentId (cmsContentTopic.getContentId());
     	    	result.setTopicId (cmsContentTopic.getTopicId());
     	    return result;
	 }
	
	public static List<CmsContentTopicDTO>  toDTOs(Collection<CmsContentTopic>  cmsContentTopics){
		if (cmsContentTopics == null) {
			return null;
		}
		List<CmsContentTopicDTO> results = new ArrayList<CmsContentTopicDTO>();
		for (CmsContentTopic each : cmsContentTopics) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentTopic  toEntity(CmsContentTopicDTO  cmsContentTopicDTO){
	 	if (cmsContentTopicDTO == null) {
			return null;
		}
	 	CmsContentTopic result  = new CmsContentTopic();
        result.setId (cmsContentTopicDTO.getId());
         result.setVersion (cmsContentTopicDTO.getVersion());
         result.setContentId (cmsContentTopicDTO.getContentId());
         result.setTopicId (cmsContentTopicDTO.getTopicId());
 	  	return result;
	 }
	
	public static List<CmsContentTopic> toEntities(Collection<CmsContentTopicDTO> cmsContentTopicDTOs) {
		if (cmsContentTopicDTOs == null) {
			return null;
		}
		
		List<CmsContentTopic> results = new ArrayList<CmsContentTopic>();
		for (CmsContentTopicDTO each : cmsContentTopicDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
