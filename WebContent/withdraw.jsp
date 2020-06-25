<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/vader/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link href="https://fonts.googleapis.com/css2?family=Iceberg&display=swap" rel="stylesheet"><!-- googlr font -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title></title>
<script>
$(function(){
	$("input[name=withdrawBtn]").click(function(){
		if($("#password").val()=="") alert("비밀번호를 입력해주세요.")
		else if($("#password").val()!="${sessionScope.vo.password}") alert("비밀번호를 잘못 입력하셨습니다.");
		else if($("#password").val()=="${sessionScope.vo.password}"){
			alert("정말 탈퇴하시겠습니까?");
			alert("탈퇴되었습니다. 그동안 이용해주셔서 감사합니다.");
			var url = "#";//홈으로
			$(location).attr('href',url);
		}//password	
	});//withdrawBtn
	$("input[name=cancelBtn]").click(function(){
		alert("탈퇴를 취소합니다.");
		var url = "#";//이전페이지로
		$(location).attr('href',url);
	});//cancelBtn
});
</script>
<style>
	.container{width:50%;margin:0 auto;text-align:center;}
	#announce{width:80%;margin:0 auto;text-align:center;border:1px solid gray;padding:5px;}
	h1{margin:0 auto;padding:1%;text-align:center;margin-top:5%;}
</style>
</head>
<body>
	<h1>Withdraw</h1>
	<div class="container">
		<div id="announce">
			<p>탈퇴하시면 EZBasket에서 회원님과 모든 관련 정보는 삭제됩니다.</p>
			<p>본인 확인을 위해 비밀번호를 입력해주세요.</p>
		</div><p><p>
		PW &nbsp;&nbsp;<input type ="password" id="password" required="required"><p><p><p>
		<input type="button" name="withdrawBtn" value="탈퇴하기">&nbsp;&nbsp;
		<input type="button" name="cancelBtn" value="취소">
	</div>
</body>
</html>