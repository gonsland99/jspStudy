<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, pro17.sec01.ex02.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modMemberForm</title>
	<style>
	.cls1 {
		font-size: 40px;
		text-align: center;
	}
	.cls2{
		font-size: 20px;
		text-align: center;
	}
	</style>
</head>
<body>
	<p class="cls1">회원정보 수정</p>
	<form action="${contextPath}/member/modMember.do?id=${memInfo.id}"
		method="post">
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</td>
				<td width="400"><input type="text" name="id"
					value="${memInfo.id}" disabled></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</td>
				<td width="400"><input type="password" name="pw"
					value="${memInfo.pw}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</td>
				<td width="400"><input type="text" name="name"
					value="${memInfo.name}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</td>
				<td width="400"><input type="text" name="email"
					value="${memInfo.email}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">가입일</td>
				<td width="400"><input type="text" name="joinDate"
					value="${memInfo.joinDate }" disabled></td>
			</tr>
			<tr align="center">
				<td colspan="2" width="400"><input type="submit" value="수정하기">
				<input type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
	<a href="${contextPath}/member/memberForm.do"><p class="cls2">회원가입 하기</p></a>
</body>
</html>