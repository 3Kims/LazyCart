<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="java.util.HashMap"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<title>Insert title here</title>

<style type="text/css">
	.bi{
		margin:0px;
	}
	.checkbox{
		border:1px solid #777;border-radius:50%;float:right;height:14px;margin-left:24px;padding:2px;width:14px
	}
	.checked{
		border-color:#4285f4; background:#4285f4;
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
						  <c:when test="${empty sessionScope.user.img}">
						  	<div id="empty_user_thumnail">
							  	<svg class="bi bi-person-bounding-box user_icon" width="50px" height="50px" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg">
										<path fill-rule="evenodd" d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1h-3zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5zM.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5zm15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5z"/>
										<path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
									</svg>
								</div>
						  </c:when>
							<c:otherwise>
								<div id="user_thumnail">
						  		<div class="user_icon"><img src= ${sessionScope.user.img} alt="user_icon"></div>
								</div>
							</c:otherwise>
					  </c:choose>
					<!-- </a> -->
					</div> <!-- 사용자 로고 -->		  
			  </div> <!-- user icon-->
			  
			  <div class="collapse navbar-collapse" id="add_basket">
			    <div class="navbar-nav">
			      <div id="search_box" nav-item nav-link active>
				  		<form action="search_product.do" method="post">
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
		      <%
		      	HashMap categoryMap= new HashMap();
		      %>	
		      <c:set var="categoryList" value=<%=map %>>
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
		      	<c:forEach items="${categoryList}" var="category">
		      		<a href="categoryClick" id="category"><span>${category}</span><span class="checkbox"></span></a>
		      	</c:forEach>
		      	
		      </div>
		      <hr>
		      <div class = "category shop">
		      	<p>쇼핑몰</p>
		      	<c:forEach items="${shopList}" var="shop">
		      		<a href="categoryClick" id="shop"><span>${shop}</span><span class="checkbox"></span></a>
		      	</c:forEach>
		      </div>
		      
		      </section>
		    </div>
		    <div class="col-9">
			    <nav>
						<div><!-- 통계아이콘 --></div> <div><!-- 아이콘영역 --></div> <div><!-- 정렬 영역 --></div>
					</nav>
					<hr>
					<article id="bucketList">
						<!-- 장바구니 리스트 영역 -->
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
						-<br>
					</article>
		    </div>
		  </div>
	</div>
   <!-- Optional JavaScript -->
   <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	 
	 <script>
	 $(function(){
		 	$('#empty_user_thumnail').click(function(){
		 		alert("empty thumnail");
		 		var user = ${sessionScope.user};
		 		if(user == null){
		 			alert("empty session");
		 			return;
		 		}
		 		else{
		 			alert("사진을 넣어주세요.");
		 			
		 		}
		 	});
		 	
		 	$('#user_thumnail').click(function(){
		 		alert("used thmnail");
		 	});
		 	
		 	$('.categoryClick').click(function()){	//카테고리 영역에서 원하는 가격 범위를 선택한경우
		 		var category = $(this).attr("id");	//정렬 기준
		 		var option = $(this).text();
		 		$.ajax({
		 			type: post,
		 			url: 'category.do',
		 			data: {'productList':${productList},'category':category, 'option':option},
		 			error:function(xhr,status,message){
						alert("error : "+message );
					},
					success:function(data){
						$('#bucketList').html(data);	// 장바구니에 데이터를 출력
					}
		 		});	//ajax
		 	};
		 	
	 });	
	 </script>
</body>
</html>