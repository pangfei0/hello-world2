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
	request.setAttribute("items", da.GetSensitive_By_All());
	int banword = da.GetBanword_By_All();
	request.setAttribute("banword", banword);
%>

<div class="pageContent">
	<div>
		<form method="post" action="DictAction_banwordCheck" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<table align="left">
				<tr>
					<!-- <td>敏感词过滤开关:</td><td>是<input type="radio" value="1" name="banword" ></td>
					<td>否<input type="radio" value="0" name="banword" ></td> -->
					<td>打开敏感词过滤开关：<input type="checkbox" value="1" name="banword" 
						<c:if test="${banword==1}">
							checked
						</c:if>
						<c:if test="${banword!=1}">							
						</c:if>
					></td>
					<td><button type="submit" id="btn">确定</button>	</td>
				</tr>
				<tr><td height="8"></td></tr>
			</table>									
		</form>
	</div>
	<div>
		<form name="update" method="post" action="DictAction_updateSensitive" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<table align="left">			
			<tr>
				<td>
					<textarea rows="10" cols="40" name="sensitive">${items.sysValue}</textarea>
					
				</td>
			</tr>	
			<tr><td height="8"></td></tr>
			<tr>
				<td align="right">				
					<button type="submit">更新敏感词库</button>			
				</td>
			</tr>					
		</table>
		</form>
	</div>
</div>
