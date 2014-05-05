<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectedClass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="/pages/common/EasyUI/EasyUICommon.jsp"%>
	<script type="text/javascript">
	$(function() {
		$('#selectedClass').datagrid({
			url : 'clzz!getSelectedClass.action',
			singleSelect : true,
			fit : true,
			title : "已选课程",
			collapsible : true,
			loadMsg : "数据加载中请稍后……",
			pagination : true,
			rownumbers : true,
			pageSize : 10,// 每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],// 可以设置每页记录条数的列表 
			beforePageText : '第',// 页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
			onLoadError : function() {
				$.messager.alert("提示信息", "数据加载失败");
			},
			onClickCell : function(rowIndex, field, value) {
				$.messager.alert("提示信息", field + "::" + value);
			},
			columns : [ [
			{
				field : 'teacher',
				title : '主讲老师'
			}, {
				field : 'className',
				title : '课程名称'
			},{
				field : 'class_hour',
				title : '课时（天）'
			}] ]
		});
	});
	</script>
  </head>
  
  <body>
  <table id = "selectedClass" ></table>
  </body>
</html>
