/**
 * 职业行业，职业类别，地点
 * 多选插件
 * 
 * 李丁-http://www.eleia.tk/ 2014/12/07
 * @memo 关联插件 reload.js , serializeObject.js ,Zebra_Dialog.js ,uniqueArray.js
 * @usage
 * @return this
 * 
 */
$(function(){
	$.reeMs = function(){
		// default options
		var defaults = {
			// 数据类型
			dataType:'json',
			// 目标按钮选择器
			btnTarget : '.ms-btn',
			// 目标层选择器
			divTarget : '.ms-div',
			// 数据源
			dataSource : '',
			// 对话框样式
			dialogCSS : 'ree-dialog',
			// 数据参数
			dataParams : {'c':1,'p':10},
			// 数据回调函数
			dataCallback : null
		}
		var ms = {}
		// 参数集
		ms.settings = {};
		options = {};
		if (typeof arguments[0] == 'object')
			options = $.extend(options, arguments[0]);
		// 初始化
		ms.init = function(con) {
			// init
			ms.settings = $.extend({}, defaults, options);
			//目标层
			ms.divTarget = $(ms.settings.divTarget);
			//目标按钮
			ms.btnTarget = $(ms.settings.btnTarget,ms.divTarget );
			
			//bind/live command
			var elem = [];
			var btnC = {
					//初始化按钮
					init:function(i,tar){tar = new ms.commandBtn(tar);elem[i]=tar;tar.init(tar);return tar;},
					//绑定
					bind:function(i){
						elem[i].bind(elem[i]);
					},
					//获得数据源
					getData:function(i){
						elem[i].getData(elem[i]);
					},
					//clear
					clear:function(i){elem[i].clear()}
			}
			//入口
			ms.btnTarget.each(function(i,e){
				//建立控制器
				btnC.init(i,$(e));
				//绑定事件入口
				btnC.bind(i);
				//获得数据源
				//btnC.getData(i);
			})
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
			return ms;
		}
		//加载数据
		ms.reload = function(con){
			//check&run reloadPlugin
			!ms.divTarget.reload||ms.divTarget.reload();
		}
		//结束加载数据
		ms.reloaded = function(con){
			//check&run reloadedPlugin
			!ms.divTarget.reloaded||ms.divTarget.reloaded();
		}
		//调整dialog位置
		ms.setDialog = function(d){
			var browserName = navigator.userAgent.toLowerCase();
			var scrollTop = 0;
			var dialog = d.get(0);
			if (/chrome/i.test(browserName) && /webkit/i.test(browserName) && /mozilla/i.test(browserName)){
				//isChrome
				scrollTop = document.body.scrollTop;
			}
			else
				 scrollTop = document.documentElement.scrollTop;
			
			var scrollempty = parseInt(document.documentElement.scrollHeight - document.documentElement.clientHeight);
			if (dialog.offsetHeight > document.documentElement.clientHeight) {
				if (scrollTop == 0) {
			    	d.css('top','0px');
			    }
			    else if (scrollTop == scrollempty) {
			    	d.css('top',(parseInt(document.documentElement.clientHeight - dialog.offsetHeight)).toString() + "px");
			    }
			    else {
			        d.css('top',(parseInt(document.documentElement.clientHeight - dialog.offsetHeight) / 2).toString() + "px");
			    }
			}
			else {

		        var h = parseInt((document.documentElement.clientHeight - dialog.offsetHeight) / 2);

		        d.css('top',h.toString() + "px");
		    }
		    
			d.css('left',(parseInt(document.documentElement.clientWidth - d.get(0).offsetWidth) / 2).toString() + "px");
		}
		//按钮事件
		ms.commandBtn = function(target){
			var con = this;
			//target
			var tar = target;
			//data
			var data = tar.data();
			
			//
			//事件初始化
			this.init = function(con){
				//清除过去数据
				con.clear();
				console.log('init:' + tar.val());
				//获得数据源
				con.getData(con);
				
			}
			//清除过去数据
			this.clear = function(){
				//
			}
			//绑定事件
			this.bind = function(con){
				tar.bind('click',con.event);
			}
			//获得数据源
			this.getData = function(con){
				//数据源Url
				$.post(data.source,$.extend({},ms.settings.dataParams),function(d){
					//success
					data.store = d.store;
					//解析数据源
					data.Level1 = data.store.data.map(function(e,i){return e.jobTypePriDictType}).unique();
					data.Level2 = [];
					$(data.store.data).each(function(i,e){
						data.Level2[e.jobTypePriDictType]||(data.Level2[e.jobTypePriDictType]=[]);
						data.Level2[e.jobTypePriDictType].push(e.jobTypePriDictName);
					})
					
				},ms.settings.dataType);
			}
			//事件内容
			this.event = function(){
				//reload
				ms.reload();
				//create dialog
				con.MSdialog = $('<div>',{
					'class':'MS-dialog',
					'id':'MS_dialog_'+data.source,
					css:{
						"z-index":'999',
						'display':'block',
						'position':'fixed',//IE6:absolute
						'top':'0px',
						'left': '0px',
						'background':'#fff'
						
					},
					html:$('<a>',{
						href:'#',//get
						html:$(data.Level1).map(function(i,e){return e+":"+data.Level2[e];}).get().join('<br>'),
						click:function(e){
							con.MSdialog.remove();
							ms.reloaded();
							e.preventDefault();
						}
					})
				})
				//append dialog
				con.MSdialog.appendTo(document.body);
				//set dialog
				ms.setDialog(con.MSdialog);
				console.log(data.source);
			}
		}
		// 构造
		return ms.init(ms);
	}
})