package org.pro.ygcms.facade;

import java.util.List;

import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.dto.CmsResourceDTO;
import org.springframework.web.multipart.MultipartFile;


public interface CmsResourceFacade {
	/**
	 * 获得模板列表。根据前缀，用于选择模板。
	 * 
	 * @param prefix
	 *            前缀
	 * @return
	 */
	public InvokeResult getListByPrefix(String prefix);

	public InvokeResult getNameListByPrefix(String prefix);

	/**
	 * 获得下级模板列表。根据路径，用于展现下级目录和文件。
	 * 
	 * @param path
	 *            路径
	 * @return
	 */
	public CmsResourceDTO getChild(String path);

	/**
	 * 保存模板
	 * 
	 * @param name
	 *            模板名称
	 * @param source
	 *            模板内容
	 * @param isDirecotry
	 *            是否目录
	 */
	public InvokeResult save(String name, String source, boolean isDirectory);

	/**
	 * 保存模板
	 * 
	 * @param path
	 * @param file
	 */
	public InvokeResult save(String path, MultipartFile file);

	/**
	 * 获得模板
	 * 
	 * @param name
	 * @return
	 */
	public InvokeResult get(String name);

	/**
	 * 更新模板
	 * 
	 * @param name
	 *            模板名称
	 * @param source
	 *            模板内容
	 */
	public InvokeResult update(String name, String source);

	/**
	 * 修改模板名称或路径
	 * 
	 * @param orig
	 * @param dist
	 */
	public InvokeResult rename(String orig, String dist);

	/**
	 * 删除模板
	 * 
	 * @param names
	 *            模板名称数组
	 * @return 被删除的模板数量
	 */
	public InvokeResult delete(String[] names);

	public List<CmsResourceDTO> getListFileByPDir(String realpath);
}
