<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script>
        function addSubject(){
            var txt = document.getElementById("subjectName").value;
            var parent = document.getElementById("subject");
            //li태그 생성
            var newNode = document.createElement("li");
            //새로 생성된 li태그에다가 입력된 값으로 초기화
            newNode.innerHTML = txt;
            //이벤트 추가
            newNode.onclick = function() {
                newNode.style.color = "blue";
            }
            //선택한 요소 안에 자식 요소를 추가
            parent.appendChild(newNode);
            //텍스트필드 클리어
            document.getElementById("subjectName").value = " ";
        }
    </script>
</head>
<body>
    <input type="text" id="subjectName">
    <button type="button" onclick="addSubject()">추가</button>
    <ul id="subject">
        <li>java</li>
    </ul>
</body>
</html>