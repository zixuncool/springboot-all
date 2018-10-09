function loadHighligther(){
			$("pre code").each(function(i, block){
		if($(this).find("code").length==0){
			$(this).wrapInner("<code class='hljs javascript,java,sql,nodejs,vuejs,html,css,json'></code>");
		}else{
			$(this).find("code").addClass("hljs javascript,java,sql,nodejs,vuejs,html,css,json");
		}
		 hljs.highlightBlock(block);
	});
}
/*分页信息*/
function loadPage(totalPages){
	$("#page").Page({
	    totalPages: totalPages,//total Pages
	    liNums: 7,
	    activeClass: 'activP', //active class style
	    firstPage: '<',//first button name
	    lastPage: '>',//last button name
	    prv: '<<',//prev button name
	    next: '>>',//next button name
	    hasFirstPage: true,
	    hasLastPage: true,
	    hasPrv: true,
	    hasNext: true,
	    callBack : function(page){
	    	mkBlog.pageNo = page;
	    	mkBlog.loadBlog();
	    }
	});
};

var mkBlog = {
	pageNo:2,
	pageSize:10,
	timer:null,
	loadBlog:function(callback){
		if(mkBlog.timer)clearTimeout(mkBlog.timer);
		mkBlog.timer = setTimeout(function(){
			var cid = $("body").data("cid");
			var params = {"pageNo":mkBlog.pageNo,"pageSize":mkBlog.pageSize,"categoryId":cid};
			$("#posts").load(basePath+"/blog/template",params,function(data){
				var psize = $("#posts").children().eq(0).data("psize");
				loadHighligther();
				callback && callback(psize);
			});
		}, 200);
	},
	search:function(){
		
	}
};

$(function(){
	loadHighligther()
	loadPage($("#posts").children().eq(0).data("psize"));
});