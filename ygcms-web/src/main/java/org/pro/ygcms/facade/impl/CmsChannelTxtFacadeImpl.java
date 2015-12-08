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
import org.pro.ygcms.facade.impl.assembler.CmsChannelTxtAssembler;
import org.pro.ygcms.facade.CmsChannelTxtFacade;
import org.pro.ygcms.application.CmsChannelTxtApplication;

import org.pro.ygcms.core.domain.channel.*;

@Named
public class CmsChannelTxtFacadeImpl implements CmsChannelTxtFacade {

	@Inject
	private CmsChannelTxtApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsChannelTxt(Long id) {
		return InvokeResult.success(CmsChannelTxtAssembler.toDTO(application.getCmsChannelTxt(id)));
	}
	
	public InvokeResult creatCmsChannelTxt(CmsChannelTxtDTO cmsChannelTxtDTO) {
		application.creatCmsChannelTxt(CmsChannelTxtAssembler.toEntity(cmsChannelTxtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsChannelTxt(CmsChannelTxtDTO cmsChannelTxtDTO) {
		application.updateCmsChannelTxt(CmsChannelTxtAssembler.toEntity(cmsChannelTxtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannelTxt(Long id) {
		application.removeCmsChannelTxt(application.getCmsChannelTxt(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsChannelTxts(Long[] ids) {
		Set<CmsChannelTxt> cmsChannelTxts= new HashSet<CmsChannelTxt>();
		for (Long id : ids) {
			cmsChannelTxts.add(application.getCmsChannelTxt(id));
		}
		application.removeCmsChannelTxts(cmsChannelTxts);
		return InvokeResult.success();
	}
	
	public List<CmsChannelTxtDTO> findAllCmsChannelTxt() {
		return CmsChannelTxtAssembler.toDTOs(application.findAllCmsChannelTxt());
	}
	
	public Page<CmsChannelTxtDTO> pageQueryCmsChannelTxt(CmsChannelTxtDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsChannelTxt from CmsChannelTxt _cmsChannelTxt   where 1=1 ");
	   	if (queryVo.getChannelId() != null) {
	   		jpql.append(" and _cmsChannelTxt.channelId=?");
	   		conditionVals.add(queryVo.getChannelId());
	   	}	
	   	if (queryVo.getTxt() != null && !"".equals(queryVo.getTxt())) {
	   		jpql.append(" and _cmsChannelTxt.txt like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTxt()));
	   	}		
	   	if (queryVo.getTxt1() != null && !"".equals(queryVo.getTxt1())) {
	   		jpql.append(" and _cmsChannelTxt.txt1 like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTxt1()));
	   	}		
	   	if (queryVo.getTxt2() != null && !"".equals(queryVo.getTxt2())) {
	   		jpql.append(" and _cmsChannelTxt.txt2 like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTxt2()));
	   	}		
	   	if (queryVo.getTxt3() != null && !"".equals(queryVo.getTxt3())) {
	   		jpql.append(" and _cmsChannelTxt.txt3 like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTxt3()));
	   	}		
        Page<CmsChannelTxt> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsChannelTxtDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsChannelTxtAssembler.toDTOs(pages.getData()));
	}
	
	
}
