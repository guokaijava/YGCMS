package org.pro.ygcms.core.domain.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 信息评论属性类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_comment_ext")
public class CmsCommentExt extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7224445367033702018L;

	@Column(name = "comment_id")
	private int commentId;

	@Column(name = "ip")
	private String ip;

	@Column(name = "text")
	private String text;

	@Column(name = "reply")
	private String reply;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}