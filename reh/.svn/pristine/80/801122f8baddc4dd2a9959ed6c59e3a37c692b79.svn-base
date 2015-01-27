<%@page import="com.ree.community.communityAdapter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ree.dict.DictAdapter"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("items", da.GeteduDict_By_All());
%>
<link href="../css/altercomm.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../scripts/dict/edudict.js"></script>
<style type="text/css">
	.eduleft{
		float:left;
		width:600px;
		padding-top:20px;
		background: #F2F2F2;
	}
	.eduright{
		float:left;
		padding-left:30px;
		width:600px;
		padding-top:20px;
	}
</style>
<h2 class="contentTitle">学历字典维护</h2>
<div class="pageContent">
	<form method="post" action="DictAction_eduDel" class="pageForm required-validate"	onsubmit="return validateCallback(this, navTabAjaxDone);">
	<div class="eduleft">		
		<table class="info_table" cellspacing="0" border="1" width="100%" layoutH="138">
				<thead>
						<tr class="tr_top" align="center" height="30px">
							<th style="width: 80px;">操作</th>
							<th style="width: 80px;">学历序号</th>
							<th style="width: 80px;">学历名称</th>
							<th style="width: 80px;">学历类型</th>
						</tr>
				</thead>
				<tbody>
					<c:forEach var="eduitems" items="${items}">
						<tr>							
							<td><input type="radio" value="${eduitems.educationDictNo}" name="ruleid" ></td>
							<td>${eduitems.educationDictNo }</td>
							<td>${eduitems.educationDictName }</td>
							<td>${eduitems.educationDictType }</td>
						</tr>
			</c:forEach>
				</tbody>
		</table>		
	</div>
	<div class="eduright" id="eduright" style="display:none;">		
		学历序号:<input type="text" id="eduNo" value=""/><br><br>
		学历名称:<input type="text" id="eduName" value=""/><br><br>
		学历类型:<input type="text" id="ruletype" value=""/>
		<input type="button" id="edubtn" value="添加">
	</div>
	<div class="eduright" id="edualter" style="display:none;">		
		学历序号:<input type="text" id="eduNo1" value="" readonly="readonly"/><br><br>
		学历名称:<input type="text" id="eduName1" value=""/><br><br>
		学历类型:<input type="text" id="ruletype1" value=""/>
		<input type="button" id="edualbtn" value="修改">
	</div>
	<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="edualterbtn">修改</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="eduaddbtn">添加</button>
						</div>
					</div></li>
				<li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" id="edudelbtn">删除</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="educancel">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
		</form>
</div>
