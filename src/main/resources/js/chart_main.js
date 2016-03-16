/* Derived from:
http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/line-time-series/ */
		
$(function () {


        $('#chart-holder').highcharts({
            chart: {
                zoomType: 'x'
            },
            title: {
                text: 'My Actual Sleep Data'
            },
            subtitle: {
                text: document.ontouchstart === undefined ?
                        'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
            },
            xAxis: {
                type: 'datetime'
            },
            yAxis: {
                title: {
                    text: 'Hours slept'
                }
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },

            series: [{
                type: 'area',
                name: 'Hours',
                data: [[Date.UTC(2015,11,25),4.68],[Date.UTC(2015,11,26),13.08],[Date.UTC(2015,11,27),5.73],[Date.UTC(2015,11,28),12.00],[Date.UTC(2015,11,29),6.50],[Date.UTC(2015,11,30),6.67],[Date.UTC(2015,11,31),14.04]]
            }]
        });
});
