console.log("컨텐트 스크립트 시작");

if(document.getElementById("user_thumnail")!=null){//로그인되어있다면
	
	
	console.log("로그인 되어있음!!!")
	console.log("메세지 시작!");
	chrome.runtime.sendMessage({data: "logined"}, function(response) {
	    console.log(response);
	});
	console.log("메세지 전달 완료");
	
}

