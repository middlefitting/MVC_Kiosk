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
<title>관리자 헤더</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/adminHeaderStyle.css">
</head>
<body>
<table border=0  width="100%">
	<tr>
     <td>
		<a href="${contextPath}/adminMain.do">
			<img src="${contextPath}/resources/image/pizzaLogo.png" height="80px" />
		</a>
     </td>
     <td id="topMenu">
     	<ul>
     		<li class="topMenuLi"><a class="menuLink" href="${contextPath}/complaintpost/listAllComplaintPostList.do">문의내역</a></li>
     		<li class="topMenuLi"><a class="menuLink" href="${contextPath}/eventpost/listAllEventPostList.do">이벤트관리</a></li>
     		<li class="topMenuLi"><a class="menuLink" href="">메뉴관리</a></li>
     		<li class="topMenuLi"><a class="menuLink" href="">쿠폰관리</a></li>
     	</ul>
     </td>
     <td>
     	<a id="logout" href="${contextPath}/member/logout.do">로그아웃</a>
     </td>
  </tr>
</table>


</body>
</html>