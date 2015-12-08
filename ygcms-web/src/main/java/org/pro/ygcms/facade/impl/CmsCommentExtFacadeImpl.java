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
import org.pro.ygcms.facade.impl.assembler.CmsCommentExtAssembler;
import org.pro.ygcms.facade.CmsCommentExtFacade;
import org.pro.ygcms.application.CmsCommentExtApplication;

import org.pro.ygcms.core.domain.comment.*;

@Named
public class CmsCommentExtFacadeImpl implements CmsCommentExtFacade {

	@Inject
	private CmsCommentExtApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsCommentExt(Long id) {
		return InvokeResult.success(CmsCommentExtAssembler.toDTO(application.getCmsCommentExt(id)));
	}
	
	public InvokeResult creatCmsCommentExt(CmsCommentExtDTO cmsCommentExtDTO) {
		application.creatCmsCommentExt(CmsCommentExtAssembler.toEntity(cmsCommentExtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsCommentExt(CmsCommentExtDTO cmsCommentExtDTO) {
		application.updateCmsCommentExt(CmsCommentExtAssembler.toEntity(cmsCommentExtDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsCommentExt(Long id) {
		application.removeCmsCommentExt(application.getCmsCommentExt(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsCommentExts(Long[] ids) {
		Set<CmsCommentExt> cmsCommentExts= new HashSet<CmsCommentExt>();
		for (Long id : ids) {
			cmsCommentExts.add(application.getCmsCommentExt(id));
		}
		application.removeCmsCommentExts(cmsCommentExts);
		return InvokeResult.success();
	}
	
	public List<CmsCommentExtDTO> findAllCmsCommentExt() {
		return CmsCommentExtAssembler.toDTOs(application.findAllCmsCommentExt());
	}
	
	public Page<CmsCommentExtDTO> pageQueryCmsCommentExt(CmsCommentExtDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsCommentExt from CmsCommentExt _cmsCommentExt   where 1=1 ");
	   	if (queryVo.getCommentId() != null) {
	   		jpql.append(" and _cmsCommentExt.commentId=?");
	   		conditionVals.add(queryVo.getCommentId());
	   	}	
	   	if (queryVo.getIp() != null && !"".equals(queryVo.getIp())) {
	   		jpql.append(" and _cmsCommentExt.ip like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getIp()));
	   	}		
	   	if (queryVo.getText() != null && !"".equals(queryVo.getText())) {
	   		jpql.append(" and _cmsCommentExt.text like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getText()));
	   	}		
	   	if (queryVo.getReply() != null && !"".equals(queryVo.getReply())) {
	   		jpql.append(" and _cmsCommentExt.reply like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getReply()));
	   	}		
        Page<CmsCommentExt> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsCommentExtDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsCommentExtAssembler.toDTOs(pages.getData()));
	}
	
	
}
