<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {
		drawChart1();
		drawChart2();
		drawChart3();
 
 	}

   	  function drawChart1(){
          // Create the data table.
          var data = new google.visualization.DataTable();
          // Set chart options
          var options = {'title':'업종별 등록현황',
                         'width':400,
                         'height':500,
                         //colors: ['purple', '#e6693e', '#ec8f6e', '#f3b49f', '#f6c7b6'],
                         colors: ['', 'yellow', 'green'],
                         is3D: true,                   
                         bar: {groupWidth: '70%'},
                         vAxis: { gridlines: { count: 10 }, format: 'decimal', maxValue:10},
                         animation:{
                         "startup": true,
                         duration: 500,
                         easing: 'out'
                      	  }
          			  };
          //data.addColumn('string', {role:"style"});
          // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.BarChart(document.getElementById('chart_div1'));
		var color = ["red","orange","green","blue"]

          //ajax 호출
        var xhttp = new XMLHttpRequest();
   	  	  xhttp.onreadystatechange = function() {
    	  if (this.readyState == 4 && this.status == 200) {
           
            data.addColumn('string','업종');
            data.addColumn('number','음식점수');
            data.addColumn({type:'string', role:'style'})
            var list = JSON.parse(xhttp.responseText);
      	  var arr = [];
      	  for(i=0; i<list.length;i++){
      		  arr.push([list[i].food_name,parseInt(list[i].cnt),color[i]]);
      	  }
      	  
            data.addRows(arr);
    		chart.draw(data, options);
            
     	  }
  	 };
   		 xhttp.open("GET","../notice/CntFood.do", true);
   	 	 xhttp.send();
   	 }
   	  
	   	function drawChart2(){
	        // Create the data table.
        var data = new google.visualization.DataTable();
        // Set chart options
        var options = {'title':'지역별 등록현황',
                       'width':400,
                       'height':500,
                       colors: ['blue', 'red', 'orange', 'green','purple'],
                       is3D: true,                   
                       bar: {groupWidth: '70%'},
                       vAxis: { gridlines: { count: 10 }, format: 'decimal', maxValue:10},
                       animation:{
                       "startup": true,
                       duration: 500,
                       easing: 'out'
                    	  }
        			  };
        //data.addColumn('string', {role:"style"});
        // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.PieChart(document.getElementById('chart_div2'));


        //ajax 호출
      var xhttp = new XMLHttpRequest();
 	  xhttp.onreadystatechange = function() {
  	  if (this.readyState == 4 && this.status == 200) {
         
          data.addColumn('string','지역');
          data.addColumn('number','업소 카운트');
          var list = JSON.parse(xhttp.responseText);
    	  var arr = [];
    	  for(i=0; i<list.length;i++){    		  
    		 
    		  
    		  console.log(list[i]);
    		  arr.push([list[i].loc_name,parseInt(list[i].cnt) ]);
    	  }
          data.addRows(arr);
  		  chart.draw(data, options);
          
   	  	}
	 };
 	 xhttp.open("GET","../notice/LocFood.do", true);
  	 xhttp.send();
 	  }
   	
   	function drawChart3(){
        // Create the data table.
        var data = new google.visualization.DataTable();
        // Set chart options
        var options = {'title':'음식점 순위',
                       'width':400,
                       'height':500,
                       colors: ['green', 'yellow', 'purple', 'green', 'blue'],
                       is3D: true,                   
                       bar: {groupWidth: '70%'},
                       vAxis: { gridlines: { count: 10 }, format: 'decimal', maxValue:10},
                       animation:{
                       "startup": true,
                       duration: 500,
                       easing: 'out'
                    	  }
        			  };
        //data.addColumn('string', {role:"style"});
        // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.LineChart(document.getElementById('chart_div3'));


        //ajax 호출
      var xhttp = new XMLHttpRequest();
 	  xhttp.onreadystatechange = function() {
  	  if (this.readyState == 4 && this.status == 200) {
         
          data.addColumn('string','업종');
          data.addColumn('number','조회수');
          var list = JSON.parse(xhttp.responseText);
    	  var arr = [];
    	  for(i=0; i<list.length;i++){
    		  arr.push([list[i].food_name,parseInt(list[i].cnt) ]);
    	  }
    	  
          data.addRows(arr);
  		  chart.draw(data, options);
          
   	  	}
	 };
 	 xhttp.open("GET","../notice/RankFood.do", true);
  	 xhttp.send();
 	  }
    </script>
    <style type="text/css">
    	.grid {
    		margin: 0 auto;
    		border:1px solid gold;
    		text-align: left;
    		display: inline-block;
    		width:30%;
    		font-size: 0;
    	}
    /* 	.grid_item {
    	display: inline-block;
    	width:20%;
    	vertical-align: top;
    	} */
    	
    	.first {
    	display: inline;
    	width:30%;
    	vertical-align: top;
    	}
    </style>
  </head>

  <body>
<%@include file="../main/header.jsp"%>
    <!--Div that will hold the pie chart-->
    <div id=first>
	    <div class="grid" id="chart_div1"></div>
	    <div class="grid" id="chart_div2"></div>
	    <div class="grid" id="chart_div3"></div>
    </div>
  </body>
<%@include file="../main/footer.jsp"%>
</html>