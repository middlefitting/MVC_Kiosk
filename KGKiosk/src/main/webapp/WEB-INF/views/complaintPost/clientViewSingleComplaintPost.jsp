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
	<form name="frmComplaint" method="post"  action="${contextPath}/complaintpost/modifyComplaintPostClient.do">
		<div class="inputBox">
				<input type="text" name="complaintPostId" id="complaintPostId" value="${complaintPost.complaintPostId }" size="50" placeholder="아이디" readonly>
				<label for="complaintPostId">아이디</label>
			</div>
		<div class="inputBox">
			<input type="text" name="complaintPostTitle" id="complaintPostTitle" value="${complaintPost.complaintPostTitle}" size="50"placeholder="제목">
			<label for="complaintPostTitle">제목</label>
		</div>
		<div class="inputBox">
			<textarea rows="7" cols="50" name="complaintPostBody" id="complaintPostBody"placeholder="문의내용">${complaintPost.complaintPostBody}</textarea>
			<label for="complaintPostBody">문의내용</label>
		</div>
		<!-- 미답변일 때만 수정 삭제 가능 -->
		<c:if test="${complaintPost.complaintAnswer eq '0'}">
			<div class="button">
				<input type="hidden" name="complaintAnswer" id="complaintAnswer" value="0">
				<input type="hidden" name="complaintPostKey" id="complaintPostKey" value="${complaintPost.complaintPostKey}">
				<input type="submit" value="수정">
				<input type="button" value="삭제" onclick="location.href='${contextPath}/complaintpost/removeComplaintPost.do?complaintPostKey=${complaintPost.complaintPostKey }'">
			</div>
		</c:if>
	</form>
</div>
</body>
</html>