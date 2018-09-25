<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<%@include file="../_common.jsp"%>
<title>用户管理</title>
<style>
	/****************************page************************/
	#page{display:table;line-height:50px;margin:10px auto 10px}
	.page{text-align:center}
	.fl{float:left}
	.fr{float:right}
	.pagingUl{float:right;padding:0;margin:0;list-style:none;height:30px}
	.pagingUl li{float:left;width:30px;height:30px;background:#fff;text-align:center;margin-right:10px;border-radius:5px;
	}
	.pagingUl li a{display:inline-block;width:30px;height:30px;text-align:center;line-height:28px;color:#666;font-size:12px;border-radius:5px;border:1px solid #ccc}
	.prv,.next{text-align:center;cursor:pointer;background:#fff;padding:0 5px;border-radius:5px;
	height: 30px;
	    line-height: 30px;
	    margin-top: 13px;font-size: 14px;}
	.prv{margin-right:10px}
	.first,.last{font-size:12px;text-align:center;cursor:pointer;background:#fff;padding:0 5px;border-radius:5px;margin-right:10px;
	height: 30px;
	    line-height: 30px;
	    margin-top: 13px;}
	.prv:hover,.next:hover,.first:hover,.last:hover,.pagingUl li a:hover,.activP{background-color:#333 !important;color:#fff !important}
</style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" id="keyword" style="width:250px" placeholder="输入会员名称、电话、邮箱">
		<button type="button" class="btn btn-success radius" id="search_contentbtn"><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span> <span class="r">共有数据：<strong>88</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th width="100">标题</th>
				<th width="40">状态</th>
				<th width="90">时间</th>
				<th width="150">邮箱	</th>
				<th width="">地址</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody id="tbody">
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="20">
					<div id="page"></div>
				</td>
			</tr>
		</tfoot>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<%@include file="../_footer.jsp"%>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${basePath}/js/page/jquery.page.js"></script>
<script>
	
	var rumoContent = {
		pageNo:1,
		pageSize:2,
		keyword:"",
		status:"",
		init:function(){
			rumoContent.load(function(totalPageSize){
				//初始化分页
				rumoContent.loadPage(totalPageSize*1);
			});
			
			$("#search_contentbtn").on("click",function(){
				rumoContent.search();
			});
			
			//有一个前提，没有调用的方法没有参数
			//$("#search_contentbtn").on("click",rumoContent.search);
		},
		
		search:function(){

			var keyword = $("#keyword").val();
			
			//改变参数
			rumoContent.pageNo = 0;
			rumoContent.keyword = keyword;
			
			//调用查询方法
			rumoContent.load(function(totalPageSize){
				//初始化分页
				rumoContent.loadPage(totalPageSize*1);
			});
				
		},
		
		load:function(callback){
			
			//借用模板
			var params = {
				"pageNo":rumoContent.pageNo,
				"pageSize":rumoContent.pageSize,
				"keyword":rumoContent.keyword,
				"status":rumoContent.status
			}
			
			$("#tbody").load("http://localhost:8082/admin/content/template",params,function(){
				var psize = $("#tbody").children().eq(0).attr("psize");
				callback && callback(psize);
			});
		},
		
		loadPage:function(totalPages){
			$("#page").Page({
			    totalPages: totalPages,//total Pages
			    liNums: 7,
			    activeClass: 'activP', //active class style
			    firstPage: '<',//first button name
			    lastPage: '>',//last button name
			    prv: '<<',//prev button name
			    next: '>>',//next button name
			    hasFirstPage: true,//whether has first button
			    hasLastPage: true,//whether has last button
			    hasPrv: true,//whether has prev button
			    hasNext: true,//whether has next button
			    callBack : function(pageNo){//每次点击分页执行的回调函数
			    	//点击分页获取吓一条数据
			    	rumoContent.pageNo = pageNo;
			    	//不分页
			    	rumoContent.load();
			    }
			});
		}
	};
	
	
	
	$(function(){
		rumoContent.init();
	});
	/*用户-添加*/
	function member_add(title,url,w,h){
		layer_show(title,url,w,h);
	}
	/*用户-查看*/
	function member_show(title,url,id,w,h){
		layer_show(title,url,w,h);
	}
	/*用户-停用*/
	function member_stop(obj,id){
		layer.confirm('确认要停用吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '',
				dataType: 'json',
				success: function(data){
					$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
					$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
					$(obj).remove();
					layer.msg('已停用!',{icon: 5,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}
	
	/*用户-启用*/
	function member_start(obj,id){
		layer.confirm('确认要启用吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '',
				dataType: 'json',
				success: function(data){
					$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
					$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
					$(obj).remove();
					layer.msg('已启用!',{icon: 6,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});
		});
	}
	/*用户-编辑*/
	function member_edit(title,url,id,w,h){
		layer_show(title,url,w,h);
	}
	/*密码-修改*/
	function change_password(title,url,id,w,h){
		layer_show(title,url,w,h);	
	}
	/*用户-删除*/
	function member_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '',
				dataType: 'json',
				success: function(data){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}
</script> 
</body>
</html>