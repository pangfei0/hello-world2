var Major = {
/* ****************************** 单选 ********************************* */
	// 单选输出
/*	Show1: function(){
		var list= new Array()
		$.post("GetProJob.action",{},function(d){
			$.each(d.store.data,function(i,v){
				list[i]=v
			})
		})
		return list
	},*/
	Show2 : function(){
		var output='',flag,output2='';		
		$.post("GetProJob.action",{},function(d){
			for(var i in d.store.data){
				if(d.store.data[i].jobIntentionDictFatherId==-1){
					output+='<li onclick="Major.SubLayer2(\''+d.store.data[i].jobIntentionDictNo+'\')">'+d.store.data[i].jobIntentionDictName+'</li>';
				}
			}
		
		$('#drag').width('670px');
		$('#MajorList').html('<ul>'+output+'</ul>');
		// 鼠标悬停变色
		$('#MajorAlpha li').hover(function(){$(this).addClass('over')},function(){$(this).removeClass('over')});	
		// 点击弹出子菜单
		$('#MajorList li').click(function(e){$("#sublist").css({top:e.pageY-4,left:e.pageX-4}).hover(function(){$(this).show()},function(){$(this).hide()})})
		})
	},
	// 子职位 悬浮菜单
	SubLayer2 : function(id){		
			var output='',width;
			var myid=id;
			var len=0;		
			$.post("GetProJobById.action",{"id":myid},function(d){
				for(var i in d.store.data){
					output+='<li><a href="javascript:" onclick="Major.Chk2(\''+d.store.data[i].jobIntentionDictName+'\')">'+d.store.data[i].jobIntentionDictName+'</a></li>';
					len++;
				}		
			width=len>10?440:220;
			output='<div id="sub_funtype" class="radio"><ul style="width:'+width+'px">'+output+'</ul></div>';
			$("#sublist").html(output).show();
		})
	},
	Chk2 : function(id){
		$('#btn_MajorID_2').val(id);
		$('#MajorID_2').val(id.jobIntentionDictName);
		$("#sublist").empty().hide();
		boxAlpha();
	}
}
// 单选
function majorSelect_2(){
	var dragHtml ='<div id="MajorAlpha">';			//职能类别
		dragHtml+='		<div id="MajorList"></div>';	//职能类别列表
		dragHtml+='</div>';
	$('#drag_h').html('<b>请选择专业</b><span onclick="boxAlpha()">关闭</span>');
	$('#drag_con').html(dragHtml);
	Major.Show2();
	boxAlpha();
	draglayer();
}