<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.news.NewsAdapter"%>
<%
	NewsAdapter na = new NewsAdapter();
	request.setAttribute("item", na.GetNewsItem_By_NewsId(Integer.parseInt(request.getParameter("nid"))));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="news_detail border-style top-space white-bg">
			<div class="navigation" style="text-align: left">
				<img src="images/dot_new.jpg" /><span>详细信息</span>
			</div>
			<div class="news_detail_title top-space">${item.newsTitle }</div>
			<div class="news_detail_more underLine">时间：${item.newsSubmittime
				}
				来源：${item.newsAuthor }</div>
			<div class="news_detail_content">${item.newsContent }</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>