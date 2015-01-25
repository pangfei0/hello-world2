<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<h2 class="contentTitle">多选框/单选框</h2>
<form method="post" action="SpiderAction" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
	<div class="pageFormContent" layoutH="98">
		<label><input type="radio" name="isDel" value="true"/>删除原数据</label>
		<label><input type="radio" name="isDel" value="false"/ checked="checked">不删除原数据</label>
		<div class="divider"></div>
		<label>匹配方式：</label>
		<select class="combox" name="wayToCompare">
			<option value="submittime">提交时间</option>
			<option value="title">标题</option>
		</select>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
		</ul>
	</div>
</form>
