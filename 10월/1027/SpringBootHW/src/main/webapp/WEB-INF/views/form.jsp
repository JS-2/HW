<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set value="${pageContext.request.contextPath}" var="root"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품입력폼</title>
</head>
<%-- form.jsp --%>
<body>
  <h1>Welcome To SSAFY</h1>
  <hr>
  <h2>상품 등록</h2>
  <br>
  
  <form method="post" action="regist">
   <table>
      <tr>
        <td style="background-color:lightgray">아이디</td>
        <td><input type="text" name="id"></td>
        <td style="background-color:lightgray">상품명</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td style="background-color:lightgray">가격</td>
        <td><input type="text" name="price"></td>
        <td style="background-color:lightgray">설명</td>
        <td><input type="text" name="description">
            <button>제출</button></td>
      </tr>
   </table>
   <br>
   <a href="${root }/list">목록보기</a>
  
  </form>
  
</body>
</html>






