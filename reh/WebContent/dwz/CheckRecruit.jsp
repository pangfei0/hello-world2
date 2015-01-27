<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.enterprise.CheckJobAdapter"%>
<%
    CheckJobAdapter ca = new CheckJobAdapter();
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	int numPerPage = Integer.parseInt(request
			.getParameter("numPerPage"));
	String keyword = request.getParameter("keyword");	
	String orderField = request.getParameter("orderField");
	String orderDirection = request.getParameter("orderDirection");
	int totalcount = ca.GetEntJobTotalcount_By_All(pageNum, numPerPage, orderField, orderDirection , keyword);
	request.setAttribute("totalcount", totalcount);
	request.setAttribute("items", ca.GetEntJobItems_By_All(pageNum, numPerPage, orderField, orderDirection , keyword)); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form id="pagerForm" method="post"action="CheckRecruit.jsp">
	<input type="hidden" name="status" value="${param.status}"> <input
		type="hidden" name="keyword" value="${param.keyword}" /> <input
		type="hidden" name="pageNum" value="${param.pageNum}" /> <input
		type="hidden" name="numPerPage" value="${param.numPerPage}" /> <input
		type="hidden" name="orderField" value="${param.orderField}" /> <input
		type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);"action="CheckRecruit.jsp?pageNum=1&numPerPage=10&orderField=JOB_NO&orderDirection=desc"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>工作名称：<input type="text" name="keyword" value="${param.keyword}" />
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
			<li><a class="delete" href="EntdelAction_deljob?job_no={job_no}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="icon" href="EntdelAction_jobstate?job_no={job_no}" target="ajaxTodo" class="edit" title="改变报名状态">
			<span>审核为已通过</span></a></li>
			<li><a class="icon" href="EntdelAction_rejobstate?job_no={job_no}" target="ajaxTodo" class="edit" title="改变报名状态">
			<span>审核为未通过</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>工作名称</th> 
				<th>工作地点</th>
				<th>薪资待遇</th>
				<th>职位性质</th>
				<th>学历要求</th>
				<th>招聘人数</th>
				<th>工作经验</th>
				<th>招聘公司</th>	
				<th>联系方式</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="jobitem" items="${items}">
				<tr target="job_no" rel="${jobitem.jobNo }">
					<td>${jobitem.jobName }</td>					
					<td>${jobitem.jobAddrPosName }</td>
					<td>${jobitem.jobSalaryDictName }</td>
					<td>${jobitem.jobTypePos }</td>
					<td>${jobitem.educationDictName }</td>
					<td>${jobitem.jobPnum }</td>
					<td>${jobitem.jobExpDictName }</td>
					<td>${jobitem.entName }</td>
					<td>${jobitem.jobContactPhone }</td>
					<c:choose>
						<c:when test="${jobitem.jobState==0}">
							<td style="color:red;">未通过审核</td>
						</c:when>
						<c:when test="${jobitem.jobState==1}">
							<td>已通过审核</td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
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