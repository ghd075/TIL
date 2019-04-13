<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head><title>timer_imageSliser.jsp</title>
<script>
//�̹��� �迭 ����
var arrImage =  ["images/logo.gif",     "images/pic1.jpg",
                 "images/pic2.jpg",     "images/pic3.jpg"]; 
                 
var pos = 0 ; // �̹��� ��ġ �ε���
var timer; //Ÿ�̸� ���� ����

function init(){
	document.getElementById("slider").src= "./"+arrImage[0];
	//Ÿ�̸� ����(500=0.5�� ����)
	timer = setInterval(to_Right, 500);
}
function to_Right() {
	//�ε��� ����
	pos++;
	//pos üũ(�̹����� ����ִ� �ε��� ��ġ�� �̹��� �迭ũ�⺸�� ũ�� 0���� �ʱ�ȭ)
	if(pos > (arrImage.length-1)){
		pos = 0;
	}	
	//�̹��� ����
	document.getElementById("slider").src= "./"+arrImage[pos];
}

function to_Left() {
	//pos ����
	pos--;
	//pos üũ(�̹����� ����ִ� �ε��� ��ġ�� 0���� ������ �̹��� �迭 ũ��� �ʱ�ȭ)
	if(pos < 0){
		pos = arrImage.length-1;
	}
	//�̹��� ����
	document.getElementById("slider").src= "./"+arrImage[pos];
}
function moveStop() {
	clearInterval(timer); //Ÿ�̸� ����
}
</script>
</head>
<body onload="init();">
<!-- imageSlider.jsp -->
�̹��� �����̴� <hr>
<img id="slider" src="" 
    style="width: 200px;height: 200px; position: relative; left: 100px;"><br>
<input type="button" value="��" onclick="to_Left()"/> 
<input type="button" value="��" onclick="to_Right()"/>
<input type="button" value="����" onclick="moveStop()"/>
</body>
</html>