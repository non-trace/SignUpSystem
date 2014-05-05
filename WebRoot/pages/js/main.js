function addTab(title, href, icon) {
	var tt = $('#tabs');
	if (tt.tabs('exists', title)) {
		tt.tabs('select', title);
		refreshTab({
			tabTitle : title,
			url : href
		});
	} else {
		var content = null;
		if (href) {
			content = '<iframe scrolling="no" frameborder="0"  src="' + href + '" style="width:100%;height:100%;"></iframe>';
		}
		tt.tabs('add', {
			title : title,
			closable : true,
			content : content,
			iconCls : icon || ''
		});
		content = null;
	}
}


function showRegistWin(){
	var registDialogConfig = {
		title:"注册新用户",
		modal : true,
		closable : true,
		onClose:function (){
			if(loginflag!='true'){
				showLoginWin();
			};
		},
		buttons : [{
			text : '注册',
			left:50,
			handler : function() {
				$('#uiform').form({
					url : "user!regist.action",
					onSubmit : function() {
						return $("#uiform").form("validate")
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
}



function showLoginWin(){
	var loginDialogConfig = {
			title:"登录",
			modal : true,
			closable : false,
			buttons : [ {
				text : '注册',
				handler : function() {
					$('#loginWin').dialog('close');
					showRegistWin();
				}
			}, {
				text : '登录',
				handler : function() {
					$('#form1').form({
						url : "user!login.action",
						onSubmit : function() {
							return $("#form1").form("validate")
						},
						success : function(data) {
							if ("success"==data) {
								$('#loginWin').dialog('close');
								location.reload();
								$.messager.show({
									title : '登录信息',
									msg : '登录成功',
									timeout : 5000,
									showType : null
								});
							}else{
								$.messager.show({
									title : '登录信息',
									msg : data,
									timeout : 5000,
									showType : null
								});
							}
						}
					});
					$('#form1').submit();
				}
		   }]
		}
		var loginWin = $("#loginWin").dialog(loginDialogConfig);
}


$(function() {
	showLoginWin();
	var treeConfig = {
		url : 'pages/json/tree_data.json',
		method : 'POST',
		animate : 'true',
		onClick : function(node) {
			if ($('#tree').tree('isLeaf', node.target)) {
				if (node.attributes.url) {
					addTab(node.text, basePath + node.attributes.url,'icon-help');
				}
			}
		}
	};

	var tabsConfig = {
		border : false,
		tools : [{
			text:"退出登录",
			iconCls : 'icon-undo',
			handler : function() {
				$.ajax({url:'user!logout.action',success:function(){
					$('#loginWin').dialog();
				}});
			}
		} ]
	};

	$("#tree").tree(treeConfig);
	$("#tabs").tabs(tabsConfig);
	addTab("百度", "pages/json/tree_data.json");
	$('#mb').menubutton({
		iconCls : 'icon-edit',
		menu : '#mm'
	});
	
	if(loginflag=='true'){
		$('#loginWin').dialog('close');
	};
});