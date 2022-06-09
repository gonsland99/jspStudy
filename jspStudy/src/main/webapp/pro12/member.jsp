<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
	import="pro12.sec02.ex01.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String _name = request.getParameter("name");
	MemberVO memberVO = new MemberVO();
	memberVO.setName(_name);
	MemberDAO dao = new MemberDAO();
	List list = dao.listMembers(memberVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 출력</title>
<style>
	h1{
		text-align: center;
	}
</style>
</head>
<body>
	<table border=1 width=800 align="center">
		<tr align="center" bgcolor="#ffff66">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<%
			for(int i=0; i<list.size(); i++){
				MemberVO vo = (MemberVO) list.get(i);
				String id = vo.getId();
				String pw = vo.getPw();
				String name = vo.getName();
				String email = vo.getEmail();
				Date joinDate = vo.getJoinDate();
		%>
			<tr>
				<td><%=id %></td>
				<td><%=pw %></td>
				<td><%=name %></td>
				<td><%=email %></td>
				<td><%=joinDate %></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>