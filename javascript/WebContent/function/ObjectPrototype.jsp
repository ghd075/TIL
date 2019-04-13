<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ObjectPrototype.jsp</title>
<script type="text/javascript">
	function Emp(id, name, sal) {
		this.empid = id;
		this.firstName = name;
		this.sal = sal;
	}
/* 	Emp.prototype.getEmpid = function(){}
	Emp.prototype.getFirstName = function(){}
	Emp.prototype.getSal = function(){} */
	Emp.prototype = {
			getEmpid : function(){ return this.empid; },
			getfirstName : function(){ return this.firstName; },
			getSal : function(){ return this.sal; }
	}
	
	var emp = new Emp(100, "홍길동", 2000);
	document.write(emp.getEmpid() + "<br>");
	document.write(emp.getSal() + "<br>");
</script>
</head>
<body>

</body>
</html>