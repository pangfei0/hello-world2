$(function(){
	$("#jobaddbtn").click(function(){
		document.getElementById("jobalter").style.display="none";
		document.getElementById("jobright").style.display="";
	})
	$("#jobcancel").click(function(){
		document.getElementById("jobright").style.display="none";
		document.getElementById("jobalter").style.display="none";
	})
	$("#jobbtn").click(function(){
		 var No = document.getElementById("jobintno").value;
		 var Name = document.getElementById("jobintname").value;
		 var type = document.getElementById("jobinttype").value;
		 $.ajax({
			 url:"DictAction_JobAdd",
			 data:{"jobintno":No,"jobintname":Name,"jobinttype":type},
			 success:function(data){
				 navTabAjaxDone(data);
			 }
		 });
	})
	$("#jobalterbtn").click(function(){
		document.getElementById("jobright").style.display="none";	
		var No=0;
		var radio = document.getElementsByName("jobintid");
        for(var i=0;i<radio.length;i++){
            if(radio[i].checked){
                No=radio[i].value;
            }
        }
        if(!!$('[name="jobintid"]:checked').length){
        $.ajax({
			 url:"DictAction_SeeJobAlter",
			 data:{"alterNo":No},
			 success:function(d){
				 document.getElementById("jobalter").style.display="";
				 $("#jobintno1").val(d.store.data[0].jobIntentionDictNo);
				 $("#jobintname1").val(d.store.data[0].jobIntentionDictName);
				 $("#jobinttype1").val(d.store.data[0].jobIntentionDictType);
			 }
		 });
        }
	})
	$("#jobalbtn").click(function(){
		 var No = document.getElementById("jobintno1").value;
		 var Name = document.getElementById("jobintname1").value;
		 var type = document.getElementById("jobinttype1").value;
		 $.ajax({
			 url:"DictAction_JobAlter",
			 data:{"jobintno":No,"jobintname":Name,"jobinttype":type},
			 success:function(data){
				 navTabAjaxDone(data);
			 }
		 });
	})	
		
})