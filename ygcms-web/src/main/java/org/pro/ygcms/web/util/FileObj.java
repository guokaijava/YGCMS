package org.pro.ygcms.web.util;

public class FileObj {
	String fileName;
	Long size;
	String localpath;

	public String getLocalpath() {
		return localpath;
	}

	public void setLocalpath(String localpath) {
		this.localpath = localpath;
	}

	public FileObj( String filename, Long size,String localpath) {
		this.localpath = localpath;
		this.fileName = filename;
		this.size = size;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
}
