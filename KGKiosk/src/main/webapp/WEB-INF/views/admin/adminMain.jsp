<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>관리자 메인 페이지</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mypageStyle.css">
</head>
<body>

   <h2>관리자 메인 페이지</h2>
   <div class="pageMenu">
		<div class="subMenu">
			<a href="${contextPath}/admin/complaint.do">
				문의내역
			</a>
		</div>
		<div class="subMenu">
			<a href="${contextPath}/eventpost/listAllEventPostList.do">
				이벤트관리
			</a>
		</div>
		<div class="subMenu">
			<a href="${contextPath}/member/logout.do">
				메뉴관리
			</a>
		</div>
		<div class="subMenu">
			<a href="${contextPath}/member/logout.do">
				쿠폰관리
			</a>
		</div>
	</div>
</body>
</html>