package com.rumo.controller.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	private static Logger log = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping("/file") 
	@ResponseBody
	public HashMap<String, Object> singleFileUpload(@RequestParam("doc") MultipartFile file,HttpServletRequest request) {
	    if (file.isEmpty()) {
	    	request.setAttribute("message", "Please select a file to upload");
	        return null;
	    }
	    // 上传头像  文章上传 博客 ----目录区分
	    
	    try {
	        // 获取文件的字节
	        byte[] bytes = file.getBytes();
	        //获取指定的上传模块目录
	        String dirname = request.getParameter("dir");
	        //参数的其他参数
	        String zip = request.getParameter("zip");
	        String swidth = request.getParameter("swidth");
	        String sheight = request.getParameter("sheight");
	        log.info("文件上传的模块目录是：{}，参数是{},{},{},{}",dirname,zip,swidth,sheight);
	        if(dirname==null || dirname.equals(""))dirname = "blog";
	        //request.getServletContext().getRealPath()是获取项目所在的web服务器的路径，其实就是tomcat工程的目录
	        String UPLOADED_FOLDER = request.getServletContext().getRealPath("/upload/"+dirname);
	        log.info("文件上传的路径是：{}",UPLOADED_FOLDER);
	        //因为upload在服务器上是不存在的，所有需要动态创建。
	        File parentPath = new File(UPLOADED_FOLDER);
	        //如果目录不存在就存在，否则就不创建
	        if(!parentPath.exists()) {
	        	parentPath.mkdirs();
	        }
	        
	        //获取文件的原名名称
	        String oldname = file.getOriginalFilename();
	        
	        //截取原文件的后缀
	        String ext = oldname.substring(oldname.lastIndexOf("."));
	        //进行重命名操作
	        String realitivepath = UUID.randomUUID().toString()+ext;
	        //上传之后文件存储的路径
	        Path path = Paths.get(UPLOADED_FOLDER +"/"+ realitivepath);
	        // 讲上传的文件写入指定的path中。
	        Files.write(path, bytes);
	        
	        //返回完整数据包
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("oldname", oldname);
	        map.put("newname", realitivepath);
	        map.put("ext", ext.substring(1));
	        map.put("path", "upload/"+dirname+"/"+realitivepath);
	        map.put("size", file.getSize());
	        
	        return  map;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
}
