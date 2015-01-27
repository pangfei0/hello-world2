//
//login.js
//检查空输入，绑定提交
//李丁
//2014/7/15
//

$(function() {
	// action:RefreshRoleAction
	// target:.infospan
	// info:<input> data-title

	/* 验证-start */
	var ielem = [];
	// 验证对象
	var id = function(id) {
		var id = id;
		var tar = $('#' + id);
		this.title = tar.data('title');
		this.getvalue = function() {
			return tar.val()
		};
		this.clear = function(con) {
			con.value = "";
			tar.val(con.value);
		}
		this.init = function(con) {
			con.clear(con);
		}
		this.check = function(con) {
			f = false;
			for ( var v in ielem) {
				if (ielem[v].getvalue() == null || ielem[v].getvalue() == "") {
					f = true;
					title = ielem[v].title;
					break;
				}
			}
			if (f) {
				$('.infospan').text(title + "为空");
				$('.btn.btn-primary').addClass('disabled').attr('disabled',
						'disabled');
			} else {
				$('.btn.btn-primary').removeClass('disabled').removeAttr(
						'disabled');
				$('.infospan').text("");
			}
			return !f;
		}
		this.getrole = function(con) {
			$.post("RefreshRoleAction", {
				username : con.getvalue()
			}, function(d) {
				if (d.store.success) {
					$('h4.title').text(d.store.type);
				}
				else
					$('h4.title').text('没有此用户！');
			})
		}
	}
	// 验证控制器
	var ic = {
		init : function(tar) {
			var n = tar;
			tar = new id(tar);
			ielem[n] = tar;
			tar.init(tar);
		},
		getvalue : function(id) {
			return ielem[id].getvalue();
		},
		check : function(id) {
			ielem[id].check(ielem[id]);
			return this;
		},
		getrole : function() {
			ielem['username'].getrole(ielem['username']);
		}
	}
	//绑定验证
	$('input').each(function(i, e) {
		ic.init(e.id);
		$(e).keyup(function() {
			ic.check(e.id);
		}).change(function(ev){
			if(!ev&&window)
				var ev = window.event;
			ic.check(e.id);
		});
	});
	//绑定获得角色
	$('input').eq(0).blur(function() {
		ic.getrole();
	})
	/* 验证-end */
})