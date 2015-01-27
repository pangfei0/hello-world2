$(function(){

	//初始化表格
    $.reeTable({
        'dataSource': 'RecruitJob_GetBlackList_By_EntNo',
        'dataTitle': [
        	'id.userCert',{
        	'id': 'id.entNo','sub_id':'id.userCert','format': ' <a class="recruitJob_btn" href="#" data-action="BlackList_Del?userCert=^">删除</a> '
        	+'<a class="recruitJob_btn" href="#" data-form="./dialogForm/entBlacklistUserDialog.jsp?entNo=*&userCert=^" data-title="修改"  data-action="BlackList_Alter?userCert=^">修改</a>'
        }]
    })
	
})