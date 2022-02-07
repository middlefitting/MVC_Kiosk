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
<table id="all" border=0  width="100%">
  <tr>
     <td id="logo">
		<a href="${contextPath}/main.do">
			<img src="${contextPath}/resources/image/pizzaLogo.png" height="80px" />
		</a>
     </td>
     <!-- <td>
       <h1><font size=30>Pizza Hot</font></h1>
     </td> -->
     <!-- 메뉴바 -->
     <td id="topMenu" >
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
     </td>
    <td id="address">
    	<a href="#">
    		<img src="${contextPath}/resources/image/locationIcon.png" height="50px">
    	</a>
    </td>
	<td id="login">
		<c:choose>
			<c:when test="${isLogOn == true  && member!= null}">
				<h3>${member.name }님 안녕하세요</h3>
				<a href="${contextPath}/member/logout.do">
					<img src="${contextPath}/resources/image/memberIcon.png" height="40px">
				<!-- <h3>로그아웃</h3> --></a>
			</c:when>
			<c:otherwise>
				<a href="${contextPath}/member/loginForm.do">
					<img src="${contextPath}/resources/image/memberIcon.png" height="40px">
				<!-- <h3>로그인</h3> --></a>
			</c:otherwise>
		</c:choose>     
	</td>
     <td id="cart">
     	<a href="#">
			<img src="${contextPath}/resources/image/cartIcon.png" height="40px">
		</a>
     </td>
     
     <%-- <td>     
     <ul id="menuMain"> <!-- id="main-menu" -->
		<li class="menuMainLi"><a href="#" class="menuMainLink">메뉴</a>
			<ul id="menuSub">
				<!-- 아래 네 개 컨트롤러는 걍 해당 페이지로 이동만 하게 해주세요 -->
				<li><a href="${contextPath}/menu/pizzaMenu.do" class="menuSubLink">피자</a></li> <!-- pizzaMenuPage.jsp -->
				<li><a href="${contextPath}/menu/setMenu.do" class="menuSubLink">세트</a></li> <!-- setMenuPage.jsp -->
				<li><a href="${contextPath}/menu/sideMenu.do" class="menuSubLink">사이드</a></li> <!-- sideMenuPage.jsp -->
				<li><a href="${contextPath}/menu/beverageOtherMenu.do" class="menuSubLink">음료&기타</a></li> <!-- beverageOtherMenuPage.jsp -->
			</ul>
		</li>
		<li class="menuMainLi"><a href="" class="menuMainLink">쿠폰</a></li>
		<li class="menuMainLi"><a href="#" class="menuMainLink">이벤트</a>
			<ul id="menuSub">
				<li><a href="${contextPath}/menu/event.do" class="menuSubLink">이벤트</a></li>
				<li><a href="${contextPath}/menu/groupOrder.do" class="menuSubLink">단체주문</a></li>
			</ul>
		</li>
	</ul>
	</td>
	<td>
		<a href="#"><h3>주소</h3></a>
	</td>
     <td>
       <!-- <a href="#"><h3>로그인</h3></a> -->
       <c:choose>
          <c:when test="${isLogOn == true  && member!= null}">
            <h3>${member.name }님 안녕하세요</h3>
            <a href="${contextPath}/member/logout.do"><h3>로그아웃</h3></a>
          </c:when>
          <c:otherwise>
	        <a href="${contextPath}/member/loginForm.do"><h3>로그인</h3></a>
	      </c:otherwise>
	   </c:choose>     
     </td>
     <td>
     	<a href="#"><h3>장바구니</h3></a>
     </td> --%>
  </tr>
</table>


</body>
</html>