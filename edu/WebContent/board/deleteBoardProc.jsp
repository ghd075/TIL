<%@page import="com.edu.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="com.edu.board.Board"/>
<jsp:setProperty property="*" name="bean"/>
 <% //삭제처리페이지 : deleteBoardProc.jsp
	BoardDao.getInstance().delete(bean.getId());
	response.sendRedirect("selectBoardList.jsp");
 %>  