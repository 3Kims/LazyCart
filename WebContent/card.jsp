<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Chart.js -->
<script async="" src="//www.google-analytics.com/analytics.js"></script><script src="../../../dist/2.9.3/Chart.min.js"></script>
<script src="../utils.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<script src="../../../dist/2.9.3/Chart.min.js"></script>
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
	h1{
		align: "center";
	}
	table{
		margin:0 auto;
	}
	table tr td img{
		width:150px;
		height:150px;
		padding:3px;
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
					<svg class="bi bi-search user_icon" width="45px" height="45px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
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
			</nav>
		</div>
  	</header>
			<div class="col">
		    <div class="col-12">
			    <nav>
						<div><!-- 통계아이콘 --></div> <div><!-- 아이콘영역 --></div> <div><!-- 정렬 영역 --></div>
					</nav>
					<hr>
					<article>
	
					
	<h1>카드 뒤집기 게임</h1>
	<br>
	<table>
			<c:set var="No" value="0"/>
			<c:forEach items="${cardList}" var="img">
				<c:if test="${No mod 4 eq 0} ">
				<tr></c:if>
				<td ><img class="cardClick" id="${No}" src=${img}></img></td>
				<c:if test="${No mod 4 eq 3}"></tr></c:if>
				<c:set var="No" value="${No +1}"/>
			</c:forEach>
	</table>
	
	
	
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
<script>
	$(function(){
		$('.cardClick').animate({opacity:"0"}); // to hide image
		var psrc="";
		var pid="";
		$(".cardClick").click(function(){
			$(this).animate({opacity:"100"});
			
			if(psrc!=""){
				if(pid==this.id){
				//	alert("같은 카드를 클릭했습니다!!");
					$("#"+pid).animate({opacity:"0"});
					$(this).animate({opacity:"0"});
				}
				else if(psrc==this.src){
				//	alert("matched!");
					psrc="";
					pid="";
				}
				else{	//같지 않을떄
					$("#"+pid).animate({opacity:"0"});
					$(this).animate({opacity:"0"});
					psrc="";
					pid="";
				//	alert("실패!!")
				}
			}else{
				pid=this.id;
				psrc=this.src;
				console.log("id="+pid +"src="+ psrc);
			}
		});
		
	})
</script>
</body>
</html>
