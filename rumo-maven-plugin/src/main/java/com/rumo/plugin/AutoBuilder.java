
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
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.rumo.util.JDBCTypesUtils;
import com.rumo.util.Tool;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 
 * AutoBuilderProjectMojo<br/>
 * ������:mofeng<br/>
 * ʱ�䣺2018��9��27��-����10:26:32 <br/>
 * @version 1.0.0<br/>
 *
 * mybatis-generate:generator
 */

@Mojo(name="builder",defaultPhase=LifecyclePhase.PACKAGE)
public class AutoBuilder extends AbstractMojo {
	
	@Parameter(property="path")
	private String path;
	
	@Parameter(property="tables")
	private List<String> tables;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println("��Ҫд��ĵ�Ŀ¼�ǣ�"+path);
		for (String tableinfo : tables) {
			String[] tableinfos = tableinfo.split(",");//����
			String tablename = tableinfos[0];//��
			String beanModel = tableinfos[1];//ʵ��
			String pojoDir = tableinfos[2];//��Ŀ¼
			String mapperdir = tableinfos[3];//mapperĿ¼
			/*String service = tableinfos[5];//serviceĿ¼
			String controller = tableinfos[5];//serviceĿ¼
*/			
			
			//��ѯ��Ӧ�ı�
			List<Map<String, String>> fields = loadTable(tablename);
			Map<String, String> infos = new HashMap<>();
			infos.put("beanModel",beanModel);
			infos.put("baseDir","src/main/java");
			infos.put("pack","com.rumo.pojo");
			
			//��ʼ����
			createTemplate(fields,"pojo.tml",beanModel,"src/main/java",pojoDir,beanModel+".java");
			createTemplate(fields,"mapper.tml",beanModel,"src/main/java",mapperdir,beanModel+".java");
		}
	}
	
	
	private  void createTemplate(List<Map<String, String>> fields,
			String template,
			String beanModel,
			String baseDir,
			String packagedir,
			String fname) {
		try {
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
			// ָ��ģ����μ�������ģ�ͣ�����һ���߼��������ˡ� // ���ȿ�����ô���ã� 
			cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
			String classLoader_str = this.getClass().getClassLoader().getResource("/template").getPath();

			// ָ��ģ���ļ��Ӻδ����ص�����Դ���������ó�һ���ļ�Ŀ¼��
			cfg.setDirectoryForTemplateLoading(new File(classLoader_str));
			
			// ����
			Map root = new HashMap(); 
			// �ڸ��з����ַ���"user" 
			root.put("beanModel", beanModel); 
			root.put("package", packagedir);
			root.put("fields", fields);
			
			//�ҵ���Ӧģ��
			Template temp = cfg.getTemplate(template);
			
			String packagec = packagedir.replaceAll("\\.", "/");
			//�����ָ��Ŀ��
			File rootPath = new File(path+File.separator+baseDir+File.separator+packagec);
			if(!rootPath.exists())rootPath.mkdirs();
			Writer out = new OutputStreamWriter(new FileOutputStream(new File(rootPath,fname)),"gbk");
			//ģ������� �����滻===��ʵ���ݻ���ҳ��
			temp.process(root, out); 
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * �˷������ȡ���ݵĶ�Ӧĳ��������е��ֶ�
	 * ��������loadTable<br/>
	 * �����ˣ�mofeng <br/>
	 * ʱ�䣺2018��9��27��-����11:24:41 <br/>
	 * �ֻ�:1564545646464<br/>
	 * @return List<Map<String,String>><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	private  List<Map<String,String>> loadTable(String tablename) {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tmalldb?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "root","mkxiaoer");
			 Statement st = connection.createStatement();
			 //��ѯ���еı���ֶ�
			 String sql = "SELECT * FROM "+tablename;
			 //ִ��sql
			 ResultSet rs = st.executeQuery(sql);
			 //��ȡ���Ԫ������Ϣ�������ֶ��������͵�
			 ResultSetMetaData rsmd = rs.getMetaData();
			 //���������ת��ȥװ����Щ����
			 List<Map<String,String>> maps = new ArrayList<>();
			 //��ʼѭ��Ԫ����
			 for( int i=1; i<=rsmd.getColumnCount(); i++ ){
				 //��ȡ���ж�Ӧ��������
				 String field = rsmd.getColumnName(i);
				 //����
				 int type =  rsmd.getColumnType(i) ;
				 //��ȡ��������������
				 String strtype = JDBCTypesUtils.jdbcTypeToJavaType(type).getName();
				 //��ʼ����mapȥװ��
				 Map<String,String> map = new HashMap<>();
				 //װ�����ݿ�ԭ�е�����---insert update delete select��sql���Ҫ�õ�
				 map.put("column", field);//���ݿ�ԭ�е�����
				 map.put("name", Tool.lineToHump(field));//Сд���֣�
				 map.put("hname", Tool.HlineToHump(field));//��д�����֣�������set get
				 map.put("type", strtype);//�ֶζ�Ӧ��java����
				 map.put("dtype", JDBCTypesUtils.getJdbcName(type));//�ֶζ�Ӧ��java����
				 map.put("ctype", strtype.substring(strtype.lastIndexOf(".")+1));//û�а�����������
				 maps.add(map);
			 }
			 rs.close();
			 st.close();
			 connection.close();
			 return maps;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return null;
	}
	
}
