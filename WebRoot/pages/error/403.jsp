<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>403 ~ 无权限</title>
</head>

<body>
<div>
	<div><h1>您没有访问该资源的权限！</h1></div>
	<div>
	<a href="#" onclick="history.back()">返回</a>&nbsp;&nbsp;
	<a href="<c:url value="/j_spring_security_logout"/>">退出</a>&nbsp;&nbsp;
	<a href="<c:url value="/"/>">首页</a>&nbsp;&nbsp;
	</div>
</div>
</body>

</html>