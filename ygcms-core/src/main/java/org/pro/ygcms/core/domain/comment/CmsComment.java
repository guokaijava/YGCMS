package org.pro.ygcms.core.domain.comment;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 信息评论实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_comment")
public class CmsComment extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8716647772755031529L;

	@Column(name = "comment_user_id")
	private int commentUserId;

	@Column(name = "reply_user_id")
	private int replyUserId;

	@Column(name = "content_id")
	private int contentId;

	@Column(name = "site_id")
	private int siteId;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "reply_time")
	private Timestamp replyTime;

	@Column(name = "ups")
	private short ups;

	@Column(name = "downs")
	private short downs;

	@Column(name = "is_recommend")
	private Boolean isRecommend;

	@Column(name = "is_checked")
	private Boolean isChecked;

	@Column(name = "score")
	private int score;

	public int getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}

	public int getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(int replyUserId) {
		this.replyUserId = replyUserId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public short getUps() {
		return ups;
	}

	public void setUps(short ups) {
		this.ups = ups;
	}

	public short getDowns() {
		return downs;
	}

	public void setDowns(short downs) {
		this.downs = downs;
	}

	public Boolean getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}