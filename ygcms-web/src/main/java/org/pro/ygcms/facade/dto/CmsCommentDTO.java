package org.pro.ygcms.facade.dto;

import java.sql.Timestamp;

import java.io.Serializable;

public class CmsCommentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private Timestamp createTime;

	private Integer siteId;

	private Boolean isChecked;

	private Integer score;

	private Integer replyUserId;

	private Short downs;

	private Short ups;

	private Timestamp replyTime;

	private Integer commentUserId;

	private Boolean isRecommend;

	private Integer contentId;

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getSiteId() {
		return this.siteId;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public Boolean getIsChecked() {
		return this.isChecked;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setReplyUserId(Integer replyUserId) {
		this.replyUserId = replyUserId;
	}

	public Integer getReplyUserId() {
		return this.replyUserId;
	}

	public void setDowns(Short downs) {
		this.downs = downs;
	}

	public Short getDowns() {
		return this.downs;
	}

	public void setUps(Short ups) {
		this.ups = ups;
	}

	public Short getUps() {
		return this.ups;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setCommentUserId(Integer commentUserId) {
		this.commentUserId = commentUserId;
	}

	public Integer getCommentUserId() {
		return this.commentUserId;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Boolean getIsRecommend() {
		return this.isRecommend;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getContentId() {
		return this.contentId;
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
		CmsCommentDTO other = (CmsCommentDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}