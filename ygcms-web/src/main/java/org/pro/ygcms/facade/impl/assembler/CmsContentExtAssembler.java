package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.web.util.DateTimeUtil;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentExtAssembler {
	
	public static CmsContentExtDTO  toDTO(CmsContentExt  cmsContentExt){
		if (cmsContentExt == null) {
			return null;
		}
		CmsContentExtDTO result  = new CmsContentExtDTO();
		result.setId (cmsContentExt.getId());
		result.setVersion (cmsContentExt.getVersion());
		result.setContentId (cmsContentExt.getContentId());
		result.setTitle (cmsContentExt.getTitle());
		result.setShortTitle (cmsContentExt.getShortTitle());
		result.setAuthor (cmsContentExt.getAuthor());
		result.setOrigin (cmsContentExt.getOrigin());
		result.setOriginUrl (cmsContentExt.getOriginUrl());
		result.setDescription (cmsContentExt.getDescription());
//		result.setReleaseDate (DateTimeUtil.Date2String(cmsContentExt.getReleaseDate(), "yyyy-MM-dd HH:mm:ss"));
		result.setReleaseDate (DateTimeUtil.Date2String(cmsContentExt.getReleaseDate(), "yyyy-MM-dd"));
		result.setMediaPath (cmsContentExt.getMediaPath());
		result.setMediaType (cmsContentExt.getMediaType());
		result.setTitleColor (cmsContentExt.getTitleColor());
		result.setIsBold (cmsContentExt.getIsBold());
		result.setTitleImg (cmsContentExt.getTitleImg());
		result.setContentImg (cmsContentExt.getContentImg());
		result.setTypeImg (cmsContentExt.getTypeImg());
		result.setLink (cmsContentExt.getLink());
		result.setTplContent (cmsContentExt.getTplContent());
		result.setNeedRegenerate (cmsContentExt.getNeedRegenerate());
		return result;
	 }
	
	public static List<CmsContentExtDTO>  toDTOs(Collection<CmsContentExt>  cmsContentExts){
		if (cmsContentExts == null) {
			return null;
		}
		List<CmsContentExtDTO> results = new ArrayList<CmsContentExtDTO>();
		for (CmsContentExt each : cmsContentExts) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsContentExt toEntity(CmsContentExtDTO  cmsContentExtDTO){
	 	if (cmsContentExtDTO == null) {
			return null;
		}
	 	CmsContentExt result  = new CmsContentExt();
	 	result.setId(cmsContentExtDTO.getId());
	 	result.setVersion(cmsContentExtDTO.getVersion());
	 	result.setContentId(cmsContentExtDTO.getContentId());
	 	result.setTitle(cmsContentExtDTO.getTitle());
	 	result.setShortTitle(cmsContentExtDTO.getShortTitle());
	 	result.setAuthor(cmsContentExtDTO.getAuthor());
	 	result.setOrigin(cmsContentExtDTO.getOrigin());
	 	result.setOriginUrl(cmsContentExtDTO.getOriginUrl());
	 	result.setDescription(cmsContentExtDTO.getDescription());
	 	if(cmsContentExtDTO.getReleaseDate()!=null){
	 		result.setReleaseDate(DateTimeUtil.String2Date(cmsContentExtDTO.getReleaseDate()));
	 	}
	 	result.setMediaPath(cmsContentExtDTO.getMediaPath());
	 	result.setMediaType(cmsContentExtDTO.getMediaType());
	 	result.setTitleColor(cmsContentExtDTO.getTitleColor());
	 	result.setIsBold(cmsContentExtDTO.getIsBold()==null?false:cmsContentExtDTO.getIsBold());
	 	result.setTitleImg(cmsContentExtDTO.getTitleImg());
	 	result.setContentImg(cmsContentExtDTO.getContentImg());
	 	result.setTypeImg(cmsContentExtDTO.getTypeImg());
	 	result.setLink(cmsContentExtDTO.getLink());
	 	result.setTplContent(cmsContentExtDTO.getTplContent());
	 	result.setNeedRegenerate(cmsContentExtDTO.getNeedRegenerate()==null?false:cmsContentExtDTO.getNeedRegenerate());
	 	return result;
	 }
	
	public static List<CmsContentExt> toEntities(Collection<CmsContentExtDTO> cmsContentExtDTOs) {
		if (cmsContentExtDTOs == null) {
			return null;
		}
		
		List<CmsContentExt> results = new ArrayList<CmsContentExt>();
		for (CmsContentExtDTO each : cmsContentExtDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
