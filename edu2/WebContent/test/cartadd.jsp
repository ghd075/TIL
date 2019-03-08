<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//cartadd.jsp
	//application에 장바구니 담기
	List<String> cartlist;
	if(application.getAttribute("cart")==null){
		cartlist=new ArrayList<String>();		
	} else{
		cartlist=(List<String>)application.getAttribute("cart");
	}
	String goodno = request.getParameter("goodno");
	cartlist.add(goodno);//장바구니에 담고
	application.setAttribute("cart", cartlist);
	response.sendRedirect("goodlist.jsp");
%>