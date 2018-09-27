
 /**
 * itbookingϵͳƽ̨<br/>
 * com.rumo.plugin<br/>
 * AutoBuilderProjectMojo.java<br/>
 * ������:mofeng <br/>
 * ʱ�䣺2018��9��27��-����10:26:32 <br/>
 * 2018itbooking-��Ȩ����<br/>
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
 * ������:mofeng<br/>
 * ʱ�䣺2018��9��27��-����10:26:32 <br/>
 * @version 1.0.0<br/>
 *
 * mybatis-generate:generator
 */

@Mojo(name="auto",defaultPhase=LifecyclePhase.PACKAGE)
public class AutoBuilderProjectMojo extends AbstractMojo {

	
	@Parameter(property="path")
	private String path;
	
	//java�ļ��ļ�����
	private int fileCount;
	//Ŀ¼�ļ�����
	private int folderCount;
	//��Դ�ļ��ļ�����
	private int resourceCount;

	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println("��Ҫ��ص�Ŀ¼�ǣ�"+path);
		String result = countFile(path);
		System.out.println(result);
	}
	
	public String countFile(String dir) {
		File file = new File(dir);
		File[] files = file.listFiles();
		if(files!=null) {
			for (int i = 0; i < files.length; i++) {
				File currentFile = files[i];
				//����ļ�ֱ�ӷ��أ�
				if(currentFile.isFile()) {
					resourceCount++;
					String filename = currentFile.getName();
					String ext = filename.substring(filename.lastIndexOf(".")+1);
					if(ext.equals("java")) {
						fileCount++;
					}
				}else {
					folderCount++;
					//������ļ��ӣ�
					countFile(currentFile.getAbsolutePath());
				}
			}
		}
		
		
		return "��Դ�ļ�һ���У�"+resourceCount+",����java�ļ��У�"+fileCount+", �ļ����У�"+folderCount;
	}

}
