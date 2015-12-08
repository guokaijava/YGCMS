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
import org.pro.ygcms.facade.impl.assembler.CmsContentChannelAssembler;
import org.pro.ygcms.facade.CmsContentChannelFacade;
import org.pro.ygcms.application.CmsContentChannelApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentChannelFacadeImpl implements CmsContentChannelFacade {

	@Inject
	private CmsContentChannelApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentChannel(Long id) {
		return InvokeResult.success(CmsContentChannelAssembler.toDTO(application.getCmsContentChannel(id)));
	}
	
	public InvokeResult creatCmsContentChannel(CmsContentChannelDTO cmsContentChannelDTO) {
		application.creatCmsContentChannel(CmsContentChannelAssembler.toEntity(cmsContentChannelDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentChannel(CmsContentChannelDTO cmsContentChannelDTO) {
		application.updateCmsContentChannel(CmsContentChannelAssembler.toEntity(cmsContentChannelDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentChannel(Long id) {
		application.removeCmsContentChannel(application.getCmsContentChannel(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentChannels(Long[] ids) {
		Set<CmsContentChannel> cmsContentChannels= new HashSet<CmsContentChannel>();
		for (Long id : ids) {
			cmsContentChannels.add(application.getCmsContentChannel(id));
		}
		application.removeCmsContentChannels(cmsContentChannels);
		return InvokeResult.success();
	}
	
	public List<CmsContentChannelDTO> findAllCmsContentChannel() {
		return CmsContentChannelAssembler.toDTOs(application.findAllCmsContentChannel());
	}
	
	public Page<CmsContentChannelDTO> pageQueryCmsContentChannel(CmsContentChannelDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentChannel from CmsContentChannel _cmsContentChannel   where 1=1 ");
	   	if (queryVo.getChannelId() != null) {
	   		jpql.append(" and _cmsContentChannel.channelId=?");
	   		conditionVals.add(queryVo.getChannelId());
	   	}	
	   	if (queryVo.getContentId() != null) {
	   		jpql.append(" and _cmsContentChannel.contentId=?");
	   		conditionVals.add(queryVo.getContentId());
	   	}	
        Page<CmsContentChannel> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentChannelDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentChannelAssembler.toDTOs(pages.getData()));
	}
	
	
}
