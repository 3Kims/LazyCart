
	document.getElementById("login").addEventListener("click",goLogin);
	document.getElementById("bucket").addEventListener("click",goBucket);
	document.getElementById("addcart").addEventListener("click",addCart);


function goLogin() {
	location.href = "login.html";
}
function goBucket() {
	location.href = "bucket.html";
}

function addCart() {
	var currentURL;

	chrome.tabs.query({'active': true, 'windowId': chrome.windows.WINDOW_ID_CURRENT}, 
	function(tabs){
		addCurrentURL(tabs[0].url);
	});

	function addCurrentURL(tab){
		currentURL = tab;
		
	}
	alert(currentURL);
}