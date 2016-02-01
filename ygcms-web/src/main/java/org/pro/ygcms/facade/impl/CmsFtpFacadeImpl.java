package org.pro.ygcms.facade.impl;

import java.text.MessageFormat;
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
import org.pro.ygcms.application.CmsFtpApplication;
import org.pro.ygcms.core.domain.ftp.CmsFtp;
import org.pro.ygcms.facade.CmsFtpFacade;
import org.pro.ygcms.facade.dto.CmsFtpDTO;
import org.pro.ygcms.facade.impl.assembler.CmsFtpAssembler;

@Named
public class CmsFtpFacadeImpl implements CmsFtpFacade {

	@Inject
	private CmsFtpApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsFtp(String id) {
		return InvokeResult.success(CmsFtpAssembler.toDTO(application.getCmsFtp(id)));
	}
	
	public InvokeResult creatCmsFtp(CmsFtpDTO cmsFtpDTO) {
		application.creatCmsFtp(CmsFtpAssembler.toEntity(cmsFtpDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsFtp(CmsFtpDTO cmsFtpDTO) {
		application.updateCmsFtp(CmsFtpAssembler.toEntity(cmsFtpDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsFtp(String id) {
		application.removeCmsFtp(application.getCmsFtp(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsFtps(String[] ids) {
		Set<CmsFtp> cmsFtps= new HashSet<CmsFtp>();
		for (String id : ids) {
			cmsFtps.add(application.getCmsFtp(id));
		}
		application.removeCmsFtps(cmsFtps);
		return InvokeResult.success();
	}
	
	public List<CmsFtpDTO> findAllCmsFtp() {
		return CmsFtpAssembler.toDTOs(application.findAllCmsFtp());
	}
	
	public Page<CmsFtpDTO> pageQueryCmsFtp(CmsFtpDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsFtp from CmsFtp _cmsFtp   where 1=1 ");
	   	if (queryVo.getFtpname() != null && !"".equals(queryVo.getFtpname())) {
	   		jpql.append(" and _cmsFtp.ftpname like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFtpname()));
	   	}		
	   	if (queryVo.getIp() != null && !"".equals(queryVo.getIp())) {
	   		jpql.append(" and _cmsFtp.ip like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIp()));
	   	}		
	   	if (queryVo.getPort() != null) {
	   		jpql.append(" and _cmsFtp.port=?");
	   		conditionVals.add(queryVo.getPort());
	   	}	
	   	if (queryVo.getUsername() != null && !"".equals(queryVo.getUsername())) {
	   		jpql.append(" and _cmsFtp.username like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUsername()));
	   	}		
	   	if (queryVo.getPassword() != null && !"".equals(queryVo.getPassword())) {
	   		jpql.append(" and _cmsFtp.password like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getPassword()));
	   	}		
	   	if (queryVo.getEncoding() != null && !"".equals(queryVo.getEncoding())) {
	   		jpql.append(" and _cmsFtp.encoding like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEncoding()));
	   	}		
	   	if (queryVo.getTimeout() != null) {
	   		jpql.append(" and _cmsFtp.timeout=?");
	   		conditionVals.add(queryVo.getTimeout());
	   	}	
	   	if (queryVo.getFtppath() != null && !"".equals(queryVo.getFtppath())) {
	   		jpql.append(" and _cmsFtp.ftppath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getFtppath()));
	   	}		
	   	if (queryVo.getUrl() != null && !"".equals(queryVo.getUrl())) {
	   		jpql.append(" and _cmsFtp.url like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getUrl()));
	   	}		
        Page<CmsFtp> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsFtpDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsFtpAssembler.toDTOs(pages.getData()));
	}
	
	
}
