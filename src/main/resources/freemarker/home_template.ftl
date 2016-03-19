<!DOCTYPE html>
<html>
<head>
    <title>Sleep Analytics Stuff</title>
    
    <!-- For remote access -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://code.highcharts.com/stock/highstock.js"></script>
	<script src="http://www.highcharts.com/js/themes/dark-unica.js"></script>
	
	<!-- For local access
	<script src="/js/third-party/jquery.min.js"></script>
	<script src="/js/third-party/highstock.js"></script>
	<script src="/js/third-party/dark-unica.js"></script>
	-->
	
	<script src="/js/chart_main.js"></script> <!-- chart-holder -->
	<script src="/js/chart_hoursnight_demo_mood.js"></script> <!-- chart-holder2 -->
	
</head>
<body>

	<!-- referencing the external style sheet --> 
			<link rel = "stylesheet" href = "css/home_style.css">

<!-- heading for our about page -->
		<h2> I can has Sleep? <br />Cat Analytics </h2> 
		
		<a href="about"><button type = "button"> About I can has Sleep? </button></a> 
		
		<br /> 
		
		<div id="chart-holder"></div>
		<br><br>
		<div id="chart-holder2"></div>
		<br /> 
		
				<!-- putting in images --> 
		<img src = "img/microsoftWordCat.jpg" height = "75px" width = "75px" border = "3px blue" alt = "Microsoft Word Cat" />
		Picture obtained from: http://bp2.blogger.com/_hbpLGRGZWl4/R70kKnphWXI/AAAAAAAAAx0/xOgGtpOTV7Y/s1600/untitled5.JPG 
		
		<p id = "moodScale"> The measurement of mood is on a five point scale. Here are the categories of moods: 
		
		<br /> 1 = VERY not happy 
		<br /> 2 = not happy 
		<br /> 3 = content 
		<br /> 4 = well 
		<br /> 5 = everything is AWESOME 
		
		</p> 
</body>
</html>

