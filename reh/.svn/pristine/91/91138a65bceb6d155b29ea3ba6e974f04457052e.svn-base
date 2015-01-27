/*
 * author:jcc
 * */

$(function(){
	
	$('#ok').click(function(){
		$.post("I_newPWD_byUserInfo.action" ,$("#alterpwd_form").serializeArray(),function(d){
			if(d.store.suc==true){
				$.Zebra_Dialog(d.store.msg,{
				  	'buttons':  false,
				    'modal': false,
				    'position': ['right -20', 'top + 20'],
				    'auto_close': 2000,
				    'onClose':  function(caption) {
 				    window.location.href="UserAction_Logout_"; 
				    }
				});
		    }else if(d.store.suc==false){
	    		$.Zebra_Dialog(d.store.msg,{
				  	'buttons':  false,
				    'modal': false,
				    'position': ['right -800', 'top + 20'],
				    'auto_close': 2000
			 });
	    	}
	    },"json");
		
	})
	$('#cancel').click(function(){
		window.location.href="after_login.jsp"; 	
	})
})

