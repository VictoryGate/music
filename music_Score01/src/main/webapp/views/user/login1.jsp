<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%  
        String path = request.getContextPath();  
        String basePath = request.getScheme() + "://"  
                + request.getServerName() + ":" + request.getServerPort()  
                + path + "/";  
    %>  
<!DOCTYPE html>

<html>

<head>
<base href="<%=basePath%>" /> 
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>登录</title>
<link href="<c:url value='/css/layui.css"'/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/css/login1.css"'/>" rel="stylesheet" type="text/css"/>

</head>

<body class="beg-login-bg">
	<div class="beg-login-box">
		<header>
			<h1>欢迎来到音乐社区</h1>
		</header>
		<div class="beg-login-main">
			<form action="/music_Score01/user/login.do" class="layui-form" method="post">
				<input name="__RequestVerificationToken" type="hidden"
					value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81" />
				<div class="layui-form-item">
					<label class="beg-login-icon"> <i class="layui-icon">&#xe612;</i>
					</label> <input type="text" name="userName" lay-verify="userName"
						autocomplete="off" placeholder="这里输入登录名" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="beg-login-icon"> <i class="layui-icon">&#xe642;</i>
					</label> <input type="password" id="password" name="password" lay-verify="password"
						autocomplete="off" placeholder="这里输入密码" class="layui-input">
				</div>
				<div class="layui-form-item">
					<div class="beg-pull-left beg-login-remember">
						<label>记住帐号？</label> <input type="checkbox" name="rememberMe"
							value="true" lay-skin="switch" checked title="记住帐号">
					</div>
					<div class="beg-pull-right">
						<button class="layui-btn layui-btn-primary" lay-submit
							lay-filter="login">
							<i class="layui-icon">&#xe650;</i> 登录
						</button>
					</div>
					<div class="beg-clear"></div>
				</div>
			</form>
		</div>
		<footer>
			<p>Beginner ©</p>
		</footer>
	</div>
	<script src="<c:url value='js/layui/layui.js'/>" type="text/javascript"></script>
	<script>
		layui.use([ 'layer', 'form' ], function() {
			var layer = layui.layer, $ = layui.jquery, form = layui.form();
			
			form.on('submit(login)', function(data) {
				if(data.field.userName == "" || data.field.password == ""){
					layer.msg('用户名和密码不能为空...', {
						icon: 2,
						time: 1000
					});
					return false;
				}
				//location.href = '../admin/admin.jsp';
				return true;
			});
			
			
			var message ="${erroeMessage}";
			if(message){
				layer.msg(message, {
					icon: 2,
					time: 1000
				});
			}
		});
		
		
	</script>
</body>

</html>