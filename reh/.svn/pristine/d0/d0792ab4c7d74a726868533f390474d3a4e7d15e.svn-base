$(function(){
	$("#eduaddbtn").click(function(){
		document.getElementById("edualter").style.display="none";
		document.getElementById("eduright").style.display="";
	})
	$("#educancel").click(function(){
		document.getElementById("eduright").style.display="none";
		document.getElementById("edualter").style.display="none";
	})
	$("#edubtn").click(function(){
		 var No = document.getElementById("eduNo").value;
		 var Name = document.getElementById("eduName").value;
		 var type = document.getElementById("ruletype").value;
		 $.ajax({
			 url:"DictAction_eduAdd",
			 data:{"ruleNo":No,"ruleName":Name,"ruletype":type},
			 success:function(data){
				 navTabAjaxDone(data);
			 }
		 });
	})
	$("#edualterbtn").click(function(){
		document.getElementById("eduright").style.display="none";	
		var No=0;
		var radio = document.getElementsByName("ruleid");
        for(var i=0;i<radio.length;i++){
            if(radio[i].checked){
                No=radio[i].value;
            }
        }
        if(!!$('[name="ruleid"]:checked').length){

        	$.ajax({
   			 url:"DictAction_SeeeduAlter",
   			 data:{"alterNo":No},
   			 success:function(d){
   				 document.getElementById("edualter").style.display="";
   				 $("#eduNo1").val(d.store.data[0].educationDictNo);
   				 $("#eduName1").val(d.store.data[0].educationDictName);
   				 $("#ruletype1").val(d.store.data[0].educationDictType);
   			 }
   		 });
        }
        
	})
	$("#edualbtn").click(function(){
		
		 var No = document.getElementById("ruleNo1").value;
		 var Name = document.getElementById("ruleName1").value;
		 var type = document.getElementById("ruletype1").value;
		 $.ajax({
			 url:"DictAction_eduAlter",
			 data:{"ruleNo":No,"ruleName":Name,"ruletype":type},
			 success:function(data){
				 navTabAjaxDone(data);
				 //alertMsg.correct(data.message);
			 }
		 });
	})	
		
})