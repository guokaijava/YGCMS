package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsConfigItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private String areaCols;

	private Integer configId;

	private String field;

	private String defValue;

	private Integer category;

	private String textSize;

	private String areaRows;

	private String help;

	private Integer dataType;

	private Boolean isRequired;

	private String itemLabel;

	private Integer priority;

	private String optValue;

	private String helpPosition;

	public void setAreaCols(String areaCols) {
		this.areaCols = areaCols;
	}

	public String getAreaCols() {
		return this.areaCols;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public Integer getConfigId() {
		return this.configId;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getField() {
		return this.field;
	}

	public void setDefValue(String defValue) {
		this.defValue = defValue;
	}

	public String getDefValue() {
		return this.defValue;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getCategory() {
		return this.category;
	}

	public void setTextSize(String textSize) {
		this.textSize = textSize;
	}

	public String getTextSize() {
		return this.textSize;
	}

	public void setAreaRows(String areaRows) {
		this.areaRows = areaRows;
	}

	public String getAreaRows() {
		return this.areaRows;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getHelp() {
		return this.help;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public Integer getDataType() {
		return this.dataType;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public Boolean getIsRequired() {
		return this.isRequired;
	}

	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}

	public String getItemLabel() {
		return this.itemLabel;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setOptValue(String optValue) {
		this.optValue = optValue;
	}

	public String getOptValue() {
		return this.optValue;
	}

	public void setHelpPosition(String helpPosition) {
		this.helpPosition = helpPosition;
	}

	public String getHelpPosition() {
		return this.helpPosition;
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
		CmsConfigItemDTO other = (CmsConfigItemDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}