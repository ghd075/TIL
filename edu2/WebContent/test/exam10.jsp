<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setLocale value="en" />
<fmt:setBundle basename="com.edu.bundle.msg" />
<fmt:message key="greeting">
	<fmt:param>${param.userid}</fmt:param> <%-- 해당.properties 파일의 원하는 key 값을 {0}요소로 지정하여 param값을 지정할 수 있다.  --%>
</fmt:message>
<h4><fmt:message key="titleMember"/></h4>
<form>
	<fmt:message key="id" /><input type="text" name="userid"><br>
	<fmt:message key="pw" /><input type="text" name=userpw><br>
	<button><fmt:message key="btnInsert" /></button>
</form>


