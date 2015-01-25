/*
 * author:jcc
 * */

$(function(){
	
	//点击图片更换验证码
    $("#Verify").click(function(){
       $(this).attr("src","SecurityCodeImageAction.action?timestamp="+new Date().getTime());
     });
 
	$('#user_btn').click(function(){
	     //点击登录按钮
		$.post("I_Login_byUserInfo.action" ,$("#login_form").serializeArray(),function(d){
			if(d.store.suc==true && d.store.u_type==0)
	    	{
				$.Zebra_Dialog(d.store.msg,{
				  	'buttons':  false,
				    'modal': false,
				    'position': ['right -800', 'top + 20'],
				    'auto_close': 1000,
				    'onClose':  function(caption) {
				    	//alert((caption != '' ? '"' + caption + '"' : 'nothing') + ' was clicked');
				    	window.location.href=""+d.store.fjsp+""; 
				    }
				});
	    		// window.location.href="test_jcc.jsp?name='"+data.store.store_key.userName+"'"; 
	    	}else if(d.store.suc==true && d.store.u_type==1){
	    		$.Zebra_Dialog(d.store.msg,{
				  	'buttons':  false,
				    'modal': false,
				    'position': ['right -800', 'top + 20'],
				    'auto_close': 1000,
				    'onClose':  function(caption) {
				    	//alert((caption != '' ? '"' + caption + '"' : 'nothing') + ' was clicked');
				    	window.location.href=""+d.store.fjsp+""; 
				    }
				});
	    		//window.location.href=""+d.store.fjsp+""; 
	    	}
			else if(d.store.suc==false){
	    		$.Zebra_Dialog(d.store.msg,{
				  	'buttons':  false,
				    'modal': false,
				    'position': ['right -800', 'top + 20'],
				    'auto_close': 1000
			 });
	    	//window.location.href=""+data.store.fjsp+""; 
	    	}
	    },"json");
  })
});
