<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ree.dict.DictAdapter"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("da", da);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>应聘管理-人才库</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<jsp:include page="tree.jsp" />
<script type="text/javascript" src="./scripts/userLib/userLib.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>应聘管理-平台人才库</span>
			</div>
			<div class="infos">
				<form class="search-box">
					<input type="hidden" name="c" value="1" /><input type="hidden"
						name="p" value="10" /> <input type="hidden" name="sortBy"
						value="id.userName" /><input type="hidden" name="sortMethod"
						value="asc" /> <a class="search_btn red_btn" href="#">查询</a> <span>人员姓名：</span>
					<input name="userBean.userName" /> <span>所在街道：</span><input
						type="hidden" name="userBean.userAddrName" class="addrTree" /><label
						style="margin-left:14px" class="addrTree"> 请点击并选择</label> <span
						style="margin-left:90px">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：</span>
					<select name="userBean.userEducationNo">
						<option value="0">所有</option>
						<c:forEach var="dict"
							items="${requestScope.da.GetEducationDict() }">
							<option value="${dict.educationDictNo }">${dict.educationDictName
								}</option>
						</c:forEach>
					</select> <br /> <span>工作经验：</span> <select name="userBean.userExpNo">
						<option value="0">所有</option>
						<c:forEach var="dict" items="${requestScope.da.GetExpDict() }">
							<option value="${dict.jobExpDictNo }">${dict.jobExpDictName
								}</option>
						</c:forEach>
					</select>
					<%-- <span>薪金待遇：</span> 
					<select name="userBean.userSalaryNo">
						<option value="0">所有</option>
						<c:forEach var="dict" items="${requestScope.da.GetSalaryDict() }">
							<option value="${dict.jobSalaryDictNo }">${dict.jobSalaryDictName
								}</option>
						</c:forEach>
					</select>  --%>
					<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span> <label
						style="margin-left:14px;">男：</label> <input
						style="width: 20px;margin-left: 0px;padding-top: 2px"
						name="userBean.userSex" type="radio" value="男" /> <label
						style="margin-left:8px;">女：</label> <input
						style="width: 20px;margin-left: 0px;" name="userBean.userSex"
						type="radio" value="女" /> <label style="margin-left:8px;">不限：</label>
					<input style="width: 20px;margin-left: 0px;"
						name="userBean.userSex" type="radio" value="" checked="checked" />
					<br /> <span>行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span>
					<select class="intentType" name="jobIntentionDictType">
						<option value="">所有</option>
						<c:forEach var="dict"
							items="${requestScope.da.GetIntentionDictDistinct() }">
							<option value="${dict.jobIntentionDictType}">
								${dict.jobIntentionDictType}</option>
						</c:forEach>
					</select> <span>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span> <select
						class="intentJob" name="userBean.userIntention">
					</select>
				</form>

				<div class="btns">
					<a class="add_btn" id="sresume" href="favouriteMgrPage.jsp">简历收藏夹</a>
					<a class="refresh_btn">刷新</a>
				</div>
				<div class="data-table">
					<table class="info_table" cellspacing="0">
						<tr class="tr_top" align="center">
							<td>姓名</td>
							<td>性别</td>
							<td>联系方式</td>
							<td>年龄</td>
							<td>学历</td>
							<td>求职意向</td>
							<td>所属街道</td>
							<td>操作</td>
						</tr>

					</table>
				</div>
				<div class="center top-space">
					<div id="page" style="margin:0px auto;">
						<div id="Pagination"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
