<%@page import="com.ree.community.communityAdapter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ree.intentaddr.IntentAddrAdapter"%>
<%
communityAdapter ca = new communityAdapter(false);
request.setAttribute("ca", ca);
%>
<link href="../css/altercomm.css" rel="stylesheet" type="text/css" />
<script>
	
</script>
<h2 class="contentTitle">求职意向地点信息维护</h2>
<div class="pageContent">
	<!-- <form method="post" action="CommunityAction"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this)"> -->
	<form method="post" action="IntentAddrAction" class="pageForm required-validate"	onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="actionmethod" id="actionmethod" value="" />
		<input type="hidden" name="id" id="alterid" value="" /> 
		<input type="hidden" name="newlevel" id="newlevel" value="1" /> 
		<input type="hidden" name="newfatherid" id="newfatherid" value="0" />
		<div class="pageFormContent" layoutH="96">
			<div class="treebox">
				<ul class="tree treeFolder collapse communities">
					<c:forEach var="community"	items="${requestScope.ca.GetAddr_By_father_id(0) }">
						<li><a level="1" data-addr="${community.intentAddr }" data-fathername="无" data-key="${community.intentAddrNo }">${community.intentAddrName }</a>
							<c:forEach var="community1"	items="${requestScope.ca.GetAddr_By_father_id(community.intentAddrNo) }">
								<ul>
									<li><a level="2" data-addr="${community1.intentAddr }" data-fathername="${community.intentAddrName }"	data-key="${community1.intentAddrNo }">${community1.intentAddrName }</a>
										<c:forEach var="community2"	items="${requestScope.ca.GetAddr_By_father_id(community1.intentAddrNo) }">
											<ul>
												<li><a level="3" data-addr="${community2.intentAddr }" data-fathername="${community1.intentAddrName }" data-key="${community2.intentAddrNo }">${community2.intentAddrName }</a>
													<c:forEach var="community3"	items="${requestScope.ca.GetAddr_By_father_id(community2.intentAddrNo) }">
														<ul>
															<li><a level="4" data-addr="${community3.intentAddr }" data-fathername="${community2.intentAddrName }" data-key="${community3.intentAddrNo }">${community3.intentAddrName }</a>
																<c:forEach var="community4"	items="${requestScope.ca.GetAddr_By_father_id(community3.intentAddrNo) }">
																	<ul>
																		<li><a level="5" data-addr="${community4.intentAddr }" data-fathername="${community3.intentAddrName }" data-key="${community4.intentAddrNo }">${community4.intentAddrName }</a></li>
																	</ul>
																</c:forEach>
															</li>
														</ul>
													</c:forEach>
												</li>
											</ul>
										</c:forEach>
									</li>
								</ul>
							</c:forEach>
					   </li>
					</c:forEach>
				</ul>
			</div>
			<p>
				<label>类 型：</label> <input name="txttype" id="txttype" type="text"
					readonly="readonly" size="30" value="" />
			</p>
			<p>
				<label>从属于：</label> <input name="txtfather_name" id="txtfather_name"
					type="text" readonly="readonly" size="30" value="" />
			</p>
			<p>
				<label>名 称：</label> <input name="txtname" id="txtname"
					class="required" type="text" size="30" value="" />
			</p>
			<p>
				<label>地 址：</label> <input id="txtaddr"
					readonly="readonly" class="required" type="text" size="30" value="" />
			</p>

		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">修改</button>
						</div>
					</div></li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="addbtn">添加</button>
						</div>
					</div></li>
				<li>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" id="delbtn">删除</button>
						</div>
					</div></li>
				
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(function() {
		/*c元素*/
		var celem = [];
		/*c对象*/
		var d = function(i, tar) {
			var i = i;
			var name = $(tar).text();
			var addr = $(tar).data('addr');
			var id = $(tar).data('key');
			var level = $(tar).attr('level');
			var fathername = $(tar).data('fathername');
			this.init = function(con) {
				con.clear()
			};
			this.clear = function() {
			};
			this.click = function() {
				var type;
				switch(level){
					case '1':type="市";break;
					case '2':type="区";break;
					case '3':type="街道";break;
					case '4':type="社区";break;
					case '5':type="小区";break;
					default:break;
				}
				//添加时使用
				$('#newlevel').val(parseInt(level)+1);
				$('#newfatherid').val(id);
				
				$('#txttype').val(type);
				$('#txtfather_name').val(fathername);
				$('#txtname').val(name);
				$('#txtaddr').val(addr);
				$('#alterid').val(id);
				$('#actionmethod').val('alter');
			};
		}
		/*c控制器*/
		var c = {
			click : function(i) {
				celem[i].click()
			},
			init : function(i, e) {
				tar = i;
				celem[tar] = new d(i, e);
				tar = celem[tar];
				tar.init(tar);
			}
		}
		/*初始*/
		$('.communities a').each(function(i, e) {
			c.init(i, e);
			$(e).click(function() {
				c.click(i);
			})
		});
		/*添加*/
		$('#addbtn').click(function(){
			$('#actionmethod').val('add');
			validateCallback($(this).closest('form'), navTabAjaxDone);
		});
		/*删除*/
		$('#delbtn').click(function(){
			$('#actionmethod').val('del');
			validateCallback($(this).closest('form'), navTabAjaxDone);
		});
	})
</script>