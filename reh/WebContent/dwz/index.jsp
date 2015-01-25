<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ree.list.ListAdapter,com.ree.news.NewsAdapter"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<% 
if(session.getAttribute("admin_uid")==null)
	response.sendRedirect("LoginAction");
ListAdapter la = new ListAdapter();
request.setAttribute("la", la);
NewsAdapter na = new NewsAdapter();
request.setAttribute("nBean", na.GetNewsItem_By_NewsId(1));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>华天后台管理界面</title>

<link href="themes/default/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/core.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="themes/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<link href="uploadify/css/uploadify.css" rel="stylesheet"
	type="text/css" media="screen" />
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<style type="text/css">
#header {
	height: 85px
}

#leftside, #container, #splitBar, #splitBarProxy {
	top: 90px
}
</style>

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="uploadify/scripts/jquery.uploadify.min.js"
	type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="chart/raphael.js"></script>
<script type="text/javascript" src="chart/g.raphael.js"></script>
<script type="text/javascript" src="chart/g.bar.js"></script>
<script type="text/javascript" src="chart/g.line.js"></script>
<script type="text/javascript" src="chart/g.pie.js"></script>
<script type="text/javascript" src="chart/g.dot.js"></script>

<script src="bin/dwz.min.js" type="text/javascript"></script>
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        DWZ.init("dwz.frag.xml", {
            loginUrl: "login_dialog.html", loginTitle: "登录", // 弹出登录对话框
            //		loginUrl:"login.html",	// 跳到登录页面
            statusCode: { ok: 200, error: 300, timeout: 301 }, //【可选】
            keys: { statusCode: "statusCode", message: "message" }, //【可选】
            pageInfo: { pageNum: "pageNum", numPerPage: "numPerPage", orderField: "orderField", orderDirection: "orderDirection" }, //【可选】
            debug: false, // 调试模式 【true|false】
            hasTitle :true,//
            callback: function () {
                initEnv();
                $("#themeList").theme({ themeBase: "themes" });
                //
                $("#sidebar .toggleCollapse div").trigger("click"); //hide leftbar
                $('#sidebar_s .collapse').unbind('click'); //unbind click
                $('.toggleCollapse div').hide(); //禁止手动隐藏/显示leftbar
                //setTimeout(function() {$("#sidebar .toggleCollapse div").trigger("click");}, 10);$('.collapse div,.collapse').unbind('click');
            }
        });
    });
</script>
<script type="text/javascript">
    function check(){
    	
    }
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="./index_ent.html">标志</a>
				<ul class="nav">
					<li><a href="http://bbs.dwzjs.com" target="_blank">帮助</a></li>
					<li><a href="./Logout">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<div id="navMenu">
				<ul>
					<!-- 在同一个jsp中tid不同显示的界面不同 -->
					<c:choose>
						<c:when test="${sessionScope.admin_type!=0 }">
						<c:forEach var="list" items="${requestScope.la.ReturnList_By_ListType(-1) }">
							<c:if test="${fn:contains(sessionScope.admin_list,list.listNo) }">
							${list.listUrl }
							</c:if>
						</c:forEach>
						</c:when>
						<c:otherwise>
						<c:forEach var="list" items="${requestScope.la.ReturnList_By_ListType(-1) }">
							${list.listUrl }
						</c:forEach>
						<!-- <li><a href="index_nav.jsp?tid=1" data-hidebar="true" target="navTab" rel="nav"><span>首页</span></a></li>
						<li><a href="index_nav.jsp?tid=2"><span>审核</span></a></li>
					<li><a href="index_nav.jsp?tid=3&list_id=6&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc" data-hidebar="true" target="navTab" rel="nav"><span>培训管理</span></a></li>
					<li><a href="index_nav.jsp?tid=4"><span>发布</span></a></li>
					<li><a href="index_nav.jsp?tid=5&cid=1&pageNum=1&numPerPage=10&orderField=USER_NAME&orderDirection=desc" data-hidebar="true" target="navTab" rel="nav"><span>查看人才库</span></a></li>
					<li><a href="index_nav.jsp?tid=7"><span>信息统计与分析</span></a></li>
					<li><a href="index_nav.jsp?tid=6" target="navTab" rel="nav"><span>系统管理</span></a></li> -->
						</c:otherwise>
					</c:choose>
					

				</ul>
			</div>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar"></div>

			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<!--  <li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li> -->
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<h2>
									<a href="doc/dwz-user-guide.pdf" target="_blank">DWZ框架使用手册(PDF)</a>
								</h2>
								<a href="doc/dwz-user-guide.swf" target="_blank">DWZ框架演示视频</a>
							</div>
							<div class="right">
								<p>
									<a href="doc/dwz-user-guide.zip" target="_blank"
										style="line-height: 19px">DWZ框架使用手册(CHM)</a>
								</p>
								<p>
									<a href="doc/dwz-ajax-develop.swf" target="_blank"
										style="line-height: 19px">DWZ框架Ajax开发视频教材</a>
								</p>
							</div>
							<p>
								<span>DWZ富客户端框架</span>
							</p>
							<p>
								DWZ官方微博:<a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a>
							</p>
						</div>
						<div class="pageFormContent" layoutH="80">
							${requestScope.nBean.newsContent}</div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">
		Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">DWZ团队</a>
	</div>

	<!-- 注意此处js代码用于google站点统计，非DWZ代码，请删除 -->
	<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-16716654-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? ' https://ssl' : ' http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

</body>
</html>