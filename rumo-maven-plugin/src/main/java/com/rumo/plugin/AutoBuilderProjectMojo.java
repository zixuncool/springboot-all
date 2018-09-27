
 /**
 * itbooking系统平台<br/>
 * com.rumo.plugin<br/>
 * AutoBuilderProjectMojo.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月27日-下午10:26:32 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.plugin;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * 
 * AutoBuilderProjectMojo<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月27日-下午10:26:32 <br/>
 * @version 1.0.0<br/>
 *
 * mybatis-generate:generator
 */

@Mojo(name="auto",defaultPhase=LifecyclePhase.PACKAGE)
public class AutoBuilderProjectMojo extends AbstractMojo {

	
	@Parameter(property="path")
	private String path;
	
	//java文件的计数器
	private int fileCount;
	//目录的计算器
	private int folderCount;
	//资源文件的计算器
	private int resourceCount;

	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println("你要监控的目录是："+path);
		String result = countFile(path);
		System.out.println(result);
	}
	
	public String countFile(String dir) {
		File file = new File(dir);
		File[] files = file.listFiles();
		if(files!=null) {
			for (int i = 0; i < files.length; i++) {
				File currentFile = files[i];
				//如果文件直接返回，
				if(currentFile.isFile()) {
					resourceCount++;
					String filename = currentFile.getName();
					String ext = filename.substring(filename.lastIndexOf(".")+1);
					if(ext.equals("java")) {
						fileCount++;
					}
				}else {
					folderCount++;
					//如果是文件加，
					countFile(currentFile.getAbsolutePath());
				}
			}
		}
		
		
		return "资源文件一共有："+resourceCount+",其中java文件有："+fileCount+", 文件夹有："+folderCount;
	}

}
