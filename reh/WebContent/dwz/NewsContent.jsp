<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page
	import="com.ree.news.NewsAdapter, java.util.Date, java.text.SimpleDateFormat"%>
<%
	NewsAdapter na = new NewsAdapter();
	String nid = request.getParameter("nid");
	if(nid!=null&&nid.length()>0){
		request.setAttribute("nBean", na.GetNewsItem_By_NewsId(Integer.parseInt(nid)));
	}
	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
	request.setAttribute("now", dateformat.format(new Date()));
%>
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
	<form method="post"
		action="NewsAction?id=${requestScope.nBean.newsNo }"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>标 题：</label> <input name="title" type="text" size="30"
					class="required" value="${requestScope.nBean.newsTitle }" />
			</p>
			<p>
				<label>作者：</label> <input name="author" class="" type="text"
					readonly="true" size="30"
					value="<c:out value='${requestScope.nBean.newsAuthor }' default='${sessionScope.admin_uid }'/>"
					alt="无作者" />
			</p>
			<p>
				<label>列表节点：</label> <input name="list_id" class="digits"
					type="text" readonly="true" size="30"
					value="<c:out value='${requestScope.nBean.newsListNo }' default='${param.add_list_id }'/>" />
			</p>
			<p>
				<label>提交时间：</label> <input type="text" name="submittime"
					dateFmt="yyyy-MM-dd HH:mm:ss.0" readonly="true" class="date"
					size="30"
					/ value="<c:out value='${requestScope.nBean.newsSubmittime }' default='${requestScope.now }'/>"><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>排序时间：</label> <input type="text" name="ordertime"
					dateFmt="yyyy-MM-dd HH:mm:ss.0" readonly="true" class="date"
					size="30"
					/ value="<c:out value='${requestScope.nBean.newsOrdertime}' default='${requestScope.now }'/>"><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>截止时间：</label> <input type="text" name="trainEndtime"
					dateFmt="yyyy-MM-dd HH:mm:ss.0" readonly="true" class="date"
					size="30"
					/ value="<c:out value='${requestScope.nBean.newsTrainEndtime}' default='${requestScope.now }'/>"><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>注册资金：</label> <select name="capital" class="required combox">
					<option value="">请选择</option>
					<option value="10">10</option>
					<option value="50" selected>50</option>
					<option value="100">100</option>
				</select> <span class="unit">万元</span>
			</p>

			<div class="divider"></div>
			<p class="w100">
				<label>新闻正文：</label>
				<textarea class="editor required" name="content" rows="8" cols="100"
					upLinkUrl="uploadfile" upLinkExt="zip,rar,doc,docx,xls,xlsx"
					upImgUrl="uploadfile" upImgExt="jpg,jpeg,gif,png"
					upFlashUrl="upload.php" upFlashExt="swf" upMediaUrl="upload.php" upMediaExt="avi">
				<c:out value='${requestScope.nBean.newsContent}' default='' />
							</textarea>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
