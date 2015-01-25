$(function(){		
		var output="";
		var head="<table>";
		var foot="<table>";
		$.post("I_toTrain_byNewNoAndUserNo.action",{"listno":6,"c":1,"p":10,"orderField":"newsTitle","orderDirection":"desc","keyword":""},function(d){			
	    		for ( var i in d.store.data) {
	    			output += '<tr>'+'<td>'+ d.store.data[i].newsSubmittime+ '</td>'+'<td>'+ d.store.data[i].newsTrainEndtime+ '</td>'+
	    			'<td>'+ d.store.data[i].newsTitle+ '</td>'+
	    			'<td>'+ '<a href="news.jsp?nid='+d.store.data[i].newsNo+'">点击查看</a>'+ '</td>'
	    			+'</tr>'
				}
	    		$(".train").html(head+output+foot);
	    	})
})