package org.pro.ygcms.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.text.MessageFormat;

import javax.inject.Inject;
import javax.inject.Named;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.utils.Page;
import org.dayatang.querychannel.QueryChannelService;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsSiteFacade;
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.facade.impl.assembler.CmsSiteAssembler;
import org.pro.ygcms.application.CmsSiteApplication;
import org.pro.ygcms.core.domain.site.*;

@Named
public class CmsSiteFacadeImpl implements CmsSiteFacade {

	@Inject
	private CmsSiteApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsSite(String id) {
		return InvokeResult.success(CmsSiteAssembler.toDTO(application.getCmsSite(id)));
	}
	
	public InvokeResult creatCmsSite(CmsSiteDTO cmsSiteDTO) {
		application.creatCmsSite(CmsSiteAssembler.toEntity(cmsSiteDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsSite(CmsSiteDTO cmsSiteDTO) {
		application.updateCmsSite(CmsSiteAssembler.toEntity(cmsSiteDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsSite(String id) {
		application.removeCmsSite(application.getCmsSite(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsSites(String[] ids) {
		Set<CmsSite> cmsSites= new HashSet<CmsSite>();
		for (String id : ids) {
			cmsSites.add(application.getCmsSite(id));
		}
		application.removeCmsSites(cmsSites);
		return InvokeResult.success();
	}
	
	public List<CmsSiteDTO> findAllCmsSite() {
		return CmsSiteAssembler.toDTOs(application.findAllCmsSite());
	}
	
	public Page<CmsSiteDTO> pageQueryCmsSite(CmsSiteDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsSite from CmsSite _cmsSite   where 1=1 ");
	   	if (queryVo.getConfigid() != null) {
	   		jpql.append(" and _cmsSite.configid=?");
	   		conditionVals.add(queryVo.getConfigid());
	   	}	
	   	if (queryVo.getFtpuploadid() != null) {
	   		jpql.append(" and _cmsSite.ftpuploadid=?");
	   		conditionVals.add(queryVo.getFtpuploadid());
	   	}	
	   	if (queryVo.getDomain() != null && !"".equals(queryVo.getDomain())) {
	   		jpql.append(" and _cmsSite.domain like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDomain()));
	   	}		
	   	if (queryVo.getSitepath() != null && !"".equals(queryVo.getSitepath())) {
	   		jpql.append(" and _cmsSite.sitepath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSitepath()));
	   	}		
	   	if (queryVo.getSitename() != null && !"".equals(queryVo.getSitename())) {
	   		jpql.append(" and _cmsSite.sitename like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getSitename()));
	   	}		
	   	if (queryVo.getShortname() != null && !"".equals(queryVo.getShortname())) {
	   		jpql.append(" and _cmsSite.shortname like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getShortname()));
	   	}		
	   	if (queryVo.getProtocol() != null && !"".equals(queryVo.getProtocol())) {
	   		jpql.append(" and _cmsSite.protocol like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProtocol()));
	   	}		
	   	if (queryVo.getDynamicsuffix() != null && !"".equals(queryVo.getDynamicsuffix())) {
	   		jpql.append(" and _cmsSite.dynamicsuffix like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDynamicsuffix()));
	   	}		
	   	if (queryVo.getStaticsuffix() != null && !"".equals(queryVo.getStaticsuffix())) {
	   		jpql.append(" and _cmsSite.staticsuffix like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStaticsuffix()));
	   	}		
	   	if (queryVo.getStaticdir() != null && !"".equals(queryVo.getStaticdir())) {
	   		jpql.append(" and _cmsSite.staticdir like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getStaticdir()));
	   	}		
	   	if (queryVo.getIsindextoroot() != null && !"".equals(queryVo.getIsindextoroot())) {
	   		jpql.append(" and _cmsSite.isindextoroot like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsindextoroot()));
	   	}		
	   	if (queryVo.getIsstaticindex() != null && !"".equals(queryVo.getIsstaticindex())) {
	   		jpql.append(" and _cmsSite.isstaticindex like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsstaticindex()));
	   	}		
	   	if (queryVo.getLocaleadmin() != null && !"".equals(queryVo.getLocaleadmin())) {
	   		jpql.append(" and _cmsSite.localeadmin like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLocaleadmin()));
	   	}		
	   	if (queryVo.getLocalefront() != null && !"".equals(queryVo.getLocalefront())) {
	   		jpql.append(" and _cmsSite.localefront like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLocalefront()));
	   	}		
	   	if (queryVo.getTplsolution() != null && !"".equals(queryVo.getTplsolution())) {
	   		jpql.append(" and _cmsSite.tplsolution like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTplsolution()));
	   	}		
	   	if (queryVo.getFinalstep() != null) {
	   		jpql.append(" and _cmsSite.finalstep=?");
	   		conditionVals.add(queryVo.getFinalstep());
	   	}	
	   	if (queryVo.getAftercheck() != null) {
	   		jpql.append(" and _cmsSite.aftercheck=?");
	   		conditionVals.add(queryVo.getAftercheck());
	   	}	
	   	if (queryVo.getIsrelativepath() != null && !"".equals(queryVo.getIsrelativepath())) {
	   		jpql.append(" and _cmsSite.isrelativepath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsrelativepath()));
	   	}		
	   	if (queryVo.getIsrecycleon() != null && !"".equals(queryVo.getIsrecycleon())) {
	   		jpql.append(" and _cmsSite.isrecycleon like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIsrecycleon()));
	   	}		
	   	if (queryVo.getDomainAlias() != null && !"".equals(queryVo.getDomainAlias())) {
	   		jpql.append(" and _cmsSite.domainAlias like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDomainAlias()));
	   	}		
	   	if (queryVo.getDomainredirect() != null && !"".equals(queryVo.getDomainredirect())) {
	   		jpql.append(" and _cmsSite.domainredirect like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDomainredirect()));
	   	}		
	   	if (queryVo.getTplindex() != null && !"".equals(queryVo.getTplindex())) {
	   		jpql.append(" and _cmsSite.tplindex like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTplindex()));
	   	}		
	   	if (queryVo.getKeywords() != null && !"".equals(queryVo.getKeywords())) {
	   		jpql.append(" and _cmsSite.keywords like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getKeywords()));
	   	}		
	   	if (queryVo.getDescription() != null && !"".equals(queryVo.getDescription())) {
	   		jpql.append(" and _cmsSite.description like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDescription()));
	   	}		
        Page<CmsSite> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsSiteDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsSiteAssembler.toDTOs(pages.getData()));
	}
	
}
