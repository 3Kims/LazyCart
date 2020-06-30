<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- google font css -->
<link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">

<!-- basic css,jquery 1.12.1 -->

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Ezbasket</title>
<style type="text/css">
	body{
		font-family: 'Balsamiq Sans', cursive;
	}
	
	/* bootstrap4 icon  */
	.bi{
		margin:0px;
	}
	
	/* category checkbox */
	.checkbox{
		border:1px solid #777;border-radius:50%;float:right;height:14px;margin-left:24px;padding:2px;width:14px;
	}
	.checked{
		border-color:#4285f4; background:#4285f4;
	}
	
	
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
	#phone1,#phone2,#phone3{width:60px;}	
	
	/* file box  */
	.user_icon{
		object-fiti:contain;
  }
  #fileType{
  	display: none;
  }
	.form-control-file{
		width:200px;
	}
	/* ProductList */
	#productImg{object-fiti:contain;}
	.list-group table{width:100%;}
	.list-group table tr{width:100%;}
	.list-group th{display:inline-block;width:25%;text-align:center;}
	.list-group td{width:25%;text-align:center;}
																	
				
	/* 도넛 그래프 */
	<script async="" src="//www.google-analytics.com/analytics.js"></script><script src="../../../dist/2.9.3/Chart.min.js"></script>
	<script src="../utils.js"></script>
	<style>
	canvas {
		-moz-user-select: none;
		-webkit-user-select: none;
		-ms-user-select: none;
	}
	</style>
	<!-- Chart.js --> 
	<style type="text/css">
	@keyframes chartjs-render-animation{from{opacity:.99}to{opacity:1}}
	.chartjs-render-monitor{animation:chartjs-render-animation 1ms}
	.chartjs-size-monitor,.chartjs-size-monitor-expand,.chartjs-size-monitor-shrink{position:absolute;direction:ltr;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1}
	.chartjs-size-monitor-expand>div{position:absolute;width:1000000px;height:1000000px;left:0;top:0}
	.chartjs-size-monitor-shrink>div{position:absolute;width:200%;height:200%;left:0;top:0}		
	#Chart_Btn button{
		border:1.3px solid #03a9f4ad;
		background:#fff;
		border-radius:12px;
		font-size:10px;
		text-align:center;
		height:25px;
		width:90px;
	}				
</style>
</head>

<body>
	<div class="container">
  	<p></p>
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
			  
			  <!-- 사용자로고  -->
			  <div class="navbar_icon" data-toggle="collapse" data-target="#userinfo" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
					<div class="navbar_icon">
					  <c:choose>
						  <c:when test="${empty sessionScope.customer.img}">
						  	<span class="badge badge-warning">Off</span>
						  	<div id="empty_user_thumnail">
							  	<img alt="nosessionImg" src="img/nosession.png" width="50px" height="50px">
								</div>
						  </c:when>
							<c:otherwise>
								<span class="badge badge-success">On</span>
								<div id="user_thumnail">
						  		<div class="user_icon"><img src="${sessionScope.customer.img}" alt="user_icon" width="50px" height="50px"></div>
								</div>
							</c:otherwise>
					  </c:choose>
					</div> <!-- 사용자 로고 -->		  
			  </div> <!-- user icon-->
			  
			  <!-- 카트에 담기 영역 -->
			  <div class="collapse navbar-collapse" id="add_basket">
			    <div class="navbar-nav">
			      <div>
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
			  
			  <!-- 사용자 상품 찾기 정보 -->
			  <div class="collapse navbar-collapse" id="search_product">
			    <div class="navbar-nav">
			      <div>
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
			 
			  <!-- 유저 프로필 업로드 영역 -->
			  

			  <div class="collapse navbar-collapse" id="userinfo">
			    <div class="navbar-nav">
            <div class="input-group-append">
              <c:choose>
                <c:when test="${empty sessionScope.customer}">
                    <span class="sr-only">(current)</span>
                    <strong>로그인이 필요합니다.</strong>
                </c:when>
                <c:otherwise>
                  <form class="form-inline" action="profileImg.do" method="post" enctype="multipart/form-data">
                    <div id="fileBox" class="form-group"> 
                        <svg class="bi bi-person-square" width="25px" height="25px" viewBox="0 0 16 16" fill="#FF5733" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                            <path fill-rule="evenodd" d="M2 15v-1c0-1 1-4 6-4s6 3 6 4v1H2zm6-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        </svg>
                        <label for="fileType">Select</label>
                        <input type="file" id="fileType" name="fileType" class="form-control-file"> 
                        <input type="submit" value="Upload">
                    </div>
                  </form>
                  <span class="sr-only">(current)</span>
                    <a href="LogoutController.do"><button>logout</button></a>
                  <span class="sr-only">(current)</span>
                    <a href="ChangeUserInfoController.do"><button>회원정보수정</button></a>
                  <span class="sr-only">(current)</span>
                    <button class="deleteCustomer">회원탈퇴</button>
                </c:otherwise>
              </c:choose>
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
		      
		      <!-- 분류 조건영역 -->
		        <div class = "category all">
		      	<a class="categoryClick" id="all"><span>전체보기</span><span class="checkbox"></span></a><br>
		      	</div>
		      	<hr>
		      <div class = "category price">
		      <p>가격</p>
            <p><input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;"></p>
            <div id="slider-range"></div><hr>
		      </div>
		      <div class = "category product">
		      	<p><b>카테고리</b></p>
		      	<c:forEach items="${categoryList}" var="category">
		      		<a class="categoryClick" id="category"><span>${category.key}</span><span class="checkbox"></span></a><br>
		      		<c:forEach items="${category.value}" var="secondCategory">
		      			<a class="categoryClick" id="category"><span>${secondCategory}</span><span class="checkbox"></span></a>
		      	  </c:forEach>
            </c:forEach>
		      </div>
		      <hr>
		      <div class = "category seller">
		      	<p><b>쇼핑몰</b></p>
		      	<c:forEach items="${shopList}" var="shop">
		      		<a class="categoryClick" id="shop"><span>${shop}</span><span class="checkbox"></span></a><br>
		      	</c:forEach>
		      </div>
		      <hr>
		      <div class = "category analysis">
		      	<p><b>Analysis</b></p>
		      	<c:forEach items="${data}" var="shop">
		      		<%-- <a class="analysisClick" id="analysis"><span>${data}</span><span class="checkbox"></span></a> --%>
		      	</c:forEach>
		      </div>
		    <!-- 도넛 그래프 -->
				<div id="canvas-holder" style="width:40%"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
				<canvas id="chart-area" style="display: block; height: 142px; width: 255px;" width="427" height="213" class="chartjs-render-monitor"></canvas>
				</div>
				<div id="Chart_Btn">
					<button id="randomizeData">Randomize Data</button>
					<button id="addDataset">Add Dataset</button>
					<!-- <button id="removeDataset">Remove All</button> -->
					<button id="addData">Add Data</button>
					<button id="removeData">Remove Data</button>
					<button id="changeCircleSize">Semi/Full</button>
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
								<table id="productList" class="list-group">
									<tr class="list-group-item">
										<th>Image</th><th>Name</th><th>Price</th><th>Category</th>
									</tr>
								</table>
								<table class="list-group">						
									<c:forEach items="${productList}" var="product">
										<c:choose>
											<c:when test="${empty product.img}">
												<!-- 카트가 비어있을 경우 아무것도 표시 안함. -->
											</c:when>
											<c:otherwise>
												<tr class="list-group-item">
													<td class="productImg"><img src="${product.img}" width="180px" height="180px"></td>
													<td class="name">${product.name}</td>
													<td class="price">${product.price}</td>
													<td class="category">${product.category}</td>
												</tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</table>	
						</c:when>
					<c:otherwise>
							
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
																<ul style="-webkit-padding-start:0px;">
																	<li>Find ID</li> &nbsp;&nbsp;
																	<li>Find PW</li>
																</ul>
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
																			<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
																			<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소">
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
							</div>
							</c:otherwise>
						</c:choose>
					</article>
				</div>
			</div>
		</div>
		<p></p>
		<hr width="90%">
		<p></p>
	
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>  <!-- 낮은 버전이 아래로 -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- Chart.js -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

<script>
	$(function(){
		/* JQUERY 슬라이더 시작 */
	 	$("#slider-range").slider({
			range: true,
			min:  <c:out value="${priceList[0]}"/>,
			max: <c:out value="${priceList[1]}"/>,
			values: [<c:out value="${priceList[0]}"/>,<c:out value="${priceList[1]}"/> ],
			slide: function(event, ui) {
			 $("#amount").val(ui.values[0]+"원 - "+ui.values[1]+"원");
			 //가격 변동시 ajax 호출 -> 가격 범우에 맞는 데이터만 출력
			 $.ajax({
		 			type: "post",
		 			url: "category.do",
		 			data: {'category':"price",'option':ui.values[0]+"-"+ui.values[1]},
		 			error:function(xhr,status,message){
						alert("error : "+message );
					},
					success:function(data){
						var html = data;
						$('.list-group').html(data);
					}
		 		}); //categoryClick ajax
		 	}
		});
		$("#amount").val($("#slider-range").slider("values",0)+"원 - "+$("#slider-range").slider("values", 1)+"원");		 	
		/* JQUERY 슬라이더 끝 */

		/*회원탈퇴 재확인 시작*/
    $("button.deleteCustomer").click(function() {
      var deleteConfirm = confirm("정말 회원탈퇴 하시겠습니까? (회원탈퇴시 모든 회원정보와 장바구니 기록은 자동삭제됩니다.)");
      if (deleteConfirm == true) {
        window.location.href = "DeleteCustomer.do";   
      }else {
        return;
      }//else
    });// $("button.deleteCustomer").click
    /*회원탈퇴 재확인 끝*/
		
		/*user thumnail upload start*/
	 	var fileTarget = $('#fileBox .form-control-file'); 
	 	var fileExtensionArray = ['jpg', 'JPG', 'jpeg', 'JPEG', 'jpe', 'JPE', 'jfif', 'JFIF', 'gif', 'GIF', 'tif', 'TIF', 'tiff', 'TIFF', 'png', 'PNG'];
	 	
	 	fileTarget.on('change', function(){
	 		var fileRoute = $(this).val();  //파일 경로 추출
	 		var fileExtension = fileRoute.substring(fileRoute.length-3); //"확장자 추출"
	 		fileExtension = fileExtensionArray.find(function(data){ //fileExtensionArray안에 있는 것이 아니라면  undefined반환. 맞으면 true반환
		 		if(data == fileExtension){
		 			return true;
		 		}
		 	});
	 		if(fileExtension == null){
	 			alert("이미지 파일을 넣어주세요.(jpg, 'jpeg', 'jpe', 'jfif', 'gif', 'tif', 'tiff', 'png')");
	 			location.reload(true);
	 			return;
	 		}
	 		var fileName= $(this).val().split('/').pop().split('\\').pop();//extract only fileName
	 		//파일명과 파일루트 추출완료
	 		
			$(this).siblings('.upload-name').val(fileName); 
			$(this).siblings('.bi-person-square').attr('fill', '#229954'); 
			//파일명뜨기, 완료 색깔 변경 완료
    /*user thumnail upload finished*/
	 	});
	 	
		/*category start*/
	 	$(".categoryClick").click(function(){	//카테고리 영역에서 원하는 가격 범위를 선택한경우
	 		console.log("clicked!");
	 		var category = $(this).attr("id");	//정렬 기준
	 		var option = $(this).text();
	 		//체크박스 클레스 checked로 바꾸는 로직 필요
	 		$.ajax({
	 			type: "post",
	 			url: "category.do",
	 			data: {'category':category,'option':option},
	 			error:function(xhr,status,message){
					alert("error : "+message );
				},
				success:function(data){
					console.log(data);
					var html = data;
					$('.list-group').html(data);
				}
	 		});//categoryClick ajax
	 	});//categoryClick
	 	/*category finished*/	
 	});//document onload
 	
 	
 	
 	//Chart.js Script
		var randomScalingFactor = function() {
			return Math.round(Math.random() * 100);
		};

		var config = {
			type: 'doughnut',
			data: {
				datasets: [{
					data: [randomScalingFactor(),randomScalingFactor(),randomScalingFactor()],
					backgroundColor: [
						window.chartColors.red,
						window.chartColors.orange,
						window.chartColors.yellow
						],
					label: 'ProductList.size|Category'
				}],
				labels: ['Cupang','Musinsa','Auction']
			},
			options: {
				responsive: true,
				legend: {
					position: 'top',
				},
				title: {
					display: true,
					text: 'Doughnut Chart'
				},
				animation:{
					animateScale: true,
					animateRotate: true
				}
			}
		};

		window.onload = function() {
			var ctx = document.getElementById('chart-area').getContext('2d');
			window.myDoughnut = new Chart(ctx, config);
		};

		document.getElementById('randomizeData').addEventListener('click', function() {
			config.data.datasets.forEach(function(dataset) {
				dataset.data = dataset.data.map(function() {
					return randomScalingFactor();
				});
			});
			window.myDoughnut.update();
		});

		var colorNames = Object.keys(window.chartColors);
		document.getElementById('addDataset').addEventListener('click', function() {
			var newDataset = {
				backgroundColor: [
					window.chartColors.red,
					window.chartColors.orange,
					window.chartColors.yellow
					],
				data: [100,200,300],
				label: 'New dataset ' + config.data.datasets.length,
			};

			for (var index = 0; index < config.data.labels.length; ++index) {
				newDataset.data.push(randomScalingFactor());
				var colorName = colorNames[index % colorNames.length];
				var newColor = window.chartColors[colorName];
				newDataset.backgroundColor.push(newColor);
			}
			config.data.datasets.push(newDataset);
			window.myDoughnut.update();
		});

		document.getElementById('addData').addEventListener('click', function() {
			if (config.data.datasets.length > 0) {
				config.data.labels.push('data #' + config.data.labels.length);

				var colorName = colorNames[config.data.datasets[0].data.length % colorNames.length];
				var newColor = window.chartColors[colorName];

				config.data.datasets.forEach(function(dataset) {
					dataset.data.push(randomScalingFactor());
					dataset.backgroundColor.push(newColor);
				});

				window.myDoughnut.update();
			}
		});

		document.getElementById('removeDataset').addEventListener('click', function() {
			config.data.datasets.splice(0, 1);
			window.myDoughnut.update();
		});

		document.getElementById('removeData').addEventListener('click', function() {
			config.data.labels.splice(-1, 1); // remove the label first

			config.data.datasets.forEach(function(dataset) {
				dataset.data.pop();
				dataset.backgroundColor.pop();
			});

			window.myDoughnut.update();
		});

		document.getElementById('changeCircleSize').addEventListener('click', function() {
			if (window.myDoughnut.options.circumference === Math.PI) {
				window.myDoughnut.options.circumference = 2 * Math.PI;
				window.myDoughnut.options.rotation = -Math.PI / 2;
			} else {
				window.myDoughnut.options.circumference = Math.PI;
				window.myDoughnut.options.rotation = -Math.PI;
			}

			window.myDoughnut.update();
		});
 	
</script>
</body>
</html>
