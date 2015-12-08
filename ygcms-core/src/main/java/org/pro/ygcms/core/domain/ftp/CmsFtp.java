package org.pro.ygcms.core.domain.ftp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * Ftp管理
 * 
 * @author 郭凯
 * 
 */
@Entity
@Table(name="cms_ftp")
public class CmsFtp extends CmsAbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "ftp_name")
	private String ftpname;

	@Column(name = "ip")
	private String ip;

	@Column(name = "port")
	private int port;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "encoding")
	private String encoding;

	@Column(name = "timeout")
	private int timeout;

	@Column(name = "ftp_path")
	private String ftppath;

	@Column(name = "url")
	private String url;

	public String getFtpname() {
		return ftpname;
	}

	public void setFtpname(String ftpname) {
		this.ftpname = ftpname;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncoding() {
		return encoding;
	}


	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}


	public int getTimeout() {
		return timeout;
	}


	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}


	public String getFtppath() {
		return ftppath;
	}


	public void setFtppath(String ftppath) {
		this.ftppath = ftppath;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}


}