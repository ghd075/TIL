<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>math_test.jsp</title>
</head>
<body>
<h4>���������� ����</h4>
<script type="text/javascript">
	var game = prompt("����, ����, �� ����","����");
	var gameNum;
	var str;
	var str2;
	switch(game){
	case "����":
		gameNum=1;
		str="����"
		break;
	case "����":
		gameNum=2;
		str="����";
		break;
	case "��":
		gameNum=3;
		str="��";
		break;
		default: alert("�߸� �ۼ��߽��ϴ�.");
		location.reload();//F5(���ΰ�ħ)
	}
	var com = Math.ceil(Math.random()*3);//1~3
		switch(com){
	case 1:		
		str2="����"
		break;
	case 2:
		str2="����";
		break;		
	case 3:
		str2="��";
		break;		
	default: alert("�߸� �ۼ��߽��ϴ�.");
		location.reload();//F5(���ΰ�ħ)
	}
	
	//gamenum, com ���ؼ� ��� ���
	if(gameNum==com){
		document.write("�����ϴ�.<br>");
		document.write("���� �� : "+str+" ��ǻ�� ��: "+str2);
	} else if((gameNum==1&&com==3)||(gameNum==2&&com==1)||(gameNum==3&&com==2) ){
		document.write("������ �̰���ϴ�.<br>");
		document.write("���� �� : "+str+" ��ǻ�� ��: "+str2);
	} else if((com==1&&gameNum==3)||(com==2&&gameNum==1)||(com==3&&gameNum==2)){
		document.write("��ǻ�Ͱ� �̰���ϴ�.<br>");
		document.write("���� �� : "+str+" ��ǻ�� ��: "+str2);
	}

</script>
</body>
</html>