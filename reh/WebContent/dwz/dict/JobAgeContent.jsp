<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.ree.dict.DictDao"%>
<c:if test="${param.alterNo!=null}">
<%
	DictDao dDao=new DictDao();
	int alterNo=Integer.parseInt(request.getParameter("alterNo"));
	request.setAttribute("sBean",dDao.GetJobAgeDict_By_No(alterNo));
%>
</c:if>
<style>
p.w100 {
	width: 100%;
}

.editor {
	height: auto !important;
	height: 400px;
	min-height: 400px;
	width: 80%;
}
</style>
<div class="pageContent">
	<c:if test="${param.alterNo==null}">
		<form method="post"	action="DictAction_JobAgeAdd" class="pageForm required-validate"	onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>职业要求年龄序号：</label> <input type="text" size="30" name="ruleNo" value="${requestScope.sBean.ageNo}"/>
			</p>
			<p>
				<label>职业要求年龄：</label> <input type="text" size="30" name="ruleName" value="${requestScope.sBean.ageName}"/>
			</p>
			
		</div>
	</c:if>
	<c:if test="${param.alterNo!=null}">
		<form method="post"	action="DictAction_AgeJobAlter" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
	
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>职业要求年龄序号：</label> <input type="text" size="30" name="ruleNo" readonly="true" value="${requestScope.sBean.ageNo}"/>
			</p>
			<p>
				<label>职业要求年龄：</label> <input type="text" size="30" name="ruleName" value="${requestScope.sBean.ageName}"/>
			</p>
			
		</div>
	</c:if>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
