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
import org.pro.ygcms.facade.dto.*;
import org.pro.ygcms.facade.impl.assembler.CmsConfigAssembler;
import org.pro.ygcms.facade.CmsConfigFacade;
import org.pro.ygcms.application.CmsConfigApplication;

import org.pro.ygcms.core.domain.config.*;

@Named
public class CmsConfigFacadeImpl implements CmsConfigFacade {

	@Inject
	private CmsConfigApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsConfig(Long id) {
		return InvokeResult.success(CmsConfigAssembler.toDTO(application.getCmsConfig(id)));
	}
	
	public InvokeResult creatCmsConfig(CmsConfigDTO cmsConfigDTO) {
		application.creatCmsConfig(CmsConfigAssembler.toEntity(cmsConfigDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsConfig(CmsConfigDTO cmsConfigDTO) {
		application.updateCmsConfig(CmsConfigAssembler.toEntity(cmsConfigDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsConfig(Long id) {
		application.removeCmsConfig(application.getCmsConfig(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsConfigs(Long[] ids) {
		Set<CmsConfig> cmsConfigs= new HashSet<CmsConfig>();
		for (Long id : ids) {
			cmsConfigs.add(application.getCmsConfig(id));
		}
		application.removeCmsConfigs(cmsConfigs);
		return InvokeResult.success();
	}
	
	public List<CmsConfigDTO> findAllCmsConfig() {
		return CmsConfigAssembler.toDTOs(application.findAllCmsConfig());
	}
	
	public Page<CmsConfigDTO> pageQueryCmsConfig(CmsConfigDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsConfig from CmsConfig _cmsConfig   where 1=1 ");
	   	if (queryVo.getContextPath() != null && !"".equals(queryVo.getContextPath())) {
	   		jpql.append(" and _cmsConfig.contextPath like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getContextPath()));
	   	}		
	   	if (queryVo.getServletPoint() != null && !"".equals(queryVo.getServletPoint())) {
	   		jpql.append(" and _cmsConfig.servletPoint like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getServletPoint()));
	   	}		
	   	if (queryVo.getPort() != null) {
	   		jpql.append(" and _cmsConfig.port=?");
	   		conditionVals.add(queryVo.getPort());
	   	}	
	   	if (queryVo.getDbFileUri() != null && !"".equals(queryVo.getDbFileUri())) {
	   		jpql.append(" and _cmsConfig.dbFileUri like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDbFileUri()));
	   	}		
	   	if (queryVo.getIsUploadToDb() != null) {
		   	jpql.append(" and _cmsConfig.isUploadToDb is ?");
		   	conditionVals.add(queryVo.getIsUploadToDb());
	   	}	
	   	if (queryVo.getDefImg() != null && !"".equals(queryVo.getDefImg())) {
	   		jpql.append(" and _cmsConfig.defImg like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDefImg()));
	   	}		
	   	if (queryVo.getLoginUrl() != null && !"".equals(queryVo.getLoginUrl())) {
	   		jpql.append(" and _cmsConfig.loginUrl like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getLoginUrl()));
	   	}		
	   	if (queryVo.getProcessUrl() != null && !"".equals(queryVo.getProcessUrl())) {
	   		jpql.append(" and _cmsConfig.processUrl like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getProcessUrl()));
	   	}		
	   	if (queryVo.getMarkOn() != null) {
		   	jpql.append(" and _cmsConfig.markOn is ?");
		   	conditionVals.add(queryVo.getMarkOn());
	   	}	
	   	if (queryVo.getMarkWidth() != null) {
	   		jpql.append(" and _cmsConfig.markWidth=?");
	   		conditionVals.add(queryVo.getMarkWidth());
	   	}	
	   	if (queryVo.getMarkHeight() != null) {
	   		jpql.append(" and _cmsConfig.markHeight=?");
	   		conditionVals.add(queryVo.getMarkHeight());
	   	}	
	   	if (queryVo.getMarkImage() != null && !"".equals(queryVo.getMarkImage())) {
	   		jpql.append(" and _cmsConfig.markImage like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMarkImage()));
	   	}		
	   	if (queryVo.getMarkContent() != null && !"".equals(queryVo.getMarkContent())) {
	   		jpql.append(" and _cmsConfig.markContent like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMarkContent()));
	   	}		
	   	if (queryVo.getMarkSize() != null) {
	   		jpql.append(" and _cmsConfig.markSize=?");
	   		conditionVals.add(queryVo.getMarkSize());
	   	}	
	   	if (queryVo.getMarkColor() != null && !"".equals(queryVo.getMarkColor())) {
	   		jpql.append(" and _cmsConfig.markColor like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getMarkColor()));
	   	}		
	   	if (queryVo.getMarkAlpha() != null) {
	   		jpql.append(" and _cmsConfig.markAlpha=?");
	   		conditionVals.add(queryVo.getMarkAlpha());
	   	}	
	   	if (queryVo.getMarkPosition() != null) {
	   		jpql.append(" and _cmsConfig.markPosition=?");
	   		conditionVals.add(queryVo.getMarkPosition());
	   	}	
	   	if (queryVo.getMarkOffsetX() != null) {
	   		jpql.append(" and _cmsConfig.markOffsetX=?");
	   		conditionVals.add(queryVo.getMarkOffsetX());
	   	}	
	   	if (queryVo.getMarkOffsetY() != null) {
	   		jpql.append(" and _cmsConfig.markOffsetY=?");
	   		conditionVals.add(queryVo.getMarkOffsetY());
	   	}	
	   	if (queryVo.getCountClearTime() != null) {
	   		jpql.append(" and _cmsConfig.countClearTime between ? and ? ");
	   		conditionVals.add(queryVo.getCountClearTime());
	   		conditionVals.add(queryVo.getCountClearTimeEnd());
	   	}	
	   	if (queryVo.getDownloadCode() != null && !"".equals(queryVo.getDownloadCode())) {
	   		jpql.append(" and _cmsConfig.downloadCode like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getDownloadCode()));
	   	}		
	   	if (queryVo.getDownloadTime() != null) {
	   		jpql.append(" and _cmsConfig.downloadTime=?");
	   		conditionVals.add(queryVo.getDownloadTime());
	   	}	
	   	if (queryVo.getEmailHost() != null && !"".equals(queryVo.getEmailHost())) {
	   		jpql.append(" and _cmsConfig.emailHost like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmailHost()));
	   	}		
	   	if (queryVo.getEmailEncoding() != null && !"".equals(queryVo.getEmailEncoding())) {
	   		jpql.append(" and _cmsConfig.emailEncoding like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmailEncoding()));
	   	}		
	   	if (queryVo.getEmailUsername() != null && !"".equals(queryVo.getEmailUsername())) {
	   		jpql.append(" and _cmsConfig.emailUsername like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmailUsername()));
	   	}		
	   	if (queryVo.getEmailPassword() != null && !"".equals(queryVo.getEmailPassword())) {
	   		jpql.append(" and _cmsConfig.emailPassword like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmailPassword()));
	   	}		
	   	if (queryVo.getEmailPersonal() != null && !"".equals(queryVo.getEmailPersonal())) {
	   		jpql.append(" and _cmsConfig.emailPersonal like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getEmailPersonal()));
	   	}		
	   	if (queryVo.getEmailValidate() != null) {
		   	jpql.append(" and _cmsConfig.emailValidate is ?");
		   	conditionVals.add(queryVo.getEmailValidate());
	   	}	
	   	if (queryVo.getViewOnlyChecked() != null) {
		   	jpql.append(" and _cmsConfig.viewOnlyChecked is ?");
		   	conditionVals.add(queryVo.getViewOnlyChecked());
	   	}	
        Page<CmsConfig> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsConfigDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsConfigAssembler.toDTOs(pages.getData()));
	}
	
	
}
