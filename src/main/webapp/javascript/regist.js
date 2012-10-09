$(function() {
	$("#registForm").validate({
		"rules":{
//			email:{
//				required:true,
//				maxlength:100,
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
				equalTo:"#inputPassword"
			},
			captcha:"required"
		},
		errorPlacement:function(error, element) {
			element.parent().parent().addClass("error");
			element.next().html(error.html());
		},
		success:function(succ, element) {
			element.parent().parent().removeClass("error");
			element.next().html("");
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
});