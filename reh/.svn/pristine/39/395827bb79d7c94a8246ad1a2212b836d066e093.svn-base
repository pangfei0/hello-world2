<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ree.enterprise.EntAdapter,com.ree.hibernate.RepEntInfoViewId,com.ree.hibernate.RepEntInfo"%>
<%
	if (session.getAttribute("u_type") != null
			&& Integer.parseInt(session.getAttribute("u_type")
					.toString()) == 1) {
		RepEntInfoViewId view = (RepEntInfoViewId) session
				.getAttribute("view");
		RepEntInfo entbean = (RepEntInfo) session
				.getAttribute("entbean");
		EntAdapter ea = new EntAdapter();
		request.setAttribute("EntBoxBean",
				ea.GetBoxBean_By_EntNo(entbean.getEntNo()));
		request.setAttribute("sc", request.getParameter("sc"));
	} else
		response.sendRedirect("./");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>再就业信息网</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<body>
	<jsp:include page="header.jsp" />
	<div class="main" style="width:954px">
		<div class="main_border" style="padding-top:50px;">
			<div class="main_left">
				<div class="msg_top">
					<div class="msg_top_content" style="font-size:19px;">
						<span id="username">${sessionScope.entbean.entName}</span>&nbsp;，&nbsp;欢迎登录
					</div>
					<div class="msg_top_content">
						上次登录时间：<span id="loginTime">${sessionScope.lastTime }</span>
					</div>
				</div>
				<!-- 				<div class="msg">
					您有消息：<a href="#" target="_blank">0</a>&nbsp;条
				</div> -->
				<div class="msg">
					收到的简历：<a href="offerMgrPage.jsp?boxtype=1" target="_blank">${requestScope.EntBoxBean.recruitNum
						}</a>&nbsp;条
				</div>
				<div class="msg">
					您的收藏夹内有简历：<a href="favouriteMgrPage.jsp" target="_blank">${requestScope.EntBoxBean.isFavourite
						}</a>&nbsp;条
				</div>
				<div class="login_btn fr">
					<a href="UserAction_Logout">安全退出</a>
				</div>
				<div class="underLine"
					style="margin-left:30px;padding-top:90px;width:88%" class="fr"></div>
				<div class="msg_bottom">
					<div class="msg_bottom_left fl left-space">
						客户<br>服务
					</div>
					<div class="fl left-space" style="font-size:15px;">
						热线：123456789<br>邮箱：123@123.com
					</div>
					<div class="fl left-space" style="font-size:15px;">
						<img class="left-space fl" src="images/company04.png"
							style="width:50px;height:50px" /> <a href="#" target="_blank"
							class="fl left-space">意见反馈</a>
					</div>
				</div>
			</div>
			<div class="main_right">
				<div class="shortcut_group">
					<h1>招聘管理</h1>
					<div class="shortcut">
						<a href="releaseJobInfo.jsp?method=add" target="_blank"><img
							src="images/company07.png" /></a>
						<h2>
							<a href="releaseJobInfo.jsp?method=add" target="_blank">职位发布</a>
						</h2>
					</div>
					<div class="shortcut">
						<a href="releaseJobInfo.jsp?method=normal" target="_blank"><img
							src="images/company08.jpg" /></a>
						<h2>
							<a href="releaseJobInfo.jsp?method=normal" target="_blank">职位管理</a>
						</h2>
					</div>
				</div>
				<div class="shortcut_group">
					<h1>应聘管理</h1>
					<div class="shortcut">
						<a href="offerMgrPage.jsp" target="_blank"><img
							src="images/company01.png" /></a>
						<h2>
							<a href="offerMgrPage.jsp?boxtype=1" target="_blank">简历收件箱</a>
						</h2>
					</div>
					<div class="shortcut">
						<a href="userLib.jsp" target="_blank"><img
							src="images/company03.png" /></a>
						<h2>
							<a href="userLib.jsp" target="_blank">现有人才库</a>
						</h2>
					</div>
					<div class="shortcut">
						<a href="favouriteMgrPage.jsp" target="_blank"><img
							src="images/company02.png" /></a>
						<h2>
							<a href="favouriteMgrPage.jsp" target="_blank">人才储备库</a>
						</h2>
					</div>
				</div>
				<div class="shortcut_group">
					<h1>账号管理</h1>
					<div class="shortcut">
						<a href="registerAndModify.jsp" target="_blank"><img
							src="images/company06.png" /></a>
						<h2>
							<a href="registerAndModify.jsp" target="_blank">基本信息</a>
						</h2>
					</div>
					<div class="shortcut">
						<a href="registerAndModify.jsp" target="_blank"><img
							src="images/company05.png" /></a>
						<h2>
							<a href="alterpassword.jsp" target="_blank">修改密码</a>
						</h2>
					</div>
					<div class="shortcut">
						<a href="blacklist.jsp" target="_blank"><img
							src="images/company09.png" /></a>
						<h2>
							<a href="blacklist.jsp" target="_blank">黑名单管理</a>
						</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
