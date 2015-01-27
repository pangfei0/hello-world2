$(function(){
	$("#addbtn").click(function(){
		document.getElementById("alter").style.display="none";
		document.getElementById("right").style.display="";
	})
	$("#cancel").click(function(){
		document.getElementById("right").style.display="none";
		document.getElementById("alter").style.display="none";
	})
	$("#btn").click(function(){
		 var No = document.getElementById("ruleNo").value;
		 var Name = document.getElementById("ruleName").value;
		 var Score = document.getElementById("ruleScore").value;
		 var For = document.getElementById("ruleFor").value;
		 $.ajax({
			 url:"DictAction_Add",
			 data:{"ruleNo":No,"ruleName":Name,"ruleScore":Score,"ruleFor":For},
			 success:function(data){
				 navTabAjaxDone(data);
			 }
		 });
	})
	$("#alterbtn").click(function(){
		document.getElementById("right").style.display="none";	
		var No=0;
		var radio = document.getElementsByName("ruleid");
        for(var i=0;i<radio.length;i++){
            if(radio[i].checked){
                No=radio[i].value;
            }
        }
        if(!!$('[name="ruleid"]:checked').length){
        	$.ajax({
   			 url:"DictAction_SeeAlter",
   			 data:{"alterNo":No},
   			 success:function(d){
   				 document.getElementById("alter").style.display="";
   				 $("#ruleNo1").val(d.store.data[0].ruleNo);
   				 $("#ruleName1").val(d.store.data[0].ruleName);
   				 $("#ruleScore1").val(d.store.data[0].ruleScore);
   				 $("#ruleFor1").val(d.store.data[0].ruleFor);
   			 }
   		 });
        }
        
	})
	$("#albtn").click(function(){
		
		 var No = document.getElementById("ruleNo1").value;
		 var Name = document.getElementById("ruleName1").value;
		 var Score = document.getElementById("ruleScore1").value;
		 var For = document.getElementById("ruleFor1").value;
		 $.ajax({
			 url:"DictAction_Alter",
			 data:{"ruleNo":No,"ruleName":Name,"ruleScore":Score,"ruleFor":For},
			 success:function(data){
				 navTabAjaxDone(data);
				 //alertMsg.correct(data.message);
			 }
		 });
	})	
		
})