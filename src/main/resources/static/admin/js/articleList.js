var vm = new Vue({
	el : "#app",
	data : {
		items : []
	},
	mounted : function(){
		this.$nextTick(function(){
			this.dataMore(1, 9);
		});
	},
	methods : {
		dataMore : function(pageNum, pageSize){
			$.ajax({
				url : "/admin/articleList",
				data :{
					"pageNum" : pageNum,
					"pageSize" : pageSize
				},
				type : "GET",
				dataType : "json",
				success : function(result){
					if(result && "0000"==result.code){
						vm.items = result.data;
					} else {
						alert(result.msg);
					}
				}
			})
		}
	}
});