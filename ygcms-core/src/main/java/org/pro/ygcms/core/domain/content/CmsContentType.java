package org.pro.ygcms.core.domain.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;
/**
 * 内容类型实体
 * 作者：郭凯
 * 时间：2015年3月17日
 */
@Entity
@Table(name = "cms_content_type")
public class CmsContentType extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7834303785781546214L;
	@Column(name = "type_name")
	private String typename;
	@Column(name = "img_width")
	private int imgwidth;
	@Column(name = "img_height")
	private int imgheight;
	@Column(name = "has_imgage")
	private int hasimage;
	@Column(name = "is_disabled")
	private int isdisabled;

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getImgwidth() {
		return imgwidth;
	}

	public void setImgwidth(int imgwidth) {
		this.imgwidth = imgwidth;
	}

	public int getImgheight() {
		return imgheight;
	}

	public void setImgheight(int imgheight) {
		this.imgheight = imgheight;
	}

	public int getHasimage() {
		return hasimage;
	}

	public void setHasimage(int hasimage) {
		this.hasimage = hasimage;
	}

	public int getIsdisabled() {
		return isdisabled;
	}

	public void setIsdisabled(int isdisabled) {
		this.isdisabled = isdisabled;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
