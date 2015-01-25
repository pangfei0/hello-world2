<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page
	import="com.ree.news.NewsAdapter,com.ree.user.UserAdapter,com.ree.hibernate.RepUserInfoViewId,com.ree.hibernate.RepUserInfo,com.opensymphony.xwork2.ActionContext"%>
<%
	if (session.getAttribute("u_type") != null
			&& Integer.parseInt(session.getAttribute("u_type")
					.toString()) == 1) {
		response.sendRedirect("./company");
	}
	NewsAdapter na = new NewsAdapter();
	request.setAttribute("na", na);
	UserAdapter ua;
	RepUserInfoViewId userview = null;
	RepUserInfo userbean = null;
	if (ActionContext.getContext().getSession().get("userbean") != null) {
		userview = (RepUserInfoViewId) ActionContext.getContext()
				.getSession().get("view");
		userbean = (RepUserInfo) ActionContext.getContext()
				.getSession().get("userbean");
		request.getSession().setAttribute("view", userview);
		request.getSession().setAttribute("userbean", userbean);
	}
	if (session.getAttribute("u_type") != null
			&& Integer.parseInt(session.getAttribute("u_type")
					.toString()) == 0) {
		ua = new UserAdapter();
		request.setAttribute("UserBoxBean",
				ua.GetBoxBean_By_UserNo(userbean.getUserNo()));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>再就业信息网</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<link href="./css/goodnav.css" rel="stylesheet" type="text/css" />
<script src="./scripts/jquery.litenav.js" type="text/javascript"></script>
<script src="./scripts/index/index.js" type="text/javascript"></script>

<style type="text/css">
.newstitle {
	padding-left: 2px;
}

.x_hei a:hover {
	color: #d50000;
	text-decoration: underline;
	font-size: 14px;
}

.logbtn {
	width: 65px;
	height: 25px;
	color: #FFF;
	display: block;
	background: #6DAC13;
	line-height: 25px;
	margin-left: 22px;
	margin-right: 22px;
	float: left;
	text-align: center;
}
</style>
<script src="./scripts/index/index.js" type="text/javascript"></script>
<script>
	document.onkeydown = function(event) {
		e = event ? event : (window.event ? window.event : null);
		if (e.keyCode == 13 && $('#log_Content0').css('display') === 'block') {
			user_login();
		} else if (e.keyCode == 13
				&& $('#log_Content1').css('display') === 'block')
			com_login();
	}
</script>
</head>
<body onload="onLoginLoaded()">
	<jsp:include page="header.jsp" />
	<div class="main_index">
		<div style="padding-left:8px">
			<div class="login border-style top-space white-bg">
				<div class="login_title" id="loginTab">
					<c:choose>
						<c:when test="${sessionScope.u_type ==0}">
							<span class="active">用户窗口 </span>
						</c:when>
						<c:when test="${sessionScope.u_type ==1}">
							<span class="active">企业窗口 </span>
						</c:when>
						<c:otherwise>
							<div id="log">
								<span class="active" onmouseover="nTabs(this,0);">用户窗口 </span><span
									class="normal" onmouseover="nTabs(this,1);">企业窗口 </span>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<c:choose>
					<c:when test="${sessionScope.u_type !=null}">
						<form action="UserAction_Logout" method="post">
							<%-- <div style="width:100%;color:#5A9304;margin:20px">
							<span>${requestScope.sc}</span>
						</div> --%>
							<div class="left-space">
								<div class="center top-space">
									<img src="images/login_tag.jpg" id="login_tag"
										style="width: 165px; height: 34px" />
								</div>
								<div class="top-space left-space"
									style="font-weight:bold;font-size: 15px;">${sessionScope.userbean
									!=null?sessionScope.userbean.userName:sessionScope.entbean.entName}&nbsp;，&nbsp;欢迎登录</div>
								<c:choose>
									<c:when test="${sessionScope.u_type ==0}">
										<div class="msg txtsize left-space "
											style="height:30px;line-height: 30px;padding-top:10px">
											投报职位数：<a href="myRecruit.jsp" target="_blank">${requestScope.UserBoxBean.recruitNum
												}</a>&nbsp;条
										</div>
										<!-- <div class="msg txtsize left-space"
										style="height:30px;line-height: 30px;">
										信件：<a href="#" target="_blank">0</a>&nbsp;条
									</div> -->
										<div class="msg txtsize left-space"
											style="height:30px;line-height: 30px;">
											已回应职位数：<a href="myRecruit.jsp" target="_blank">${requestScope.UserBoxBean.recruitHasStateNum
												}</a>&nbsp;条
										</div>
										<div class="ms left-space"
											style="height:30px;line-height: 30px;padding-top:10px;padding-left:5px;">
											<a href="recruitAndEmploy.jsp?method=auto"
												onmouseout="this.style.cssText='color:#5A9304;text-decoration:none;font-size:15px;'"
												onmouseover="this.style.cssText='color:gray;text-decoration:underline;font-size:15px;'"
												style="color:#5A9304;font-size:15px;"><b>工作推荐</b></a> <a
												href="myRecruit.jsp"
												onmouseout="this.style.cssText='color:#5A9304;text-decoration:none;font-size:15px;padding-left: 30px;'"
												onmouseover="this.style.cssText='color:gray;text-decoration:underline;font-size:15px;padding-left: 30px;'"
												style="padding-left: 30px;color:#5A9304;font-size:15px;"><b>我的招聘</b></a><br>
											<a style="color: #5A9304;font-size:15px;"
												href="alterpassword.jsp"
												onmouseout="this.style.cssText='color:#5A9304;text-decoration:none;font-size:15px'"
												onmouseover="this.style.cssText='color:gray;text-decoration:underline;font-size:15px'"><b>修改密码</b></a>
										</div>

										<div class="login_btn fr" style="padding-top:8px">
											<button type="submit" style="border:none;">安全退出</button>
										</div>
									</c:when>
									<c:when test="${sessionScope.u_type ==1}">
										<div class="msg txtsize left-space">
											您有消息：<a href="#" target="_blank">10</a>&nbsp;条
										</div>
										<div class="msg txtsize left-space">
											收到的简历：<a href="#" target="_blank">10</a>&nbsp;条
										</div>
										<div class="msg txtsize left-space">
											您还可以发布简历：<a href="#" target="_blank">10</a>&nbsp;条
										</div>
										<div class="login_btn fr top-space">
											<button type="submit">安全退出</button>
										</div>

									</c:when>
								</c:choose>
							</div>
						</form>
					</c:when>
					<c:otherwise>
						<div id="log_Content0" style="display: block;">
							<form name="LoginForm" style="margin-bottom: 0px !important;"
								action="UserAction_Login" method="post">
								<input type="hidden" id="loginTab_Content1" name="u_type"
									value="0" />
								<div class="center top-space">
									<img src="images/login_tag.jpg"
										style="width: 165px; height: 34px" />
								</div>

								<div class="login_detail top-space">
									用户名： <input type="text" placeholder="用户名" id="user_name"
										data-title="用户名" name="username" />
								</div>
								<div class="login_detail">
									密&nbsp;&nbsp;&nbsp;码： <input type="password" placeholder="密码"
										id="password" data-title="密码" name="password" />
								</div>
								<div class="center" style="color: #484C53">
									<input name="rememberPass" type="checkbox" id="user_rem" />记住用户名
									<span style="padding-left: 30px;"><a
										style="color: #5A9304;" href="findpass.jsp" class="resetPass"
										data-form="./dialogForm/resetPassDialog.jsp" data-title="重置密码"
										onmouseout="this.style.cssText='color:#5A9304;text-decoration:none'"
										onmouseover="this.style.cssText='color:gray;text-decoration:underline;'">忘记密码？</a></span>
								</div>
								<div class="login_btn">
									<a href="registerAndModify.jsp?u_type=0" target="_blank">注册</a>
									<a onclick="user_login();" target="_blank">登录</a>

								</div>
								<div class="center top-space text"
									style="color: #484C53;display: none;">
									合作网站账号登录： <a href="#" target="_blank" title="新浪微博"><img
										src="images/3login_1.jpg" style="width: 25px; height: 25px;" /></a>
									<a href="#" target="_blank" title="腾讯"><img
										src="images/3login_2.jpg" style="width: 25px; height: 25px;" /></a>
								</div>
								<div class="underLine" style="padding:20px 10px 0px 10px;"></div>
							</form>
						</div>
						<div id="log_Content1" style="display:none;">
							<form name="LoginForm1" style="margin-bottom: 0px !important;"
								action="UserAction_Login" method="post">
								<input type="hidden" id="loginTab_Content0" name="u_type"
									value="1" />
								<div class="center top-space">
									<img src="images/login_tag_company.jpg"
										style="width:165px;height:34px" />
								</div>
								<!-- <div style="height: 34px"></div> -->
								<div class="login_detail top-space">
									企业名： <input type="text" placeholder="用户名" id="com_name"
										data-title="用户名" name="username" />
								</div>
								<div class="login_detail">
									密&nbsp;&nbsp;&nbsp;码： <input type="password" placeholder="密码"
										id="password" data-title="密码" name="password" />
								</div>
								<div class="center" style="color: #484C53">
									<input name="rememberPass" type="checkbox" id="com_rem" />记住用户名
									<span style="padding-left: 30px;"><a
										style="color: #5A9304;" href="entfindpass.jsp" class="resetPass"
										data-form="./dialogForm/resetPassDialog.jsp" data-title="重置密码"
										onmouseout="this.style.cssText='color:#5A9304;text-decoration:none'"
										onmouseover="this.style.cssText='color:gray;text-decoration:underline;'">忘记密码？</a></span>
								</div>
								<div class="login_btn">
									<a href="registerAndModify.jsp?u_type=1" target="_blank">注册</a>
									<a onclick="com_login();" target="_blank">登录</a>

								</div>
								<div class="center top-space text"
									style="color:#484C53;display:none;">
									合作网站账号登录： <a href="#" target="_blank" title="新浪微博"><img
										src="images/3login_1.jpg" style="width: 25px; height: 25px;" /></a>
									<a href="#" target="_blank" title="腾讯"><img
										src="images/3login_2.jpg" style="width: 25px; height: 25px;" /></a>
								</div>
								<div class="underLine" style="padding:20px 10px 0px 10px;"></div>
							</form>
						</div>
					</c:otherwise>
				</c:choose>

			</div>

			<div class="news border-style top-space left-space white-bg">
				<div>
					<!-- 选项卡0开始 -->
					<div class="nTab1">
						<!-- 标题开始 -->
						<div class="TabTitle1">
							<ul id="myTab1">
								<li class="active" onMouseOver="nTabs(this,0);">专场招聘</li>
								<li class="normal" onMouseOver="nTabs(this,1);">企业招聘</li>
							</ul>
						</div>
						<!-- 内容开始 -->
						<div class="TabContent1">
							<div id="myTab1_Content0">
								<div class="news_list">
									<table width="360" border="0" cellspacing="0" cellpadding="0"
										text-align="center">

										<c:forEach var="newsitem"
											items="${na.GetNewsItems_By_List_id(1,1, 8, 'NEWS_ORDERTIME', 'desc','')}">
											<tr rel="${newsitem.newsNo}">
												<td width="70%" height="26" align="left" class="x_hei">
													<li><a href='news.jsp?nid=${newsitem.newsNo}'
														target=_blank title='${newsitem.newsTitle }'
														class="newstitle">${fn:length(newsitem.newsTitle)>17?(fn:substring(newsitem.newsTitle,0,17)).concat('...'):newsitem.newsTitle
															}</a></li>
												</td>
												<td width="30%" align="right" class="time"><fmt:formatDate
														value="${newsitem.newsSubmittime }" pattern="yyyy-MM-dd" /></td>
											</tr>
										</c:forEach>

									</table>
								</div>
								<div class="more">
									<ul>
										<li class="x_hei topmore"
											style="padding-top: 8px; width: 370px;"><a
											href="moreNews.jsp?list_id=1&curPage=1&tid=0&curPage=1"
											style="padding-left: 305px;">更多>></a></li>
									</ul>
								</div>
							</div>
							<div id="myTab1_Content1" style="display: none;">
								<div class="news_list">
									<table width="350" border="0" cellspacing="0" cellpadding="0"
										text-align="center">
										<c:forEach var="jobitem"
											items="${requestScope.na.GetEntJobInfoList_By_All_Allowed('','', '',1,7 ,'id.jobSubmitTime', 'desc')}">
											<tr rel="${jobitem.jobNo}">
												<td width="70%" height="26" align="left" class="x_hei">
													<li><a href='jobInfoPage.jsp?jobNo=${jobitem.jobNo}'
														target=_blank class="newstitle">${fn:length(jobitem.entName)>8?(fn:substring(jobitem.entName,0,8)).concat('...'):jobitem.entName
															} -
															${fn:length(jobitem.jobName)>8?(fn:substring(jobitem.jobName,0,8)).concat('...'):jobitem.jobName
															}</a></li>
												</td>
												<td width="30%" align="right" class="time"><fmt:formatDate
														value="${jobitem.jobSubmitTime }" pattern="yyyy-MM-dd" /></td>
											</tr>
										</c:forEach>

									</table>
								</div>
								<div class="more">
									<ul>
										<li class="x_hei topmore"
											style="padding-top: 8px; width: 360px;"><a
											href="recruitAndEmploy.jsp" style="padding-left: 305px;">更多>></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="guide border-style top-space left-space white-bg">
				<table width="360" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="360" align="center" valign="top">
							<div id="hotpic">
								<div id="NewsPic">
									<c:set
										value="${na.GetNewsItems_By_List_id(2,1, 6, 'NEWS_ORDERTIME', 'desc','')}"
										var="picNews" />
									<c:forEach var="newsitem" varStatus="s" items="${picNews }">
										<a target="_blank" href="news.jsp?nid=${newsitem.newsNo}"
											style="visibility: ${s.index==0?'visible':'hidden'}; display: ${s.index==0?'block':'none'};">
											<img src="${newsitem.newsImgurl }" class="Picture"
											alt="${newsitem.newsTitle }" title="${newsitem.newsTitle }"
											border="0" width="333" height="268" />
										</a>
									</c:forEach>
									<div class="Nav">
										<span class="Normal">6</span> <span class="Normal">5</span> <span
											class="Normal">4</span> <span class="Normal">3</span> <span
											class="Normal">2</span> <span class="Cur">1</span>

									</div>
								</div>
								<div id="NewsPicTxt" style="width: 333px; overflow: hidden">
									<a target="_blank"
										href="news.jsp?nid=${picNews.get(0).newsNo }">
										${picNews.get(0).newsTitle} </a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="adv top-space">
				<img src="images/adv01.jpg" />
			</div>
			<div class="adv top-space left-space">
				<img src="images/adv02.jpg" />
			</div>
			<div>
				<div class="info_part border-style top-space white-bg">
					<div class="info_title">

						<c:if test="${sessionScope.USER_NO==NULL}">
							<a href="moreNews.jsp?list_id=6&tid=1&curPage=1">更多>></a>
						</c:if>
						<c:if test="${sessionScope.USER_NO!=NULL}">
							<a
								href="moreNews.jsp?list_id=6&tid=1&curPage=1&user_id=${sessionScope.USER_NO}">更多>></a>
						</c:if>
						<span>培训信息</span>
					</div>
					<div class="info_content">
						<table width="93%" border="0" cellspacing="0" cellpadding="0">
							<c:forEach var="newsitem"
								items="${na.GetNewsItems_By_List_id(6,1, 8, 'NEWS_ORDERTIME', 'desc','')}">
								<tr rel="${newsitem.newsNo}">
									<td width="340" height="26" align="left" class="x_hei">
										<li style="list-style: inside disc;"><a
											href='news.jsp?nid=${newsitem.newsNo}' target=_blank
											title='${newsitem.newsTitle }'>${fn:length(newsitem.newsTitle)>20?(fn:substring(newsitem.newsTitle,0,20)).concat('...'):newsitem.newsTitle
												}</a></li>
									</td>
									<td width="20%" align="right" class="time"><fmt:formatDate
											value="${newsitem.newsSubmittime }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
				<div class="info_part left-space border-style top-space white-bg">
					<div class="info_title">
						<a href="moreNews.jsp?list_id=3&tid=0&curPage=1">更多>></a><span>政策法规</span>
					</div>
					<div class="info_content">
						<table width="93%" border="0" cellspacing="0" cellpadding="0">
							<c:forEach var="newsitem"
								items="${na.GetNewsItems_By_List_id(3,1, 8, 'NEWS_ORDERTIME', 'desc','')}">
								<tr rel="${newsitem.newsNo}">
									<td width="340" height="26" align="left" class="x_hei">
										<li style="list-style: inside disc;"><a
											href='news.jsp?nid=${newsitem.newsNo}' target=_blank
											title='${newsitem.newsTitle }'>${fn:length(newsitem.newsTitle)>20?(fn:substring(newsitem.newsTitle,0,20)).concat('...'):newsitem.newsTitle
												}</a></li>
									</td>
									<td width="20%" align="right" class="time"><fmt:formatDate
											value="${newsitem.newsSubmittime }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
				<div class="info_part top-space border-style white-bg">
					<div class="info_title">
						<a href="moreNews.jsp?list_id=4&tid=0&curPage=1">更多>></a><span>就业指南</span>
					</div>
					<div class="info_content">
						<table width="93%" border="0" cellspacing="0" cellpadding="0">
							<c:forEach var="newsitem"
								items="${na.GetNewsItems_By_List_id(4,1, 8, 'NEWS_ORDERTIME', 'desc','')}">
								<tr rel="${newsitem.newsNo}">
									<td width="340" height="26" align="left" class="x_hei">
										<li style="list-style: inside disc;"><a
											href='news.jsp?nid=${newsitem.newsNo}' target=_blank
											title='${newsitem.newsTitle }'>${fn:length(newsitem.newsTitle)>20?(fn:substring(newsitem.newsTitle,0,20)).concat('...'):newsitem.newsTitle
												}</a></li>
									</td>
									<td width="20%" align="right" class="time"><fmt:formatDate
											value="${newsitem.newsSubmittime }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
				<div class="info_part left-space  top-space border-style white-bg">
					<div class="info_title">
						<a href="moreNews.jsp?list_id=5&tid=0&curPage=1">更多>></a><span>表格下载</span>
					</div>
					<div class="info_content">
						<table width="93%" border="0" cellspacing="0" cellpadding="0">
							<c:forEach var="newsitem"
								items="${na.GetNewsItems_By_List_id(5,1, 8, 'NEWS_ORDERTIME', 'desc','')}">
								<tr rel="${newsitem.newsNo}">
									<td width="340" height="26" align="left" class="x_hei">
										<li style="list-style: inside disc;"><a
											href='news.jsp?nid=${newsitem.newsNo}' target=_blank
											title='${newsitem.newsTitle }'>${fn:length(newsitem.newsTitle)>20?(fn:substring(newsitem.newsTitle,0,20)).concat('...'):newsitem.newsTitle
												}</a></li>
									</td>
									<td width="20%" align="right" class="time"><fmt:formatDate
											value="${newsitem.newsSubmittime }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>

						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>