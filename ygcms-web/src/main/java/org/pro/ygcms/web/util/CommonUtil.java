package org.pro.ygcms.web.util;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	/**
	 * 获取文件绝对路径
	 * @param request 会话请求
	 * @param path 相对路径
	 * @return
	 */
	public static String getPath(HttpServletRequest request, String path) {
		String realpath = request.getSession().getServletContext().getRealPath(path);
		if(realpath==null){
			realpath=request.getSession().getServletContext().getRealPath("/")+path;
		}
		return realpath;
	}
}
