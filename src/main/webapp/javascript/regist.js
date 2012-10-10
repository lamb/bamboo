$(function() {
//	$.validator.setDefaults({
//		submitHandler:function(){
//			
//		},
//		showErrors:function(map, list) {
//			
//		}
//	});
	$("#registForm").validate({
		"rules":{
//			email:{
//				required:true,
//				email:true,
//				remote:{
//					url:"",
//					type:"get",
//					data:{
//						email:function(){
//							return $("#inputEmail").val();
//						}
//					},
//					dataFilter:function(data) {
//						if(data.result) {
//							
//						}
//					}
//				}
//			},
			password:{
				required:true,
				maxlength:20,
				minlength:6
			},
			repassword:{
				required:true,
				equalTo:"#inputPassword"
			},
			captcha:"required"
		},
//		errorElement:"span",
		errorPlacement:function(error, element) {
			element.nextAll("span.help-inline").html(error.html());
//			error.appendTo(element.parent());
		},
		highlight:function(element, errorClass) {
			$(element).parent().parent().addClass("error");
		},
		success:function(label, element) {
			element.parent().parent().removeClass("error").addClass("success");
			element.next().html("");
//			label.text("ok");
		},
		submitHandler:function(form) {
		}
	});
	$("#registForm").ajaxForm({
		dataType:"json",
		beforeSerialize:function($form, options) {
			
		},
		beforeSubmit:function(formData, jqForm, options) {
		},
		success:function(data) {
			
		},
		error:function(jqXHR, textStatus, errorThrown) {
			
		}
	});
	jQuery().ajaxStart(function() {
		
	}).ajaxStop(function() {
		
	}).ajaxError(function(a, b, e) {
		throw e;
	});
});