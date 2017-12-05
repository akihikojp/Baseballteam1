#####htmlでVue.jsを使う(CDN方式)
`<script src="https://cdn.jsdelivr.net/vue/latest/vue.js"></script>`
#####Vue.jsで非同期接続を行う為のaxiosメソッドを使う(CDN)
`<script src="https://unpkg.com/axios/dist/axios.min.js"></script>`
#####ThymeLeafで外部ファイル(例えばjsファイル)を参照する
`<script th:src="@{/js/vuesample.js}"></script>`


--

####ThymeLeafでcontextPathを取得する

・html側
`<input id="contextPath" type="hidden" th:value="@{/}" />`

・js側

```
var contextPath = document.getElementById("contextPath");

-省略-

  data:{
	 contextPath : contextPath
  }
```

--

####axiosを使った非同期処理メソッド(例)
```
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
```