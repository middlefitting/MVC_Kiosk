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
<title>쿠폰 조회 페이지</title>

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/viewCoupon.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body>
	
	<h2 style="font-family:바탕체;">사용가능한 쿠폰</h2>
	
	<div class="all">
	<div class="compList">
		<ul class="header">
			<li class="subRow couponKey header">쿠폰키<li>
			<li class="subRow couponName header">쿠폰명<li>
			<li class="subRow couponPercent header">쿠폰할인율<li>
			<li class="subRow couponAmount header">쿠폰감가<li>
			<li class="subRow couponLeast header">최소주문금액<li>
		</ul>
		<hr id="headerHr">
		<c:forEach var="CouponLists" items="${CouponLists}">
			<ul class="row">
				<li class="subRow couponKey">${CouponLists.couponKey}</li>
				<li class="subRow couponName">${CouponLists.couponName}</li>
				<li class="subRow couponPercent">${CouponLists.couponPercent}</li>
				<li class="subRow couponAmount">${CouponLists.couponAmount}</li>
				<li class="subRow couponLeast">${CouponLists.couponLeast}</li>
			</ul>
		</c:forEach>
	</div>
	</div>
</body>
</html>