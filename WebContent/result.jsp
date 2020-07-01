<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<table>
		<c:forEach items="${productListByCategory}" var="product">
			<c:choose>
				<c:when test="${empty product.img}">
					<!-- 카트가 비어있을 경우 아무것도 표시 안함. -->
				</c:when>
				<c:otherwise>
				<ul  class="list-group-item">
                   <li id="productImg" alt="${product.id}"><a href="${product.url}"><img src="${product.img}" width="180px" height="180px"></a></li>
                   <li id="name">${product.name}</li>
                   <li id="price">${product.price}</li>
                   <li id="category">${product.category}</li>
                   <li id="delete"><a href="DeleteProduct.do?productId=${product.id}"><img id="DeleteProduct" src="img/delete.png" width="20%" height=="20%"></a></li>
				</ul>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
</body>
</html>