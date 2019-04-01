<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chartBasic.jsp</title>
<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	// Load the Visualization API and the corechart package.
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {

		// 데이터 테이블 생성
		var data = new google.visualization.DataTable();
		data.addColumn('string', '부서');
		data.addColumn('number', '과장');
		data.addColumn('number', '사원');
		data.addRows([ 
			[ '총무', 2, 10 ], [ '인사', 5, 20 ], [ '개발', 10, 30 ]
		]);

		// 차트 환경 설정
		var options = {
			'title' : '부서별 사원수',
			'width' : 800,
			'height' : 500,
			colors: ['black', 'blue' ]
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.BarChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
<div id="chart_div"></div>
</body>
</html>