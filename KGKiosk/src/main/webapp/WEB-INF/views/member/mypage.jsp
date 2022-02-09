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
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/complaintListStyle.css">
</head>
<body>
<div class="myPage">
	<div class="header">
		<h1>마이페이지</h1>
		<b>${member.name }</b>님 안녕하세요!
	</div>
	<div class="pageMenu">
		<div class="subMenu">
			<a href="${contextPath}/complaintpost/addComplaintPostForm.do">
				<img src="${contextPath}/resources/image/complaintIcon.png" height="40px">
				<br>
				문의
			</a>
		</div>
		<div class="subMenu">
			<a href="${contextPath}/member/modifyMemberForm.do">
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
	<br>
	<div class="header">
		<h1>나의 문의</h1>
	</div>
	<div class="compList" style="width:800px; display: inline-block;">
		<ul class="header">
			<li class="subRow title header">문의제목</li>
			<li class="subRow date header">문의시각</li>
			<li class="subRow answer header">답변여부</li>
		</ul>
		<hr id="headerHr">
		<c:forEach var="complaintPostVO" items="${ComplaintPostLists }">
			<c:set var="memId" value="${complaintPostVO.complaintPostId}" />
			<c:if test="${memId eq member.id }">
				<ul class="row">
					<li class="subRow title"><a href="${contextPath}/complaintpost/clientViewSingleComplaintPost.do?complaintPostKey=${complaintPostVO.complaintPostKey }">${complaintPostVO.complaintPostTitle }</a></li>
					<li class="subRow date">${complaintPostVO.complaintWriteDate }</li>
					<c:set var="answer" value="${complaintPostVO.complaintAnswer}" />
					<c:choose>
						<c:when test="${answer eq '0'}">
							<li class="subRow answer no">미답변</li>
						</c:when>
						<c:when test="${answer eq '1'}">
							<li class="subRow answer yes">답변완료</li>
						</c:when>
					</c:choose>
				</ul>
			</c:if>
		</c:forEach>
	</div>
</div>
</body>
</html>