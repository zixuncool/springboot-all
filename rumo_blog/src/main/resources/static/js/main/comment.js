var mkComment = {
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
		    	mkComment.pageNo = page;
		    	mkComment.loadComment();
		    }
		});
	},
	
	//查询
	loadComment:function(callback){
		if(mkComment.timer)clearTimeout(mkComment.timer);
		mkComment.timer = setTimeout(function(){
			//获取参数
			var params = {"pageNo":mkComment.pageNo,"pageSize":mkComment.pageSize};
			$("#posts").load(basePath+"/comment/template",params,function(data){
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
		var content = $("#content").val();
		var userId = $("#userId").val();
		var ip = $("#ip").val();
		var isDelete = $("#isDelete").val();
		var status = $("#status").val();
		var contentId = $("#contentId").val();
		var isTop = $("#isTop").val();
		var parentId = $("#parentId").val();
		var replyUserid = $("#replyUserid").val();
		var score = $("#score").val();
		
		//设置参数
		var params = {
			"content":content,
			"userId":userId,
			"ip":ip,
			"isDelete":isDelete,
			"status":status,
			"contentId":contentId,
			"isTop":isTop,
			"parentId":parentId,
			"replyUserid":replyUserid,
			"score":score
		};
		//保存方法
		var promise = $.post(basePath+"/comment/saveComment",params);
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
		var content = $("#content").val();
		var userId = $("#userId").val();
		var ip = $("#ip").val();
		var isDelete = $("#isDelete").val();
		var status = $("#status").val();
		var contentId = $("#contentId").val();
		var isTop = $("#isTop").val();
		var parentId = $("#parentId").val();
		var replyUserid = $("#replyUserid").val();
		var score = $("#score").val();
		
		//设置参数
		var params = {
			"id":id,
			"content":content,
			"userId":userId,
			"ip":ip,
			"isDelete":isDelete,
			"status":status,
			"contentId":contentId,
			"isTop":isTop,
			"parentId":parentId,
			"replyUserid":replyUserid,
			"score":score
		};
		//保存方法
		var promise = $.post(basePath+"/comment/updateComment",params);
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
		var promise = $.post(basePath+"/comment/deleteComment/"+id);
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
	mkComment.init();
});

