$(function() {
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
    	//'dialogCSS':'abc',
        'dataSource': 'EntJobInfo_Get_By_EntNo',
        'dataTitle': [
                      {'sortBy':'jobName','id': 'jobNo','sub_id':'jobName','format': '<a href="jobInfoPage.jsp?jobNo=*" >^</a> '}
        , 'jobStateName', 'jobAddrPosName','educationDictName', 'jobExpDictName', 'jobSex','jobSalaryDictName',
        'jobTypePosName',
        {'id': 'jobIntentionDictName','sub_id':'jobIntentionDictType','format':'^-*'}, 
            {'id': 'jobNo','format': '<a href="jobInfoPage.jsp?jobNo=*" >查看</a> '
            	+'<a href="#" data-action="EntJobInfo_Del?jobBean.jobNo=*" class="del_btn" target="">删除</a> '
            	+'<a href="#" data-form="./dialogForm/modifyJobDialog.jsp?jobNo=*" data-title="修改" data-action="EntJobInfo_Modify" class="notify_btn" target="">修改</a>'}]
    })
	//初始化树
	$.reeTree({
		// value是否使用ID （搜索时不建议使用）
		useID : false,
		// 节点ID字段
		idTag : 'intentAddrNo',
		// 节点name字段
		nameTag : 'intentAddrName',
		// 父节点ID字段
		parentidTag : 'intentFatherNo',
		// 节点数据字段
		dataTag : 'intentAddr',
		// 数据源
		url : 'communityJSONAction_intent'
	});
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
