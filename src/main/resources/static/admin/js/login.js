var vm = new Vue({
	data : {
		username : "",
		password : "",
		tip : ""
	},
	methods : {
		login : function(){
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
					if("0000"==result.code){
						location.href = "index.html";
					}
				}
			})
			
		}
	}
});