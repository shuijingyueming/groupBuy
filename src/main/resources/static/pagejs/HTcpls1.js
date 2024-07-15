$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_f1");
    $("#menu_f1", parent.document).addClass("active");
});

function getMonthDay(year, month) {
    let days = new Date(year, month+1, 0).getDate()
    return days
}

function getEvents(y, m,d, s,t) {
    var list=[];
    let da=new Date();
    // var index = layer.load(1, {
    //     content: "查询中",
    //     shade: [0.1, 'black'], //0.1透明度的白色背景
    //     success: function (layero) {
    //         layero.find('.layui-layer-content').css({
    //             'padding-top': '39px',
    //             'width': '60px'
    //         });
    //     }
    // });
    for(let i=s;i<t;i++){
        if(i+1>d){
            da=new Date(y, m, i+1);
            $.ajax({
                url:'toDi/serachcpls1?date='+getTime(da,'YY-MM-DD'),
                type:'post',
                async: false,
                cache: false,
                processData: false,
                contentType: false,
                dataType:'json',
                success:function(data) {
                    var item = eval(data.item);
                    if(item.zt){
                        let usdlist=item.usdlist;
                        if(usdlist.length>0){
                            let gtitle='公司('+usdlist.length+')';
                            let htitle='';
                            for(let j=0;j<usdlist.length;j++){htitle+=usdlist[j].usd002+"  "}
                            list.push({
                                    title: gtitle,
                                    htitle:htitle,
                                    start: da,
                                    allDay: true,
                                    backgroundColor: '#00a65a', //red
                                    borderColor: '#00a65a' //red
                                }
                            )
                            list.push(
                                {
                                    title: (item.tz?'(有调整)':'')+'菜品管理',
                                    start: da,
                                    allDay: true,
                                    url: 'toDi/tocpls1cp?date='+getTime(da,'YY-MM-DD')+"&lx="+(i+1>d+7?'B':'A'),
                                    backgroundColor:(item.tz?'#f56954': '#00c0ef'), //red
                                    borderColor: (item.tz?'#f56954': '#00c0ef') //red
                                }

                            )
                        }

                    }
                },
                error:function(){}
            });
        }
    }
    // layer.close(index)
    // console.log(list);
    return list;
}

$(function () {
    /* initialize the external events
     -----------------------------------------------------------------*/
    function init_events(ele) {
        ele.each(function () {

            // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
            // it doesn't need to have a start or end
            var eventObject = {
                title: $.trim($(this).text()) // use the element's text as the event title
            }

            // store the Event Object in the DOM element so we can get to it later
            $(this).data('eventObject', eventObject)

            // make the event draggable using jQuery UI
            $(this).draggable({
                zIndex: 1070,
                revert: true, // will cause the event to go back to its
                revertDuration: 0  //  original position after the drag
            })

        })
    }

    init_events($('#external-events div.external-event'))

    /* initialize the calendar
     -----------------------------------------------------------------*/
    //Date for the calendar events (dummy data)
    var date = new Date()
    var d = date.getDate(),
        m = date.getMonth(),
        y = date.getFullYear()
    var t=getMonthDay(y, m);
    var list=[];
    var l=$('#l').val();
    var t1=0;
    var m1=0;
    list=getEvents(y, m,d,0,t);
    $('#calendar').fullCalendar({
        editable: true,
        eventLimit: true,
        height:600,
        header: {
            left: 'prevMonthCustom,nextMonthCustom, today',
            center: 'title',
            right: ''//'month,agendaWeek,agendaDay'
        },
        customButtons: {
            prevMonthCustom: {
                text: '上个月',
                click: function() {
                    m1--;
                    $('#calendar').fullCalendar('prev')
                }
            },
            nextMonthCustom: {
                text: '下个月',
                click: function() {
                    m1++;
                    // console.log(m1);
                    $('#calendar').fullCalendar('next')
                    if(m1>l){
                        t1=t+getMonthDay(y, m+l);
                        list=list.concat(getEvents(y, m+l,d,t,t1));
                        l++;
                        // console.log(list);
                        $("#calendar").fullCalendar('removeEvents');
                        $('#calendar').fullCalendar("addEventSource",list);
                    }
                }
            }
        },
        buttonText: {
            // prev: 'prev',
            today: '今天'//,
            // month: 'month',
            // week: 'week',
            // day: 'day'
        },
        //Random default events
        events: list,
        eventLimit: true,
        editable: true,
        droppable: true, // this allows things to be dropped onto the calendar !!!
        drop: function (date, allDay) { // this function is called when something is dropped
            console.log(date)
            // retrieve the dropped element's stored Event Object
            var originalEventObject = $(this).data('eventObject')

            // we need to copy it, so that multiple events don't have a reference to the same object
            var copiedEventObject = $.extend({}, originalEventObject)

            // assign it the date that was reported
            copiedEventObject.start = date
            copiedEventObject.allDay = allDay
            copiedEventObject.backgroundColor = $(this).css('background-color')
            copiedEventObject.borderColor = $(this).css('border-color')

            // render the event on the calendar
            // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
            $('#calendar').fullCalendar('renderEvent', copiedEventObject, true)

            // is the "remove after drop" checkbox checked?
            if ($('#drop-remove').is(':checked')) {
                // if so, remove the element from the "Draggable Events" list
                $(this).remove()
            }


        }
    });
})

