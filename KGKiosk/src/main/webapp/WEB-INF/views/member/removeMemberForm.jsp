<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/memberFormStyle.css">
</head>
<body>
<div class="header">
	<h2>${member.name } 님</h2> 
	<h4>정말 탈퇴하시겠습니까?</h4>

</div>
<form name="frmAddMember" method="post"  action="${contextPath}/member/removeMember.do">
	<input type="hidden" name="id" id="id" value="${member.id }">
	<input type="submit" value="탈퇴합니다" >
</form>


</body>
</html>