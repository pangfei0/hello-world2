<%@page import="com.ree.community.communityAdapter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ree.community.communityAdapter"%>
<%
	communityAdapter ca = new communityAdapter(true);
	request.setAttribute("ca", ca);
%>
<link href="../css/altercomm.css" rel="stylesheet" type="text/css" />
<script>
	
</script>
<h2 class="contentTitle">街道-社区-小区信息维护</h2>
<div class="pageContent">
	<!-- <form method="post" action="CommunityAction"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this)"> -->
	<form method="post" action="communityAction" class="pageForm required-validate"	onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="actionmethod" id="actionmethod" value="" />
		<input type="hidden" name="id" id="alterid" value="" /> 
		<input type="hidden" name="newlevel" id="newlevel" value="1" /> 
		<input type="hidden" name="newfatherid" id="newfatherid" value="0" />
		<div class="pageFormContent" layoutH="96">
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
			<p>
				<label>类 型：</label> <input name="txttype" id="txttype" type="text"
					readonly="readonly" size="30" value="" />
			</p>
			<p>
				<label>从属于：</label> <input name="txtfather_name" id="txtfather_name"
					type="text" readonly="readonly" size="30" value="" />
			</p>
			<p>
				<label>名 称：</label> <input name="txtname" id="txtname"
					class="required" type="text" size="30" value="" />
			</p>
			<p>
				<label>地 址：</label> <input id="txtaddr"
					readonly="readonly"  class="required" type="text" size="30" value="" />
			</p>

		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">修改</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="addbtn">添加</button>
						</div>
					</div></li>
				<li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="delbtn">删除</button>
						</div>
					</div></li>
				
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript" src="scripts/AlterComm.js"></script>