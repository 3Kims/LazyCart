<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/vader/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Iceberg&display=swap" rel="stylesheet"><!-- googlr font -->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script><title>Login</title>

<title>Update User Infomation</title>
<script>
window.onload=function(){
	if(${vo}==null)
		alert("로그인 먼저 진행해주세요.")
}
function updateCheck(){
	if(alert("입력하신 정보로 회원 정보를 수정합니다.")) return true;
	else return false;
}
function cancelCheck(){
	if(alert("회원정보 수정을 취소합니다."))
		locate.href="home.jsp"// 홈이나 이전 페이지로
	else return false;
}
</script>
<style type="text/css">
	body{background:#E3F2FD;font-family: 'Iceberg', cursive;}
	.container{width:60%;height:40%;margin:0 auto;background:#fff;align:center;padding:2%;margin-top:5%;border:2px solid #fff;border-radius:20px;}
	form{margin:0 auto;text-align:center;padding:3px;}
	table{margin:0 auto;}
	table td{text-align:left;}
	table input{border: 1px solid #e6e6e6; border-radius:2px; width:230px;height:25px;}
	#buttons{text-align:center;margin:3%;}
	h1{margin:0 auto;padding:1%;text-align:center;font-size:40px;}
	#phone1,#phone2,#phone3{width:60px;}	
</style>
</head>
<body align="center">
	<div class="container">
	<h1>Update User Infomation</h1><p>
	<form action="registerSuccess.jsp" id="registerFrm" method="post" onsubmit="return registerCheck();">	
	<table>
		<tr>
			<td>이름</td><td><input type ="text" id="name" readonly="readonly"></td>
		</tr>
		<tr>
			<td>휴대전화 번호</td><td><input type ="text" id="phone1" required="required" maxlength=3 value="${phone1}" > 
			- <input type ="text" id="phone2" required="required" maxlength=4 value="${phone2}"> 
			- <input type ="text" id="phone3" required="required" maxlength=4 value="${phone3}"></td>
		</tr>
		<tr>
			<td>ID</td><td><input type ="text" id="id" readonly="readonly" value="${id}"><span id="idCheck"></span><p></td>
		</tr>
		<tr>
			<td>PW</td><td><input type ="password" id="password1" required="required"></td>
		</tr>
		<tr>
			<td>PW확인</td><td><input type ="password" id="password2" required="required"><span id="passwordCheck"></span></td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
			<input type="text" id="postcode" value="${postcode}">
			<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="roadAddress" value="${roadAddress}">
			<input type="text" id="jibunAddress" value="${jibunAddress}">
			<span id="guide" style="color:#999;display:none"></span>
			</td>			
		</tr>
	</table><p>
	<div id="buttons">
		<input type="submit" id="updateBtn" value="수정 완료">&nbsp;&nbsp;
		<input type="button" id="cancelBtn" value="수정 취소">
	</div>
	</form>
</div>
										<!-- 주소 찾기 API script -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	    function execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var roadAddr = data.roadAddress; // 도로명 주소 변수
	                var extraRoadAddr = ''; // 참고 항목 변수
	
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraRoadAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraRoadAddr !== ''){
	                    extraRoadAddr = ' (' + extraRoadAddr + ')';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postcode').value = data.zonecode;
	                document.getElementById("roadAddress").value = roadAddr;
	                document.getElementById("jibunAddress").value = data.jibunAddress;
	                
	                var guideTextBox = document.getElementById("guide");
	                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	                if(data.autoRoadAddress) {
	                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                    guideTextBox.style.display = 'block';
	
	                } else if(data.autoJibunAddress) {
	                    var expJibunAddr = data.autoJibunAddress;
	                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                    guideTextBox.style.display = 'block';
	                } else {
	                    guideTextBox.innerHTML = '';
	                    guideTextBox.style.display = 'none';
	                }
	            }
	        }).open();
	    }
	</script>
</body>
</html>