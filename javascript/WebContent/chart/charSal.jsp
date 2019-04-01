<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>charSal.jsp</title>
<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	// 구글 차트 API 관련 패키지를 가져온다.
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	// 구글 차트 불러올 때 불러온 콜백함수 지정
	google.charts.setOnLoadCallback(drawChart);
	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {
		// 데이터 테이블 생성
		var data = new google.visualization.DataTable();
		// 차트 환경 설정
		var options = {
			'title' : '부서별 평균급여', //차트제목
			'width' : 800, //가로px
			'height' : 500, //세로px
		};
		var chart = new google.visualization.ColumnChart(document
				.getElementById('chart_div')); //세로 막대 차트
		//ajax 호출
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            	//(타입, 이름)
        		data.addColumn('string', '부서명'); //첫번째 속성(속성타입, 항목)
        		data.addColumn('number', '급여'); //두번째 속성(속성타입, 항목 값)
        		data.addColumn('number', '부서별평균급여');
        		data.addColumn({type:'string', role:'annotation'});
        		//그래프 위에 주석 추가
        		data.addColumn({type:'string', role:'tooltip'});
        		//그래프 위에 풍선 도움말 내용을 바꿈
            	var list = JSON.parse(xhttp.responseText);
            	var arr = [];
            	for(i=0; i<list.length; i++){
            		arr.push([ 
            			list[i].department_name, 
            			list[i].salary,
            			list[i].avg,
            			list[i].department_id,
            			list[i].department_name + "\n급여: " + list[i].salary 
            			+"\n평균급여: " + list[i].avg,            			
            			]);
            		//받아오는 자료형와 타입이 일치해야 함
            	}
            	//console.log(arr);
            	data.addRows(arr);
            	chart.draw(data, options);
            }
        };
    	xhttp.open("GET", "../SelectDeptSalServ", true);
    	xhttp.send();		
	}
</script>
</head>
<body>
<div id="chart_div"></div>
</body>
</html>