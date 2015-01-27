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
        'dataSource': 'RecruitJob_Get_By_EntNo',
        'dataTitle': [{
        	'sortBy':'userName','id': 'userNo','sub_id':'userName','format': '<a class="recruitJob_btn" href="resumeInfoPage.jsp?userNo=*" >^</a> '}, 
        	{'sortBy':'jobName','id': 'jobNo','sub_id':'jobName','format': '<a href="jobInfoPage.jsp?jobNo=*" >^</a> '}, 'jobAddrPosName', 'userAge', 'educationDictName', 'submittime','stateName',{
        	'id': 'userNo','sub_id':'jobNo','format': '<a class="recruitJob_btn" href="#" data-action="Favourite_Add?userBean.userNo=*&jobBean.jobNo=^">加入收藏夹</a>'
        	+' <a class="recruitJob_btn" href="#" data-action="Favourite_Refuse?userBean.userNo=*&jobBean.jobNo=^">拒绝</a> '
        	+'<a class="recruitJob_btn" href="#" data-form="./dialogForm/auditionJobDialog.jsp?userNo=*&jobNo=^" data-title="通知面试"  data-action="Favourite_Audition?userBean.userNo=*&jobBean.jobNo=^">通知面试</a>'
        	+' <a class="recruitJob_btn" href="resumeInfoPage.jsp?userNo=*&&jobNo=^" >就业跟踪/查看简历</a> '
        }]
    })
	
})