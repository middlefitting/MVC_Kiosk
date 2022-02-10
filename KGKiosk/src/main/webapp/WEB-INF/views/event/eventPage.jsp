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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/eventListStyle.css">
</head>
<body>
<h1>이벤트 관리</h1>
<hr>
<div class="all">
<div class="eventList">
	<ul class="header">
		<li class="subRow id header"><input type="button" value="이벤트추가" onclick="location.href='${contextPath}/eventpost/addEventPostForm.do'"></li>
		<li class="subRow title header">이벤트이름</li>
		<li class="subRow date header">등록일</li>
	</ul>
	<hr id="headerHr">
	<c:forEach var="eventPostVO" items="${EventPostLists }" varStatus="status">
		<ul class="row">
			<li class="subRow id">${status.count}</li>
			<li class="subRow title"><a href="${contextPath}/eventpost/adminViewSingleEventPost.do?eventKey=${eventPostVO.eventKey }">${eventPostVO.eventTitle }</a></li>
			<li class="subRow date">${eventPostVO.eventWriteDate }</li>
		</ul>
	</c:forEach>
</div>
</div>
</body>
</html>