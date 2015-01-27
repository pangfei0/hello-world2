<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ree.enterprise.EntJobDao,com.ree.hibernate.RepEntJobInfoViewId,com.ree.dict.DictAdapter"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("da", da);	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布招聘信息</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />

<jsp:include page="tree.jsp" />
<script type="text/javascript"
	src="./scripts/releaseJobInfo/releaseJobInfo.js"></script>
<script>
	$(function() {
		//获得querystring
		function getQueryStringByName(name) {
			var result = location.search.match(new RegExp("[\?\&]" + name
					+ "=([^\&]+)", "i"));
			if (result == null || result.length < 1) {
				return "";
			}
			return result[1];
		}
		method = getQueryStringByName('method');
		if (method === 'add' && ("${sessionScope.u_type}" === "1")) {
			$('.add_btn.ree-btn').trigger('click');
		}
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>发布招聘信息</span>
			</div>
			<div class="infos">
				<form class="search-box">
					<div class="search-block">
						<input type="hidden" name="c" value="1" /> <input type="hidden"
							name="p" value="10" /> <input type="hidden" name="sortBy"
							value="id.jobSubmitTime" /> <input type="hidden"
							name="sortMethod" value="desc" /> <a class="search_btn red_btn"
							href="#">查询</a> <span style="padding-left: 20px">职位名称：</span> <input
							name="jobBean.jobName" /> <span>工作地点：</span> <input
							type="hidden" name="jobBean.jobAddrPosName" class="addrTree" />
						<label class="addrTree" style="margin-left: 14px;"> 请点击并选择</label>
						<span style="padding-left: 90px">学历要求：</span> <select
							name="jobBean.educationDictNo">
							<option value="0">所有</option>
							<c:forEach var="dict"
								items="${requestScope.da.GetEducationDict() }">
								<option value="${dict.educationDictNo }">${dict.educationDictName
									}</option>
							</c:forEach>
						</select> <br /> <span style="padding-left: 20px">工作经验：</span> <select
							name="jobBean.jobExpDictNo">
							<option value="0">所有</option>
							<c:forEach var="dict" items="${requestScope.da.GetExpDict() }">
								<option value="${dict.jobExpDictNo }">${dict.jobExpDictName}</option>
							</c:forEach>
						</select> <span>性别要求：</span> <label style="margin-left: 14px;">男：</label><input
							style="width: 20px; margin-left: 0px; padding-top: 2px"
							name="jobBean.jobSex" type="radio" value="男" /> <label
							style="margin-left: 8px;">女：</label><input
							style="width: 20px; margin-left: 0px;" name="jobBean.jobSex"
							type="radio" value="女" /> <label style="margin-left: 8px;">不限：</label><input
							style="width: 20px; margin-left: 0px;" name="jobBean.jobSex"
							type="radio" value="" checked="checked" /> <br /> <span
							style="padding-left: 20px">薪金待遇：</span> <select
							name="jobBean.jobSalaryNo">
							<option value="0">所有</option>
							<c:forEach var="dict" items="${requestScope.da.GetSalaryDict() }">
								<option value="${dict.jobSalaryDictNo }">${dict.jobSalaryDictName
									}</option>
							</c:forEach>
						</select> <span>职位性质：</span> <select name="jobBean.jobTypePos">
							<option value="0">所有</option>
							<option value="1">全职</option>
							<option value="2">兼职</option>
							<option value="3">实习</option>
						</select> <br /> <span style="padding-left: 20px">行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span>
						<select class="intentType" name="jobBean.jobIntentionDictType">
							<option value="">所有</option>
							<c:forEach var="dict"
								items="${requestScope.da.GetIntentionDictDistinct() }">
								<option value="${dict.jobIntentionDictType}">
									${dict.jobIntentionDictType}</option>
							</c:forEach>
						</select> <span>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span> <select
							class="intentJob" name="jobBean.jobIntentionDictNo">
							<option value="0">所有</option>
						</select>
					</div>
					<div id="treeview" style="display: inline-block;"></div>
				</form>
			</div>

			<div class="btns">
				<a class="add_btn ree-btn" href="#"
					data-form="./dialogForm/modifyJobDialog.jsp?jobNo=" data-title="添加"
					data-action="EntJobInfo_Add">添加新职位</a><a class="refresh_btn">刷新</a>
			</div>
			<div class="data-table">
				<table class="info_table" cellspacing="0">
					<tr class="tr_top" align="center">
						<td>职位名称</td>
						<td>状态</td>
						<td style="width: 140px;">工作地点</td>
						<td>学历</td>
						<td>经验</td>
						<td>性别</td>
						<td>薪资待遇</td>
						<td>职业性质</td>
						<td style="width: 90px;">职业倾向/类别</td>
						<td>操作</td>
					</tr>
				</table>
			</div>
			<div class="center top-space">
				<div id="page" style="margin: 0px auto;">
					<div id="Pagination"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
