package org.pro.ygcms.core.domain.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 信息栏目关系实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_content_channel")
public class CmsContentChannel extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3265673396430946452L;

	@Column(name = "channel_id")
	private int channelId;

	@Column(name = "content_id")
	private int contentId;

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}