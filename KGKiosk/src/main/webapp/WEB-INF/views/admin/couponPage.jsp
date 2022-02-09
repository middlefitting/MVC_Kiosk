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
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/adminCoupon.css">
</head>
<body>
 
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
	 
	 
<%-- 	<div class="header"><h2>쿠폰삭제</h2></div>
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
 --%>
</body>
</html>