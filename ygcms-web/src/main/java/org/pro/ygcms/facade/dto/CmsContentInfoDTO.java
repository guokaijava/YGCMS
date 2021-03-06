package org.pro.ygcms.facade.dto;

import java.io.Serializable;
import java.util.Date;

import org.pro.ygcms.web.util.DateTimeUtil;

/**
 * 内容信息数据对象
 * 作者：任建新
 * 时间：2016年2月3日
 */
public class CmsContentInfoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8253065293957064004L;
	
	private String id;
	private String title;//标题
	private String channelName;//栏目名称
	private String typeId;//类型id
	private String typeName;//类型名称
	private String author;//作者
	private Integer viewsDay;//点击
	private String releaseDate;//发布时间
	private short status;//状态
	
	public CmsContentInfoDTO(String id,String title,String channelName,String typeId,String typeName,String author,Integer viewsDay,Date releaseDate,short status){
		this.id = id;
		this.title = title;
		this.channelName = channelName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.author = author;
		this.viewsDay = viewsDay;
		if(releaseDate!=null){
			this.releaseDate = DateTimeUtil.Date2String(releaseDate, "yyyy-MM-dd");
		}
		this.status = status;
	}
	
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
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getViewsDay() {
		return viewsDay;
	}
	public void setViewsDay(Integer viewsDay) {
		this.viewsDay = viewsDay;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
}
