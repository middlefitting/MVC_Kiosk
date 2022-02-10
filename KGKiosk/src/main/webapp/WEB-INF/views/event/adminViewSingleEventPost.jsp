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
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/eventFormStyle.css">
</head>
<body>
<div class="header"><h2>이벤트 수정 및 삭제</h2></div>
<div class="formDiv">
	<form name="frmEvent" method="post"  action="${contextPath}/eventpost/modifyEventPost.do">
		<input type="hidden" name="eventKey" id="eventKey" value="${eventPostVO.eventKey}">
		<div class="inputBox">
			<input type="text" name="eventTitle" id="eventTitle" value="${eventPostVO.eventTitle }" size="50"placeholder="이벤트 제목">
			<label for="eventTitle">이벤트 제목</label>
		</div>
		<div class="inputBox">
			<textarea rows="3" cols="50" name="eventBody" id="eventBody"placeholder="이벤트 내용">${eventPostVO.eventBody }</textarea>
			<label for="eventBody">이벤트 내용</label>
		</div>
		<div class="inputBox">
			<input type="text" name="eventImgSrc" id="eventImgSrc" value="${eventPostVO.eventImgSrc }" size="20"placeholder="이미지">
			<label for="eventImgSrc">이미지</label>
		</div>
		<div class="button">
			<input type="submit" value="수정" > 
			<input type="button" value="삭제" onclick="location.href='${contextPath}/eventpost/removeEventPost.do?eventKey=${eventPostVO.eventKey}'">
		</div>
		
	</form>
</div>
</body>
</html>