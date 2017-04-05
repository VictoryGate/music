<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%  
        String path = request.getContextPath();  
        String basePath = request.getScheme() + "://"  
                + request.getServerName() + ":" + request.getServerPort()  
                + path + "/";  
    %>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <base href="<%=basePath%>" />  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>userInfo</title>
    <link href="<c:url value='/css/login.css'/>" rel="stylesheet" type="text/css"/>
    </head>  
    <body>
    
    <div class="logo_box">
	<h3>爱音乐欢迎你</h3>
	<form action="<c:url value='/user/login.do'/>" id="myForm" name="f" method="post">
		<div class="input_outer">
			<span class="u_user"></span>
			<input name="userName" id ="userName" class="text" onFocus=" if(this.value=='输入ID或用户名登录') this.value='',$('#erroeMessage').text('')" onBlur="if(this.value=='') this.value='输入ID或用户名登录'" value="输入ID或用户名登录" style="color: #FFFFFF !important" type="text">
		</div>
		<div class="input_outer">
			<span class="us_uer"></span>
			<label class="l-login login_password" style="color: rgb(255, 255, 255);display: block;">输入密码</label>
			<input name="password"  id="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" onFocus="$('.login_password').hide(),$('#erroeMessage').text('')" onBlur="if(this.value=='') $('.login_password').show()" value="" type="password">
		</div>
		<div class="mb2"><a class="act-but submit" href="javascript:submit();" style="color: #FFFFFF">登录</a></div>
	</form>
	<div class="logins">
		</div>
		<div class="sas" id="erroeMessage">
		</div>
		<div class="sas">
	</div>
	
</div>
<script type="text/javascript" src="<c:url value='/js/jQuery/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/common/common.js'/>"></script>
<script src="<c:url value='js/jQuery/jquery.md5.js'/>" type="text/javascript"></script>
<script type="text/javascript">
var message ="${erroeMessage}";
if(message){
	$("#erroeMessage").text(message);
}
function submit(){
	var userName = $("#userName").val();
	var password = $("#password").val();
	if(password && userName){
		var password1 = $.md5(password);
		$("#password").val(password1)
		$("#myForm").submit();
	}else{
		$("#erroeMessage").text("用户名密码不能为空");
	}
}
</script>
</body>
</html>