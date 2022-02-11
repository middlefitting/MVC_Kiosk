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

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/singleMenuPageStyle.css">
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
<!-- 메뉴 설명 및 선택 -->
<form name="foodId" method="get" action="${contextPath}/cart/addCart.do">
<div class="wrap"> <!-- 가로 -->
	<div class="ele2"> <!-- 세로 -->
    	<!-- sticky 설명 및 사진 -->
    	<div class="foodName">${foodVO.foodName}</div>
    	<div class="foodInfo">${foodVO.foodInfo}</div>
    	<div class="foodImg">
    		<%-- <div class="prodImg"><div class="img" style="background-image: url('${contextPath}/resources/image/pizzaTest.png');"></div></div> --%>
    		<div class="prodImg"><div class="img" style="background-image: url('/filePath/food/${foodVO.foodImg}');"></div></div>
    		
    	<%-- <div class="foodImg" style="background-image: url('${foodVO.foodInfo}');"></div> --%>
    	</div>
  	</div>
 	<div class="ele1"> <!-- 세로 -->
 	<c:if test="${foodVO.foodCategory eq '피자'}">
    	<!-- relative 옵션 선택 -->
    	<div class="option size"> <!-- 가로 -->
    		<h3>사이즈 선택</h3>
    		<div class="radioBox">
				<label class="radio">
					<input type="radio" name="size" value="기본" checked="checked"><span>기본</span>
				</label>
				<label class="radio">
					<input type="radio" name="size" value="라지"><span>라지 (+5000원)</span>
				</label>
			</div>
    	</div>
    	<br><br>
    	<div class="option edge">
    		<h3>엣지 선택</h3>
    		<div class="radioBox">
				<label class="radio">
					<input type="radio" name="edge" value="기본" checked="checked"><span>기본</span>
				</label>
				<label class="radio">
					<input type="radio" name="edge" value="치즈크러스트"><span>치즈크러스트 (+2000원)</span>
				</label>
				<label class="radio">
					<input type="radio" name="edge" value="리치골드"><span>리치골드 (+1000원)</span>
				</label>
			</div>
    	</div>
    	<br><br>
    	<div class="option topping">
    		<h3>토핑 선택</h3>
    		<div class="radioBox">
				<label class="radio">
					<input type="radio" name="topping" value="치즈"><span>치즈 (+1000원)</span>
				</label>
				<label class="radio">
					<input type="radio" name="topping" value="소시지"><span>소시지 (+2000원)</span>
				</label>
				<label class="radio">
					<input type="radio" name="topping" value="통새우"><span>통새우 (+3000원)</span>
				</label>
				<label class="radio">
					<input type="radio" name="topping" value="베이컨"><span>베이컨 (+1500원)</span>
				</label>
			</div>
    	</div>
    </c:if>
    	<br><br>
    	<div class="inputBox">
    		<h3>수량 입력</h3>
    		<input type="text" name="foodCount" id="foodCount" value="1" size="20" placeholder="수량">
			<label for="foodCount">개</label>
    	</div>
    	<!-- 장바구니 넣기 버튼 -->
    	<input type="hidden" name="foodKey" id= "foodKey" value="${foodVO.foodKey}">
		<input type="hidden" name="foodName" id= "foodName" value="${foodVO.foodName}">
		<input type="hidden" name="foodImg" id= "foodImg" value="${foodVO.foodImg}">
		<input type="hidden" name="foodPrice" id= "foodPrice" value="${foodVO.foodPrice}">
    	<div class="btn">
			<input type="submit" value="장바구니 추가"> 
		</div>
  	</div>
</div>
</form>
	

<%-- <form name="foodId" method="GET"  action="${contextPath}/cart/addCart.do">   
	<input type="hidden" name="foodKey" id= "foodKey" value="${foodVO.foodKey}">
	
	<input type="hidden" name="foodName" id= "foodName" value="${foodVO.foodName}">
	<input type="hidden" name="foodImg" id= "foodImg" value="${foodVO.foodImg}">
	<input type="hidden" name="foodPrice" id= "foodPrice" value="${foodVO.foodPrice}">
	<input type="hidden" name="foodCount" id= "foodCount" value="${foodVO.foodCount}">
	
	
</form>	 --%>	


<%-- <table align="center" border="1"  width="80%"  >
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
</table> --%>

</body>
</html>