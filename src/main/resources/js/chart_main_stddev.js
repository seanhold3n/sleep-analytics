/* Derived from:
http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/line-time-series/ 

SMA inclusion derived from: http://jsfiddle.net/laff/WaEBc/

*/

		
$(function () {

	$.getJSON('/stddev.json?callback=?', function (data) {

        $('#chart-holder-stddev').highcharts('StockChart', {
            chart: {
                zoomType: 'x'
            },
            title: {
                text: 'Moving Standard Deviation (Volatility)'
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
                    text: 'Volatility in Hours'
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
                type: 'line',
                name: 'Volatility',
				id: 'primary',
                data: data
            }]
        });
    });
});
