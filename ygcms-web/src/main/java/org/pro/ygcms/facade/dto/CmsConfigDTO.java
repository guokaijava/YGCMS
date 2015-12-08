package org.pro.ygcms.facade.dto;

import java.sql.Timestamp;

import java.util.Date;

import java.io.Serializable;

public class CmsConfigDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private Integer port;

	private Integer markHeight;

	private Integer markWidth;

	private String emailHost;

	private String dbFileUri;

	private String markImage;

	private Date countClearTime;

	private Date countClearTimeEnd;

	private String defImg;

	private Boolean markOn;

	private Integer markOffsetX;

	private Timestamp countCopyTime;

	private String loginUrl;

	private Integer markOffsetY;

	private Integer downloadTime;

	private String markColor;

	private String processUrl;

	private Boolean viewOnlyChecked;

	private String markContent;

	private Boolean isUploadToDb;

	private String servletPoint;

	private String emailPersonal;

	private String emailPassword;

	private String emailUsername;

	private Integer markPosition;

	private String emailEncoding;

	private Integer markSize;

	private Boolean emailValidate;

	private String contextPath;

	private Integer markAlpha;

	private String downloadCode;

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getPort() {
		return this.port;
	}

	public void setMarkHeight(Integer markHeight) {
		this.markHeight = markHeight;
	}

	public Integer getMarkHeight() {
		return this.markHeight;
	}

	public void setMarkWidth(Integer markWidth) {
		this.markWidth = markWidth;
	}

	public Integer getMarkWidth() {
		return this.markWidth;
	}

	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}

	public String getEmailHost() {
		return this.emailHost;
	}

	public void setDbFileUri(String dbFileUri) {
		this.dbFileUri = dbFileUri;
	}

	public String getDbFileUri() {
		return this.dbFileUri;
	}

	public void setMarkImage(String markImage) {
		this.markImage = markImage;
	}

	public String getMarkImage() {
		return this.markImage;
	}

	public void setCountClearTime(Date countClearTime) {
		this.countClearTime = countClearTime;
	}

	public Date getCountClearTime() {
		return this.countClearTime;
	}

	public void setCountClearTimeEnd(Date countClearTimeEnd) {
		this.countClearTimeEnd = countClearTimeEnd;
	}

	public Date getCountClearTimeEnd() {
		return this.countClearTimeEnd;
	}

	public void setDefImg(String defImg) {
		this.defImg = defImg;
	}

	public String getDefImg() {
		return this.defImg;
	}

	public void setMarkOn(Boolean markOn) {
		this.markOn = markOn;
	}

	public Boolean getMarkOn() {
		return this.markOn;
	}

	public void setMarkOffsetX(Integer markOffsetX) {
		this.markOffsetX = markOffsetX;
	}

	public Integer getMarkOffsetX() {
		return this.markOffsetX;
	}

	public void setCountCopyTime(Timestamp countCopyTime) {
		this.countCopyTime = countCopyTime;
	}

	public Timestamp getCountCopyTime() {
		return this.countCopyTime;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginUrl() {
		return this.loginUrl;
	}

	public void setMarkOffsetY(Integer markOffsetY) {
		this.markOffsetY = markOffsetY;
	}

	public Integer getMarkOffsetY() {
		return this.markOffsetY;
	}

	public void setDownloadTime(Integer downloadTime) {
		this.downloadTime = downloadTime;
	}

	public Integer getDownloadTime() {
		return this.downloadTime;
	}

	public void setMarkColor(String markColor) {
		this.markColor = markColor;
	}

	public String getMarkColor() {
		return this.markColor;
	}

	public void setProcessUrl(String processUrl) {
		this.processUrl = processUrl;
	}

	public String getProcessUrl() {
		return this.processUrl;
	}

	public void setViewOnlyChecked(Boolean viewOnlyChecked) {
		this.viewOnlyChecked = viewOnlyChecked;
	}

	public Boolean getViewOnlyChecked() {
		return this.viewOnlyChecked;
	}

	public void setMarkContent(String markContent) {
		this.markContent = markContent;
	}

	public String getMarkContent() {
		return this.markContent;
	}

	public void setIsUploadToDb(Boolean isUploadToDb) {
		this.isUploadToDb = isUploadToDb;
	}

	public Boolean getIsUploadToDb() {
		return this.isUploadToDb;
	}

	public void setServletPoint(String servletPoint) {
		this.servletPoint = servletPoint;
	}

	public String getServletPoint() {
		return this.servletPoint;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getEmailPersonal() {
		return this.emailPersonal;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public String getEmailPassword() {
		return this.emailPassword;
	}

	public void setEmailUsername(String emailUsername) {
		this.emailUsername = emailUsername;
	}

	public String getEmailUsername() {
		return this.emailUsername;
	}

	public void setMarkPosition(Integer markPosition) {
		this.markPosition = markPosition;
	}

	public Integer getMarkPosition() {
		return this.markPosition;
	}

	public void setEmailEncoding(String emailEncoding) {
		this.emailEncoding = emailEncoding;
	}

	public String getEmailEncoding() {
		return this.emailEncoding;
	}

	public void setMarkSize(Integer markSize) {
		this.markSize = markSize;
	}

	public Integer getMarkSize() {
		return this.markSize;
	}

	public void setEmailValidate(Boolean emailValidate) {
		this.emailValidate = emailValidate;
	}

	public Boolean getEmailValidate() {
		return this.emailValidate;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getContextPath() {
		return this.contextPath;
	}

	public void setMarkAlpha(Integer markAlpha) {
		this.markAlpha = markAlpha;
	}

	public Integer getMarkAlpha() {
		return this.markAlpha;
	}

	public void setDownloadCode(String downloadCode) {
		this.downloadCode = downloadCode;
	}

	public String getDownloadCode() {
		return this.downloadCode;
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
		CmsConfigDTO other = (CmsConfigDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}