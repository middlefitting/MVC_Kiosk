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

 	<h2>쿠폰조회</h2><a href= "${contextPath}/coupon/listAllCouponList.do">조회</a>

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

<%--   		<h2>쿠폰조회</h2><a href= "${contextPath}/coupon/listAllCouponList.do">조회</a>
 			<tabel>
 				<thread>
 					<tr>
 						<th>쿠폰키</th>
 						<th>쿠폰명</th>
 						<th>쿠폰할인율</th>
 						<th>쿠폰할인가</th>
 						<th>쿠폰적용최소금액</th>
 						<th>쿠폰유효기간</th><br>
 					</tr>
 				</thread>
 			<tbody>
 				<c:forEach items="${CouponLists}" var="CouponLists">
 					<tr>
 						<td>${CouponLists.couponKey}</td>
 						<td>${CouponLists.couponName}</td>
 						<td>${CouponLists.couponPercent}</td>
 						<td>${CouponLists.couponAmount}</td>
 						<td>${CouponLists.couponLeast}</td>
 						<td>${CouponLists.couponEndDate}</td><br>
 					</tr>
 				</c:forEach>
 			</tbody>	
 --%>
</body>
</html>