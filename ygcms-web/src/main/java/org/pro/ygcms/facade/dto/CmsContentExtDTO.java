package org.pro.ygcms.facade.dto;

import java.sql.Timestamp;

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

	private Integer contentId;

	private String mediaType;

	private String author;

	private String title;

	private String contentImg;

	private Timestamp releaseDate;

	private String shortTitle;

	private String description;

	private String tplContent;

	private String originUrl;

	private String titleImg;

	private String typeImg;

	private Boolean isBold;

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

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getContentId() {
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

	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Timestamp getReleaseDate() {
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
}