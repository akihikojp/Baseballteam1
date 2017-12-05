###aaaaaaaaaa

・ThymeLeafでcontextPathを取得する方法
-html側
<input id="contextPath" type="hidden" th:value="@{/}" />
-js側
var contextPath = document.getElementById("contextPath");

  data:{
	 contextPath : contextPath
  }
