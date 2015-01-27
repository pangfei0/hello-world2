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

	// 初始化表格
	$.reeTable({
		'dataSource' : 'RecruitJob_Get_By_UserNo',
		'dataTitle' : [ {
			'sortBy':'jobName','id': 'jobNo','sub_id':'jobName','format': '<a href="jobInfoPage.jsp?jobNo=*" >^</a> '
				}, 
		                'entName',
		                'trytime', 
		                'membertime',
		                'stateName',
		                'reserved01',
		                {
					'id': 'userNo','sub_id':'jobNo',
					'format': '<a class="recruitJob_btn" href="resumeInfoPage.jsp?userNo=*&jobNo=^">就业跟踪</a>'} ],
		                'dataParams' : {
		                	'id01' : 'userNo',
		                	'id02' : 'jobNo'
		                }
	});
	$('.info_table tr:gt(0) td:contains("面试")').live(
		{
			mouseenter : function() {
			$this = $(this);
			$this.data('txt',$this.text());
			tr = $this.parent('tr');
			var txt = $this.text();
			if(!$this.data('is'))
				{
				$this.text('载入中...');
				$.post('Favourite_AuditionView', {
					'userBean.userNo' : tr.data('id01'),
					'jobBean.jobNo' : tr.data('id02')
				}, function(d) {
					$this.html("<a onmouseover=this.style.cssText='text-decoration:none;' title='"+d.store.msg+"'>面试信息详情</a>");
					new elem_alt($this, 'a','title','10px');
					$this.data('is',true);
				}, 'json');
				}
			
		},
		mouseleave : function() {
//		$this = $(this);
//		setTimeout(function() {
//		$this.text($this.data('txt'));
//		}, 2000)
		}
	});
	 //$(document).tooltip({track: true});

});