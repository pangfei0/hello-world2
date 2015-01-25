<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ree.user.UserAdapter,com.ree.dict.DictAdapter,com.ree.community.communityAdapter"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
UserAdapter ua = new UserAdapter();
DictAdapter da = new DictAdapter();
communityAdapter ca = new communityAdapter();
request.setAttribute("da", da);
request.setAttribute("ca", ca);
if(request.getParameter("userNo")!=null){
	int userNo = Integer.parseInt(request.getParameter("userNo"));
	request.setAttribute("userbean", ua.GetUserView_By_UserNo(userNo));
	if(request.getParameter("htid")!=null){
		request.setAttribute("htid",Integer.parseInt(request.getParameter("htid")));
	}
}
if(request.getParameter("jobNo")!=null&&request.getParameter("userNo")!=null){
	int userNo = Integer.parseInt(request.getParameter("userNo"));
	int jobNo = Integer.parseInt(request.getParameter("jobNo"));
	//request.setAttribute("recruitbean", ua.GetEntJobUserView_By_Job_No(jobNo));
	request.setAttribute("recruitbean", ua.GetEntJobView_By_userNo_jobNo(userNo,jobNo));
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简历与跟踪</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<script>
	$(
			function() {
				//初始化
				$('.stateChange input:radio').change(
						function(e) {
							if (!!($(this).closest('div').find(
									'input:radio:checked').val() === '1'))
								$(this).siblings('input:text').show();
							else
								$(this).siblings('input:text').hide();
						})
			})
</script>
<style>
div.stateChange {
	float: left;
}
</style>
</head>
<body>
	<c:if test="${htid!=1}"><!-- htid=1是当华天从后台查看用户详细简历的时候 -->
	<jsp:include page="header.jsp" />
	</c:if>
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>简历与跟踪</span>
			</div>

			<div class="info_reg top-space">
				<div class="title underLine" style="margin-left:50px">
					<span>人员基本信息</span>
				</div>

				<table class="info_table" cellspacing="0"
					style="margin-top: 20px; margin-left: 50px;">
					<tr align="center">
						<td class="tr_top" style="width: 120px;">姓名</td>
						<td style="width: 120px;">${requestScope.userbean.userName }</td>
						<td class="tr_top" style="width: 120px;">性别</td>
						<td style="width: 120px;">${requestScope.userbean.userSex }</td>
						<td class="tr_top" style="width: 120px;">年龄</td>
						<td style="width: 120px;">${requestScope.userbean.userAge }</td>
					</tr>
					<tr align="center">
						<td class="tr_top" style="width: 120px;">工作经验</td>
						<td style="width: 120px;">${requestScope.userbean.jobExpDictName
							}</td>
						<td class="tr_top" style="width: 120px;">求职意向</td>
						<td colspan="3" style="width: 120px;">
						${da.GetIntentionStr_By_Str(requestScope.userbean.userIntention) }
						<%-- 
						${da.GetIntentionStr_By_No(fn:split(requestScope.userbean.userIntention,',')[0])}
						${da.GetIntentionStr_By_No(fn:split(requestScope.userbean.userIntention,',')[1])} --%>
						<%-- <c:set value="${da.GetIntentionItem_By_No(fn:split(requestScope.userbean.userIntention,',')[0])}" var="bean" /> 
						<c:out value="${bean.jobIntentionDictType} - ${bean.jobIntentionDictName }" />
						<c:set value="${da.GetIntentionItem_By_No(fn:split(requestScope.userbean.userIntention,',')[1])}" var="bean" /> 
						<c:out value="${bean.jobIntentionDictType} - ${bean.jobIntentionDictName }" /> --%>
						</td>
					</tr>
					<tr align="center">
						<td class="tr_top">应聘岗位</td>
						<td>${requestScope.recruitbean.jobName }</td>
						<td class="tr_top">户籍</td>
						<td>${requestScope.userbean.userResidence }</td>
						<td class="tr_top">所属街道</td>
						<td>${requestScope.userbean.userAddrName }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">身份证</td>
						<td colspan="3">${requestScope.userbean.userCert }</td>
						<td class="tr_top">意向求职区域</td>
						<td><c:forEach var="no"
								items="${fn:split(requestScope.userbean.userIntentDisNo,',') }">
							${requestScope.ca.GetIntentAddr_By_No(no).intentAddrName} -
						</c:forEach></td>
					</tr>
					<tr align="center">
						<td class="tr_top">家庭地址</td>
						<td colspan="5">${requestScope.userbean.userAddrPos }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">专长</td>
						<td colspan="5">${requestScope.userbean.userSkill }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">学历</td>
						<td colspan="5">${requestScope.userbean.educationDictName }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">联系方式</td>
						<td colspan="5">${requestScope.userbean.userPhone }</td>
					</tr>
					<tr align="center">
						<td class="tr_top">履历</td>
						<td colspan="5"><c:if
								test="${sessionScope.userbean.userBynow!=null }">
								<c:forEach var="v"
									items="${fn:split(requestScope.userbean.userBynow,'■') }"
									varStatus="s">
									<p class="byNow">${fn:split(v,'★')[0] }-
										${fn:substring(v,fn:indexOf(v,'★')+1,fn:indexOf(v,'☆')) }
										:${fn:split(v,'☆')[1] }</p>
								</c:forEach>
							</c:if></td>
					</tr>
					<tr align="center">
						<td class="tr_top">个人简历</td>
						<td colspan="5">
							<div style="overflow: auto;max-width: 750px;">
								${requestScope.userbean.userContent }</div>
						</td>
					</tr>
				</table>
			</div>
			<c:if test="${requestScope.recruitbean!=null }">
				<!-- 就业跟踪信息 只读部分 start -->
				<div class="info_reg top-space">
					<div class="title underLine" style="margin-left: 50px">
						<span>就业跟踪信息</span>
					</div>

					<table class="info_table" cellspacing="0"
						style="margin-top: 20px; margin-left: 50px;">
						<tr class="tr_top" align="center">
							<td style="width: 100px;">回复状态</td>
							<td style="width: 100px;">面试时间</td>
							<td style="width: 100px;">试用时间</td>
							<td style="width: 100px;">正式上岗时间</td>
							<td style="width: 100px;">签订合同时间</td>
						</tr>
						<tr align="center">
							<td>${requestScope.recruitbean.stateName }</td>
							<td>${requestScope.recruitbean.auditiontime }</td>
							<td>${requestScope.recruitbean.trytime }</td>
							<td>${requestScope.recruitbean.membertime }</td>
							<td>${requestScope.recruitbean.contracttime }</td>
						</tr>
					</table>
				</div>
				<!-- 就业跟踪信息 只读部分 end -->
				<c:if
					test="${sessionScope.u_type==1&&param.jobNo!=null&&sessionScope.entbean.entNo==requestScope.recruitbean.entNo }">
					<!-- 就业跟踪信息 修改部分 start -->
					<form action="AuditionAction_stateChange" method="post"
						style="float:left;">
						<input type="hidden" name="jobbean.userNo"
							value="${param.userNo }" /> <input type="hidden"
							name="jobbean.jobNo" value="${param.jobNo }" />
						<div style="margin-left:50px;">
							<c:if test="${requestScope.recruitbean.state==2 }">
								<!-- 已录用 start -->
								<div class="stateChange" style="font-size: 15px">
									<span>确认试用：</span><label style="margin-left:20px;"> 否：</label><input type="radio" name="state2to4"
										checked="checked" value="0" /> <label style="margin-left:30px;">是：</label><input type="radio"
										name="state2to4" value="1" /> <label style="margin-left:40px;">试用时间：</label><input
										name="jobbean.trytime" style="display:none;" type="text"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										class="Wdate" value="${requestScope.recruitbean.trytime }" />
								</div>
								<br />
								<!-- 已录用end -->
							</c:if>
							<c:if test="${requestScope.recruitbean.state==4 }">
								<!-- 已试用 start -->
								<div class="stateChange" style="font-size: 15px">
									<span>确认转正：</span><label style="margin-left:20px;"> 否：</label><input type="radio" name="state4to5"
										checked="checked" value="0" /><label style="margin-left:30px;">是：</label><input type="radio"
										name="state4to5" value="1" />  <label style="margin-left:40px;">转正时间：</label><input
										name="jobbean.membertime" style="display:none;" type="text"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										class="Wdate" value="${requestScope.recruitbean.membertime }" />
								</div>
								<br />
								<!-- 已试用 end -->
							</c:if>
							<c:if test="${requestScope.recruitbean.state==5 }">
								<!-- 已签订合同 start -->
								<div class="stateChange" style="font-size: 15px">
									<span>确认签订合同：</span><label style="margin-left:20px;"> 否：</label><input type="radio" name="state5to6"
										checked="checked" value="0" /><label style="margin-left:30px;">是：</label><input type="radio"
										name="state5to6" value="1" /> <label style="margin-left:40px;">签订合同时间：</label><input
										name="jobbean.contracttime" style="display:none;" type="text"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
										class="Wdate"
										value="${requestScope.recruitbean.contracttime }" />
								</div>
								<br />
								<!-- 已签订合同 end -->
							</c:if>

							<br /> <input class="submit_btn" type="submit" value="提交" />
						</div>
					</form>
					<br />${requestScope.sc}
					<!-- 就业跟踪信息 修改部分 end -->
				</c:if>
			</c:if>
		</div>
	</div>
	<c:if test="${htid!=1}"><!-- htid=1是当华天从后台查看用户详细简历的时候 -->
	<jsp:include page="footer.jsp" />
	</c:if>
</body>
</html>
