<%@page import="net.sf.json.JSONArray"%>
<%@page import="emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="emp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//ajax요청을 처리할 서버 프로그램
//페이징처리
int p = Integer.parseInt(request.getParameter("p"));
int start = (p-1)*5+1;
int end = start+5-1;
List<EmpDTO> list = EmpDAO.getInstance().selectPage(start, end);
/* out.print("[");
for(int i=0; i < list.size(); i++){
	EmpDTO emp = list.get(i);
	out.print("{");
	out.print("\"first_name\":\""
			  +emp.getFirst_name() +"\",\"last_name\":\""
			  +emp.getLast_name()+"\"}");
	if(i<list.size()-1){
		out.print(",");
	}
} 
out.print("]") ; */
%>
<%=JSONArray.fromObject(list)%>