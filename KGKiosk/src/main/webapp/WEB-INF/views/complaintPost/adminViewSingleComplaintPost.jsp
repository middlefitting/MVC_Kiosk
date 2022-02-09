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
	<form name="frmComplaint" method="post"  action="${contextPath}/admin/complaint.do">
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
		<div class="inputBox">
			<textarea rows="7" cols="50" name="complaintPostBody" id="complaintPostBody"placeholder="답변"></textarea>
			<!-- <input type="text" name="complaintPostBody" id="complaintPostBody" value="" size="20"placeholder="문의내용"> -->
			<label for="complaintPostBody">답변</label>
			<input type="hidden" name="complaintPostAnswer" id="complaintPostAnswer" value="1">
		</div>
		<div class="button">
			<input type="submit" value="답변완료" >
		</div>
		
	</form>
</div>
</body>
</html>