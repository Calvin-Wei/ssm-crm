<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>crm管理系统后台</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/easyui/jquery.min.js" type="text/javascript"></script>
</head>
<div style="width:100%;height:90%;position: absolute;top:50%;left:50%;margin-top:-320px;margin-left:-50%;">
    <div class="header">欢迎使用</div>
    <div class="center">
        <div class="login_right">
            <div style="width: 100%;height: auto;margin-top: 150px">
                <form action="login" method="post" name="loginForm" id="loginForm" class="loginForm">
                    <div class="login_info">
                        <label>用户名:</label>
                        <input type="text" name="loginname" id="loginname"
                               value="${loginname}"
                               class="login_input"/>
                        &nbsp;<span id="nameerr" class="errInfo"></span>
                    </div>
                    <div class="login_info">
                        <label>密 码:</label>
                        <input type="password" name="password" id="password"
                               value="${password}"
                               class="login_input">
                    </div>
                    <div class="login_info">
                        <label>验证码：</label>
                        <input type="text" name="code" id="code" class="login_input"/>
                        &nbsp;<span id="codeerr" class="errInfo"></span>
                    </div>
                    <div class="login_info">
                        <label>　　　　</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <img src="" id="codeImg" alt="点击更换" title="点击更换">
                    </div>
                    <p></p>
                    <div class="login_info">
                        <input type="button" name="loginBtn" id="loginBtn" value="登录"
                               class="btn" onclick="login()">
                        <label></label>
                        <input type="reset" name="cancelBtn" id="cancelBtn" value="取消" class="btn">
                    </div>
                    <div class="login_info">
                        <input type="checkbox" id="autologin" name="autologin" class="autologin"
                               value="" style="margin: 0px;vertical-align: middle;padding: 0px;
                                width: 16px;height: 16px;font-size: 20px;"/>
                        &nbsp;一周内自动登录
                        <input type="hidden" id="autologinch" name="autologinch" class="autologinch" value="" >
                    </div>
                </form>
            </div>
        </div>
        <div class="login_left">
            <div style="width: 100%;height: auto;margin-top: 150px;">
                <div class="logo"></div>
                <div class="left_txt"></div>
            </div>
        </div>
    </div>
    <div class="bottom">
        Copyright &copy;2017 wxc
    </div>
</div>
<body>

</body>
</html>
