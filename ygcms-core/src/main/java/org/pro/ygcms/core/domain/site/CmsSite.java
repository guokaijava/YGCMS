package org.pro.ygcms.core.domain.site;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.pro.ygcms.core.domain.CmsAbstractEntity;

/**
 * 站点实体类
 * 
 * @author 郭凯
 * 
 */
@Entity
@Table(name = "cms_site")  
public class CmsSite extends CmsAbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "config_id")
	private int configid;

	@Column(name = "ftp_upload_id")
	private int ftpuploadid;

	@Column(name = "domain")
	private String domain;

	@Column(name = "site_path")
	private String sitepath;

	@Column(name = "site_name")
	private String sitename;

	@Column(name = "short_name")
	private String shortname;

	@Column(name = "protocol")
	private String protocol;

	@Column(name = "dynamic_suffix")
	private String dynamicsuffix;

	@Column(name = "static_suffix")
	private String staticsuffix;

	@Column(name = "static_dir")
	private String staticdir;

	@Column(name = "is_index_to_root")
	private String isindextoroot;

	@Column(name = "is_static_index")
	private String isstaticindex;

	@Column(name = "locale_admin")
	private String localeadmin;

	@Column(name = "locale_front")
	private String localefront;

	@Column(name = "tpl_solution")
	private String tplsolution;

	@Column(name = "final_step")
	private short finalstep;

	@Column(name = "after_check")
	private short aftercheck;

	@Column(name = "is_relative_path")
	private String isrelativepath;

	@Column(name = "is_recycle_on")
	private String isrecycleon;

	@Column(name = "domain_alias")
	private String domainAlias;

	@Column(name = "domain_redirect")
	private String domainredirect;

	@Column(name = "tpl_index")
	private String tplindex;

	@Column(name = "keywords")
	private String keywords;

	@Column(name = "description")
	private String description;


	@Override
	public String[] businessKeys() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getConfigid() {
		return configid;
	}


	public void setConfigid(int configid) {
		this.configid = configid;
	}


	public int getFtpuploadid() {
		return ftpuploadid;
	}


	public void setFtpuploadid(int ftpuploadid) {
		this.ftpuploadid = ftpuploadid;
	}


	public String getDomain() {
		return domain;
	}


	public void setDomain(String domain) {
		this.domain = domain;
	}


	public String getSitepath() {
		return sitepath;
	}


	public void setSitepath(String sitepath) {
		this.sitepath = sitepath;
	}


	public String getSitename() {
		return sitename;
	}


	public void setSitename(String sitename) {
		this.sitename = sitename;
	}


	public String getShortname() {
		return shortname;
	}


	public void setShortname(String shortname) {
		this.shortname = shortname;
	}


	public String getProtocol() {
		return protocol;
	}


	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}


	public String getDynamicsuffix() {
		return dynamicsuffix;
	}


	public void setDynamicsuffix(String dynamicsuffix) {
		this.dynamicsuffix = dynamicsuffix;
	}


	public String getStaticsuffix() {
		return staticsuffix;
	}


	public void setStaticsuffix(String staticsuffix) {
		this.staticsuffix = staticsuffix;
	}


	public String getStaticdir() {
		return staticdir;
	}


	public void setStaticdir(String staticdir) {
		this.staticdir = staticdir;
	}


	public String getIsindextoroot() {
		return isindextoroot;
	}


	public void setIsindextoroot(String isindextoroot) {
		this.isindextoroot = isindextoroot;
	}


	public String getIsstaticindex() {
		return isstaticindex;
	}


	public void setIsstaticindex(String isstaticindex) {
		this.isstaticindex = isstaticindex;
	}


	public String getLocaleadmin() {
		return localeadmin;
	}


	public void setLocaleadmin(String localeadmin) {
		this.localeadmin = localeadmin;
	}


	public String getLocalefront() {
		return localefront;
	}


	public void setLocalefront(String localefront) {
		this.localefront = localefront;
	}


	public String getTplsolution() {
		return tplsolution;
	}


	public void setTplsolution(String tplsolution) {
		this.tplsolution = tplsolution;
	}


	public short getFinalstep() {
		return finalstep;
	}


	public void setFinalstep(short finalstep) {
		this.finalstep = finalstep;
	}


	public short getAftercheck() {
		return aftercheck;
	}


	public void setAftercheck(short aftercheck) {
		this.aftercheck = aftercheck;
	}


	public String getIsrelativepath() {
		return isrelativepath;
	}


	public void setIsrelativepath(String isrelativepath) {
		this.isrelativepath = isrelativepath;
	}


	public String getIsrecycleon() {
		return isrecycleon;
	}


	public void setIsrecycleon(String isrecycleon) {
		this.isrecycleon = isrecycleon;
	}


	public String getDomainAlias() {
		return domainAlias;
	}


	public void setDomainAlias(String domainAlias) {
		this.domainAlias = domainAlias;
	}


	public String getDomainredirect() {
		return domainredirect;
	}


	public void setDomainredirect(String domainredirect) {
		this.domainredirect = domainredirect;
	}


	public String getTplindex() {
		return tplindex;
	}


	public void setTplindex(String tplindex) {
		this.tplindex = tplindex;
	}


	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
}