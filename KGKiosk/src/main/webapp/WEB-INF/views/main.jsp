<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!-- 
	이벤트 최신 3개를 db에서 뽑아와서 이벤트 배너에 넣는다.
 -->
<%
  request.setCharacterEncoding("UTF-8");
%>    
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>메인 페이지</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <%-- <script src="${contextPath}/resources/js/mainJS.js"></script> --%>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mainStyle.css">
  <c:choose>	
	<c:when test="${errorType=='loginError'}">
	  <script>
	    window.onload=function(){
	      alert("로그인 후 이용해 주세요!");
	    }
	    ${errorType=''}
	  </script>
	</c:when>
  </c:choose>
</head>

<body>

	<div class="eventBanner">
		<input type="radio" name="slide" id="slide01" checked>
		<input type="radio" name="slide" id="slide02">
		<input type="radio" name="slide" id="slide03">
		
		<div class="slidewrap">
			<ul class="slidelist">
				<li>
					<a href="${contextPath}/eventpost/memListAllEventPostList.do">
						<label for="slide03" class="left"></label>
						<img src="${contextPath}/resources/image/italian.jpg" width="500" height="500">
						<label for="slide02" class="right"></label>
					</a>
				</li>
				<li>
					<a href="${contextPath}/eventpost/memListAllEventPostList.do">
						<label for="slide01" class="left"></label>
						<img src="${contextPath}/resources/image/birthday.jpg" width="500" height="500">
						<label for="slide03" class="right"></label>
					</a>
				</li>
				<li>
					<a href="${contextPath}/eventpost/memListAllEventPostList.do">
						<label for="slide02" class="left"></label>
						<img src="${contextPath}/resources/image/oven.jpg" width="500" height="500">
						<label for="slide01" class="right"></label>
					</a>
				</li>
			</ul>
		</div>
	</div>
	<div class="orderButton">
		<div class="deliveryOrder" onclick="location.href='${contextPath}/menu/deliveryMenuPage.do';">
			<img src="${contextPath}/resources/image/deliveryIcon.png" width="100px">
			<h2>배달주문</h2>
		</div>
		<div class="packingOrder" onclick="location.href='${contextPath}/menu/packageMenuPage.do';">
			<img src="${contextPath}/resources/image/packingIcon.png" width="100px">
			<h2>포장주문</h2>
		</div>
	</div>
</body>
</html>