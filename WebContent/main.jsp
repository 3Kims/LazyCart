<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/vader/jquery-ui.css">
<link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">


<title>Insert title here</title>

<style type="text/css">

	.bi{
		margin:0px;
	}
	.checkbox{
		border:1px solid #777;border-radius:50%;float:right;height:14px;margin-left:24px;padding:2px;width:14px;
	}
	.checked{
		border-color:#4285f4; background:#4285f4;
	}
	
	/*login box  */

	#loginContainer{
	font-family: 'Balsamiq Sans', cursive;
	width:90%;height:90%;
	margin:0 auto;
	background:#fff;padding:2%;margin-top:5%;border:2px solid #fff;border-radius:15px;font-size:0.8em;}
	
	#loginFrmBox{margin:0 auto;text-align:center;}
	#password,#id{border: 1px solid #E6E6E6; border-radius:2px; width:250px;height:30px;}
	ul li{list-style-type:none;display:inline;}
	h1{margin:0 auto;padding:1%;text-align:center;font-size:40px;color:#6c757d;}
	#loginSubmit,#registerSubmit{
	border:1.3px solid #03a9f4ad;
	background:#fff;
	border-radius:2px;
	font-size:14px;
	text-align:center;
	height:30px;
	width:90px;}

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
	
	#registerForm form{margin:0 auto;text-align:center;padding:3px;}
	#registerForm #buttons div{display:inline;}
	#registerForm table{margin:0 auto;}
	#registerForm table td{text-align:left;}
	#registerForm table td span{color:orange;}
	#registerForm table input, #registerForm #initialize{border: 1px solid #e6e6e6; border-radius:2px; width:200px;height:25px;}
	#buttons{text-align:center;margin:3%;}

	h1{margin:0 auto;padding:1%;text-align:center;font-size:40px;color:#6c757d;}
	#phone1,#phone2,#phone3{width:60px;}	
	
	
	/* file box  */
	.fileBox input[type="file"]{
		position:absolute;
		width: 1px;
		height: 1px;
		padding: 0;
		margin: -1px;
		overflow: hidden;
		clip:rect(0,0,0,0);
		border: 0;
	}
	.form-control{
		height: 1.9em;
		width: 10%;
	}
	.user_icon{
		object-fiti:contain;
  }
	#productList table tr td img{
		width: 100%;
	}
</style>

</head>

<body>
	<div class="container">
  	<header>
			<div class="text-center">
			  <a href="main.jsp"><img src="img/cart.png" class="rounded" alt="logo"></a>
			</div><!-- 로고 -->
			
			<div class="sticky-top">
		    <nav class="navbar navbar-light" style="background-color: #e3f2fd; border-radius:10px;">
			  <a class="navbar-brand" href="#">Menu</a>
			  
			  <div class="navbar_icon" data-toggle="collapse" data-target="#add_basket" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
					<svg class="bi bi-cart-plus user_icon" width="50px" height="50px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd" d="M8.5 5a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 .5-.5z"/>
						<path fill-rule="evenodd" d="M8 7.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0v-2z"/>
						<path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
					</svg>			  
			  </div><!-- add basket icon-->
			  
			  <div class="navbar_icon" data-toggle="collapse" data-target="#search_product" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
					<svg class="bi bi-search user_icon" width="50px" height="50px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
						<path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
					</svg>			  
			  </div> <!-- search icon-->
			  
			  <div class="navbar_icon" data-toggle="collapse" data-target="#userinfo" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
					<div class="navbar_icon">
					<!-- <a href="userInfo.jsp"> -->
					  <c:choose>
						  <c:when test="${empty sessionScope.customer.img}">
						  	<span class="badge badge-warning">Off</span>
						  	<div id="empty_user_thumnail">
							  	<svg class="bi bi-person-bounding-box user_icon" width="50px" height="50px" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg">
										<path fill-rule="evenodd" d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1h-3zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5zM.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5zm15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5z"/>
										<path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
									</svg>
								</div>
						  </c:when>
							<c:otherwise>
								<span class="badge badge-success">On</span>
								<div id="user_thumnail">
						  		<div class="user_icon"><img src="${sessionScope.customer.img}" alt="user_icon" width="50px" height="50px"></div>
								</div>
							</c:otherwise>
					  </c:choose>
					<!-- </a> -->
					</div> <!-- 사용자 로고 -->		  
			  </div> <!-- user icon-->
			  
			  <div class="collapse navbar-collapse" id="add_basket">
			    <div class="navbar-nav">
			      <div id="search_box" nav-item nav-link active>
				  		<form action="addcart.do" method="post">
								<div class="input-group">
							    <input type="text" class="form-control" placeholder="Please enter product's url...." name="url">
							    <div class="input-group-append">
							      <button class="btn btn-secondary" type="submit">
							        <i class="fa fa-search"> 
								        <svg class="bi bi-plus" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
												  <path fill-rule="evenodd" d="M8 3.5a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5H4a.5.5 0 0 1 0-1h3.5V4a.5.5 0 0 1 .5-.5z"/>
												  <path fill-rule="evenodd" d="M7.5 8a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1H8.5V12a.5.5 0 0 1-1 0V8z"/>
												</svg>
											</i>
							      </button>
							    </div>
							  </div>
						  </form><!--url로 검색 -->
						  <span class="sr-only">(current)</span>
						</div>
			    </div>
			  </div>
			  
			  <div class="collapse navbar-collapse" id="search_product">
			    <div class="navbar-nav">
			      <div id="search_box" nav-item nav-link active>
				  		<form action="search_product.do" method="post">
								<div class="input-group">
							    <input type="text" class="form-control" placeholder="Please enter product's name...." name="url">
							    <div class="input-group-append">
							      <button class="btn btn-secondary" type="submit">
							        <i class="fa fa-search"> 
								        <svg class="bi bi-search" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><!-- icon -->
												 <path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
												 <path fill-rule="evenodd" d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
												</svg>
											</i>
							      </button>
							    </div>
							  </div>
						  </form><!--url로 검색 -->
						  <span class="sr-only">(current)</span>
						</div>
			    </div>
			  </div>
			  
			  <div class="collapse navbar-collapse" id="userinfo">
			    <div class="navbar-nav">
			      <div id="search_box" nav-item nav-link active>
				  		<!-- 여기부터 시작해야함. -->
					  		<form action="post" id="customerImg">
					  			<div class="fileBox">
					  				<div class="input-group-append">
					  				
						  				<label for="customFile"> 
							  				<svg class="bi bi-image" width="30px" height="30px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
												  <path fill-rule="evenodd" d="M14.002 2h-12a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1zm-12-1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2h-12z"/>
												  <path d="M10.648 7.646a.5.5 0 0 1 .577-.093L15.002 9.5V14h-14v-2l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71z"/>
												  <path fill-rule="evenodd" d="M4.502 7a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"/>
												</svg>
						  				</label>
						  				<input type="text" class="form-control upload-hidden visuallyhidden" value="Choose file" name="imgName" disabled="disabled">
										  <input type="file" id="customFile">
									  </div>
									</div>
					  		</form>
						  <span class="sr-only">(current)</span>
						</div>
			    </div>
			  </div>
			  
			</nav>
		</div>
  	</header>
  		<!-- 레이어 나누기 -->
	  	<div class="row">
		    <div class="col-3">
		      <!-- 위치 표시 -->
		      <p>현재 위치 : 서울</p>
		      <hr>
		      <section>

					<!-- 분류 조건 배열 생성 -->
		      <c:set var="categoryList" value="<%= new java.util.HashSet<String>() %>" />
		      <c:set var="shopList" value="<%= new java.util.HashSet<String>() %>" />
		      <c:forEach items ="${productList}" var="product">
		      		      	<%-- {categoryList}.add({product.category});
		      	{shopList}.add({product.shop}); --%>

		      </c:forEach>
		      
		      <!-- 분류 조건영역 -->
		      <div class = "category price">
		      	<p>가격</p>
		      	<!-- for each를 이용해 아래와 같은 형식으로 뿌려줘야한다. -->
		      	<c:forEach items="${priceList}" var="price">	<!-- priceList생성 필요, productList에 있는 아이템을 가격별로 나눈 List -->
		      		<a class="categoryClick" id="price"><span>${price}</span><span class="checkbox"></span></a>	
		      	</c:forEach>
		      	
		      </div>
		      <div class = "category product">
		      	<p>카테고리</p>
		      	<c:forEach items="${productList}" var="product">
		      		<a class="categoryClick" id="cl"><span>${product.category}</span><span class="checkbox"></span></a>
		      		<script>
		      		$('.categoryClick').click(function(){	//카테고리 영역에서 원하는 가격 범위를 선택한경우
				 		var category = $(this).attr("id");	//정렬 기준
				 		
				 		$.ajax({
				 			type: post,
				 			url: "category.do",
				 			data: {'productList':${"productList"},'category':category},
				 			error:function(xhr,status,message){
								alert("error : "+message );
							},
							success:function(data){
								$('#gridtype').html(data);	// 장바구니에 데이터를 출력
							}
				 		});	//ajax
				 	});
		      		</script>
		      	</c:forEach>
		      	
		      </div>
		      <hr>
		      <div class = "category seller">
		      	<p>쇼핑몰</p>
		      	<a class="categoryClick"><span>11번가</span><span class="checkbox checked"></span></a>
		      </div>
		      
		      </section>
		    </div>
		    <div class="col-9">
			    <nav>
						<div><!-- 통계아이콘 --></div> <div><!-- 아이콘영역 --></div> <div><!-- 정렬 영역 --></div>
					</nav>
					<hr>
					<article>
						<!-- 장바구니 리스트 영역 -->
						
						<c:choose>
							<c:when test="${!empty sessionScope.customer}">
								<div class="list-group" id="productList">
									<table>
									<c:forEach items="${productList}" var="product">
										<c:choose>
											<c:when test="${empty product.img}">
											</c:when>
											<c:otherwise>
												<tr>
													<td>${product.img}</td>
													<td>${product.name}</td>
													<td>${product.price}</td>
													<td>${product.category}</td>
												</tr>
											</c:otherwise>
										</c:choose>
										<c:if test="">
										</c:if>
										
									</c:forEach>
									</table>
								</div>
							</c:when>
							<c:otherwise>
							<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
							  <div class="carousel-inner">
							    <div class="carousel-item active" data-interval="false">
							    	<div id="loginBody">
											<div class="container" >
												<div id="loginContainer">
													<h1>Login</h1>
														<div id="loginFrmBox">
															<form action="LoginController.do" id="loginFrm" method="post">
																<br>
																ID &nbsp;&nbsp;<input type ="text" name="id" id="id" required="required"><p><p>
																PW &nbsp;&nbsp;<input type ="password" name="password" id="password" required="required" ><p><br>
																<input type="submit" name="loginSubmit" id="loginSubmit" value="Login" class="ui-button ui-widget ui-corner-all"> &nbsp;
																<a href="#carouselExampleControls" role="button" data-slide="next"><input type="button" id="registerSubmit" name="registerSubmit" value="Register" class="ui-button ui-widget ui-corner-all"></a><p>
																<p><p><p>
																<ul style="-webkit-padding-start:0px;">
																	<li>Find ID</li> &nbsp; &nbsp;
																	<li>Find PW</li>
																</ul>
															</form>
														</div>
												</div>
											</div>
										</div>
							    </div>			
							    				 
								  <div class="carousel-item">
								  	<div id="registerBody">
								   		<div class="container">
								    		<div id="registerContainer">
													<h1>Register</h1><p>
														<div id="registerForm">
															<form action="registerSubmit.do" id="registerFrm" method="post" onsubmit="return registerCheck();">
																<table>
																	<tr>
																		<td><span>*</span>이름</td><td><input type ="text" id="name" name="name" required="required"></td>
																	</tr>
																	<tr>
																		<td><span>*</span>휴대전화 번호</td><td><input type ="text" id="phone1" name="phone1" required="required" maxlength=3>
																		- <input type ="text" id="phone2" name="phone2" name="phone2" required="required" maxlength=4>
																		- <input type ="text" id="phone3" name="phone3" name="phone3" required="required" maxlength=4></td>
																	</tr>
																	<tr>
																		<td><span>*</span>ID</td><td><input type ="text" id="id" name="id" required="required"><span id="idCheck"></span><p></td>
																	</tr>
																	<tr>
																		<td><span>*</span>PW</td><td><input type ="password" id="password1" name="password1" required="required"></td>
																	</tr>
																	<tr>
																		<td><span>*</span>PW확인</td><td><input type ="password" id="password2" name="password2" required="required"><span id="passwordCheck"></span></td>
																	</tr>
																	<tr>
																		<td>주소</td>
																		<td>
																		<input type="text" id="postcode" name="postcode" placeholder="우편번호">
																		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
																		<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소">
																		<input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소">
																		</td>			
																	</tr>
																</table>
																<div id="buttons">
																	<div><a href="#carouselExampleControls" role="button" data-slide="prev">
																	<input type="button" id="registerSubmit" value="prev" class="ui-button ui-widget ui-corner-all"></a></div><p>
																	<span class="sr-only">Prev</span>
																	<input type="submit" id="registerSubmit" value="회원가입">&nbsp; &nbsp;
																	<input type="button" id="initialize" value="초기화">
																</div>
															</form>
														</div>
												</div>

																					<!-- 주소 찾기 API script -->
												<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
												<script>
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
											</div>
								    </div>
							    </div>
							  </div>
							</div>
							</c:otherwise>
						</c:choose>
					</article>
		    </div>
		  </div>
	</div>
   <!-- Optional JavaScript -->
   <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   
   
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	 
	 <script>
	 $(function(){
			$(document).ready(function(){ 
			 	var fileTarget = $('.fileBox .upload-hidden'); 
			 	fileTarget.on('change', function(){ // 값이 변경되면 
					if(window.FileReader){ // modern browser 
						 var filename = $(this)[0].files[0].name; 
					}
					else { // old IE 
						 var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
					} // 추출한 파일명 삽입 
					$(this).siblings('.upload-name').val(filename); 
				}); 
			});
			
		 	$('#user_thumnail').click(function(){
		 		alert("used thmnail");
		 	});

		 	$('.categoryClick').click(function(){	//카테고리 영역에서 원하는 가격 범위를 선택한경우
		 		var category = $(this).attr("id");	//정렬 기준
		 		
		 		$.ajax({
		 			type: post,
		 			url: "category.do",
		 			data: {'productList':${"productList"},'category':category},
		 			error:function(xhr,status,message){
						alert("error : "+message );
					},
					success:function(data){
						$('#gridtype').html(data);	// 장바구니에 데이터를 출력
					}
		 		});	//ajax
		 	});
	 });	
	 </script>
</body>
</html>