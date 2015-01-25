<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.dict.DictAdapter"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("items", da.GetIntentionDict_By_All());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="dict/IntentionContent.jsp" target="navTab" title="添加" rel="nav04"><span>添加</span></a></li>
			<li><a class="delete" href="DictAction_JobDel?jobintid={rule_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="dict/IntentionContent.jsp?alterNo={rule_id}" title="修改" rel="nav04" target="navTab"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>序号/排序</th>
				<th>职业</th>
				<th>行业</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="scoreitems" items="${items}">
					<tr target="rule_id" rel="${scoreitems.jobIntentionDictNo}">	
						<td>${scoreitems.jobIntentionDictNo }</td>						
						<td>${scoreitems.jobIntentionDictName }</td>
						<td>${scoreitems.jobIntentionDictType }</td>
					</tr>
				</c:forEach>
				</tbody>
		
	</table>
	
</div>
