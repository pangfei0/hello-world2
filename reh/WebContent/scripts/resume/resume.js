$(function(){
	$("#resume").click(function(){
		$.post("I_GetProFile_byUserNo.action",{"userno":75},function(d){
			for(var i in d.store.rdata){//基本信息
				
			}			
			for(var i in d.store.cdata){//工作经验
				
			}
			for(var i in d.store.edata){//教育背景
				
			}
			for(var i in d.store.pdata){//项目经验
				
			}
			for(var i in d.store.tdata){//培训经历
				
			}
			for(var i in d.store.adata){//其他能力
				
			}
			for(var i in d.store.sdata){//补充信息
				
			}
		})
	})
})