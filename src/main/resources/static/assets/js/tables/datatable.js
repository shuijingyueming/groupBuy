$(document).ready(function () {
    $('#example').DataTable();
    //账户管理
   $('#staffexm').DataTable({
       // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A2#")>=0||$("#jsqx").val().indexOf("A4#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

   $('#roleexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A2#")>=0||$("#jsqx").val().indexOf("A4#")>=0?[/*'excel','print',*/
           $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined/*,
           $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
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

    $('#ddexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#fhlx").val()!=""?[/*'excel','print',*/
            $("#fhlx").val()!=""?{text: '返回',action: function ( e, dt, node, config ) {reback();}}:undefined/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#dwexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("F2#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("F2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#cpexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("G2#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("G2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#cplsexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [
            $("#fhlx").val()!=""?{text: '返回',action: function ( e, dt, node, config ) {reback();}}:undefined,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("P2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#fhlx").val()==""&&($("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("P5#")>=0)?{text: '下载模板',action: function ( e, dt, node, config ) {todc();}}:undefined,
            $("#fhlx").val()==""&&($("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("P5#")>=0)?{text: '导入',action: function ( e, dt, node, config ) {todr();}}:undefined,

        ],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#pslsexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("Q2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
        ],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#qsexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("H2#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("H2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#gsexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("I2#")>=0?[/*'excel','print',*/
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("I2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            {text: '下载模板',action: function ( e, dt, node, config ) {todc();}}/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });
    $('#gsygexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("J2#")>=0||$("#fhlx").val()!=""?[/*'excel','print',*/
            $("#fhlx").val()!=""?{text: '返回',action: function ( e, dt, node, config ) {reback();}}:undefined,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("J2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });
    $('#gsczexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#fhlx").val()!=""||$("#jsqx").val().indexOf("K2#")>=0?[/*'excel','print',*/
            $("#fhlx").val().indexOf("GS")>=0&&$("#fhlx").val().indexOf("YG")<0?{text: '返回',action: function ( e, dt, node, config ) {reback();}}:undefined,
            $("#fhlx").val().indexOf("YG")>=0?{text: '返回',action: function ( e, dt, node, config ) {reback1();}}:undefined/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#gspsexm').DataTable({
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

    $('#gspsygexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [{text: '返回',action: function ( e, dt, node, config ) {reback();}},
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("N2#")>=0?{text: '导出',action: function ( e, dt, node, config ) {todc();}}:undefined],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#gscgexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [$("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("O2#")>=0?{text: '导出',action: function ( e, dt, node, config ) {todc();}}:undefined],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#qscpexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [
            {text: '返回',action: function ( e, dt, node, config ) {reback();}},
            $("#type").val()=="B"&&($("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("P5#")>=0)?{text: '下载模板',action: function ( e, dt, node, config ) {todc();}}:undefined,
            $("#type").val()=="B"&&($("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("P5#")>=0)?{text: '导入',action: function ( e, dt, node, config ) {todr();}}:undefined,],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });
    $('#dzexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: $("#jsqx").val()=="admin"||$("#fhlx").val()!=""?[/*'excel','print',*/
            $("#fhlx").val()!=""?{text: '返回',action: function ( e, dt, node, config ) {reback();}}:undefined/*,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A2#")>=0?{text: '新添加',action: function ( e, dt, node, config ) {edit();}}:undefined,
            $("#jsqx").val()=="admin"||$("#jsqx").val().indexOf("A4#")>=0?{text: '批量删除',action: function ( e, dt, node, config ) {delete_item();}}:undefined*/
        ]:[],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

});
