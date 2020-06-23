<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/vader/jquery-ui.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>Update User Information</title>
<script type="text/javascript">
</script>
<style type="text/css">
	form{width:50%;margin:0 auto;padding-top:2%;padding-bottom:2%;border:3px double gray;}
	#infoInput{text-align:left;margin:3%;}
	#buttons{text-align:center;margin:3%;}
	h1{width:50%;padding:5px;margin:0 auto;margin-top:5%;background:lightgray;text-align:center;}
	#phone1,#phone2,#phone3{width:60px;}	
</style>
</head>
<body align="center">
	<h1>Update User Information</h1><p>
	<form action="" id="registerFrm" method="post">
	<div class="container" id="infoInput">
		이름 &nbsp;&nbsp;<input type ="text" id="name" readonly="readonly" value="${name}"><p><p>
		휴대전화 번호 &nbsp;&nbsp;<input type ="text" id="phone1" required="required" value="${phone1}"> - <input type ="text" id="phone2" required="required" value="${phone2}"> - <input type ="text" id="phone3" required="required" value="${phone3}"><p>
		ID &nbsp;&nbsp;<input type ="text" id="id" readonly="readonly" value="${id}">
		<span id="idCheck"></span><p>
		PW &nbsp;&nbsp;<input type ="password" id="password" required="required" value="${password}"><p>
		PW확인 &nbsp;&nbsp;<input type ="password" id="passwordCheck" required="required"><p>
		주소 &nbsp;&nbsp;<input type ="text" id="address" value="${address}"><p></p>
	</div><p>
	<div id="buttons">
		<input type="button" id="update" value="회원정보 수정" text-align="center">&nbsp; &nbsp;
		<input type="button" id="updateCancel" value="수정 취소">
	</div>
	</form>
</body>
</html>