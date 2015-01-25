<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
if(session.getAttribute("admin_uid")!=null)
	response.sendRedirect("LoginAction");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>社区再就业系统</title>

<link rel="stylesheet" href="../css/font/css/font-awesome.min.css">
<!-- Custom styles for this template -->
<link href="./themes/css/htlogin.css" rel="stylesheet" />
<script type="text/javascript" src="../scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="./themes/login/login.js"></script>

<script language="javascript">
	if (top.location != self.location) {
		top.location = self.location;
	}
</script>
</head>
<body class="texture">
	<div id="cl-wrapper" class="login-container">

		<div class="middle-login">
			<div class="block-flat">
				<div class="header">
					<h3 class="text-center">
						<img class="logo-img" src="images/logo.png" alt="logo" />社区再就业管理系统
					</h3>
				</div>
				<div>
					<form style="margin-bottom: 0px !important;" class="form-horizontal" action="LoginAction" method="post">
						<div class="content">
							<h4 class="title">登陆</h4>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" placeholder="用户名" id="username" data-title="用户名"
											name="username" class="form-control">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input type="password" placeholder="密码" id="password" data-title="密码"
											name="password" class="form-control">
									</div>
								</div>
							</div>

						</div>
						<div class="foot">
						   <%--  <a class="btn btn-default findpass"  data-dismiss="modal" href="findpass.jsp"
								>找回密码</a>
							<span class="infospan">${sc}</span>
							<a class="btn btn-default"  data-dismiss="modal" href="dwz/ManagerIndex?type=-3"
								>申请</a> --%>
							<!-- <a class="btn btn-default"  data-dismiss="modal" href="signup.jsp"
								>注册</a> -->
							<button class="btn btn-primary disabled"  disabled="disabled" data-dismiss="modal" 
								type="submit">登陆</button>
						</div>
					</form>
				</div>
			</div>
			<div class="text-center out-links">
				<a href="#">&copy; 2014 Your Company</a>
			</div>
		</div>
	</form>
	</div>
</body>
<%-- 长度：${fn:length(sList)}<br/>
<c:forEach var="s" items="${sList}">
	<c:out value="${s}" default="wang" />
</c:forEach> --%>
</html>