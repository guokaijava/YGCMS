package org.pro.ygcms.facade.dto;

import java.sql.Timestamp;

import java.io.Serializable;

public class CmsContentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private Boolean hasTitleImg;

	private Integer viewsDay;

	private Timestamp sortDate;

	private Short commentsDay;

	private String channelId;

	private Short status;

	private Integer score;

	private String modelId;

	private String siteId;

	private String userId;

	private Short downloadsDay;

	private String typeId;

	private Short upsDay;

	private Short topLevel;

	private Boolean isRecommend;

	public void setHasTitleImg(Boolean hasTitleImg) {
		this.hasTitleImg = hasTitleImg;
	}

	public Boolean getHasTitleImg() {
		return this.hasTitleImg;
	}

	public void setViewsDay(Integer viewsDay) {
		this.viewsDay = viewsDay;
	}

	public Integer getViewsDay() {
		return this.viewsDay;
	}

	public void setSortDate(Timestamp sortDate) {
		this.sortDate = sortDate;
	}

	public Timestamp getSortDate() {
		return this.sortDate;
	}

	public void setCommentsDay(Short commentsDay) {
		this.commentsDay = commentsDay;
	}

	public Short getCommentsDay() {
		return this.commentsDay;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelId() {
		return this.channelId;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelId() {
		return this.modelId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteId() {
		return this.siteId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setDownloadsDay(Short downloadsDay) {
		this.downloadsDay = downloadsDay;
	}

	public Short getDownloadsDay() {
		return this.downloadsDay;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setUpsDay(Short upsDay) {
		this.upsDay = upsDay;
	}

	public Short getUpsDay() {
		return this.upsDay;
	}

	public void setTopLevel(Short topLevel) {
		this.topLevel = topLevel;
	}

	public Short getTopLevel() {
		return this.topLevel;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Boolean getIsRecommend() {
		return this.isRecommend;
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
		CmsContentDTO other = (CmsContentDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}