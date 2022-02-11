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
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/cartPageStyle.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

	<br><br><br><br>
	<div class="all">
	<div class="cartList">
	<u1><h1>주문정보</h1></u1>
	<br>
		<ul class="header">
			<li class="subRow cartImg header">상품 이미지<li>
			<li class="subRow cartName header">메뉴명<li>
			<li class="subRow cartPrice header">가격<li>
			<li class="subRow cartAdded header">추가옵션 가격<li>
			<li class="subRow cartCount header">수량<li>
			<li class="subRow cartDel header">삭제<li>
		</ul>
		<hr id="headerHr">
		<c:forEach var="CartLists" items="${CartLists}">
			<div class="scrollPoint">
			<ul class="row">
				<li class="subRow cartImg">${CartLists.foodImg}</li>
				<li class="subRow cartName">${CartLists.foodName}</li>
				<li class="subRow cartPrice">${CartLists.foodPrice}</li>
				<li class="subRow cartAdded">${CartLists.addedPrice}</li>
				<li class="subRow cartCount">
				
						<form name="frmModCart" method="post"  action="${contextPath}/cart/modifyCart.do">
							<div class="inputBox">
								<input type="text" name="foodCount" id="foodCount" value="${CartLists.foodCount}" size="5"placeholder="수량">
								<input type="hidden" name="cartId" id= "cartId" value="${CartLists.cartId}">			
							</div>
							<div class="button">
								<input type="submit" value="수정" > 
							</div>
						</form>
				</li>
				<li class="subRow cartDel">
					<form name="foodId" method="post"  action="${contextPath}/cart/removeSingleCart.do">
						<input type="hidden" name="cartId" id= "cartId" value="${CartLists.cartId}">			
						<input type="submit" value="삭제" class="submenuLink"> 
					</form>
				</li>
			</ul>
			</div>
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
			<input type="submit" value="주문하기" class="submenuLink end"> 
		</form>
	</div>

</body>
</html>