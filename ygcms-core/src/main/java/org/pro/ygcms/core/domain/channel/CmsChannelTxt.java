package org.pro.ygcms.core.domain.channel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 栏目内容扩展类 
 * 作者：郭凯 
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_channel_txt")
public class CmsChannelTxt extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -710838823289994042L;

	@Column(name = "channel_id")
	private String channelId;

	@Column(name = "txt")
	private String txt;

	@Column(name = "txt1")
	private String txt1;

	@Column(name = "txt2")
	private String txt2;

	@Column(name = "txt3")
	private String txt3;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public String getTxt2() {
		return txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	public String getTxt3() {
		return txt3;
	}

	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}