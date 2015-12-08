package org.pro.ygcms.facade.dto;

import java.io.Serializable;

import org.pro.ygcms.core.common.CmsConstants;

@SuppressWarnings("serial")
public class CmsSiteDTO implements Serializable {

	private String id;

	private int version;

	private String sitepath;

	private String protocol;

	private String keywords;

	private String sitename;

	private Short finalstep;

	private Integer configid;

	private Short aftercheck;

	private String domainAlias;

	private Integer ftpuploadid;

	private String tplsolution;

	private String isindextoroot;

	private String isstaticindex;

	private String tplindex;

	private String dynamicsuffix;

	private String staticdir;

	private String isrecycleon;

	private String localeadmin;

	private String domainredirect;

	private String isrelativepath;

	private String description;

	private String domain;

	private String shortname;

	private String staticsuffix;

	private String localefront;

	public CmsSiteDTO() {

	}

	public CmsSiteDTO(String id, String sitename, String shortname, String domain) {
		this.id = id;
		this.sitename = sitename;
		this.shortname = shortname;
		this.domain = domain;
	}

	public void setSitepath(String sitepath) {
		this.sitepath = sitepath;
	}

	public String getSitepath() {
		return this.sitepath;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getSitename() {
		return this.sitename;
	}

	public void setFinalstep(Short finalstep) {
		this.finalstep = finalstep;
	}

	public Short getFinalstep() {
		return this.finalstep;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
	}

	public Integer getConfigid() {
		return this.configid;
	}

	public void setAftercheck(Short aftercheck) {
		this.aftercheck = aftercheck;
	}

	public Short getAftercheck() {
		return this.aftercheck;
	}

	public void setDomainAlias(String domainAlias) {
		this.domainAlias = domainAlias;
	}

	public String getDomainAlias() {
		return this.domainAlias;
	}

	public void setFtpuploadid(Integer ftpuploadid) {
		this.ftpuploadid = ftpuploadid;
	}

	public Integer getFtpuploadid() {
		return this.ftpuploadid;
	}

	public void setTplsolution(String tplsolution) {
		this.tplsolution = tplsolution;
	}

	public String getTplsolution() {
		return this.tplsolution;
	}

	public void setIsindextoroot(String isindextoroot) {
		this.isindextoroot = isindextoroot;
	}

	public String getIsindextoroot() {
		return this.isindextoroot;
	}

	public void setIsstaticindex(String isstaticindex) {
		this.isstaticindex = isstaticindex;
	}

	public String getIsstaticindex() {
		return this.isstaticindex;
	}

	public void setTplindex(String tplindex) {
		this.tplindex = tplindex;
	}

	public String getTplindex() {
		return this.tplindex;
	}

	public void setDynamicsuffix(String dynamicsuffix) {
		this.dynamicsuffix = dynamicsuffix;
	}

	public String getDynamicsuffix() {
		return this.dynamicsuffix;
	}

	public void setStaticdir(String staticdir) {
		this.staticdir = staticdir;
	}

	public String getStaticdir() {
		return this.staticdir;
	}

	public void setIsrecycleon(String isrecycleon) {
		this.isrecycleon = isrecycleon;
	}

	public String getIsrecycleon() {
		return this.isrecycleon;
	}

	public void setLocaleadmin(String localeadmin) {
		this.localeadmin = localeadmin;
	}

	public String getLocaleadmin() {
		return this.localeadmin;
	}

	public void setDomainredirect(String domainredirect) {
		this.domainredirect = domainredirect;
	}

	public String getDomainredirect() {
		return this.domainredirect;
	}

	public void setIsrelativepath(String isrelativepath) {
		this.isrelativepath = isrelativepath;
	}

	public String getIsrelativepath() {
		return this.isrelativepath;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setStaticsuffix(String staticsuffix) {
		this.staticsuffix = staticsuffix;
	}

	public String getStaticsuffix() {
		return this.staticsuffix;
	}

	public void setLocalefront(String localefront) {
		this.localefront = localefront;
	}

	public String getLocalefront() {
		return this.localefront;
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
		CmsSiteDTO other = (CmsSiteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * 获得模板路径。如：/WEB-INF/t/cms/www
	 * 
	 * @return
	 */
	public String getTplPath() {
		return CmsConstants.TPL_BASE + "/" + this.getSitepath();
	}

	/**
	 * 获得模板方案路径。如：/WEB-INF/t/cms/www/default
	 * 
	 * @return
	 */
	public String getSolutionPath() {
		return CmsConstants.TPL_BASE + "/" + this.getSitepath() + "/" + this.getTplsolution();
	}

	/**
	 * 获得模板资源路径。如：/r/cms/www
	 * 
	 * @return
	 */
	public String getResPath() {
		return CmsConstants.RES_PATH + "/" + this.getSitepath();
	}

	/**
	 * 获得上传路径。如：/u/jeecms/path
	 * 
	 * @return
	 */
	public String getUploadPath() {
		return CmsConstants.UPLOAD_PATH + this.getSitepath();
	}

	/**
	 * 获得文库路径。如：/wenku/path
	 * 
	 * @return
	 */
	public String getLibraryPath() {
		return CmsConstants.LIBRARY_PATH + this.getSitepath();
	}

}