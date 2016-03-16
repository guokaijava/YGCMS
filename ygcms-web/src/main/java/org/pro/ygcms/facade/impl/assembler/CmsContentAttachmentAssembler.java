package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.content.*;

public class CmsContentAttachmentAssembler {

	public static CmsContentAttachmentDTO toDTO(CmsContentAttachment cmsContentAttachment) {
		if (cmsContentAttachment == null) {
			return null;
		}
		CmsContentAttachmentDTO result = new CmsContentAttachmentDTO();
		result.setId(cmsContentAttachment.getId());
		result.setVersion(cmsContentAttachment.getVersion());
		result.setContentId(cmsContentAttachment.getContentId());
		result.setPriority(cmsContentAttachment.getPriority());
		result.setAttachmentPath(cmsContentAttachment.getAttachmentPath());
		result.setAttachmentName(cmsContentAttachment.getAttachmentName());
		result.setFilename(cmsContentAttachment.getFilename());
		result.setDownloadCount(cmsContentAttachment.getDownloadCount());
		result.setFileTitle(cmsContentAttachment.getTitle());
		result.setFileDescription(cmsContentAttachment.getDescription());
		return result;
	}

	public static List<CmsContentAttachmentDTO> toDTOs(Collection<CmsContentAttachment> cmsContentAttachments) {
		if (cmsContentAttachments == null) {
			return null;
		}
		List<CmsContentAttachmentDTO> results = new ArrayList<CmsContentAttachmentDTO>();
		for (CmsContentAttachment each : cmsContentAttachments) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static CmsContentAttachment toEntity(CmsContentAttachmentDTO cmsContentAttachmentDTO) {
		if (cmsContentAttachmentDTO == null) {
			return null;
		}
		CmsContentAttachment result = new CmsContentAttachment();
		result.setId(cmsContentAttachmentDTO.getId());
		result.setVersion(cmsContentAttachmentDTO.getVersion());
		result.setContentId(cmsContentAttachmentDTO.getContentId());
		result.setAttachmentPath(cmsContentAttachmentDTO.getAttachmentPath());
		result.setAttachmentName(cmsContentAttachmentDTO.getAttachmentName());
		result.setFilename(cmsContentAttachmentDTO.getFilename());
		result.setTitle(cmsContentAttachmentDTO.getFileTitle());
		result.setDescription(cmsContentAttachmentDTO.getFileDescription());
		return result;
	}

	public static List<CmsContentAttachment> toEntities(Collection<CmsContentAttachmentDTO> cmsContentAttachmentDTOs) {
		if (cmsContentAttachmentDTOs == null) {
			return null;
		}

		List<CmsContentAttachment> results = new ArrayList<CmsContentAttachment>();
		for (CmsContentAttachmentDTO each : cmsContentAttachmentDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
