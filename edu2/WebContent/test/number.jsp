<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>number.jsp</title>
</head>
<body>
<c:set var="salary" value="-120000000.678"/>
기본 출력 : ${salary}<br>
콤마 포함해서 출력 : <fmt:formatNumber value="${salary}" /><br>
콤마 출력하지 않고 출력 : <fmt:formatNumber value="${salary}" groupingUsed="false" /><br>
통화기호 붙여서 출력 : <fmt:formatNumber value="${salary}" type="currency" currencySymbol="$" /><br>
소수점 자리 수 출력 : <fmt:formatNumber value="${salary}" minFractionDigits="2" maxFractionDigits="2" /><br>
패턴 사용해서 출력(음수 값 확인) : <fmt:formatNumber value="${salary}" pattern="000,000.0;(000,000.0)" />

<hr>
<c:set var="today" value="2019/03/20 4:30:13"></c:set>
<fmt:parseDate var="today" value="${today}" pattern="yyyy/MM/dd hh:mm"/>
<fmt:formatDate value="${today}"/><br>
<fmt:formatDate value="${today}" type="both"/><br>
<fmt:formatDate value="${today}" pattern="yyyy/MM/dd hh:mm"/>
</body>
</html>