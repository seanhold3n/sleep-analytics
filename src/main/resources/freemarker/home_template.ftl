<!DOCTYPE html>
<html>
<head>
    <title>My Site</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script>
	<#include "home_template_js.ftl">
	</script>
	
	<style>
	<#include "home_template_css.ftl">
	</style>
	
</head>
<body>

<!-- heading for our about page -->
		<h2> I can has Sleep? <br />Cat Analytics </h2> 
		
		<a href="aboutIcanHazSleep.html"><button type = "button"> About I can has Sleep? </button></a> 
		
		<br /> 
		
		<div id="chart-holder"></div>
		<br /> 
		
				<!-- putting in images --> 
		<img src = "microsoftWordCat.jpg" height = "75px" width = "75px" border = "3px blue" alt = "Microsoft Word Cat" />
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

