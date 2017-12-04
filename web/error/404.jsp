<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/1
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<script type="text/javascript">
    var path = "${path}";
</script>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Page-Enter" content="blendTrans(Duration=0.2)">
    <meta http-equiv="Page-Exit" content="blendTrans(Duration=0.2)">
    <title>404</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="shortcut icon" href="${path}/img/favicon.png">
    <link href="${path}/css/base.css" rel="stylesheet">
</head>
<body style="background: white">
<!-- login page -->
<div id="error404" class="other_pages">
    <div class="row-fluid container spacer fluid">
        <div class="span12">
            <h2>Not sure if</h2>
            <h1>404 Page&nbsp;&nbsp;
            <img src="${path}/img/error/404.png" alt="资源未找到"/>
            <h3 class="bottom-line">Or I don't get the joke</h3>
            </h1>
        </div>
    </div>
</div>
</body>
</html>
