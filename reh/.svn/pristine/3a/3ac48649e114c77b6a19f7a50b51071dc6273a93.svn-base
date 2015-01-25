<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="./scripts/intention.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.ree.user.UserAdapter,java.util.List,com.ree.dict.DictAdapter,com.ree.list.ListAdapter,java.util.List,com.ree.news.NewsAdapter,com.ree.admin.AdminAdapter"%>
<%
if(session.getAttribute("admin_uid")==null)
	response.sendRedirect("LoginAction");
if("4".equals(request.getParameter("tid")))
{
	ListAdapter la = new ListAdapter();
	request.setAttribute("la", la);
}
if("1".equals(request.getParameter("tid")))
{
    NewsAdapter na = new NewsAdapter();
    request.setAttribute("nBean", na.GetNewsItem_By_NewsId(1));
}
%>

<c:if test="${param.tid==3}">
	<%@ page
		import="com.ree.train.TrainAdapter,com.ree.dict.DictAdapter,java.util.List,com.ree.news.NewsAdapter,com.ree.hibernate.RepUserInfo"%>
	<%
			NewsAdapter na = new NewsAdapter();
			TrainAdapter ta = new TrainAdapter();
			int list_id = Integer.parseInt(request.getParameter("list_id"));
			request.setAttribute("list_id", list_id);
			int tid = Integer.parseInt(request.getParameter("tid"));
			request.setAttribute("tid", tid);
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			int numPerPage = Integer.parseInt(request
					.getParameter("numPerPage"));
			String orderField = request.getParameter("orderField");
			String orderDirection = request.getParameter("orderDirection");
			String keyword = request.getParameter("keyword");
			int totalcount = na.GetTotalCount_By_List_id(list_id, keyword);
			request.setAttribute("items", na.GetNewsItems_By_List_id(
					list_id, pageNum, numPerPage, orderField,
					orderDirection, keyword, true));
			request.setAttribute("totalcount", totalcount);	
	%>
</c:if>
<c:if test="${param.tid==4}">
	<% 
		if(session.getAttribute("admin_uid")==null){
			response.sendRedirect("LoginAction");
		}else{
			String adminUid = (String)session.getAttribute("admin_uid");
			AdminAdapter aa=new AdminAdapter();
			request.setAttribute("aBean",aa.GetAdminBean_by_AdminUid(adminUid));	
		}			
		ListAdapter la = new ListAdapter();
		request.setAttribute("la", la);		
	%>
</c:if>


<c:if test="${param.tid==5}">
	<c:if test="${param.cid==1}">
		<%
		UserAdapter ua = new UserAdapter();
		DictAdapter da = new DictAdapter();
	    request.setAttribute("da", da);		
		if(request.getParameter("userName")==null&&request.getParameter("userSex")==null&&request.getParameter("educationDictNo")==null
		&&request.getParameter("userIntention")==null&&request.getParameter("userSkill")==null&&request.getParameter("userAddrName")==null)
		{
	
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			int numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
			String orderField = request.getParameter("orderField");
			String orderDirection = request.getParameter("orderDirection");
			String keyword = request.getParameter("keyword");
			int totalcount = ua.GetTotalCount_By_All(keyword);
			request.setAttribute("totalcount", totalcount);
			request.setAttribute("items", ua.GetUserInfo_By_All(pageNum, numPerPage, orderField, orderDirection,keyword));				
					
		}else{
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			int numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
			String orderField = request.getParameter("orderField");
			String orderDirection = request.getParameter("orderDirection");
			String userName = null;
			userName = request.getParameter("userName");
			String userSex = null;  userSex = request.getParameter("userSex");
			String userAddrName=null; userAddrName = request.getParameter("userAddrName");
			int  educationDictNo = Integer.parseInt(null==request.getParameter("educationDictNo")||"".equals(request.getParameter("educationDictNo"))?"0":request.getParameter("educationDictNo")); 				
			String userIntention = null; userIntention = request.getParameter("userIntention");
			String userSkill = null; userSkill = request.getParameter("userSkill");
			String jobIntentionDictType = request.getParameter("jobIntentionDictType");
			int	option=Integer.parseInt(null==request.getParameter("option")||"".equals(request.getParameter("option"))?"0":request.getParameter("option"));								
			int totalcount = ua.GetTotalCount_By_Select_All(userName,userSex,educationDictNo,userIntention,jobIntentionDictType,userSkill,userAddrName,option);
			request.setAttribute("totalcount", totalcount);
			request.setAttribute("items", ua.GetUserInfo_By_Select_All(pageNum, numPerPage, orderField, orderDirection,userName,userSex,educationDictNo,userIntention,jobIntentionDictType,
					userSkill,userAddrName,option));
		}
		%>
	</c:if>
	<c:if test="${param.cid==2}">
		<%			int user_id=Integer.parseInt(request.getParameter("user_id"));
					request.setAttribute("user_id", user_id);
					UserAdapter ua = new UserAdapter();
					request.setAttribute("useritems",ua.GetUserInfo_By_User_Id(Integer.parseInt(request.getParameter("user_id"))));
					request.setAttribute("userjobitems",ua.GetUserJobInfo_By_User_Id(Integer.parseInt(request.getParameter("user_id"))));
		%>
	</c:if>
</c:if>
<form id="pagerForm" method="post"
	action="index_nav.jsp?list_id=${param.list_id}&tid=${param.tid}&cid=${param.cid}">
	<input type="hidden" name="status" value="${param.status}"> 
	<input type="hidden" name="keyword" value="${param.keyword}" />
	<input type="hidden" name="userName" value="${param.userName}" />
	<input type="hidden" name="userSex" value="${param.userSex}" />
	<input type="hidden" name="educationDictNo" value="${param.educationDictNo}" />
	<input type="hidden" name="userIntention" value="${param.userIntention}" />
	<input type="hidden" name="jobIntentionDictType" value="${param.jobIntentionDictType}" />
	<input type="hidden" name="userAddrName" value="${param.userAddrName}" />
	<input type="hidden" name="userSkill" value="${param.userSkill}" />
	<input type="hidden" name="option" value="${param.option}" />
    <input type="hidden" name="pageNum" value="${param.pageNum}" />
    <input type="hidden" name="numPerPage" value="${param.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" /> 
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>
<c:if test="${param.tid==1}">
	<div class="pageHeader">
		欢迎您
	</div>
	<div class="pageContent">
${requestScope.nBean.newsContent}
		
	</div>
</c:if>
<c:if test="${param.tid==2}">
	<div class="accordion" fillSpace="sideBar">
		<div class="accordionContent">
			<ul class="tree treeFolder">
				<li><a
					href="CheckEnt.jsp?pageNum=1&numPerPage=10&orderField=ENT_NO&orderDirection=desc"
					target="navTab" rel="nav01">审核企业注册</a></li>
				<li><a
					href="CheckRecruit.jsp?pageNum=1&numPerPage=10&orderField=JOB_NO&orderDirection=desc"
					target="navTab" rel="nav02">审核招聘信息</a></li>
			</ul>
		</div>
	</div>

</c:if>
<c:if test="${param.tid==3}">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="index_nav.jsp?tid=3&list_id=6&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc"
			method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>培训名称：<input type="text" name="keyword"
							value="${param.keyword}" />
						</td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li><div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">查询</button>
								</div>
							</div></li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="delete"
					href="NewsAction?id={train_id}&list_id=${param.list_id}&method=del"
					target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li><a class="edit" href="NewsContent.jsp?nid={train_id}"
					title="修改培训" rel="altertrain" target="navTab"><span>修改</span></a></li>
				<li class="line">line</li>
				<li><a class="icon"
					href="UsersInfo.jsp?news_id={train_id}&pageNum=1&numPerPage=10&orderField=SUBMITTIME&orderDirection=desc"
					title="报名人员详细" rel="enrolluser" target="navTab"><span>报名人员详细</span></a></li>
				<li class="line">line</li>
				<li><a class="icon"
					href="Excel_trains?list_id=${param.list_id}" target="dwzExport"
					targetType="navTab" title="确实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="900">培训名称</th>
					<th>发布时间</th>
					<th>截止时间</th>
					<th align="center">报名人数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="newsitem" items="${items}">
					<tr target="train_id" rel="${newsitem.newsNo }">
						<td><a href="NewsView.jsp?nid=${newsitem.newsNo}"
							title="查看新闻" rel="viewnews" target="navTab">${newsitem.newsTitle }</a></td>
						<td><fmt:formatDate value="${newsitem.newsSubmittime  }"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${newsitem.newsTrainEndtime  }"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${newsitem.userCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<span>显示</span> <select showvalue="${param.numPerPage}"
					class="combox" name="numPerPage"
					onchange="navTabPageBreak({numPerPage:this.value})">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="50">50</option>
				</select> <span>条，共${totalcount}条</span>
			</div>

			<div class="pagination" targetType="navTab"
				totalCount="${totalcount}" numPerPage="${param.numPerPage}"
				pageNumShown="5" currentPage="${param.pageNum}"></div>

		</div>
	</div>
	<script>
		$(
				function() {
					var orderField = "${param.orderField}";
					var orderDirection = "${param.orderDirection}";
					$('th[orderfield=' + orderField + ']', $('.pageContent'))
							.addClass(orderDirection);
				})
	</script>
</c:if>
<c:if test="${param.tid==4}">
	<div class="accordion" fillSpace="sideBar">
		<div class="accordionContent">
			<ul class="tree treeFolder">
				<!-- <li><a href="NewsItems.jsp?list_id=1&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc" target="navTab" rel="NewsItems">专场招聘</a></li>
				<li><a href='NewsItems.jsp?list_id=2&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc' target="navTab" rel="NewsItems">图片新闻</a></li>
				<li><a href="NewsItems.jsp?list_id=3&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc"	target="navTab" rel="NewsItems">政策法规</a></li>
				<li><a href="NewsItems.jsp?list_id=4&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc"	target="navTab" rel="NewsItems">求职技巧</a></li>
				<li><a href="NewsItems.jsp?list_id=5&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc"	target="navTab" rel="NewsItems">表格下载</a></li>
				<li><a href="NewsItems.jsp?list_id=6&pageNum=1&numPerPage=10&orderField=NEWS_ORDERTIME&orderDirection=desc"	target="navTab" rel="NewsItems">培训新闻</a></li>		
				 -->	
					<c:choose>
						<c:when test="${sessionScope.admin_type!=0 }">
							<c:forEach var="list" items="${requestScope.la.ReturnList_By_ListType(1) }">
								<%-- <c:if test="${fn:contains(sessionScope.admin_list,list.listNo) }">
								${list.listUrl }
								</c:if> --%>
								<c:forEach var="i" items="${fn:split(requestScope.aBean.adminList,',') }">
									<c:if test="${i==list.listNo}">
										${list.listUrl }
									</c:if>
								</c:forEach>
							</c:forEach>
						</c:when>
						<c:otherwise>
						<c:forEach var="list" items="${requestScope.la.ReturnList_By_ListType(1) }">
							${list.listUrl }
						</c:forEach>
						</c:otherwise>
					</c:choose>
					<div style="display:none;">
					adminlist:${sessionScope.admin_list }
listtype1size:${requestScope.la.ReturnList_By_ListType(1).size() }
listsize:${requestScope.la.ReturnList().size() }
					</div>
			</ul>
		</div>
	</div>

</c:if>
<c:if test="${param.tid==5}">
	<c:if test="${param.cid==1}">
	<input type="hidden" name="userintention" value="${param.userIntention }"/>
		<div class="pageHeader">
			<form onsubmit="return navTabSearch(this);"	action="index_nav.jsp?tid=5&cid=1&pageNum=1&numPerPage=10&orderField=USER_NAME&orderDirection=desc"	method="post">
				<div class="searchBar">
					<table class="searchContent">
						<tr>
							<td>姓名：<input type="text" name="userName" value="${param.userName}"/>
							</td>
							<td>性别：男：<input name="userSex" type="radio" value="男" 	
								<c:if test="${param.userSex=='男'}">
									checked
								</c:if>
							/>
						                                         女：<input name="userSex"	type="radio" value="女" 
						    	<c:if test="${param.userSex=='女'}">
									checked
								</c:if>	                                     
						    />
						     	      不限：<input name="userSex"	type="radio" value="" 
						     	      	<c:if test="${param.userSex==null || param.userSex==''}">
											checked
										</c:if>	
						     	      />
							</td>
							<td>学历：<select	name="educationDictNo">	
										<option value="0" 
											<c:if test="${param.educationDictNo==0}">
												selected
											</c:if>	
										>所有</option>										
										<c:forEach var="dict"	items="${requestScope.da.GetEducationDict() }">
							            	<option value="${dict.educationDictNo }"
							            		<c:if test="${param.educationDictNo==dict.educationDictNo }">
													selected
												</c:if>	
							            	>${dict.educationDictName}</option>
										</c:forEach>
									</select>
							</td>
							<td>求职意向:&nbsp;&nbsp;职业：<select class="intentType" name="jobIntentionDictType">									
										<option value=""
											<c:if test="${param.jobIntentionDictType==''}">
													selected
											</c:if>	
										>所有</option>
											<c:forEach var="dict" items="${requestScope.da.GetIntentionDictDistinct() }">
												<option value="${dict.jobIntentionDictType}"
													<c:if test="${param.jobIntentionDictType==dict.jobIntentionDictType}">
													selected
													</c:if>	
												>
													${dict.jobIntentionDictType}</option>
											</c:forEach>
									</select>
									        行业：<select class="intentJob" name="userIntention"></select>
							</td>
							</tr>							
							<tr>
							<td>专长：<input type="text" name="userSkill" value="${param.userSkill}"	/>
							</td>
							<td align="right">						
								所属街道：<input class="required" name="userAddrName" type="text" readonly 	value="${param.userAddrName}"/>															
							</td>
							<td align="left"><a class="btnLook" href="./treelookup.jsp" lookupGroup="">查找带回</a></td>
							<c:if test="${sessionScope.admin_type!=0}">
							<td width="1300px"></td>
							<td><div class="subBar">
								<ul>
									<li><div class="buttonActive">
											<div class="buttonContent">
												<button type="submit">查询</button>
											</div>
										</div></li>
								</ul>
								</div></td>
							</c:if>
							<c:if test="${sessionScope.admin_type==0}">
								<td>查看已登记的人员信息：<input name="option" type="radio" value=1 
								<c:if test="${param.option==null || param.option==1 }">
									checked
								</c:if>
							/>查看未登记的信息：<input name="option" type="radio" value=2
								<c:if test="${param.option==2 }">
									checked
								</c:if>
							/>
							查看所有人员信息：<input name="option" type="radio" value=0 
								<c:if test="${param.option==0 }">
									checked
								</c:if>
							/></td><td width="900px"></td>
							<td><div class="subBar">
								<ul>
									<li><div class="buttonActive">
											<div class="buttonContent">
												<button type="submit">查询</button>
											</div>
										</div></li>
								</ul>
								</div></td>
							</c:if>						
						</tr>
					</table>
					<!-- <div class="subBar">
						<ul>
							<li><div class="buttonActive">
									<div class="buttonContent">
										<button type="submit">查询</button>
									</div>
								</div></li>
						</ul>
					</div> -->
				</div>
			</form>
		</div>
		<div class="pageContent">
			<div class="panelBar">
				<ul class="toolBar">
					<li><a class="add"
						href="index_nav.jsp?tid=5&user_id={user_id}&cid=2" target="navTab"
						title="查看详细信息" rel="info"><span>查看详细信息</span></a></li>
					<li><a class="delete"
						href="userTrainAction_delUser?user_id={user_id}" target="ajaxTodo"
						title="确定要删除吗?"><span>删除</span></a></li>
					<li class="line">line</li>
					<li><a class="icon" href="Excel_allUsers.action"
						target="dwzExport" targetType="navTab" title="确实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
				</ul>
			</div>
			<table class="table" width="100%" layoutH="138">
				<thead>
					<tr>
						<th orderfield="">姓名</th>
						<th orderfield="">性别</th>
						<th orderfield="">居住地址</th>
						<th orderfield="">联系方式</th>
						<th width="200" orderfield="">身份证号</th>
						<th orderfield="">学历</th>
						<th orderfield="150">邮件</th>
						<th orderfield="">所属街道</th>
						<th orderfield="">求职意向</th>
						<th orderfield="">专长</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="useritems" items="${items}">
						<tr target="user_id" rel="${useritems.userNo }">
							<td>${useritems.userName}</td>
							<td>${useritems.userSex}</td>
							<td>${useritems.userAddrName}</td>
							<td>${useritems.userPhone}</td>
							<td>${useritems.userCert}</td>	
							<td>${useritems.educationDictName}</td>
							<td>${useritems.userEmail}</td>
							<td>${useritems.userAddrName}</td>
							<td>${useritems.reserved01}</td>
							<td>${useritems.userSkill}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="panelBar">
				<div class="pages">
					<span>显示</span> <select showvalue="${param.numPerPage}"
						class="combox" name="numPerPage"
						onchange="navTabPageBreak({numPerPage:this.value})">
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
					</select> <span>条，共${totalcount}条</span>
				</div>

				<div class="pagination" targetType="navTab"
					totalCount="${totalcount}" numPerPage="${param.numPerPage}"
					pageNumShown="5" currentPage="${param.pageNum}"></div>

			</div>
		</div>
		<script>
			$(function() {
				var orderField = "${param.orderField}";
				var orderDirection = "${param.orderDirection}";
				$('th[orderfield=' + orderField + ']', $('.pageContent'))
						.addClass(orderDirection);
			})
		</script>
	</c:if>
	<c:if test="${param.cid==2}">
		<form onsubmit="return navTabSearch(this);"	action="#" method="post">
		<div class="pageHeader" style="height: 100px">			
			<table width="85%" text-align="left" height="100px"
				style="padding-top: 15px;">
				<tr>
					<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="userName" size="30" readonly="true" value="${useritems.userName}" /></td>
					<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="text" name="userSex" size="30" readonly="true" value="${useritems.userSex}" /></td>
					<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="text" name="userAge" size="30" readonly="true" value="${useritems.userAge}" /></td>
					<td><a href="../resumeInfoPage.jsp?userNo=${user_id}&htid=1" target="_blank"><span>查看详细简历</span></a></td>
				</tr>
				<tr>
					<td>联系方式：<input type="text" name="userPhone" size="30" readonly="true" value="${useritems.userPhone}" /></td>
					<td>身份证号：<input type="text" name="userCert" size="30" readonly="true" value="${useritems.userCert}" /></td>
					<td>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：<input type="text" name="educationDictName" size="30" readonly="true" value="${useritems.educationDictName}" />
					<td>家庭地址：<input type="text" name="userAddrPos" size="30" readonly="true" value="${useritems.userAddrPos}" /></td>
					</td>
				</tr>
				<tr>
					<td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件：<input type="text" name="userEmail" size="30" readonly="true" value="${useritems.userEmail}" /></td>
					<td>所属街道：<input type="text" name="userAddrName" size="30" readonly="true" value="${useritems.userAddrName}" /></td>
					<td>求职意向：<input type="text" name="userIntention" size="30" readonly="true" value="${useritems.userIntention}" /></td>
					<td>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长：<input type="text" name="userSkill" size="30" readonly="true" value="${useritems.userSkill}" /></td>
				</tr>
			</table>
				<input type="hidden" name="userNo" value="${user_id}">
				<input type="hidden" name="userAddrDisNo" value="${useritems.userAddrDisNo}">
				<input type="hidden" name="userIntentDisNo" value="${useritems.userIntentDisNo}">
				<input type="hidden" name="userEducationNo" value="${useritems.userEducationNo}">
		</div>
		<div class="pageContent">
			<div class="panelBar">
				<!-- <div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">修改</button>
						</div>
					</div> -->
			</div>
			<table class="table" width="100%" layoutH="196">
				<thead>
					<tr>
						<th>应聘公司</th>
						<th>应聘岗位</th>
						<th>学历要求</th>
						<th>工作地点</th>
						<th>应聘时间</th>
						<th>面试时间</th>
						<th>试用时间</th>
						<th>正式上岗时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="userjobitems" items="${userjobitems}">
						<tr target="userjob_id" rel="${userjobitems.userNo }">
							<td>${userjobitems.entName}</td>
							<td>${userjobitems.jobName}</td>
							<td>${userjobitems.educationDictName}</td>
							<td>${userjobitems.jobAddrPosName}</td>
							<td>${userjobitems.submittime}</td>
							<td>${userjobitems.auditiontime}</td>	
							<td>${userjobitems.trytime}</td>
							<td>${userjobitems.hiretime}</td>
						</tr>
					</c:forEach>
				</tbody>			
			</table>
			<div class="formBar">
			<ul>
				<!-- <li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">修改</button>
						</div>
					</div>
				</li>			 -->
			</ul>
		   </div>
			
		</div>
	</form>
	</c:if>
</c:if>
<c:if test="${param.tid==6}">
	<div class="accordion" fillSpace="sideBar">
		<div class="accordionContent">
			<ul class="tree treeFolder">
				<li><a href="#">基本属性维护</a>
					<ul>
						<li><a href="dict/baseinfo1.jsp" target="navTab" rel="nav11">敏感词维护</a></li>
						<li><a href="dict/baseinfo2.jsp" target="navTab" rel="nav11">企业申请审核维护</a></li>
						<li><a href="dict/baseinfo3.jsp" target="navTab" rel="nav11">职位发布审核维护</a></li>
					</ul>
				</li>
				<li><a href="#">地址树维护</a>
					<ul>
						<li><a href="AlterComm.jsp" target="navTab" rel="treeinfo">街道社区维护</a></li>
						<li><a href="dict/intent_addr_dict.jsp" target="navTab" rel="treeinfo">求职意向区域维护</a></li>
					</ul>
				</li>
				<li><a href="#">字典维护</a>
					<ul>
						<li><a href="dict/score_dict.jsp" target="navTab" rel="nav04">分数字典</a></li>
						<li><a href="dict/intention_dict.jsp" target="navTab" rel="nav05">职业/行业字典</a></li>
						<li><a href="dict/edu_dict.jsp" target="navTab" rel="nav06">学历字典</a></li>
						<li><a href="dict/job_age_dict.jsp" target="navTab" rel="nav03">职业要求年龄字典</a></li>
						<li><a href="dict/job_exp_dict.jsp" target="navTab" rel="nav02">工作经验字典</a></li>
						<li><a href="dict/job_salary_dict.jsp" target="navTab" rel="nav01">薪资待遇字典</a></li>
						<!-- <li><a href="dict/job_type_pri_dict.jsp" target="navTab" rel="nav07">首要类别字典</a></li> -->
						<li><a href="dict/scale_dict.jsp" target="navTab" rel="nav08">规模字典</a></li>
						<li><a href="dict/ent_trade_dict.jsp" target="navTab" rel="nav09">企业/行业类型字典</a></li>
						<!--<li><a href="dict/ent_trade_dict.jsp" target="navTab" rel="nav10">经济类型字典</a></li> -->
					</ul>
				</li>
				<li><a href="dict/admin_list.jsp" target="navTab" rel="nav10">管理员角色设置</a></li>
				<li><a href="dict/spider.jsp" target="navTab" rel="nav11">专场招聘抓取</a></li>
				<li><a href="NewsContent.jsp?nid=1" target="navTab" rel="nav12">首页新闻管理</a></li>
			</ul>
		</div>
	</div>
</c:if>
<c:if test="${param.tid==7}">
	<div class="accordion" fillSpace="sideBar">
		<div class="accordionContent">
			<ul class="tree treeFolder">
				<li><a href="nav01_01_gov.html" target="navTab">参数设置</a></li>
				<li><a href="nav01_02_gov.html" target="navTab">广告发布</a></li>
				<li><a href="nav01_03_gov.html" target="navTab">友情链接</a></li>
			</ul>
		</div>
	</div>

</c:if>

 