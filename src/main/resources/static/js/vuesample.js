
// viewModelを生成
window.onload = function(){

	var contextPath = location.pathname.split("/")[1];
	
	
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
				teamName     : "",
				leagueName   : "",
				headquarters : "",
				inauguration : "",
				history      : ""
		}, 
		 methods: {
			register: function(){
				let newTeam = {
					teamName     : "",
					leagueName   : "",
					headquarters : "",
					inauguration : "",
					history      : ""
				};
				
				newTeam.teamName = this.teamName;
				newTeam.leagueName = this.leagueName;
				newTeam.headquarters = this.headquarters;
				newTeam.inauguration = this.inauguration;
				newTeam.history = this.history;
				
				 // teamをListに入れる
				 ajaxAccess.teamList.push(newTeam);
				 // DBに流す
				 function ajaxProcess(newTeam) { 
					 // axiousのやつ
					 let params = new URLSearchParams();
					 params.append('ajaxData' , JSON.stringify(newTeam))
					console.log('its = ' + JSON.stringify(newTeam));
					axios.post('/vue/register_baseballteam', params
					).then(function(){
						
					});
				}

				 ajaxProcess(newTeam);
				  newTeam = "";
				 cratedTeam = "";
			}
		 }
});

	// 非同期で取得し、ブラウザに表示させる。
	ajaxAccess.findTeam()
}