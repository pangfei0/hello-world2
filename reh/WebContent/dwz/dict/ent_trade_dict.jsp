<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.dict.DictAdapter"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("items", da.GetTradeDict());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="dict/EntTradeContent.jsp" target="navTab" title="添加" rel="nav09"><span>添加</span></a></li>
			<li><a class="delete" href="DictAction_EntTradeDel?ruleid={rule_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="dict/EntTradeContent.jsp?alterNo={rule_id}" title="修改" rel="nav09" target="navTab"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>行业类型序号</th>
				<th>行业类型名称</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="items" items="${items}">
					<tr target="rule_id" rel="${items.tradeNo}">							
						<td>${items.tradeNo }</td>
						<td>${items.tradeName }</td>
					</tr>
				</c:forEach>
				</tbody>
		
	</table>
	
</div>
