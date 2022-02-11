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
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/eventFormStyle.css">

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
<div class="header"><h2>이벤트 추가</h2></div>
<div class="formDiv">
	<form name="frmEvent" method="post"  action="${contextPath}/eventpost/addEventPost.do">
		<div class="inputBox">
			<input type="text" name="eventTitle" id="eventTitle" value="" size="50"placeholder="이벤트 제목">
			<label for="eventTitle">이벤트 제목</label>
		</div>
		<div class="inputBox">
			<textarea rows="3" cols="50" name="eventBody" id="eventBody"placeholder="이벤트 내용"></textarea>
			<label for="eventBody">이벤트 내용</label>
		</div>

		<!-- <div class="inputBox">
			<input type="text" name="eventImgSrc" id="eventImgSrc" value="" size="20"placeholder="이미지">
			<label for="eventImgSrc">이미지</label>
		</div> -->
	
		<div class="inputBox">
			<input type="file" name="eventImgSrc"  id="eventImgSrc" onchange="readURL(this);" />
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
</body>
</html>