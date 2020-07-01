<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/vader/jquery-ui.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<title>Insert title here</title>
<script type="text/javascript">

</script>
<style type="text/css">
	body{background:#E3F2FD;font-family: 'Iceberg', cursive;}
	.container{width:40%;height:40%;margin:0 auto;background:#fff;align:center;padding:2%;margin-top:5%;border:2px solid #fff;border-radius:20px;text-align:center;}
	
</style>
</head>
<body>
	<div class="container">
		<h2>${customer.name}님,</h2> 
		<h3>회원으로 등록되셨습니다.</h3> 
		<a href="main.jsp"><input type="button" name="homeBtn" value="홈으로"></a>
	</div>
</body>
</html>