<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//1. JNDI 서버 역할을 하는 객체 생성
	// 리소스가 로컬에 있을 때는 단순히 InitialContext 객체만 생성
	Context initContext = new InitialContext();
	//2. 리소스를 찾은 후 리소스를 사용할 수 있도록 객체를 반환
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
	//3. getConnection() 데이터 원본과의 연결을 설정
	Connection conn = ds.getConnection(); //커넥션풀에서 담당
	//Statement stmt = conn.createStatement();
	//from -> where -> select -> orderby 순으로 실행된다.
	//테이블들을 기본적으로
/* 	String sql ="select * from employees where department_id='" + dept + "'"
				+ " order by employee_id"; */
	String sql = "select * from  employees where department_id=? order by employee_id";
	PreparedStatement psmt = conn.prepareStatement(sql);
	String dept = request.getParameter("deptno");
	psmt.setString(1, dept);
	ResultSet rs = psmt.executeQuery();
	//ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){
		out.print(rs.getString("employee_id") + " : " + 
				  rs.getString("first_name") + "<br>");
	}
	conn.close(); //풀에 반납
	%>
</body>
</html>