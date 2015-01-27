/*
 * author:jcc
 * */

$(function(){
		var userNo = $("#userNo").val();
		$.post("I_GetUserBox_byUserNo.action" ,{"userNo":userNo},function(d){
			/*$("#each").append(function(){*/
				alert("已投保职位数："+d.store.recruitNum+"<br/>"+"已回应职位数:" + d.store.recruitHasStateNum);
		/*	});*/
	    },"json");
});
