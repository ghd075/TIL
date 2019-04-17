<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조기요</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css" />
<link rel="stylesheet" href="../css/cards-gallery.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<!-- 공지사항관련 자바스크립트 추가 -->
<!-- <script>
function pevent(){
    function getCookie(name){
        var nameOfCookie = name + "=";
        var x = 0;
        while (x <= document.cookie.length){
            var y = (x + nameOfCookie.length);
            if (document.cookie.substring(x, y) == nameOfCookie){
            if ((endOfCookie = document.cookie.indexOf(";", y)) == -1){
            endOfCookie = document.cookie.length;
            }
            return unescape (document.cookie.substring(y, endOfCookie));
            }
            x = document.cookie.indexOf (" ", x) + 1;
            if (x == 0) break;
        }
        return "";
    }
    if (getCookie("popname") != "done"){
        var popUrl = "../notice/notice3.jsp";
        var popOption = "width=400%, height=235%, resizable=no, scrollbars=no, status=no;";
        window.open(popUrl,"",popOption);
    }
}
</script> -->
<!-- 공지사항관련 자바스크립트 추가2() -->
<script src="../js/cookie.js"></script>
<script type="text/javascript">
function showPopup(){
	var popup1 = getCookie("popup1");
	if(popup1 != 'N'){
	window.open("../notice/notice1.html","a",
	"width=450, height=350, left=100, top=250");				
	}
}
function showPopup1(){
	var popup2 = getCookie("popup2")
	if(popup2 != 'N'){
	window.open("../notice/NoticeSelect.do","b",
	"width=450, height=350, left=570, top=250");
		
	}
}
</script>
</head>
<!-- <body onload="pevent();"> -->
<body onload="showPopup(); showPopup1();">
<%@include file="../main/header.jsp"%>
	<section class="gallery-block cards-gallery">
		<div class="container">
			<div class="row md-3">
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/menu.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">전체보기</a></h4>
	                	</div>
					</div>
				</div>
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/chicken.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">치킨</a></h4>
	                	</div>
					</div>
				</div>
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/pizza.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">피자/양식</a></h4>
	                	</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/JaJang.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">중식</a></h4>
	                	</div>
					</div>
				</div>
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/Kimchi.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">한식</a></h4>
	                	</div>
					</div>
				</div>
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/pork.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">일식/돈까스</a></h4>
	                	</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/feet.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">족발/보쌈</a></h4>
	                	</div>
					</div>
				</div>
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/bugger.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">패스트푸드</a></h4>
	                	</div>
					</div>
				</div>
				<div class="col-md-9 col-lg-4 m-b-10">
					<div class="card border-1 transform-on-hover">
						<a class="lightbox" href="#">
	                		<img src="../images/tteokbokki.jpg" alt="Card Image" class="card-img-top" width="270" height="236">
	                	</a>
	                	<div class="card-body">
	                		<h4><a href="#">분식</a></h4>
	                	</div>
					</div>
				</div>
			</div>
		</div>
	</section>
<%@include file="../main/footer.jsp"%>
</body>
</html>