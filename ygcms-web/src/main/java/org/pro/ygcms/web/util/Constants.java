package org.pro.ygcms.web.util;

/**
 * web常量
 */
public abstract class Constants {
	/**
	 * 路径分隔符
	 */
	public static final String SPT = "/";
	/**
	 * 索引页
	 */
	public static final String INDEX = "index";
	/**
	 * 默认模板
	 */
	public static final String DEFAULT = "default";
	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";
	/**
	 * 提示信息
	 */
	public static final String MESSAGE = "message";
	/**
	 * cookie中的JSESSIONID名称
	 */
	public static final String JSESSION_COOKIE = "JSESSIONID";
	/**
	 * url中的jsessionid名称
	 */
	public static final String JSESSION_URL = "jsessionid";
	/**
	 * HTTP POST请求
	 */
	public static final String POST = "POST";
	/**
	 * HTTP GET请求
	 */
	public static final String GET = "GET";
	/**
	 * 文件上传根目录
	 */
	public static final String BASEPICUPLOADPATH = "/images/uploadfiles/";
	/**
	 * 水印图片
	 */
	public static final String WATER_IMG_PTAH = "/images/global.logo.png";
	/**
	 * 内容状态：草稿
	 */
	public static final byte CONTENT_CHECK_DRAFT = 0;
	/**
	 * 内容状态：审核中
	 */
	public static final byte CONTENT_CHECK_CHECKING = 1;
	/**
	 * 内容状态：退回
	 */
	public static final byte CONTENT_CHECK_REJECT = -1;
	/**
	 * 内容状态：已审核
	 */
	public static final byte CONTENT_CHECK_CHECKED = 2;
	/**
	 * 内容状态：回收站
	 */
	public static final byte CONTENT_CHECK_RECYCLE = 3;
	/**
	 * 内容状态：投稿
	 */
	public static final byte CONTENT_CHECK_CONTRIBUTE = 4;
}
