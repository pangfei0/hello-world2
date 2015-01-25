$(function(){

	$(
			"#nav>li>a[href*='"
			+ location.pathname.split('/')[location.pathname
			                               .split('/').length - 1] + location.search
			                               + "']").css

			                               ("background", "#3A7100");

	var p = $("#nav>li>ul>li>a[href*='"
			+ location.pathname.split('/')[location.pathname.split('/').length - 1]
			+ location.search + "']");
	if (p.length > 0) {
		$(p).parent().parent().parent().css("background", "#3A7100");

	}

	//初始化表格
	$.reeTable({
		'dataSource': 'LibAction',
		'dataTitle': [
		              {
		            	  'sortBy':'userName','id': 'userNo','sub_id':'userName','format': '<a class="recruitJob_btn" href="resumeInfoPage.jsp?userNo=*" >^</a> '
		              },
		              'userSex',
		              'userPhone',
		              'userAge',
		              'educationDictName',
		              'reserved01',
		              'userAddrName',{
		            	  'id': 'userNo','sub_id':'jobNo','format': '<a class="recruitJob_btn" href="resumeInfoPage.jsp?userNo=*" >查看简历</a> '+
		            	  '<a class="recruitJob_btn" href="#" data-action="Favourite_Add?userBean.userNo=*&jobBean.jobNo=0">加入收藏夹</a> ' +
		            	  '<a class="recruitJob_btn" href="#" data-form="./dialogForm/auditionJobDialog.jsp?userNo=*&jobNo=^" data-title="通知面试"  data-action="Favourite_Audition?userBean.userNo=*&jobBean.jobNo=^">通知面试</a>'
		              }]
	})
	//初始化树
	$.reeTree();
	//行业-职业
	$('.intentType')
	.change(
			function() {
				var $intents = $('.intentType');
				var $this = $(this);
				$
				.post(
						'Dict_GetIntentionDict_By_Type',
						{
							'typeName' : $(this).val()
						},
						function(d) {
							var html = '';
							for ( var s in d.store.data) {
								html += '<option value="'
									+ d.store.data[s].jobIntentionDictNo
									+ '" '
									+ '>'
									+ d.store.data[s].jobIntentionDictName
									+ '</option>';
							}
							$this.siblings(
							'select.intentJob')
							.html(
									'<option value="0">所有</option>'
									+ html);
						}, 'json')
			}).trigger('change');
})