package org.pro.ygcms.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 栏目属性类 作者：郭凯 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_channel_attr")
public class CmsChannelAttr extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3792200373646641576L;

	@Column(name = "channel_id")
	private String channelId;

	@Column(name = "attr_name")
	private String attrName;

	@Column(name = "attr_value")
	private String attrValue;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

}
