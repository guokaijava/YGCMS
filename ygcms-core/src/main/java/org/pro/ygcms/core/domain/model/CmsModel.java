package org.pro.ygcms.core.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 模版类 
 * 作者：郭凯 
 * 时间：2015年3月17日
 */
@Entity
@Table(name = "cms_model")
public class CmsModel extends CmsAbstractEntity {

	private static final long serialVersionUID = -2682675801192836670L;
	@Column(name = "model_name")
	private String modelname;
	@Column(name = "model_path")
	private String modelpath;
	@Column(name = "tpl_channel_prefix")
	private String tplchannelprefix;
	@Column(name = "tpl_content_prefix")
	private String tplcontentprefix;
	@Column(name = "title_img_width")
	private int titleimgwidth;
	@Column(name = "title_img_height")
	private int titleimgheight;
	@Column(name = "content_img_width")
	private int contentimgwidth;
	@Column(name = "content_img_height")
	private int contentimgheight;
	@Column(name = "priority")
	private int priority;
	@Column(name = "has_content")
	private int hascontent;
	@Column(name = "is_disabled")
	private int isdisabled;
	@Column(name = "is_def")
	private int isdef;

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getModelpath() {
		return modelpath;
	}

	public void setModelpath(String modelpath) {
		this.modelpath = modelpath;
	}

	public String getTplchannelprefix() {
		return tplchannelprefix;
	}

	public void setTplchannelprefix(String tplchannelprefix) {
		this.tplchannelprefix = tplchannelprefix;
	}

	public String getTplcontentprefix() {
		return tplcontentprefix;
	}

	public void setTplcontentprefix(String tplcontentprefix) {
		this.tplcontentprefix = tplcontentprefix;
	}

	public int getTitleimgwidth() {
		return titleimgwidth;
	}

	public void setTitleimgwidth(int titleimgwidth) {
		this.titleimgwidth = titleimgwidth;
	}

	public int getTitleimgheight() {
		return titleimgheight;
	}

	public void setTitleimgheight(int titleimgheight) {
		this.titleimgheight = titleimgheight;
	}

	public int getContentimgwidth() {
		return contentimgwidth;
	}

	public void setContentimgwidth(int contentimgwidth) {
		this.contentimgwidth = contentimgwidth;
	}

	public int getContentimgheight() {
		return contentimgheight;
	}

	public void setContentimgheight(int contentimgheight) {
		this.contentimgheight = contentimgheight;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getHascontent() {
		return hascontent;
	}

	public void setHascontent(int hascontent) {
		this.hascontent = hascontent;
	}

	public int getIsdisabled() {
		return isdisabled;
	}

	public void setIsdisabled(int isdisabled) {
		this.isdisabled = isdisabled;
	}

	public int getIsdef() {
		return isdef;
	}

	public void setIsdef(int isdef) {
		this.isdef = isdef;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}
}
