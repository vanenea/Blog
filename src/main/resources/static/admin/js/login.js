var vm = new Vue({
	el : "#app",
	data : {
		username : "",
		password : "",
		tip : ""
	},
	methods : {
		toLogin : function(){
			console.log("######")
			if(""==this.username){
				this.tip = "请输入账户名"
				return;
			} else if(""==this.password){
				this.tip = "请输入密码";
				return;
			}
			$.ajax({
				url : "/admin/toLogin",
				data : {
					"username" : vm.username,
					"password" : vm.password
				},
				type : "POST",
				dataType : "json",
				success : function(result){
					console.log("######"+result);
					if("0000"==result.code){
						location.href = "/admin/index";
					} else {
						vm.tip = result.msg;
					}
				}
			})
			
		}
	}
});