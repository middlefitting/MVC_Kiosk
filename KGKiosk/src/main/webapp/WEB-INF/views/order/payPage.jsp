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
<table align="center" border="1"  width="80%"  >
  <tr height="10" align="center"  bgcolor="lightgreen">
     <td> 번호</td>
     <td >메뉴명</td>
     <td >이미지</td>             
     <td >가격</td>
     <td >수량</td>
     <td >삭제</td>
  </tr>
<c:choose>
  <c:when test="${CartLists ==null }" >
    <tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">담긴 상품이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
 
  </c:when>
  <c:when test="${CartLists !=null }" >
    <c:forEach  var="article" items="${CartLists}" varStatus="articleNum" >
     <tr align="center">
	<td width="5%">${articleNum.count}</td>
	
	<td width="15%">${article.foodName}</td>
	
	<td  width="10%">${article.foodImg}</td>
	
	<td  width="10%">${article.foodPrice}</td>
	
	<td  width="10%">${article.foodCount}</td>
	
	<td width="10%">
	    <form name="foodId" method="get"  action="${contextPath}/order/delteCart.do">
			<input type="hidden" name="cartId" id= "cartId" value="${article.cartId}">			
			<input type="submit" value="삭제" class="submenuLink"> 
		</form>
 	</td>
	</tr>
    </c:forEach>
     </c:when>
    </c:choose>
</table>
	    <form name="foodId" method="get"  action="${contextPath}/order/payPage.do">
			<input type="hidden" name="orderPrice" id= "orderPrice" value="${orderPrice}">			
			<input type="hidden" name="orderType" id= orderType value="${orderType}">
			<input type="hidden" name="foodName" id= foodName value="${foodName}">
			<input type="submit" value="정말 결제하기" class="submenuLink"> 
		</form>

</body>
</html>