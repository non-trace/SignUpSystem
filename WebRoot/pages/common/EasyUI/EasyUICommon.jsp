<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String __path__ = request.getContextPath();
	String __basePath__ = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ __path__ + "/";
%>
<link rel="stylesheet" type="text/css" href="<%=__basePath__%>plugins/EasyUI/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=__basePath__%>plugins/EasyUI/themes/icon.css">
<script type="text/javascript" src="<%=__basePath__%>plugins/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=__basePath__%>plugins/EasyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=__basePath__%>plugins/EasyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var basePath = '<%=__basePath__%>';
</script>