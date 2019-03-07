<%@page import="com.edu.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 게시판수정 처리 페이지 --%>
<%
	//한글인코딩
	request.setCharacterEncoding("utf-8");
%>
 <jsp:useBean id="bean" class="com.edu.board.Board"/>
 <jsp:setProperty property="*" name="bean"/>
 <%
	BoardDao.getInstance().update(bean);
	response.sendRedirect("selectBoardList.jsp");
 %>  