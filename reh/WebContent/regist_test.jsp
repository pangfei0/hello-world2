<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="scripts/public/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="scripts/public/My97/WdatePicker.js"></script>
<script type="text/javascript" src="scripts/public/zebra_dialog.js"></script>
<script type="text/javascript" src="./scripts/public/reload.js"></script>
<script type="text/javascript" src="./scripts/public/ree-multiselect.js"></script>
<script type="text/javascript" src="./scripts/public/formToJson.js"></script>
<script type="text/javascript" src="scripts/public/uniqueArray.js"></script>

<script src="dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>

<script type="text/javascript" src="./scripts/public/jquery.validate.min.js">
</script>
 <script type="text/javascript" src="./scripts/registerAndModify/Regist.js"> 
 </script>
<script type="text/javascript">
	
</script> 
<style>
 label.error{
 font-size: .8em;
 color: yellow;
 font-weight: bold;
 margin-left: 315px;
 dispaly:block;
}
input.error, #testform select.error  {
  background: #FFA9B8;
  border: 1px solid red;
}
</style>
</head>
<body>


<div>
<h2>企业注册!</h2>	
<form id="testform" >							
				    <input name="u_type" type="hidden" value=1 />	
				    	
					<label for="name" class="label">	用户名：</label>			<input name="entUid"   type="text" class="required" />
									
							密码：		<input name="entPwd"   id="entPwd" type="passWord" class="required" />
							
							密码确认                    <input name="entPwd1"    type="passWord" class="required" />
							姓名：	<input name="entName"  type="text" />
							企业类型		<select style="margin-left:0px" name="entType" class="required" title="please in">

												    <option value="1">

								    有限责任公司
								    												
								
								</option>
								<option value="2">
								
								    股份有限公司
								    												
								
								</option>
								<option value="3">
								
								    国有独资公司
								    												
								
								</option>
								<option value="4">
								
								    个人独资企业
								    												
								
								</option>
								<option value="5">
								
								    合伙企业
								    												
								
								</option>
								<option value="6">
								
								    个体工商户
    												

                                </option>

				               </select>
								邮箱	<input name="entEmail"  type="text"  class="required"/>
							
					
						<input type="submit" id="submit" value="提交"></input>		
							
						</form> 
				
				
<h2>用户注册!</h2>				
      <form id="testform2" >							
				    <input name="u_type" type="hidden" value=0 />	
				    	
					     	用户名：		<input name="USER_UID"   type="text" class="required" />
									
							密码：		<input name="USER_PWD"   id="USER_PWD" type="passWord" class="required" />
							
							密码确认                    <input name="USER_PWD1"    type="passWord" class="required" />
							 姓名：	<input name="USER_NAME"  type="text" />
						            性别：          男 <input  type="radio" name="USER_SEX" Value='男'> 
						                                  女 <input  type="radio" name="USER_SEX" Value='女'> 
							邮箱	<input name="USER_EMAIL"  type="text"  class="required"/>
							
					
						<input type="submit" id="submit" value="提交"></input>		
							
						</form> 
								

</div>
</body>
</html>