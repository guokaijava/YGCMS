package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsChannelTxtDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private String txt1;

	private String txt2;

	private String txt3;

	private Integer channelId;

	private String txt;

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public String getTxt1() {
		return this.txt1;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	public String getTxt2() {
		return this.txt2;
	}

	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}

	public String getTxt3() {
		return this.txt3;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getChannelId() {
		return this.channelId;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getTxt() {
		return this.txt;
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
		CmsChannelTxtDTO other = (CmsChannelTxtDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}