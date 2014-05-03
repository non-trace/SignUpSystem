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
<title>Full Layout - jQuery EasyUI Demo</title>
<%@include file="/pages/common/EasyUI/EasyUICommon.jsp"%>
<script type="text/javascript">
			var loginflag = '<%=session.getAttribute("_LOGIN_USER_") != null%>';
</script>
<script type="text/javascript"
	src="<%=basePath%>pages/js/main.js"></script>
<script type="text/javascript"
	src="<%=basePath%>pages/common/js/validateRules.js"></script>
</head>
<body class="easyui-layout">
	<!-- West -->
	<div data-options="region:'west',split:true,title:'West'"
		style="width:200px;">
		<!-- TreeMenu -->
		<div title="TreeMenu" data-options="iconCls:'icon-tip',selected:true"
			style="overflow:auto;padding:10px;">
			<ul class="easyui-tree" id='tree'></ul>
		</div>
	</div>
	<!-- Center -->
	<div data-options="region:'center',title:'Center'">
		<div class="easyui-tabs" fit='true' id='tabs'></div>
	</div>

	<!-- 登陆dialog -->
	<div id="loginWin" title="登录" style="width:300px;height:160px;">
		<form action="" id="form1">
			<table>
				<tr height="30">
					<th align="right" width="30%">登录名</th>
					<td><input name="user.user_code" size="25"
						class="easyui-validatebox" required='true' missingMessage='登陆名称必填' />
					</td>
				</tr>
				<tr height="30">
					<th align="right" width="30%">密码</th>
					<td><input type="password" name="user.password" size="25"
						class="easyui-validatebox" required='true' missingMessage='密码必填' />
					</td>
				</tr>
			</table>
		</form>
	</div>




	<div id="registWin" style= "width: 550">
		<form id="uiform" method="post">
			<table>
				<tr>
					<td>登录名：</td>
					<td><input required="true" id="txtUsername" type="text"
						name="user.user_code" validType="user_code"/>
					</td>
					<td>真实姓名：</td>
					<td><input id="txtTruename" validType="CHS" required="true"
						type="text" name="user.user_name" /></td>
				</tr>


				<tr>
					<td>登录密码：</td>
					<td><input type="password" id="txtpasswd" required="true"
						validType="password" name="user.password" /></td>
					<td>确认密码：</td>
					<td><input type="password" id="txtpasswd2" required="true"
						validType="equalTo['#txtpasswd']" /></td>
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
					<td><input id="birthday" name="user.birthday"></td>
					<td>Email：</td>
					<td><input id="txtEmail" name="user.email" validType="email"
						type="text" invalidMessage="请输入正确的邮箱格式" /></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input validType="number" id="txtZIP0" name="user.age"
						type="text" />
					</td>
					<td>身份证号：</td>
					<td><input validType="idcard" id="txtIdcard" name="user.idcard"
						type="text" /></td>
				</tr>
				<tr>
					<td>手机：</td>
					<td><input validType="mobile" id="txtMobile" name="user.mobile"
						type="text" /></td>
					<td>电话：</td>
					<td><input id="txtTel" validType="phone" name="user.tel"
						type="text" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>