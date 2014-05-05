<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<%@include file="/pages/common/EasyUI/EasyUICommon.jsp"%>
<script type="text/javascript" src="<%=basePath%>pages/common/js/validateRules.js"></script>
<script type="text/javascript">
$(function(){
	var registDialogConfig = {
		title:"注册新用户",
		modal : true,
		closable : true,
		buttons : [{
			text : '确定修改',
			left:50,
			handler : function() {
				$('#uiform').form({
					url : "user!update.action",
					onSubmit : function() {
						return $("#uiform").form("validate");
					},
					success : function(data) {
						if ("success" == data) {
							$('#registWin').dialog('close');
							showLoginWin();
							$.messager.show({
								title : '注册信息',
								msg : '注册成功,请登录',
								timeout : 5000,
								showType : null
							});
						}else{
							$.messager.show({
								title : '注册信息',
								msg : '注册失败',
								timeout : 5000,
								showType : null
							});
						}
					}
				});
				$('#uiform').submit();
			}
	   }, {
			text : '重置',
			handler : function() {
				$("#uiform").form("clear");
			}
		}]
	};
	$('#birthday').datebox({
	    required:true,
	    showSeconds:true,
	    validType:"date"
	}); 
	// 加载验证信息
	$('#uiform input').each(function() {
		if ($(this).attr('required') || $(this).attr('validType'))
			$(this).validatebox();
	});
	var registWin = $("#registWin").dialog(registDialogConfig);
});	
</script>
</head>

<body>
	<form id="uiform" method="post">
			<table>
				<tr>
					<td>登录名：</td>
					<td>${sessionScope._LOGIN_USER_.user_code}
					</td>
					<td>真实姓名：</td>
					<td>${sessionScope._LOGIN_USER_.user_name}</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>${sessionScope._LOGIN_USER_.sex}</td>

				</tr>
				<tr>
					<td>出生日期</td>
					<td>${sessionScope._LOGIN_USER_.birthday}</td>
					<td>Email：</td>
					<td>${sessionScope._LOGIN_USER_.email}</td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td>
					${sessionScope._LOGIN_USER_.email}
					</td>
					<td>身份证号：</td>
					<td>${sessionScope._LOGIN_USER_.idcard}</td>
				</tr>
				<tr>
					<td>手机：</td>
					<td>${sessionScope._LOGIN_USER_.mobile}</td>
					<td>电话：</td>
					<td>${sessionScope._LOGIN_USER_.tel}</td>
				</tr>
			</table>
		</form>
</body>
</html>
