<%@page import="com.myspring.kgkiosk.complaintpost.vo.ComplaintPostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  	request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의내역</title>
<%-- <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/adminComplaintSubMenuStyle.css"> --%>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/complaintListStyle.css">
</head>
<body>
<h1>문의 내역</h1>
<hr>
<!-- 헤더 메뉴 -->
<!-- <table border=0  width="100%">
	<tr>
     <td id="subMenu">
     	<ul>
     		<li class="subMenuLi"><a class="menuLink" href="">문의</a></li>
     		<li class="subMenuLi"><a class="menuLink check" href="">불만</a></li>
     		<li class="subMenuLi"><a class="menuLink" href="">배송지연</a></li>
     		<li class="subMenuLi"><a class="menuLink" href="">기타</a></li>
     	</ul>
     </td>
  </tr>
</table>
<hr> -->
<!-- 리스트 -->
<div class="compList">
	<ul class="header">
		<li class="subRow id header ">아이디</li>
		<li class="subRow title header">문의제목</li>
		<li class="subRow date header">문의시각</li>
		<li class="subRow answer header">답변여부</li>
	</ul>
	<hr id="headerHr">
	<c:forEach var="complaintPostVO" items="${ComplaintPostLists }">
		<ul class="row">
			<li class="subRow id">${complaintPostVO.complaintPostId }</li>
			<li class="subRow title"><a href="${contextPath}/complaintpost/adminViewSingleComplaintPost.do?complaintPostKey=${complaintPostVO.complaintPostKey }">${complaintPostVO.complaintPostTitle }</a></li>
			<li class="subRow date">${complaintPostVO.complaintWriteDate }</li>
			<c:set var="answer" value="${complaintPostVO.complaintAnswer}" />
			<c:choose>
				<c:when test="${answer eq '0'}">
					<li class="subRow answer yes">new!</li>
				</c:when>
				<c:when test="${answer eq '1'}">
					<li class="subRow answer yes">답변완료</li>
				</c:when>
			</c:choose>
		</ul>
	</c:forEach>
</div>


</body>
</html>