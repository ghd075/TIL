<%@tag import="java.util.Calendar"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%
	Calendar data = Calendar.getInstance();
%>
<%=data.get(Calendar.YEAR) %> -
<%=data.get(Calendar.MONTH)+1 %> -
<%=data.get(Calendar.DATE) %> 

