//$(function() {
//	$('#newsinfo').click(function news() {
//		var listno;
//		$.post("I_GetListNo_by_all.action", {}, function(d) {
//			for ( var i in d.store.data) {
//				listno = d.store.data[i].listNo
//				$.post("I_GetNewsItem_byListNo.action", {
//					"listNo" : listno
//				}, function(d) {
//					for ( var i in d.store.data) {
//						newsno = d.store.data[i].newsNo
//						document.writeln(newsno);
//						if (newsno == $("#newsno").val()) {
//							$.post("I_GetNewsInfo_byNewsNo.action", {
//								"newsNo" : newsno
//							}, function(d) {
//								document.writeln(d.store.data.newsTitle);
//								document.writeln(d.store.data[i].newsSubmittime);
//								document.writeln(d.store.data[i].newsAuthor);
//								document.writeln("<br>");
//							})
//						}
//					}
//				})
//			}
//		})
//	})
//})
$(function(){
	$("#newsinfo").click(function news(){
//		var newsno;
//		if(newsno==$("#newsno").val()){
			$.post("I_GetNewsItem_byListNo.action",{
//				"newNo":newsno
			},function(d){
				for ( var i in d.store.data) {
					document.writeln(d.store.data[i].newsTitle);
					document.writeln(d.store.data[i].newsSubmittime);
					document.writeln(d.store.data[i].newsAuthor);
					document.writeln("<br>");
				}
			})
//		}
	})
})













