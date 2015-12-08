package org.pro.ygcms.core.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

@Entity
@Table(name = "cms_model_item")
public class CmsModelItem extends CmsAbstractEntity {

	private static final long serialVersionUID = -2595802162201156329L;

	@Column(name = "model_id")
	private int modelid;

	@Column(name = "field")
	private String field;

	@Column(name = "item_label")
	private String itemlabel;

	@Column(name = "priority")
	private int priority;

	@Column(name = "def_value")
	private String defvalue;

	@Column(name = "opt_value")
	private String optvalue;

	@Column(name = "text_size")
	private String textsize;

	@Column(name = "area_rows")
	private String arearows;

	@Column(name = "area_cols")
	private String areacols;

	@Column(name = "help")
	private String help;

	@Column(name = "help_position")
	private String helpposition;

	@Column(name = "data_type")
	private int datatype;

	@Column(name = "is_single")
	private int issingle;

	@Column(name = "is_channel")
	private int ischannel;

	@Column(name = "is_custom")
	private int iscustom;

	@Column(name = "is_display")
	private int isdisplay;

	@Column(name = "card")
	private int card;

	public int getModelid() {
		return modelid;
	}

	public void setModelid(int modelid) {
		this.modelid = modelid;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getItemlabel() {
		return itemlabel;
	}

	public void setItemlabel(String itemlabel) {
		this.itemlabel = itemlabel;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDefvalue() {
		return defvalue;
	}

	public void setDefvalue(String defvalue) {
		this.defvalue = defvalue;
	}

	public String getOptvalue() {
		return optvalue;
	}

	public void setOptvalue(String optvalue) {
		this.optvalue = optvalue;
	}

	public String getTextsize() {
		return textsize;
	}

	public void setTextsize(String textsize) {
		this.textsize = textsize;
	}

	public String getArearows() {
		return arearows;
	}

	public void setArearows(String arearows) {
		this.arearows = arearows;
	}

	public String getAreacols() {
		return areacols;
	}

	public void setAreacols(String areacols) {
		this.areacols = areacols;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public String getHelpposition() {
		return helpposition;
	}

	public void setHelpposition(String helpposition) {
		this.helpposition = helpposition;
	}

	public int getDatatype() {
		return datatype;
	}

	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}

	public int getIssingle() {
		return issingle;
	}

	public void setIssingle(int issingle) {
		this.issingle = issingle;
	}

	public int getIschannel() {
		return ischannel;
	}

	public void setIschannel(int ischannel) {
		this.ischannel = ischannel;
	}

	public int getIscustom() {
		return iscustom;
	}

	public void setIscustom(int iscustom) {
		this.iscustom = iscustom;
	}

	public int getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(int isdisplay) {
		this.isdisplay = isdisplay;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}
}