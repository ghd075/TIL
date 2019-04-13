<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>applyExmple.jsp</title>
<script>
function class1(){
    this.name = 'class1';
    this.getName = function(){
        alert(this.name);
    }
}
function class2(){
    this.name = 'class2';
    this.getName = function(){
        alert(this.name);
    }
}
var c1 = new class1();
var c2 = new class2();
c1.getName();
c1.getName.apply(c2);
</script>
</head>
<body>

</body>
</html>