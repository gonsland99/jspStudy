<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, pro14.sec02.ex01.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="m" class="pro14.sec02.ex01.MemberBean"/>
<jsp:setProperty name="m" property="*"/>
<%
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.addMember(m);
	List membersList = memberDAO.listMembers();
	request.setAttribute("membersList", membersList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action</title>
</head>
<body>
	<jsp:forward page="membersList.jsp"/>
</body>
</html>