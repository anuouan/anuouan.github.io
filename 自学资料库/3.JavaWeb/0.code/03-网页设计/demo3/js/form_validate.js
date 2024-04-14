function doValidate(){
	console.log("-----doValidate")
	//对输入的数据进行校验，如果输入的数据OK，return true
	
	//1.校验用户名
	var userName = document.getElementById("userNameInput").value;
	var label1 = document.getElementById("userNameTipsLabel");
	
	if(userName== null || userName == ""){
		// 通过innerHTML属性修改 标签对象的里面的值
		label1.innerHTML = "请输入用户名！";
		label1.style.color = "red";
		return false;
	}else if( userName.length<8 || userName.length>20 ){
		label1.innerHTML = "用户名长度必须为8-20个字符！";
		label1.style.color = "red";
		return false;
	}else if( ! new RegExp("^[0-9a-zA-Z]*$").test(userName) ){
		label1.innerHTML = "用户名只允许包含数字和字母";
		label1.style.color = "red";
		return false;
	}else{
		//进入else 表示用户名已经合法
		label1.innerHTML = "用户名输入正确！";
		label1.style.color = "green";
	}
	
	//2.检验密码
	var userPwd = document.getElementById("userPwdInput").value;
	var label2 = document.getElementById("userPwdTipsLabel");
	if(userPwd == null || userPwd == ""){
		label2.innerHTML = "请输入密码！";
		label2.style.color="red";
		return false;
	}else if(userPwd.length<8 ||userPwd.length>16 ){
		label2.innerHTML = "密码长度必须为8-16个字符！";
		label2.style.color = "red";
		return false;
	}else{
		//密码正确
		label2.innerHTML = "密码输入正确！";
		label2.style.color = "green";
	}
	
	//3.确认密码
	var rePwd = document.getElementById("rePwdInput").value;
	var label3 = document.getElementById("rePwdTipsLabel");
	if(rePwd == null || rePwd == ""){
		label3.innerHTML = "请再次输入密码！";
		label3.style.color="red";
		return false;
	}else if(userPwd != rePwd){
		label3.innerHTML = "两次密码输入不一致！";
		label3.style.color="red";
		return false;
	}else{
		label3.innerHTML = "重复密码输入正确！";
		label3.style.color="green";
	}
	
	//4.验证手机
	//5.验证邮箱
	
	return true;
}