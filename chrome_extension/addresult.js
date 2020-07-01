
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

	var url = getParameterByName("url");
	console.log(url);
	var iframe = document.getElementById("addCartResult");
	iframe.src=("http://localhost:8888/EZbasket/addcart.do?url="+url);

	chrome.runtime.onMessage.addListener(function (request, sender, sendResponse){
		var result=null;
		if(request.error != null){
			console.log("error 발생");
			result = document.getElementById("result");
			result.innerHTML = request.error;
			sendResponse({ data: "에러 발생!!!"});
		}
	});
