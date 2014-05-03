$.extend($.fn.validatebox.defaults.rules, {
	user_code:{
		validator:function(value, param){
			var flag = "";
			$.ajax(
					{
						url:"user!checkUserCode.action",
						async:false,
						data:{"user.user_code":value},
						success:function(data){
							flag = data;
						}
					}
				);
			if(flag=="false"){
				return false;
			}else{
				return true;
			}
		},
		message : '该用户名已存在'
	},
	/* 必须和某个字段相等 */
	equalTo : {
		validator : function(value, param) {
			return $(param[0]).val() == value;
		},
		message : '字段不匹配'
	},
	
	/*
	 * 验证如入的是否是汉字
	 */
	CHS : {
		validator : function(value, param) {
			return /^[\u0391-\uFFE5]+$/.test(value);
		},
		message : '请输入汉字'
	},
	/*
	 * 验证邮编格式（5位数字）
	 */
	ZIP : {
		validator : function(value, param) {
			return /^[1-9]\d{5}$/.test(value);
		},
		message : '邮政编码不正确'
	},
	/*
	 * 验证QQ号格式（4到10位数字）
	 */
	QQ : {
		validator : function(value, param) {
			return /^[1-9]\d{4,10}$/.test(value);
		},
		message : 'QQ号码不正确'
	},
	/*
	 * 验证手机号格式
	 */
	mobile : {
		validator : function(value, param) {
			return /^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/.test(value);
		},
		message : '手机号码不正确'
	},
	
	/*
	 * 验证是否为数字
	 * */
	number : {
		validator : function(value, param) {
			return /^\d+$/.test(value);
		},
		message : '请输入数字'
	},
	
	/*
	 * 验证身份证格式
	 **/
	idcard : {
		validator : function(value, param) {
			return idCard(value);
		},
		message : '请输入正确的身份证号码'
	},
		date : {
		validator : function(value, param) {
			// 标准时间格式
			var regStandard = /^\1|2\d{3}-\d{1,2}-\d{1,2} \d{1,2}:\d{1,2}:\d{1,2}$/; // 匹配标准日期格式 2014-1-20 12:10:00
			// 日期快速输入格式
			var regA = /^\1|2\d{3}-\d{1,2}-\d{1,2}-\d{1,2}-\d{1,2}-\d{1,2}$/; // 匹配日期和时\分\秒2014-1-20-12-10-00
			var regC = /^\1|2\d{3}-\d{1,2}-\d{1,2}$/; // 匹配日期 2014-1-20
			if (regStandard.test(value)) {
				return true;
			}else if(regA.test(value)){
				return true;
			}else if(regC.test(value)){
				return true;
			}
			return false;
		},
		message : '日期格式不正确'
	}  
	
	
});
var idCard = function(value) {
	if (value.length == 18 && 18 != value.length){
		return false;
	}
	
	var number = value.toLowerCase();
	
	var d, 
	sum = 0, 
	v = '10x98765432',
	w = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7,9, 10, 5, 8, 4, 2 ],
	a = '11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91';
	
	var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/);
	
	if (re == null || a.indexOf(re[1]) < 0){
		return false;
	}

	if (re[2].length == 9) {
		number = number.substr(0, 6) + '19' + number.substr(6);
		d = [ '19' + re[4], re[5], re[6] ].join('-');
	} else{
		d = [ re[9], re[10], re[11] ].join('-');
	}
	if (!isDateTime.call(d, 'yyyy-MM-dd')){
		return false;
	}
	for ( var i = 0; i < 17; i++){
		sum += number.charAt(i) * w[i];
	}
	return (re[2].length == 9 || number.charAt(17) == v.charAt(sum % 11));
};
var isDateTime = function(format, reObj) {
	format = format || 'yyyy-MM-dd';
	var input = this,o = {},d = new Date();
	var f1 = format.split(/[^a-z]+/gi),f2 = input.split(/\D+/g),f3 = format.split(/[a-z]+/gi), f4 = input.split(/\d+/g);
	var len = f1.length, len1 = f3.length;
	if (len != f2.length || len1 != f4.length){
		return false;
	}
	for ( var i = 0; i < len1; i++)
		if (f3[i] != f4[i]){
			return false;
		}
	for ( var i = 0; i < len; i++){
		o[f1[i]] = f2[i];
	}
	o.yyyy = s(o.yyyy, o.yy, d.getFullYear(), 9999, 4);
	o.MM = s(o.MM, o.M, d.getMonth() + 1, 12);
	o.dd = s(o.dd, o.d, d.getDate(), 31);
	o.hh = s(o.hh, o.h, d.getHours(), 24);
	o.mm = s(o.mm, o.m, d.getMinutes());
	o.ss = s(o.ss, o.s, d.getSeconds());
	o.ms = s(o.ms, o.ms, d.getMilliseconds(), 999, 3);
	if (o.yyyy + o.MM + o.dd + o.hh + o.mm + o.ss + o.ms < 0){
		return false;
	}
	
	if (o.yyyy < 100){
		o.yyyy += (o.yyyy > 30 ? 1900 : 2000);
	}
	d = new Date(o.yyyy, o.MM - 1, o.dd, o.hh, o.mm, o.ss, o.ms);
	var reVal = d.getFullYear() == o.yyyy && d.getMonth() + 1 == o.MM
			&& d.getDate() == o.dd && d.getHours() == o.hh
			&& d.getMinutes() == o.mm && d.getSeconds() == o.ss
			&& d.getMilliseconds() == o.ms;
	return reVal && reObj ? d : reVal;
	
	function s(s1, s2, s3, s4, s5) {
		s4 = s4 || 60, s5 = s5 || 2;
		var reVal = s3;
		if (s1 != undefined && s1 != '' || !isNaN(s1)){
			reVal = s1 * 1;
		}
		if (s2 != undefined && s2 != '' && !isNaN(s2)){
			reVal = s2 * 1;
		}
		return (reVal == s1 && s1.length != s5 || reVal > s4) ? -10000 : reVal;
	}
};