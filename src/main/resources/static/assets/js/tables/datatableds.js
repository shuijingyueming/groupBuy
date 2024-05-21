$(document).ready(function () {
    $('#example').DataTable();

    $('#jyflexm1').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:[$("#flid").val()!=""?{text: '全部',action: function ( e, dt, node, config ) {flxx('');}}:undefined,],
        "columnDefs": [ {
            "orderable": false,
            "targets": [3]
        }]
    });

    $('#dphxexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:$("#jsqx").val()=="street"||$("#jsqx").val().indexOf("Y5#")>=0||$("#jsqx").val().indexOf("Y6#")>=0?[/*'excel','print',*/
            $("#lx").val()=="0"&&($("#jsqx").val()=="street"||$("#jsqx").val().indexOf("Y5#")>=0)?{text: '用户核销',action: function ( e, dt, node, config ) {totjyh();}}:undefined,
            $("#lx").val()=="1"&&($("#jsqx").val()=="street"||$("#jsqx").val().indexOf("Y6#")>=0)?{text: '店铺提现',action: function ( e, dt, node, config ) {totjdp();}}:undefined,
        ]:[],
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
        buttons: [ {text: '返回',action: function ( e, dt, node, config ) {reback();}},],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });

    $('#spfkexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:[  $("#fhlx").val()!=""?{text: '返回',action: function ( e, dt, node, config ) {reback();}}:undefined,],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,4]
        }]
    });
});
