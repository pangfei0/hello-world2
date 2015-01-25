<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.ree.enterprise.EntJobDao,com.ree.hibernate.RepEntJobInfoViewId,com.ree.dict.DictAdapter,com.ree.community.communityAdapter"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	EntJobDao eDao = new EntJobDao();
	DictAdapter da = new DictAdapter();
	communityAdapter ca = new communityAdapter();
	request.setAttribute("da", da);
	request.setAttribute("ca", ca);
	if (request.getParameter("jobNo") != null
			&& !"".equals(request.getParameter("jobNo"))) {
		RepEntJobInfoViewId bean = eDao.GetEntJobInfo_By_jobNo(Integer
				.parseInt(request.getParameter("jobNo")));
		request.setAttribute("bean", bean);
	}
%>
<html>
<head>
<script>
$(document).ready(function() {
    //tree_init
    Clear();
    $("#treeview2").btechcotree({
        idTag: 'intentAddrNo',
        nameTag: 'intentAddrName',
        parentidTag: 'intentFatherNo',
        dataTag: 'intentAddr',
        containerid: "treeview2",
        url: 'communityJSONAction_intent',
        datatype: $treedatatype.Json,
        dataformat: $treedataformat.Linear,
        class_node_collapse: "ui-icon-circle-minus",
        class_node_expand: "ui-icon-circle-plus"

        ,
        class_node_item: "ui-icon-clipboard",
        collapse_tree: true,
        class_node_highlight: "ui-state-highlight",
        show_button_check: false

        ,
        onselectednode: function(id, node, sender) {
        	$('#'+this.containerid).toggle();
        	console.log(1);
            $('input.addrTree2').val(id);
            $('label.addrTree2').text(node.data('data'));
        }
    });
    //编辑器
    if ($.fn.xheditor) {
        $("textarea.editor", $('form')).each(function() {
            var $this = $(this);
            var op = {
                html5Upload: false,
                skin: 'default',
                tools: $this.attr("tools") || 'full'
            };
            var upAttrs = [["upLinkUrl", "upLinkExt", "zip,rar,txt,doc"], ["upImgUrl", "upImgExt", "jpg,jpeg,gif,png"], ["upFlashUrl", "upFlashExt", "swf"], ["upMediaUrl", "upMediaExt", "avi"]];

            $(upAttrs).each(function(i) {
                var urlAttr = upAttrs[i][0];
                var extAttr = upAttrs[i][1];

                if ($this.attr(urlAttr)) {
                    op[urlAttr] = $this.attr(urlAttr);
                    op[extAttr] = $this.attr(extAttr) || upAttrs[i][2];
                }
            });

            $this.xheditor(op);
        });
    }
    //地址树
    $("label.addrTree2").click(function() {
        $("#treeview2").toggle();
    });
    //树清空方法
    function Clear() {
        $("#treeview2").empty();
    }
    //行业-职业
    $('.intentType2').change(function() {
        var $intents = $('.intentType2');
        var $this = $(this);
        $.post('Dict_GetIntentionDict_By_Type', {
            'typeName': $(this).val()
        },
        function(d) {
            var html = '';
            for (var s in d.store.data) {
                html += '<option value="' + d.store.data[s].jobIntentionDictNo + '" ' + ("${requestScope.bean.jobIntentionDictNo}" == d.store.data[s].jobIntentionDictNo ? 'selected': '') + '>' + d.store.data[s].jobIntentionDictName + '</option>';
            }
            $this.closest('div.apply_item').find('select.intentJob').html(html);
        },
        'json');
    }).trigger('change');
});
</script>
<link href="./css/dialog_style.css" rel="stylesheet" />
<style>
#treeview2 ul {
	margin: 0 0 10px 25px;
	padding: 0;
}
</style>
</head>
<body>
	<form action="" method="post">
		<div style="width:640px;height:auto">
			<input type="hidden" name="jobBean.jobNo"
				value="${requestScope.bean.jobNo }" /><br>
			<div class="apply_item">
				<div class="apply_tag">职位名称:</div>
				<div class="apply_input">
					<input name="jobBean.jobName" type="text"
						value="${requestScope.bean.jobName }" />
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">性别要求:</div>
				<div class="apply_input">
					<label style="margin-left:20px">男：</label><input
						name="jobBean.jobSex" type="radio" style="width:15px;margin:5px"
						;
				${requestScope.bean==null?"checked='checked'":'' }
						${requestScope.bean.jobSex=='男'?"checked='checked'":'' } value="男" />
					<label>女：</label><input style="width:15px;margin:5px;"
						name="jobBean.jobSex" type="radio"
						${requestScope.bean.jobSex=='女'?'checked=\"checked\"':''}
						value="女" /> <label>不限：</label><input name="jobBean.jobSex"
						type="radio" style="width:15px;margin:5px"
						${requestScope.bean.jobSex=='男,女'?'checked=\"checked\"':'' }
						value="男,女" />
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">职业倾向/意愿:</div>
				<div class="apply_input">
						<label style="margin-left:20px;font-size:14px;font-weight:bold;">行业：</label> <select
							class="intentType2" style="margin-left:0px;width:176px">
							<c:forEach var="dict"
								items="${requestScope.da.GetIntentionDictDistinct() }">
								<option
									${da.GetIntentionDictType_By_No(requestScope.bean.jobIntentionDictNo)==dict.jobIntentionDictType?'selected':''}>
									${dict.jobIntentionDictType}</option>
							</c:forEach>
						</select>
				</div>
				<div class="apply_input">
				 <label style="margin-left:20px;font-size:14px;font-weight:bold;">职业：</label> <select
							class="intentJob" style="margin-left:0px;width:176px"
							name="jobBean.jobIntentionDictNo">
						</select>
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">工作地点:</div>
				<div class="apply_input">
					<input type="hidden" name="jobBean.jobAddrPosNo"
						value="${requestScope.bean.jobAddrPosNo }" class="addrTree2" /><label
						class="addrTree2" style="margin-left:20px;display: block;">${requestScope.bean.jobAddrPosName
						}- 请点击并选择</label>
					<%-- ${requestScope.ca.GetCommunityBean_By_id(requestScope.bean.jobAddrPos).communityAddr }  --%>
					<div id="treeview2"
						style="display:none;float:left;background-color: #999;margin-left:20px;margin-bottom:5px;padding-right:10px;z-index: 200000;position: absolute;"></div>
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">招聘人数:</div>
				<div class="apply_input">
					<input onkeyup="this.value=this.value.replace(/\D/g,'')"
						onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"
						name="jobBean.jobPnum" value="${requestScope.bean.jobPnum }" />
				</div>
			</div>
			
			<div class="apply_item">
				<div class="apply_tag">职位性质:</div>
				<div class="apply_input">
					<select name="jobBean.jobTypePos">
						<option value="1" ${requestScope.bean.jobTypePos==1?'selected':''}>全职</option>
						<option value="2" ${requestScope.bean.jobTypePos==2?'selected':''}>兼职</option>
						<option value="3" ${requestScope.bean.jobTypePos==3?'selected':''}>实习</option>
					</select>
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">薪金待遇:</div>
				<div class="apply_input">
					<select name="jobBean.jobSalaryNo">
						<c:forEach var="dict" items="${requestScope.da.GetSalaryDict() }">
							<option value="${dict.jobSalaryDictNo }"
								${requestScope.bean.jobSalaryNo==dict.jobSalaryDictNo?'selected':''}>${dict.jobSalaryDictName
								}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">学历要求:</div>
				<div class="apply_input">
					<select name="jobBean.educationDictNo">
						<c:forEach var="dict"
							items="${requestScope.da.GetEducationDict() }">
							<option value="${dict.educationDictNo }"
								${requestScope.bean.educationDictNo==dict.educationDictNo?'selected':''}>${dict.educationDictName
								}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">工作经验:</div>
				<div class="apply_input">
					<select name="jobBean.jobExpDictNo">
						<c:forEach var="dict" items="${requestScope.da.GetExpDict() }">
							<option value="${dict.jobExpDictNo }"
								${requestScope.bean.jobExpDictNo==dict.jobExpDictNo?'selected':''}>${dict.jobExpDictName
								}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">年龄要求:</div>
				<div class="apply_input">
					<select name="jobBean.jobAgeNo">
						<c:forEach var="dict" items="${requestScope.da.GetAgeDict() }">
							<option value="${dict.ageNo }"
								${requestScope.bean.jobAgeNo==dict.ageNo?'selected':''}>${dict.ageName
								}以上</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">开始招聘时间:</div>
				<div class="apply_input">
					<input type="text" name="jobBean.jobStartTime"
						value="${requestScope.bean.jobStartTime}"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
						class="Wdate" />
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">结束招聘时间:</div>
				<div class="apply_input">
					<input type="text" name="jobBean.jobEndTime"
						value="${requestScope.bean.jobEndTime}"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
						class="Wdate" />
				</div>
			</div>
			<div class="apply_item">
				<div class="apply_tag">职位描述:</div>
			</div>
			<div class="center">
				<textarea class="editor required" rows="10" cols="70"
					upLinkUrl="uploadfile" upLinkExt="zip,rar,doc,docx"
					upImgUrl="uploadfile" upImgExt="jpg,jpeg,gif,png"
					upFlashUrl="upload.php" upFlashExt="swf" upMediaUrl="upload.php"
					upMediaExt="avi" name="jobBean.jobDecribe">${requestScope.bean.jobDecribe }</textarea>

			</div>
		</div>
	</form>
</body>
</html>