<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<html>
<head>
<title>页面访问出错</title>
</head>
<%
	String reqPath = (String) request.getAttribute("REQ_BIZ_PATH");
	String errorMsg = (String) request.getAttribute("SYSTEM_ERROR_MSG");
	String detail_error_msg = (String) request.getAttribute("SYSTEM_EXCEPTION_MSG");
%>
<body>
	<div id="content">
		<div>
			<h3>
				页面提交路径:<%=reqPath%></br> 
				错误系信息：<%=errorMsg%>
			</h3>
		</div>
		<div>
			<button onclick="history.back();">返回</button>
			<button onclick="document.getElementById('detail_error_msg').style.display = '';">显示详细信息</button>
		</div>
		<div id="detail_error_msg" style="display:none">
			页面访问错误,错误信息:<br /><%=detail_error_msg%>
		</div>
	</div>
</body>
</html>