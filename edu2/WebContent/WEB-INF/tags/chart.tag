<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" %>
<%@ attribute name="color" %>
<%@ attribute name="w" %>
<table border="1" width="${w}">
	<tr><th>${title}</th></tr>
	<tr><td bgcolor="${color}"><jsp:doBody /></td></tr>
</table>
