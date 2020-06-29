
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
	setTimeout("location.href = 'bucket.html'",30);
