<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ree.favourite.AuditionDao,com.ree.enterprise.EntJobDao,com.ree.hibernate.RepEntAuditionUserId,com.ree.hibernate.RepEntInfo,com.ree.hibernate.RepEntAuditionUser"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	AuditionDao aDao = new AuditionDao();
	EntJobDao eDao = new EntJobDao();
	if (request.getParameter("jobNo") != null
			&& !"".equals(request.getParameter("jobNo"))) {
		RepEntAuditionUserId id = new RepEntAuditionUserId();
		id.setJobNo(Integer.parseInt(request.getParameter("jobNo")));
		id.setUserNo(Integer.parseInt(request.getParameter("userNo")));
		RepEntAuditionUser bean = (RepEntAuditionUser) aDao.getBean(
				RepEntAuditionUser.class, id);
		request.setAttribute("jobbean", eDao
				.GetEntJobInfo_By_jobNo(Integer.parseInt(request
						.getParameter("jobNo"))));
		RepEntInfo entbean = (RepEntInfo) session
				.getAttribute("entbean");
		request.setAttribute("joblist",
				eDao.GetEntJobInfoList_By_EntNo_All_Allowed(entbean.getEntNo()));
		if (bean != null)
			request.setAttribute("aubean", bean);
	}
%>
<link href="./css/dialog_style.css" rel="stylesheet" />
<form action="" method="post">
<div style="width:640px;height:auto;min-height:120px">
	<div class="apply_item">
		<div class="apply_tag">面试职位:</div>
		<div class="apply_input">
			<c:choose>
				<c:when test="${param.jobNo!=0&&requestScope.jobbean!=null }">
					<label style="margin-left:20px">${requestScope.jobbean.jobName }</label>
				</c:when>
				<c:otherwise>
					<select name="selectedjobNo">
						<c:forEach var="v" items="${requestScope.joblist }">
							<option value="${v.jobNo }" ${param.jobNo==v.jobNo?'selected':''}>${v.jobName}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="apply_item">
		<div class="apply_tag">面试时间:</div>
		<div class="apply_input">
			<input name="auditionBean.auditionTime" type="text" style="width:222px"
				value="${requestScope.aubean.auditionTime }"
				onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" />
		</div>
	</div>
	<div class="apply_item">
		<div class="apply_tag">面试地点:</div>
		<div class="apply_input">
			<input name="auditionBean.auditionAddr" type="text"
				value="${requestScope.aubean.auditionAddr }" />
		</div>
	</div>
</div>
</form>