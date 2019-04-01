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
			[ '총무', 2000, 10000 ], [ '인사', 5000, 20000 ], [ '개발', 10000, 30000 ]
		]);

		// 차트 환경 설정
		var options = {
			'title' : '부서별 사원수', //차트제목
			'width' : 800, //높이
			'height' : 500, //너비
			colors: ['yellow', 'blue' ], //색 지정
			is3D: true, //3d효과
			legend: 'none', //범레 끄기
	        bar: {groupWidth: '95%'}, //막대 그래프 크기
			vAxis: { gridlines: { count: 3 }, format: 'decimal', maxValue:100000 }, //세로막대 그리드라인 생성
			//count - 그리드라인 수 지정
			//hAxis: { gridlines: { count : 3 }, format: 'currency'} //가로막대 그리드라인 생성
			//format: 'currency' - 통화단위 붙여서 출력
			//format: 'decimal' - 소수점까지 출력
			//maxValue : 최댓값 지정
			 animation:{
				"startup": true, //애니메이션 동작 여부 지정
        		duration: 1000, //지속시간 지정
        		easing: 'out' //속도를 조작하여 특별한 애니메이션 효과를 나타나게 하는 함수
      		 }
		};

		// Instantiate and draw our chart, passing in some options.
		/* var chart = new google.visualization.PieChart(document
				.getElementById('chart_div')); //원형차트 */
		/* var chart = new google.visualization.BarChart(document
				.getElementById('chart_div')); //가로 막대 차트 */
		var chart = new google.visualization.ColumnChart(document
				.getElementById('chart_div')); //세로 막대 차트
		chart.draw(data, options);
		
	}
</script>
</head>
<body>
<div id="chart_div"></div>
</body>
</html>