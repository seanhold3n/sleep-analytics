<!DOCTYPE html>
<html>
<head>
    <title>My Site</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script>
	
	/*JavaScript file for the main UI code for the sleep analytics project 
called "I can has Sleep?." This file exists so that we can implemment 
highcharts! yay! Rebecca loves highcharts! :) ...this is also 
Rebecca's first time actually using JavaScript for something*/ 

		
$(document).ready(function () {
    $('#chart-holder').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: 'Amount of Sleep over the last 5.5 years'
        },
        subtitle: {
            text: 'Seriously - this is Sean\'s actual sleep data!'
        },
        xAxis: [{
            categories: ${xAxisCategories},
            crosshair: true
        }],
        yAxis: [{ // mood points
            labels: {
                format: '{value}',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            title: {
                text: 'Mood Points',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            }
        }, { // Secondary yAxis
            title: {
                text: 'Hours Slept',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            labels: {
                format: '{value} hours',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            x: 120,
            verticalAlign: 'top',
            y: 100,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },
        series: [{
            name: 'Hours of Sleep',
            type: 'column',
            yAxis: 1,
            data: ${hoursData},
            tooltip: {
                valueSuffix: ' hours'
            }

        }
        /*, {
            name: 'Mood',
            type: 'spline',
            data: [4, 3, 3, 2, 3, 2, 4],
            tooltip: {
                valueSuffix: ''
            }
        }*/
         ]
    });
    
    /* Secondary mood demo chart */
     $('#chart-holder2').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: 'Amount of Sleep Mapped to Mood'
        },
        subtitle: {
            text: 'This is demo data'
        },
        xAxis: [{
            categories: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday',
                'Sunday'],
            crosshair: true
        }],
        yAxis: [{ // mood points
            labels: {
                format: '{value}',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            title: {
                text: 'Mood Points',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            }
        }, { // Secondary yAxis
            title: {
                text: 'Hours Slept',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            labels: {
                format: '{value} hours',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'vertical',
            align: 'left',
            x: 120,
            verticalAlign: 'top',
            y: 100,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },
        series: [{
            name: 'Hours of Sleep',
            type: 'column',
            yAxis: 1,
            data: [8, 7, 5, 4, 6, 0, 9],
            tooltip: {
                valueSuffix: ' hours'
            }

        }, {
            name: 'Mood',
            type: 'spline',
            data: [4, 3, 3, 2, 3, 2, 4],
            tooltip: {
                valueSuffix: ''
            }
        } ]
    });
    
});


/* http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/combo-dual-axes/ */ 
	</script>
	
	<style>
/* Rebecca's first time using CSS */ 
/* styling for main page */ 
/* PolyHacks 2016 */ 

/* adding background-color */ 
body { 
	background-color: #0B5172;
}

/* adding padding for head and body */
head {
	padding: 200px;
}

body {
	padding-right: 400px; 
	padding-left: 400px; 
}

button { 
	background-color: #E37222 ; 
	font-size: 50 px ;
	border-radius: 90%;
}

#moodScale { 
	color: #FFFFFF ; 
	background-color: #008542 ;
	max-width: 425px ;
	font-family: "Courier New", Courier, monospace ;
		</style>
	
</head>
<body>

<!-- heading for our about page -->
		<h2> I can has Sleep? <br />Cat Analytics </h2> 
		
		<a href="about"><button type = "button"> About I can has Sleep? </button></a> 
		
		<br /> 
		
		<div id="chart-holder"></div>
		<br><br>
		<div id="chart-holder2"></div>
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

