<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>math_test.jsp</title>
</head>
<body>
<h4>가위바위보 게임</h4>
<script type="text/javascript">
	var game = prompt("가위, 바위, 보 선택","가위");
	var gameNum;
	var str;
	var str2;
	switch(game){
	case "가위":
		gameNum=1;
		str="가위"
		break;
	case "바위":
		gameNum=2;
		str="바위";
		break;
	case "보":
		gameNum=3;
		str="보";
		break;
		default: alert("잘못 작성했습니다.");
		location.reload();//F5(새로고침)
	}
	var com = Math.ceil(Math.random()*3);//1~3
		switch(com){
	case 1:		
		str2="가위"
		break;
	case 2:
		str2="바위";
		break;		
	case 3:
		str2="보";
		break;		
	default: alert("잘못 작성했습니다.");
		location.reload();//F5(새로고침)
	}
	
	//gamenum, com 비교해서 결과 출력
	if(gameNum==com){
		document.write("비겼습니다.<br>");
		document.write("유저 값 : "+str+" 컴퓨터 값: "+str2);
	} else if((gameNum==1&&com==3)||(gameNum==2&&com==1)||(gameNum==3&&com==2) ){
		document.write("유저가 이겼습니다.<br>");
		document.write("유저 값 : "+str+" 컴퓨터 값: "+str2);
	} else if((com==1&&gameNum==3)||(com==2&&gameNum==1)||(com==3&&gameNum==2)){
		document.write("컴퓨터가 이겼습니다.<br>");
		document.write("유저 값 : "+str+" 컴퓨터 값: "+str2);
	}

</script>
</body>
</html>