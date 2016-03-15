package org.pro.ygcms.facade.dto;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.pro.ygcms.web.util.DateTimeUtil;

import java.io.Serializable;

public class CmsContentExtDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private String mediaPath;

	private String link;

	private String origin;

	private String titleColor;

	private Boolean needRegenerate;

	private String contentId;

	private String mediaType;

	private String author;

	private String title;

	private String contentImg;

	private String releaseDate;

	private String shortTitle;

	private String description;

	private String tplContent;

	private String originUrl;

	private String titleImg;

	private String typeImg;

	private Boolean isBold;
	
	//CmsContentDTO属性
	private String channelId;//栏目id
	
	private String modelId;//模型id

	private String siteId;//站点id
	
	private Short topLevel;//固顶级别
	
	private String typeId;//内容类型id
	
	//CmsContentTopicDTO属性
	private String topicId;//专题id
	
	//CmsContentTagDTO属性
	private String tagStr;//标签
	
	//CmsContentTxtDTO属性
	private String txt;//内容
	
	//CmsContentAttachmentDTO属性
	private String attachments;
	
	private String media;
	
	//CmsContentPictureDTO属性
	private String[] pictures;//图片集

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	public String getMediaPath() {
		return this.mediaPath;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return this.link;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}

	public String getTitleColor() {
		return this.titleColor;
	}

	public void setNeedRegenerate(Boolean needRegenerate) {
		this.needRegenerate = needRegenerate;
	}

	public Boolean getNeedRegenerate() {
		return this.needRegenerate;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentId() {
		return this.contentId;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaType() {
		return this.mediaType;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}

	public String getContentImg() {
		return this.contentImg;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getShortTitle() {
		return this.shortTitle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setTplContent(String tplContent) {
		this.tplContent = tplContent;
	}

	public String getTplContent() {
		return this.tplContent;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

	public String getOriginUrl() {
		return this.originUrl;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getTitleImg() {
		return this.titleImg;
	}

	public void setTypeImg(String typeImg) {
		this.typeImg = typeImg;
	}

	public String getTypeImg() {
		return this.typeImg;
	}

	public void setIsBold(Boolean isBold) {
		this.isBold = isBold;
	}

	public Boolean getIsBold() {
		return this.isBold;
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
	
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public Short getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(Short topLevel) {
		this.topLevel = topLevel;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTagStr() {
		return tagStr;
	}

	public void setTagStr(String tagStr) {
		this.tagStr = tagStr;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String[] getPictures() {
		return pictures;
	}

	public void setPictures(String[] pictures) {
		this.pictures = pictures;
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
		CmsContentExtDTO other = (CmsContentExtDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void blankToNull() {
		if (StringUtils.isBlank(this.getShortTitle())) {
			this.setShortTitle(null);
		}
		if (StringUtils.isBlank(this.getAuthor())) {
			this.setAuthor(null);
		}
		if (StringUtils.isBlank(this.getOrigin())) {
			this.setOrigin(null);
		}
		if (StringUtils.isBlank(this.getOriginUrl())) {
			this.setOriginUrl(null);
		}
		if (StringUtils.isBlank(this.getDescription())) {
			this.setDescription(null);
		}
		if (StringUtils.isBlank(this.getTitleColor())) {
			this.setTitleColor(null);
		}
		if (StringUtils.isBlank(this.getTitleImg())) {
			this.setTitleImg(null);
		}
		if (StringUtils.isBlank(this.getContentImg())) {
			this.setContentImg(null);
		}
		if (StringUtils.isBlank(this.getTypeImg())) {
			this.setTypeImg(null);
		}
		if (StringUtils.isBlank(this.getLink())) {
			this.setLink(null);
		}
		if (StringUtils.isBlank(this.getTplContent())) {
			this.setTplContent(null);
		}
		if (StringUtils.isBlank(this.getMediaPath())) {
			this.setMediaPath(null);
		}
		if (StringUtils.isBlank(this.getMediaType())) {
			this.setMediaType(null);
		}
	}

	
	public void init() {
		if (this.getReleaseDate() == null) {
//			this.setReleaseDate(new Timestamp(System.currentTimeMillis()));
			this.setReleaseDate(DateTimeUtil.Date2String(new Date(), "yyyy-MM-dd"));
//			this.setReleaseDate(DateTimeUtil.Date2String(new Date(), "yyyy-MM-dd HH:mm:ss"));
		}
		if (this.getIsBold() == null) {
			this.setIsBold(false);
		}
		if(this.getNeedRegenerate()==null){
			this.setNeedRegenerate(true);
		}
		blankToNull();
	}
}