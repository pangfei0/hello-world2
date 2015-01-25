<%@page import="com.ree.community.communityAdapter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ree.dict.DictAdapter"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("items", da.GetIntentionDict_By_All());
%>
<link href="../css/altercomm.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../scripts/dict/intentiondict.js"></script>
<style type="text/css">
	.jobleft{
		float:left;
		width:600px;
		padding-top:20px;
		background: #F2F2F2;
	}
	.jobright{
		float:left;
		padding-left:30px;
		width:600px;
		padding-top:20px;
	}
</style>
<h2 class="contentTitle">分数字典维护</h2>
<div class="pageContent">
	<form method="post" action="DictAction_JobDel" class="pageForm required-validate"	onsubmit="return validateCallback(this, navTabAjaxDone);">
	<div class="jobleft">		
		<table class="info_table" cellspacing="0" border="1" width="100%" layoutH="138">
				<thead>
						<tr class="tr_top" align="center" height="30px">
							<th style="width: 80px;">操作</th>
							<th style="width: 80px;">求职意向序号</th>
							<th style="width: 80px;">求职意向名称</th>
							<th style="width: 80px;">求职意向类型</th>
						</tr>
				</thead>
				<tbody>
					<c:forEach var="intentionitems" items="${items}">
						<tr>							
							<td><input type="radio" value="${intentionitems.jobIntentionDictNo}" name="jobintid" ></td>
							<td>${intentionitems.jobIntentionDictNo }</td>
							<td>${intentionitems.jobIntentionDictName }</td>
							<td>${intentionitems.jobIntentionDictType }</td>
						</tr>
			</c:forEach>
				</tbody>
		</table>		
	</div>
	<div class="jobright" id="jobright" style="display:none;">		
		求职意向序号:<input type="text" id="jobintno" value=""/><br><br>
		求职意向名称:<input type="text" id="jobintname" value=""/><br><br>
		求职意向类型:<input type="text" id="jobinttype" value=""/>
		<input type="button" id="jobbtn" value="添加">
	</div>
	<div class="jobright" id="jobalter" style="display:none;">		
		求职意向序号:<input type="text" id="jobintno1" value="" readonly="readonly"/><br><br>
		求职意向名称:<input type="text" id="jobintname1" value=""/><br><br>
		求职意向类型:<input type="text" id="jobinttype1" value=""/>
		<input type="button" id="jobalbtn" value="修改">
	</div>
	<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="jobalterbtn">修改</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="jobaddbtn">添加</button>
						</div>
					</div></li>
				<li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" id="jobdelbtn">删除</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="jobcancel">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
		</form>
</div>
