$(document).ready(function () {
    $('#example').DataTable();
    $('#coexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
        ],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });
    $('#hdryexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [/*'excel','print',*/
            {text: '返回',action: function ( e, dt, node, config ) {reback();}},
        ],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0]
        }]
    });
    $('#hdexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
        ],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,11]
        }]
    });
    $('#hdflexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons: [/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
        ],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,3]
        }]
    });
    $('#ggexm').DataTable({
        // "searching":false,
        "info":false,
        "paging": false,
        dom: 'Bfrtip',
        buttons:[/*'excel','print',*/
            {text: '新添加',action: function ( e, dt, node, config ) {edit();}},
        ],
        "columnDefs": [ {
            "orderable": false,
            "targets": [0,5]
        }]
    });
});
