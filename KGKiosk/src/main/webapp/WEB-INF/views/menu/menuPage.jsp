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

/* #menu .wrap_menuList > ul > li.no_dc_con {
  min-height: 410px;
} */

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

/* #menu .wrap_menuList > ul > li .thumb .pizza .img .soldout {
  width: 226px;
  height: 226px;
  padding-top: 94px;
  background: rgba(0, 0, 0, 0.65);
  border-radius: 50%;
  position: absolute;
  left: 0px;
  right: 0;
  top: 0px;
  bottom: 0;
  margin: auto;
}

#menu .wrap_menuList > ul > li .thumb .pizza .img .soldout span {
  display: block;
  width: 155px;
  height: 40px;
  font-family: 'Noto Sans KR';
  font-weight: 800;
  font-size: 24px;
  color: #fff;
  line-height: 36px;
  text-align: center;
  border: 2px solid rgba(255, 255, 255, 0.8);
  border-radius: 10px;
  margin: 0 auto;
  -webkit-transform: rotate(-20deg);
      -ms-transform: rotate(-20deg);
          transform: rotate(-20deg);
}

#menu .wrap_menuList > ul > li .thumb .flag_category {
  margin: 10px 0 0 -6px;
}*/

#menu .wrap_menuList > ul > li .con {
  padding: 10px 30px 0 30px;
}

#menu .wrap_menuList > ul > li .con .inner {
  position: relative;
}

#menu .wrap_menuList > ul > li .con .inner .title {
  height: 64px;
  font-family: 'Noto Sans KR';
  font-weight: 600;
  font-size: 20px;
  line-height: 1.4;
  word-break: break-all;
}

#menu .wrap_menuList > ul > li .con .inner .wrap_price {
  margin-bottom: 15px;
}

#menu .wrap_menuList > ul > li .con .inner .wrap_price .item {
  margin-bottom: 10px;
}

/* #menu .wrap_menuList > ul > li .con .inner .wrap_price .item .dc_con {
  margin-bottom: 15px;
} */

#menu .wrap_menuList > ul > li .con .inner .wrap_price .item .size {
  display: inline-block;
  width: 30px;
  height: 30px;
  font-family: 'Noto Sans KR';
  font-weight: 800;
  font-size: 16px;
  color: #DE4B50;
  text-align: center;
  line-height: 30px;
  background: #f8e8e8;
  border-radius: 10px;
  vertical-align: middle;
  margin-bottom: 3px;
}

#menu .wrap_menuList > ul > li .con .inner .wrap_price .item .price {
  display: inline-block;
  width: 65px;
  font-family: 'Noto Sans KR';
  font-weight: 800;
  font-size: 18px;
  text-align: right;
}

/* #menu .wrap_menuList > ul > li .con .inner .wrap_price .item .dc {
  display: inline-block;
  width: 50px;
  font-family: 'Noto Sans KR';
  font-weight: 400;
  font-size: 14px;
  color: #bbb;
  text-align: right;
  text-decoration: line-through;
} 

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul > li {
  float: left;
  position: relative;
  padding-left: 20px;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul > li:before {
  content: '';
  display: block;
  width: 1px;
  height: 12px;
  background: #ddd;
  background-size: 6px auto;
  position: absolute;
  left: 9px;
  top: 8px;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul > li:first-child:before {
  display: none;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul > li span {
  display: inline-block;
  font-family: 'Noto Sans KR';
  font-weight: 800;
  font-size: 18px;
  letter-spacing: -0.5px;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul > li span.current {
  color: #DA1A32;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul > li span .ic_size {
  display: inline-block;
  width: 30px;
  height: 30px;
  font-family: 'Noto Sans KR';
  font-weight: 800;
  font-size: 16px;
  color: #DE4B50;
  text-align: center;
  line-height: 30px;
  background: #f8e8e8;
  border-radius: 10px;
  vertical-align: middle;
  margin: 0 0 5px 5px;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul > li:first-child {
  padding-left: 0;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul > li:first-child:after {
  display: none;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con > ul.on:first-child span:after {
  -webkit-transform: rotate(180deg);
      -ms-transform: rotate(180deg);
          transform: rotate(180deg);
  -webkit-transform-origin: 50% 50%;
      -ms-transform-origin: 50% 50%;
          transform-origin: 50% 50%;
  -webkit-transition: 0.5s;
  transition: 0.5s;
}

#menu .wrap_menuList > ul > li .con .inner .dc_con.no_arrow > ul > li:first-child span:after {
  display: none;
} */
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
</table>




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