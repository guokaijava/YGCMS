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
import org.pro.ygcms.facade.impl.assembler.CmsContentTypeAssembler;
import org.pro.ygcms.facade.CmsContentTypeFacade;
import org.pro.ygcms.application.CmsContentTypeApplication;

import org.pro.ygcms.core.domain.content.*;

@Named
public class CmsContentTypeFacadeImpl implements CmsContentTypeFacade {

	@Inject
	private CmsContentTypeApplication  application;

	private QueryChannelService queryChannel;

    private QueryChannelService getQueryChannelService(){
       if(queryChannel==null){
          queryChannel = InstanceFactory.getInstance(QueryChannelService.class,"queryChannel");
       }
     return queryChannel;
    }
	
	public InvokeResult getCmsContentType(Long id) {
		return InvokeResult.success(CmsContentTypeAssembler.toDTO(application.getCmsContentType(id)));
	}
	
	public InvokeResult creatCmsContentType(CmsContentTypeDTO cmsContentTypeDTO) {
		application.creatCmsContentType(CmsContentTypeAssembler.toEntity(cmsContentTypeDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult updateCmsContentType(CmsContentTypeDTO cmsContentTypeDTO) {
		application.updateCmsContentType(CmsContentTypeAssembler.toEntity(cmsContentTypeDTO));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentType(Long id) {
		application.removeCmsContentType(application.getCmsContentType(id));
		return InvokeResult.success();
	}
	
	public InvokeResult removeCmsContentTypes(Long[] ids) {
		Set<CmsContentType> cmsContentTypes= new HashSet<CmsContentType>();
		for (Long id : ids) {
			cmsContentTypes.add(application.getCmsContentType(id));
		}
		application.removeCmsContentTypes(cmsContentTypes);
		return InvokeResult.success();
	}
	
	public List<CmsContentTypeDTO> findAllCmsContentType() {
		return CmsContentTypeAssembler.toDTOs(application.findAllCmsContentType());
	}
	
	public Page<CmsContentTypeDTO> pageQueryCmsContentType(CmsContentTypeDTO queryVo, int currentPage, int pageSize) {
		List<Object> conditionVals = new ArrayList<Object>();
	   	StringBuilder jpql = new StringBuilder("select _cmsContentType from CmsContentType _cmsContentType   where 1=1 ");
	   	if (queryVo.getTypename() != null && !"".equals(queryVo.getTypename())) {
	   		jpql.append(" and _cmsContentType.typename like ?");
	   		conditionVals.add(MessageFormat.format("%{0}%", queryVo.getTypename()));
	   	}		
	   	if (queryVo.getImgwidth() != null) {
	   		jpql.append(" and _cmsContentType.imgwidth=?");
	   		conditionVals.add(queryVo.getImgwidth());
	   	}	
	   	if (queryVo.getImgheight() != null) {
	   		jpql.append(" and _cmsContentType.imgheight=?");
	   		conditionVals.add(queryVo.getImgheight());
	   	}	
	   	if (queryVo.getHasimage() != null) {
	   		jpql.append(" and _cmsContentType.hasimage=?");
	   		conditionVals.add(queryVo.getHasimage());
	   	}	
	   	if (queryVo.getIsdisabled() != null) {
	   		jpql.append(" and _cmsContentType.isdisabled=?");
	   		conditionVals.add(queryVo.getIsdisabled());
	   	}	
        Page<CmsContentType> pages = getQueryChannelService()
		   .createJpqlQuery(jpql.toString())
		   .setParameters(conditionVals)
		   .setPage(currentPage, pageSize)
		   .pagedList();
		   
        return new Page<CmsContentTypeDTO>(pages.getStart(), pages.getResultCount(),pageSize, CmsContentTypeAssembler.toDTOs(pages.getData()));
	}
	
	
}
