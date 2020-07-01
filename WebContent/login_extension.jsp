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
	#loginContainer{
		width:90%;height:90%;
		margin:0 auto;
		background:#fff;padding:2%;margin-top:5%;border:2px solid #fff;border-radius:15px;font-size:0.8em;
	}
	#loginFrmBox{
		margin:0 auto;text-align:center;
	}
	.lg_pw_textbox{
		border: 1px solid #E6E6E6; border-radius:2px; width:250px;height:30px;
	}
	 ul li{
		list-style-type:none;display:inline;
	}
	h1{
		margin:0 auto;padding:1%;text-align:center;font-size:40px;color:#6c757d;
	}
	.Signin_register_Btn{
		border:1.3px solid #03a9f4ad;
		background:#fff;
		border-radius:2px;
		font-size:14px;
		text-align:center;
		height:30px;
		width:90px;
	}
	
	/* register box  */
	.visuallyhidden {
	    border: 0;
	    clip: rect(0 0 0 0);
	    height: 1px;
	    margin: -1px;
	    overflow: hidden;
	    padding: 0;
	    position: absolute;
	    width: 1px;
	}	
	#registerBody{
		align:center;
		background:#fff;
	}
	#registerContainer{
		width:100%;height:40%;margin:0 auto;background:#fff;align:center;padding:2%;margin-top:5%;border:2px solid #E3F2FD;border-radius:15px;font-size:0.8em;
	}
	#registerForm form{
		margin:0 auto;text-align:center;padding:3px;
	}
	#registerForm #buttons div{
		display:inline;
	}
	#registerForm table{
		margin:0 auto;
	}
	#registerForm table td{
		text-align:left;
	}
	#registerForm table td span{
		color:orange;
	}
	#registerForm table input, #registerForm .initialize{
		border: 1px solid #e6e6e6; border-radius:2px; width:200px;height:25px;
	}
	#buttons{
		text-align:center;margin:3%;
	}
	#registerForm table input[id="phone1"], 
	#registerForm table input[id="phone2"], 
	#registerForm table input[id="phone3"]{width:58.5px;}
	
	#registerForm table input[id="postcode"]{
		width: 60px;
		margin-top: 30px;
	}
	#registerForm table input[id="searchPostCode"]{
		width: 95px;
		text-align: center;
	}
	
</style>
</head>
<body>

	<!-- login carousel -->
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active" data-interval="false">
		    	<div id="loginBody">
						<div class="container" >
							<div id="loginContainer">
								<h1>Login</h1>
									<div id="loginFrmBox">
										<!-- login form -->
										<form action="LoginController.do" id="loginFrm" method="post">
											<br>
											ID &nbsp;&nbsp;<input type ="text" name="id" class = "lg_pw_textbox" required="required"><p></p><p></p>
											PW &nbsp;&nbsp;<input type ="password" name="password" class="lg_pw_textbox" required="required" ><p></p><br>
											<input type="submit" name="loginSubmit" value="Login" class="ui-button ui-widget ui-corner-all Signin_register_Btn"> &nbsp;
											<a href="#carouselExampleControls" role="button" data-slide="next"><input type="button" id="registerCarousel" name="registerSubmit" value="Register" class="ui-button ui-widget ui-corner-all Signin_register_Btn"></a><p></p>
											<p></p><p></p><p></p>
										</form>
									</div>
							</div>
						</div>
					</div>
		    </div>			
		    
		    <!-- register carousel -->				 
			  <div class="carousel-item">
			  	<div id="registerBody">
			   		<div class="container">
			    		<div id="registerContainer">
								<h1>Register</h1><p></p>
									<div id="registerForm">
										<!-- register form -->
										<form action="registerSubmit.do" id="registerFrm" method="post" onsubmit="return registerCheck();">
											<table>
												<tr>
													<td><span>*</span>이름</td><td><input type ="text" id="name" name="name" required="required"></td>
												</tr>
												<tr>
													<td><span>*</span>휴대전화 번호</td>
													<td>
															<input type ="text" id="phone1" name="phone1" required="required" maxlength=3> 
															- <input type ="text" id="phone2" name="phone2" name="phone2" required="required" maxlength=4> 
															- <input type ="text" id="phone3" name="phone3" name="phone3" required="required" maxlength=4>						
													</td>
												</tr>
												<tr>
													<td><span>*</span>ID</td>
													<td><input type ="text" id="register_id" name="id" required="required"><span id="idCheck"></span><p></p></td>
												</tr>
												<tr>
													<td><span>*</span>PW</td>
													<td><input type ="password" id="password1" name="password1" required="required"></td>
												</tr>
												<tr>
													<td><span>*</span>PW확인</td>
													<td><input type ="password" id="password2" name="password2" required="required"><span id="passwordCheck"></span></td>
												</tr>
												<tr>
													<td>주소</td>
													<td>
														<input type="text" id="postcode" name="postcode" placeholder="우편번호">
														<input type="button" id="searchPostCode" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
														<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소"><br>
														<input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소">
													</td>			
												</tr>
											</table>
											<!-- carousel prev button -->
											<div id="buttons">
												<div class="input-group-append">
													<a href="#carouselExampleControls" role="button" data-slide="prev">
													<input type="button" id="prevCarousel" value="뒤로" class="ui-button ui-widget ui-corner-all Signin_register_Btn"></a>
													<span class="sr-only">Prev</span>&nbsp; &nbsp;	
												<input type="submit" class="ui-button ui-widget ui-corner-all Signin_register_Btn" name="registerSubmit" value="회원가입">&nbsp; &nbsp;
												<input type="button" class="ui-button ui-widget ui-corner-all Signin_register_Btn" name="initialize"  value="초기화">
												</div>
											</div>
										</form>
									</div>
							</div>

							<!-- 주소 찾기 API script -->									
							<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							<script><!-- 주소 찾기 API script -->
							    function execDaumPostcode() {
						        new daum.Postcode({
					            oncomplete: function(data) {
				                var roadAddr = data.roadAddress; // 도로명 주소 변수
				                var extraRoadAddr = ''; // 참고 항목 변수
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
				                }
				                else if(data.autoJibunAddress) {
			                    var expJibunAddr = data.autoJibunAddress;
			                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
			                    guideTextBox.style.display = 'block';
				                } 
				                else {
			                    guideTextBox.innerHTML = '';
			                    guideTextBox.style.display = 'none';
				                }
					            }
						        }).open();
							    }
							</script><!-- 주소 찾기 API script -->
						</div>
			    </div>
		    </div>
		  </div>
		</div><!--carousel  -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>	
</body>
</html>