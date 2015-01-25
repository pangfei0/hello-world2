<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>应聘管理-简历收藏夹</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<script type="text/javascript"
	src="./scripts/favouriteMgrPage/favouriteMgrPage.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>应聘管理-简历收藏夹</span>
			</div>
			<div class="infos">
				<form class="search-box">
				<input type="hidden" name="c" value="1" /><input type="hidden"
						name="p" value="10" /> <input type="hidden" name="sortBy"
						value="id.userName" /><input type="hidden" name="sortMethod"
						value="asc" />  
						<span>职位名称：</span><input name="jobBean.jobName" />
					<a class="search_btn red_btn" href="#">查询</a> 
				</form>

				<div class="btns">
					<a class="add_btn" id="sresume" href="offerMgrPage.jsp">简历收件箱</a> 
					<a class="add_btn" id="sresume" href="myLibPage.jsp">我的人才库</a> 
					<a class="refresh_btn">刷新</a>
				</div>
				<div class="data-table">
					<table class="info_table" cellspacing="0">
						<tr class="tr_top" align="center">
							<td>姓名</td>
							<td>性别</td>
							<td>联系方式</td>
							<td>年龄</td>
							<td>学历</td>
							<td>求职意向</td>
							<td>所属街道</td>
							<td>操作</td>
						</tr>
						
					</table>
				</div>
				<div class="center top-space">
					<div id="page" style="margin:0px auto;">
						<div id="Pagination">
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
