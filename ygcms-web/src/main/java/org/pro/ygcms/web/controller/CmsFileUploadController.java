package org.pro.ygcms.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.pro.ygcms.web.util.Constants;
import org.pro.ygcms.web.util.DateTimeUtil;
import org.pro.ygcms.web.util.FileObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/CmsUpload")
public class CmsFileUploadController {
	
	@ResponseBody
	@RequestMapping("/upload")
	public String uploadFile(HttpServletRequest request,@RequestParam MultipartFile[] myfiles){
		String result = "";
        if(request.getHeader("content-type")!=null&&"application/x-www-form-urlencoded".equals(request.getHeader("content-type"))){
            return null;//不支持断点续传，直接返回null即可
        }
        ;
        
        //MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //MultipartHttpServletRequest mRequest = resolver.resolveMultipart(request);
        JSONArray map = new JSONArray();
        for(MultipartFile mFile : myfiles){
            if(mFile.isEmpty()){
            	result = "EventAction.picture.failed";
            }else{
            	String localpath = Constants.BASEPICUPLOADPATH+DateTimeUtil.Date2String(new Date(),"YYYYMMDD");
                String basePath=request.getSession().getServletContext().getRealPath("/")+localpath;
                String originFileName=mFile.getOriginalFilename();
                String suffix=originFileName.split("\\.")[originFileName.split("\\.").length-1];
                String base64Name=UUID.randomUUID().toString()+"."+suffix;
                File file =  new File(basePath,base64Name);
                try {
                    FileUtils.copyInputStreamToFile(mFile.getInputStream(),file);//存储文件
                    FileObj fo = new FileObj(base64Name,file.length(),localpath);
                    map.add(fo);
                } catch (IOException e) {
                    e.printStackTrace();
                }  
            }
        }
        if(!map.isEmpty()){
        	result = map.toString();
        }
        return result;	
	}
}
