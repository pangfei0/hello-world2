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
	//初始社区化树
	$.reeTree({
		'useID' : true
	});
	//初始化意向树
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
		dataTag : ['intentFatherNo','intentAddrLever'],
		// 容器ID
		containerid : 'treeview2' + (new Date()).valueOf(),
		// label选择器
		label : 'label.addrTree2',
		// value选择器
		value : 'input:hidden.addrTree2',
		// 数据源
		url : 'communityJSONAction_intent',
		// 是否可选
		show_button_check : true,
		// 多选事件
		onnodecheckselected : function(id, node, sender) {
			//tree
			var $tree = $('#' + this.containerid);
			var data = $tree.btechcotree
			.SelectedData();
			var value = [];
			var name = [];
			$(data).each(function(i, e) {
				if ($tree.find('li[data-fatherid="'+e.id+'"]').length==0) {
					value.push(e.id);
					name.push(e.name);
				}

			})
			$('label.addrTree2').text(name.join('-'));
			$('input:hidden.addrTree2').val(value.join(','));
		}
	});
	//编辑器
	if ($.fn.xheditor) {
		$("textarea.editor", $('form'))
		.each(
				function() {
					var $this = $(this);
					var op = {
							html5Upload : false,
							skin : 'default',
							tools : $this.attr("tools")
							|| 'full'
					};
					var upAttrs = [
					               [ "upLinkUrl", "upLinkExt",
					                 "zip,rar,txt,doc" ],
					                 [ "upImgUrl", "upImgExt",
					                   "jpg,jpeg,gif,png" ],
					                   [ "upFlashUrl", "upFlashExt",
					                     "swf" ],
					                     [ "upMediaUrl", "upMediaExt",
					                       "avi" ] ];

					$(upAttrs)
					.each(
							function(i) {
								var urlAttr = upAttrs[i][0];
								var extAttr = upAttrs[i][1];

								if ($this
										.attr(urlAttr)) {
									op[urlAttr] = $this
									.attr(urlAttr);
									op[extAttr] = $this
									.attr(extAttr)
									|| upAttrs[i][2];
								}
							});

					$this.xheditor(op);
				});
	}
	//履历
	$('span.addByNow:gt(0)').removeClass('addByNow').addClass(
	'delByNow').text('-');
	$('span.delByNow').live('click', function() {
		$(this).closest('div').remove();
	})
	$('span.addByNow').eq(0).click(
			function() {
				var $this = $(this);
				var d = $this.closest('div').clone().find('span')
				.removeClass('addByNow').addClass(
				'delByNow').text('-').end()
				.appendTo($this.closest('div.group'));
			})

			//行业-职业
			$('.intentType')
			.change(
					function() {
						var split = "${sessionScope.userbean.userIntention}";
						var $intents = $('.intentType');
						var $this = $(this);
						var $index = $intents.index($this);
						$
						.post(
								'Dict_GetIntentionDict_By_Type',
								{
									'typeName' : $(this)
									.val()
								},
								function(d) {
									var html = '';
									for ( var s in d.store.data) {
										html += '<option value="'
											+ d.store.data[s].jobIntentionDictNo
											+ '" '
											+ (split
													.split(',')[$index] == d.store.data[s].jobIntentionDictNo ? 'selected'
															: '')
															+ '>'
															+ d.store.data[s].jobIntentionDictName
															+ '</option>';
									}
									$this
									.siblings(
									'select.intentJob')
									.html(html);
								}, 'json')
					}).trigger('change');
});