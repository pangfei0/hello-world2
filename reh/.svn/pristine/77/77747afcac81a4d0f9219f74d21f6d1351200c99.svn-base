/**
 * ree前台ajax表格插件
 * 
 * 李丁-http://www.eleia.tk/ 2014/10/17
 * 
 * @memo 完成ree前台表格的刷新，翻页，排序，筛选等功能 返回状态(status) :0-缺省，1-未登录，2-错误，3-成功，4-提示
 * @usage dataSource:必要 dataTitle:必要 string - 数据源字段, object - 自定义html内容 format -
 *        html data-action ：action地址 rel：主键 data-form ：form地址（可选） data-title
 *        ：form标题（可选） id - id （html中替换'*'） dialogCSS - 自定义dialog的样式（注意样式覆盖等级）
 * 
 * @returns
 */
$(function() {
	$.reeTable = function() {
		// default options
		var defaults = {
			// 自动隐藏时间
			closeTime : 2000,
			// 目标表格选择器
			tableTarget : '.data-table',
			// 刷新按钮选择器
			refreshBtn : 'a.refresh_btn',
			// 搜索按钮选择器
			searchBtn : '.search_btn',
			// 是否加载了刷新插件
			reloadAble : !!$.fn.reload,
			// 数据源
			dataSource : '',
			// 对话框样式
			dialogCSS : 'ree-dialog',
			// 标题集
			dataTitle : [],
			// 分页搜索表单选择器
			searchForm : 'form.search-box',
			// 标题选择器
			titleTarget : '.tr_top td',
			// 数据参数
			dataParams : {'c':1,'p':10},
			// 每页条目数
			perNum : 10,
			// 分页条选择器
			pagination : '#Pagination',
			// 数据回调函数
			dataCallback : null
		}
		var rt = {};
		// 操作-删除,修改
		rt.commandBtn = function() {
			var t = this;
			t.action = $(t).data('action');
			t.title = $(t).data('title') || "confirm";
			t.$data = {}
			t.init = function(con) {
				con.clear();
			}
			t.clear = function() {
			};
			t.getForm = function() {
				t.$form = !!$(t).data('form');
				if (t.$form) {
					t.$form = $('<c>');
					if (rt.settings.reloadAble)
						$('html').reload();
					$.ajaxSetup({
						'async' : false
					});
					t.$form.load($(t).data('form'), {}, function(d, s, xhr) {});
					
					if (rt.settings.reloadAble)
						$('html').reloaded();
					
					$.ajaxSetup({
						'async' : true
					});
					if (t.$form = $(t.$form).html()) {
						rt.dialogID = 'form_' + (new Date()).valueOf();
						t.$form = $(t.$form);
						$('<html>').append(t.$form).find('form:eq(0)').attr('id', rt.dialogID);
					}
					t.$form = t.$form.is('form') ? t.$form : false;
				}
				return t.$form;
			}
			t.comfirm = function() {
				if (!rt.settings.hasZebra) {
					alert('缺少dialog');
					return false;
				}
				
				var $form = t.getForm();
				$.Zebra_Dialog((!!t.$form) ? $("<c>").append($('<html>').append($form)).html()
						: "确认操作？", {
					'custom_class' : !!$form?rt.settings.dialogCSS:'',
					'overlay_close' : false,
					'title' : t.title||'确认',
					position:['center', 'center'],
					'buttons' : [ '确定', '取消' ],
					'onClose' : function(caption) {
						if (rt.settings.reloadAble){
							$('html').reload();
							$('html').reloaded();//firefox
						}
						if (caption == '确定') {
							if (rt.settings.reloadAble)
								rt.tableTarget.reload();
							t.$data = !!t.$form ? $('#' + rt.dialogID)
									.serializeObject() : t.$data;
							$.post(t.action, t.$data,
									function(d) {
								if (rt.settings.reloadAble)
									rt.tableTarget.reloaded();
										if (!d.store || d.store.status != 3)
											alert('失败:'
													+ (!!d.store ? d.store.msg
															: d));
										else if (d.store.status == 3)
											alert('成功');
										rt.refreshBtn.trigger('click');
										;
									});
						} else if (caption == '取消') {
							// this.onClose();
							return false;
						}
					}
				});
			}
			return t.comfirm();
		}
		// 参数集
		rt.settings = {};
		options = {};
		if (typeof arguments[0] == 'object')
			options = $.extend(options, arguments[0]);
		// 初始化
		rt.init = function(con) {
			// init
			rt.settings = $.extend({}, defaults, options);
			rt.tableTarget = $(rt.settings.tableTarget);
			rt.titleTarget = $(rt.settings.titleTarget);
			rt.refreshBtn = $(rt.settings.refreshBtn);
			rt.searchBtn = $(rt.settings.searchBtn);
			rt.searchForm = $(rt.settings.searchForm);
			rt.pagination = $(rt.settings.pagination);
			rt.settings.perNum = rt.searchForm.find('input[name="p"]').val()||rt.settings.perNum;
			rt.settings.curPage = rt.searchForm.find('input[name="c"]').val()||1;
			rt.settings.hasZebra = !!$.Zebra_Dialog;

			$('a[data-action]', rt.tableTarget).live('click', rt.commandBtn);
			$('.ree-btn').live('click', rt.commandBtn);

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

			// 绑定刷新按钮
			rt.refreshBtn.bind('click', rt.refresh);
			// 绑定搜索按钮
			rt.searchBtn.bind('click', rt.search);
			// 绑定表头排序
			rt.tableTarget.find('tr:eq(0) td').each(function(i,e){
				$(e).click(function(){
					if(typeof(rt.settings.dataTitle[i])==="object"&&!rt.settings.dataTitle[i].sortBy)
						return false;
					rt.tableTarget.find('tr:eq(0) td').css('text-decoration','none');
					$(this).css('text-decoration','underline');
					rt.settings.dataParams.sortBy = rt.settings.dataTitle[i].sortBy||(rt.settings.dataTitle[i]);
					rt.settings.dataParams.sortBy = rt.settings.dataParams.sortBy.indexOf('.')>0?rt.settings.dataParams.sortBy:'id.'+ rt.settings.dataParams.sortBy;
					if(rt.settings.dataParams.sortMethod=='asc'){
						rt.settings.dataParams.sortMethod = ('desc');
					}
					else
						rt.settings.dataParams.sortMethod = ('asc');
					rt.paramToForm().load();
				})
			})
			
			// initData
			rt.refreshBtn.trigger('click');
			return rt;
		}
		//setting ---> form
		rt.paramToForm = function(){
			rt.searchForm.find('input[name="sortBy"]').val(rt.settings.dataParams.sortBy);
			rt.searchForm.find('input[name="sortMethod"]').val(rt.settings.dataParams.sortMethod);
			return rt;
		}
		// 加载数据
		rt.load = function() {
			// 读入参数
			rt.settings.dataParams = $.extend({}, rt.settings.dataParams, rt.searchForm.serializeObject());
			// 开始读入数据
			if (rt.settings.reloadAble)
				rt.tableTarget.reload();
			// 开始加载数据
			$.post(rt.settings.dataSource,rt.settings.dataParams,
							function(d) {

								// 清除旧信息
								rt.tableTarget.find('tr:gt(0)').remove();
								// 加入新信息
								try {
									// 判断返回状态
									if (d.store.status != 3&&d.store.status != 4) // 0-缺省，1-未登录，2-错误，3-成功 ，4-提示
										throw new Error(d.store.msg);
									//提示
									if (d.store.status == 4) // 0-缺省，1-未登录，2-错误，3-成功 ，4-提示
										$('.navigation span').text(d.store.msg);
									if (d.store.data.length == 0 && location.search.indexOf('add')<0)
										{
										rt.pagination.empty();
										throw new Error('1_无结果');
										}
									if ((rt.settings.dataTitle.length != rt.tableTarget
											.find(rt.titleTarget).length)
											&& (!!$.Zebra_Dialog || !alert('0_数据或标题长度不正确'))) {
										throw new Error('0_标题长度不正确');
									}
									//本体加载
									for ( var s = 0;s< d.store.data.length ; s++) {
										tr = $('<tr align="center">');
										if(rt.settings.dataParams.id01&&rt.settings.dataParams.id02)
											tr.data('id01',d.store.data[s][rt.settings.dataParams.id01]).data('id02',d.store.data[s][rt.settings.dataParams.id02]);
										// 拆取标题
										for ( var i = 0 ;i<rt.settings.dataTitle.length ;i++) {
											if(parseInt("0")>=0)
											if(rt.tableTarget.find('tr:eq(0) td').eq(i).css('display') === 'none')
												{
												tr.append($('<td>').css('display','none'));
												continue;
												}
											if (typeof rt.settings.dataTitle[i] == 'string')
												tr.append($('<td>').append(rt.settings.dataTitle[i].indexOf('.')>0?
														d.store.data[s][rt.settings.dataTitle[i].split('.')[0]][rt.settings.dataTitle[i].split('.')[1]]:
														d.store.data[s][rt.settings.dataTitle[i]]));
											else {
												// object
												rt.settings.dataTitle[i].id.indexOf('.')>0?id = d.store.data[s][rt.settings.dataTitle[i].id.split('.')[0]][rt.settings.dataTitle[i].id.split('.')[1]]:id = d.store.data[s][rt.settings.dataTitle[i].id];
												sub_id =(!!rt.settings.dataTitle[i].sub_id&&rt.settings.dataTitle[i].sub_id.indexOf('.'))>0 ?d.store.data[s][rt.settings.dataTitle[i].sub_id.split('.')[0]][rt.settings.dataTitle[i].sub_id.split('.')[1]]: d.store.data[s][rt.settings.dataTitle[i].sub_id];
												
												//sub_id = d.store.data[s][rt.settings.dataTitle[i].sub_id];
												tr.append($('<td>').append(rt.settings.dataTitle[i].format.replace(/\*/g,id||0).replace(/\^/g,sub_id||0)));
											}
										}
										tr.appendTo($('table tbody',
												rt.tableTarget));
									}
									//分页条加载
									//rt.settings.perNum 10 rt.settings.curPage 1 d.store.totalNum 21
									//rt.pagination
									//清空
									rt.pagination.empty();
									//开始构造
									rt.settings.perNum = rt.searchForm.find('input[name="p"]').val()||rt.settings.perNum;
									rt.settings.curPage = rt.searchForm.find('input[name="c"]').val()||1;
									var pagination = $('<div>').addClass('pagination');
									var num = parseInt(d.store.totalNum /rt.settings.perNum) + (d.store.totalNum%rt.settings.perNum?1:0);
									var content = $('<c>');
									for(i=1;i<=num ;i++){
										content.append($('<a>',{'class':'num','href':'#'}).text(i));
									}
									
									content.children(":contains('"+rt.settings.curPage+"')").removeAttr('href').addClass('current');
									pagination.append($('<a>',{'class':'prev btn','href':'#'}).text('上一页')).append($(content.html())).
									append($('<a>',{'class':'next btn','href':'#'}).text('下一页')).append($('<span>').text('总条数:'+d.store.totalNum));
									if(rt.settings.curPage ==1)
										pagination.children(":contains('上一页')").removeAttr('href').addClass('current');
									if(rt.settings.curPage ==num)
										pagination.children(":contains('下一页')").removeAttr('href').addClass('current');
									rt.pagination.append(pagination);
									//绑定事件
									rt.pagination.find('a.num[href]').bind('click',function(){
										rt.searchForm.find('input[name="c"]').val($(this).text());
										rt.load();
									})
									rt.pagination.find('a.btn[href]').bind('click',function(){
										if($(this).hasClass('next'))
											to = parseInt(rt.settings.curPage)+1;
										else
											to = parseInt(rt.settings.curPage)-1;
										rt.searchForm.find('input[name="c"]').val(to);
										rt.load();
									})
									// 结束加载数据
									if (rt.settings.reloadAble)
										rt.tableTarget.reloaded();
									
								} catch (e) {
									var treelbl = $('label.addrTree,label.addrTree2');
									var treeClass=treelbl.attr('class');
									treelbl.removeClass(treeClass);
									$('.ree-btn').addClass('disabled_btn').die('click',rt.commandBtn);
									setTimeout(function(){
										$('.ree-btn').removeClass('disabled_btn').live('click',rt.commandBtn);
										treelbl.addClass(treeClass);
									},rt.settings.closeTime)
									if (!!$.Zebra_Dialog) {
										type = e.message.split('_')[0] == '0' ? 'error' : 'warning';
										$ .Zebra_Dialog( '<strong>'+e.message.split('_')[0] == '0' ? '错误' : '提示'+'</strong> '+ ": "+ (e.message .split('_')[1] || e.message),
														{
											  'buttons':  false,
											    'modal': false,
											    'position': ['right - 20', 'top + 20'],
											    'auto_close': rt.settings.closeTime,
															'type' : type,
															'title' : e.message.split('_')[0] == '0' ? '错误' : '提示'
														});
									}
									if (rt.settings.reloadAble)
										rt.tableTarget.reloaded();
								}
							});

		}
		// 搜索
		rt.search = function() {
			rt.settings.dataParams.sortBy = $(this).hasClass('custom_btn')?('id.'+rt.settings.dataTitle[0].sortBy):rt.settings.dataParams.sortBy;
			//rt.tableTarget.find('tr:eq(0) td:eq(0)').css('text-decoration','underline');
			rt.paramToForm().load();
		}
		// 刷新
		rt.refresh = function() {
			rt.load();
		}
		// 构造
		return rt.init(rt);
	}
})
