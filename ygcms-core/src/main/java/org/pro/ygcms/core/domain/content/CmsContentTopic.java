package org.pro.ygcms.core.domain.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 信息主题实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_content_topic")
public class CmsContentTopic extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5193559420802725602L;

	@Column(name = "content_id")
	private String contentId;

	@Column(name = "topic_id")
	private String topicId;

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}