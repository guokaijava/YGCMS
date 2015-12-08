package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.content.CmsContentTopic;

public interface CmsContentTopicApplication {

	public CmsContentTopic getCmsContentTopic(Long id);
	
	public void creatCmsContentTopic(CmsContentTopic cmsContentTopic);
	
	public void updateCmsContentTopic(CmsContentTopic cmsContentTopic);
	
	public void removeCmsContentTopic(CmsContentTopic cmsContentTopic);
	
	public void removeCmsContentTopics(Set<CmsContentTopic> cmsContentTopics);
	
	public List<CmsContentTopic> findAllCmsContentTopic();
	
}

