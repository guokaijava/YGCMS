package org.pro.ygcms.core.domain.content;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 信息实体类 
 * 作者：郭凯 
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_content")
public class CmsContent extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7567394041535559128L;

	@Column(name = "channel_id")
	private String channelId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "type_id")
	private String typeId;

	@Column(name = "model_id")
	private String modelId;

	@Column(name = "site_id")
	private String siteId;

	@Column(name = "sort_date")
	private Timestamp sortDate;

	@Column(name = "top_level")
	private short topLevel;

	@Column(name = "has_title_img")
	private Boolean hasTitleImg;

	@Column(name = "is_recommend")
	private Boolean isRecommend;

	@Column(name = "status")
	private short status;

	@Column(name = "views_day")
	private int viewsDay;

	@Column(name = "comments_day")
	private short commentsDay;

	@Column(name = "downloads_day")
	private short downloadsDay;

	@Column(name = "ups_day")
	private short upsDay;

	@Column(name = "score")
	private int score;
	
	@Column(name = "is_delete")
	private Boolean isDelete;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public Timestamp getSortDate() {
		return sortDate;
	}

	public void setSortDate(Timestamp sortDate) {
		this.sortDate = sortDate;
	}

	public short getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(short topLevel) {
		this.topLevel = topLevel;
	}

	public Boolean getHasTitleImg() {
		return hasTitleImg;
	}

	public void setHasTitleImg(Boolean hasTitleImg) {
		this.hasTitleImg = hasTitleImg;
	}

	public Boolean getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public int getViewsDay() {
		return viewsDay;
	}

	public void setViewsDay(int viewsDay) {
		this.viewsDay = viewsDay;
	}

	public short getCommentsDay() {
		return commentsDay;
	}

	public void setCommentsDay(short commentsDay) {
		this.commentsDay = commentsDay;
	}

	public short getDownloadsDay() {
		return downloadsDay;
	}

	public void setDownloadsDay(short downloadsDay) {
		this.downloadsDay = downloadsDay;
	}

	public short getUpsDay() {
		return upsDay;
	}

	public void setUpsDay(short upsDay) {
		this.upsDay = upsDay;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}