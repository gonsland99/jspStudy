<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, pro14.sec01.ex01.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m1" class="pro14.sec01.ex01.MemberBean"/>
<jsp:setProperty name="m1" property="*"/>
<jsp:useBean id="list" class="java.util.ArrayList"/>
<jsp:useBean id="map" class="java.util.HashMap"/>
<%
	map.put("id", "park");
	map.put("pw", "321");
	map.put("name", "박지성");
	map.put("email", "park@test.com");

	MemberBean m2 = new MemberBean("son","123","손흥민","son@test.com");
	list.add(m1);
	list.add(m2);
	map.put("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력4</title>
</head>
<body>
	<table align="center">
		<tr align="center" bgcolor="99ccff">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		<tr align="center">
			<td>${map.id}</td>
			<td>${map.pw}</td>
			<td>${map.name}</td>
			<td>${map.email}</td>
		</tr>
		<tr align="center">
			<td>${map.list[0].id}</td>
			<td>${map.list[0].pw}</td>
			<td>${map.list[0].name}</td>
			<td>${map.list[0].email}</td>
		</tr>
		<tr align="center">
			<td>${map.list[1].id}</td>
			<td>${map.list[1].pw}</td>
			<td>${map.list[1].name}</td>
			<td>${map.list[1].email}</td>
		</tr>
	</table>
</body>
</html>