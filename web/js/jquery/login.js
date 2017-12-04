//生成验证码
function changeValidateCode(obj) {
	// 获取当前的时间作为参数，无具体意义
	var timenow = new Date().getTime();
	// 每次请求需要一个不同的参数，否则可能会返回同样的验证码
	obj.src = "rand.action?d=" + timenow;
}

// 登录表单验证
$(document).ready( function() {
	$("#loginForm").validate( {
		rules : {
			userId : {
				required : true,
				minlength : 4
			},
			password : {
				required : true,
				minlength : 6
			},
			random : {
				required : true,
				minlength : 4
			}
		}
	});
});