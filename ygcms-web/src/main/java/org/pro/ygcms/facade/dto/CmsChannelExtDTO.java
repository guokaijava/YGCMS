package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsChannelExtDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private Boolean hasTitleImg;

	private Boolean allowUpdown;

	private Integer contentImgHeight;

	private String channelRule;

	private String link;

	private Boolean allowShare;

	private String isStaticChannel;

	private String isStaticContent;

	private String tplChannel;

	private Integer commentControl;

	private String title;

	private Short finalStep;

	private String contentImg;

	private String description;

	private Boolean hasContentImg;

	private String titleImg;

	private Integer titleImgHeight;

	private Boolean isBlank;

	private String isAccessByDir;

	private String channelName;

	private String keywords;

	private String channelId;

	private Short afterCheck;

	private Integer pageSize;

	private String contentRule;

	private Integer contentImgWidth;

	private Boolean allowScore;

	private Integer titleImgWidth;

	private String tplContent;

	private String isListChild;

	public void setHasTitleImg(Boolean hasTitleImg) {
		this.hasTitleImg = hasTitleImg;
	}

	public Boolean getHasTitleImg() {
		return this.hasTitleImg;
	}

	public void setAllowUpdown(Boolean allowUpdown) {
		this.allowUpdown = allowUpdown;
	}

	public Boolean getAllowUpdown() {
		return this.allowUpdown;
	}

	public void setContentImgHeight(Integer contentImgHeight) {
		this.contentImgHeight = contentImgHeight;
	}

	public Integer getContentImgHeight() {
		return this.contentImgHeight;
	}

	public void setChannelRule(String channelRule) {
		this.channelRule = channelRule;
	}

	public String getChannelRule() {
		return this.channelRule;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return this.link;
	}

	public void setAllowShare(Boolean allowShare) {
		this.allowShare = allowShare;
	}

	public Boolean getAllowShare() {
		return this.allowShare;
	}

	public void setIsStaticChannel(String isStaticChannel) {
		this.isStaticChannel = isStaticChannel;
	}

	public String getIsStaticChannel() {
		return this.isStaticChannel;
	}

	public void setIsStaticContent(String isStaticContent) {
		this.isStaticContent = isStaticContent;
	}

	public String getIsStaticContent() {
		return this.isStaticContent;
	}

	public void setTplChannel(String tplChannel) {
		this.tplChannel = tplChannel;
	}

	public String getTplChannel() {
		return this.tplChannel;
	}

	public void setCommentControl(Integer commentControl) {
		this.commentControl = commentControl;
	}

	public Integer getCommentControl() {
		return this.commentControl;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setFinalStep(Short finalStep) {
		this.finalStep = finalStep;
	}

	public Short getFinalStep() {
		return this.finalStep;
	}

	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}

	public String getContentImg() {
		return this.contentImg;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setHasContentImg(Boolean hasContentImg) {
		this.hasContentImg = hasContentImg;
	}

	public Boolean getHasContentImg() {
		return this.hasContentImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getTitleImg() {
		return this.titleImg;
	}

	public void setTitleImgHeight(Integer titleImgHeight) {
		this.titleImgHeight = titleImgHeight;
	}

	public Integer getTitleImgHeight() {
		return this.titleImgHeight;
	}

	public void setIsBlank(Boolean isBlank) {
		this.isBlank = isBlank;
	}

	public Boolean getIsBlank() {
		return this.isBlank;
	}

	public void setIsAccessByDir(String isAccessByDir) {
		this.isAccessByDir = isAccessByDir;
	}

	public String getIsAccessByDir() {
		return this.isAccessByDir;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelId() {
		return this.channelId;
	}

	public void setAfterCheck(Short afterCheck) {
		this.afterCheck = afterCheck;
	}

	public Short getAfterCheck() {
		return this.afterCheck;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public void setContentRule(String contentRule) {
		this.contentRule = contentRule;
	}

	public String getContentRule() {
		return this.contentRule;
	}

	public void setContentImgWidth(Integer contentImgWidth) {
		this.contentImgWidth = contentImgWidth;
	}

	public Integer getContentImgWidth() {
		return this.contentImgWidth;
	}

	public void setAllowScore(Boolean allowScore) {
		this.allowScore = allowScore;
	}

	public Boolean getAllowScore() {
		return this.allowScore;
	}

	public void setTitleImgWidth(Integer titleImgWidth) {
		this.titleImgWidth = titleImgWidth;
	}

	public Integer getTitleImgWidth() {
		return this.titleImgWidth;
	}

	public void setTplContent(String tplContent) {
		this.tplContent = tplContent;
	}

	public String getTplContent() {
		return this.tplContent;
	}

	public void setIsListChild(String isListChild) {
		this.isListChild = isListChild;
	}

	public String getIsListChild() {
		return this.isListChild;
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
		CmsChannelExtDTO other = (CmsChannelExtDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}