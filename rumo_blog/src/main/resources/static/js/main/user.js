$(function(){
			
	$("#lnEditAvatar").on("click",function(e){
		$(".avatarbox-itemsbox").stop(true).slideToggle("slow");
		stopBubble(e);
	});
	
	$(".update_userinp").on("blur",function(){
		var $this = $(this);
		var title = $this.attr("title");
		var val = $this.val();
		var name = $this.data("name");
		if(isEmpty(val)){
			$this.val(title);
			return;
		}
		
		if(val == title){
			return;
		}
		
		var params = {};
		params[name]=val;
		request(basePath+"/user/updateUser",function(response){
			if(response.status==200){
				$this.attr("title",val);
				$(".avatar").attr("src",basePath+"/"+headerPic+"?d="+new Date().getTime());
			}
		},params);
	});
	
	
	$("body").on("click",function(){
		$(".avatarbox-itemsbox").stop(true).slideUp("slow");
	});
	
	$(".avatarbox-items").click(function(){
		var headerPic = $(this).data("avatar");
		request(basePath+"/user/updateUser",function(response){
			if(response.status==200){
				loading("修改成功....",4);
				$(".avatar").attr("src",basePath+"/"+headerPic+"?d="+new Date().getTime());
			}
		},{headerPic:headerPic})
	});
	
	$("#data_listbox").on("click",".btn-action-remove",function(){
		var opid = $(this).data("opid");
		var model = $(this).data("model");
		var $li = $(this).parents(".track-item");
		mkCommon.tip("你确定删除吗?","success",function(ok){
			if(ok){
				request(basePath+"/admin/"+model+"/delete/"+opid,function(response){
					if(response.status==200){
						$li.fadeOut("slow",function(){
							$(this).remove();
						})
					}
				});
			}
		});
	});
	
	$("#data_listbox").on("click",".btn-action-remove",function(){
		var opid = $(this).data("opid");
		var model = $(this).data("model");
		var $li = $(this).parents(".track-item");
		mkCommon.tip("你确定删除吗?","success",function(ok){
			if(ok){
				request(basePath+"/admin/"+model+"/delete/"+opid,function(response){
					if(response.status==200){
						$li.fadeOut("slow",function(){
							$(this).remove();
						})
					}
				});
			}
		});
	});
	
	$("#data_listbox").on("click",".btn-action-password",function(){
		var userId = $(this).data("uid");
		$.tzPrompt({title:"密码修改提示",content:"请输入新密码6-16位",callback:function(ok){
			if(ok){
				request(basePath+"/user/updatepassword",function(response){
					if(response.status==200){
						loading("修改成功!",4);
					}
				},{id:userId,password:ok});
			}
		}})
	});
	
	$("#data_listbox").on("change",".btn-action-yearuser",function(){
		var userId = $(this).data("uid");
		var mark = $(this).val(); 
		request(basePath+"/admin/order/saveorder/"+userId+"/"+mark,function(response){
			if(response.status==200){
				loading("授权成功!",4);
			}
		});
	});
	
	$("#data_listbox").on("change",".btn-action-type",function(){
		var userId = $(this).data("uid");
		var type = $(this).val();
		
		request(basePath+"/user/updatetype",function(response){
			if(response.status==200){
				loading("授权成功!",4);
			}
		},{id:userId,type:type});
	});
	
	$("#data_listbox").on("click",".btn-action-cancel-yearuser",function(){
		var userId = $(this).data("uid");
		var mark = $(this).val(); 
		request(basePath+"/admin/order/deleteorder/"+userId,function(response){
			if(response.status==200){
				loading("取消成功!",4);
			}
		});
	});
	
	
	$("#data_listbox").on("click",".btn-action-active",function(){
		var userId = $(this).data("uid");
		var $this = $(this);
		var active = $(this).hasClass("green")?0:1;
		mkCommon.tip("你确定禁止该用户吗?","success",function(ok){
			if(ok){
				request(basePath+"/user/updateUser",function(response){
					if(response.status==200){
						if($this.hasClass("green")){
							loading("禁止成功!!!",4);
							$this.removeClass("green").addClass("red").text("已禁止");
						}else{
							loading("恢复成功!!!",4);
							$this.removeClass("red").addClass("green").text("禁止");
						}
					}
				},{id:userId,active:active});
			}
		});
	});
	
	
	
	
	var pageflag = true;
	var target  = {};
	target.pageNo = 1;
	target.pageflag = true;
	
	$("#my_mangerblog").on("click",function(){
		//if($(this).hasClass("actived"))return;
		$(this).addClass("actived").siblings().removeClass("actived");
		if(target.box!=this){
			target.pageNo = 1;
			target.pageflag = true;
		}
		target.box = this;
		loadingtip("#loadingbox");
		$("#data_listbox").load(basePath+"/admin/blog/hit/template",{pageNo:target.pageNo,pageSize:"20"},function(data){
			$("#loadingbox").empty();
			if(isEmpty(data)){
				$("#data_listbox").html("<div class='empty tc' style='background:#fbfbfb;padding:60px;'><a href='"+basePath+"'>暂无数据，点击去看看...</a></div>");
				return;
			}
			if(target.pageflag){
				var pages = $("#data_listbox").children().eq(0).data("pages");
				if(pages>1){
					loadPage(pages);
					target.pageflag = false;
				}else{
					$("#page").empty();
				}
			}
		});
	}).trigger("click");
	
	$("#my_mangercourse").on("click",function(){
		//if($(this).hasClass("actived"))return;
		$(this).addClass("actived").siblings().removeClass("actived");
		if(target.box!=this){
			target.pageNo = 1;
			target.pageflag = true;
		}
		target.box = this;
		loadingtip("#loadingbox");
		$("#data_listbox").load(basePath+"/admin/course/hit/template",{pageNo:target.pageNo,pageSize:"20"},function(data){
			$("#loadingbox").empty();
			if(isEmpty(data)){
				$("#data_listbox").html("<div class='empty tc' style='background:#fbfbfb;padding:60px;'><a href='"+basePath+"/course'>暂无数据，点击去看看...</a></div>");
				return;
			}
			if(target.pageflag){
				var pages = $("#data_listbox").children().eq(0).data("pages");
				if(pages>1){
					loadPage(pages);
					target.pageflag = false;
				}else{
					$("#page").empty();
				}
			}
		});
	});
	
	$("#my_mangeruser_course").on("click",function(){
		//if($(this).hasClass("actived"))return;
		$(this).addClass("actived").siblings().removeClass("actived");
		if(target.box!=this){
			target.pageNo = 1;
			target.pageflag = true;
		}
		target.box = this;
		loadingtip("#loadingbox");
		$("#data_listbox").load(basePath+"/admin/course/my/template",{pageNo:target.pageNo,pageSize:"20"},function(data){
			$("#loadingbox").empty();
			if(isEmpty(data)){
				$("#data_listbox").html("<div class='empty tc' style='background:#fbfbfb;padding:60px;'><a href='"+basePath+"/course'>暂无数据，点击去看看...</a></div>");
				return;
			}
			if(target.pageflag){
				var pages = $("#data_listbox").children().eq(0).data("pages");
				if(pages>1){
					loadPage(pages);
					target.pageflag = false;
				}else{
					$("#page").empty();
				}
			}
		});
	});
	
	
	$("#mangercourse").on("click",function(){
		//if($(this).hasClass("actived"))return;
		$(this).addClass("actived").siblings().removeClass("actived");
		if(target.box!=this){
			target.pageNo = 1;
			target.pageflag = true;
		}
		target.box = this;
		loadingtip("#loadingbox");
		$("#data_listbox").load(basePath+"/admin/course/template",{pageNo:target.pageNo,pageSize:"20"},function(data){
			$("#loadingbox").empty();
			if(isEmpty(data)){
				$("#data_listbox").html("<div class='empty tc' style='background:#fbfbfb;padding:60px;'><a href='"+basePath+"/course'>暂无数据，点击去看看...</a></div>");
				return;
			}
			if(target.pageflag){
				var pages = $("#data_listbox").children().eq(0).data("pages");
				if(pages>1){
					loadPage(pages);
					target.pageflag = false;
				}else{
					$("#page").empty();
				}
			}
		});
	});
	
	$("#mangerblog").on("click",function(){
		//if($(this).hasClass("actived"))return;
		$(this).addClass("actived").siblings().removeClass("actived");
		if(target.box!=this){
			target.pageNo = 1;
			target.pageflag = true;
		}
		target.box = this;
		loadingtip("#loadingbox");
		$("#data_listbox").load(basePath+"/admin/blog/template",{pageNo:target.pageNo,pageSize:"20"},function(data){
			$("#loadingbox").empty();
			if(isEmpty(data)){
				$("#data_listbox").html("<div class='empty tc' style='background:#fbfbfb;padding:60px;'><a href='"+basePath+"'>暂无数据，点击去看看...</a></div>");
				return;
			}
			if(target.pageflag){
				var pages = $("#data_listbox").children().eq(0).data("pages");
				if(pages>1){
					loadPage(pages);
					target.pageflag = false;
				}else{
					$("#page").empty();
				}
			}
		});
	});
	
	$("#mangeruser").on("click",function(){
		//if($(this).hasClass("actived"))return;
		$(this).addClass("actived").siblings().removeClass("actived");
		if(target.box!=this){
			target.pageNo = 1;
			target.pageflag = true;
		}
		target.box = this;
		loadingtip("#loadingbox");
		$("#data_listbox").load(basePath+"/admin/user/template",{pageNo:target.pageNo,pageSize:"20"},function(data){
			$("#loadingbox").empty();
			if(isEmpty(data)){
				$("#data_listbox").html("<div class='empty tc' style='background:#fbfbfb;padding:60px;'><a href='"+basePath+"'>暂无数据，点击去看看...</a></div>");
				return;
			}
			if(target.pageflag){
				var pages = $("#data_listbox").children().eq(0).data("pages");
				if(pages>1){
					loadPage(pages);
					target.pageflag = false;
				}else{
					$("#page").empty();
				}
			}
		});
	});
	
	/*分页信息*/
	function loadPage(totalPages){
		$("#page").show().Page({
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
		    	target.pageNo = page;
		    	$(target.box).trigger("click");
		    }
		});
	};
	
	countUserinfo();
	function countUserinfo(){
		$.post(basePath+"/user/getinfo",function(response){
			var data = response.data;
			for(var key in data){
				$("."+key).text(data[key]);
			}
		});
	};
});