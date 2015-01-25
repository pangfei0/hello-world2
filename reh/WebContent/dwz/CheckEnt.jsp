<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.enterprise.EntAdapter"%>
<%
 	EntAdapter ea = new EntAdapter();
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	int numPerPage = Integer.parseInt(request
			.getParameter("numPerPage"));
	String keyword = request.getParameter("keyword");
	String orderField = request.getParameter("orderField");
	String orderDirection = request.getParameter("orderDirection");
	int totalcount = ea.GetEntTotalCount_By_All(pageNum, numPerPage, orderField, orderDirection , keyword);
	request.setAttribute("totalcount", totalcount);
	request.setAttribute("items", ea.GetEntItems_By_All(pageNum, numPerPage, orderField, orderDirection , keyword)); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form id="pagerForm" method="post"action="CheckEnt.jsp">
	<input type="hidden" name="status" value="${param.status}"> <input
		type="hidden" name="keyword" value="${param.keyword}" /> <input
		type="hidden" name="pageNum" value="${param.pageNum}" /> <input
		type="hidden" name="numPerPage" value="${param.numPerPage}" /> <input
		type="hidden" name="orderField" value="${param.orderField}" /> <input
		type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"action="CheckEnt.jsp?pageNum=1&numPerPage=10&orderField=ENT_NO&orderDirection=desc"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>企业名称：<input type="text" name="keyword" value="${param.keyword}" />
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
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">			
			<li><a class="delete"
				href="EntdelAction_delent?ent_no={ent_no}"
				target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="icon" href="EntdelAction_state?ent_no={ent_no}" target="ajaxTodo" class="edit" title="改变报名状态">
			<span>审核为已通过</span></a></li>
			<li><a class="icon" href="EntdelAction_restate?ent_no={ent_no}" target="ajaxTodo" class="edit" title="改变报名状态">
			<span>审核为未通过</span></a></li>
			<!-- <li><a class="icon" href="Excel_ents"
				title="确定要导出吗" rel="alternews" target="navTab"><span>导出Excel</span></a></li> -->
				<li><a class="icon"
				href="Excel_ents"
				target="dwzExport" targetType="navTab" title="导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>企业名称</th>
				<th>联系人</th>
				<th>联系电话</th>
				<th>电子邮箱</th>
				<th>联系地址</th>
				<th>所属街道</th>
				<th>经济类型</th>
				<th>行业类型</th>
				<th>社保编号</th>
				<th>机构代码</th>
				<th>审核状态</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entitem" items="${items}">
				<c:if test="${fn:contains(entitem.communityAddr,sessionScope.admin_range)}">
					<tr target="ent_no" rel="${entitem.entNo }">
					<td>${entitem.entName }</td>
					<td>${entitem.entContactMan }</td>
					<td>${entitem.entContactPhone }</td>
					<td>${entitem.entEmail }</td>
					<td>${entitem.entContactAddr }</td>
					<td>${entitem.communityAddr }</td>
					<td>${entitem.entTypeEconomyName }</td>
					<td>${entitem.entTypeTradeName }</td>
					<td>${entitem.entSercurityNum }</td>
					<td>${entitem.entOCode }</td>
					<c:choose>
						<c:when test="${entitem.reserved02=='0'}">
							<td style="color:red;">未通过审核</td>
						</c:when>
						<c:when test="${entitem.reserved02 == '1'}">
							<td>已通过审核</td>
						</c:when>
						<c:otherwise><td></td></c:otherwise>
					</c:choose>
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
	$(function() {
		var orderField = "${param.orderField}";
		var orderDirection = "${param.orderDirection}";
		$('th[orderfield=' + orderField + ']', $('.pageContent')).addClass(
				orderDirection);
	})
</script>