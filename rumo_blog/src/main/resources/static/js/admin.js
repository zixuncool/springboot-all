//防止session过期造成退出的问题5分钟重新发一次session
function loadSession(){
	setInterval(function(){
		request(basePath+"/loading");
	},300000);
};

	
function loadingtip(target,mark){
	$.loading({target:$(target).show(),mark:mark||7}); 
};

function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
} 


/*错误损坏图片加载*/
function imgError(obj){
	obj.src = basePath+"/img/noimage.gif";
};

//把内容会进行过滤标签
function filterTag(str) {
    str = str.replace(/&/ig, "&amp;");
    str = str.replace(/</ig, "&lt;");
    str = str.replace(/>/ig, "&gt;");
    str = str.replace(" ", "&nbsp;");
    return str;
};

function filterScript(str) {
	return str.replace(/<script.*?>.*?<\/script>/ig, '');  
};


//删除提示，信息的提示
var mkCommon = {
	tip:function(msg,mark){
		$(".error_tips").remove();
		var cd = tz_animateIn(9);
		if(!mark)mark="error";
		$(".tmui-common-overlay").remove();
		$("body").append("<div class='"+cd+" error_tips cbg' ><i class='fa fa-"+mark+" tp2'></i><span id='e_m'>"+msg+"</span></div>");
		var args = arguments;
		if(args.length>2 && args[2]){
			$(".error_tips").append("<a href='javascript:void(0);' class='ke_esure'>确定</a><a href='javascript:void(0);' class='ke_ecan'>取消</a>");
			$("body").append("<div class='tmui-common-overlay'></div>");
			$(".error_tips").find(".ke_esure").on("click",function(){
				deleteError();
				if(args[2])args[2](true);
			});
			
			$(".error_tips").next().on("click",function(){
				deleteError();
				if(args[2])args[2](false);
			});
			
			$(".error_tips").find(".ke_ecan").on("click",function(){
				deleteError();
				if(args[2])args[2](false);
			});
		}
		
		$(".error_tips").off().on("click",function(){
			$(this).removeClass(cd).addClass(tz_animateOut(3)).fadeOut("slow",function(){
				$(".tmui-common-overlay").remove();
				$(this).remove();
			});
		});
		
		if(mark=="success"){//success
			$(".error_tips").css("background","#449D44");
		}else if(mark=="error"){//error
			$(".error_tips").css("background","#C9302C");
		}else if(mark=="tip"){//warn
			$(".error_tips").css("background","#EC971F");
		}
		
		if(this.timer)clearTimeout(this.timer);
		this.timer = setTimeout(function(){
			deleteError();
		},4000);
		
		
		function deleteError(){
			$(".error_tips").removeClass(cd).addClass(tz_animateOut(3)).fadeOut("slow",function(){
				$(".tmui-common-overlay").remove();
				$(this).remove();
			});
		}
	}
};


/*ajax的封装*/
var request = function(url,callback,params){
	KAjax.request({url:url,callback:function(data){
		if(callback)callback(data);
	}},params);
};

//javascript本身是没提供日期类
//var date =new Date();
//var str = date.format("yyyy-MM-dd HH:mm:ss")
//设定时间格式化函数，使用new Date().format("yyyyMMddhhmmss");  
//es
Date.prototype.format = function (format) {  
    var args = {  
        "M+": this.getMonth() + 1,  
        "d+": this.getDate(),  
        "h+": this.getHours(),  
        "m+": this.getMinutes(),  
        "s+": this.getSeconds(),  
    };  
    if (/(y+)/.test(format))  
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    for (var i in args) {  
        var n = args[i];  
        if (new RegExp("(" + i + ")").test(format))  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));  
    }  
    return format;  
};  


//本地存储cookie storage(sessionStorage,localstorage)
/*会话处理*/

function setSession(key,value,mark){
	mark=undefined
	//falsy---undefined/false/0/null/""在逻辑判断都是false
	var stroage = mark?sessionStorage:localStorage;
	if(stroage)stroage.setItem("keant_"+key, value);
};


function getSession(key,mark){
	var stroage = mark?sessionStorage:localStorage;
	if(stroage){
		return stroage.getItem("keant_"+key);
	}else{
		return "";
	}
};

function removeSession(key,mark){
	var stroage = mark?sessionStorage:localStorage;
	if(stroage){
		return stroage.removeItem("keant_"+key);
	}else{
		return "";
	}
};


/*给要预览的图片或者元素上加 class="keui-imgbox"和data-src='图片地址即可'*/
function mkImageShow(){
	var ow = window.innerWidth;
	var oh = window.innerHeight;
	
	$(window).resize(function(){
		var $imgbox = $(".keui-imgcontainer");
		var imgsrc = $imgbox.find(".keui-imgcnt").find("img").attr("src");
		if(isEmpty(imgsrc))return;
		var xbit = this.innerWidth / ow;
		var ybit = this.innerHeight / oh;
		var width = $imgbox.data("width")*1;
		var height = $imgbox.data("height")*1;
		var wb = width *  xbit;
		var yb = height * ybit;
		if(wb>=1440)wb = 1440;
		if(yb>=900)yb = 900;
		
		loadingImage(imgsrc,function(ok){
			if(ok){
				var imgjson  = resizeImg(this,wb,yb);
				var cwidth = imgjson.width;
				var cheight = imgjson.height;
				$imgbox.find(".keui-imgcnt").stop(true,true).animate({
					width:cwidth,
					height:cheight,
					marginLeft:"-"+(cwidth/2)+"px",
					marginTop:"-"+(cheight/2)+"px"
				});
				$imgbox.find(".keui-imgcnt").find("img").attr("width",cwidth).attr("height",cheight);
			}else{
				mkCommon.error("图片已损坏，加载失败","error");
			}
		});
		
	});
	
	$("body").on("click",".keui-imgbox",function(){
		var imgsrc = $(this).attr("src");
		if(isEmpty(imgsrc))imgsrc = $(this).data("src").replace(",","");
		loadingImage(imgsrc,function(ok){
			if(ok){
				var bw = 1440;
				var bh = 900;
				if(bw>=ow)bw=ow;
				if(bh>=oh)bh=oh-100;
				var imgjson  = resizeImg(this,bw,bh);
				var width = imgjson.width;
				var height = imgjson.height;
				var html = "<div class='keui-imgcontainer' data-width='"+width+"' data-height='"+height+"'>"+
				"  		<div class='keui-imgcnt'  style='width:"+width+"px;height:"+height+"px;margin-left:-"+(width/2)+"px;margin-top:-"+(height/2)+"px;'>"+
				"  			<img src='"+imgsrc+"?d="+new Date().getTime()+"' width='"+width+"' height='"+height+"'>"+	
				"  		</div><a href='javascript:void(0);' class='keui-imgclose'><i class='fa fa-remove'></i></a>"+
				"  	</div>";
				$("body").append(html).append("<div class='keui-imgoverlay'></div>");
				
				$(".keui-imgcontainer").off("click").on("click",function(){
					$(this).next().remove();
					$(this).remove();
				});
			}else{
				mkCommon.error("图片已损坏，加载失败","error");
			}
		});
	});
};



function showShareMessage(options){
	$(".share_wrap").remove();
	$("body").append("<div class='share_wrap'>"+
	"		<div class='sharebox_c'>"+
	"			<h1 class='fz24 fw' style='color:"+options.color+"'>"+(options.message||"")+"</h1>"+	
	"			<h1>非常感谢你的一直对ITBooking的支持与厚爱，为了帮助更多的热爱或即将踏上IT编程道路的年轻人获取学习权利和享受知识。</h1>"+
	"			<h3>你的分享和帮助平台的推广是一件多么可爱又有意义的事情。</h3>"+
	"			<div class='mt20'>"+
	"				<span class='ftp2' style='color:#01cd9a;'>分享：</span>"+
	"				<a class='shareicoc pr5 cof tmui-tips' data-type='1' tip='分享到QQ空间' target='_blank' href='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url="+basePath+"&amp;title=我正在学习：互联网最新最前沿的IT技术平台学习编程【更多互联网最新IT技术信息访问--www.itbooking.net】&amp;summary=互联网最懂你的IT学习交流平台，课程主要包括：NodeJs,大数据,Java,Java框架SSM,SSH,人工智能,AI,区块链技术,SpringBoot等。欢迎更多的热爱编程和初学编程的加入学习平台通过学习成就自己。&amp;pics=http://www.itbooking.net/resources/images/logob.png'><i class='fz48 iconfont icon-qzonec' style='color:#ff5722'></i></a>"+
	"				<a class='shareicoc pr5 cof tmui-tips' data-type='2' tip='分享到QQ好友' target='_blank' href='http://connect.qq.com/widget/shareqq/index.html?url="+basePath+"&amp;title=我正在学习：互联网最新最前沿的IT技术平台学习编程【更多互联网最新IT技术信息访问--www.itbooking.net】&amp;summary=互联网最懂你的IT学习交流平台，课程主要包括：NodeJs,大数据,Java,Java框架SSM,SSH,人工智能,AI,区块链技术,SpringBoot等。欢迎更多的热爱编程和初学编程的加入学习平台通过学习成就自己。&amp;desc=互联网最懂你的IT学习交流平台，课程主要包括：NodeJs,大数据,Java,Java框架SSM,SSH,人工智能,AI,区块链技术,SpringBoot等。欢迎更多的热爱编程和初学编程的加入学习平台通过学习成就自己。&amp;pics=http://www.itbooking.net/resources/images/logob.png'><i class='fz48 iconfont icon-qq' style='color:#01cd9a'></i></a>"+
	"				<a class='shareicoc pr5 cof tmui-tips' data-type='3' tip='分享到微博' target='_blank' href='http://service.weibo.com/share/share.php?url="+basePath+"&amp;title=我正在学习：互联网最新最前沿的IT技术平台学习编程【更多互联网最新IT技术信息访问--www.itbooking.net】&amp;searchPic=false&amp;pic=http://www.itbooking.net/resources/images/logob.png&amp;summary=互联网最懂你的IT学习交流平台，课程主要包括：NodeJs,大数据,Java,Java框架SSM,SSH,人工智能,AI,区块链技术,SpringBoot等。欢迎更多的热爱编程和初学编程的加入学习平台通过学习成就自己。&amp;desc=互联网最懂你的IT学习交流平台，课程主要包括：NodeJs,大数据,Java,Java框架SSM,SSH,人工智能,AI,区块链技术,SpringBoot等。欢迎更多的热爱编程和初学编程的加入学习平台通过学习成就自己。'><i class='fz48 iconfont icon-weibo' style='color:#ff9800'></i></a>"+
	"			</div>"+
	"			<div class='mt30'><a href='http://shang.qq.com/wpa/qunwpa?idkey=1b16cd81ab62b8e95e53d822eb2887e8e1478be7651a9bb28f3cc9d89ad0b2c3' target='_blank'  style='padding:5px 68px;' class='btn  btn-large btn-success'><span>加群申请</span><i class='iconfont icon-qq fz30 tp2' style='margin-left: 10px'></i></a>&nbsp;<a href='javascript:void(0);' onclick='mkPay.alipay(this)' style='padding:5px 68px;' class='btn mkyearorderbtn btn-large btn-danger'><span>开通会员</span><i class='iconfont icon-vip fz30 tp2' style='margin-left: 10px'></i></a></div>"+
	"		</div>	"+
	"	</div>");
	loadYearPayOk();
	
	$(".shareicoc").off("click").on("click",function(){
		var type = $(this).data("type");
		saveShare(type, function(bool) {
			$(".share_wrap").remove();
		});
	});
}

function transfterURL(url){
	var browser={  
			versions:function(){   
				var u = navigator.userAgent, app = navigator.appVersion;   
				return {//移动终端浏览器版本信息   
					trident: u.indexOf('Trident') > -1, //IE内核  
					presto: u.indexOf('Presto') > -1, //opera内核  
					webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核  
					gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核  
					mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端  
					ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端  
					android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1  || app.indexOf("Android")>-1, //android终端或者uc浏览器  
					iPhone: u.indexOf('iPhone') > -1  || app.indexOf("iPhone")>-1, //是否为iPhone或者QQHD浏览器  
					iPad: u.indexOf('iPad') > -1  || app.indexOf("iPad")>-1, //是否iPad    
					webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部  
				};  
			}(),  
			language:(navigator.browserLanguage || navigator.language).toLowerCase()  
		};
	
		var p = navigator.platform;   
		var system ={}; 
	    system.win = p.indexOf("Win") == 0; 
	    system.mac = p.indexOf("Mac") == 0; 
	    system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);    
	    /*if(system.win||system.mac||system.xll){
	//如果是电脑跳转到百度  
	        window.location.href="http://www.baidu.com/"; 
	    }else{  
	//如果是手机,跳转到hao123首页
	        window.location.href="http://www.hao123.com/"; 
	    }*/
		
		//如果你是通过手机访问pc地址，那么跳转到你指定的地址
		if(browser.versions.mobile || browser.versions.ios || browser.versions.android ||   
				browser.versions.iPhone || browser.versions.iPad || !(system.win||system.mac||system.xll)){  
			window.location.href = url;
		}
};



//盐
var salt = "itbooking.123sk";
function inputPassToFormPass(inputPass) {
	//混淆视听 slat
	var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
	//加密一次
	return md5(str);
}
	
//所有的通用的初始化
function initLoadingJS(){
	$(".sidebar-toggle-line-wrap").on("click",function(e) {
		if($("#sidebar").hasClass("sidebar-active")) {
			$("#sidebar").removeClass("sidebar-active animated slideInRight slideOutRight").animate({
				right: "-32%"
			}).addClass("animated slideOutRight");
			$("#main,#header").animate({marginRight:0});
		} else {
			$("#sidebar").removeClass("animated slideInRight slideOutRight").animate({
				right: 0
			}).addClass("sidebar-active animated slideInRight");
			$("#main,#header").animate({marginRight:"32%"});
		}
		e.stopPropagation();
	});
	
	$("body").on("dblclick",function(e){
		if($(this).data("isclose"))return;
		if(this.timer)clearTimeout(this.timer);
		this.timer = setTimeout(function(){
			$(".sidebar-toggle-line-wrap").trigger("click");
		}, 60);
		e.stopPropagation();
	});
	
	
	$(window).on("load scroll",function(){
		if($(this).scrollTop() >= 200){
			$(".back-to-top").show();
		}else{
			$(".back-to-top").hide();
		}
	});

	$(".back-to-top").on("click", function() {
		$("html,body").stop(true, true).animate({
			scrollTop: 0
		}, 600);
	});
	
	//浏览器的拦截
	var v = getBroswerVersion().version;
	if(v=="ie_6" || v=="ie_7" || v=="ie_8"){
		$("body").append("<div id='tipnobox' style='background:#1F53A0;padding:20% 0px;text-align:center;font-size:36px;line-height:46px;font-weight:700;color:#fff;position:fixed;width:100%;height:100%;top:0;left:0;z-index:9999'>很是遗憾，作者关闭了IE6,7,8,为推动互联的发展做贡献....请下载ie9+浏览器,推荐使用google和火狐浏览器.</div>");
		shakeCharacter("tipnobox");	
		return;
	};

	//图片预览
	mkImageShow();
	//提示插件
	$(".mkui-tips,.tmui-tips").tmTip();
}


//扩展复制内容到剪切板的增加额外的内容
function setClipboardText(event){ 
    event.preventDefault();//阻止元素发生默认的行为（例如，当点击提交按钮时阻止对表单的提交）。
    var node = document.createElement('div');
    //对documentfragment不熟，不知道怎么获取里面的内容，用了一个比较笨的方式
    node.appendChild(window.getSelection().getRangeAt(0).cloneContents());
    //getRangeAt(0)返回对基于零的数字索引与传递参数匹配的选择对象中的范围的引用。对于连续选择，参数应为零。
    var htmlData = '<div>'+node.innerHTML +'<br>/**著作权归作者所有。<br />' 
                    + '商业转载请联系作者获得授权，非商业转载请注明出处。<br />'
                    + '作者：中华墨风<br />链接：http://www.itbooking.net<br />'
                    + '来源：中华墨风分布式集群，大前端架构学习平台 **/<br />' 
                    + '文章地址：'+window.location.href+'<br />' 
                    + '</div>';
    var textData = window.getSelection().getRangeAt(0)+'\n/**\n著作权归作者所有。\n' 
                    + '商业转载请联系作者获得授权，非商业转载请注明出处。\n'
                    + '作者：中华墨风\n平台链接：http://www.itbooking.net\n'
                    + '来源：中华墨风分布式集群，大前端架构学习平台 **/\n' 
                    + '文章地址：'+window.location.href+'\n' ;
    if(event.clipboardData){  
    	//setData(剪贴板格式, 数据) 给剪贴板赋予指定格式的数据。返回 true 表示操作成功。 
        event.clipboardData.setData("text/html", htmlData);
        event.clipboardData.setData("text/plain",textData);
    } else if(window.clipboardData){ //window.clipboardData的作用是在页面上将需要的东西复制到剪贴板上，提供了对于预定义的剪贴板格式的访问，以便在编辑操作中使用。 
        return window.clipboardData.setData("text", textData);  
    }  
    
};  


$(function(){
	
	//监听剪切板事件
	document.addEventListener('copy',function(e){
	    setClipboardText(e);
	});
	
	initLoadingJS()
});