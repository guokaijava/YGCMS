package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.ftp.*;

public class CmsFtpAssembler {

	public static CmsFtpDTO toDTO(CmsFtp cmsFtp) {
		if (cmsFtp == null) {
			return null;
		}
		CmsFtpDTO result = new CmsFtpDTO();
		result.setId(cmsFtp.getId());
		result.setVersion(cmsFtp.getVersion());
		result.setFtpname(cmsFtp.getFtpname());
		result.setIp(cmsFtp.getIp());
		result.setPort(cmsFtp.getPort());
		result.setUsername(cmsFtp.getUsername());
		result.setPassword(cmsFtp.getPassword());
		result.setEncoding(cmsFtp.getEncoding());
		result.setTimeout(cmsFtp.getTimeout());
		result.setFtppath(cmsFtp.getFtppath());
		result.setUrl(cmsFtp.getUrl());
		return result;
	}

	public static List<CmsFtpDTO> toDTOs(Collection<CmsFtp> cmsFtps) {
		if (cmsFtps == null) {
			return null;
		}
		List<CmsFtpDTO> results = new ArrayList<CmsFtpDTO>();
		for (CmsFtp each : cmsFtps) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static CmsFtp toEntity(CmsFtpDTO cmsFtpDTO) {
		if (cmsFtpDTO == null) {
			return null;
		}
		CmsFtp result = new CmsFtp();
		result.setId(cmsFtpDTO.getId());
		result.setVersion(cmsFtpDTO.getVersion());
		result.setFtpname(cmsFtpDTO.getFtpname());
		result.setIp(cmsFtpDTO.getIp());
		result.setPort(cmsFtpDTO.getPort());
		result.setUsername(cmsFtpDTO.getUsername());
		result.setPassword(cmsFtpDTO.getPassword());
		result.setEncoding(cmsFtpDTO.getEncoding());
		result.setTimeout(cmsFtpDTO.getTimeout());
		result.setFtppath(cmsFtpDTO.getFtppath());
		result.setUrl(cmsFtpDTO.getUrl());
		return result;
	}

	public static List<CmsFtp> toEntities(Collection<CmsFtpDTO> cmsFtpDTOs) {
		if (cmsFtpDTOs == null) {
			return null;
		}

		List<CmsFtp> results = new ArrayList<CmsFtp>();
		for (CmsFtpDTO each : cmsFtpDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
