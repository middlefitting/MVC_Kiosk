<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/menuPageStyle.css">
<c:choose>	
	<c:when test="${errorType=='alreadyCart'}">
		<script>
			window.onload=function(){
			  alert("이미 담긴 상품입니다.");
			}
			${errorType=''}
		</script>
	</c:when>
	<c:when test="${errorType=='successCart'}">
		<script>
			window.onload=function(){
			  alert("상품을 성공적으로 담았습니다.");
			}
			${errorType=''}
		</script>
	</c:when>
</c:choose>

</head>
<body>
<h1>메뉴</h1>
<!-- 메뉴 헤더 -->
<div id="topMenu" >
   	<ul> 
   		<li class="topMenuLi"> <a class="menuLink" href="${contextPath}/menu/pizzaMenuPage.do">피자</a> </li>
   		<li class="topMenuLi"> <a class="menuLink" href="${contextPath}/menu/sideMenuPage.do">사이드</a> </li> 
   		<li class="topMenuLi"> <a class="menuLink" href="${contextPath}/menu/beverageMenuPage.do">음료&기타</a> </li>
   	</ul>
</div>

<br>
<hr>
<br>

<div class="menuList"> <!-- wrap_menuList -->
	<ul class="clear">
		<!-- 메뉴가 없을 경우 -->
		<c:choose>
			<c:when test="${FoodLists == null }">
				<p align="center"><b><span style="font-size:9pt;">등록된 메뉴가 없습니다.</span></b>
			</c:when>
		</c:choose>
		<!-- 메뉴가 있을 경우 -->
		<c:choose>
			<c:when test="${FoodLists != null }">
				<c:forEach  var="foodVO" items="${FoodLists}">
				<li>
					<div class="thumbImg">
						<div class="prodImg">
							<a href="${contextPath}/menu/${foodVO.foodKey}SingleMenu.do?foodKey=${foodVO.foodKey}" style="cursor: pointer;">
								<div class="img" style="background-image: url('${contextPath}/resources/image/pizzaTest.png');"></div>
								<%-- <div class="img" style="background-image: url('${foodVO.foodImg}');"></div> --%>
							</a>
						</div>
					</div>
					<div class="price">
						<div class="inner">
							<div class="prodName">
								<a href="${contextPath}/menu/${foodVO.foodKey}SingleMenu.do?foodKey=${foodVO.foodKey}" style="cursor: pointer;">${foodVO.foodName}</a>
							</div>
							<div class="prodPrice">
								<span class="price">${foodVO.foodPrice}원</span>
							</div>
						</div>
					</div>
				</li>
				</c:forEach>
			</c:when>
		</c:choose>
	</ul>
</div>

<%-- <table align="center" border="1"  width="80%"  >
  <tr height="10" align="center"  bgcolor="lightgreen">
     <td> 번호</td>
     <td >메뉴명</td>
     <td >이미지</td>             
     <td >설명</td>
     <td >가격</td>
  </tr>
<c:choose>
  <c:when test="${FoodLists ==null }" >
    <tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 메뉴가 없습니다.</span></b>
        </p>
      </td>  
    </tr>
 
  </c:when>
  <c:when test="${FoodLists !=null }" >
    <c:forEach  var="article" items="${FoodLists}" varStatus="articleNum" >
     <tr align="center">
	<td width="5%">${articleNum.count}</td>
	
	<td width="10%">
	    <form name="foodId" method="get"  action="${contextPath}/menu/${article.foodKey}SingleMenu.do">
			<input type="hidden" name="foodKey" id= "foodKey" value="${article.foodKey}">			
			<input type="submit" value="${article.foodName}" class="submenuLink"> 
		</form>
 	</td>
	
	<td  width="10%">
	    <form name="foodId" method="get"  action="${contextPath}/menu/${article.foodKey}SingleMenu.do">
			<input type="hidden" name="foodKey" id= "foodKey" value="${article.foodKey}">			
			<input type="submit" value="${article.foodImg}" class="submenuLink"> 
		</form>	
	</td>

	<td align='left'  width="35%">${article.foodInfo}</td>
	  <td  width="10%">${article.foodPrice}</td>
	</tr>
    </c:forEach>
     </c:when>
    </c:choose>
</table> --%>




<%-- <div id="menuList">
	<!-- db에서 해당 메뉴 뽑아옴 -->
	<ul class="clear">
		<li>
		
		</li>
		<% for(int i=0; i<ab.size(); i++) {%>
			<div class="thumb">
				<div class="pizza">
					<a style="cursor: pointer;">
						<div class="img" style="background-image: url(<%=이미지url%>);"></div>
					</a>
				</div>
			</div>
			<div class="con">
				<div class="inner">
					<div class="title">
						<a style="cursor: pointer;"><%=피자이름 %></a>
					</div>
					<div class="price">
						<div class="item">
							<span class="size">M</span>
							<span class="parice"><%=M사이즈가격 %></span>
						</div>
						<div class="item large">
							<span class="size">L</span>
							<span class="parice"><%=L사이즈가격 %></span>
						</div>
					</div>
				</div>
			</div>
		<%} %>
	</ul>
</div> --%>
</body>
</html>