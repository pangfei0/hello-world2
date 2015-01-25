<%@page import="com.ree.hibernate.RepEntBlacklistUserId"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ree.favourite.AuditionDao,com.ree.entblacklist.BlackListDao,com.ree.hibernate.RepEntBlacklistUser,com.ree.hibernate.RepEntInfo,com.ree.hibernate.RepEntAuditionUser"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	BlackListDao bDao = new BlackListDao();
	if (request.getParameter("userCert") != null&& !"".equals(request.getParameter("userCert"))) {
		RepEntBlacklistUserId id = new RepEntBlacklistUserId();
		id.setEntNo(Integer.parseInt(request.getParameter("entNo")));
		id.setUserCert(request.getParameter("userCert"));
		RepEntBlacklistUser bbean = (RepEntBlacklistUser) bDao.getBean(RepEntBlacklistUser.class, id);
		request.setAttribute("blackbean", bbean);
		//RepEntInfo entbean = (RepEntInfo) session.getAttribute("entbean");
	}
%>
<link href="./css/dialog_style.css" rel="stylesheet" />
<form action="" method="post">
<div style="width:640px;height:auto;min-height:120px">
	<div class="apply_item">
		<div class="apply_tag">身份证号:</div>
		<div class="apply_input">
			<input name="newuserCert" type="text"
				value="${requestScope.blackbean.id.userCert }" />
		</div>
	</div>
</div>
</form>