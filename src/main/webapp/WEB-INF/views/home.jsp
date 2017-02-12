<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>컨트롤러 호출 연습페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<%
	// 컨텍스트 메서드 호출
	String path = request.getContextPath();
%>
<script>
	// json의 형식
	// {변수명: 값, 변수명: 값}
	// {name: "냉장고", price: 990000}
	function doF(){
		$.ajax({
			type: "post",
			url: "<%=path%>/sample/doF",
			success: function(result){
				console.log(result);
				$("#result").html("상품명 : "+result.productName+", 가격 : "+result.productPrice);
			}
		});
	}
	
</script>
<body>
	<h2>컨트롤러 호출 연습 페이지</h2>
	<a href="<%=path%>/sample/doA">doA</a> : model <br>
	<a href="<%=path%>/sample/doB">doB</a> : 단순호출<br>
	<a href="<%=path%>/sample/doC">doC</a> : modelAndView <br>
	<a href="<%=path%>/sample/doD">doD</a> : redirect <br>
	<!-- 1. doF()함수 호출 -->
	<a href="javascript:doF()">doF</a> : json<br>
	<!-- 2. 함수 호출 결과물 출력 -->
	<div id="result"></div>
</body>
</html>