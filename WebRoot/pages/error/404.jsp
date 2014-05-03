<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<base href="<%=basePath%>">
<TITLE>访问错误--页面跳转中...</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<style type="text/css">
#container {
	MARGIN-LEFT: auto;
	WIDTH: 100%;
	MARGIN-RIGHT: auto;
	BACKGROUND-COLOR: #ffffff;
	TEXT-ALIGN: center
}
</style>
</HEAD>
<BODY>
	<DIV id=container>
		<IMG height=312 src="<%=basePath%>pages/images/404.gif" width=512>
	</DIV>
</BODY>
</HTML>

