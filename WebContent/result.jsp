  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<tr>
						<td class="productImg"><img src="${product.img}" width="180px" height="180px"></td>
						<td class="name">${product.name}</td>
						<td class="price">${product.price}</td>
						<td class="category">${product.category}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
</body>
</html>