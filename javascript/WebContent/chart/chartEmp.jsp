<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chartEmp.jsp</title>
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
			'title' : '부서별 사원수', //차트제목
			'width' : 800, //높이
			'height' : 500, //너비
		};
		var chart = new google.visualization.ColumnChart(document
				.getElementById('chart_div')); //세로 막대 차트
		//ajax 호출
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            	data.addColumn('string', '부서'); //(타입, 이름)
        		data.addColumn('number', '사원수');
            	var list = JSON.parse(xhttp.responseText);
            	var arr = [];
            	for(i=0; i<list.length; i++){
            		arr.push([ list[i].department_name, parseInt(list[i].cnt) ]);
            		//받아오는 자료형와 타입이 일치해야 함
            	}
            	data.addRows(arr);
            	chart.draw(data, options);
            }
            
            data.addRows(arr);
            chart.draw(data, options); //차트 그리기
        };
    	xhttp.open("GET", "../SelectDeptEmpServ", true);
    	xhttp.send();		
	}
</script>
</head>
<body>
<div id="chart_div"></div>
</body>
</html>