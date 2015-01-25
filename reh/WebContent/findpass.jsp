<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>找回密码</title>
<link rel="stylesheet" href="./css/font/css/font-awesome.min.css">
<!-- Custom styles for this template -->
<link href="./css/findpass.css" rel="stylesheet" />
<script type="text/javascript" src="scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="scripts/login/login.js"></script>
<script type="text/javascript">
  $(function () {  
	     //点击图片更换验证码
	     $("#Verify").click(function(){
	        $(this).attr("src","SecurityCodeImageAction.action?timestamp="+new Date().getTime());
	      
	    });
		   
	});
</script>
<!-- <style type="text/css">
	.securitycode{
		width:100px;     
		height:31px;
		position:relative;
		top:2px;
		left:2px;
	}
</style> -->

</head>
<!-- <body>
	<form action="FindpassAction" method="post">
		请输入邮箱地址：<input type="text" name="mailname"/>
				  <input type="submit" value="确定">
	</form>

</body> -->
<body class="texture">
	<div id="cl-wrapper" class="login-container">

		<div class="middle-login">
			<div class="block-flat">
				<div class="header">
					<h3 class="text-center">
						<img class="logo-img" src="images/logo.png" alt="logo" />找回密码
					</h3>
				</div>
				<div>
					<form style="margin-bottom: 0px !important;" class="form-horizontal" action="FindpassAction" method="post">
						<div class="content">
							<h4 class="title">找回密码</h4>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" placeholder="请输入用户名" id="username" data-title="用户名/邮箱"
											name="username" class="form-control">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input type="text" placeholder="请输入邮箱" id="email" data-title="邮箱"
											name="email" class="form-control">
									</div>
								</div>
							</div>							
							
							<div class="code">							  
								<input type="text" id="password" class="securitycode" placeholder="&nbsp;请输入验证码" name="codename" data-title="验证码"/>
								<img src="SecurityCodeImageAction.action" id="Verify" width="100px" height="32px" style="cursor:pointer;" alt="看不清，换一张"/>
							</div>			
							
						</div>
						<div class="foot">
						    <a class="btn btn-default findpass"  data-dismiss="modal" href="index.jsp"
								>返回登录</a>
			
							<span class="infospan">${sc}</span>
							<button class="btn btn-primary disabled"  disabled="disabled" data-dismiss="modal" 
								type="submit">找回密码</button>
						</div>
					</form>
				</div>
			</div>
			<div class="text-center out-links">
				<a href="#">&copy; 2014 Your Company</a>
			</div>
		</div>
	</form>
	</div>
</body>
</html>