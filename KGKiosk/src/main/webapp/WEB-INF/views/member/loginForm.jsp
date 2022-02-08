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
<title>로그인창</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/loginFormStyle.css">
<c:choose>
	<c:when test="${result=='loginFailed' }">
	  <script>
	    window.onload=function(){
	      alert("아이디나 비밀번호가 틀립니다.다시 로그인 하세요");
	    }
	  </script>
	</c:when>
</c:choose>  
</head>

<body>
<div class="header"><h2>로그인</h2></div>
<div class="formDiv">
	<form name="frmLogin" method="post"  action="${contextPath}/member/login.do">
		<div class="inputBox">
			<input type="text" name="id" id="id" value="" size="20" placeholder="아이디">
			<label for="id">아이디</label>
		</div>
		<div class="inputBox">
			<input type="password" name="pwd" id="pwd" value="" size="20"placeholder="비밀번호">
			<label for="id">비밀번호</label>
		</div>
		<div class="button">
			<input type="submit" value="로그인" > 
			<input type="button" value="회원가입" onclick="location.href='${contextPath}/member/join.do'"> 
		</div>
	</form>
</div>
</body>
</html>
