<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="items" type="java.util.HashMap"%>
<%@ attribute name="name" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="${name}">
	<c:forEach items="${items}" var="item">
		<option value="${item.key}">${item.value}
	</c:forEach>
</select>