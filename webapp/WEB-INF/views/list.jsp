<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>리스트</h2>
	<p>입력한 정보 내용입니다.</p>

	<c:forEach items="${requestScope.pList}" var="personVo">
		<table border="1">
			<tr>
				<td>이름(name)</td>
				<td>${personVo.name}</td>
			</tr>
			<tr>
				<td>휴대폰(hp)</td>
				<td>${personVo.hp}</td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td>${personVo.company}</td>
			</tr>
			<tr>
				<td><a href ="/phonebook4/updateForm/${personVo.personId}">[수정폼]</a>
					<a href ="/phonebook4/updateForm2/${personVo.personId}">[수정폼2]</a></td>
				<td><a href="/phonebook4/delete/${personVo.personId},${personVo.name}">[삭제]</a></td>
			</tr>
		</table>
		<br>
	</c:forEach>
	
	<br>
	
	<a href = "/phonebook4/writeForm">등록</a>
</body>
</html>