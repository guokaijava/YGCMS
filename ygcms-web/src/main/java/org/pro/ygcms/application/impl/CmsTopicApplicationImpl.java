package org.pro.ygcms.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import org.pro.ygcms.application.CmsTopicApplication;
import org.pro.ygcms.core.domain.channel.CmsTopic;

@Named
@Transactional
public class CmsTopicApplicationImpl implements CmsTopicApplication {

	public CmsTopic getCmsTopic(String id) {
		return CmsTopic.get(CmsTopic.class, id);
	}
	
	public void creatCmsTopic(CmsTopic cmsTopic) {
		cmsTopic.save();
	}
	
	public void updateCmsTopic(CmsTopic cmsTopic) {
		cmsTopic .save();
	}
	
	public void removeCmsTopic(CmsTopic cmsTopic) {
		if(cmsTopic != null){
			cmsTopic.remove();
		}
	}
	
	public void removeCmsTopics(Set<CmsTopic> cmsTopics) {
		for (CmsTopic cmsTopic : cmsTopics) {
			cmsTopic.remove();
		}
	}
	
	public List<CmsTopic> findAllCmsTopic() {
		return CmsTopic.findAll(CmsTopic.class);
	}
	
}
