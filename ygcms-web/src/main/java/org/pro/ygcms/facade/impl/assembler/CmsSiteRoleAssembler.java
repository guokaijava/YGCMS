package org.pro.ygcms.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.core.domain.site.*;

public class CmsSiteRoleAssembler {
	
	public static CmsSiteRoleDTO  toDTO(CmsSiteRole  cmsSiteRole){
		if (cmsSiteRole == null) {
			return null;
		}
    	CmsSiteRoleDTO result  = new CmsSiteRoleDTO();
	    	result.setId (cmsSiteRole.getId());
     	    	result.setVersion (cmsSiteRole.getVersion());
     	    	result.setSiteid (cmsSiteRole.getSiteid());
     	    	result.setRoleid (cmsSiteRole.getRoleid());
     	    return result;
	 }
	
	public static List<CmsSiteRoleDTO>  toDTOs(Collection<CmsSiteRole>  cmsSiteRoles){
		if (cmsSiteRoles == null) {
			return null;
		}
		List<CmsSiteRoleDTO> results = new ArrayList<CmsSiteRoleDTO>();
		for (CmsSiteRole each : cmsSiteRoles) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static CmsSiteRole  toEntity(CmsSiteRoleDTO  cmsSiteRoleDTO){
	 	if (cmsSiteRoleDTO == null) {
			return null;
		}
	 	CmsSiteRole result  = new CmsSiteRole();
        result.setId (cmsSiteRoleDTO.getId());
         result.setVersion (cmsSiteRoleDTO.getVersion());
         result.setSiteid (cmsSiteRoleDTO.getSiteid());
         result.setRoleid (cmsSiteRoleDTO.getRoleid());
 	  	return result;
	 }
	
	public static List<CmsSiteRole> toEntities(Collection<CmsSiteRoleDTO> cmsSiteRoleDTOs) {
		if (cmsSiteRoleDTOs == null) {
			return null;
		}
		
		List<CmsSiteRole> results = new ArrayList<CmsSiteRole>();
		for (CmsSiteRoleDTO each : cmsSiteRoleDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
