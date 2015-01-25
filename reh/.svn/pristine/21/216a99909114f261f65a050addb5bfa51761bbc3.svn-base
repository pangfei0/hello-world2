/**
 * ree前台ajax树插件
 * 
 * 李丁-http://www.eleia.tk/ 2014/10/25
 * 
 * @memo 
 * @usage 
 * 
 * @returns
 */
$(function() {
	$.reeTree = function() {
		// default options
		var defaults = {
			// value是否使用ID （搜索时不建议使用）
				useID : false,
			// 节点ID字段
				idTag : 'communityNo',
			// 节点name字段
				nameTag : 'communityName',
			// 父节点ID字段
				parentidTag : 'communityFatherNo',
			// 节点数据字段
				dataTag : 'communityAddr',
			// 容器ID
				containerid : 'treeview' + (new Date()).valueOf(),
			// label选择器
				label:'label.addrTree',
			// value选择器
				value:'input:hidden.addrTree',
			// 数据源
				url : 'communityJSONAction_community',
			// 是否可选
				show_button_check : false,
			// 单选事件
				onselectednode : function (id, node, sender) {
					
					//rt.value.val(id);
					rt.value.val(rt.settings.useID?id:node.data('data'));
                	rt.label.text(node.data('data'));
                },
			// 多选事件
                onnodecheckselected : function (id, node, sender) {
                    console.log("onnodecheckselected");
                    console.log(id);
                    console.log(node);
                    console.log(sender);
                }
		}
		var rt = {};
		// 参数集
		rt.settings = {};
		options = {};
		if (typeof arguments[0] == 'object')
			options = $.extend(options, arguments[0]);
		// 初始化
		rt.init = function(con) {
			// init
			rt.settings = $.extend({}, defaults, options);
			rt.container = $('#'+rt.settings.containerid);
			rt.label = $(rt.settings.label);
			rt.value = $(rt.settings.value);
			rt.settings.hasZebra = !!$.Zebra_Dialog;
			
			rt.label.live('click', rt.labelClick);
			
			// ajax错误返回
			$.ajaxSetup({
				error : function(jqXHR, textStatus, errorThrown) {
					if (!!($.Zebra_Dialog || alert(jqXHR.status))) {
						$.Zebra_Dialog('<strong>网络错误</strong> '
								+ jqXHR.readyState + ':'
								+ (textStatus || errorThrown), {
							'type' : 'error',
							'title' : jqXHR.status
						});
					}
					$.ajaxSetup({
						'async' : true
					});
				}
			});
			// initData
			return rt;
		}
		//dialog返回值
		rt.returnValue = function(caption) {
			if (caption == '确定') {
				
			} else if (caption == '取消') {
				rt.value.val('');
            	rt.label.text('未选择');
				// this.onClose();
				return false;
			}
		}
		// 清除
		rt.Clear = function() {
			rt.container.empty();
		}
		// label点击事件
		rt.labelClick = function() {
            rt.Clear();
            
            if (!rt.settings.hasZebra) {
				alert('缺少dialog');
				return false;
			}
            
            $.Zebra_Dialog($('<c>').append($('<div>',{'id':rt.settings.containerid})).html(), {
				'custom_class' : 'tree-dialog',
				'position':['center', 'top + 100'],
				'overlay_close' : false,
				'title' : '选择地址',
				'buttons' : [ '确定', '取消' ],
				'onClose' : rt.returnValue
			});
            
            rt.container = $('#'+rt.settings.containerid);
            
            rt.container.btechcotree({
            	idTag:rt.settings.idTag,
            	nameTag:rt.settings.nameTag,
            	parentidTag:rt.settings.parentidTag,
            	dataTag:rt.settings.dataTag,
                containerid: rt.settings.containerid,
                url:rt.settings.url
                , datatype: $treedatatype.Json
                , dataformat: $treedataformat.Linear
                , class_node_collapse: "ui-icon-circle-plus"
                , class_node_expand: "ui-icon-circle-minus"
                , class_node_item: "ui-icon-clipboard"
                , collapse_tree: false
                , class_node_highlight: "ui-state-highlight"
                , show_button_check: rt.settings.show_button_check
                , onselectednode: rt.settings.onselectednode
                , onnodecheckselected: rt.settings.onnodecheckselected
            });
		};
		// 构造
		return rt.init(rt);
	};
});
