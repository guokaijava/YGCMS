package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsChannelAttrDTO implements Serializable {

	private String id;

	private int version;

			
		private String channelId;
		
				
		private String attrName;
		
				
		private String attrValue;
		
			
	
	public void setChannelId(String channelId) { 
		this.channelId = channelId;
	}

	public String getChannelId() {
		return this.channelId;
	}
		
			
	
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
		CmsChannelAttrDTO other = (CmsChannelAttrDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}