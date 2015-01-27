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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pageContent">
		<div class="pageFormContent" layoutH="58">
			<!-- <ul class="tree expand">
				
				<li><a href="javascript:">上海 </a>
					<ul>
						<li><a href="javascript:" onclick="$.bringBack({userAddrName:'崇明', cityName:'上海'})">崇明</a></li>
						<li><a href="javascript:" onclick="$.bringBack({districtName:'黄浦', cityName:'上海'})">黄浦</a></li>
					</ul>
				</li>
			</ul> -->
			<ul class="tree expand">
					<c:forEach var="community" items="${requestScope.ca.GetCommunities_By_father_id(0) }">
						<c:if test="${sessionScope.admin_type==1}">
							<li><c:if test="${fn:contains(sessionScope.admin_range,community.communityName) }">
									<a href="javascript:" onclick="$.bringBack({userAddrName:'${community.communityAddr }'})">${community.communityName }</a>															
										<c:forEach var="community1"	items="${requestScope.ca.GetCommunities_By_father_id(community.communityNo) }">
											<ul>
												<li><c:if test="${fn:contains(sessionScope.admin_range,community1.communityName) }">	
												<a href="javascript:" onclick="$.bringBack({userAddrName:'${community1.communityAddr }'})">${community1.communityName }</a>
													<c:forEach var="community2" items="${requestScope.ca.GetCommunities_By_father_id(community1.communityNo) }">
														<ul>
															<c:choose>
															<c:when test="${fn:contains(community1.communityAddr,sessionScope.admin_range) }">
																<li>
																<a href="javascript:" onclick="$.bringBack({userAddrName:'${community2.communityAddr }'})">${community2.communityName }</a>
																	<c:forEach var="community3"	items="${requestScope.ca.GetCommunities_By_father_id(community2.communityNo) }">
																		<ul>
																			<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community3.communityAddr }'})">${community3.communityName }</a>
																				<c:forEach var="community4"	items="${requestScope.ca.GetCommunities_By_father_id(community3.communityNo) }">
																					<ul>
																						<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community4.communityAddr }'})">${community4.communityName }</a></li>
																					</ul>
																				</c:forEach></li>
																		</ul>
																	</c:forEach>
																</li>	
															</c:when>
															<c:otherwise>
															<li><c:if test="${fn:contains(sessionScope.admin_range,community2.communityName) }">	
																	<a href="javascript:" onclick="$.bringBack({userAddrName:'${community2.communityAddr }'})">${community2.communityName }</a>
																	<c:forEach var="community3"	items="${requestScope.ca.GetCommunities_By_father_id(community2.communityNo) }">
																		<ul>
																			<c:choose>
																				<c:when test="${fn:contains(community2.communityAddr,sessionScope.admin_range) }">
																					<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community3.communityAddr }'})">${community3.communityName }</a>
																						<c:forEach var="community4"	items="${requestScope.ca.GetCommunities_By_father_id(community3.communityNo) }">
																							<ul>
																								<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community4.communityAddr }'})">${community4.communityName }</a></li>
																							</ul>
																						</c:forEach>
																					</li>
																				</c:when>
																				<c:otherwise>
																					<li><c:if test="${fn:contains(sessionScope.admin_range,community3.communityName) }">
																					<a href="javascript:" onclick="$.bringBack({userAddrName:'${community3.communityAddr }'})">${community3.communityName }</a>
																						<c:forEach var="community4"	items="${requestScope.ca.GetCommunities_By_father_id(community3.communityNo) }">
																							<ul>
																								<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community4.communityAddr }'})">${community4.communityName }</a></li>
																							</ul>
																						</c:forEach>
																						</c:if>
																					</li>
																				</c:otherwise>
																			</c:choose>																			
																		</ul>
																	</c:forEach>
																</c:if>
															</li>
															</c:otherwise>
															</c:choose>															
														</ul>
													</c:forEach>
													</c:if>
												</li>
											</ul>
										</c:forEach>									
								</c:if>
							</li>
						</c:if>
						<c:if test="${sessionScope.admin_type==0}">					
							<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community.communityAddr }'})">${community.communityName }</a>
								<c:forEach var="community1"	items="${requestScope.ca.GetCommunities_By_father_id(community.communityNo) }">
									<ul>
										<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community1.communityAddr }'})">${community1.communityName }</a>
											<c:forEach var="community2" items="${requestScope.ca.GetCommunities_By_father_id(community1.communityNo) }">
												<ul>
													<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community2.communityAddr }'})">${community2.communityName }</a>
														<c:forEach var="community3"	items="${requestScope.ca.GetCommunities_By_father_id(community2.communityNo) }">
															<ul>
																<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community3.communityAddr }'})">${community3.communityName }</a>
																	<c:forEach var="community4"	items="${requestScope.ca.GetCommunities_By_father_id(community3.communityNo) }">
																		<ul>
																			<li><a href="javascript:" onclick="$.bringBack({userAddrName:'${community4.communityAddr }'})">${community4.communityName }</a></li>
																		</ul>
																	</c:forEach></li>
															</ul>
														</c:forEach></li>
												</ul>
											</c:forEach></li>
									</ul>
								</c:forEach></li>
							</c:if>							
							
					</c:forEach>
				</ul>
		</div>		
		<div class="formBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
			</ul>
		</div>
  </div>
</body>
</html>