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
<title>문의내역</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/adminComplaintSubMenuStyle.css">
</head>
<body>
<h1>문의 내역</h1>
<hr>
<!-- 헤더 메뉴 -->
<!-- <table border=0  width="100%">
	<tr>
     <td id="subMenu">
     	<ul>
     		<li class="subMenuLi"><a class="menuLink" href="">문의</a></li>
     		<li class="subMenuLi"><a class="menuLink check" href="">불만</a></li>
     		<li class="subMenuLi"><a class="menuLink" href="">배송지연</a></li>
     		<li class="subMenuLi"><a class="menuLink" href="">기타</a></li>
     	</ul>
     </td>
  </tr>
</table>
<hr> -->
<!-- 리스트 -->
<%-- <div class="compList">
	<c:forEach var="complaintPostVO" items=${ComplaintPostLists }>
		<ul>
			<li>${complaintPostVO.complaintPostId }</li>
			<li>${complaintPostVO.complaintPostTitle }</li>
			<li>${complaintPostVO.complaintPostBody }</li>
			<li>${complaintPostVO.complaintWriteDate }</li>
		</ul>
	</c:forEach>
	
</div> --%>

</body>
</html>