package org.pro.ygcms.core.domain.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 信息图片实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_content_picture")
public class CmsContentPicture extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -909830222709137800L;

	@Column(name = "content_id")
	private int contentId;

	@Column(name = "priority")
	private int priority;

	@Column(name = "img_path")
	private String imgPath;

	@Column(name = "description")
	private String description;

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}