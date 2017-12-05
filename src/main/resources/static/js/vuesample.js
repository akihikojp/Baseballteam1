
// viewModelを生成
window.onload = function(){
	var contextPath = location.pathname.split("/")[1];
	
	var baseball = new Vue({
		el:'#openingMessage',
		data: {
			message: '野球チーム追加'
		},
	});
	
	
	var ajaxAccess = new Vue({
		el:'#ajaxAccess',
		data: {
			teamList : "",
			contextPath : contextPath
	  },
		methods: {
			findTeam() {
				axios.get('/vue/index')
				.then(function (response) {
					ajaxAccess.$data.teamList = response.data;
				})
			}
		}
	});
	
	
	var createTeam = new Vue({
		el:'#createTeam',
		data: {
			message: '' // 入力した値が入る
		},
		methods: {
			register: function(){
				alert('ALERT');			
			}
		}
	});
	
	// 非同期で取得し、ブラウザに表示させる。
	ajaxAccess.findTeam()
};