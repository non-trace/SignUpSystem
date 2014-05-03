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
	<table id="dg"></table>
	<div id="registWin" style= "width: 550">
		<form id="uiform" method="post">
				<table>
					<tr>
						<td>登录名：</td>
						<td><input required="true" id="txtUsername" type="text"
							name="user.user_code" value="${sessionScope._LOGIN_USER_.user_code}" readonly="readonly"/>
						</td>
						<td>真实姓名：</td>
						<td><input id="txtTruename" validType="CHS" required="true"
							type="text" name="user.user_name" value="${sessionScope._LOGIN_USER_.user_name}"/></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><input id="Checkbox1" type="radio" name="user.sex"
							checked="checked" value="man" /><label>男</label></td>
						<td><input id="Checkbox2" type="radio" name="user.sex"
							value="female" /><label>女</label></td>
	
					</tr>
					<tr>
						<td>出生日期</td>
						<td><input id="birthday" name="user.birthday" value="${sessionScope._LOGIN_USER_.birthday}"></td>
						<td>Email：</td>
						<td><input id="txtEmail" name="user.email" validType="email"
							type="text" invalidMessage="请输入正确的邮箱格式" value="${sessionScope._LOGIN_USER_.email}"/></td>
					</tr>
					<tr>
						<td>年龄：</td>
						<td><input validType="number" id="txtZIP0" name="user.age"
							type="text" value="${sessionScope._LOGIN_USER_.age}"/>
						</td>
						<td>身份证号：</td>
						<td><input validType="idcard" id="txtIdcard" name="user.idcard"
							type="text" value="${sessionScope._LOGIN_USER_.idcard}"/></td>
					</tr>
					<tr>
						<td>手机：</td>
						<td><input validType="mobile" id="txtMobile" name="user.mobile"
							type="text" value="${sessionScope._LOGIN_USER_.mobile}"/></td>
						<td>电话：</td>
						<td><input id="txtTel" validType="phone" name="user.tel"
							type="text" value="${sessionScope._LOGIN_USER_.tel}"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>
