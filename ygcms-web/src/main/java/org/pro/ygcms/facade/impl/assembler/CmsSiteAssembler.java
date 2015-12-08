package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.site.*;

public class CmsSiteAssembler {

	public static CmsSiteDTO toDTO(CmsSite cmsSite) {
		if (cmsSite == null) {
			return null;
		}
		CmsSiteDTO result = new CmsSiteDTO();
		result.setId(cmsSite.getId());
		result.setVersion(cmsSite.getVersion());
		result.setConfigid(cmsSite.getConfigid());
		result.setFtpuploadid(cmsSite.getFtpuploadid());
		result.setDomain(cmsSite.getDomain());
		result.setSitepath(cmsSite.getSitepath());
		result.setSitename(cmsSite.getSitename());
		result.setShortname(cmsSite.getShortname());
		result.setProtocol(cmsSite.getProtocol());
		result.setDynamicsuffix(cmsSite.getDynamicsuffix());
		result.setStaticsuffix(cmsSite.getStaticsuffix());
		result.setStaticdir(cmsSite.getStaticdir());
		result.setIsindextoroot(cmsSite.getIsindextoroot());
		result.setIsstaticindex(cmsSite.getIsstaticindex());
		result.setLocaleadmin(cmsSite.getLocaleadmin());
		result.setLocalefront(cmsSite.getLocalefront());
		result.setTplsolution(cmsSite.getTplsolution());
		result.setFinalstep(cmsSite.getFinalstep());
		result.setAftercheck(cmsSite.getAftercheck());
		result.setIsrelativepath(cmsSite.getIsrelativepath());
		result.setIsrecycleon(cmsSite.getIsrecycleon());
		result.setDomainAlias(cmsSite.getDomainAlias());
		result.setDomainredirect(cmsSite.getDomainredirect());
		result.setTplindex(cmsSite.getTplindex());
		result.setKeywords(cmsSite.getKeywords());
		result.setDescription(cmsSite.getDescription());
		return result;
	}

	public static List<CmsSiteDTO> toDTOs(Collection<CmsSite> cmsSites) {
		if (cmsSites == null) {
			return null;
		}
		List<CmsSiteDTO> results = new ArrayList<CmsSiteDTO>();
		for (CmsSite each : cmsSites) {
			results.add(toDTO(each));
		}
		return results;
	}

	public static CmsSite toEntity(CmsSiteDTO cmsSiteDTO) {
		if (cmsSiteDTO == null) {
			return null;
		}
		CmsSite result = new CmsSite();
		result.setId(cmsSiteDTO.getId());
		result.setVersion(cmsSiteDTO.getVersion());
		result.setConfigid(cmsSiteDTO.getConfigid() == null ? 0 : cmsSiteDTO
				.getConfigid());
		result.setFtpuploadid(cmsSiteDTO.getFtpuploadid()==null?0:cmsSiteDTO.getFtpuploadid());
		result.setDomain(cmsSiteDTO.getDomain());
		result.setSitepath(cmsSiteDTO.getSitepath());
		result.setSitename(cmsSiteDTO.getSitename());
		result.setShortname(cmsSiteDTO.getShortname());
		result.setProtocol(cmsSiteDTO.getProtocol());
		result.setDynamicsuffix(cmsSiteDTO.getDynamicsuffix());
		result.setStaticsuffix(cmsSiteDTO.getStaticsuffix());
		result.setStaticdir(cmsSiteDTO.getStaticdir());
		result.setIsindextoroot(cmsSiteDTO.getIsindextoroot());
		result.setIsstaticindex(cmsSiteDTO.getIsstaticindex());
		result.setLocaleadmin(cmsSiteDTO.getLocaleadmin());
		result.setLocalefront(cmsSiteDTO.getLocalefront());
		result.setTplsolution(cmsSiteDTO.getTplsolution());
		result.setFinalstep(cmsSiteDTO.getFinalstep()==null?0:cmsSiteDTO.getFinalstep());
		result.setAftercheck(cmsSiteDTO.getAftercheck()==null?0:cmsSiteDTO.getAftercheck());
		result.setIsrelativepath(cmsSiteDTO.getIsrelativepath());
		result.setIsrecycleon(cmsSiteDTO.getIsrecycleon());
		result.setDomainAlias(cmsSiteDTO.getDomainAlias());
		result.setDomainredirect(cmsSiteDTO.getDomainredirect());
		result.setTplindex(cmsSiteDTO.getTplindex());
		result.setKeywords(cmsSiteDTO.getKeywords());
		result.setDescription(cmsSiteDTO.getDescription());
		return result;
	}

	public static List<CmsSite> toEntities(Collection<CmsSiteDTO> cmsSiteDTOs) {
		if (cmsSiteDTOs == null) {
			return null;
		}

		List<CmsSite> results = new ArrayList<CmsSite>();
		for (CmsSiteDTO each : cmsSiteDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
