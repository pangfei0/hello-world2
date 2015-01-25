<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ree.dict.DictAdapter,com.ree.community.communityAdapter"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<style type="">
.addrTree,addrTree2 {
	margin-left: 35px;
}
label.addrTree,label.addrTree2{
color:red;}
span.addByNow,span.delByNow{
font-weight: bold;
font-size: 17px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>修改密码</span>
			</div>
			<div class="apply">
				<form action="AlterPassAction" method="post">
					<div class="apply_item">
						<div class="apply_tag">请输入原密码： <span>*</span>
						</div>
						<div class="apply_input">
							<input type="password" name="oldpassword" class="tag_input" />
						</div>
					</div>		
					<div class="apply_item">
						<div class="apply_tag">请输入新密码： <span>*</span>
						</div>
						<div class="apply_input">
							<input type="password" name="newpassword" class="tag_input" />
						</div>
					</div>			
					<div class="apply_item">
						<div class="apply_tag">再次输入新密码： <span>*</span>
						</div>
						<div class="apply_input">
							<input type="password" name="renewpassword" class="tag_input" />
						</div>
					</div>	
					<div class="center">
						<input type="submit" value="确定" class="submit_btn"/> 
						<input type="reset"	style="margin-left:50px" value="取消" class="submit_btn" />
					</div>				
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>