<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.admin.AdminAdapter,com.ree.list.ListAdapter"%>
<%
	AdminAdapter aa = new AdminAdapter();
	ListAdapter la = new ListAdapter();
	request.setAttribute("items", aa.GetAdminList_by_AdminType(1));
	request.setAttribute("la", la);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="dict/AdminListContent.jsp" target="navTab" title="添加" rel="nav30"><span>添加</span></a></li>
			<li><a class="delete" href="AdminAction_DelAdmin?adminbean.adminNo={rule_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="dict/AdminListContent.jsp?adminNo={rule_id}" title="修改" rel="nav30" target="navTab"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>名称</th>
				<th>用户名</th>
				<th>权限列</th>
				<th>权限范围</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="adminitems" items="${items}">
					<tr target="rule_id" rel="${adminitems.adminNo}">					
						<td width="5%">${adminitems.adminName }</td>
						<td>${adminitems.adminUid }</td>
						<td>
							<c:forEach var="i" items="${fn:split(adminitems.adminList,',') }">
							${requestScope.la.GetListName_By_ListNo(i) }
							</c:forEach>							
						</td>
						<td>${adminitems.adminRange }</td>
					</tr>
				</c:forEach>
				</tbody>
		
	</table>
	
</div>
