<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ree.admin.AdminAdapter,com.ree.list.ListAdapter,com.ree.community.communityAdapter"%>
<%
	ListAdapter la = new ListAdapter();
	request.setAttribute("la", la);
	communityAdapter ca = new communityAdapter(true);
	request.setAttribute("ca", ca);
	if(request.getParameter("adminNo")!=null){
		int adminNo = Integer.parseInt(request.getParameter("adminNo"));
		AdminAdapter aa=new AdminAdapter();
		request.setAttribute("aBean",aa.GetAdminBean_by_AdminNo(adminNo));
	}
%>
<link href="../css/altercomm.css" rel="stylesheet" type="text/css" />
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
.field{display: inline-block;
float: left;}
</style>
<div class="pageContent">
	<c:if test="${param.adminNo==null}">
		<form method="post"	action="AdminAction_AddAdmin" class="pageForm required-validate"	onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" id="adminlist" name="adminbean.adminList" value="" />
		<div class="pageFormContent" layoutH="56">
		<fieldset class="field">
		<legend>权限列表：</legend>
			<div class="treebox">
				<ul class="tree treeFolder treeCheck expand" oncheck="kkk">
					<c:forEach var="list" items="${requestScope.la.ReturnList_By_ListType(-1)}">
						<li><a tname="name" tvalue="${list.listNo }" >${list.listName }</a>	</li>
					</c:forEach>
				</ul>
			</div>
		</fieldset>
		<fieldset class="field">
		<legend>范围列表：</legend>
			<div class="treebox">
				<ul class="tree treeFolder collapse communities">
					<c:forEach var="community"
						items="${requestScope.ca.GetCommunities_By_father_id(0) }">
						<li><a level="1" data-addr="${community.communityAddr }"
							data-fathername="无" data-key="${community.communityNo }">${community.communityName }</a>
							<c:forEach var="community1"
								items="${requestScope.ca.GetCommunities_By_father_id(community.communityNo) }">
								<ul>
									<li><a level="2" data-addr="${community1.communityAddr }"
										data-fathername="${community.communityName }"
										data-key="${community1.communityNo }">${community1.communityName }</a>
										<c:forEach var="community2"
											items="${requestScope.ca.GetCommunities_By_father_id(community1.communityNo) }">
											<ul>
												<li><a level="3"
													data-addr="${community2.communityAddr }"
													data-fathername="${community1.communityName }"
													data-key="${community2.communityNo }">${community2.communityName }</a>
													<c:forEach var="community3"
														items="${requestScope.ca.GetCommunities_By_father_id(community2.communityNo) }">
														<ul>
															<li><a level="4"
																data-addr="${community3.communityAddr }"
																data-fathername="${community2.communityName }"
																data-key="${community3.communityNo }">${community3.communityName }</a>
																<c:forEach var="community4"
																	items="${requestScope.ca.GetCommunities_By_father_id(community3.communityNo) }">
																	<ul>
																		<li><a level="5"
																			data-addr="${community4.communityAddr }"
																			data-fathername="${community3.communityName }"
																			data-key="${community4.communityNo }">${community4.communityName }</a></li>
																	</ul>
																</c:forEach></li>
														</ul>
													</c:forEach></li>
											</ul>
										</c:forEach></li>
								</ul>
							</c:forEach></li>
					</c:forEach>
				</ul>
			</div>
		</fieldset>
			<p>
				<label>名称：</label> <input type="text" name="adminbean.adminName" size="30"  />
			</p>
			<p>
				<label>用户名：</label> <input type="text" size="30" name="adminbean.adminUid" />
			</p>
			<p>
				<label>密码：</label> <input type="text" size="30" name="adminbean.adminPwd" value="" />
			</p>
			<p>
				<label>范围权限：</label> <input type="text" size="30" id="adminrange"  readonly="readonly" name="adminbean.adminRange" value="" />
			</p>
		</div>
	</c:if>
	<c:if test="${param.adminNo!=null}">
		<form method="post"	action="AdminAction_AlterAdmin" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" id="adminlist" name="adminbean.adminList" value="${requestScope.aBean.adminList }" />
		<input type="hidden" name="adminbean.adminNo" value="${requestScope.aBean.adminNo}" />
		<div class="pageFormContent" layoutH="56">
			<fieldset class="field">
			<legend>权限列表：</legend>
				<div class="treebox">
					<ul class="tree treeFolder treeCheck expand" oncheck="kkk">
						<c:forEach var="list" items="${requestScope.la.ReturnList_By_ListType(-1)}">
							<li><a tname="name" tvalue="${list.listNo }" ${fn:contains(requestScope.aBean.adminList,list.listNo)?'checked=\"true\"':'' }>${list.listName }</a>
								<c:if test="${list.listNo==11}">
									<ul>
										<c:forEach var="list1" items="${requestScope.la.ReturnList_By_ListType(1)}">
											<%-- <li><a tname="fbname" tvalue="${list1.listNo }"  ${fn:contains(requestScope.aBean.adminList,list1.listNo)?'checked=\"true\"':'' }>${list1.listName }</a></li> --%>
											<%-- <li><a tname="fbname" tvalue="${list1.listNo }"  ${fn:contains(fn:split(requestScope.aBean.adminList,','),list1.listNo)?'checked=\"true\"':'' }>${list1.listName }</a></li> --%>
											 <li><a tname="fbname" tvalue="${list1.listNo }" 
												<c:forEach var="i" items="${fn:split(requestScope.aBean.adminList,',') }">
													<c:if test="${i==list1.listNo}">
														checked="true"
													</c:if>
												</c:forEach>
											>${list1.listName }</a></li>	
										</c:forEach>
									</ul>
								</c:if>
							</li>
						</c:forEach>
					</ul>
				</div>
			</fieldset>			
			<fieldset class="field">
				<legend>范围列表：</legend>
					<div class="treebox">
						<ul class="tree treeFolder collapse communities">
							<c:forEach var="community"
								items="${requestScope.ca.GetCommunities_By_father_id(0) }">
								<li><a level="1" data-addr="${community.communityAddr }"
									data-fathername="无" data-key="${community.communityNo }">${community.communityName }</a>
									<c:forEach var="community1"
										items="${requestScope.ca.GetCommunities_By_father_id(community.communityNo) }">
										<ul>
											<li><a level="2" data-addr="${community1.communityAddr }"
												data-fathername="${community.communityName }"
												data-key="${community1.communityNo }">${community1.communityName }</a>
												<c:forEach var="community2"
													items="${requestScope.ca.GetCommunities_By_father_id(community1.communityNo) }">
													<ul>
														<li><a level="3"
															data-addr="${community2.communityAddr }"
															data-fathername="${community1.communityName }"
															data-key="${community2.communityNo }">${community2.communityName }</a>
															<c:forEach var="community3"
																items="${requestScope.ca.GetCommunities_By_father_id(community2.communityNo) }">
																<ul>
																	<li><a level="4"
																		data-addr="${community3.communityAddr }"
																		data-fathername="${community2.communityName }"
																		data-key="${community3.communityNo }">${community3.communityName }</a>
																		<c:forEach var="community4"
																			items="${requestScope.ca.GetCommunities_By_father_id(community3.communityNo) }">
																			<ul>
																				<li><a level="5"
																					data-addr="${community4.communityAddr }"
																					data-fathername="${community3.communityName }"
																					data-key="${community4.communityNo }">${community4.communityName }</a></li>
																			</ul>
																		</c:forEach></li>
																</ul>
															</c:forEach></li>
													</ul>
												</c:forEach></li>
										</ul>
									</c:forEach></li>
							</c:forEach>
						</ul>
					</div>
			</fieldset>
			<p>
				<label>序号：</label> <input type="text" size="30" readonly="readonly" value="${requestScope.aBean.adminNo}"/>
			</p>
			<p>
				<label>名称：</label> <input type="text" size="30" name="adminbean.adminName"  value="${requestScope.aBean.adminName}"/>
			</p>
			<p>
				<label>用户名：</label> <input type="text" size="30" name="adminbean.adminUid" value="${requestScope.aBean.adminUid}"/>
			</p>
			<p>
				<label>修改密码：</label> <input type="text" size="30" name="adminbean.adminPwd" value="" alt="此处输入则修改密码"/>
			</p>
			<p>
				<label>范围权限：</label> <input type="text" size="30" id="adminrange"  readonly="readonly" name="adminbean.adminRange" value="${requestScope.aBean.adminRange}" />
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
<script type="text/javascript">
function kkk(){
	var json = arguments[0], result="",value=[];
	//$(json.items).each(function(i){
	//	 value.push(this.value); 
		/* result +=a.value+',';  */
		//result += "<p>name:"+this.name + " value:"+this.value+" text: "+this.text+"</p>";
	//	 value.push(result);
	//});	
	//console.log(result);
	$('#adminlist').val($.map(json.items,function(e,i){return e.value}).join(','));
}
</script>
<script type="text/javascript" src="./scripts/AdminListContent.js"></script>