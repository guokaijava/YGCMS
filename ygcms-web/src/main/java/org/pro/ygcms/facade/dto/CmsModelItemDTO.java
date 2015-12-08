package org.pro.ygcms.facade.dto;

import java.io.Serializable;

public class CmsModelItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private String areacols;

	private String defvalue;

	private Integer modelid;

	private Integer issingle;

	private Integer isdisplay;

	private String optvalue;

	private String field;

	private Integer ischannel;

	private String help;

	private String itemlabel;

	private String helpposition;

	private Integer priority;

	private String textsize;

	private String arearows;

	private Integer card;

	private Integer datatype;

	private Integer iscustom;

	public void setAreacols(String areacols) {
		this.areacols = areacols;
	}

	public String getAreacols() {
		return this.areacols;
	}

	public void setDefvalue(String defvalue) {
		this.defvalue = defvalue;
	}

	public String getDefvalue() {
		return this.defvalue;
	}

	public void setModelid(Integer modelid) {
		this.modelid = modelid;
	}

	public Integer getModelid() {
		return this.modelid;
	}

	public void setIssingle(Integer issingle) {
		this.issingle = issingle;
	}

	public Integer getIssingle() {
		return this.issingle;
	}

	public void setIsdisplay(Integer isdisplay) {
		this.isdisplay = isdisplay;
	}

	public Integer getIsdisplay() {
		return this.isdisplay;
	}

	public void setOptvalue(String optvalue) {
		this.optvalue = optvalue;
	}

	public String getOptvalue() {
		return this.optvalue;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getField() {
		return this.field;
	}

	public void setIschannel(Integer ischannel) {
		this.ischannel = ischannel;
	}

	public Integer getIschannel() {
		return this.ischannel;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getHelp() {
		return this.help;
	}

	public void setItemlabel(String itemlabel) {
		this.itemlabel = itemlabel;
	}

	public String getItemlabel() {
		return this.itemlabel;
	}

	public void setHelpposition(String helpposition) {
		this.helpposition = helpposition;
	}

	public String getHelpposition() {
		return this.helpposition;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setTextsize(String textsize) {
		this.textsize = textsize;
	}

	public String getTextsize() {
		return this.textsize;
	}

	public void setArearows(String arearows) {
		this.arearows = arearows;
	}

	public String getArearows() {
		return this.arearows;
	}

	public void setCard(Integer card) {
		this.card = card;
	}

	public Integer getCard() {
		return this.card;
	}

	public void setDatatype(Integer datatype) {
		this.datatype = datatype;
	}

	public Integer getDatatype() {
		return this.datatype;
	}

	public void setIscustom(Integer iscustom) {
		this.iscustom = iscustom;
	}

	public Integer getIscustom() {
		return this.iscustom;
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
		CmsModelItemDTO other = (CmsModelItemDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}