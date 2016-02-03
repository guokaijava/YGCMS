package org.pro.ygcms.application;


import java.util.List;
import java.util.Set;
import  org.pro.ygcms.core.domain.channel.CmsTopic;

public interface CmsTopicApplication {

	public CmsTopic getCmsTopic(String id);
	
	public void creatCmsTopic(CmsTopic cmsTopic);
	
	public void updateCmsTopic(CmsTopic cmsTopic);
	
	public void removeCmsTopic(CmsTopic cmsTopic);
	
	public void removeCmsTopics(Set<CmsTopic> cmsTopics);
	
	public List<CmsTopic> findAllCmsTopic();
	
}

