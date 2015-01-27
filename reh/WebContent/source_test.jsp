<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="./css/style.css" rel="stylesheet" type="text/css" />
<link href="./css/main.css" rel="stylesheet" type="text/css" />
<link href="./css/zebra_dialog.css" rel="stylesheet" type="text/css" />
<link href="./css/pagination.css" rel="stylesheet" />
<link href="./css/ree-dialog.css" rel="stylesheet" />
<script type="text/javascript" src="scripts/public/jquery-1.10.2.js"></script>
<script type="text/javascript" src="scripts/public/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="scripts/public/zebra_dialog.js"></script>

<script type="text/javascript" src="./scripts/public/reload.js"></script>
<script type="text/javascript" src="./scripts/public/ree-table.js"></script>
<script type="text/javascript" src="./scripts/public/ree-multiselect.js"></script>
<script type="text/javascript" src="./scripts/public/formToJson.js"></script>
<script type="text/javascript" src="scripts/public/uniqueArray.js"></script>
<script src="dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	if("${sessionScope.msg}"!="")
		 $.Zebra_Dialog("${sessionScope.msg}",{
			  'buttons':  false,
			    'modal': false,
			    'position': ['right - 20', 'top + 20'],
			    'auto_close': 2000
		 }); 
	
})

</script>