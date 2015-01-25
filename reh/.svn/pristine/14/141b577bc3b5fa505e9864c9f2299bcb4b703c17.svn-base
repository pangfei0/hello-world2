<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page
	import="com.ree.news.NewsAdapter,com.ree.list.ListAdapter,com.ree.train.TrainAdapter,org.apache.struts2.ServletActionContext,com.ree.hibernate.RepUserInfo,java.util.Date, java.text.SimpleDateFormat"%>
<%
	ListAdapter la = new ListAdapter();
	request.setAttribute("la", la);
	if (request.getParameter("tid") == null || !request.getParameter("tid").equals("2")) {
		NewsAdapter na = new NewsAdapter();
		int list_id = Integer.parseInt(request.getParameter("list_id"));
		request.setAttribute("list_id", list_id);
		int curPage = request.getParameter("curPage") == null? 1: Integer.parseInt(request.getParameter("curPage"));
		request.setAttribute("curPage", curPage);
		int count = na.GetCount_By_List_id(Integer.parseInt(request.getParameter("list_id")));
		request.setAttribute("count", count);
		request.setAttribute("na", na);
		int totalpage = (count / 13) + 1;
		request.setAttribute("totalpage", (count / 13) + 1);
	} else {
		TrainAdapter ta = new TrainAdapter();
		request.setAttribute("ta", ta);
	}
%>
<c:if test="${sessionScope.userbean.userNo!=null}">
	<%
	NewsAdapter na = new NewsAdapter();
	int tid=0;
	tid=Integer.parseInt(request.getParameter("tid"));
	int list_id = Integer.parseInt(request.getParameter("list_id"));
	int curPage = Integer.parseInt(request.getParameter("curPage"));
	int count = na.GetCount_By_List_id(Integer.parseInt(request.getParameter("list_id"))); 
	 int totalpage=(count/13)+1;
	 request.setAttribute("totalpage",(count / 13) + 1 );
 	request.setAttribute("count", count);
	RepUserInfo userbean=new RepUserInfo();
	HttpSession se=ServletActionContext.getRequest().getSession();
	userbean=(RepUserInfo)se.getAttribute("userbean");
	request.setAttribute("user_id", userbean.getUserNo());
	SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
	request.setAttribute("now", dateformat.format(new Date()));
%>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>更多新闻</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<script>
	$(function() {
		$(
				"#nav>li>a[href*='"
						+ location.pathname.split('/')[location.pathname
								.split('/').length - 1] + location.search
						+ "']").css

		("background", "#3A7100");

		var p = $("#nav>li>ul>li>a[href*='"
				+ location.pathname.split('/')[location.pathname.split('/').length - 1]
				+ location.search + "']");
		if (p.length > 0) {
			$(p).parent().parent().parent().css("background", "#3A7100");

		}
		
		$("#nextpage").click(function() {
		});

	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="download border-style top-space white-bg">
			<div class="infos">
				<c:choose>
					<c:when test="${sessionScope.userbean.userNo!=null}">
						<c:if test="${param.tid!=2}">
							<div class="navigation">
								<img src="images/dot_new.jpg" /><span>${requestScope.la.GetListName_By_ListNo(param.list_id)
									}</span>
							</div>
						</c:if>
						<c:if test="${param.list_id!=6}">
							<div class="data-table"></div>
							<table width="730" border="0" cellspacing="0" cellpadding="0"
								text-align="center" style="margin: 0 auto;padding-top: 10px;"
								border="1">
								<c:forEach var="newsitem"
									items="${na.GetNewsItems_By_List_id(param.list_id,param.curPage!=null?param.curPage:1, 13, 'newsSubmittime', 'desc','')}">
									<tr rel="${newsitem.newsNo}">
										<td width="85%" height="30" align="left"
											class="x_hei underLine"><a
											href='news.jsp?nid=${newsitem.newsNo }' target=_blank
											title='${newsitem.newsTitle }' class="newstitle">${fn:length(newsitem.newsTitle)>40?(fn:substring(newsitem.newsTitle,0,40)).concat('...'):newsitem.newsTitle
												}</a></td>
										<td width="16%" align="right" class="time underLine"><fmt:formatDate
												value="${newsitem.newsSubmittime }" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						<c:if test="${param.tid==1}">
							<!-- <div class="navigation">
							<img src="images/dot_new.jpg" /><span>培训信息列表</span>
						</div> -->
						<a
							href="moreNews.jsp?list_id=6&user_id=${sessionScope.userbean.userNo}&tid=2&curPage=1"
							style="color: blue; font-size: 14px;">查看报名结果</a>
						<div class="data-table">
						<table border="1" cellspacing="0" cellpadding="0"
							class="info_table" width="730"  style="margin: 0 auto;padding-top: 10px;">
							<thead>
								<tr style="line-height: 36px;">
									<th style="width: 100px">发布日期</th>
									<th style="width: 100px">截止日期</th>
									<th style="width: 300px">培训内容</th>
									<th style="width: 150px">详细信息</th>
									<th style="width: 150px">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="newsitem"
									items="${na.GetNewsItems_By_List_id(param.list_id,param.curPage!=null?param.curPage:1, 13, 'newsSubmittime', 'desc','')}">
									<tr style="line-height: 30px;" rel="${newsitem.newsNo}">
										<td><fmt:formatDate value="${newsitem.newsSubmittime }"	pattern="yyyy-MM-dd" /></td>
										<td><fmt:formatDate value="${newsitem.newsTrainEndtime }"	pattern="yyyy-MM-dd" /></td>
										<td>${fn:length(newsitem.newsTitle)>20?(fn:substring(newsitem.newsTitle,0,20)).concat('...'):newsitem.newsTitle
											}</td>
										<td><a href="news.jsp?nid=${newsitem.newsNo}"
											target=_blank style="color: blue;">点击查看</a></td>
											<td>
												<a href="javascript:if(confirm('确实要报名该培训吗'))location='trainAction?news_id=${newsitem.newsNo}&user_id=${sessionScope.userbean.userNo}&submittime=${newsitem.newsSubmittime}'">报名参加</a>
											</td>
									</tr>
								</c:forEach>
							</tbody>
							</table>
						</div>
						</c:if>
						<c:if test="${param.tid==2}">
							<div class="navigation">
								<img src="images/dot_new.jpg" /><span>培训新闻</span>
							</div>
						<table border="1" cellspacing="0" cellpadding="0"
							class="info_table" style="width: 860px; margin-left: 30px;">
							<thead>
								<tr style="line-height: 36px;">
									<th style="width: 200px">培训名称</th>
									<th style="width: 150px">详细信息</th>
									<th style="width: 150px">培训截止日期</th>
									<th style="width: 150px">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="trainitem"	items="${ta.GetTrainBeans_By_User(user_id)}">
									<tr style="line-height: 30px;" rel="${trainitem.trainUserNo}">
										<td>${fn:length(trainitem.newsTitle)>20?(fn:substring(trainitem.newsTitle,0,20)).concat('...'):trainitem.newsTitle}</a>
										</td>
										<td><a href="news.jsp?nid=${trainitem.newsNo}" target=_blank style="color: blue;">点击查看</a></td>
										<td><fmt:formatDate value="${trainitem.newsTrainEndtime }"	pattern="yyyy-MM-dd" /></td>
										<td><a
											href="javascript:if(confirm('确实要退出该培训吗'))location='trainAction?train_id=${trainitem.trainUserNo}&news_id=${trainitem.newsNo}&method=del'">退出培训</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</c:when>
				<c:otherwise>
					<div class="navigation">
							<img src="images/dot_new.jpg" /><span>${requestScope.la.GetListName_By_ListNo(param.list_id) }</span>
					</div>
					<div class="data-table">
						<table width="730" border="0" cellspacing="0" cellpadding="0"
							text-align="center"
							style="margin: 0 auto; padding-top: 10px;" border="1">
							<c:forEach var="newsitem"
								items="${na.GetNewsItems_By_List_id(param.list_id,param.curPage!=null?param.curPage:1, 13, 'newsSubmittime', 'desc','')}">
								<tr rel="${newsitem.newsNo}">
									<td width="85%" height="30" align="left" class="x_hei underLine"><a
										href='news.jsp?nid=${newsitem.newsNo }' target=_blank
										title='${newsitem.newsTitle }' class="newstitle">${fn:length(newsitem.newsTitle)>40?(fn:substring(newsitem.newsTitle,0,40)).concat('...'):newsitem.newsTitle
												}</a></td>
									<td width="15%" align="right" class="time underLine"><fmt:formatDate
											value="${newsitem.newsSubmittime }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>	
						</table>
					</div>
					<div class="center top-space">
						<div id="page" style="margin:0px auto;">
							<div id="Pagination"></div>
						</div>
					</div>
					</c:otherwise>
				</c:choose>
				<div class="center top-space">
					<div id="page" style="margin:0px auto;">
						<div id="Pagination"></div>
					</div>
				</div>
				<div class="center top-space" style="font-size: 15px;">
					<a
						href="moreNews.jsp?list_id=${param.list_id}&curPage=${param.curPage-1==0?1:param.curPage-1}&tid=${param.tid==0?0:param.tid}"
						id="prepage">上一页</a>
					<c:forEach var="i" begin="1" end="${totalpage}">
						<a
							href="moreNews.jsp?list_id=${param.list_id}&curPage=${i}&tid=${param.tid==0?0:param.tid}">${i}</a>
						<%-- <c:if test="${curPage==i}">
							<script>
								$(".pageNum").css("text-decoration",
										"underline");
							</script>
						</c:if> --%>
					</c:forEach>
					<a
						href="moreNews.jsp?list_id=${param.list_id}&curPage=${param.curPage+1>=totalpage?totalpage:param.curPage+1}&tid=${param.tid==0?0:param.tid}"
						id="nextpage">下一页</a> <span style="vertical-align: top">共${totalpage}页</span>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>