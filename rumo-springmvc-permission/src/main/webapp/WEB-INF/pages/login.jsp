<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>网站登录管理后台</title>
<style>
*{padding:0px; margin:0px; list-style:none;}
body{width:100%;margin:0px;padding:0px;background:url(images/bg03.jpg);width:100%;height:100%}
.top{width:960px;height:336px;margin:200px auto; background:url(images/bg01s.jpg) no-repeat; position:relative}
.bottom{width:960px;height:305px;margin:0 auto; background:url(images/bg02.jpg) no-repeat; position:relative}
#telephone,#p_t,#password,#code{ position:absolute;top:206px;left:187px;width:193px;height:34px;border:0px;font-size:14px;line-height:30px;color:#666}
#p_t,#password{left:402px; z-index:2}
#code{left:618px; z-index:2;width:113px}
#vcodesrc{ position:absolute;top:165px;left:616px; font-family:Arial}
#password{z-index:1;color:#333}
#login_bt{position:absolute;top:207px;left:751px;width:102px;height:33px; background:transparent; z-index:3;border:0px; cursor:pointer}
.forget{color:#94adc3;position:absolute;top:247px;left:805px;font-size:12px; text-decoration:none}
.forget1{color:#ff6600;position:absolute;top:247px;left:745px;font-size:12px; text-decoration:none}
.item_list{position:absolute;top:70px;left:505px;width:300px;padding-top:20px;}
ul,li{padding:0;margin:0; font-size:12px;list-style:none; border:0;font-weight:normal;}
.item_list ul{width:100%}
.item_list li{width:100%;line-height:24px;color:#fff;}
</style>
</head>
<body>
<div class="top">
<form name="userLoginActionForm" id="userLoginActionForm" method="POST" action="" target="_parent" >
	<div id="errorbox"></div>
	<input type="text" autofocus="true" id="telephone" value="15073424333" name="telephone" placeholder="手机号码" maxlength="11" />
    <input type="password" id="password" name="userpwd" maxlength="20" value="123456" placeholder="密码" />
    <input type="text" id="code" name="code" placeholder="验证码" maxlength="4"  onfocus="$(this).next().find('img').show()" >
    <a href="javaScript:getVcode2()" title="点击，换一张！"><img src="code" id="vcodesrc" name="vcodesrc" border="0" width="116" height="38" onclick="this.src='code?'+new Date().getTime()" style="float:left;display:none" alt="点击，换一张！"  /></a>
    <input type="button" value="" id="login_bt" name="login_bt" onclick="logincheck()"/>
    <a href="" class="forget">忘记密码？</a>
</form>
</div>
<script type="text/javascript" src="${basePath}/lib/jquery/1.12.4/jquery.min.js"></script>
<script>

	function logincheck(){
		var telephone = $("#telephone").val();
		var password = $("#password").val();
		var code = $("#code").val();
		var promise = $.post("logined",{telephone:telephone,password:password,code:code});
		promise.done(function(response){
			if(response.status==200){
				window.location.href = "admin/index";
			}else{
					console.log(response);
				if(response.status==402){
					$("#errorbox").stop(true).show().html(response.data.defaultMessage).fadeOut(3000);
					$("#"+response.data.field).focus();
				}else{
					$("#errorbox").stop(true).show().html(response.msg).fadeOut(3000);
					$("#"+response.field).focus();
				}
			}
		});
	}
</script>
</body>
</html>