<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//用户状态：0-用户；1-企业
	if (session.getAttribute("userbean") != null) {
		//已登陆	-登记
		//userbean = (RepUserInfo) session.getAttribute("userbean");
		request.setAttribute("userbean",
				session.getAttribute("userbean"));
	} else if (request.getParameter("u_type") != null) {
		request.setAttribute("u_type", request.getParameter("u_type"));
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<%-- <jsp:include page="source_test.jsp" /> --%>
<script type="text/javascript" src="scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="scripts/public/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="scripts/public/My97/WdatePicker.js"></script>
<script type="text/javascript" src="scripts/public/zebra_dialog.js"></script>

<script type="text/javascript" src="./scripts/public/reload.js"></script>
<script type="text/javascript" src="./scripts/public/ree-table.js"></script>
<script type="text/javascript" src="./scripts/public/ree-multiselect.js"></script>
<script type="text/javascript" src="./scripts/public/formToJson.js"></script>
<script type="text/javascript" src="scripts/public/uniqueArray.js"></script>
<script src="dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>

<script src="./scripts/login/I_newPWD_byUserInfo.js" type="text/javascript"></script>
</head>
<body>
<form id="alterpwd_form">
					<div class="apply_item">
						<div class="apply_tag">请输入原密码： <span>*</span>
						</div>
						<div class="apply_input">
							<input id="oldpass" type="password" name="oldpass" class="tag_input" />
							<input id="oldpwd_show" type="hidden" class="tag_input" />
						</div>
					</div>
					<div class="apply_item">
						<div class="apply_tag">请输入新密码： <span>*</span>
						</div>
						<div class="apply_input">
							<input type="password" id="newpassword"  name="newpassword" class="tag_input" />
							<input id="npwd_show" type="hidden" class="tag_input" />
						</div>
					</div>			
					<div class="apply_item">
						<div class="apply_tag">再次输入新密码： <span>*</span>
						</div>
						<div class="apply_input">
							<input type="password" name="renewpassword" id="renewpassword" class="tag_input" />
							<input id="repwd_show" type="hidden" class="tag_input" />
						</div>
					</div>	
					<div class="center">
						<input id="ok" value="确定" class="submit_btn" type="button"/> 
						<input id="cancel" type="reset"	style="margin-left:50px" value="取消" class="submit_btn" />
					</div>			
</form>
</body>
</html>