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
<title>쿠폰관리페이지</title>

<%-- <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/adminCoupon.css"> --%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mypageStyle.css">

</head>
<body>

<h2>쿠폰 관리</h2>
   <div class="pageMenu">
		<div class="subMenu">
			<a href="${contextPath}/coupon/addCouponPage.do">
				쿠폰생성
			</a>
		</div>
		<div class="subMenu">
			<a href="${contextPath}/coupon/removeCouponPage.do">
				쿠폰삭제
			</a>
		</div>
		<div class="subMenu">
			<a href="${contextPath}/coupon/listAllCouponList.do">
				쿠폰조회
			</a>
		</div>
	</div>
	
</body>
</html>