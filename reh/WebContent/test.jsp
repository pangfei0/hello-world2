<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page	import="com.ree.hibernate.RepUserInfo,org.apache.struts2.ServletActionContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试职业插件</title>
<link rel="stylesheet" type="text/css" href="css/plug/css.css" />
<link rel="stylesheet" href="scripts/train/reset.css" />
<link rel="stylesheet" href="scripts/train/pageCode.css" />
<link rel="stylesheet" href="scripts/train/seetrain.css" />
<script type="text/javascript" src="scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="scripts/plug/drag.js"></script>
<script type="text/javascript" src="scripts/plug/major_arr.js"></script>
<script type="text/javascript" src="scripts/train/trainenter.js"></script>
<script type="text/javascript" src="scripts/resume/resume.js"></script>
</head>
<body>
	<script type="text/javascript" src="scripts/plug/major_func.js"></script>
	<input id="btn_MajorID_2" type="button" value="请选择专业" onclick="majorSelect_2()" />
	<input id="MajorID_2" type="hidden" name="MajorID_2" value="" />单选	
	<div id="maskLayer" style="display:none">
		<div id="alphadiv" style="filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5"></div>
				<div id="drag">
					<h3 id="drag_h"></h3>
				<div id="drag_con"></div><!-- drag_con end -->
		</div>
	</div>
	<button id="resume">查看简历</button>
<div id="sublist" style="display:none"></div>
<input id="userno" type="hidden" value="${sessionScope.userbean.userNo} "/>
<div class="tcdPageCode">
</div>
<div class="train">
</div>
<div class="seetrain">
</div>
<div class="train1">
</div>
<div class="resume">
</div>
<!-- 求职与招聘表格插件开始   -->
<div class="data-table">
					<table class="info_table" cellspacing="0">
						<tr class="tr_top" align="center">
							<td>职位名称</td>
							<td>公司/部门</td>
							<td style="width: 140px;">工作地点</td>
							<td>学历</td>
							<td>经验</td>
							<td>性别</td>
							<td>薪资待遇</td>
							<td>职业性质</td>
							<td style="width: 90px;">职业倾向/类别</td>
							<td ${sessionScope.u_type==null?'style="display:none;"':'' }>匹配度</td>
							<td ${sessionScope.u_type==null?'style="display:none;"':'' }>操作</td>
						</tr>
					</table>
</div>
<!-- 求职与招聘表格插件结束   -->
</body>
<script src="scripts/train/jquery.page.js"></script>
<script src="scripts/train/jquery.seetrain.js"></script>

</html>