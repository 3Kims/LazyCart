 
//chrome.browserAction.setBadgeText({text: 'OFF'});
//chrome.browserAction.setBadgeBackgroundColor({color: '#4688F1'});

chrome.runtime.onMessage.addListener(function(request, sender, sendResponse) {
	console.log("background listening");
	console.log(sender.tab ? "from a content script:" + sender.tab.url : "from the extension");
	
    if (request.data == "logined") {
    	console.log("background logined detect");
    	chrome.browserAction.setBadgeText({text: 'ON'});
    	chrome.browserAction.setBadgeBackgroundColor({color: '#4688F1'});
    	console.log("logincolor blue");
    	
    	sendResponse({ result: "login successed" });

    } else if (request.data == "logout") {
    	chrome.browserAction.setBadgeText({text: 'OFF'});
    	chrome.browserAction.setBadgeBackgroundColor({color: '#EA1515'});
    	console.log("logincolor blue")
    	sendResponse({ result: "logout successed" });
    }  
});
