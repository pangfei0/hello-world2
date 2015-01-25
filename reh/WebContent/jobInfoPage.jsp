<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ree.enterprise.EntJobAdapter,com.ree.hibernate.RepEntJobInfoViewId,com.ree.hibernate.RepEntInfoViewId"%>
	<%@ page isELIgnored="false"%>
<%
EntJobAdapter ea = new EntJobAdapter();
if(request.getParameter("jobNo")!=null){
	int jobNo = Integer.parseInt(request.getParameter("jobNo"));
	RepEntJobInfoViewId jobbean = ea.GetJobInfoView_By_jobNo(jobNo);
	RepEntInfoViewId entbean = ea.GetEntInfo_By_entNo(jobbean.getEntNo());
	request.setAttribute("jobbean", jobbean);
	request.setAttribute("entbean", entbean);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职位与公司详情</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>职位与企业详情</span>
			</div>

			<div class="info_reg top-space">
				<div class="title underLine" style="margin-left:50px">
					<span>职位基本信息</span>
				</div>

				<table class="info_table" cellspacing="0"
					style="margin-top: 20px; margin-left: 50px;">
					<tr align="center">
					<td class="tr_top" style="width: 120px;">职位名称</td>
					<td style="width: 120px;">${requestScope.jobbean.jobName }</td>
					<td class="tr_top" style="width: 120px;">性别要求</td>
					<td style="width: 120px;">${requestScope.jobbean.jobSex }</td>
					<td class="tr_top">职位类别</td>
					<td>${requestScope.jobbean.jobIntentionDictType} - ${requestScope.jobbean.jobIntentionDictName }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">薪金待遇</td>
						<td>${requestScope.jobbean.jobSalaryDictName }</td>
						<td class="tr_top">招聘人数</td>
						<td>${requestScope.jobbean.jobPnum }</td>
						<td class="tr_top">职位性质</td>
						<td>${requestScope.jobbean.jobTypePos==1?'全职': (requestScope.jobbean.jobTypePos==2?'兼职':'实习')}</td>
					</tr>
					<tr align="center">
						<td class="tr_top">工作地点</td>
						<td colspan="5">${requestScope.jobbean.jobAddrPosName }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">学历要求</td>
						<td>${requestScope.jobbean.educationDictName }</td>
						<td class="tr_top">工作经验</td>
						<td>${requestScope.jobbean.jobExpDictName}</td>
						<td class="tr_top">年龄要求</td>
						<td>${requestScope.jobbean.ageName }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">发布时间</td>
						<td style="width: 180px;">${requestScope.jobbean.jobSubmitTime }</td>
						<td class="tr_top">开始时间</td>
						<td>${requestScope.jobbean.jobStartTime}</td>
						<td class="tr_top">结束时间</td>
						<td>${requestScope.jobbean.jobEndTime }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">职位描述</td>
						<td colspan="5">${requestScope.jobbean.jobDecribe }</td>
					</tr>
				</table>
			</div>
			<div class="info_reg top-space">
				<div class="title underLine" style="margin-left:50px">
					<span>企业基本信息</span>
				</div>

				<table class="info_table" cellspacing="0"
					style="margin-top: 20px; margin-left: 50px;">
					<tr align="center">
					<td class="tr_top" style="width: 120px;">企业名称</td>
					<td style="width: 120px;">${requestScope.entbean.entName }</td>
					<td class="tr_top" style="width: 120px;">所在区域</td>
					<td style="width: 120px;">${requestScope.entbean.communityAddr }</td>
					<td class="tr_top" style="width: 120px;">公司类型</td>
					<td style="width: 120px;">${requestScope.entbean.entType }</td>
					</tr>
					<tr align="center">
					<td class="tr_top" style="width: 120px;">Email</td>
					<td style="width: 120px;">${requestScope.entbean.entEmail }</td>
					<td class="tr_top" style="width: 120px;">邮政编码</td>
					<td style="width: 120px;">${requestScope.entbean.entPcode }</td>
					<td class="tr_top" style="width: 120px;">公司规模</td>
					<td style="width: 120px;">${requestScope.entbean.scaleName }</td>
					</tr>
					<tr align="center">
					<td class="tr_top" style="width: 120px;">企业类型</td>
					<td style="width: 120px;">${requestScope.entbean.entTypeTradeName }</td>
					<td class="tr_top" style="width: 120px;">联系人姓名</td>
					<td style="width: 120px;">${requestScope.entbean.entContactMan }</td>
					<td class="tr_top" style="width: 120px;">电话</td>
					<td style="width: 120px;">${requestScope.entbean.entContactPhone }</td>
					</tr>
					<tr align="center">
					<td class="tr_top" style="width: 120px;">公司详细地址</td>
					<td style="width: 120px;" colspan="5">${requestScope.entbean.entContactAddr }</td>
					</tr>
					<tr align="center">
					<td class="tr_top" style="width: 120px;">社保登记证扫描件</td>
					<td style="width: 120px;"><a href="${sessionScope.entbean.entCertUrlSer==null?'#': sessionScope.entbean.entCertUrlSer}">查看</a></td>
					<td class="tr_top" style="width: 120px;">机构代码扫描件</td>
					<td style="width: 120px;"><a href="${sessionScope.entbean.entCertUrlO==null?'#': sessionScope.entbean.entCertUrlO}">查看</a></td>
					<td class="tr_top" style="width: 120px;">营业执照扫描件</td>
					<td style="width: 120px;"><a href="${sessionScope.entbean.entCertUrlLicence==null?'#': sessionScope.entbean.entCertUrlLicence}">查看</a></td>
					</tr>
					<tr align="center">
					<td class="tr_top" style="width: 120px;">社保编号</td>
					<td style="width: 120px;">${requestScope.entbean.entSercurityNum }</td>
					<td class="tr_top" style="width: 120px;">机构代码</td>
					<td style="width: 120px;" colspan="3">${requestScope.entbean.entOCode }</td>
					</tr>

					<tr align="center">
					<td class="tr_top" style="width: 120px;">公司介绍</td>
					<td colspan="5">${requestScope.entbean.entContent }</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
