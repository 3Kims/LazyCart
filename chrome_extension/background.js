 
chrome.browserAction.setBadgeText({text: 'OFF'});
chrome.browserAction.setBadgeBackgroundColor({color: '#4688F1'});

/*chrome.runtime.onMessage.addListener(function(message, callback) {
	console.log("background listening");
    if (message.data == “logined”) {
    	console.log("background logined detect");
    	chrome.browserAction.setBadgeText({text: 'ON'});
    	chrome.browserAction.setBadgeBackgroundColor({color: '#4688F1'});
    	sendResponse();

    } else if (message.data == “logout”) {
    	chrome.browserAction.setBadgeText({text: 'OFF'});
    	chrome.browserAction.setBadgeBackgroundColor({color: '#4688F1'});
    	sendResponse();
    } 
    
    
  });

*/
/*function(request, sender, sendResponse) {
    if (request.data == "logined") {
    	console.log("data accepted")
    	sendResponse({ result: "sccess" });
      
    } else {
      sendResponse({ result: "error", message: `Invalid 'cmd'` });
    }*/