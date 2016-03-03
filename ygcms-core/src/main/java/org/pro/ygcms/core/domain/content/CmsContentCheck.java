package org.pro.ygcms.core.domain.content;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 信息审核操作实体类
 * 作者：郭凯
 * 时间：2015年7月1日
 */
@Entity
@Table(name = "cms_content_check")
public class CmsContentCheck extends CmsAbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9022137585935709906L;

	@Column(name = "content_id")
	private String contentId;

	@Column(name = "check_step")
	private short checkStep;

	@Column(name = "check_opinion")
	private String checkOpinion;

	@Column(name = "is_rejected")
	private Boolean isRejected;

	@Column(name = "reviewer")
	private int reviewer;

	@Column(name = "check_date")
	private Timestamp checkDate;

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public short getCheckStep() {
		return checkStep;
	}

	public void setCheckStep(short checkStep) {
		this.checkStep = checkStep;
	}

	public String getCheckOpinion() {
		return checkOpinion;
	}

	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

	public Boolean getIsRejected() {
		return isRejected;
	}

	public void setIsRejected(Boolean isRejected) {
		this.isRejected = isRejected;
	}

	public int getReviewer() {
		return reviewer;
	}

	public void setReviewer(int reviewer) {
		this.reviewer = reviewer;
	}

	public Timestamp getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}

	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}