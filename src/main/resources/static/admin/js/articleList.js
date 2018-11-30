var vm = new Vue({
	el : "#app",

	data : {
		itemList : [],
		currentPage : 0,
		totalPage : 0,
		count : 0
	},
	mounted : function(){
		this.$nextTick(function(){
			this.dataMore(1, 9);
			
		});
	},
	filters:{
		dataFormat : function(param){
			
			var date =  new Date(param*1000);
			var year = date.getFullYear(),
				month = date.getMonth()+1,
				day = date.getDate(),
				hour = date.getHours(),
				min = date.getMinutes(),
				seconds = date.getSeconds();
			return year+"-"+month+"-"+day+" "+hour+":"+min+":"+seconds;
		}
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
						vm.itemList = result.data;
						vm.currentPage =pageNum,
						vm.totalPage = result.data.pages,
						vm.count = pageSize;
						vm.pageInit();
					} else {
						alert(result.msg);
					}
				}
			})
		},
		pageInit : function(){
			$("#pagination").pagination({
				currentPage: vm.currentPage,
				totalPage: vm.totalPage,
				isShow: true,
				count: vm.count,
				homePageText: "首页",
				endPageText: "尾页",
				prevPageText: "上一页",
				nextPageText: "下一页",
				callback: function(current) {
					$("#current").text(current)
					vm.dataMore(currentPage, count);
				}
			});
		}
	}
})