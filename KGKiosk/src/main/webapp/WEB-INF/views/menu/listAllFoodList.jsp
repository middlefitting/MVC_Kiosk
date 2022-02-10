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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/foodListStyle.css">
</head>
<body>
<h1>제품 관리</h1>
<hr>
<div class="all">
<div class="compList">
	<ul class="header">
		<li class="subRow category header"><input type="button" value="메뉴추가" onclick="location.href='${contextPath}/food/addFoodForm.do'"></li>
		<li class="subRow name header">제품명</li>
		<li class="subRow price header">제품가격</li>
		<li class="subRow stock header">재고</li>
	</ul>
	<hr id="headerHr">
	<c:forEach var="foodVO" items="${FoodLists }">
		<ul class="row">
			<li class="subRow category">${foodVO.foodCategory }</li>
			<li class="subRow name"><a href="${contextPath}/food/adminViewSingleFood.do?foodKey=${foodVO.foodKey }">${foodVO.foodName }</a></li>
			<li class="subRow price">${foodVO.foodPrice }</li>
			<li class="subRow stock">${foodVO.foodStock }</li>
		</ul>
	</c:forEach>
</div>
</div>
</body>
</html>