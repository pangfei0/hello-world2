<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.news.NewsAdapter"%>
<%
	NewsAdapter na = new NewsAdapter();
	request.setAttribute("item", na.GetNewsItem_By_NewsId(Integer.parseInt(request.getParameter("nid"))));
%>
<style type="text/css">
div.pageCentent p {
	line-height: auto;
	margin: 12px 0;
}

div.pageCentent p span {
	margin: auto;
}
</style>
<div class="accountInfo">
	<div class="alertInfo">

		<h2>
			<a href="doc/dwz-user-guide.pdf" target="_blank">DWZ框架使用手册下载</a>
		</h2>
		<a href="doc/dwz-user-guide.swf" target="_blank">DWZ框架视频教材下载</a>
	</div>
	<div class="right">
		<p>发布时间：${item.newsSubmittime }</p>
	</div>
	<p>
		<span>${item.newsTitle } </span>
	</p>
	<p>
		<a>来源：${item.newsAuthor }</a>
	</p>
</div>

<div class="pageCentent" layoutH="80">${item.newsContent }</div>