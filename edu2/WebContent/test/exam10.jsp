<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setLocale value="en" />
<fmt:bundle basename="com.edu.bundle.msg">
<h4><fmt:message key="titleMember"/></h4>
<form>
	<fmt:message key="id" /><input type="text" name="userid"><br>
	<fmt:message key="pw" /><input type="text" name=userpw><br>
	<button><fmt:message key="btnInsert" /></button>
</form>
	
</fmt:bundle>

