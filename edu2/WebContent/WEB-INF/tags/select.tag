<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag dynamic-attributes="option" %>
<%@ attribute name="location" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="${location}">
	<c:forEach items="${option}" var="item">
		<option value="${item.key}">${item.value}
	</c:forEach>
</select>