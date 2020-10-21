<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To SSAFY</h1><hr>
	<h1>상품목록</h1><br>
	<table>
		<th>아이디</th>
		<th>이름</th>
		<th>가격</th>
		<th>상품설명</th>
		<c:forEach items="${products}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.description}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>