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
import org.pro.ygcms.facade.CmsTplManagerFacade;
import org.pro.ygcms.facade.dto.CmsTplManagerDTO;
import org.springframework.web.multipart.MultipartFile;

@Named
public class CmsTplManagerFacadeImpl implements CmsTplManagerFacade{
	

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
			return InvokeResult.success(new CmsTplManagerDTO(f));
		} else {
			return InvokeResult.failure(null);
		}
	}

	/**
	 * 通过前缀获得文件列表
	 */
	public InvokeResult getListByPrefix(String prefix) {
		File f = new File(prefix);
		List<CmsTplManagerDTO> list = new ArrayList<CmsTplManagerDTO>();
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
					list.add(new CmsTplManagerDTO(file));
				}
			} 
		}
		return InvokeResult.success(list);
	}

	/**
	 * 通过前缀获得文件名称列表
	 */
	public InvokeResult  getNameListByPrefix(String prefix) {
		List<CmsTplManagerDTO> list = (List<CmsTplManagerDTO>)getListByPrefix(prefix).getData();
		List<String> result = new ArrayList<String>(list.size());
		for (CmsTplManagerDTO tpl : list) {
			result.add(tpl.getName());
		}
		return InvokeResult.success(result);
	}

	/**
	 * 获取路径下的子文件夹列表
	 */
	public CmsTplManagerDTO  getChild(String path) {
		File file = new File(path);
		File[] child = file.listFiles();
		LinkedHashMap<String, CmsTplManagerDTO> map = new LinkedHashMap<String, CmsTplManagerDTO>();
		CmsTplManagerDTO top = new CmsTplManagerDTO(file);
		map.put(top.getFileName(), top);
		for (File f : child) {
			if(f.isDirectory()){
				map.put(f.getName(), new CmsTplManagerDTO(f));
				setChildFile(f,map);
			}
		}
		for(CmsTplManagerDTO dto: map.values()){
			if(!dto.getFileName().equals(top.getFileName())&&dto.getPname()!=null&&!"".equals(dto.getPname())){
				if(dto.isDirectory()){
					map.get(dto.getPname()).getChildren().add(dto);
				}
			}
		}
		return top;
	}
	
	private void setChildFile(File f,LinkedHashMap<String, CmsTplManagerDTO> map){
		File[] child = f.listFiles();
		if(child.length>0){
			for(File file : child){
				if(file.isDirectory()){
					map.put(file.getName(), new CmsTplManagerDTO(file));
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
	public List<CmsTplManagerDTO> getListFileByPDir(String realpath) {
		File file = new File(realpath);
		File[] child = file.listFiles();
		List<CmsTplManagerDTO> list = new ArrayList<CmsTplManagerDTO>();
		for (File f : child) {
			if(f.isDirectory() || f.getName().endsWith(".html")){
				list.add(new CmsTplManagerDTO(f));
			}
		}
		return list;
	}
}
