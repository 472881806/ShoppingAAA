<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>注册</title>
	<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport" />
	<meta content="yes" name="apple-mobile-web-app-capable" />
	<meta content="black" name="apple-mobile-web-app-status-bar-style" />
	<meta content="telephone=no" name="format-detection" />
	<link href="jq/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="jq/js/jquery.min.js"></script>
	<script type="text/javascript" src="jq/js/register.js"></script>
</head>
<body>

	<div class="aui-register-popup">
		<div class="aui-register-box">
			<div class="aui-register-link">
				<a href="index.jsp" class="fl">返回首页</a>
				<a href="login.jsp" class="fr">已有账号？去登录</a>
			</div>
			<div class="aui-register-logo">
				<img src="images/logo.png" alt="">
			</div>
			<div class="aui-register-form" id="verifyCheck">
				<form action="adduser">
				     <div class="aui-register-form-item">
						<input type="text" name="account_name" maxlength="20"  placeholder="账户名(不能修改请慎重输入)" class="txt03 f-r3 required" tabindex="1" data-valid="isNonEmpty||between:3-20||isUname" data-error="<i class='icon-tips'></i>您还没有输入账户名||<i class='icon-tips'></i>用户名长度3-20位||<i class='icon-tips'></i>只能输入字母、数字、且以中文或字母开头" id="account_name">
						<label for="name" class="focus valid"></label>
					</div>
					<div class="aui-register-form-item">
						<input type="text" name="account_phone" placeholder="手机号码" class="txt01 f-r3 required" keycodes="tel" tabindex="2" data-valid="isNonEmpty||isPhone" data-error="<i class='icon-tips'></i>请输入手机号||<i class='icon-tips'></i>手机号码格式不正确" maxlength="11" id="account_phone">
						<label for="phone" class="focus valid"><div class="msg" style="display:none"><i class='icon-tips'></i>您还未输入手机号</div></label>
						<span class="aui-get-code btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled style="display:none;"></span>
						<span class="aui-get-code btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz" >获取动态码</span>
					</div>
					<div class="aui-register-form-item">
						<input type="text" placeholder="动态码" maxlength="6" id="verifyNo" class="txt02 f-r3 f-fl required" tabindex="3" data-valid="isNonEmpty||isInt" data-error="<i class='icon-tips'></i>请填写正确的手机动态码||<i class='icon-tips'></i>请填写6位手机动态码">
						<label class="focus valid"></label>
					</div>
					<div class="aui-register-form-item">
						<input type="password" name="account_password" placeholder="设置密码" id="account_password" maxlength="20" class="txt04 f-r3 required" tabindex="4" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2" data-error="<i class='icon-tips'></i>密码太短，最少6位||<i class='icon-tips'></i>密码长度6-20位||<i class='icon-tips'></i>密码太简单，有被盗风险，建议字母+数字的组合">
						<label for="password" class="focus valid"></label>
					</div>
					<div class="aui-register-form-item">
						<input type="password" name="account_password" placeholder="确认密码" maxlength="20" class="txt05 f-r3 required" tabindex="5" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-16||isRepeat:account_password" data-error="<i class='icon-tips'></i>密码太短，最少6位||<i class='icon-tips'></i>密码长度6-16位||<i class='icon-tips'></i>两次密码输入不一致" id="account_password">
						<label class="focus valid"></label>
					</div>
					<div class="aui-register-form-item">
						<div class="protocol">注册即同意<a  href="#">《用户使用协议》</a>&amp;<a href="#">《隐私权条款》</a></div>
						<input type="submit" id="aui-btn-reg" class="aui-btn-reg" placeholder=""  readonly="readonly" value="注册"  >
					</div>
				</form>
			</div>
			<div class="aui-register-bottom">
				<a>©618.com</a>
				<a href="#">联系客服</a>
				<a href="#">帮助中心</a>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	
</body>
</html>
