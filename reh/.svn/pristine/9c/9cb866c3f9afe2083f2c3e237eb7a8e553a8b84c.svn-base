<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>应聘管理-黑名单管理</title>
<meta name="Keywords" content=",," />
<meta name="Description" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<jsp:include page="source.jsp" />
<script type="text/javascript"
	src="./scripts/entBlacklistUser/entBlacklistUser.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="main">
		<div class="main_border border-style top-space white-bg">
			<div class="navigation">
				<img src="images/dot_new.jpg" /><span>应聘管理-黑名单管理</span>
			</div>
			<div class="infos">
				<form class="search-box">
				<input type="hidden" name="c" value="1" /><input type="hidden"
						name="p" value="10" /> <input type="hidden" name="sortBy"
						value="id.userCert" /><input type="hidden" name="sortMethod"
						value="desc" /> <input type="hidden" name="boxtype" value="${param.boxtype }"/>
					<a class="search_btn red_btn" href="#">查询</a> <span>身份证号：</span> <input
						name="recruitBean.userName" /> 
				</form>

				<div class="btns">
				<a class="add_btn ree-btn" href="#"
					data-form="./dialogForm/entBlacklistUserDialog.jsp?entNo=" data-title="添加"
					data-action="BlackList_Add">添加新黑名单</a>
					<a class="refresh_btn">刷新</a>
				</div>
				<div class="data-table">
					<table class="info_table" cellspacing="0">
						<tr class="tr_top" align="center">
							<td>身份证号</td>
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
