package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsContentTypeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private Integer hasimage;

	private Integer imgwidth;

	private Integer isdisabled;

	private Integer imgheight;

	private String typename;

	public void setHasimage(Integer hasimage) {
		this.hasimage = hasimage;
	}

	public Integer getHasimage() {
		return this.hasimage;
	}

	public void setImgwidth(Integer imgwidth) {
		this.imgwidth = imgwidth;
	}

	public Integer getImgwidth() {
		return this.imgwidth;
	}

	public void setIsdisabled(Integer isdisabled) {
		this.isdisabled = isdisabled;
	}

	public Integer getIsdisabled() {
		return this.isdisabled;
	}

	public void setImgheight(Integer imgheight) {
		this.imgheight = imgheight;
	}

	public Integer getImgheight() {
		return this.imgheight;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTypename() {
		return this.typename;
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
		CmsContentTypeDTO other = (CmsContentTypeDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}