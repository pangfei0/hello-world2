$(function() {
	$('#newslist').click(function news() {
		var listno;
		$.post("I_GetListNo_by_all.action", {}, function(d) {
			for ( var i in d.store.data) {
				listno = d.store.data[i].listNo
				if (listno == $("#listno").val()) {
					/*
					 * title
					 */
					document.writeln(d.store.data[i].listName);
					/*
					 * URL
					 */
					document.writeln(d.store.data[i].listUrl);
					document.writeln("<br>");
					$.post("I_GetNewsItem_byListNo.action", {
						"listNo" : listno
					}, function(d) {
						/*
						 * count
						 */
						document.writeln(d.store.num);
						document.writeln("<br>");
						for ( var i in d.store.data) {
							document.writeln(d.store.data[i].newsTitle);
							document.writeln(d.store.data[i].newsSubmittime);
							document.writeln(d.store.data[i].newsAuthor);
							document.writeln("<br>");
						}
					})
				}
			}
		})
	})
})