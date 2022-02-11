<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/foodFormStyle.css">
<script>

function readURL(input) {
   
   if (input.files && input.files[0]){
            
      var reader = new FileReader();
      
      reader.onload = function(e) {
         document.getElementById("preview").src = e.target.result;
      };
      reader.readAsDataURL(input.files[0]);
   } else {
      document.getElementById("preview").src = "";
   }
}

</script>

</head>
<body>
<div class="header"><h2>메뉴 추가</h2></div>
<div class="all">
<div class="formDiv">
	<form name="frmFood" method="post"  action="${contextPath}/food/addFood.do">
		<div class="radioBox">
			<label class="radio">
				<input type="radio" name="foodCategory" value="피자" checked="checked"><span>피자</span>
			</label>
			<label class="radio">
				<input type="radio" name="foodCategory" value="사이드"><span>사이드</span>
			</label>
			<label class="radio">
				<input type="radio" name="foodCategory" value="음료"><span>음료</span>
			</label>
		</div>
		
		<div class="inputBox">
			<input type="text" name="foodName" id="foodName" value="" size="40"placeholder="제품 이름">
			<label for="foodName">제품 이름</label>
		</div>
		<div class="inputBox">
			<input type="text" name="foodPrice" id="foodPrice" value="" size="40"placeholder="제품 가격">
			<label for="foodPrice">제품 가격</label>
		</div>
		<div class="inputBox">
			<input type="text" name="foodStock" id="foodStock" value="" size="40"placeholder="재고">
			<label for="foodStock">재고</label>
		</div>
		<div class="inputBox">
			<input type="text" name="foodInfo" id="foodInfo" value="" size="40"placeholder="제품 설명">
			<label for="foodInfo">제품 설명</label>
		</div>
		<div class="inputBox">
			<input type="file" name="foodImg"  id="foodImg" onchange="readURL(this);" />
			<label for="eventBody">이미지 추가</label>
			<div>
				<img id="preview" width="200">
			</div>
		</div>
		<div class="button">
			<input type="submit" value="등록" > 
		</div>
	</form>
</div>
</div>
</body>
</html>

