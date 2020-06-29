document.getElementById("login").addEventListener("click", goLogin);
document.getElementById("bucket").addEventListener("click", goBucket);

var isLogin=document.getElementById("iframe_main").contentWindow.document.getElementByClassName("badge badge-warning");
console.log(isLogin);
if(isLogin==null){
	document.getElementById("login").html("로그아웃");
}


function goLogin() {
	location.href = "login.html";
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
