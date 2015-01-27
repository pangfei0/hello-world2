<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type=text/javascript>
	function menuFix() {
		var sfEls = document.getElementById("nav").getElementsByTagName("li");
		for ( var i = 0; i < sfEls.length; i++) {
			sfEls[i].onmouseover = function() {
				this.className += (this.className.length > 0 ? " " : "")
						+ "sfhover";
			}
			sfEls[i].onMouseDown = function() {
				this.className += (this.className.length > 0 ? " " : "")
						+ "sfhover";
			}
			sfEls[i].onMouseUp = function() {
				this.className += (this.className.length > 0 ? " " : "")
						+ "sfhover";
			}
			sfEls[i].onmouseout = function() {
				this.className = this.className.replace(new RegExp(
						"( ?|^)sfhover\\b"), "");
			}
		}
	}
	window.onload = menuFix;
</script>

<body>
	<div class="header">
		<div class="header_top">
			<div class="logo">
				<img src="images/logo_new.jpg" />
			</div>

			<span style="font-weight:bold;font-size: 46px;padding-top:10px;padding-left:15px" class="fl">社区再就业</span>

		</div>

		<div class="nav">
			<ul id="nav">
				<li><a href="./" target="">首页</a></li>
				<c:choose>
					<c:when test="${sessionScope.u_type ==1}">
						<!-- 企业 start -->
						<li><a href="registerAndModify.jsp" target="">登记企业信息</a></li>
						<li><a href="releaseJobInfo.jsp?method=normal" target="">招聘管理</a>
							<ul>
								<li><a href="releaseJobInfo.jsp?method=normal"
									_fcksavedurl="#">查看已发布职位</a></li>
								<li><a href="releaseJobInfo.jsp?method=add"
									_fcksavedurl="#">发布职位信息</a></li>
								<li><a href="userLib.jsp" _fcksavedurl="#">平台人才库</a></li>
							</ul></li>
						<li><a href="offerMgrPage.jsp?boxtype=1" target="">应聘管理</a>
							<ul>
								<li><a href="offerMgrPage.jsp?boxtype=1" _fcksavedurl="#">简历收件箱</a></li>
								<li><a href="favouriteMgrPage.jsp" _fcksavedurl="#">人才储备库</a></li>
								<li><a href="myLibPage.jsp" _fcksavedurl="#">现有人才库</a></li>
							</ul></li>
						<!-- 企业 end -->
					</c:when>
					<c:otherwise>
						<!-- 用户及一般  start-->
						<li><a href="registerAndModify.jsp" target="">登记就业信息</a></li>
						<li><a href="recruitAndEmploy.jsp" target="">招聘与求职</a>
							<ul>
								<li><a href="recruitAndEmploy.jsp?method=auto"
									_fcksavedurl="#">工作推荐</a></li>
								<li><a href="myRecruit.jsp" _fcksavedurl="#">我的应聘</a></li>
								<li><a href="moreNews.jsp?list_id=1&tid=0&curPage=1"
									_fcksavedurl="#">专场招聘</a></li>
							</ul></li>

						<li><a href="moreNews.jsp?list_id=6&tid=1&curPage=1">培训信息</a></li>
						<li><a href="moreNews.jsp?list_id=3&tid=0&curPage=1">政策法规</a></li>
						<li><a href="moreNews.jsp?list_id=4&tid=0&curPage=1"
							target="">就业指南</a></li>
						<li><a href="moreNews.jsp?list_id=5&tid=0&curPage=1">表格下载</a></li>
						<!-- 用户及一般  end-->
					</c:otherwise>
				</c:choose>

			</ul>
			<div class="clear"></div>
		</div>
	</div>
</body>