package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsConfigAttrDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private String attrName;

	private String attrValue;

	private Integer configId;

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrName() {
		return this.attrName;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public String getAttrValue() {
		return this.attrValue;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public Integer getConfigId() {
		return this.configId;
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
		CmsConfigAttrDTO other = (CmsConfigAttrDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}