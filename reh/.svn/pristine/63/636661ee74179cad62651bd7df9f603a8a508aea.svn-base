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
        'dataSource': 'EntJobInfo_Get_By_All',
        'dataTitle': [
                      {'sortBy':'jobName','id': 'jobNo','sub_id':'jobName','format': '<a href="jobInfoPage.jsp?jobNo=*" >^</a> '},
                      'entName', 'jobAddrPosName','educationDictName', 'jobExpDictName', 'jobSex','jobSalaryDictName',
                      'jobTypePosName',
                      {'id': 'jobIntentionDictName','sub_id':'jobIntentionDictType','format':'^-*'}, 'reserved01', 
            {'id': 'jobNo','format': '<a href="jobInfoPage.jsp?jobNo=*" >查看</a>  <a class="recruitJob_btn" href="#" data-action="EntJobInfo_recruitJob?recruitBean.id.jobNo=*">报名应聘</a>'}]
    })
    //多选插件
    $.reeMs({
    	'dataCallback':function(){}
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
	$('.intentType').change(function() {
						var $intents = $('.intentType');
						var $this = $(this);
						$.post(
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
	
	//获得querystring
    function getQueryStringByName(name) {
    var result = location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
    if (result == null || result.length < 1) {
        return "";
    }
    return result[1];
}
    method = getQueryStringByName('method');
    if(method==='custom'&&("${sessionScope.u_type}"==="0")){
    	$('.search_btn.red_btn').trigger('click');
    }
})