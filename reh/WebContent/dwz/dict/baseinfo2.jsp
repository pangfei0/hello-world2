<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.ree.dict.DictAdapter"%>
<%
	DictAdapter da = new DictAdapter(); 
	int entcheck = da.GetEntcheck_state_By_All();
	request.setAttribute("entcheck", entcheck);
%>
<div class="pageContent">
	<form method="post" action="DictAction_entCheck" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<table align="left">
			<tr>
				<!-- <td>企业申请审核开关 :</td><td>是<input type="radio" value="1" name="entcheck" ></td>
				<td>否<input type="radio" value="0" name="entcheck" ></td> -->
				<td>打开企业申请审核开关：<input type="checkbox" value="1" name="entcheck"
					<c:if test="${entcheck==1}">
							checked
						</c:if>
						<c:if test="${entcheck!=1}">							
						</c:if>
				></td>
				<td><button type="submit" id="btn">确定</button>	</td>
			</tr>
		</table>
									
	</form>
</div>
