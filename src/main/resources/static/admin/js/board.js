var vm = new Vue({
	el : "#app",
	data : {
		contentsCount : 0,
		commentsCount : 0,
		attachCount : 0,
		linkCount : 0,
		contentsList : [],
		commentsList : [],
		logsList : []
	},
	mounted : function(){
		this.$nextTick(function(){
			this.init();
		})
	},
	methods : {
		init : function(){
			$.ajax({
				url : "/admin/boardInfor",
				data : {},
				type : "POST",
				dataType : "JSON",
				success : function(result){
					vm.contentsCount = result.data.contentsCount;
					vm.commentsCount = result.data.commentsCount;
					vm.attachCount = result.data.attachCount;
					vm.linkCount = result.data.linkCount;
					vm.contentsList = result.data.contentsList;
					vm.commentsList = result.data.commentsList;
					vm.logsList = result.data.logsList;
				}
			});
		}
	}
})