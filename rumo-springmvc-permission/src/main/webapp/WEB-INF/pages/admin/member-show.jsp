<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<%@include file="_common.jsp"%>
<title>用户查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
	<img class="avatar size-XL l" src="static/h-ui/images/ucnter/avatar-default.jpg">
	<dl style="margin-left:80px; color:#fff">
		<dt>
			<span class="f-18">张三</span>
			<span class="pl-10 f-12">余额：40</span>
		</dt>
		<dd class="pt-10 f-12" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
	</dl>
</div>
<div class="pd-20">
	<table class="table">
		<tbody>
			<tr>
				<th class="text-r" width="80">性别：</th>
				<td>男</td>
			</tr>
			<tr>
				<th class="text-r">手机：</th>
				<td>13000000000</td>
			</tr>
			<tr>
				<th class="text-r">邮箱：</th>
				<td>admin@mail.com</td>
			</tr>
			<tr>
				<th class="text-r">地址：</th>
				<td>北京市 海淀区</td>
			</tr>
			<tr>
				<th class="text-r">注册时间：</th>
				<td>2014.12.20</td>
			</tr>
			<tr>
				<th class="text-r">积分：</th>
				<td>330</td>
			</tr>
		</tbody>
	</table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${basePath}/lib/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
</body>
</html>