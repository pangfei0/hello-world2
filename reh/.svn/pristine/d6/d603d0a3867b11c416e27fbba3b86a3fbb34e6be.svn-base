<%@page import="com.ree.community.communityAdapter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ree.dict.DictAdapter"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("items", da.GetScoreDict_By_All());
%>
<link href="../css/altercomm.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./scripts/public/jquery-1.10.2.js"></script>
<style type="text/css">
	.left{
		float:left;
		width:600px;
		padding-top:20px;
		background: #F2F2F2;
	}
	.right{
		float:left;
		padding-left:30px;
		width:600px;
		padding-top:20px;
	}
</style>
<h2 class="contentTitle">分数字典维护</h2>
<div class="pageContent">
	<form method="post" action="DictAction_Del" class="pageForm required-validate"	onsubmit="return validateCallback(this, navTabAjaxDone);">
	<div class="left">		
		<table class="info_table" cellspacing="0" border="1" width="100%" layoutH="138">
				<thead>
						<tr class="tr_top" align="center" height="30px">
							<th style="width: 80px;">操作</th>
							<th style="width: 80px;">规则序号</th>
							<th style="width: 80px;">规则名</th>
							<th style="width: 80px;">规则比重</th>
							<th style="width: 80px;">规则对象</th>
						</tr>
				</thead>
				<tbody>
					<c:forEach var="scoreitems" items="${items}">
						<tr>							
							<td><input type="radio" value="${scoreitems.ruleNo}" name="ruleid" ></td>
							<td>${scoreitems.ruleNo }</td>
							<td>${scoreitems.ruleName }</td>
							<td>${scoreitems.ruleScore }</td>
							<td>${scoreitems.ruleFor }</td>
						</tr>
			</c:forEach>
				</tbody>
		</table>		
	</div>
	<div class="right" id="right" style="display:none;">		
		规则序号:<input type="text" id="ruleNo" value=""/><br><br>
		规&nbsp;&nbsp;则&nbsp;&nbsp;名:<input type="text" id="ruleName" value=""/><br><br>
		规则比重:<input type="text" id="ruleScore" value=""/><br><br>
		规则对象:<input type="text" id="ruleFor" value=""/>
		<input type="button" id="btn" value="添加">
	</div>
	<div class="right" id="alter" style="display:none;">		
		规则序号:<input type="text" id="ruleNo1" value="" readonly="readonly"/><br><br>
		规&nbsp;&nbsp;则&nbsp;&nbsp;名:<input type="text" id="ruleName1" value=""/><br><br>
		规则比重:<input type="text" id="ruleScore1" value=""/><br><br>
		规则对象:<input type="text" id="ruleFor1" value=""/>
		<input type="button" id="albtn" value="修改">
	</div>
	<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="alterbtn">修改</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="addbtn">添加</button>
						</div>
					</div></li>
				<li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" id="delbtn">删除</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="cancel">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
		</form>
</div>
