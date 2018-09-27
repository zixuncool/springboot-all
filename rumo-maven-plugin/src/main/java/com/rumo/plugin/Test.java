
 /**
 * itbooking系统平台<br/>
 * com.rumo.plugin<br/>
 * Test.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月27日-下午11:10:01 <br/>
 * 2018itbooking-版权所有<br/>
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

import javax.xml.ws.Response;

import com.rumo.util.JDBCTypesUtils;
import com.rumo.util.Tool;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 
 * Test<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月27日-下午11:10:01 <br/>
 * @version 1.0.0<br/>
 * 
 */
public class Test {
	
	
	
	
	
	
	
	private static String projectPath = System.getProperty("user.dir");
	private static String beanModel = "Content";
	private static String basedir = "src/main/java";
	private static String packagec = "com.rumo.pojo";
	private static String tablename = "tb_content";
	
	/**
	 * 此方法会获取数据的对应某个表的所有的字段
	 * 方法名：loadTable<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月27日-下午11:24:41 <br/>
	 * 手机:1564545646464<br/>
	 * @return List<Map<String,String>><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public static List<Map<String,String>> loadTable(String tablename) {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tmalldb?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "root","mkxiaoer");
			 Statement st = connection.createStatement();
			 //查询所有的表的字段
			 String sql = "SELECT * FROM "+tablename;
			 //执行sql
			 ResultSet rs = st.executeQuery(sql);
			 //获取表的元数据信息，包括字段名，类型等
			 ResultSetMetaData rsmd = rs.getMetaData();
			 //定义个集合转变去装配这些数据
			 List<Map<String,String>> maps = new ArrayList<>();
			 //开始循环元数据
			 for( int i=1; i<=rsmd.getColumnCount(); i++ ){
				 //获取表中对应的属性名
				 String field = rsmd.getColumnName(i);
				 //类型
				 int type =  rsmd.getColumnType(i) ;
				 //获取到具体数据类型
				 String strtype = JDBCTypesUtils.jdbcTypeToJavaType(type).getName();
				 //开始定义map去装配
				 Map<String,String> map = new HashMap<>();
				 //装配数据库原有的列名---insert update delete select的sql语句要用到
				 map.put("column", field);//数据库原有的名字
				 map.put("name", Tool.lineToHump(field));//小写名字，
				 map.put("hname", Tool.HlineToHump(field));//大写的名字，服务于set get
				 map.put("type", strtype);//字段对应的java类型
				 map.put("dtype", JDBCTypesUtils.getJdbcName(type));//字段对应的java类型
				 map.put("ctype", strtype.substring(strtype.lastIndexOf(".")+1));//没有包的类型名字
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
	
	
	public static void createTemplate(List<Map<String, String>> fields,Map<String, String> infos) {
		try {
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
			// 指定模板如何检索数据模型，这是一个高级的主题了… // 但先可以这么来用： 
			cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
			// 指定模板文件从何处加载的数据源，这里设置成一个文件目录。
			cfg.setDirectoryForTemplateLoading(new File(projectPath+"/template"));
			

			// 数据
			Map root = new HashMap(); 
			// 在根中放入字符串"user" 
			root.put("beanModel", infos.get("beanModel")); 
			root.put("package", infos.get("pack"));
			root.put("fields", fields);
			
			
			
			//找到对应模板
			Template temp = cfg.getTemplate("pojo.tml");
			
			packagec = packagec.replaceAll("\\.", "/");
			//输出到指定目标
			File rootPath = new File(projectPath+File.separator+infos.get("baseDir")+File.separator+packagec);
			if(!rootPath.exists())rootPath.mkdirs();
			Writer out = new OutputStreamWriter(new FileOutputStream(new File(rootPath,beanModel+".java")),"gbk");
			//模板和数据 处理替换===真实数据或者页面
			temp.process(root, out); 
			out.flush();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	public static void main(String[] args) {
		
		List<Map<String, String>> fields = loadTable(tablename);
		
		Map<String, String> infos = new HashMap<>();
		infos.put("beanModel","Content");
		infos.put("baseDir","src/main/java");
		infos.put("pack","com.rumo.pojo");
		createTemplate(fields,infos);
		
	}
}
