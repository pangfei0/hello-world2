$(function() {
		/*c元素*/
		var celem = [];
		/*c对象*/
		var d = function(i, tar) {
			var i = i;
			var name = $(tar).text();
			var addr = $(tar).data('addr');
			var id = $(tar).data('key');
			var level = $(tar).attr('level');
			var fathername = $(tar).data('fathername');
			this.init = function(con) {
				con.clear()
			};
			this.clear = function() {
			};
			this.click = function() {
				var type;
				switch(level){
					case '1':type="市";break;
					case '2':type="区";break;
					case '3':type="街道";break;
					case '4':type="社区";break;
					case '5':type="小区";break;
					default:break;
				}
				//添加时使用
				$('#newlevel').val(parseInt(level)+1);
				$('#newfatherid').val(id);
				
				$('#txttype').val(type);
				$('#txtfather_name').val(fathername);
				$('#txtname').val(name);
				$('#txtaddr').val(addr);
				$('#alterid').val(id);
				$('#actionmethod').val('alter');
			};
		}
		/*c控制器*/
		var c = {
			click : function(i) {
				celem[i].click()
			},
			init : function(i, e) {
				tar = i;
				celem[tar] = new d(i, e);
				tar = celem[tar];
				tar.init(tar);
			}
		}
		/*初始*/
		$('.communities a').each(function(i, e) {
			c.init(i, e);
			$(e).click(function() {
				c.click(i);
			})
		});
		/*添加*/
		$('#addbtn').click(function(){
			$('#actionmethod').val('add');
			validateCallback($(this).closest('form'), navTabAjaxDone);
		});
		/*删除*/
		$('#delbtn').click(function(){
			$('#actionmethod').val('del');
			validateCallback($(this).closest('form'), navTabAjaxDone);
		});
	})