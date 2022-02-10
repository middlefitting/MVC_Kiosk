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
<style>
#menu .wrap_menuList > ul > li {
  display: inline-block;
  width: 310px;
  min-height: 480px;
  margin-right: 35px;
  margin-bottom: 60px;
  border-radius: 16px;
  background: #fff;
  padding-top: 15px;
  vertical-align: top;
}

#menu .wrap_menuList > ul > li:nth-child(4n) {
  margin-right: 0;
}

#menu .wrap_menuList > ul > li:hover {
  -webkit-box-shadow: 0 8px 25px 0 rgba(0, 0, 0, 0.1);
          box-shadow: 0 8px 25px 0 rgba(0, 0, 0, 0.1);
}

#menu .wrap_menuList > ul > li .thumb {
  width: 250px;
  height: 250px;
  margin: 0 auto;
  position: relative;
}

#menu .wrap_menuList > ul > li .thumb .pizza {
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0px;
  top: 0px;
  z-index: 2;
}

#menu .wrap_menuList > ul > li .thumb .pizza .img {
  width: 100%;
  height: 100%;
  background-repeat: no-repeat;
  background-size: 250px auto;
  background-position: center;
}

</style>
</head>
<body>
<h2>메뉴</h2>
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

<table align="center" border="1"  width="80%"  >
  <tr height="10" align="center"  bgcolor="lightgreen">
     <td >메뉴명</td>
     <td >이미지</td>             
     <td >설명</td>
     <td >가격</td>
     <td> 장바구니</td>
  </tr>
<c:choose>
  <c:when test="${foodVO ==null }" >
    <tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 메뉴가 없습니다.</span></b>
        </p>
      </td>  
    </tr>
 
  </c:when>
  <c:when test="${foodVO !=null }" >
    <tr align="center">
	
	<td width="10%">${foodVO.foodName}</td>
	<td  width="10%">${foodVO.foodImg}</td>
	<td align='left'  width="35%">${foodVO.foodInfo}</td>
	<td  width="10%">${foodVO.foodPrice}</td>
	

	
	
 	<td width="10%">
	    <form name="foodId" method="GET"  action="${contextPath}/cart/addCart.do">   
 			<input type="hidden" name="foodKey" id= "foodKey" value="${foodVO.foodKey}">	
			<input type="hidden" name="foodName" id= "foodName" value="${foodVO.foodName}">
			<input type="hidden" name="foodImg" id= "foodImg" value="${foodVO.foodImg}">
			<input type="hidden" name="foodPrice" id= "foodPrice" value="${foodVO.foodPrice}">
		<div class="inputBox">
			<input type="text" name="foodCount" id="foodCount" value="" size="20" placeholder="foodCount">
			<label for="foodCount">수량</label>
		</div>
			<input type="submit" value="장바구니 추가" class="submenuLink"> 
		</form>		
	</td>
	</tr>
     </c:when>
    </c:choose>
</table>

</body>
</html>