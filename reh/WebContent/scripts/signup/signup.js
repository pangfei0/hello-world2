$(function(){
	$('form').validate({
		errorElement: 'div',
		errorClass: 'help-block',
		focusInvalid: false,
		rules: {
			password: {
				required: true,
				minlength: 5
			},
			password2: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			username: {
				required: true
			},
			email:{
				required:true,
				email:true
			}
		},
		messages: {
			username: {
				required: "请填写用户名."
			},
			password: {
				required: "请填写密码.",
				minlength: "密码长度太短."
			},
			email:{
				required:"请输入电子邮件.",
				email:"请输入正确的邮件格式"
			}
		},
		highlight: function (e) {
			$(e).closest('.input-group').removeClass('has-info').addClass('has-error');
		},

		success: function (e) {
			$(e).siblings('.input-group').removeClass('has-error').addClass('has-info');
			$(e).remove();
		},

		errorPlacement: function (error, element) {
			if(element.is('input[type=checkbox]')) {
				error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
			}
			else error.insertAfter(element.parent());
		},

		submitHandler: function (form) {
			if($(form).valid())
				form.submit();
		},
		invalidHandler: function (form) {
		}
	});

})
