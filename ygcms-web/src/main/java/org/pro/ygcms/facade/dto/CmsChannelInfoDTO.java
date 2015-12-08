package org.pro.ygcms.facade.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 栏目信息数据对象
 * 作者：郭凯
 * 时间：2015年7月3日
 */
public class CmsChannelInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5701177353551057357L;
	
	private String id;
	private String title;
	private String siteid;
	private String pid;
	private List<CmsChannelInfoDTO> children = new ArrayList<CmsChannelInfoDTO>();
	
	public CmsChannelInfoDTO(String cid,String channelName,String siteid,String pid){
		this.id = cid;
		this.title = channelName;
		this.siteid = siteid;
		this.pid = pid;
	}
	
	public List<CmsChannelInfoDTO> getChildren() {
		return children;
	}

	public void setChildren(List<CmsChannelInfoDTO> children) {
		this.children = children;
	}

	public CmsChannelInfoDTO(){}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
