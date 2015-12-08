package org.pro.ygcms.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 栏目实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_channel")
public class CmsChannel extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1657136730350104784L;

	@Column(name = "channel_path")
	private String channelPath;

	@Column(name = "has_content")
	private int hasContent;

	@Column(name = "is_display")
	private int isDisplay;

	@Column(name = "lft")
	private int lft;

	@Column(name = "model_id")
	private String modelId;

	@Column(name = "parent_id")
	private String parentId;

	@Column(name = "priority")
	private int priority;

	@Column(name = "rgt")
	private int rgt;

	@Column(name = "site_id")
	private String siteId;

	@Column(name = "channel_name")
	private String channelName;
	
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelPath() {
		return channelPath;
	}

	public void setChannelPath(String channelPath) {
		this.channelPath = channelPath;
	}

	public int getHasContent() {
		return hasContent;
	}

	public void setHasContent(int hasContent) {
		this.hasContent = hasContent;
	}

	public int getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}

	public int getLft() {
		return lft;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getRgt() {
		return rgt;
	}

	public void setRgt(int rgt) {
		this.rgt = rgt;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	
	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}