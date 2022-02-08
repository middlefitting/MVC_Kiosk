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
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mypageStyle.css">
</head>
<body>
<div class="myPage">
	<div class="header">
		<h1>마이페이지</h1>
		<b><%-- ${member.name } --%>강채윤</b>님 안녕하세요!
	</div>
	<div class="pageMenu">
		<div class="subMenu">
			<a href="${contextPath}/complaintpost/addComplaintPost.do">
				<img src="${contextPath}/resources/image/complaintIcon.png" height="40px">
				<br>
				문의
			</a>
		</div>
		<div class="subMenu">
			<a href="${contextPath}/member/modifyMember.do">
				<img src="${contextPath}/resources/image/modifiyIcon.png" height="40px">
				<br>
				내 정보 수정
			</a>
		</div>
		<div class="subMenu">
			<a href="${contextPath}/member/logout.do">
				<img src="${contextPath}/resources/image/logoutIcon.png" height="40px">
				<br>
				로그아웃
			</a>
		</div>
	</div>
</div>
</body>
</html>