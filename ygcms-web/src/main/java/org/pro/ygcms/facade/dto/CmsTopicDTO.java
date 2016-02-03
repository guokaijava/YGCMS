package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsTopicDTO implements Serializable {

	private String id;

	private int version;

			
		private String titleimg;
		
				
		private String keywords;
		
								
		private Integer isrecommend;
		
								
		private Integer priority;
		
				
		private String description;
		
				
		private String contentimg;
		
				
		private String shortname;
		
				
		private String topicname;
		
				
		private String tplcontent;
		
				
		private String channelid;
		
			
	
	public void setTitleimg(String titleimg) { 
		this.titleimg = titleimg;
	}

	public String getTitleimg() {
		return this.titleimg;
	}
		
			
	
	public void setKeywords(String keywords) { 
		this.keywords = keywords;
	}

	public String getKeywords() {
		return this.keywords;
	}
		
							
	
	public void setIsrecommend(Integer isrecommend) { 
		this.isrecommend = isrecommend;
	}

	public Integer getIsrecommend() {
		return this.isrecommend;
	}
		
							
	
	public void setPriority(Integer priority) { 
		this.priority = priority;
	}

	public Integer getPriority() {
		return this.priority;
	}
		
			
	
	public void setDescription(String description) { 
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
		
			
	
	public void setContentimg(String contentimg) { 
		this.contentimg = contentimg;
	}

	public String getContentimg() {
		return this.contentimg;
	}
		
			
	
	public void setShortname(String shortname) { 
		this.shortname = shortname;
	}

	public String getShortname() {
		return this.shortname;
	}
		
			
	
	public void setTopicname(String topicname) { 
		this.topicname = topicname;
	}

	public String getTopicname() {
		return this.topicname;
	}
		
			
	
	public void setTplcontent(String tplcontent) { 
		this.tplcontent = tplcontent;
	}

	public String getTplcontent() {
		return this.tplcontent;
	}
		
			
	
	public void setChannelid(String channelid) { 
		this.channelid = channelid;
	}

	public String getChannelid() {
		return this.channelid;
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
		CmsTopicDTO other = (CmsTopicDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}