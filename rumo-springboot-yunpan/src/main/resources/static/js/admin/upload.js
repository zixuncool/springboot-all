/*分页信息*/
function loadPage(totalPages){
	$("#page").Page({
	    totalPages: totalPages,//total Pages
	    liNums: 7,
	    activeClass: 'activP', //active class style
	    firstPage: '首页',//first button name
	    lastPage: '末页',//last button name
	    prv: '上一页',//prev button name
	    next: '下一页',//next button name
	    hasFirstPage: true,//whether has first button
	    hasLastPage: true,//whether has last button
	    hasPrv: true,//whether has prev button
	    hasNext: true,//whether has next button
	    callBack : function(page){//每次点击分页执行的回调函数
	    	//点击分页获取吓一条数据
	    	rumoResource.findResourcesAll(page,rumoResource.pageSize);
	    }
	});
};

function uploadFile(){
	
	// 初始化Web Uploader
	var uploader = WebUploader.create({
	    // 选完文件后，是否自动上传。
	    auto: true,
	    fileVal :"doc",
		formData:{"dir":"resources","zip":true,swidth:235,sheight:140},
	    // swf文件路径
	    swf:   'http://localhost:8080/js/webupload/Uploader.swf',
	    // 文件接收服务端。
	    server: 'http://localhost:8080/upload/file',
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input file元素，也可能是flash.
	    pick:{
	    	id:"#filePicker",
	    	//改变file控件的名字
	    	name:"doc",
	    	//改变按钮的文字
	    	innerHTML:"&nbsp;<i class='fa fa-upload c-icon icon_dnn1Ct'></i>&nbsp;",
	    	//改变文件的选择策略，true多选文件，如果是false那么就只能一张一张的选择
	    	multiple :true
	    }		   
	});
	
	 // 当有文件添加进来的时候,此方法主要用于判断文件上传之前进行一些验证操作
	 uploader.on('beforeFileQueued', function( file ) {
	     var folderId = $("#foldername").data("folderid");
	     if(!folderId){
	    	 alert("请选中一个目录进行此操作....");
	    	 return false;
	     }
	 });
	 
	 uploader.on( 'fileQueued', function( file ) {
		
	 });
	
	 //上传的进度
	 uploader.on( 'uploadProgress', function( file, percentage ) {
		 var percent = percentage * 100;
	 });

	 //上传成功
	 uploader.on( 'uploadSuccess', function( file,response) {
		rumoResource.save(response)
	 });

	 // 文件上传失败
	 uploader.on( 'uploadError', function( file ) {
	     
	 });

	 // 完成上传完了
	 uploader.on( 'uploadComplete', function( file ) {
	    
	 });
};

var rumoResource = {
	pageSize:30,	
	save:function(response){
		//获取当前操作的目录
		var folderId = $("#foldername").data("folderid");
		//给数组追加目录id
		response["folderId"] = folderId;
		//提交保存资源方法
		var promise = $.post("http://localhost:8080/saveResource",response);
		promise.done(function(response){
			if(response.status==200){
				var data = response.data;
				$("#resourcebox").prepend("<article class='clearfix c-div div_oSSKRH' id='"+data.id+"'>"+
						"	<div class='c-div div_QNxosG'>"+
						"		<img class='c-image image_RYUI1N' src='"+data.path+"'>"+
						"		<div class='c-div div_SUNYRV' style='z-index:1;'>"+
						"			<div class='clearfix c-div div_24LNze'>"+
						"				<a draggable='false' class='action-preview c-linkblock linkblock_xLqE9S' href='#'>"+
						"					<i class='fa fa-eye c-icon icon_yMAUER'>"+
						"			</i>"+
						"				</a>"+
						"				<a draggable='false' class='action-insert c-linkblock linkblock_TT2m0J' href='#'>"+
						"					<i class='fa fa-cloud-download c-icon icon_ySGc7U'>"+
						"				</i>"+
						"				</a>"+
						"			</div>"+
						"		</div>"+
						"	</div>"+
						"	<div class='clearfix c-div div_J0XteR'>"+
						"		<div class='checkbox c-checkbox checkbox_iiiD5P'>"+
						"			<input class='c-checkbox-input checkboxinput_tpdFrw' name='mymaterial' type='checkbox' value='"+data.id+"'>"+
						"		</div>"+
						"		<div class='c-div div_EitPkY'>"+
						"		</div>"+
						"		<p class='paragraph_QGvA4m'>"+data.oldname+"</p>"+
						"	</div>"+
						"</article>");
			}
		});
	},
	
	//查询目录资源
	findResources:function(folderId,pageNo,pageSize,callback){
		$("#resourcebox").load("http://localhost:8080/findResource/"+folderId+"/"+pageNo+"/"+pageSize,function(){
			if(callback){
				var pages = $("#resourcebox").children().eq(0).data("pages");
				callback(pages)
			}
		});
	},
	
	//查询所有
	findResourcesAll:function(pageNo,pageSize,callback){
		$("#resourcebox").load("http://localhost:8080/findResourceall/"+pageNo+"/"+pageSize,function(data){
			if(callback){
				var pages = $("#resourcebox").children().eq(0).data("pages");
				callback(pages)
			}
		});
	}
	/*findResourcesAllBase:function(pageNo,pageSize){
		$("#resourcebox").load("http://localhost:8080/findResourceall/"+pageNo+"/"+pageSize);
	}*/
}


/*加载tree相关的信息*/
function loadTreeDatas(){
	//配置参数
	var setting = {
		edit: {
			enable: true,
			editNameSelectAll: true,
			showRemoveBtn: showRemoveBtn,
			showRenameBtn: showRenameBtn
		},
		check: {
			enable: true
		},
		view: {
			addHoverDom: addHoverDom,
			removeHoverDom: removeHoverDom,
			showLine: true,//是否显示线条
			dblClickExpand:false,
			expandSpeed:"fast"
			//fontCss : {color:"red"}
		},
		data: {
			simpleData: { //约束java代码的key名字
				enable: true,
				idKey: "id",
				pIdKey: "pid",
				rootPId: 0
			}
		},
		callback: {
			onClick: onClick,
			//beforeEditName: beforeEditName,
			beforeRemove: beforeRemove,
			beforeRename: beforeRename,
			onRemove: onRemove,
			onRename: onRename,
			onCheck: onCheck
		}
	
	};
	
	
	function showRemoveBtn(treeId, treeNode) {
		//return !treeNode.isFirstNode;
		return true;
	}
	
	function showRenameBtn(treeId, treeNode) {
		//return !treeNode.isLastNode;
		return true;
	}
	
	//onClick 的执行取决于 beforeClick返回值 
	function onClick(event, treeId, treeNode, clickFlag) {
		$("#foldername").data("folderid",treeNode.id).text(treeNode.name);
		var folderId = treeNode.id;
		//根据id查询目录的文件信息
		if(treeNode.pid==0){
			//查询所有的文件
			rumoResource.findResourcesAll(1,rumoResource.pageSize,function(pages){
				//初始化分页
				loadPage(pages);
			});
		}else{
			//查询所有的文件
			rumoResource.findResources(folderId,1,rumoResource.pageSize,function(pages){
				//初始化分页
				loadPage(pages);
			});
		}
	}	
	
	
	/******************************添加按钮button -- start**********************************************/
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn){
			
			btn.bind("click", function(){
				
				var inputName=prompt("请输入你的名字：",treeNode.name); 
			    if (inputName){ 
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					var parentId = treeNode.id;
					var inputName =  inputName
					var promise = $.post("http://localhost:8080/saveFolder",{"name":inputName,"parentId":parentId});
					promise.done(function(response){
						if(response.status==200){
							//追加节点
							zTree.addNodes(treeNode, {id:response.data.id,pId:parentId,name:inputName});
						}else{
							alert("添加失败")
						}
					})
					return false;
				}
			});
			
		} 
	};
	
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	
	/******************************添加按钮button -- end**********************************************/
	//同步修改
	/* $(".action-upload").on("click",function(){
		//找到选中的节点
		var treenode = $.fn.zTree.getZTreeObj("treeDemo").getSelectedNodes();
		//console.log(treenode);
		//找到选择节点的名字修改张三
		treenode[0].name = "zahgnsan";
		$.fn.zTree.getZTreeObj("treeDemo").refresh();
	}); */
	
	/******************************删除button -- end**********************************************/
	function beforeRemove(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
		return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
	}
	
	function onRemove(e, treeId, treeNode) {
		var fid = treeNode.id;
		var promise = $.get("http://localhost:8080/delete/"+fid);
		promise.done(function(data){
			if(data.status==200){
				alert("删除成功!!!");
			}
		});
	}
	/******************************删除button -- end**********************************************/
	
	
	/******************************编辑button -- end**********************************************/
	function beforeRename(treeId, treeNode, newName, isCancel) {
		if (newName.length == 0) {
			setTimeout(function() {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.cancelEditName();
				alert("节点名称不能为空.");
			}, 0);
			return false;
		}
		return true;
	}
	
	function onRename(e, treeId, treeNode, isCancel) {
		var fid = treeNode.id;
		 var promise = $.get("http://localhost:8080/update",{id:fid,name:treeNode.name});
		promise.done(function(data){
			if(data.status==200){
				alert("修改成功!!!");
			}
		});
	}

	/******************************编辑 -- end**********************************************/
	
	/***************复选框操作*****************/
	
	var checkNodes = [];
	function onCheck(e, treeId, treeNode) {
		count();
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		//获取所有被checked的元素
		nodes = zTree.getChangeCheckedNodes();
		for (var i=0, l=nodes.length; i<l; i++) {
			console.log(nodes[i]);
			nodes[i].checkedOld = nodes[i].checked;
			checkNodes.push(nodes[i].id);
		}
		
		console.log("选中的ids是",checkNodes);
	}
	
	function count() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		checkCount = zTree.getCheckedNodes(true).length,
		nocheckCount = zTree.getCheckedNodes(false).length,
		changeCount = zTree.getChangeCheckedNodes().length;
		console.log(checkCount,nocheckCount,changeCount)
	}
	
	$.get("http://localhost:8080/getNodes",function(znodes){
		$.fn.zTree.init($("#treeDemo"), setting, znodes.data);
	});
}



/*加载默认图片*/
function loadErrImage(){
	$("img").on("error", function () {
	  $(this).attr("src", "img/noimage.gif");
	});
};





$(function(){
	//初始化文件上传组件
	uploadFile();
	//加载tree目录
	loadTreeDatas();
	//如果你的图片是损坏的可以使用此方法修复，顶一个默认图片
	loadErrImage();
	//查询所有的文件
	rumoResource.findResourcesAll(1,rumoResource.pageSize,function(pages){
		//初始化分页
		loadPage(pages);
	});
});