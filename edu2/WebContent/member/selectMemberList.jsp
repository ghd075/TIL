<%@page import="java.util.List"%>
<%@page import="com.edu.member.MemberDAO"%>
<%@page import="com.edu.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../main/header.jsp"%>
<h4>회원목록 </h4>
<a href="insertMember.jsp">회원등록</a>
<table border="1">
	<tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>직업</th><th>취미</th><th>자기소개</th><th>성별</th><th>가입일자</th></tr>
<%
	List<MemberDTO> list = MemberDAO.getInstance().selectAll();
	for(int i = 0; i<list.size(); i++){
		MemberDTO beans = list.get(i);
%>
	<tr>
		<td>
		<a href="updateDept.jsp?userid=<%=beans.getUserid()%>"><%=beans.getUserid()%>
		</a></td>
		<td><%=beans.getUserpw() %></td>
		<td><%=beans.getUsername() %></td>
		<td><%=beans.getJob() %></td>
		<td><%=beans.getHobby() %></td>
		<td><%=beans.getInfo() %></td>
		<td><%=beans.getGender() %></td>
		<td><%=beans.getRegdate() %></td>
	</tr>
<%} %>
</table>
<%@include file="../main/footer.jsp"%>
</body>
</html>