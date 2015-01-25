<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ree.dict.DictAdapter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	DictAdapter da = new DictAdapter();
	request.setAttribute("da", da);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页-招聘与求职</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<jsp:include page="tree.jsp" />
<script type="text/javascript"
	src="./scripts/recruitAndEmploy/recruitAndEmploy.js"></script>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="hidden"></div>
		<div class="main_border border-style top-space white-bg ms-div">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>招聘信息</span>
			</div>
			<div class="infos">
				<form class="search-box">
					<input type="hidden" name="c" value="1" /><input type="hidden"
						name="p" value="10" /> <input type="hidden" name="sortBy"
						value="${sessionScope.u_type==null?'id.jobSubmitTime':'id.reserved01' }" /><input
						type="hidden" name="sortMethod" value="desc" /> <a
						${sessionScope.u_type==null?'class="red_btn disabled_btn" onclick="return false;"':'class="red_btn"'}
						href="recruitAndEmploy.jsp">智能推荐</a> <a
						class="search_btn red_btn custom_btn" href="#">自定义查询</a> <span>职位名称：</span>
					<input name="jobBean.jobName" /> <span>公司名称：</span><input
						name="jobBean.entName" /> <span>工作地点：</span><input type="hidden"
						name="jobBean.jobAddrPosName" class="addrTree" /><label
						class="addrTree"> 请点击并选择</label> <br /> <span>学历要求：</span> <select
						name="jobBean.educationDictNo">
						<option value="0">所有</option>
						<c:forEach var="dict"
							items="${requestScope.da.GetEducationDict() }">
							<option value="${dict.educationDictNo }">${dict.educationDictName
								}</option>
						</c:forEach>
					</select> <span>薪金待遇：</span> <select name="jobBean.jobSalaryNo">
						<option value="0">所有</option>
						<c:forEach var="dict" items="${requestScope.da.GetSalaryDict() }">
							<option value="${dict.jobSalaryDictNo }">${dict.jobSalaryDictName
								}</option>
						</c:forEach>
					</select> <span>工作经验：</span> <select name="jobBean.jobExpDictNo">
						<option value="0">所有</option>
						<c:forEach var="dict" items="${requestScope.da.GetExpDict() }">
							<option value="${dict.jobExpDictNo }">${dict.jobExpDictName
								}</option>
						</c:forEach>
					</select> <br /> <span>职位性质：</span> <select name="jobBean.jobTypePos">
						<option value="0">所有</option>
						<option value="1">全职</option>
						<option value="2">兼职</option>
						<option value="3">实习</option>
					</select> <span>性别要求：</span> <label style="margin-left:14px;">男</label><input
						style="width: 20px;padding-top: 2px" name="jobBean.jobSex"
						type="radio" value="男" /> <label style="">女</label><input
						style="width: 20px;margin-left: 5px;" name="jobBean.jobSex"
						type="radio" value="女" /> <label>不限</label><input
						checked="checked" style="width: 20px;margin-left: 0px;"
						name="jobBean.jobSex" type="radio" value="" /> <br /> <span>行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span>
					<select class="intentType" name="jobBean.jobIntentionDictType">
						<option value="">所有</option>
						<c:forEach var="dict"
							items="${requestScope.da.GetIntentionDictDistinct() }">
							<option value="${dict.jobIntentionDictType}">
								${dict.jobIntentionDictType}</option>
						</c:forEach>
					</select> <span>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span> <select
						class="intentJob" name="jobBean.jobIntentionDictNo">
						<option value="0">所有</option>
					</select>
					<br />
					<span>测试-行业类别</span><input type="text" readonly="readonly" class='ms-btn' value="请选择行业" data-source="Dict_GetJobTypeDict_By_All"></input>
				</form>
				<div class="btns">
					<a class="add_btn" href="recruitAndEmploy.jsp">求职招聘</a><a
						class="add_btn" href="myRecruit.jsp">我的应聘</a><a
						class="refresh_btn">刷新</a>
				</div>
				<div class="data-table">
					<table class="info_table" cellspacing="0">
						<tr class="tr_top" align="center">
							<td>职位名称</td>
							<td>公司/部门</td>
							<td style="width: 140px;">工作地点</td>
							<td>学历</td>
							<td>经验</td>
							<td>性别</td>
							<td>薪资待遇</td>
							<td>职业性质</td>
							<td style="width: 90px;">职业倾向/类别</td>
							<td ${sessionScope.u_type==null?'style="display:none;"':'' }>匹配度</td>
							<td ${sessionScope.u_type==null?'style="display:none;"':'' }>操作</td>
						</tr>
					</table>
				</div>
				<div class="center top-space">
					<div id="page" style="margin:0px auto;">
						<div id="Pagination"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
