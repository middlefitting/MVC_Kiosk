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
<title>쿠폰제거페이지</title>

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/adminCoupon.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>


</head>
<body>

<%-- 
	<div class="header"><h2>쿠폰생성</h2></div>
	<div class="formDiv">
		<form name="frmAddCoupon" method="post" action="${contextPath}/coupon/addCoupon.do">
			<div class="inputBox">
				<input type="text" name="couponKey" id="cpk" value="" size="20" placeholder="쿠폰 키">
				<label for="cpk">쿠폰 key</label>
			</div>
			<div class="inputBox">
				<input type="" name="couponName" id="cpn" value="" size="20" placeholder="쿠폰명">
				<label for="cpn">쿠폰명</label>
			</div>
			<div class="inputBox">
				<input type="text" name="couponPercent" id="cpp" value="" size="20" placeholder="쿠폰 할인율">
				<label for="cpp">쿠폰 할인율</label>
			</div>
			<div class="inputBox">
				<input type="text" name="couponAmount" id="cpam" value="" size="20" placeholder="쿠폰 할인가">
				<label for="cpam">쿠폰 할인가</label>
			</div>
			<div class="inputBox">
				<input type="text" name="couponLeast" id="cpl" value="" size="20" placeholder="쿠폰 적용 최소금액">
				<label for="cpl">쿠폰 적용 최소금액</label>
			</div>
			<div class="inputBox">
				<input type="text" name="couponEndDate" id="cped" value="" size="20" placeholder="쿠폰 유효기간">
				<label for="cped">쿠폰 유효기간</label>
			</div>
			<div class="button">
				<input type="submit" value="쿠폰발행">
			</div>
		</form>
	</div>
	  --%> 
 	 
 	<div class="header"><h2>쿠폰삭제</h2></div>
		<div class="formDiv">
			<form name="frmremoveCoupon" method="post" action="${contextPath}/coupon/removeCoupon.do">
				<div class="inputBox">
					<input type="text" name="couponKey" id="cpremove" vlaue="" placeholder="쿠폰 키">
					<label for="cpremove">쿠폰 키</label>
				</div>
				<div class="button">
					<input type="submit" value="쿠폰제거">
				</div>
			</form>
		</div>

<%--  
 		<h2>쿠폰조회</h2><a href= "${contextPath}/coupon/listAllCouponList.do">조회</a>
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