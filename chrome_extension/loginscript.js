(function(doc) {
  var s = doc.createElement('iframe');
  s.type = 'text/javascript';
  s.setAttribute("src",http://localhost:8888/EZbasket/login.jsp);
 // s.src = chrome.extension.getURL(".js");
  var x = doc.getElementsByTagName('script')[0];
  x.parentNode.insertBefore(s, x);
})(document);