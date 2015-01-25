<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.dict.DictAdapter"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("items", da.GeteduDict_By_All());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="dict/EduContent.jsp" target="navTab" title="添加" rel="nav04"><span>添加</span></a></li>
			<li><a class="delete" href="DictAction_eduDel?ruleid={rule_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="dict/EduContent.jsp?alterNo={rule_id}" title="修改" rel="nav04" target="navTab"><span>修改</span></a></li>
			<li></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>序号/权重/排序<span style="color:red;">数字，不重复</span></th>
				<th>学历名称</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="scoreitems" items="${items}">
					<tr target="rule_id" rel="${scoreitems.educationDictNo}">	
						<td>${scoreitems.educationDictNo }</td>						
						<td>${scoreitems.educationDictName }</td>
					</tr>
				</c:forEach>
				</tbody>
		
	</table>
	
</div>
