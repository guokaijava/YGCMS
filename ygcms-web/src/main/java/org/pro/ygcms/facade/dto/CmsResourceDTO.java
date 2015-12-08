package org.pro.ygcms.facade.dto;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.pro.ygcms.core.web.Constants;
@SuppressWarnings("unused")
public class CmsResourceDTO implements Serializable,Comparable<CmsResourceDTO> {
	private static final long serialVersionUID = 8988220903811284414L;
	
	public static final String[] EDITABLE_EXT = new String[] { "html","htm","css","js","txt","jpg","png","gif" };
	
	private String id;
	private String name;
	private String path;
	private String fileName;
	private String source;
	private Long lastModified;
	private Date lastModifiedDate;
	private long length;
	private long size;
	private boolean isDirectory;
	private SortedSet<CmsResourceDTO> children = new TreeSet<CmsResourceDTO>();
	private String pname;
	
	
	private File file;
	private String root="/WEB-INF/r/cms/www";
	
	public CmsResourceDTO(){
		
	}
	
	public CmsResourceDTO(File file) {
		this.file = file;
	}
	
	public String getName() {
		String ap = file.getAbsolutePath().substring(root.length());
		ap = ap.replace(File.separatorChar, '/'	);
		// 在resin里root的结尾是带'/'的，这样会导致getName返回的名称不以'/'开头。
		if (!ap.startsWith("/")) {
			ap = "/" + ap;
		}
		return ap;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		String name = getName();
		return name.substring(0, name.lastIndexOf('/'));
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return file.getName();
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSource() {
		if (file.isDirectory()) {
			return null;
		}
		try {
			return FileUtils.readFileToString(this.file, Constants.UTF8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Long getLastModified() {
		return file.lastModified();
	}
	public void setLastModified(Long lastModified) {
		this.lastModified = lastModified;
	}
	public Date getLastModifiedDate() {
		return new Timestamp(getLastModified());
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public long getLength() {
		return file.length();
	}
	public void setLength(long length) {
		this.length = length;
	}
	public long getSize() {
		return (int) (getLength() / 1024) + 1;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public boolean isDirectory() {
		return file.isDirectory();
	}
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	public Set<CmsResourceDTO> getChildren() {
		return children;
	}
	public void setChildren(TreeSet<CmsResourceDTO> children) {
		this.children = children;
	}

	public String getPname() {
		return file.getParentFile().getName();
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public String getId() {
		return file.getName();
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int compareTo(CmsResourceDTO o) {
        return this.getFileName().compareTo(o.getFileName());
	}
	
}
