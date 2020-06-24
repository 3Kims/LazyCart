
	document.getElementById("gocart").addEventListener("click",goCart);
	document.getElementById("addcart").addEventListener("click",addCart);

function goCart() {
	alert("이동 시작");
	window.location.assign("https://www.naver.com");
	alert("이동 완료");
}
function addCart() {
	location.href="cart.html";
}