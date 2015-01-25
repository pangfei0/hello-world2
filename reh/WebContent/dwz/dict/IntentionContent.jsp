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
	request.setAttribute("sBean",dDao.GetJobIntDict_By_No(alterNo));
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
		<form method="post"	action="DictAction_JobAdd" class="pageForm required-validate"	onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>求职意向序号：</label> <input type="text" size="30" name="jobintno" value="${requestScope.sBean.jobIntentionDictNo}"/>
			</p>
			<p>
				<label>求职意向名称：</label> <input type="text" size="30" name="jobintname" value="${requestScope.sBean.jobIntentionDictName}"/>
			</p>
			<p>
				<label>求职意向类型：</label> <input type="text" size="30" name="jobinttype" value="${requestScope.sBean.jobIntentionDictType}"/>
			</p>
			
		</div>
	</c:if>
	<c:if test="${param.alterNo!=null}">
		<form method="post"	action="DictAction_JobAlter" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
	
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>求职意向序号：</label> <input type="text" size="30" name="jobintno" readonly="true" value="${requestScope.sBean.jobIntentionDictNo}"/>
			</p>
			<p>
				<label>求职意向名称：</label> <input type="text" size="30" name="jobintname" value="${requestScope.sBean.jobIntentionDictName}"/>
			</p>
			<p>
				<label>求职意向类型：</label> <input type="text" size="30" name="jobinttype" value="${requestScope.sBean.jobIntentionDictType}"/>
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