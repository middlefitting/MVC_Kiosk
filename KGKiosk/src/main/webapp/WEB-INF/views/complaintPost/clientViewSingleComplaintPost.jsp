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
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/complaintFormStyle.css">
</head>
<body>
<div class="formDiv">
	<form name="frmComplaint" method="post"  action="${contextPath}/complaintpost/addComplaintPost.do">
		<div class="inputBox">
				<input type="text" name="complaintPostId" id="complaintPostId" value="${complaintPost.complaintPostId }" size="50" placeholder="아이디" readonly>
				<label for="complaintPostId">아이디</label>
			</div>
		<div class="inputBox">
			<input type="text" name="complaintPostTitle" id="complaintPostTitle" value="${complaintPostVO.complaintPostTitle}" size="50"placeholder="제목" readonly>
			<label for="complaintPostTitle">제목</label>
		</div>
		<div class="inputBox">
			<textarea rows="7" cols="50" name="complaintPostBody" id="complaintPostBody"placeholder="문의내용" readonly>${complaintPostVO.complaintPostBody}</textarea>
			<!-- <input type="text" name="complaintPostBody" id="complaintPostBody" value="" size="20"placeholder="문의내용"> -->
			<label for="complaintPostBody">문의내용</label>
		</div>
		<!-- 답변 칼럼 true면 보이게 처리하기 -->
		<div class="inputBox">
			<textarea rows="7" cols="50" name="complaintPostBody" id="complaintPostBody"placeholder="답변"></textarea>
			<!-- <input type="text" name="complaintPostBody" id="complaintPostBody" value="" size="20"placeholder="문의내용"> -->
			<label for="complaintPostBody">답변</label>
		</div>
		<div class="button">
			<input type="button" value="수정" onclick="location:href=''">
			<input type="button" value="수정" onclick="location:href=''">
		</div>
		
	</form>
</div>
</body>
</html>