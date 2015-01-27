
$(function(){
	$.fn.extend({"liteNav" : function(t) {
			var $this = $(this), i = 0, $pics = $('#NewsPic'), autoChange = function() {
				var $currentPic = $pics.find('a:eq('
								+ (i + 1 === 6 ? 0
										: i + 1)
								+ ')');
				$currentPic.css({
					visibility : 'visible',
					display : 'block'
				}).siblings('a').css({
					visibility : 'hidden',
					display : 'none'
				});
				$pics
						.find(
								'.Nav>span:contains('
										+ (i + 2 > 6 ? 6 - i
												: i + 2)
										+ ')')
						.attr('class',
								'Cur')
						.siblings('span')
						.attr('class',
								'Normal');
				$('#NewsPicTxt')
						.html(
								'<a target="_blank" href="' + $currentPic[0].href + '">'
										+ $currentPic
												.find(
														'img')
												.attr(
														'title')
										+ '</a>');
				i = i + 1 === 6 ? 0 : i + 1;
			}, st = setInterval(autoChange,
					t || 2000);
			$this.hover(function() {
				clearInterval(st);
			}, function() {
				st = setInterval(
						autoChange,
						t || 2000)
			});
			$pics.find('.Nav>span').click(
							function() {
								i = parseInt($(this).text(),10) - 2;
								autoChange();
							});
		}
	});
	$('#hotpic').liteNav(3000);
})
function nTabs(thisObj, Num) {

	if (thisObj.className == "active")
		return;
	var tabObj = thisObj.parentNode.id;
	var tabList = document.getElementById(tabObj)
	.getElementsByTagName("li").length ? document.getElementById(
			tabObj).getElementsByTagName("li") : document.getElementById(
					tabObj).getElementsByTagName("span");
			for (var i = 0; i < tabList.length; i++) {
				if (i == Num) {
					thisObj.className = "active";
					document.getElementById(tabObj + "_Content" + i).style.display = "block";
					document.getElementById(tabObj + "_Content" + i).disabled = false;
				} else {
					tabList[i].className = "normal";
					document.getElementById(tabObj + "_Content" + i).style.display = "none";
					document.getElementById(tabObj + "_Content" + i).disabled = true;
				}
			}
			//register
			if (tabObj == "log") {
				var regLink = document.getElementsByClassName("login_btn")[0]
				.getElementsByTagName("a")[0];
				if (regLink) {
					regLink.href = "registerAndModify.jsp?u_type=" + Num;
				}
			}
}

function onLoginLoaded() 
{ 
	$("#user_name").val(getCookie('user_name'));
	$("#com_name").val(getCookie('com_name'));

} 

function user_login() {
	var username = $("#user_name").val();

	document.getElementsByName('LoginForm')[0].submit();

	if ($("#com_rem").is(':checked')) {
		alert("aaaaa");
		setCookie('user_name', username, 1);
	}

}
function com_login() {
	var comname = $("#com_name").val();

	document.getElementsByName('LoginForm1')[0].submit();
	if ($("#com_rem").is(':checked')) {
		setCookie('com_name', comname, 365);
	}

}

function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=");
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1;
			c_end = document.cookie.indexOf(";", c_start);
			if (c_end == -1)
				c_end = document.cookie.length;
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

function setCookie(c_name, value, expiredays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie = c_name
	+ "="
	+ escape(value)
	+ ((expiredays == null) ? "" : "; expires="
		+ exdate.toGMTString());
}