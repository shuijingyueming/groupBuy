$(document).ready(function () {
    $('#example').DataTable();
    //账户管理
   $('#staffexm').DataTable({
       // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("A2#")>=0||$("#jsqx").val().indexOf("A4#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("A2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,7]
        }]
    });

   $('#roleexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("A2#")>=0||$("#jsqx").val().indexOf("A4#")>=0?[/*'excel','print',*/
           $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("A2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
           $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,3]
        }]
    });

   $('#logexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("B4#")>=0?[/*'excel','print',*/
            {text: '全部删除',action: function ( e, dt, node, config ) {delete_item();}}
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#jdexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val().indexOf("E2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [7]
        }]
    });

    $('#jgexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val().indexOf("F2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}}/*,
            {text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [7]
        }]
    });

    $('#xnexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        "bSort":false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("G2#")>=0?[
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}}/*,
            {text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],

    });

    $('#njexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:$("#jsqx").val()=="street"||$("#jsqx").val().indexOf("H2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [($("#jstype").val()=="B"?4:3)]
        }]
    });

    $('#bjexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:$("#fhlx").val()!=""||$("#jsqx").val()=="school"||$("#jsqx").val()=="street"||$("#jsqx").val().indexOf("I2#")>=0||$("#jsqx").val().indexOf("I5#")>=0||$("#jsqx").val().indexOf("I6#")>=0?[
            $("#fhlx").val()!=""?{text: '返回',action: function ( e, dt, node, config ) {reback();}} :undefined,
            $("#jsqx").val()=="school"||$("#jsqx").val()=="street"||$("#jsqx").val().indexOf("I2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("I5#")>=0?{text: '下载模板',action: function ( e, dt, node, config ) {xzmb();}} :undefined,
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("I6#")>=0?{text: '升班',action: function ( e, dt, node, config ) {sjbj();}} :undefined
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [6]
        }]
    });


    $('#lsexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("J2#")>=0||$("#jsqx").val().indexOf("J5#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("J2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("J5#")>=0?{text: '下载模板',action: function ( e, dt, node, config ) {xzmb()}}:undefined,
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("J5#")>=0?{text: '导入老师',action: function ( e, dt, node, config ) {$('#file2').click();}}:undefined,
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [$("#jstype").val()=="A"?8:7]
        }]
    });

    $('#dyexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:($("#jsqx").val()=="street"||$("#jsqx").val().indexOf("K2#")>=0)?[/*'excel','print',*/
                $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("K2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
                $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("K9#")>=0?{text: '导出二维码',action: function ( e, dt, node, config ) {toxhhdcwem('','')}}:undefined,
                $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("K9#")>=0?{text: '导入微网格员',action: function ( e, dt, node, config ) {drwwgy()}}:undefined,
                /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/]:
            [/*'excel','print',*/],
        "columnDefs": [ {
            "orderable": false,
            "targets": [$("#jstype").val()=="A"?($("#xslx").val()=="K"?10:8):($("#jstype").val()=="B"?7:9)]
        }]
    });

    $('#jysdexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("L2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [3]
        }]
    });

    $('#jyflexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:$("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("L2#")>=0? [/*'excel','print',*/
            $("#flid").val()!=""?{text: '全部',action: function ( e, dt, node, config ) {flxx('');}}:undefined,
            $("#flid").val()!=""?{text: '新添加',action: function ( e, dt, node, config ) {editsd();}}:undefined
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [4]
        }]
    });

    $('#pjseexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        "bSort":false,
        dom: 'Bfrtip',
        buttons: [/*'excel','print',*/
            // {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ],
/*        "columnDefs": [ {
            "orderable": false,
            "targets": [$("#jtype").val()=="A"?11:9]
        }]*/
    });

    $('#dhwpexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("O2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [$("#jtype").val()=="A"?9:11]
        }]
    });

    $('#pjexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("M2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],
    });

    $('#xhhexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:/* $("#jsqx").val()=="admin"||$("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("S6#")>=0?[/!*'excel','print',*!/
            {text: '导出',action: function ( e, dt, node, config ) {toxhhdc('','');}},
            /!*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*!/
        ]:*/[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [7]
        }]
    });

    $('#xzexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("X2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            // $("#jsqx").val()=="admin"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("X4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined,
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [4]
        }]
    });

    $('#yhhdexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        "bSort":false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("T2#")>=0?[/*'excel','print',*/
            /*{text: '新添加',action: function ( e, dt, node, config ) {edit();}}*/
        ]:[],
    });

    $('#example2').DataTable({
        "scrollY": "500px",
        "scrollCollapse": true,
        "paging": false,
        "bFilter": false
    });

    $('#jzmbexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("U2#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("U2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,2]
        }]
    });

    $('#jzexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        "bSort":false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("V2#")>=0||$("#jsqx").val().indexOf("V5#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("V2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("V5#")>=0?{text: '下载模板',action: function ( e, dt, node, config ) {xzmb();}}:undefined,
        ]:[],
    });

    $('#jzjlexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        "bSort":false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("V4#")>=0?[/*'excel','print',*/
            {text: '批量打印',action: function ( e, dt, node, config ) {todylist();}},
        ]:[],
    });

    $('#xyqlxexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:$("#jsqx").val()=="street"||$("#jsqx").val().indexOf("R2#")>=0||$("#jsqx").val().indexOf("I5#")>=0||$("#jsqx").val().indexOf("I6#")>=0?[
            $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("I2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("I5#")>=0?{text: '导出二维码',action: function ( e, dt, node, config ) {ewmdc('');}} :undefined,
            $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("I5#")>=0?{text: '导出二维码图片',action: function ( e, dt, node, config ) {tpdc();}} :undefined,
            $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("I5#")>=0?{text: '下载模板',action: function ( e, dt, node, config ) {xzmb();}} :undefined,
            $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("I6#")>=0?{text: '导入',action: function ( e, dt, node, config ) {drxyq();}} :undefined
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,4]
        }]
    });

    $('#xyqexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,8]
        }]
    });

    $('#xhhtjexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,5]
        }]
    });
    $('#yhtjexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,4]
        }]
    });
    $('#xyqtable').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [],
        "columnDefs": [ {
            "orderable": false,
            "targets": [7]
        }]
    });
    $('#njtjexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [],
        "columnDefs": [ {
            "orderable": false,
            "targets": [7]
        }]
    });
    $('#xxyhhdexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        "bSort":false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("T2#")>=0?[/*'excel','print',*/
            /*{text: '新添加',action: function ( e, dt, node, config ) {edit();}}*/
        ]:[],
    });

    $('#xspjexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [],
        "columnDefs": [ {
            "orderable": false,
            "targets": []
        }]
    });




    $('#banexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("V2#")>=0||$("#rj").val().indexOf($("#jgid1").val())>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,3]
        }]
    });
    $('#xsexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:($("#jsqx").val()=="school"||$("#jsqx").val().indexOf("K2#")>=0||$("#jsqx").val()=="school"||
                    $("#jsqx").val().indexOf("M2#")>=0||$("#jsqx").val().indexOf("V2#")>=0||
                    $("#jsqx").val().indexOf("K5#")>=0||$("#jsqx").val().indexOf("K6#")>=0)?[/*'excel','print',*/
                 $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("K2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
                 $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("M2#")>=0?{text: '新增奖章',action: function ( e, dt, node, config ) {topyadd('A');}}:undefined,
                $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("M2#")>=0?{text: '新增评语',action: function ( e, dt, node, config ) {topyadd('B');}}:undefined,
                $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("V2#")>=0?{text: '新增奖状',action: function ( e, dt, node, config ) {tojzadd();}}:undefined,
                 $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("K5#")>=0?{text: '下载模板',action: function ( e, dt, node, config ) {xzmb();}} :undefined,
                 $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("K5#")>=0?{text: '导入学生',action: function ( e, dt, node, config ) {drxs();}} :undefined,
                 $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("K6#")>=0?{text: '发勋章',action: function ( e, dt, node, config ) {toxz();}} :undefined,
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [$("#jstype").val()=="A"?9:8]
        }]
    });
    $('#dpexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("U2#")>=0||$("#rj").val().indexOf("jgid1#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("U2#")>=0||$("#rj").val().indexOf("jgid1#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [8]
        }]
    });

    $('#xxjyflexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:$("#flid").val()!=''&&($("#jsqx").val()=="school"||$("#jsqx").val().indexOf("L2#")>=0)? [/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {editsd();}},
            {text: '返回全部',action: function ( e, dt, node, config ) {flxx('');}}
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [$("#flid").val()==''?5:3]
        }]
    });

    $('#xxbjexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("I2#")>=0||$("#jsqx").val().indexOf("I5#")>=0||$("#jsqx").val().indexOf("I6#")>=0?[
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("I2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#jsqx").val()=="school"||$("#jsqx").val().indexOf("I6#")>=0?{text: '升班',action: function ( e, dt, node, config ) {sjbj();}} :undefined
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [6]
        }]
    });

    $('#xxroleexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,2]
        }]
    });

    $('#xhhxsexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });
    $('#xxxzexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("X2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            // $("#jsqx").val()=="admin"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("X4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined,
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [$("#jtype").val()=="A"?6:5]
        }]
    });

    $('#xxdhwpexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("O2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            /*{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [7]
        }]
    });

    $('#smggexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val()=="school"||$("#jsqx").val()=="street"||$("#jsqx").val().indexOf("C2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            // $("#jsqx").val()=="admin"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("X4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined,
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [5]
        }]
    });

    $('#sbexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("D2#")>=0?[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
            // $("#jsqx").val()=="admin"||$("#jsqx").val()=="school"||$("#jsqx").val().indexOf("X4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined,
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [4]
        }]
    });
    $('#dhdhexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#sqtjexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#dpygexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("U2#")>=0||$("#rj").val().indexOf("jgid1#")>=0?[/*'excel','print',*/
            {text: '返回',action: function ( e, dt, node, config ) {reback();}},
            $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("U2#")>=0||$("#rj").val().indexOf("jgid1#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [5]
        }]
    });

    $('#yhjfexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        "bSort":false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="street"||$("#jsqx").val().indexOf("Y2#")>=0?[/*'excel','print',*/
            {text: '添加用户积分',action: function ( e, dt, node, config ) {toyhjf();}}
        ]:[],
    });
});
