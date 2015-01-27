<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="scripts/public/jquery-migrate-1.2.1.min.js"></script>

<script src="./scripts/login/I_GetUserBox_byUserNo.js" type="text/javascript"></script>
</head>
<body>
<br/>
<div style="font-weight:bold;font-size: 15px;">${sessionScope.userbean!=null?sessionScope.userbean.userName:sessionScope.entbean.entName}&nbsp;，&nbsp;欢迎登录</div>
<input id="userNo" type="hidden" name="userNo" value="${sessionScope.userbean.userNo}"/>
<a style="color: #5A9304;font-size:15px;" href="alterpassword_test.jsp"><b>修改密码</b></a>
<form action="UserAction_Logout_">
	<button  type="submit">安全退出</button>
</form>
<div id="each"></div>
</body>
</html>