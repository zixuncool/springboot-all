/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-27 14:14:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.admin.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.rumo.util.RequestUtil;

public final class admin_002drole_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/pages/admin/role/../_footer.jsp", Long.valueOf(1537681137905L));
    _jspx_dependants.put("/WEB-INF/pages/admin/role/../_common.jsp", Long.valueOf(1538055725870L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!--_meta 作为公共模版分离出去-->\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");

	String basePath = RequestUtil.getBasePath(request);
	pageContext.setAttribute("basePath", basePath);

      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\" />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("<link rel=\"Bookmark\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/favicon.ico\" >\r\n");
      out.write("<link rel=\"Shortcut Icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/favicon.ico\" />\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/html5shiv.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/respond.min.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/h-ui/css/H-ui.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/h-ui.admin/css/H-ui.admin.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/Hui-iconfont/1.0.8/iconfont.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/h-ui.admin/skin/green/skin.css\" id=\"skin\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/h-ui.admin/css/style.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css\" type=\"text/css\">\r\n");
      out.write("<!--[if IE 6]>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/DD_belatedPNG_0.0.8a-min.js\" ></script>\r\n");
      out.write("<script>DD_belatedPNG.fix('*');</script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<script>var basePath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";</script>");
      out.write("<title>新建网站角色 - 管理员管理 - 濡沫电商后台管理系统</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"濡沫电商后台管理系统,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载\">\r\n");
      out.write("<meta name=\"description\" content=\"濡沫电商后台管理系统，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<article class=\"page-container\">\r\n");
      out.write("\t<form action=\"\" method=\"post\"  class=\"form form-horizontal\" id=\"form-admin-role-add\">\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-xs-4 col-sm-3\"><span class=\"c-red\">*</span>角色名称：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-xs-8 col-sm-9\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"input-text\" value=\"\"  placeholder=\"请输入角色名称\" id=\"roleName\" name=\"name\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-xs-4 col-sm-3\">备注：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-xs-8 col-sm-9\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"input-text\" value=\"\" placeholder=\"请输入备注\" id=\"remark\" name=\"remark\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-xs-4 col-sm-3\"><span class=\"c-red\">*</span>发布状态：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-xs-8 col-sm-9\">\r\n");
      out.write("\t\t\t\t<label><input type=\"radio\" class=\"input-textc\"  checked=\"checked\" value=\"1\" name=\"status\">发布</label>\r\n");
      out.write("\t\t\t\t<label><input type=\"radio\" class=\"input-textc\"   value=\"0\" name=\"status\">未发布</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\" style=\"display: none;\">\r\n");
      out.write("\t\t\t<label class=\"form-label col-xs-4 col-sm-3\">网站角色：</label>\r\n");
      out.write("\t\t\t<div class=\"formControls col-xs-8 col-sm-9\">\r\n");
      out.write("\t\t\t\t<dl class=\"permission-list\">\r\n");
      out.write("\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0\" id=\"user-Character-0\">\r\n");
      out.write("\t\t\t\t\t\t\t资讯管理</label>\r\n");
      out.write("\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<dl class=\"cl permission-list2\">\r\n");
      out.write("\t\t\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-0\" id=\"user-Character-0-0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t栏目管理</label>\r\n");
      out.write("\t\t\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-0-0\" id=\"user-Character-0-0-0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t添加</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-0-0\" id=\"user-Character-0-0-1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t修改</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-0-0\" id=\"user-Character-0-0-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t删除</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-0-0\" id=\"user-Character-0-0-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t查看</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-0-0\" id=\"user-Character-0-0-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t审核</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"c-orange\"><input type=\"checkbox\" value=\"\" name=\"user-Character-0-0-0\" id=\"user-Character-0-0-5\"> 只能操作自己发布的</label>\r\n");
      out.write("\t\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t\t<dl class=\"cl permission-list2\">\r\n");
      out.write("\t\t\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-1\" id=\"user-Character-0-1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t文章管理</label>\r\n");
      out.write("\t\t\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-1-0\" id=\"user-Character-0-1-0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t添加</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-1-0\" id=\"user-Character-0-1-1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t修改</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-1-0\" id=\"user-Character-0-1-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t删除</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-1-0\" id=\"user-Character-0-1-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t查看</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0-1-0\" id=\"user-Character-0-1-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t审核</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"c-orange\"><input type=\"checkbox\" value=\"\" name=\"user-Character-0-2-0\" id=\"user-Character-0-2-5\"> 只能操作自己发布的</label>\r\n");
      out.write("\t\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t<dl class=\"permission-list\">\r\n");
      out.write("\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-0\" id=\"user-Character-1\">\r\n");
      out.write("\t\t\t\t\t\t\t用户中心</label>\r\n");
      out.write("\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<dl class=\"cl permission-list2\">\r\n");
      out.write("\t\t\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-1-0\" id=\"user-Character-1-0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t用户管理</label>\r\n");
      out.write("\t\t\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-1-0-0\" id=\"user-Character-1-0-0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t添加</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-1-0-0\" id=\"user-Character-1-0-1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t修改</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-1-0-0\" id=\"user-Character-1-0-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t删除</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-1-0-0\" id=\"user-Character-1-0-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t查看</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" value=\"\" name=\"user-Character-1-0-0\" id=\"user-Character-1-0-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t审核</label>\r\n");
      out.write("\t\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row cl\">\r\n");
      out.write("\t\t\t<div class=\"col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3\">\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-success radius\" id=\"admin-role-save\" name=\"admin-role-save\"><i class=\"icon-ok\"></i> 确定</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</article>\r\n");
      out.write("\r\n");
      out.write("<!--_footer 作为公共模版分离出去-->\r\n");
      out.write("<!--_footer 作为公共模版分离出去-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/jquery/1.12.4/jquery.min.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/layer/2.4/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/h-ui/js/H-ui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/h-ui.admin/js/H-ui.admin.js\"></script> <!--/_footer 作为公共模版分离出去-->\r\n");
      out.write("<!--请在下方写此页面业务相关的脚本-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/jquery.contextmenu/jquery.contextmenu.r2.js\"></script>");
      out.write("<!--请在下方写此页面业务相关的脚本-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/jquery.validation/1.14.0/jquery.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/jquery.validation/1.14.0/validate-methods.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/lib/jquery.validation/1.14.0/messages_zh.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\t//1：删除form表单\r\n");
      out.write("\t//2:把button submit改成a链接\r\n");
      out.write("\t//3:推荐使用：去掉默认行为： e.preventDefault();\r\n");
      out.write("\tvar rumoRole = {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//初始化操作\r\n");
      out.write("\t\tinit:function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t//绑定确定按钮的点击事件\r\n");
      out.write("\t\t\t$(\"#admin-role-save\").on(\"click\",this.saveRole);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//保存角色\r\n");
      out.write("\t\tsaveRole :function(e){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t var name = $(\"#roleName\").val();\r\n");
      out.write("\t\t\t var remark = $(\"#remark\").val();\r\n");
      out.write("\t\t\t var status = $(\"input[name='status']:checked\").val();\r\n");
      out.write("\t\t\t //组装参数\r\n");
      out.write("\t\t\t var params = {\r\n");
      out.write("\t\t\t\t 'name':name,\r\n");
      out.write("\t\t\t\t 'remark':remark,\r\n");
      out.write("\t\t\t\t 'status':status\r\n");
      out.write("\t\t\t };\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t var promise = $.post(basePath+\"/admin/role/save\",params);\r\n");
      out.write("\t\t\t promise.done(function(response){\r\n");
      out.write("\t\t\t\t if(response.status==200){\r\n");
      out.write("\t\t\t\t\t alert(\"保存成功!!!\");\r\n");
      out.write("\t\t\t\t\t $(parent).find(\".layui-layer-close\").trigger(\"click\");\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t }).fail(function(err){\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t });\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t //去除button,submit的默认行为\r\n");
      out.write("\t\t\t e.preventDefault();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\trumoRole.init();\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\".permission-list dt input:checkbox\").click(function(){\r\n");
      out.write("\t\t$(this).closest(\"dl\").find(\"dd input:checkbox\").prop(\"checked\",$(this).prop(\"checked\"));\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\".permission-list2 dd input:checkbox\").click(function(){\r\n");
      out.write("\t\tvar l =$(this).parent().parent().find(\"input:checked\").length;\r\n");
      out.write("\t\tvar l2=$(this).parents(\".permission-list\").find(\".permission-list2 dd\").find(\"input:checked\").length;\r\n");
      out.write("\t\tif($(this).prop(\"checked\")){\r\n");
      out.write("\t\t\t$(this).closest(\"dl\").find(\"dt input:checkbox\").prop(\"checked\",true);\r\n");
      out.write("\t\t\t$(this).parents(\".permission-list\").find(\"dt\").first().find(\"input:checkbox\").prop(\"checked\",true);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\tif(l==0){\r\n");
      out.write("\t\t\t\t$(this).closest(\"dl\").find(\"dt input:checkbox\").prop(\"checked\",false);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(l2==0){\r\n");
      out.write("\t\t\t\t$(this).parents(\".permission-list\").find(\"dt\").first().find(\"input:checkbox\").prop(\"checked\",false);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#form-admin-role-add\").validate({\r\n");
      out.write("\t\trules:{\r\n");
      out.write("\t\t\troleName:{\r\n");
      out.write("\t\t\t\trequired:true,\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tonkeyup:false,\r\n");
      out.write("\t\tfocusCleanup:true,\r\n");
      out.write("\t\tsuccess:\"valid\",\r\n");
      out.write("\t\tsubmitHandler:function(form){\r\n");
      out.write("\t\t\t$(form).ajaxSubmit();\r\n");
      out.write("\t\t\tvar index = parent.layer.getFrameIndex(window.name);\r\n");
      out.write("\t\t\tparent.layer.close(index);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<!--/请在上方写此页面业务相关的脚本-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
