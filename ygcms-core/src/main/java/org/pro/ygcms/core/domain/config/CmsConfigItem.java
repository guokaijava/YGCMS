package org.pro.ygcms.core.domain.config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 全局配置项实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_config_item")
public class CmsConfigItem extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5624682651550809672L;

	@Column(name = "config_id")
	private int configId;

	@Column(name = "field")
	private String field;

	@Column(name = "item_label")
	private String itemLabel;

	@Column(name = "priority")
	private int priority;

	@Column(name = "def_value")
	private String defValue;

	@Column(name = "opt_value")
	private String optValue;

	@Column(name = "text_size")
	private String textSize;

	@Column(name = "area_rows")
	private String areaRows;

	@Column(name = "area_cols")
	private String areaCols;

	@Column(name = "help")
	private String help;

	@Column(name = "help_position")
	private String helpPosition;

	@Column(name = "data_type")
	private int dataType;

	@Column(name = "is_required")
	private Boolean isRequired;

	@Column(name = "category")
	private int category;

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getItemLabel() {
		return itemLabel;
	}

	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDefValue() {
		return defValue;
	}

	public void setDefValue(String defValue) {
		this.defValue = defValue;
	}

	public String getOptValue() {
		return optValue;
	}

	public void setOptValue(String optValue) {
		this.optValue = optValue;
	}

	public String getTextSize() {
		return textSize;
	}

	public void setTextSize(String textSize) {
		this.textSize = textSize;
	}

	public String getAreaRows() {
		return areaRows;
	}

	public void setAreaRows(String areaRows) {
		this.areaRows = areaRows;
	}

	public String getAreaCols() {
		return areaCols;
	}

	public void setAreaCols(String areaCols) {
		this.areaCols = areaCols;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getHelpPosition() {
		return helpPosition;
	}

	public void setHelpPosition(String helpPosition) {
		this.helpPosition = helpPosition;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}