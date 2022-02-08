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
<div class="header"><h2>회원정보수정</h2></div>
<div class="formDiv">
	<form name="frmAddMember" method="post"  action="${contextPath}/member/modifyMember.do">
		<div class="inputBox">
				<input type="text" name="id" id="id" value="${member.id }" size="20" placeholder="아이디">
				<label for="id">아이디</label>
			</div>
		<div class="inputBox">
			<input type="password" name="pwd" id="pwd" value="${member.pwd }" size="20"placeholder="비밀번호">
			<label for="pwd">비밀번호</label>
		</div>
		<div class="inputBox">
			<input type="text" name="name" id="name" value="${member.name }" size="20"placeholder="이름">
			<label for="name">이름</label>
		</div>
		<div class="inputBox">
			<input type="text" name="email" id="email" value="${member.email }" size="20"placeholder="이메일">
			<label for="email">이메일</label>
		</div>
		<div class="inputBox">
			<input type="text" name="homeAddress" id="homeAddress" value="${member.homeAddress }" size="20"placeholder="주소">
			<label for="homeAddress">주소</label>
		</div>
		<div class="button">
			<input type="submit" value="수정하기" > 
		</div>
		
	</form>
</div>
</body>
</html>