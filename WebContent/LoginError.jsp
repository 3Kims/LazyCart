<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  
  <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  
  <title>Login</title>
  
<script>
$( function() {
    $( ".widget input[type=submit], .widget a, .widget button" ).button();
    $( "button, input, a" ).hover( function( event ) {
      event.preventDefault();
    } );
  } );
</script>
<style>
		/*login box  */
	#loginErrorContainer{
		width:80%;height:90%;
		margin:0 auto;
		background:#fff;
		text-align:center;
		padding:2%;margin-top:5%;border:2px solid #E3F2FD;border-radius:15px;font-size:0.8em;
	}
	h1, h2, h3{
		margin:0 auto;padding:1%;text-align:center;font-size:40px;color:#6c757d;
	}
	.toHome{
		border:1.3px solid #03a9f4ad;
		background:#fff;
		border-radius:2px;
		font-size:14px;
		height:30px;
		width:90px;
	}
</style>
</head>
<body>
	<div class="container">
		<div id="loginErrorContainer">
			<h2>로그인에 실패하셨습니다.</h2> 
			<h3>로그인 화면으로 돌아가 다시 시도해주세요.</h3>
			<a href="main.jsp"><input type="button" value="Home" class = "ui-button ui-widget ui-corner-all toHome"></a>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>	
</body>
</html>