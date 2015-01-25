<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的应聘</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<script type="text/javascript" src="./scripts/public/alt-plugin.js"></script>
<script type="text/javascript" src="./scripts/myRecruit/myRecruit.js"></script>
<link rel="stylesheet" href="./css/jquery-ui.min.css"/>
<script type="text/javascript" src="./scripts/public/jquery-ui.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>招聘信息</span>
			</div>
			<div class="infos">
				<form class="search-box">
				<input type="hidden" name="c" value="1" /><input type="hidden"
						name="p" value="10" /> <input type="hidden" name="sortBy"
						value="id.jobName" /><input type="hidden" name="sortMethod"
						value="desc" />
					<a class="search_btn red_btn" href="#">查询</a> <span>职位名称：</span><input
						name="recruitBean.jobName" /> 
						
				</form>
				<div class="btns">
					<a class="add_btn" href="recruitAndEmploy.jsp">求职招聘</a><a
						class="add_btn" href="myRecruit.jsp">我的应聘</a><a
						class="refresh_btn">刷新</a>
				</div>
				<div id="alt-table" class="data-table">
					<table class="info_table" cellspacing="0">
						<tr class="tr_top" align="center">
							<td>职位名称</td>
							<td>公司/部门</td>
							<td>试用时间</td>
							<td>转正时间</td>
							<td style="width: 150px;">状态</td>
							<td>企业主动招聘</td>
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
