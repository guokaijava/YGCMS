package org.pro.ygcms.facade.impl;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.io.FileUtils;
import org.openkoala.koala.commons.InvokeResult;
import org.pro.ygcms.facade.CmsResourceFacade;
import org.pro.ygcms.facade.dto.CmsResourceDTO;
import org.springframework.web.multipart.MultipartFile;

@Named
public class CmsResourceFacadeImpl implements CmsResourceFacade{
	

	/**
	 * 删除文件
	 */
	public InvokeResult delete(String[] names) {
		File f;
		int count = 0;
		for (String name : names) {	
			f = new File(name);
			if (f.isDirectory()) {
				if (FileUtils.deleteQuietly(f)) {
					count++;
				}
			} else {
				if (f.delete()) {
					count++;
				}
			}
		}
		return InvokeResult.success();
	}

	/**
	 * 获得文件对象
	 */
	public InvokeResult get(String name) {
		File f = new File(name);
		if (f.exists()) {
			return InvokeResult.success(new CmsResourceDTO(f));
		} else {
			return InvokeResult.failure(null);
		}
	}

	/**
	 * 通过前缀获得文件列表
	 */
	public InvokeResult getListByPrefix(String prefix) {
		File f = new File(prefix);
		List<CmsResourceDTO> list = new ArrayList<CmsResourceDTO>();
		String name = prefix.substring(prefix.lastIndexOf("/") + 1);
		File parent;
		if (prefix.endsWith("/")) {
			name = "";
			parent = f;
		} else {
			parent = f.getParentFile();
		}
		if (parent.exists()) {
			File[] files = parent.listFiles(new PrefixFilter(name));
			if (files != null) {
				for (File file : files) {
					list.add(new CmsResourceDTO(file));
				}
			} 
		}
		return InvokeResult.success(list);
	}

	/**
	 * 通过前缀获得文件名称列表
	 */
	public InvokeResult  getNameListByPrefix(String prefix) {
		List<CmsResourceDTO> list = (List<CmsResourceDTO>)getListByPrefix(prefix).getData();
		List<String> result = new ArrayList<String>(list.size());
		for (CmsResourceDTO tpl : list) {
			result.add(tpl.getName());
		}
		return InvokeResult.success(result);
	}

	/**
	 * 获取路径下的子文件夹列表
	 */
	public CmsResourceDTO  getChild(String path) {
		File file = new File(path);
		File[] child = file.listFiles();
		LinkedHashMap<String, CmsResourceDTO> map = new LinkedHashMap<String, CmsResourceDTO>();
		CmsResourceDTO top = new CmsResourceDTO(file);
		map.put(top.getFileName(), top);
		for (File f : child) {
			if(f.isDirectory()){
				map.put(f.getName(), new CmsResourceDTO(f));
				setChildFile(f,map);
			}
		}
		for(CmsResourceDTO dto: map.values()){
			if(!dto.getFileName().equals(top.getFileName())&&dto.getPname()!=null&&!"".equals(dto.getPname())){
				if(dto.isDirectory()){
					map.get(dto.getPname()).getChildren().add(dto);
				}
			}
		}
		return top;
	}
	
	private void setChildFile(File f,LinkedHashMap<String, CmsResourceDTO> map){
		File[] child = f.listFiles();
		if(child.length>0){
			for(File file : child){
				if(file.isDirectory()){
					map.put(file.getName(), new CmsResourceDTO(file));
					setChildFile(file,map);
				}
			}
		}
	}

	/**
	 * 文件重命名
	 */
	public InvokeResult rename(String orig, String dist) {
		String os = orig;
		File of = new File(os);
		String ds = dist;
		File df = new File(ds);
		try {
			if (of.isDirectory()) {
				FileUtils.moveDirectory(of, df);
			} else {
				FileUtils.moveFile(of, df);
			}
		} catch (IOException e) {
			return InvokeResult.failure(e.toString());
		}
		return InvokeResult.success();
	}

	/**
	 * 保存文件
	 */
	public InvokeResult save(String name, String source, boolean isDirectory) {
		String real = name;
		File f = new File(real);
		if (isDirectory) {
			f.mkdirs();
		} else {
			try {
				FileUtils.writeStringToFile(f, source,"utf-8");
			} catch (IOException e) {
				InvokeResult.failure(e.toString());
			}
		}
		return InvokeResult.success();
	}

	/**
	 * 保存文件
	 */
	public InvokeResult save(String path, MultipartFile file) {
		File f = new File(path, file.getOriginalFilename());
		try {
			file.transferTo(f);
		} catch (Exception e) {
			return InvokeResult.failure(e.toString());
		}
		return InvokeResult.success();
	}

	/**
	 * 更新文件
	 */
	public InvokeResult update(String name, String source) {
		String real = name;
		File f = new File(real);
		try {
			FileUtils.writeStringToFile(f, source, "utf-8");
		} catch (IOException e) {
			return InvokeResult.failure(e.toString());
		}
		return InvokeResult.success();
	}


	private static class PrefixFilter implements FileFilter {
		private String prefix;

		public PrefixFilter(String prefix) {
			this.prefix = prefix;
		}

		public boolean accept(File file) {
			String name = file.getName();
			return file.isFile() && name.startsWith(prefix);
		}
	}


	@Override
	public List<CmsResourceDTO> getListFileByPDir(String realpath) {
		File file = new File(realpath);
		File[] child = file.listFiles();
		List<CmsResourceDTO> list = new ArrayList<CmsResourceDTO>();
		for (File f : child) {
			if(f.isDirectory() || validatePrefix(f.getName())){
				list.add(new CmsResourceDTO(f));
			}
		}
		return list;
	}

	private boolean validatePrefix(String name) {
		for(int i=0;i<CmsResourceDTO.EDITABLE_EXT.length;i++){
			if(name.endsWith(CmsResourceDTO.EDITABLE_EXT[i])){
				return true;
			}
		}
		return false;
	}
}
