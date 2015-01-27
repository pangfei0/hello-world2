$(function(){
		//province;
		//proSchool;
	
		//学校名称 激活状态
		$("#schoolName").focus(function(){
    	  var top = $(this).pageY-4;
    	  var left = $(this).pageX-4;
    	  $("div[class='provinceSchool']").css({top:top,left:left});
    	  $("div[class='provinceSchool']").show();
		});
		
		
		//初始化省下拉框
		var provinceArray = "";
		var provicneSelectStr = "";	
		$.post("GetCommunitybyall",{},function(d){
			for(var i in d.store.data){
				if(d.store.data[i].communityFatherNo==1){
					provicneSelectStr=provicneSelectStr+"<option value='"+d.store.data[i].communityNo+"'>"+d.store.data[i].communityName+"</option>"
				}
			}
			$("div[class='proSelect'] select[class='select1']").html('<option></option>'+provicneSelectStr);
		});
		
		$("div[class='proSelect'] select[class='select1']").change(function(){
			$(".select2").html("");
			var no=$("div[class='proSelect'] select[class='select1']").val();				
			$.post("GetCommunitybyfatherno",{"fatherno":no},function(d){
				var provicneSelectStr1 = "<option></option>";
				for(var i in d.store.data){
						provicneSelectStr1=provicneSelectStr1+"<option value='"+d.store.data[i].communityNo+"'>"+d.store.data[i].communityName+"</option>"
				}				
				$("div[class='proSelect'] select[class='select2']").html(provicneSelectStr1);
			})
		});
		
		//初始化学校列表
		$("div[class='proSelect'] select[class='select2']").change(function(){
			var selectPro = $("div[class='proSelect'] select[class='select2']").val();	
			$.post("GetCommunitybyfatherno",{"fatherno":selectPro},function(d){
				var schoolUlStr="";
				for(var i in d.store.data){
					schoolUlStr = schoolUlStr + "<li>"+d.store.data[i].communityName+"</li>"
				}
				$("div[class='schoolList'] ul").html(schoolUlStr);
			})
		});
		//学校列表mouseover事件
		$("div[class='schoolList'] ul li").bind("mouseover",function(){
		  $(this).css("background-color","#72B9D7");
		});
		//学校列表mouseout事件
		$("div[class='schoolList'] ul li").bind("mouseout",function(){
		  $(this).css("background-color","");
		});
		//学校列表点击事件
		$("div[class='schoolList'] ul li").live("click",function(){
		  var addr="苏州市"+$("div[class='proSelect'] select[class='select1']").find('option:selected').text()+
		  $("div[class='proSelect'] select[class='select2']").find('option:selected').text();
		  $("#schoolName").val(addr+$(this).html());
		  $("div[class='provinceSchool']").hide();
		});
		//按钮点击事件
		$("div[class='button'] button").bind("click",function(){
		  var flag = $(this).attr("flag");
		  if("0"==flag){
		    $("div[class='provinceSchool']").hide();
		  }else if("1"==flag){
			  var addr="苏州市"+$("div[class='proSelect'] select[class='select1']").find('option:selected').text()+
			  $("div[class='proSelect'] select[class='select2']").find('option:selected').text();
		      $("#schoolName").val(addr);
		      $("div[class='provinceSchool']").hide();
		  }
		});
	  });
													