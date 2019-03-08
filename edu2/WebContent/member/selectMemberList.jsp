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
<h4>부서목록</h4>
<a href="insertMember.jsp">부서등록</a>
<table>
	<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>직업</td><td>취미</td><td>자기소개</td><td>성별</td><td>가입일자</td></tr>
<%
	List<MemberDTO> list = MemberDAO.getInstance().selectAll();
	for(int i = 0; i<list.size(); i++){
		MemberDTO beans = list.get(i);
%>
	<tr>
		<td>
		<a href="updateDept.jsp?userid=<%=beans.getUserid()%>"><%=beans.getUserid()%>
		</a></td>
		<td><%=beans.getUserid() %></td>
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