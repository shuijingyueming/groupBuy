jQuery(document).ready(function () {
    jQuery('#vmap').vectorMap({
        map: 'world_en',
        backgroundColor: '#fff',
        color: '#ffffff',
        hoverOpacity: 0.7,
        selectedColor: '#000000',
        enableZoom: true,
        showTooltip: true,
        scaleColors: ['#555555', '#CCCCCC'],
        values: sample_data,
        normalizeFunction: 'polynomial'
    });
});
if($("#bj").val()==""){
    if(document.getElementById("doughnut-chart")!=null){
        new Chart(document.getElementById("doughnut-chart"), {
            type: 'doughnut',
            data: {
                labels: labellist,
                datasets: [
                    {
                        label: "",
                        backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346", "#A976FF", "#76B2FF"],
                        data: datalist
                    }
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display: false},
            }
        });
    }
    if(document.getElementById("doughnut-chart1")!=null){
        new Chart(document.getElementById("doughnut-chart1"), {
            type: 'doughnut',
            data: {
                labels: labellist1,
                datasets: [
                    {
                        label: "",
                        backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346", "#A976FF", "#76B2FF"],
                        data: datalist1
                    }
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display: false},
            }
        });
    }
    if(document.getElementById("doughnut-chart2")!=null){
        new Chart(document.getElementById("doughnut-chart2"), {
            type: 'doughnut',
            data: {
                labels: labellist2,
                datasets: [
                    {
                        label: "",
                        backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346", "#A976FF",
                            "#76B2FF", "#4ECD77","#f84a3d","#56c513","#006ddd","#00ddd0"],
                        data: datalist2
                    }
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display: false},
            }
        });
    }
if(document.getElementById("vertical-bar-chart1")!=null){
        new Chart(document.getElementById("vertical-bar-chart1"), {
            type: 'line',
            data: {
                labels: labellist3,
                datasets: [
                    {
                        pointBackgroundColor:'rgba(22, 119, 255,1)',
                        borderColor: 'rgba(22, 119, 255,0.6)',
                        backgroundColor:'rgba(22, 119, 255, 0.16)',
                        label: "小红花数",
                        data: datalist3
                    }
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display: false},
                // legend: { position: 'right', maxLines: 2, textStyle: { fontSize: 13, bold: false, italic: false } }
            }

        });
    }
}else{
    if(document.getElementById("doughnut-chart3")!=null){
        new Chart(document.getElementById("doughnut-chart3"), {
            type: 'doughnut',
            data: {
                labels: labellist5,
                datasets: [
                    {
                        label: "",
                        backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346", "#A976FF", "#76B2FF"],
                        data: datalist5
                    }
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display: false},
            }
        });
    }
    /*if(document.getElementById("vertical-bar-chart3")!=null){
        new Chart(document.getElementById("vertical-bar-chart3"), {
            type: 'line',
            data: {
                labels: labellist6,
                datasets: [
                    {
                        pointBackgroundColor:'rgba(22, 119, 255,1)',
                        borderColor: 'rgba(22, 119, 255,0.6)',
                        backgroundColor:'rgba(22, 119, 255, 0.16)',
                        label: "小红花数",
                        data: datalist6
                    }
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display: false},
                // legend: { position: 'right', maxLines: 2, textStyle: { fontSize: 13, bold: false, italic: false } }
            }

        });
    }*/
	
	
	
    if(document.getElementById("doughnut-chart4")!=null){
        new Chart(document.getElementById("doughnut-chart4"), {
            type: 'doughnut',
            data: {
                labels: labellist8,
                datasets: [
                    {
                        label: "",
                        backgroundColor: ["#FF6384", "#36A2EB", "#4BC0C0", "#FFCD56", "#F39346", "#A976FF", "#76B2FF", "#4ECD77"],
                        data: datalist8
                    }
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display: false},
            }
        });
    }
}

new Chart(document.getElementById("real-time-chart"), {
     type: 'line',
            data: {
                labels: labellist3,
                datasets: [
                    {
                        pointBackgroundColor:'rgba(22, 119, 255,1)',
                        borderColor: 'rgba(22, 119, 255,0.6)',
                        backgroundColor:'rgba(22, 119, 255, 0.16)',
                        label: "",
                        data: datalist3,
                    },
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display:false},
				scales: {
                  yAxes: [{
                    id: 'y-axis',
					display:false
                    }],
				   xAxes: [{
                    id: 'x-axis',
					display:false
                   }]
                }
            }
});
new Chart(document.getElementById("real-time-chart1"), {
     type: 'bar',
            data: {
                labels: labellist3,
                datasets: [
                    {
						backgroundColor:'rgba(22, 119, 255, 0.7)',
                        label: "",
                        data: datalist3,
						borderSkipped:[{barThickness:10}]
                    },
                ]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: false,
                    text: ''
                },
                legend: {display:false},
				scales: {
                  yAxes: [{
                    id: 'y-axis',
					display:false
                    }],
				   xAxes: [{
                    id: 'x-axis',
					barThickness:10,
					display:false
                   }]
                }
            }
});


// $('#vertical-bar-chart1').sparkline('html',{height: '65', width: '200'});

// new Chart(document.getElementById("pie-chart"), {
//     type: 'pie',
//     data: {
//         labels: labellist,
//         datasets: [{
//             label: "全校小红花贡献值分布",
//             backgroundColor: ["#5087EC","#68BBC4","#58A55C"],
//             data: datalist,
//         }]
//     },
//     options: {
//         maintainAspectRatio: false,
//         responsive: true,
//         legend: {display: false},
//         title: {
//             display: false,
//             text: ''
//         }
//     }
// });
//
// new Chart(document.getElementById("pie-chart1"), {
//     type: 'pie',
//     data: {
//         labels: labellist1,
//         datasets: [{
//             label: "",
//             backgroundColor: ["#5087EC","#68BBC4","#58A55C"],
//             data: datalist1
//         }]
//     },
//     options: {
//         maintainAspectRatio: false,
//         responsive: true,
//         legend: {display: false},
//         title: {
//             display: false,
//             text: ''
//         }
//     }
// });
//
// new Chart(document.getElementById("pie-chart2"), {
//     type: 'pie',
//     data: {
//         labels: labellist2,
//         datasets: [{
//             label: "",
//             backgroundColor: ["#D97559","#E4C477","#DAA67B","#4E9C8F"],
//             data: datalist2
//         }]
//     },
//     options: {
//         maintainAspectRatio: false,
//         responsive: true,
//         title: {
//             display: false,
//             text: ''
//         }
//     }
// });
//
// new Chart(document.getElementById("vertical-bar-chart"), {
//     type: 'bar',
//     data: {
//         labels: labellist3,
//         datasets: [
//             {
//                 label: "小红花",
//                 backgroundColor: ["#FF6384", "#36A2EB","#4BC0C0","#FFCD56","#F39346","#EEEEEE"],
//                 data: datalist3
//             }
//         ]
//     },
//     options: {
//         maintainAspectRatio: false,
//         responsive:true,
//         legend: { display: false },
//         title: {
//             display: false,
//             text: ''
//         }
//     }
//
// });
//
// new Chart(document.getElementById("horizontal-bar-chart"), {
//     type: 'horizontalBar',
//     data: {
//         labels: labellist4,
//         datasets: [
//             {
//                 label: "",
//                 backgroundColor: ["#5087EC"],
//                 data: datalist4
//             }
//         ]
//     },
//     options: {
//         maintainAspectRatio: false,
//         responsive:true,
//         legend: { display: false },
//         title: {
//             display: true,
//             text: '班级人均排行'
//         }
//     }
// });