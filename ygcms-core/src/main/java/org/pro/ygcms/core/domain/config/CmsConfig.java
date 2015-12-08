package org.pro.ygcms.core.domain.config;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 全局配置实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_config")
public class CmsConfig extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1551508174887941025L;

	@Column(name = "context_path")
	private String contextPath;

	@Column(name = "servlet_point")
	private String servletPoint;

	@Column(name = "port")
	private int port;

	@Column(name = "db_file_uri")
	private String dbFileUri;

	@Column(name = "is_upload_to_db")
	private Boolean isUploadToDb;

	@Column(name = "def_img")
	private String defImg;

	@Column(name = "login_url")
	private String loginUrl;

	@Column(name = "process_url")
	private String processUrl;

	@Column(name = "mark_on")
	private Boolean markOn;

	@Column(name = "mark_width")
	private int markWidth;

	@Column(name = "mark_height")
	private int markHeight;

	@Column(name = "mark_image")
	private String markImage;

	@Column(name = "mark_content")
	private String markContent;

	@Column(name = "mark_size")
	private int markSize;

	@Column(name = "mark_color")
	private String markColor;

	@Column(name = "mark_alpha")
	private int markAlpha;

	@Column(name = "mark_position")
	private int markPosition;

	@Column(name = "mark_offset_x")
	private int markOffsetX;

	@Column(name = "mark_offset_y")
	private int markOffsetY;

	@Column(name = "count_clear_time")
	private Date countClearTime;

	@Column(name = "count_copy_time")
	private Timestamp countCopyTime;

	@Column(name = "download_code")
	private String downloadCode;

	@Column(name = "download_time")
	private int downloadTime;

	@Column(name = "email_host")
	private String emailHost;

	@Column(name = "email_encoding")
	private String emailEncoding;

	@Column(name = "email_username")
	private String emailUsername;

	@Column(name = "email_password")
	private String emailPassword;

	@Column(name = "email_personal")
	private String emailPersonal;

	@Column(name = "email_validate")
	private Boolean emailValidate;

	@Column(name = "view_only_checked")
	private Boolean viewOnlyChecked;

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getServletPoint() {
		return servletPoint;
	}

	public void setServletPoint(String servletPoint) {
		this.servletPoint = servletPoint;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDbFileUri() {
		return dbFileUri;
	}

	public void setDbFileUri(String dbFileUri) {
		this.dbFileUri = dbFileUri;
	}

	public Boolean getIsUploadToDb() {
		return isUploadToDb;
	}

	public void setIsUploadToDb(Boolean isUploadToDb) {
		this.isUploadToDb = isUploadToDb;
	}

	public String getDefImg() {
		return defImg;
	}

	public void setDefImg(String defImg) {
		this.defImg = defImg;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getProcessUrl() {
		return processUrl;
	}

	public void setProcessUrl(String processUrl) {
		this.processUrl = processUrl;
	}

	public Boolean getMarkOn() {
		return markOn;
	}

	public void setMarkOn(Boolean markOn) {
		this.markOn = markOn;
	}

	public int getMarkWidth() {
		return markWidth;
	}

	public void setMarkWidth(int markWidth) {
		this.markWidth = markWidth;
	}

	public int getMarkHeight() {
		return markHeight;
	}

	public void setMarkHeight(int markHeight) {
		this.markHeight = markHeight;
	}

	public String getMarkImage() {
		return markImage;
	}

	public void setMarkImage(String markImage) {
		this.markImage = markImage;
	}

	public String getMarkContent() {
		return markContent;
	}

	public void setMarkContent(String markContent) {
		this.markContent = markContent;
	}

	public int getMarkSize() {
		return markSize;
	}

	public void setMarkSize(int markSize) {
		this.markSize = markSize;
	}

	public String getMarkColor() {
		return markColor;
	}

	public void setMarkColor(String markColor) {
		this.markColor = markColor;
	}

	public int getMarkAlpha() {
		return markAlpha;
	}

	public void setMarkAlpha(int markAlpha) {
		this.markAlpha = markAlpha;
	}

	public int getMarkPosition() {
		return markPosition;
	}

	public void setMarkPosition(int markPosition) {
		this.markPosition = markPosition;
	}

	public int getMarkOffsetX() {
		return markOffsetX;
	}

	public void setMarkOffsetX(int markOffsetX) {
		this.markOffsetX = markOffsetX;
	}

	public int getMarkOffsetY() {
		return markOffsetY;
	}

	public void setMarkOffsetY(int markOffsetY) {
		this.markOffsetY = markOffsetY;
	}

	public Date getCountClearTime() {
		return countClearTime;
	}

	public void setCountClearTime(Date countClearTime) {
		this.countClearTime = countClearTime;
	}

	public Timestamp getCountCopyTime() {
		return countCopyTime;
	}

	public void setCountCopyTime(Timestamp countCopyTime) {
		this.countCopyTime = countCopyTime;
	}

	public String getDownloadCode() {
		return downloadCode;
	}

	public void setDownloadCode(String downloadCode) {
		this.downloadCode = downloadCode;
	}

	public int getDownloadTime() {
		return downloadTime;
	}

	public void setDownloadTime(int downloadTime) {
		this.downloadTime = downloadTime;
	}

	public String getEmailHost() {
		return emailHost;
	}

	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}

	public String getEmailEncoding() {
		return emailEncoding;
	}

	public void setEmailEncoding(String emailEncoding) {
		this.emailEncoding = emailEncoding;
	}

	public String getEmailUsername() {
		return emailUsername;
	}

	public void setEmailUsername(String emailUsername) {
		this.emailUsername = emailUsername;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public Boolean getEmailValidate() {
		return emailValidate;
	}

	public void setEmailValidate(Boolean emailValidate) {
		this.emailValidate = emailValidate;
	}

	public Boolean getViewOnlyChecked() {
		return viewOnlyChecked;
	}

	public void setViewOnlyChecked(Boolean viewOnlyChecked) {
		this.viewOnlyChecked = viewOnlyChecked;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}