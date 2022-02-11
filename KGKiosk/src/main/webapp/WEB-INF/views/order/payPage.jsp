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
<title>결제 페이지</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/foodFormStyle.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/orderPageStyle.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<body>

	<div class="all">
	<div class="orderList">
	<u1><h2>주문정보</h2></u1>
		<ul class="header">
			<li class="subRow orderName header">제품명<li>
			<li class="subRow orderPrice header">가격<li>
			<li class="subRow orderCount header">개수<li>
		</ul>
		<hr id="headerHr">
		<c:forEach var="CartLists" items="${CartLists}">
			<div class="scrollPoint">
			<ul class="row">
				<li class="subRow orderName">${CartLists.foodName}</li>
				<li class="subRow orderPrice">${orderVO.orderPrice}</li>
				<li class="subRow orderCount">${CartLists.foodCount}</li>
			</ul>
			</div>
		</c:forEach>
	</div>
	</div>
	
	<div class="orderInfo">
		<div class="address">
			<div class="label">배달 받을 주소</div>
			<div class="content">${member.homeAddress}</div>
		</div>
		<div class="totalPrice">
			<div class="label">총 주문금액</div>
			<div class="content">${orderVO.orderPrice}</div>
		</div>
		<div class="all">
		    <form name="foodId" method="post"  action="${contextPath}/order/addOrder.do">
			<br>
			<div class="goLeft">
			<div class="label">수령 방법</div>
			<div class="radioBox">
				<label class="radio">
					<input type="radio" name="orderType" value="배달" checked="checked"><span>배달</span>
				</label>
				<label class="radio">
					<input type="radio" name="orderType" value="포장" checked=false><span>포장</span>
				</label>
			</div>
			<br>
			<div class="label">결제 방법</div>
			<div class="radioBox">
				<label class="radio">
					<input type="radio" name="orderBY" value="카드" checked="checked"><span>카드</span>
				</label>
				<label class="radio">
					<input type="radio" name="orderBY" value="현금" checked=false><span>현금</span>
				</label>
			</div>
			</div>
			<br>
			<div class="goRight">
				<input type="hidden" name="id" id= "id" value="${member.id}">
				<input type="hidden" name="orderPrice" id= "orderPrice" value="${orderVO.orderPrice}">			
				<input type="hidden" name="foodName" id= foodName value="${orderVO.foodName}">
				<input type="hidden" name="orderSale" id= orderSale value="0">
				<input type="submit" value="결제" class="submenuLink"> 
			</div>
			</form>
		</div>
	</div>
</body>
</html>

<%-- 
<div class="header"><h2>1. 주문정보</h2></div>
<hr id="headerHr">
<div class="formDiv">
	<form name="frmAddMember" method="post"  action="${contextPath}/member/modifyMember.do">
		<div class="inputBox">
			<label for="name">주문자이름</label>
			<input type="text" name="name" id="name" value="${member.name}" size="20"placeholder="이름">
		</div>
		<div class="inputBox">
			<label for="homeAddress">주문자 주소</label>
			<input type="text" name="homeAddress" id="homeAddress" value="${member.homeAddress}" size="20"placeholder="주소">	
		</div>
		<div class="button">
			<input type="submit" value="수정하기" > 
		</div>		
	</form>
</div> --%>