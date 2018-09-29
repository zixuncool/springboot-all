package com.baidu.ueditor.upload;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BinaryUploader {

	
	/**
	 * 文件上传执行的处理类，你文件是通过common-fileuplaod.jar来上传，
	 * 但是ueditor默认不是，那么要进行改造。
	 * 方法名：save<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月29日-下午10:18:28 <br/>
	 * 手机:1564545646464<br/>
	 * @param request
	 * @param conf
	 * @return State<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		// FileItemStream fileStream = null;
		// boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

        // ServletFileUpload upload = new ServletFileUpload(
			// 	new DiskFileItemFactory());
        //
        // if ( isAjaxUpload ) {
        //     upload.setHeaderEncoding( "UTF-8" );
        // }

		try {
			// FileItemIterator iterator = upload.getItemIterator(request);
            //
			// while (iterator.hasNext()) {
			// 	fileStream = iterator.next();
            //
			// 	if (!fileStream.isFormField())
			// 		break;
			// 	fileStream = null;
			// }
            //
			// if (fileStream == null) {
			// 	return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			// }
			
			
			//改造成自己的文件上传的处理类
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile multipartFile = multipartRequest.getFile(conf.get("fieldName").toString());
			if(multipartFile==null){
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}
			
			//savepath就是config.json中的--imagePathFormat
			String savePath = (String) conf.get("savePath");
			//String originFileName = fileStream.getName();
			//获取文件原始的名字
			String originFileName = multipartFile.getOriginalFilename();
			//获取后缀
			String suffix = FileType.getSuffixByFilename(originFileName);
			
			//原始名字，无后缀
			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());
			//拼接你路径
			savePath = savePath + suffix;

			//获取配置config.json中的imageMaxSize的大小，开始做判断限制
			long maxSize = ((Long) conf.get("maxSize")).longValue();

			//如果你文件的大小，超过限制的大小，直接提示文件多大
			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}
			
			//对文件路径和重名的名字组装，行为一个完整的路径
			savePath = PathFormat.parse(savePath, originFileName);

			//String physicalPath = (String) conf.get("rootPath") + savePath;
			//basePath一般是指服务器tomcat路径。为什么要是tomcat路径，因为只有放入到tomcat下。你的图片才可以通过。http访问
			//d://tomcat/webapps/blog/image/201412/2342342342342.jpg
			//获取图片的真实存储存放的路径
			String basePath2 = request.getRealPath("/");
			String basePath=(String) conf.get("basePath");
			String physicalPath = basePath + savePath;

			//InputStream is = fileStream.openStream();
			//获取到文件上传的流
			InputStream is = multipartFile.getInputStream();
			//开始上传
			State storageState = StorageManager.saveFileByInputStream(is,
					physicalPath, maxSize);
			is.close();

			if (storageState.isSuccess()) {
				//为什么还要PathFormat.format(savePath) 去除盘符
				storageState.putInfo("url", PathFormat.format(savePath));
				//获取到后缀
				storageState.putInfo("type", suffix);
				//原始名字
				//<img src='${url}' alt="original"/>
				storageState.putInfo("original", originFileName + suffix);
			}

			return storageState;
		// } catch (FileUploadException e) {
		// 	return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
}
