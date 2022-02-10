<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카트 페이지</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/viewCoupon.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

	<br><br><br><br>
	<div class="all">
	<div class="compList">
	<u1><h1>주문정보</h1></u1>
	<br>
		<ul class="header">
			<li class="subRow couponName header">메뉴명<li>
			<li class="subRow couponPercent header">상품 이미지<li>
			<li class="subRow couponKey header">가격<li>
			<li class="subRow couponName header">수량<li>
			<li class="subRow couponPercent header">삭제<li>
		</ul>
		<hr id="headerHr">
		<c:forEach var="CartLists" items="${CartLists}">
			<ul class="row">
				<li class="subRow couponName">${CartLists.foodName}</li>
				<li class="subRow couponPercent">${CartLists.foodImg}</li>
				<li class="subRow couponKey">${CartLists.foodPrice}</li>
				<li class="subRow couponName">
				
						<form name="frmModCart" method="post"  action="${contextPath}/cart/modifyCart.do">
							<div class="inputBox">
								<input type="text" name="foodCount" id="foodCount" value="${CartLists.foodCount}" size="20"placeholder="이름">
								<input type="hidden" name="cartId" id= "cartId" value="${CartLists.cartId}">			
							</div>
							<div class="button">
								<input type="submit" value="수정" > 
							</div>
						</form>
				</li>
				<li class="subRow couponPercent">
					<form name="foodId" method="post"  action="${contextPath}/cart/removeSingleCart.do">
					<input type="hidden" name="cartId" id= "cartId" value="${CartLists.cartId}">			
					<input type="submit" value="삭제" class="submenuLink"> 
					</form>
				</li>
			</ul>
		</c:forEach>
	</div>
	</div>
		<div class="all">
	    <h2>총 금액: ${orderPrice}원</h2>
		</div>
		
		
	<div class="all">
	    <form name="foodId" method="get"  action="${contextPath}/order/payPage.do">
	   		<input type="hidden" name="id" id= "id" value="${CartLists[0].id}">
			<input type="hidden" name="orderPrice" id= "orderPrice" value="${orderPrice}">			
			<input type="hidden" name="orderType" id= orderType value="${orderType}">
			<input type="hidden" name="foodName" id= foodName value="${foodName}">
			<input type="submit" value="주문하기" class="submenuLink"> 
		</form>
	</div>

</body>
</html>