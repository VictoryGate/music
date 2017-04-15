    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
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
    <script type="text/javascript" src="/js/jQuery/jquery.js"></script>  
    <title>userInfo</title>  
    </head> 
    <script type="text/javascript" src="<c:url value='/js/jQuery/jquery.js'/>"></script>
   
    <body>
    <p id="userInfo">
        用户信息 昵称： ${user.nickName} 用户id：${user.id} 用户电话:${user.telephone } 注册时间：  
        <fmt:formatDate value="${user.registerTime }" pattern="yyyy-MM-dd HH:mm:ss" />  
        角色：[  
        <c:forEach items="${ user.roles}" var="role">  
                            ${role.name }   权限[  
                               <c:forEach items="${ role.authorities}" var="authority">  
                                 ${authority.name }   
                               </c:forEach> ]  
                          </c:forEach>  
        ]
      </p>
    </body>  
    </html>  