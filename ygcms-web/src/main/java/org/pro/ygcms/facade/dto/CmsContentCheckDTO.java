package org.pro.ygcms.facade.dto;

import java.sql.Timestamp;

import java.io.Serializable;

public class CmsContentCheckDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private int version;

	private Short checkStep;

	private Timestamp checkDate;

	private Integer reviewer;

	private Boolean isRejected;

	private String contentId;

	private String checkOpinion;

	public void setCheckStep(Short checkStep) {
		this.checkStep = checkStep;
	}

	public Short getCheckStep() {
		return this.checkStep;
	}

	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}

	public Timestamp getCheckDate() {
		return this.checkDate;
	}

	public void setReviewer(Integer reviewer) {
		this.reviewer = reviewer;
	}

	public Integer getReviewer() {
		return this.reviewer;
	}

	public void setIsRejected(Boolean isRejected) {
		this.isRejected = isRejected;
	}

	public Boolean getIsRejected() {
		return this.isRejected;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentId() {
		return this.contentId;
	}

	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

	public String getCheckOpinion() {
		return this.checkOpinion;
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
		CmsContentCheckDTO other = (CmsContentCheckDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void init() {
		short zero = 0;
		if (getCheckStep() == null) {
			setCheckStep(zero);
		}
		if (getIsRejected() == null) {
			setIsRejected(false);
		}
	}

}