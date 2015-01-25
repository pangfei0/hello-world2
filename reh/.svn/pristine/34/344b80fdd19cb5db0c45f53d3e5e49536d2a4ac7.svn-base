<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ree.dict.DictAdapter,com.ree.community.communityAdapter"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	//用户状态：0-用户；1-企业
	DictAdapter da = new DictAdapter();
	communityAdapter ca = new communityAdapter();
	request.setAttribute("da", da);
	request.setAttribute("ca", ca);
	//RepUserInfo userbean;
	String title = null;//地图
	if (session.getAttribute("userbean") != null) {
		//已登陆	-登记
		//userbean = (RepUserInfo) session.getAttribute("userbean");
		request.setAttribute("userbean",
				session.getAttribute("userbean"));
	} else if (request.getParameter("u_type") != null) {
		request.setAttribute("u_type", request.getParameter("u_type"));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页-申请与登记</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<jsp:include page="tree.jsp" />
<script type="text/javascript" src="./scripts/registerAndModify/registerAndModify.jsp"></script>
<script type="text/javascript" src="./scripts/registerAndModify/certValication.js"></script>
<style type="">
.addrTree,addrTree2 {
	margin-left: 35px;
}
label.addrTree,label.addrTree2{
color:red;}
span.addByNow,span.delByNow{
font-weight: bold;
font-size: 17px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>首页-申请与登记</span>
			</div>
			<div class="apply">
				<c:choose>
					<c:when test="${sessionScope.u_type == 0 &&!requestScope.u_type}">
						<!-- 用户登记表单 start -->
						<form action="UserAction_Modify" method="post">
							<div class="apply_item">
								<div class="apply_tag">
									姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="userbean.userName"
										value="${sessionScope.userbean.userName }" class="tag_input" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别： <span>*</span>
								</div>
								<div class="apply_input">
									<label style="margin-left:50px;">男：</label><input
										style="width: auto;margin-left:20px;" name="userbean.userSex"
										type="radio"
										${sessionScope.userbean.userSex==null?"checked='checked'":'' }
										${sessionScope.userbean.userSex=='男'?"checked='checked'":'' }
										value="男" /><label style="margin-left:30px;">女：</label><input
										style="width:auto;margin-left:20px;" name="userbean.userSex"
										type="radio"
										${sessionScope.userbean.userSex=='女'?'checked=\"checked\"':''}
										value="女" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="userbean.userEmail"
										value="${sessionScope.userbean.userEmail }" class="tag_input" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									身份证号： <span>*</span>
								</div>
								<div class="apply_input">
									<input id="card_no" name="userbean.userCert" onBlur='javascript:checktheform();'
										value="${sessionScope.userbean.userCert }" class="tag_input" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;籍： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="userbean.userResidence"
										value="${sessionScope.userbean.userResidence }"
										class="tag_input" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									意向工作区域： <span>*</span>
								</div>
								<div class="apply_input">
									<input type="hidden" name="userbean.userIntentDisNo"
										value="${sessionScope.userbean.userIntentDisNo }"
										class="addrTree2" /> <label
										style="width: 224px;display: block;margin-left:50px"
										class="addrTree2"> <c:forEach var="no"
											items="${fn:split(sessionScope.userbean.userIntentDisNo,',') }">
										${requestScope.ca.GetIntentAddr_By_No(no).intentAddrName}
										</c:forEach> - 请点击并选择
									</label>
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									所属街道序号： <span>*</span>
								</div>
								<div class="apply_input">
									<input type="hidden" name="userbean.userAddrDisNo"
										value="${sessionScope.userbean.userAddrDisNo }"
										class="addrTree" /> <label
										style="width: 224px;display: block;margin-left:50px"
										class="addrTree">${requestScope.ca.GetCommunityBean_By_id(sessionScope.userbean.userAddrDisNo).communityAddr
										} - 请点击并选择</label>
									<!-- <div id="treeview"  style="position: relative;bottom: 50px;right: 100px;float: right;"></div> -->
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									家庭地址： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="userbean.userAddrPos"
										value="${sessionScope.userbean.userAddrPos }"
										class="tag_input" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历： <span>*</span>
								</div>
								<div class="apply_input">
									<select name="userbean.userEducationNo" class="tag_input">
										<c:forEach var="dict"
											items="${requestScope.da.GetEducationDict() }">
											<option value="${dict.educationDictNo }"
												${sessionScope.userbean.userEducationNo==dict.educationDictNo?'selected':''}>${dict.educationDictName
												}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									工作经验： <span>*</span>
								</div>
								<div class="apply_input">
									<select name="userbean.userExpNo" class="tag_input">
										<c:forEach var="dict" items="${requestScope.da.GetExpDict() }">
											<option value="${dict.jobExpDictNo }"
												${sessionScope.userbean.userExpNo==dict.jobExpDictNo?'selected':''}>${dict.jobExpDictName
												}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									主求职意向： <span>*</span>
								</div>
								<div class="apply_input">
									<div style="float:left;">
										<label style="margin-left:50px;">行业：</label> <select
											class="intentType" style="width: 100px;">
											<c:forEach var="dict"
												items="${requestScope.da.GetIntentionDictDistinct() }">
												<option
													${da.GetIntentionDictType_By_No(fn:split(sessionScope.userbean.userIntention,',')[0])==dict.jobIntentionDictType?'selected':''}>
													${dict.jobIntentionDictType}</option>
											</c:forEach>
										</select> <label style="margin-left:30px;">职业：</label> <select
											class="intentJob" style="width: 100px;"
											name="userbean.userIntention">
										</select>
									</div>
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									次求职意向： <span>*</span>
								</div>
								<div class="apply_input">
									<div style="float:left">
										<label style="margin-left:50px;">行业：</label><select
											class="intentType" style="width: 100px;">
											<c:forEach var="dict"
												items="${requestScope.da.GetIntentionDictDistinct() }">
												<option
													${da.GetIntentionDictType_By_No(fn:split(sessionScope.userbean.userIntention,',')[1])==dict.jobIntentionDictType?'selected':''}>
													${dict.jobIntentionDictType}</option>
											</c:forEach>
										</select> <label style="margin-left:30px;">职业：</label> <select
											class="intentJob" style="width: 100px;"
											name="userbean.userIntention">

										</select>
									</div>
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									联系电话： <span>*</span>
								</div>
								<div class="apply_input">
									<input onkeyup="this.value=this.value.replace(/[^\d-]+/g,'')" onafterpaste="this.value=this.value.replace(/[^\d-]+/g,'')"
									 name="userbean.userPhone"
										value="${sessionScope.userbean.userPhone}" class="tag_input" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄： <span>*</span>
								</div>
								<div class="apply_input">
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
									 name="userbean.userAge"
										value="${sessionScope.userbean.userAge}" class="tag_input" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="userbean.userSkill"
										value="${sessionScope.userbean.userSkill}" class="tag_input" />
								</div>
							</div>
							<div class="apply_item" style="min-height: 40px; height:auto;">
								<div class="apply_tag">
									履&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历： <span>*</span>
								</div>
								<div class="apply_input">
									<div class="byNow group">
										<c:choose>
											<c:when test="${sessionScope.userbean.userBynow!=null }">
												<c:forEach var="v"
													items="${fn:split(sessionScope.userbean.userBynow,'■') }"
													varStatus="s">
													<div class="byNow" >
													<span class="addByNow">+</span>
														<input name="byNowStartTime"
															value="${fn:split(v,'★')[0] }"
															style="width: 100px;margin-bottom: 5px" type="text"
															onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
															class="Wdate" />- <input name="byNowEndTime"
															value="${fn:substring(v,fn:indexOf(v,'★')+1,fn:indexOf(v,'☆')) }"
															type="text" style="width: 100px;margin-bottom: 5px"
															onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
															class="Wdate" /> 内容：<input name="byNowContent"
															value="${fn:split(v,'☆')[1] }"
															style="width: 120px;margin-bottom: 5px" />
													</div>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<div class="byNow" style="float: left;">
												<span class="addByNow"></span>
													<input name="byNowStartTime" style="width: 100px; margin-left: 50px;margin-bottom: 5px"
														type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
														class="Wdate" />- <input name="byNowEndTime" type="text"
														style="width: 100px;margin-bottom: 5px"
														onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
														class="Wdate" /><br> <span
														style="height:25px;line-height:25px;margin-bottom: 5px">
															内容：</span> <input name="byNowContent"
														style="width: 120px;margin-bottom: 5px" />
												</div>
											</c:otherwise>
										</c:choose>
									</div>
									<s:fielderror key="err" theme="simple" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									个人简历： <span>*</span>
								</div>
							</div>
							<div class="center">
								<textarea class="editor required" rows="12" cols="80"
									upLinkUrl="uploadfile" upLinkExt="zip,rar,doc,docx"
									upImgUrl="uploadfile" upImgExt="jpg,jpeg,gif,png"
									upFlashUrl="upload.php" upFlashExt="swf"
									upMediaUrl="upload.php" upMediaExt="avi"
									name="userbean.userContent">${sessionScope.userbean.userContent }</textarea>
							</div>
							<div class="center">
								<input type="submit" value="保存" class="submit_btn"
									onclick="return(confirm('確定保存吗？'))" /> <input type="reset"
									style="margin-left:50px" value="取消" class="submit_btn" />
							</div>
						</form>
						<!-- 用户登记表单 end -->
					</c:when>
					<c:when test="${sessionScope.u_type == 1 &&!requestScope.u_type}">
						<!-- 企业登记表单 start -->
						<form action="EntAction_Modify" method="post" enctype="multipart/form-data">
							<div class="info_reg">
								<div class="title underLine">
									<span>企业基本信息</span>
								</div>
								<div class="info_left">
									<div class="tag">
										<div class="tag_title">企业名称</div>
										<input name="entBean.entName"
											value="${sessionScope.entbean.entName }" class="tag_input" />
									</div>
									<div class="tag">
										<div class="tag_title">企业类型</div>
										<select style="margin-left: 50px;" name="entBean.entTypeTrade">
											<c:forEach var="dict"
												items="${requestScope.da.GetTradeDict() }">
												<option value="${dict.tradeNo }"
													${sessionScope.entbean.entTypeTrade==dict.tradeNo?'selected':''}>${dict.tradeName
													}</option>
											</c:forEach>
										</select>
									</div>

								</div>
								<div class="info_right">
									<div class="tag">
										<div class="tag_title">所在区域</div>
										<input type="hidden" name="entBean.entAddrDisNo"
											value="${sessionScope.entbean.entAddrDisNo }"
											class="addrTree" /> <label style="margin-left:50px;"
											class="addrTree">${requestScope.ca.GetCommunityBean_By_id(sessionScope.entbean.entAddrDisNo).communityAddr
											} - 请点击并选择</label>
										<!-- <div id="treeview"></div> -->
									</div>
									
									<div class="tag">
										<div class="tag_title">公司规模</div>
										<select style="margin-left: 50px;" name="entBean.entScaleNo">
											<c:forEach var="dict"
												items="${requestScope.da.GetScaleDict() }">
												<option value="${dict.scaleNo }"
													${sessionScope.entbean.entScaleNo==dict.scaleNo?'selected':''}>${dict.scaleName
													}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="info_reg" style="margin-top: 20px;">
									<div class="title underLine">
										<span>联系信息</span>
									</div>
									<div class="info_left">
										<div class="tag">
											<div class="tag_title">联系人姓名</div>
											<input style="margin-left: 36px; float: left;"
												name="entBean.entContactMan"
												value="${sessionScope.entbean.entContactMan }"
												class="tag_input" />
										</div>
										<div class="tag">
											<div class="tag_title">Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
											<input name="entBean.entEmail" style="margin-left:49px;"
												value="${sessionScope.entbean.entEmail }" class="tag_input" />
										</div>
										<div class="tag">
										<div class="tag_title">邮政编码</div>
										<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
										 name="entBean.entPcode"
											value="${sessionScope.entbean.entPcode }" class="tag_input" />
									</div>
									</div>
									<div class="info_right">
										<div class="tag">
											<div class="tag_title">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</div>
											<input onkeyup="this.value=this.value.replace(/[^\d-]+/g,'')" onafterpaste="this.value=this.value.replace(/[^\d-]+/g,'')"
											 name="entBean.entContactPhone"
												value="${sessionScope.entbean.entContactPhone }"
												class="tag_input" />
										</div>
										<div class="tag">
											<div class="tag_title">公司地址</div>
											<input name="entBean.entContactAddr"
												value="${sessionScope.entbean.entContactAddr }"
												class="tag_input" />
										</div>
									</div>
								</div>
								<div class="info_reg" style="margin-top: 20px;">
									<div class="title underLine">
										<span>企业证明</span>
									</div>
									<div class="info_left">
										<div class="tag">
											<div class="tag_title">社保编号</div>
											<input name="entBean.entSercurityNum"
												value="${sessionScope.entbean.entSercurityNum }"
												class="tag_input" />
										</div>
										<div class="tag">
											<div class="tag_title">机构代码</div>
											<input name="entBean.entOCode" value="${sessionScope.entbean.entOCode }" class="tag_input" />
										</div>
										<div class="tag">
											<div class="tag_title">营业执照扫描件</div>
											<input type="file" name="entCertUrlLicence" style="margin-left: 16px;width:170px;" class="tag_input" />
											<a style="float: left;" href="${sessionScope.entbean.entCertUrlLicence==null?'#': sessionScope.entbean.entCertUrlLicence}">查看</a>
										</div>
									</div>
									<div class="info_right">
										<div class="tag">
											<div class="tag_title">社保登记证扫描件</div>
											<input type="file" name="entCertUrlSer" style="margin-left: 10px;width:165px;" class="tag_input" />
											<a href="${sessionScope.entbean.entCertUrlSer==null?'#': sessionScope.entbean.entCertUrlSer}">查看</a>
										</div>
										<div class="tag">
											<div class="tag_title">机构代码扫描件</div>
											<input type="file" name="entCertUrlO" style="margin-left: 24px;width:165px;" class="tag_input" />
											<a href="${sessionScope.entbean.entCertUrlO==null?'#': sessionScope.entbean.entCertUrlO}">查看</a>
										</div>
									</div>
								</div>
								<div class="info_reg" style="margin-top: 20px;">
									<div class="title underLine">
										<span>企业介绍</span>
									</div>
									<div  style="padding-top: 20px;padding-left:90px ">
								<textarea class="editor required" rows="12" cols="100"
									upLinkUrl="uploadfile" upLinkExt="zip,rar,doc,docx"
									upImgUrl="uploadfile" upImgExt="jpg,jpeg,gif,png"
									upFlashUrl="upload.php" upFlashExt="swf"
									upMediaUrl="upload.php" upMediaExt="avi"
									name="entBean.entContent">${sessionScope.entbean.entContent }</textarea>
							</div>
								</div>
							</div>
							<input type="submit" value="提交" class="submit_btn"
								style="float: right;margin-right: 30px" onclick="return(confirm('確定吗？'))" />
						</form>
						<!-- 企业登记表单 end -->
					</c:when>
					<c:when test="${requestScope.u_type==0 }">
						<!-- 用户注册表单 start -->
						<form action="UserAction_Register" method="post">
							<div class="apply_item">
								<div class="apply_tag">
									用户名： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="USER_UID" type="text" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="USER_PWD" type="password" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									确认密码： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="USER_PWD1" type="password" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="USER_NAME" type="text" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别： <span>*</span>
								</div>
								<div class="apply_input">
									<label style="margin-left:30px">男：</label><input
										style="width: auto;margin-left:10px" name="USER_SEX"
										type="radio" value="男" checked="checked" /><label
										style="margin-left: 50px">女：</label><input
										style="width: auto;margin-left:10px" name="USER_SEX"
										type="radio" value="女" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="USER_EMAIL" type="text" />
								</div>
							</div>
							<div class="apply_item"><s:fielderror key="err" theme="simple" /></div>
							
							<div class="center">
								<input type="submit" value="注册" class="submit_btn"
									onclick="return(confirm('確定注册吗？'))" />
							</div>
						</form>
						<!-- 用户注册表单 end -->
					</c:when>
					<c:when test="${requestScope.u_type==1 }">
						<!-- 企业注册表单 start -->
						<form name="entModify" action="EntAction_Register"
							method="post" theme="simple">
							<div class="apply_item">
								<div class="apply_tag">
									企业名称： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="entBean.entName" type="text" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									用户名： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="entBean.entUid" type="text" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码： <span>*</span>
								</div>
								<div class="apply_input">
									<input name="entBean.entPwd" type="password" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									电子邮件： <span>*</span>
								</div>
								<div class="apply_input">
									<input type="text" name="entBean.entEmail" />
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									企业类型： <span>*</span>
								</div>
								<div class="apply_input">
									<select name="entBean.entTypeTrade" style="margin-left:0px">
										<c:forEach var="dict" items="${requestScope.da.GetTradeDict() }">
												<option value="${dict.tradeNo }"
													${sessionScope.entbean.entTypeTrade==dict.tradeNo?'selected':''}>${dict.tradeName }
												</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="apply_item">
								<div class="apply_tag">
									所属街道： <span>*</span>
								</div>
								<div class="apply_input">
									<input type="hidden" name="entBean.entAddrDisNo" value=""
										class="addrTree" /> <label class="addrTree">请点击并选择</label>
									<!-- <div id="treeview"></div>  -->
								</div>
							</div>

							<s:fielderror key="err" theme="simple" />
							<div class="center">
								<input type="submit" value="申  请" class="submit_btn" />
							</div>
						</form>
						<!-- 企业注册表单 end -->
					</c:when>
					<c:otherwise>
						<span style="margin-left: 80px; font-size: 22px;">您还未登录，请先登录！！！</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>