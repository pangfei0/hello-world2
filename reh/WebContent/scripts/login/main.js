//jquery 主程序开始
$(document).ready(function(){

		//初始化操作
	    $("#username").focus(function(){
	    	usernameFocus();
	   });
	    $("#password").focus(function(){
	    	if($("#username").val()==""){
	    		$('h4.title').text('请输入用户名');
	    	}
	    	passwordFocus();
	    });
	  	   
	   //密码焦点丢失
	   $("#password").blur(function()
		{ 
		   if($("#password").val()==""){
	    		$('h4.title').text('请输入密码');
	    	}
		   $("#pwdErr").html(" ");
		});
	  

});
//jquery主程序结束 

//以下为调用部分

//当账户输入内容变化时进行用户验证，jquery1.4.2有bug故未使用jquery的change事件
function changeUser()
{		
	  $("#unameErr").html("");
	  $("#pwdErr").html("");
	  if( $("#id_tag").val() == "" )
	  		{
			$("#unameErr").html("请输入账号");
			} else
		  		{
				  checkUser();
		  		}
}

//验证用户是否存在
function checkUser()
{		
		delRolelist();
		$("#unameErr").html("查询用户中...");
		id_tag =$("#id_tag").val();
		id_tag = id_tag.replace(/(^\s*)&(\s*$)/g, "");
		$.post("CheckUserAction.action", {id_tag:id_tag},function(msg){checkusercallback(msg);}, "json");	
}

//checkUser()的callback,写入验证结果,如果为真则加载角色表
	function checkusercallback(msg)
	{   
		if(msg.success==true)
		{
			$("#unameErr").html(msg.username);
			userexist=1;
			loadrole();//加载角色表
		}else {
			$("#unameErr").html("账号不存在");
			usernameFocus();
			$("#id_tag").focus().select();
			userexist=0;
		}	
	}
	
//登录验证
function checkSubmit()
{
	 if( $("#id_tag").val() == "" )
	  {
			usernameFocus();
			$("#unameErr").html("请输入账号");
			$("#id_tag").focus().select();
			return false;
		}
	  else if( $("#password").val() == "" && userexist){
		  $("#pwdErr").html("请输入密码");
		  passwordFocus();
		  $("#password").focus().select();
			return false;
		} 
	  else if(userexist){
		  $(function(){gotoSubmit()});
	   }
	  else return false;
}

//checkSubmit()的callback，发送数据给后台，并进行登陆 
function gotoSubmit()
	{   
		var id_tag = $("#id_tag").val();
		var password =$("#password").val();
		//var	role =document.getElementsByName("role")[0].value;
		var	roleid =$("#select").val();
		var	rolename =$("#select option:selected").text();
		$.ajax({type:"post",url:"checkLoginAction.action",async:false,data:{id_tag:id_tag,password:password,roleid:roleid},
			cache:false,dataType:"json",success:function(msg){
			if(!msg.pswfailure){
				var url=host+hqc+"/treeui.action";
				window.location=url;
			}else 
				{$("#pwdErr").html("密码错误");
				 passwordFocus();
				 $("#password").attr("value","");
				 $("#password").focus().select();
				}
						
		},error:function(msg){
			$("#unameErr").html("网络错误！");
			}});		
	}	

//验证用户存在后读取角色的callback，读取该用户的角色表并写入角色的option选项中去
	function loadrole()
	//加载角色表
	{
		$.post("RefreshRoleAction.action", {id_tag:id_tag},
				function(msg){
			
			loadrolelist(msg);}, "json");	
	}
	
	
//把读取的角色表数据写入select表单中
	function loadrolelist(msg)
	{   
		$("#select option").remove();
		$("#select").append("<option value='"+msg.roleid+"'>"+msg.rolename+"</option>");
	}
	
	function delRolelist(msg)
	{
		$("#select option").remove();  //清空Select中的Option  
		$("#select").append("<option value='250'>请选择角色</option>");
	}
	
//获取账号焦点修改CSS 
function usernameFocus(){
	
	$("#username").css("background-color","#FFC");
	$("#password").css("background-color","#FFF");
}
//获取密码焦点修改CSS 
function passwordFocus(){
	
	$("#password").css("background-color","#FFC");
	$("#username").css("background-color","#FFF");
}




