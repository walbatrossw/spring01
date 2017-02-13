<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<%@ include file="../include/member_header.jsp" %>
</head>
<body>
<%@ include file="../include/member_menu.jsp" %>
	<h2>회원 목록</h2>
	<input type="button" value="회원등록" onclick="location.href='${path}/member/write.do'">
	<table border="1" width="700px">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>회원가입일자</th>
		</tr>
		<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.userId}</td>
			<!-- 회원정보 상세조회를 위해 a태그 추가 -->
			<td><a href="${path}/member/view.do?userId=${row.userId}">${row.userName}</a></td>
			<td>${row.userEmail}</td>
			<td>${row.userRegdate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>