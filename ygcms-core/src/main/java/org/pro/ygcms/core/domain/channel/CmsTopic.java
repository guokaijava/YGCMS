package org.pro.ygcms.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 专题实体类 作者：郭凯 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_topic")
public class CmsTopic extends CmsAbstractEntity {

	private static final long serialVersionUID = 5308830999019717681L;

	@Column(name = "channel_id")
	private String channelid;

	@Column(name = "topic_name")
	private String topicname;

	@Column(name = "short_name")
	private String shortname;

	@Column(name = "keywords")
	private String keywords;

	@Column(name = "description")
	private String description;

	@Column(name = "title_img")
	private String titleimg;

	@Column(name = "content_img")
	private String contentimg;

	@Column(name = "tpl_content")
	private String tplcontent;

	@Column(name = "priority")
	private int priority;

	@Column(name = "is_recommend")
	private int isrecommend;

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public String getTopicname() {
		return topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitleimg() {
		return titleimg;
	}

	public void setTitleimg(String titleimg) {
		this.titleimg = titleimg;
	}

	public String getContentimg() {
		return contentimg;
	}

	public void setContentimg(String contentimg) {
		this.contentimg = contentimg;
	}

	public String getTplcontent() {
		return tplcontent;
	}

	public void setTplcontent(String tplcontent) {
		this.tplcontent = tplcontent;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(int isrecommend) {
		this.isrecommend = isrecommend;
	}

}
