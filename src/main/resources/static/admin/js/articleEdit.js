var tale = new $.tale();

var vm = new Vue({
	el : "#wrapper",
	data : {
		content : "",
		title : ""
	},
	methods : {
		submit : function(text){
			if(""==vm.title){
				tale.alertWarn('请输入文章标题');
				return;
			}
			if(""==vm.content){
				tale.alertWarn('请输入文章内容');
			}
			
		}
	}
});