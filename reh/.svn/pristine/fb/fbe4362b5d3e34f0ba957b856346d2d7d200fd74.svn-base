<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.news.NewsAdapter"%>
<%
	NewsAdapter na = new NewsAdapter();
	int list_id = Integer.parseInt(request.getParameter("list_id"));
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	int numPerPage = Integer.parseInt(request
			.getParameter("numPerPage"));
	String keyword = request.getParameter("keyword");
	int totalcount = na.GetTotalCount_By_List_id(list_id,keyword,true);
	String orderField = request.getParameter("orderField");
	String orderDirection = request.getParameter("orderDirection");
	request.setAttribute("list_id", list_id);
	request.setAttribute("totalcount", totalcount);
	request.setAttribute("items", na.GetNewsItems_By_List_id(list_id,
			pageNum, numPerPage, orderField, orderDirection , keyword,true,true));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form id="pagerForm" method="post"
	action="NewsItems.jsp?list_id=${param.list_id}">
	<input type="hidden" name="status" value="${param.status}"> <input
		type="hidden" name="keyword" value="${param.keyword}" /> <input
		type="hidden" name="pageNum" value="${param.pageNum}" /> <input
		type="hidden" name="numPerPage" value="${param.numPerPage}" /> <input
		type="hidden" name="orderField" value="${param.orderField}" /> <input
		type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="NewsItems.jsp?list_id=${param.list_id}&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>查询：<input type="text" name="keyword"
						value="${param.keyword}" />
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">查询</button>
							</div>
						</div></li>
					<%-- <li><a class="button"
						href="adminsearch.jsp?list_id=${param.list_id}&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc"
						target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li> --%>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="NewsContent.jsp?add_list_id=${param.list_id}" target="navTab" title="添加新闻" rel="addnews"><span>添加</span></a></li>
			<li><a class="delete"
				href="NewsAction?id={news_id}&list_id=${param.list_id}&method=del"
				target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="NewsContent.jsp?nid={news_id}"
				title="修改新闻" rel="alternews" target="navTab"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th orderfield="newsTitle">标题</th>
				<th width="80" align="center" orderfield="newsAuthor">作者</th>
				<th width="150" orderfield="newsSubmittime">提交时间</th>
				<th width="150" orderfield="newsOrdertime">排序时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="newsitem" items="${items}">
				<tr target="news_id" rel="${newsitem.newsNo }">
					<td><a href="NewsView.jsp?nid=${newsitem.newsNo}" title="查看新闻"
						rel="viewnews" target="navTab">${newsitem.newsTitle }</a></td>
					<td>${newsitem.newsAuthor }</td>
					<td><fmt:formatDate value="${newsitem.newsSubmittime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${newsitem.newsOrdertime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> <select showvalue="${param.numPerPage}"
				class="combox" name="numPerPage"
				onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="50">50</option>
			</select> <span>条，共${totalcount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${totalcount}"
			numPerPage="${param.numPerPage}" pageNumShown="5"
			currentPage="${param.pageNum}"></div>

	</div>
</div>
<script>
	$(function() {
		var orderField = "${param.orderField}";
		var orderDirection = "${param.orderDirection}";
		$('th[orderfield=' + orderField + ']', $('.pageContent')).addClass(
				orderDirection);
	})
</script>