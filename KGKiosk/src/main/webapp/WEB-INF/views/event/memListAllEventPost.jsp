<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트</title>

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/memEventListStyle.css">

</head>
<body>

<body>
<h2>이벤트</h2>
<!-- 메뉴 헤더 -->
<div id="topMenu" >
   	<ul> 
   		<li class="topMenuLi"> <a class="menuLink" href="${contextPath}/eventpost/memListAllEventPostList.do">이벤트</a> </li>
   		<li class="topMenuLi"> <a class="menuLink" href="#">단체주문</a> </li> 
   	</ul>
</div>

<br>
<hr>
<br>

<div class="all">
<div class="eventList">
	<ul class="header">
		<li class="subRow id header">No</li>
		<li class="subRow title header">이벤트이름</li>
		<li class="subRow date header">등록일</li>
	</ul>
	<hr id="headerHr">
	<c:forEach var="eventPostVO" items="${EventPostLists }" varStatus="status">
		<ul class="row">
			<li class="subRow id">${status.count}</li>
			<li class="subRow title"><a href="${contextPath}/eventpost/memViewSingleEventPost.do?eventKey=${eventPostVO.eventKey }">${eventPostVO.eventTitle }</a></li>
			<li class="subRow date">${eventPostVO.eventWriteDate }</li>
		</ul>
	</c:forEach>
</div>
</div>

<br>
<hr>
<br>

</body>
</html>