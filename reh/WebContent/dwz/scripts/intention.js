$(function(){
	$('.intentType')
	.change(function() {
		console.log(2);
				selectedIntentId = parseInt($('input:hidden[name="userintention"]').val())||0;
				$intents = $('.intentType');
				$this = $(this);
				$.post(	'Dict_GetIntentionDict_By_Type',
						{
							'typeName' : $(this).val()
						},
						function(d) {
							var html = '';
							for ( var s in d.store.data) {
								html += '<option value="'+ d.store.data[s].jobIntentionDictNo + '" '
								+ (d.store.data[s].jobIntentionDictNo == selectedIntentId ? 'selected' : '' )
								+ '>'
									+ d.store.data[s].jobIntentionDictName
									+ '</option>';
							}
							$this.siblings(
							'select.intentJob')
							.html(
									'<option value="0">所有</option>'
									+ html);
						}, 'json')
			}).trigger('change');
})