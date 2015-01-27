
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.train.TrainAdapter,java.util.List"%>
<%
	TrainAdapter ua = new TrainAdapter();
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	int numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
	String keyword = request.getParameter("keyword");	
	String orderField = request.getParameter("orderField");
	String orderDirection = request.getParameter("orderDirection");
	int totalcount=ua.GetTotalCount_By_News_Id(news_id);
	request.setAttribute("items", ua.GetUsersItems_By_News_Id(news_id,pageNum, numPerPage, orderField, orderDirection , keyword));
	request.setAttribute("totalcount", totalcount);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form id="pagerForm" method="post"
	action="UsersInfo.jsp?news_id=${param.news_id}">
	<input type="hidden" name="status" value="${param.status}"> <input
		type="hidden" name="keyword" value="${param.keyword}" /> <input
		type="hidden" name="pageNum" value="${param.pageNum}" /> <input
		type="hidden" name="numPerPage" value="${param.numPerPage}" /> <input
		type="hidden" name="orderField" value="${param.orderField}" /> <input
		type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"
		action="UsersInfo.jsp?news_id=${param.news_id}&pageNum=1&numPerPage=10&orderField=SUBMITTIME&orderDirection=desc"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>姓名：<input type="text" name="keyword"
						value="${param.keyword}" />
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="delete"
				href="userTrainAction_delTrainUser?user_id={user_id}&news_id=${param.news_id}"
				target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="icon"
				href="Excel_users?tid=${param.tid}&news_id=${param.news_id}"
				target="dwzExport" targetType="navTab" title="导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80" align="center">真实姓名</th>
				<th width="80" align="center">性别</th>
				<th width="80" align="center">联系方式</th>
				<th width="80" align="center">邮箱</th>
				<th width="80" align="center">报名参加的培训</th>
				<th width="80" align="center">所属街道</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="useritem" items="${items}">
				<c:if test="${fn:contains(useritem.reserved01,sessionScope.admin_range)}">
					<tr target="user_id" rel="${useritem.userNo }">
						<td>${useritem.userName}</td>
						<td>${useritem.userSex }</td>
						<td>${useritem.userPhone }</td>
						<td>${useritem.userEmail }</td>
						<td>${useritem.newsTitle }</td>
						<td>${useritem.reserved01}</td>
					</tr>
				</c:if>
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

$(function(){
	var orderField = "${param.orderField}";
	var orderDirection = "${param.orderDirection}";
	$('th[orderfield='+orderField+']',$('.pageContent')).addClass(orderDirection);
})
</script>