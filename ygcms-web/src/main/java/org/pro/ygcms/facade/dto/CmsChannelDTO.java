package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsChannelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private String modelId;

	private String parentId;

	private int isDisplay;

	private String siteId;

	private int priority;

	private int lft;

	private int rgt;

	private String channelPath;

	private int hasContent;
	
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setHasContent(int hasContent) {
		this.hasContent = hasContent;
	}

	private String channelName;
	

	public CmsChannelDTO() {
	}
	
	public CmsChannelDTO(String cid,int isDisplay,String channelName,String channelPath){
		this.id = cid;
		this.isDisplay = isDisplay;
		this.channelName = channelName;
		this.channelPath = channelPath;
	}
	

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelId() {
		return this.modelId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

	public Integer getIsDisplay() {
		return this.isDisplay;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteId() {
		return this.siteId;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public int getLft() {
		return this.lft;
	}

	public void setRgt(int rgt) {
		this.rgt = rgt;
	}

	public int getRgt() {
		return this.rgt;
	}

	public void setChannelPath(String channelPath) {
		this.channelPath = channelPath;
	}

	public String getChannelPath() {
		return this.channelPath;
	}

	public void setHasContent(Integer hasContent) {
		this.hasContent = hasContent;
	}

	public Integer getHasContent() {
		return this.hasContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CmsChannelDTO other = (CmsChannelDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}