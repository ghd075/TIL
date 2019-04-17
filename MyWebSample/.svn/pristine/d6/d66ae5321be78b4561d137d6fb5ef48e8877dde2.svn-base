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

        // Create the data table.
        var data = new google.visualization.DataTable();
        // Set chart options
        var options = {'title':'좋아요 현황',
                       'width':600,
                       'height':500,
                       colors: ['#e0440e', '#e6693e', '#ec8f6e', '#f3b49f', '#f6c7b6'],
                       is3D: true,                   
                       bar: {groupWidth: '70%'},
                       vAxis: { gridlines: { count: 10 }, format: 'decimal', maxValue:10},
                       animation:{
                       "startup": true,
                       duration: 1000,
                       easing: 'out'
                    	  }
        			  };
        //data.addColumn('string', {role:"style"});
        // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));


        //ajax 호출
      var xhttp = new XMLHttpRequest();
 	  xhttp.onreadystatechange = function() {
  	  if (this.readyState == 4 && this.status == 200) {
         
          data.addColumn('string','부서');
          data.addColumn('number','평균');
          data.addColumn('number','사원수');
          data.addColumn('number','급여');
          data.addColumn({type:'string',role'annotation'})
          data.addColumn({type:'string',role:'tooltip'})
          
          var list = JSON.parse(xhttp.responseText);
    	  var arr = [];
    	  for(i=0; i<list.length;i++){
    		  arr.push([list[i].department_name,
    			  				parseInt(list[i].avgsal),
    			  				parseInt(list[i].cnt),
    			  				parseInt(list[i].salary),
    		  					list[i].department_id,
    		  					list[i].department_name+"\n급여:"+parseInt(list[i].salary)
    			  				]);
    	  }
    	  
          data.addRows(arr);
  		  chart.draw(data, options);
          
   	  	}
	 };
 	 xhttp.open("GET","../SelectDeptEmpServ2", true);
  	 xhttp.send();
												//타겟 , 타입,    이벤트핸들러 
 	 google.visualization.events.addListener(chart,"select",function(){alert('차트선택');});
 	}

        
      var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
 	 	 if (this.readyState == 4 && this.status == 200) {

  	 	 }
 	  };
 	 xhttp.open("GET","../SelectDeptEmpServ2", true);
  	 xhttp.send();
             
      function selectChart(){
    	  alert("막대 선택");
      }
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
  </body>
</html>