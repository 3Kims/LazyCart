document.getElementById("login").addEventListener("click", loginLogic);
document.getElementById("bucket").addEventListener("click", goBucket);
//console.log(document.getElementById("iframe_main").contentDocument.getElementById("user_thumnail"));

function loginLogic(){
	if(this.innerHTML == "로그인")
		location.href="login.html";
	if(this.innerHTML == "로그아웃")
		location.href="logoutresult.html";
}
function goBucket() {
	location.href = "bucket.html";
}

function getCurrentTabUrl(callback) {
	chrome.tabs.query({
		'active' : true,
		'windowId' : chrome.windows.WINDOW_ID_CURRENT
	}, function(tabs) {
		var url = tabs[0].url;
		callback(url);
	});
}

function renderURL(statusText){
	location.href="addresult.html?url="+statusText;
}

document.addEventListener("DOMContentLoaded",function(){
	var addCart=document.getElementById("addcart");
	
	addCart.addEventListener('click',function(){
		getCurrentTabUrl(function(url){
			renderURL(url);
		});
	});
});

chrome.runtime.onMessage.addListener(function (request, sender, sendResponse) {
	var loginTag = null;
    if (request.data === "logined") {
        console.log("current..logined status");
        loginTag = document.getElementById("login");
        loginTag.innerHTML="로그아웃";
        sendResponse({ data: "popup menu changed to 로그아웃"});
    } else if(request.data == "logout") {
    	loginTag.innerHTML="로그인";
        sendResponse({ data: "popup menu changed to 로그인"});
    }
});
