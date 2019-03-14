<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  height: 300px; /* only for demonstration, should be removed */
  background: #ccc;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #f1f1f1;
  height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>
<body>
<h2>CSS Layout Float</h2>
<header>
  <h2>Cities</h2>
</header>

<section>
  <nav>
    <ul>
     <li><a href="/dev/dept/insertDept.jsp">부서 정보 생성</a></li>
     <li><a href="memberInsert.jsp">회원 정보 생성</a></li>
	 <li><a href="memberSearch.jsp">회원 정보 검색</a></li>
	 <li><a href="memberUpdate.jsp">회원 정보 수정</a></li>
	 <li><a href="memberDelete.jsp">회원 정보 삭제</a></li>
	 <li><a href="memberList.do">모든 회원 정보 보기</a></li>
	 <li><a href="deptList.do">모든 부서 정보 보기</a></li>
    </ul>
  </nav>
  
  <article>
    <decorator:body/>
  </article>
</section>

<footer>
  <p>Footer</p>
</footer>

</body>
</html>