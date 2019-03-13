<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" %>
<%@ attribute name="color" %>
<table border="1">
	<tr><th>${title}</th></tr>
	<tr><td bgcolor="${color}"><jsp:doBody /></td></tr>
</table>
