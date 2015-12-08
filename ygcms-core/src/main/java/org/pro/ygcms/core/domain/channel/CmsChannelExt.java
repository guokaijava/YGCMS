package org.pro.ygcms.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 栏目属性类 
 * 作者：郭凯 
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_channel_ext")
public class CmsChannelExt extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8361397107253342037L;

	@Column(name = "channel_id")
	private String channelId;

	@Column(name = "channel_name")
	private String channelName;

	@Column(name = "final_step")
	private short finalStep;

	@Column(name = "after_check")
	private short afterCheck;

	@Column(name = "is_static_channel")
	private String isStaticChannel;

	@Column(name = "is_static_content")
	private String isStaticContent;

	@Column(name = "is_access_by_dir")
	private String isAccessByDir;

	@Column(name = "is_list_child")
	private String isListChild;

	@Column(name = "page_size")
	private int pageSize;

	@Column(name = "channel_rule")
	private String channelRule;

	@Column(name = "content_rule")
	private String contentRule;

	@Column(name = "link")
	private String link;

	@Column(name = "tpl_channel")
	private String tplChannel;

	@Column(name = "tpl_content")
	private String tplContent;

	@Column(name = "title_img")
	private String titleImg;

	@Column(name = "content_img")
	private String contentImg;

	@Column(name = "has_title_img")
	private Boolean hasTitleImg;

	@Column(name = "has_content_img")
	private Boolean hasContentImg;

	@Column(name = "title_img_width")
	private int titleImgWidth;

	@Column(name = "title_img_height")
	private int titleImgHeight;

	@Column(name = "content_img_width")
	private int contentImgWidth;

	@Column(name = "content_img_height")
	private int contentImgHeight;

	@Column(name = "comment_control")
	private int commentControl;

	@Column(name = "allow_updown")
	private Boolean allowUpdown;

	@Column(name = "is_blank")
	private Boolean isBlank;

	@Column(name = "title")
	private String title;

	@Column(name = "keywords")
	private String keywords;

	@Column(name = "description")
	private String description;

	@Column(name = "allow_share")
	private Boolean allowShare;

	@Column(name = "allow_score")
	private Boolean allowScore;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public short getFinalStep() {
		return finalStep;
	}

	public void setFinalStep(short finalStep) {
		this.finalStep = finalStep;
	}

	public short getAfterCheck() {
		return afterCheck;
	}

	public void setAfterCheck(short afterCheck) {
		this.afterCheck = afterCheck;
	}

	public String getIsStaticChannel() {
		return isStaticChannel;
	}

	public void setIsStaticChannel(String isStaticChannel) {
		this.isStaticChannel = isStaticChannel;
	}

	public String getIsStaticContent() {
		return isStaticContent;
	}

	public void setIsStaticContent(String isStaticContent) {
		this.isStaticContent = isStaticContent;
	}

	public String getIsAccessByDir() {
		return isAccessByDir;
	}

	public void setIsAccessByDir(String isAccessByDir) {
		this.isAccessByDir = isAccessByDir;
	}

	public String getIsListChild() {
		return isListChild;
	}

	public void setIsListChild(String isListChild) {
		this.isListChild = isListChild;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getChannelRule() {
		return channelRule;
	}

	public void setChannelRule(String channelRule) {
		this.channelRule = channelRule;
	}

	public String getContentRule() {
		return contentRule;
	}

	public void setContentRule(String contentRule) {
		this.contentRule = contentRule;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTplChannel() {
		return tplChannel;
	}

	public void setTplChannel(String tplChannel) {
		this.tplChannel = tplChannel;
	}

	public String getTplContent() {
		return tplContent;
	}

	public void setTplContent(String tplContent) {
		this.tplContent = tplContent;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getContentImg() {
		return contentImg;
	}

	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}

	public Boolean getHasTitleImg() {
		return hasTitleImg;
	}

	public void setHasTitleImg(Boolean hasTitleImg) {
		this.hasTitleImg = hasTitleImg;
	}

	public Boolean getHasContentImg() {
		return hasContentImg;
	}

	public void setHasContentImg(Boolean hasContentImg) {
		this.hasContentImg = hasContentImg;
	}

	public int getTitleImgWidth() {
		return titleImgWidth;
	}

	public void setTitleImgWidth(int titleImgWidth) {
		this.titleImgWidth = titleImgWidth;
	}

	public int getTitleImgHeight() {
		return titleImgHeight;
	}

	public void setTitleImgHeight(int titleImgHeight) {
		this.titleImgHeight = titleImgHeight;
	}

	public int getContentImgWidth() {
		return contentImgWidth;
	}

	public void setContentImgWidth(int contentImgWidth) {
		this.contentImgWidth = contentImgWidth;
	}

	public int getContentImgHeight() {
		return contentImgHeight;
	}

	public void setContentImgHeight(int contentImgHeight) {
		this.contentImgHeight = contentImgHeight;
	}

	public int getCommentControl() {
		return commentControl;
	}

	public void setCommentControl(int commentControl) {
		this.commentControl = commentControl;
	}

	public Boolean getAllowUpdown() {
		return allowUpdown;
	}

	public void setAllowUpdown(Boolean allowUpdown) {
		this.allowUpdown = allowUpdown;
	}

	public Boolean getIsBlank() {
		return isBlank;
	}

	public void setIsBlank(Boolean isBlank) {
		this.isBlank = isBlank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Boolean getAllowShare() {
		return allowShare;
	}

	public void setAllowShare(Boolean allowShare) {
		this.allowShare = allowShare;
	}

	public Boolean getAllowScore() {
		return allowScore;
	}

	public void setAllowScore(Boolean allowScore) {
		this.allowScore = allowScore;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}