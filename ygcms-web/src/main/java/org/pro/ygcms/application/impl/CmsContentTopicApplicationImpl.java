package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsContentTopicApplication;
import org.pro.ygcms.core.domain.content.CmsContentTopic;

@Named
@Transactional
public class CmsContentTopicApplicationImpl implements CmsContentTopicApplication {

	public CmsContentTopic getCmsContentTopic(String id) {
		return CmsContentTopic.get(CmsContentTopic.class, id);
	}
	
	public void creatCmsContentTopic(CmsContentTopic cmsContentTopic) {
		cmsContentTopic.save();
	}
	
	public void updateCmsContentTopic(CmsContentTopic cmsContentTopic) {
		cmsContentTopic .save();
	}
	
	public void removeCmsContentTopic(CmsContentTopic cmsContentTopic) {
		if(cmsContentTopic != null){
			cmsContentTopic.remove();
		}
	}
	
	public void removeCmsContentTopics(Set<CmsContentTopic> cmsContentTopics) {
		for (CmsContentTopic cmsContentTopic : cmsContentTopics) {
			cmsContentTopic.remove();
		}
	}
	
	public List<CmsContentTopic> findAllCmsContentTopic() {
		return CmsContentTopic.findAll(CmsContentTopic.class);
	}

	@Override
	public CmsContentTopic getCmsContentTopicByCId(String contentId) {
		List<CmsContentTopic>  topicList = CmsContentTopic.findByProperty(CmsContentTopic.class, "contentId", contentId);
		if(topicList!=null && topicList.size()>0){
			CmsContentTopic cmsContentTopic =  topicList.get(0);
			return cmsContentTopic;
		}
		return null;
	}
	
}
