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
import org.pro.ygcms.facade.impl.assembler.CmsContentTxtAssembler;
import org.pro.ygcms.facade.CmsContentTxtFacade;
import org.pro.ygcms.application.CmsContentTxtApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentTxtFacadeImpl implements CmsContentTxtFacade {

	@Inject
	private CmsContentTxtApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentTxt(Long id) {
		return InvokeResult.success(CmsContentTxtAssembler.toDTO(application.getCmsContentTxt(id)));
	}
	
	public InvokeResult creatCmsContentTxt(CmsContentTxtDTO cmsContentTxtDTO) {
		application.creatCmsContentTxt(CmsContentTxtAssembler.toEntity(cmsContentTxtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentTxt(CmsContentTxtDTO cmsContentTxtDTO) {
		application.updateCmsContentTxt(CmsContentTxtAssembler.toEntity(cmsContentTxtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentTxt(Long id) {
		application.removeCmsContentTxt(application.getCmsContentTxt(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentTxts(Long[] ids) {
		Set<CmsContentTxt> cmsContentTxts= new HashSet<CmsContentTxt>();
		for (Long id : ids) {
			cmsContentTxts.add(application.getCmsContentTxt(id));
		}
		application.removeCmsContentTxts(cmsContentTxts);
		return InvokeResult.success();
	}
	
	public List<CmsContentTxtDTO> findAllCmsContentTxt() {
		return CmsContentTxtAssembler.toDTOs(application.findAllCmsContentTxt());
	}
	
	public Page<CmsContentTxtDTO> pageQueryCmsContentTxt(CmsContentTxtDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentTxt from CmsContentTxt _cmsContentTxt   where 1=1 ");
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsContentTxt.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
	   	if (queryVo.getTxt() != null && !"".equals(queryVo.getTxt())) {
	   		jpql.append(" and _cmsContentTxt.txt like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTxt()));
	   	}		
	   	if (queryVo.getTxt1() != null && !"".equals(queryVo.getTxt1())) {
	   		jpql.append(" and _cmsContentTxt.txt1 like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTxt1()));
	   	}		
	   	if (queryVo.getTxt2() != null && !"".equals(queryVo.getTxt2())) {
	   		jpql.append(" and _cmsContentTxt.txt2 like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTxt2()));
	   	}		
	   	if (queryVo.getTxt3() != null && !"".equals(queryVo.getTxt3())) {
	   		jpql.append(" and _cmsContentTxt.txt3 like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTxt3()));
	   	}		
        Page<CmsContentTxt> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentTxtDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentTxtAssembler.toDTOs(pages.getData()));
	}
	
	
}
