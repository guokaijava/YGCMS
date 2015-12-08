package org.pro.ygcms.core.domain.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 信息标签实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_content_tag")
public class CmsContentTag extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8437057748941442465L;

	@Column(name = "tag_name")
	private String tagName;

	@Column(name = "ref_counter")
	private int refCounter;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getRefCounter() {
		return refCounter;
	}

	public void setRefCounter(int refCounter) {
		this.refCounter = refCounter;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}