<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/foodFormStyle.css">
</head>
<body>
<div class="header"><h2>메뉴 수정 및 삭제</h2></div>
<div class="all">
<div class="formDiv">
	<form name="frmFood" method="post"  action="${contextPath}/food/modifyFood.do">
		<div class="radioBox">
			<c:set var="foodCategory" value="${foodVO.foodCategory}"/>
			<label class="radio">
				<input type="radio" name="foodCategory" value="피자" <c:if test="${foodCategory eq '피자'}">checked</c:if> ><span>피자</span>
			</label>
			<label class="radio">
				<input type="radio" name="foodCategory" value="사이드" <c:if test="${foodCategory eq '사이드'}">checked</c:if> ><span>사이드</span>
			</label>
			<label class="radio">
				<input type="radio" name="foodCategory" value="음료" <c:if test="${foodCategory eq '음료'}">checked</c:if> ><span>음료</span>
			</label>
		</div>
		
		<div class="inputBox">
			<input type="text" name="foodName" id="foodName" value="${foodVO.foodName }" size="40"placeholder="제품 이름">
			<label for="foodName">제품 이름</label>
		</div>
		<div class="inputBox">
			<input type="text" name="foodPrice" id="foodPrice" value="${foodVO.foodPrice }" size="40"placeholder="제품 가격">
			<label for="foodPrice">제품 가격</label>
		</div>
		<div class="inputBox">
			<input type="text" name="foodStock" id="foodStock" value="${foodVO.foodStock }" size="40"placeholder="재고">
			<label for="foodStock">재고</label>
		</div>
		<div class="inputBox">
			<input type="text" name="foodInfo" id="foodInfo" value="${foodVO.foodInfo }" size="40"placeholder="제품 설명">
			<label for="foodInfo">제품 설명</label>
		</div>
		<div class="inputBox">
			<img src="/filePath/food/${foodVO.foodImg }" width="100%">
			<label for="foodImg">이미지</label>
		</div>
		<input type="hidden" name="foodKey" id="foodKey" value="${foodVO.foodKey }">
		<div class="button">
			<input type="submit" value="수정" >
			<input type="button" value="삭제" onclick="location.href='${contextPath}/food/removeFood.do?foodKey=${foodVO.foodKey}'"> 
		</div>
	</form>
</div>
</div>
</body>
</html>