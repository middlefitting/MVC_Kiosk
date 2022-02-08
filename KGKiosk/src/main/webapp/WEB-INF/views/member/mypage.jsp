<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<div class="myPage">
	<div class="header">
		<h1>마이페이지</h1>
		<b>${member.name }</b>님 안녕하세요!
	</div>
	<div class="pageMenu">
		<div class="subMenu"><a href="">문의</a></div>
		<div class="subMenu">내 정보 수정</div>
		<div class="subMenu">로그아웃</div>
	</div>
</div>
</body>
</html>