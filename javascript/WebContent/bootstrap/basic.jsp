<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>basic.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<style type="text/css">
	img { width: 200px; height: 200px; }
</style>
</head>
<body>
<h3>부트스트랩</h3>
<button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#login">로그인</button>
<div class="modal fade" id="login" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header"><h5 class="modal-title" id="exampleModalLabel">로그인</h5></div>
			<div class="modal-body">
				<input>
				<input>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">로그인</button>
			</div>
		</div>
	</div>	
</div>
<a href="#" class="btn btn-outline-primary">링크스타일</a>
<button type="button" class="btn btn-primary">
  프로필 <span class="badge badge-light">9</span>
  <span class="sr-only">읽지 않은 메시지</span>
</button>
<div class="container">
  <table class="table table-striped table-hover">
  <thead>
  	<tr>
  		<th>번호</th><th>이름</th>
  	</tr>
  </thead>
  <tbody>
  	<tr>
  		<td>1</td>
  		<td>홍길동</td>
  	</tr>
  	<tr>
  		<td>2</td>
  		<td>홍길동</td>
  	</tr>
  </tbody>
  </table>
  <img src="../images/bg-01.jpg" class="rounded float-left" alt="...">
  <img src="../images/sky.jpg" class="rounded float-right" alt="...">
  <div class="row">
    <div class="col-xl-4 col-md-12">
      세 칼럼 중 하나
    </div>
    <div class="col-xl-4 col-md-12">
      세 칼럼 중 하나
    </div>
    <div class="col-xl-4 col-md-12">
      세 칼럼 중 하나
    </div>
  </div>
</div>
</body>
</html>