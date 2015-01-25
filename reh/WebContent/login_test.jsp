<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="source_test.jsp" /> 
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<link href="./css/main.css" rel="stylesheet" type="text/css" />
<link href="./css/zebra_dialog.css" rel="stylesheet" type="text/css" />
<link href="./css/pagination.css" rel="stylesheet" />
<link href="./css/ree-dialog.css" rel="stylesheet" />
<script type="text/javascript" src="scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="scripts/public/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="scripts/public/My97/WdatePicker.js"></script>
<script type="text/javascript" src="scripts/public/zebra_dialog.js"></script>
<script type="text/javascript" src="./scripts/public/reload.js"></script>
<script type="text/javascript" src="./scripts/public/ree-multiselect.js"></script>
<script type="text/javascript" src="./scripts/public/formToJson.js"></script>
<script type="text/javascript" src="scripts/public/uniqueArray.js"></script>

<script src="dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="./scripts/login/I_Login_byUserInfo.js" type="text/javascript"></script>
</head>
<body>
<form id="login_form">
	用户类型：<input type="text" id="loginTab_Content1" name="u_type"/><br/>
	用户名：<input id="username" name="username" type="text"/><br/>
            密码：<input id="password" name="password" type="password"><br/>
	验证码：<input type="text" id="verify_pwd"  name="codename"/><br/>
	<img src="SecurityCodeImageAction.action" id="Verify" width="100px" height="32px" style="cursor:pointer;" alt="看不清，换一张"/>
	<button id="user_btn" type="button">登录</button>	
	<br/>
	<!-- <input type="hidden" id="loginTab_Content1" name="u_type" value="0" />
	<input id="username" name="username" type="text"/>
	<input id="password" name="password" type="password">
	<input type="text" id="verify_pwd"  name="codename"/>
	<img src="SecurityCodeImageAction.action" id="Verify" width="100px" height="32px" style="cursor:pointer;" alt="看不清，换一张"/>
	<button id="submit_btn" type="button">企业登录</button>	 -->
</form>
</body>
</html>