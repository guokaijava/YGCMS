package org.pro.ygcms.facade.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.QueryChannelService;
import org.dayatang.utils.Page;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.application.CmsSiteRoleApplication;
import org.pro.ygcms.core.domain.site.CmsSiteRole;
import org.pro.ygcms.facade.CmsSiteRoleFacade;
import org.pro.ygcms.facade.dto.CmsSiteRoleDTO;
import org.pro.ygcms.facade.impl.assembler.CmsSiteRoleAssembler;

@Named
public class CmsSiteRoleFacadeImpl implements CmsSiteRoleFacade {

	@Inject
	private CmsSiteRoleApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsSiteRole(Long id) {
		return InvokeResult.success(CmsSiteRoleAssembler.toDTO(application.getCmsSiteRole(id)));
	}
	
	public InvokeResult creatCmsSiteRole(CmsSiteRoleDTO cmsSiteRoleDTO) {
		application.creatCmsSiteRole(CmsSiteRoleAssembler.toEntity(cmsSiteRoleDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsSiteRole(CmsSiteRoleDTO cmsSiteRoleDTO) {
		application.updateCmsSiteRole(CmsSiteRoleAssembler.toEntity(cmsSiteRoleDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsSiteRole(Long id) {
		application.removeCmsSiteRole(application.getCmsSiteRole(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsSiteRoles(Long[] ids) {
		Set<CmsSiteRole> cmsSiteRoles= new HashSet<CmsSiteRole>();
		for (Long id : ids) {
			cmsSiteRoles.add(application.getCmsSiteRole(id));
		}
		application.removeCmsSiteRoles(cmsSiteRoles);
		return InvokeResult.success();
	}
	
	public List<CmsSiteRoleDTO> findAllCmsSiteRole() {
		return CmsSiteRoleAssembler.toDTOs(application.findAllCmsSiteRole());
	}
	
	public Page<CmsSiteRoleDTO> pageQueryCmsSiteRole(CmsSiteRoleDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsSiteRole from CmsSiteRole _cmsSiteRole   where 1=1 ");
        Page<CmsSiteRole> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsSiteRoleDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsSiteRoleAssembler.toDTOs(pages.getData()));
	}
	
	
}
