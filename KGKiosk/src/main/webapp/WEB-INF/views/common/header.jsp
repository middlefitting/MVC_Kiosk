<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/headerStyle.css">
<title>헤더</title>

</head>
<body>
  <div id="all"> <!-- table tr -->
     <div id="logo">
		<a href="${contextPath}/main.do">
			<img src="${contextPath}/resources/image/pizzaLogo.png" height="80px" />
		</a>
     </div>
     <!-- 메뉴바 -->
     <div id="topMenu" >
     	<ul> 
     		<li class="topMenuLi"> <a class="menuLink" href="">메뉴</a> 
     			<ul class="submenu">
     				<li><a href="" class="submenuLink">피자</a></li>
     				<li><a href="" class="submenuLink">세트</a></li> 
     				<li><a href="" class="submenuLink">사이드</a></li> 
     				<li><a href="" class="submenuLink">음료&기타</a></li>
     			</ul>
     		</li>
     		<li class="topMenuLi"> <a class="menuLink" href="">쿠폰</a> </li>
     		<li class="topMenuLi"> <a class="menuLink" href="">이벤트</a>
     			<ul class="submenu"> 
     				<li><a href="" class="submenuLink">이벤트</a></li> 
     				<li><a href="" class="submenuLink">단체주문</a></li> 
     			</ul> 
     		</li> 
     	</ul> 
     </div>
    <div id="address">
    	<a href="#">
    		<img src="${contextPath}/resources/image/locationIcon.png" height="50px">
    	</a>
    </div>
	<div id="login">
		<c:choose>
			<c:when test="${isLogOn == true  && member!= null}">
				<a href="${contextPath}/member/mypage.do">
					${member.name }님 <br> 안녕하세요 <br>
					<img src="${contextPath}/resources/image/memberIcon.png" height="20px">
				</a>
			</c:when>
			<c:otherwise>
				<a href="${contextPath}/member/loginForm.do">
					<img src="${contextPath}/resources/image/memberIcon.png" height="40px">
				</a>
			</c:otherwise>
		</c:choose>     
	</div>
    <div id="cart">
     	<a href="#">
			<img src="${contextPath}/resources/image/cartIcon.png" height="40px">
		</a>
     </div>
</div>


</body>
</html>