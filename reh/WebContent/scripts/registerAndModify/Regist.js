
$(function(){
	//用户注册表单验证
  $("#testform2").validate({
        rules:{
    	USER_UID:{
    		required:true,
            
    	},
        USER_NAME:{
            required:true,
            rangelength:[6,10]
        },
        USER_EMAIL:{
             required:true,
             email:true
        },
        USER_PWD:{
             required:true,
             rangelength:[6,10]
        },
        USER_PWD1:{
            required:true,
             equalTo:"#USER_PWD"
         },
         USER_SEX:{
        	 required:true
         }
        },//end rules
        messages:{
        	USER_UID:{
        		required:"请输入您的用户名 ",
        		rangelength:"您的用户名必须6-10个字符！"
        		},
        	USER_NAME:{
	            required:"请输入您的姓名",
	            rangelength:"您的企业名称必须满足6-10个字符!"
	            },
            USER_EMAIL:{
	            required:"请输入您的邮箱地址",
	            email:"您输入的邮箱地址不正确！"
	            },
            USER_PWD:{
	            required:"请输入您的用户密码",
	            rangelength:"您的密码必须满足6-10个字符!"
	            },
	        USER_PWD1:{
	            required:"请您再次输入密码",
	            equalTo:"两次密码不一致，请重新输入！"
	           },
	        USER_SEX:{
	            	 required:"请您选择性别"
	            }
        },//end messages
        errorPlacement:function(error,element){
            if(element.is(":radio")||element.is(":checkbox"))
                {
                error.appendTo(element.parent());
                }
            else
                {
                error.insertAfter(element);
                }
        },
        //提交操作
        submitHandler:function(form){ 	
        $.post("I_Register_byUserInfo.action", $("#testform2").serialize(),
				    function(data){
        	 if(data.status==true)
 			{
				  
					   $.Zebra_Dialog(data.mes,{
						  	'buttons':  false,
						    'modal': false,
						    'position': ['right -800', 'top + 20'],
						    'auto_close': 1500,
						    'onClose':  function(caption) {
						    window.location.href=""+"after_login.jsp"+""; 
						                                   }
						
				                     }       );
              }
			   else
			   {
				   $.Zebra_Dialog(data.mes,{
					  	'buttons':  false,
					    'modal': false,
					    'position': ['right -800', 'top + 20'],
					    'auto_close': 1500
				                              });
			   }
			   
				       
				         });
          

         

      	  
       }
    });
//企业注册表单验证
	$("#testform").validate({
        rules:{
        	entUid:{
        		required:true,
                
        	},
            entName:{
                required:true,
                rangelength:[6,10]
            },
         entEmail:{
             required:true,
             email:true
         },
         entPwd:{
             required:true,
             rangelength:[6,10]
         },
         entPwd1:{
             required:true,
              equalTo:"#entPwd"
          }   
        },//end rules
        messages:{
        	entUid:{
        		required:"请输入您的用户名 ",
        		rangelength:"您的用户名必须6-10个字符！"
        		},
            entName:{
            required:"请输入您的企业名称",
            rangelength:"您的企业名称必须满足6-10个字符!"
            },
        entEmail:{
            required:"请输入您的邮箱地址",
            email:"您输入的邮箱地址不正确！"
        },
        entPwd:{
            required:"请输入您的企业密码",
            rangelength:"您的企业密码必须满足6-10个字符!"
            },
        entPwd1:{
            required:"请您再次输入密码",
            equalTo:"两次密码不一致，请重新输入！"
           }
       //passWord1:{
          //  required:"Please type Comfirm_Password!",
            //equalTo:"This is not match the Password!"
            //}
        },//end messages
        errorPlacement:function(error,element){
            if(element.is(":radio")||element.is(":checkbox"))
                {
                error.appendTo(element.parent());
                }
            else
                {
                error.insertAfter(element);
                }
        },
        submitHandler:function(form){ 
        	
        	$.post("I_Register_byEntInfo.action", $("#testform").serialize(),
				    function(data){
				   if(data.status==true)
        			{
					  
						   $.Zebra_Dialog(data.mes,{
							  	'buttons':  false,
							    'modal': false,
							    'position': ['right -800', 'top + 20'],
							    'auto_close': 1500,
							    'onClose':  function(caption) {
							    window.location.href=""+"after_login.jsp"+""; 
							                                   }
							
					                     }       );
                     }
				   else
				   {
					   $.Zebra_Dialog(data.mes,{
						  	'buttons':  false,
						    'modal': false,
						    'position': ['right -800', 'top + 20'],
						    'auto_close': 1500
					                              });
				   }
				   
        	});
        }
				
         });

 
 

  // $("#submit").click(function(){
	 // $.post("I_Register_byEntInfo.action", $("#testform").serialize(),
				   // function(data){
				        /*  document.getElementById("1").value=data.str2; */
				     //   alert(data.mes+"  "+data.status);
				      //  window.open("http://localhost:8080/reh");
				       /* alert(data.mes+"+++"+data.status+"+++"+data.u_type+"+++"+data.lastTime); */
				       //  });
	 // }); 
	
});
