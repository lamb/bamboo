<script type="text/javascript" src="${contextPath}/javascript/jquery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/prettify/prettify.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/jquery/validation/jquery.validate.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/jquery/validation/messages_zh.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/jquery/form/jquery.form.js"></script>
<script type="text/javascript" src="${contextPath}/javascript/ready.js"></script>
<script type="text/javascript">
    var config = {
        "servePath": "${contextPath}",
        "staticServePath": "${contextPath}"
    };
    
    $(function () {
		$("#signForm").validate({
			"rules":{
				email:{
					required:true,
					email:true
				},
				password:{
					required:true
				}
			},
			errorPlacement:function(error, element) {
				var msg = error.html();
				if(msg)
					element.popover({content:msg}).popover(error);
			},
			success:function(label, element) {
				$(element).popover("hide");
			},
			submitHandler:function(form) {
				$("#signForm").ajaxSubmit({
					dataType:"json",
					beforeSerialize:function($form, options) {},
					beforeSubmit:function(formData, jqForm, options) {},
					success:function(data) {
						if(data.result) {
							alert("success");
						} else {
							alert("error");
						}
					},
					error:function(jqXHR, textStatus, errorThrown) {
						
					}
				});
			}
		});
    });
</script>