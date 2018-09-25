
 /**
 * itbooking系统平台<br/>
 * com.rumo.util<br/>
 * ProjectAutoUtil.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月25日-下午10:21:55 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.auto;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

/**
 * 自动构建类
 * ProjectAutoUtil<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月25日-下午10:21:55 <br/>
 * @version 1.0.0<br/>
 * 
 */
public class ProjectAutoUtil {

	//定义模块
	private static	String beanModel = "Stat";
	private static	String model = beanModel.toLowerCase();
	private static String author = "笑对人生";
	private static String description = "统计管理模块";
	private static String datetime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
	//获取当前项目路径
	private static String projectPath = System.getProperty("user.dir");
	
	public static void createSerivce() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/java");
		//1:创建service
		String servicePackage = "com/rumo/service/"+model;
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/IService.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//把模板中的所有的占位符传布替换成具体模块名
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,"I"+beanModel+"Service.java"), replaceContent(content),"UTF-8");
	}
	
	
	
	
	public static void createSerivceImpl() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/java");
		//1:创建service
		String servicePackage = "com/rumo/service/"+model;
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/ServiceImpl.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,beanModel+"ServiceImpl.java"), replaceContent(content),"UTF-8");
	}
	
	
	public static void createPojo() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/java");
		//1:创建service
		String servicePackage = "com/rumo/pojo";
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/pojo.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,beanModel+".java"), replaceContent(content),"UTF-8");
	}
	
	
	public static void createVo() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/java");
		//1:创建service
		String servicePackage = "com/rumo/vo";
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/vo.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,beanModel+"Vo.java"), replaceContent(content),"UTF-8");
	}
	
	
	public static void createMapper() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/java");
		//1:创建service
		String servicePackage = "com/rumo/mapper";
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/Mapper.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,beanModel+"Mapper.java"), replaceContent(content),"UTF-8");
	}
	
	public static void createMapperXML() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/resources");
		//1:创建service
		String servicePackage = "mapper";
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/Mapperxml.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,beanModel+"Mapper.xml"), replaceContent(content),"UTF-8");
	}
	
	public static void createController() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/java");
		//1:创建service
		String servicePackage = "com/rumo/controller/"+model;
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/controller.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,beanModel+"Controller.java"), replaceContent(content),"UTF-8");
	}
	
	
	public static void createListJsp() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/webapp/WEB-INF/pages/admin/");
		//1:创建service
		String servicePackage = model;
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/list.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//把模板中的所有的占位符传布替换成具体模块名
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,model+"-list.jsp"), replaceContent(content),"UTF-8");
	}
	
	public static void createListJspTemplate() throws IOException{
		//找到我src目录
		File srcPath = new File(projectPath,"src/main/webapp/WEB-INF/pages/admin/");
		//1:创建service
		String servicePackage = model;
		//创建模块对应service--package
		File servicePath = new File(srcPath,servicePackage);
		//如果不创建就创建
		if(!servicePath.exists()) {
			servicePath.mkdirs();
		}
		//service读取模板路径
		String iserviceTemplate = projectPath+"/templates/template.tml";
		String content = FileUtils.readFileToString(new File(iserviceTemplate), "UTF-8");
		//把模板中的所有的占位符传布替换成具体模块名
		//写入到制定的service对应的package包中
		FileUtils.write(new File(servicePath,"template.jsp"), replaceContent(content),"UTF-8");
	}
	
	
	public static void createTable(){
		try {
			//获取模板页面路径
			String dbtemplate = projectPath+"/templates/table.tml";
			String content = FileUtils.readFileToString(new File(dbtemplate), "UTF-8");
			content = replaceContent(content);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tmalldb?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "root","mkxiaoer");
			Statement stmt = connection.createStatement();
			String dropsql = "DROP TABLE IF EXISTS `rumo_"+model+"`";
			stmt.executeUpdate(dropsql);
	        String sql =content;
	        stmt.executeUpdate(sql);
	        System.out.println("【自动构建提示Table: 】生成表rumo_"+model+"表成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("【自动构建提示Table: 】生成表rumo_"+model+"表失败!");
		} 
	}
	
	
	public static void loadTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tmalldb?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "root","mkxiaoer");
			 Statement st = connection.createStatement();
			 String sql = "SELECT * FROM rumo_content";
			 ResultSet rs = st.executeQuery(sql);
			 ResultSetMetaData rsmd = rs.getMetaData();
			 for( int i=1; i<=rsmd.getColumnCount(); i++ ){
				 String field = rsmd.getColumnName(i);
				 int type =  rsmd.getColumnType(i) ; //5--DATA_TYPE int => SQL type from java.sql.Types
				 System.out.println(field+"=="+type);
				 if(Types.INTEGER==type){
					 System.out.println("Integer");
				 }else if (Types.VARCHAR == type) {
					System.out.println("String");
				 }	
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//如果写入模块中，驼峰命名
	
	
	public static String replaceContent(String content) {
		content = content
				.replaceAll("\\[model\\]",model)
				.replaceAll("\\[author\\]",author)
				.replaceAll("\\[datetime\\]",datetime)
				.replaceAll("\\[description\\]",description)
				.replaceAll("\\[beanModel\\]", beanModel);
		return content;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
		/*createPojo();
		createVo();
		createSerivce();
		createSerivceImpl();
		createMapper();
		createMapperXML();
		createController();
		createListJsp();
		createListJspTemplate();*/
		
		createTable();
		loadTable() ;
		
		//2:创建pojo
		//3:创建mapper
		//4:创建 controller
		//5:创建页面
		//6:可以创建数据库表
		
		
		
	}
}
