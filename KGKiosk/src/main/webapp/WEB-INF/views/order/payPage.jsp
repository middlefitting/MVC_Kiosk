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
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/viewCoupon.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<body>

	<div class="all">
	<div class="compList">
	<u1><h2>주문 정보</h2></u1>
		<ul class="header">
			<li class="subRow couponKey header">제품명<li>
			<li class="subRow couponName header">가격<li>
			<li class="subRow couponPercent header">개수<li>
		</ul>
		<hr id="headerHr">
		<c:forEach var="CartLists" items="${CartLists}">
			<ul class="row">
				<li class="subRow couponKey">${CartLists.foodName}</li>
				<li class="subRow couponName">${CartLists.foodPrice}</li>
				<li class="subRow couponPercent">${CartLists.foodCount}</li>
			</ul>
		</c:forEach>
	</div>
	</div>
<h4>주소: ${member.homeAddress}</h4>
<h4>총 가격: ${orderVO.orderPrice}</h4>
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
<br><br>
	<div class="all">
	    <form name="foodId" method="post"  action="${contextPath}/order/addOrder.do">
		<br>
		<div class="radioBox">
			<label class="radio">
				<input type="radio" name="orderType" value="배달" checked="checked"><span>배달</span>
			</label>
			<label class="radio">
				<input type="radio" name="orderType" value="포장" checked=false><span>포장</span>
			</label>
		</div>
		<br>
		<div class="radioBox">
			<label class="radio">
				<input type="radio" name="orderBY" value="카드" checked="checked"><span>카드</span>
			</label>
			<label class="radio">
				<input type="radio" name="orderBY" value="현금" checked=false><span>현금</span>
			</label>
		</div>
		<br>
			<input type="hidden" name="id" id= "id" value="${member.id}">
			<input type="hidden" name="orderPrice" id= "orderPrice" value="${orderVO.orderPrice}">			
			<input type="hidden" name="foodName" id= foodName value="${orderVO.foodName}">
			<input type="hidden" name="orderSale" id= orderSale value="0">
			<input type="submit" value="결제" class="submenuLink"> 
		</form>
	</div>
</body>
</html>