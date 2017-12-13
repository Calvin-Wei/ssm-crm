<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XXX管理系统后台</title>

<link rel="stylesheet" type="text/css" href="css/login.css">

<script src="js/easyui/jquery.min.js" type="text/javascript"></script>
</head>
<div
	style="width: 100%; height: 90%; position: absolute; top: 50%; left: 50%; margin-top: -320px; margin-left: -50%;">
	<div class="header">欢迎使用</div>
	<div class="center">
		<div class="login_right">
			<div style="width: 100%; height: auto; margin-top: 150px;">
				<form action="login" method="post" name="loginForm" id="loginForm"
					class="loginForm">
					<div class="login_info">
						<label>用户名：</label> <input type="text" name="loginname"
							id="loginname" class="login_input" value="${loginname }" />
						&nbsp;<span id="nameerr" class="errInfo"></span>
					</div>
					<div class="login_info">
						<label>密 码：</label> <input type="password" name="password"
							id="password" class="login_input" value="${password }" /> &nbsp;<span
							id="pwderr" class="errInfo"></span>
					</div>
					<div class="login_info">
						<label>验证码：</label> <input type="text" name="code" id="code"
							class="login_input" /> &nbsp;<span id="codeerr" class="errInfo"></span>
					</div>
					<div class="login_info">
						<label> </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
							id="codeImg" alt="点击更换" title="点击更换" src="" />
					</div>
					<p>
					<div class="login_info">
						<input type="button" name="loginBtn" id="loginBtn" value="登录"
							class="btn" onclick="login()" /> <label> </label> <input
							type="reset" name="cancelBtn" id="cancelBtn" value="取消"
							class="btn" />
					</div>
					<div class="login_info">
						<input type="checkbox" id="autologin" name="autologin"
							class="autologin" value=""
							style="margin: 0px; vertical-align: middle; padding: 0px; width: 16px; height: 16px; font-size: 20px;" />&nbsp;一周内自动登录
						<input type="hidden" id="autologinch" name="autologinch"
							class="autologinch" value="" />
					</div>
				</form>
			</div>
		</div>
		<div class="login_left">
			<div style="width: 100%; height: auto; margin-top: 150px;">
				<div class="logo"></div>
				<div class="left_txt"></div>
			</div>
		</div>
	</div>
	<div class="bottom">Copyright &copy; 2017 xxx</div>
</div>
<script type="text/javascript">
	var errInfo = "${errInfo}";
	$(document).ready(function() {
		changeCode();
		$("#codeImg").bind("click", changeCode);
		if (errInfo != "") {
			if (errInfo.indexOf("验证码") > -1) {
				$("#codeerr").show();
				$("#codeerr").html(errInfo);
				$("#code").focus();
			} else {
				$("#nameerr").show();
				$("#nameerr").html(errInfo);
			}
		}
		$("#loginname").focus();
	});

	function genTimestamp() {
		var time = new Date();
		return time.getTime();
	}

	function changeCode() {
		$("#codeImg").attr("src", "code?t=" + genTimestamp());
	}

	function resetErr() {
		$("#nameerr").hide();
		$("#nameerr").html("");
		$("#pwderr").hide();
		$("#pwderr").html("");
		$("#codeerr").hide();
		$("#codeerr").html("");
	}

	function check() {
		resetErr();
		if ($("#loginname").val() == "") {
			$("#nameerr").show();
			$("#nameerr").html("用户名不得为空！");
			$("#loginname").focus();
			return false;
		}
		if ($("#password").val() == "") {
			$("#pwderr").show();
			$("#pwderr").html("密码不得为空！");
			$("#password").focus();
			return false;
		}
		if ($("#code").val() == "") {
			$("#codeerr").show();
			$("#codeerr").html("验证码不得为空！");
			$("#code").focus();
			return false;
		}
		if ($(".autologin").is(":checked")) {
			$(".autologinch").val("Y");
		}
		return true;
	}

	function login() {
		check();
		document.loginForm.submit();
	}
</script>
</body>
</html>