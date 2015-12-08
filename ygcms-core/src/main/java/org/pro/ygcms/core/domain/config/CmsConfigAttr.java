package org.pro.ygcms.core.domain.config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 全局配置属性实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_config_attr")
public class CmsConfigAttr extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5191846309926454500L;

	@Column(name = "config_id")
	private int configId;

	@Column(name = "attr_name")
	private String attrName;

	@Column(name = "attr_value")
	private String attrValue;

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}