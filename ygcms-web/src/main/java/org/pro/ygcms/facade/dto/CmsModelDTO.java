package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsModelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private Integer isdef;

	private String modelname;

	private Integer titleimgwidth;

	private Integer titleimgheight;

	private Integer isdisabled;

	private String modelpath;

	private Integer priority;

	private String tplcontentprefix;

	private String tplchannelprefix;

	private Integer hascontent;

	private Integer contentimgwidth;

	private Integer contentimgheight;

	public void setIsdef(Integer isdef) {
		this.isdef = isdef;
	}

	public Integer getIsdef() {
		return this.isdef;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getModelname() {
		return this.modelname;
	}

	public void setTitleimgwidth(Integer titleimgwidth) {
		this.titleimgwidth = titleimgwidth;
	}

	public Integer getTitleimgwidth() {
		return this.titleimgwidth;
	}

	public void setTitleimgheight(Integer titleimgheight) {
		this.titleimgheight = titleimgheight;
	}

	public Integer getTitleimgheight() {
		return this.titleimgheight;
	}

	public void setIsdisabled(Integer isdisabled) {
		this.isdisabled = isdisabled;
	}

	public Integer getIsdisabled() {
		return this.isdisabled;
	}

	public void setModelpath(String modelpath) {
		this.modelpath = modelpath;
	}

	public String getModelpath() {
		return this.modelpath;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setTplcontentprefix(String tplcontentprefix) {
		this.tplcontentprefix = tplcontentprefix;
	}

	public String getTplcontentprefix() {
		return this.tplcontentprefix;
	}

	public void setTplchannelprefix(String tplchannelprefix) {
		this.tplchannelprefix = tplchannelprefix;
	}

	public String getTplchannelprefix() {
		return this.tplchannelprefix;
	}

	public void setHascontent(Integer hascontent) {
		this.hascontent = hascontent;
	}

	public Integer getHascontent() {
		return this.hascontent;
	}

	public void setContentimgwidth(Integer contentimgwidth) {
		this.contentimgwidth = contentimgwidth;
	}

	public Integer getContentimgwidth() {
		return this.contentimgwidth;
	}

	public void setContentimgheight(Integer contentimgheight) {
		this.contentimgheight = contentimgheight;
	}

	public Integer getContentimgheight() {
		return this.contentimgheight;
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
		CmsModelDTO other = (CmsModelDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}