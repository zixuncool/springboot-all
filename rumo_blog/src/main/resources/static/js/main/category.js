var mkCategory = {
	pageNo:1,
	pageSize:10,
	timer:null,
	init:function(){
		this.loadPage($("#posts").children().eq(0).data("psize"));
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
		    callBack : function(page){//每次点击分页执行的回调函数
		    	//点击分页获取吓一条数据
		    	mkCategory.pageNo = page;
		    	mkCategory.loadCategory();
		    }
		});
	},
	
	//查询
	loadCategory:function(callback){
		if(mkCategory.timer)clearTimeout(mkCategory.timer);
		mkCategory.timer = setTimeout(function(){
			//获取参数
			var params = {"pageNo":mkCategory.pageNo,"pageSize":mkCategory.pageSize};
			$("#posts").load(basePath+"/category/template",params,function(data){
				var psize = $("#posts").children().eq(0).data("psize");
				callback && callback(psize);
			});
		}, 200);
	},
	
	//保存
	save:function(){
		//校验
		if(!this.validator()){
			return;
		}
		
		//获取参数
		var name = $("#name").val();
		var isDelete = $("#isDelete").val();
		var sort = $("#sort").val();
		var icon = $("#icon").val();
		var parentId = $("#parentId").val();
		var img = $("#img").val();
		var description = $("#description").val();
		var ispush = $("#ispush").val();
		var background = $("#background").val();
		var collegeId = $("#collegeId").val();
		var type = $("#type").val();
		
		//设置参数
		var params = {
			"name":name,
			"isDelete":isDelete,
			"sort":sort,
			"icon":icon,
			"parentId":parentId,
			"img":img,
			"description":description,
			"ispush":ispush,
			"background":background,
			"collegeId":collegeId,
			"type":type
		};
		//保存方法
		var promise = $.post(basePath+"/category/saveCategory",params);
		promise.done(function(response){
			console.log(response,response.data);
		}).fail(function(err){
			console.log(err);
		});
	},
	
	//修改
	update:function(){
		//校验
		if(!this.validator()){
			return;
		}
		
		//获取参数
		var id = $("#id").val();
		var name = $("#name").val();
		var isDelete = $("#isDelete").val();
		var sort = $("#sort").val();
		var icon = $("#icon").val();
		var parentId = $("#parentId").val();
		var img = $("#img").val();
		var description = $("#description").val();
		var ispush = $("#ispush").val();
		var background = $("#background").val();
		var collegeId = $("#collegeId").val();
		var type = $("#type").val();
		
		//设置参数
		var params = {
			"id":id,
			"name":name,
			"isDelete":isDelete,
			"sort":sort,
			"icon":icon,
			"parentId":parentId,
			"img":img,
			"description":description,
			"ispush":ispush,
			"background":background,
			"collegeId":collegeId,
			"type":type
		};
		//保存方法
		var promise = $.post(basePath+"/category/updateCategory",params);
		promise.done(function(response){
			console.log(response,response.data);
		}).fail(function(err){
			console.log(err);
		});
	},
	
	//删除
	del:function(){
		//保存方法
		var id = 1;
		var promise = $.post(basePath+"/category/deleteCategory/"+id);
		promise.done(function(response){
			console.log(response,response.data);
		}).fail(function(err){
			console.log(err);
		});
	},
	
	//校验器
	validator:function(){
		return true;
	}
};

$(function(){
	mkCategory.init();
});

