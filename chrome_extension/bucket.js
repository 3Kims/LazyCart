function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
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
	

	var iframe = document.getElementById("iframe_cart");
	iframe.src=("http://localhost:8888/EZbasket/addcart.do?url="+statusText);
}

document.addEventListener("DOMContentLoaded",function(){
	var addCart=document.getElementById("addcart");
	
	addCart.addEventListener('click',function(){
		getCurrentTabUrl(function(url){
			renderURL(url);
		});
	});
});