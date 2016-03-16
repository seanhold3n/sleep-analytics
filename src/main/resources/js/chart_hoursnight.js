/*JavaScript file for the main UI code for the sleep analytics project 
called "I can has Sleep?." This file exists so that we can implemment 
highcharts! yay! Rebecca loves highcharts! :) ...this is also 
Rebecca's first time actually using JavaScript for something*/ 

/* JSON callback code derived from:
http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/line-time-series/ */
		
$(document).ready(function () {
    $('#chart-holder').highcharts({
        chart: {
            zoomType: 'xy'
        },
        title: {
            text: 'Amount of Sleep Mapped to Mood'
        },
        subtitle: {
            text: 'data is estimated'
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
        }]
    });
});


/* http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/combo-dual-axes/ */ 