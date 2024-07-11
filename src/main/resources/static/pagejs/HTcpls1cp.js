var checked_item="";
function reback(){
    var params = [];
    form_submit("toDi/tocpls1","post",params,"_self");
}
$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_f1");
    $("#menu_f1", parent.document).addClass("active");

    pdyes($("#pages").val(), $("#counts").val());

    $("#submitForm").validate({
        errorPlacement: function(error, element) {
            //替换错误显示位置，error表示错误信息
            $(element).parent("div").append(error);
            $(element).parent("div").find("label").attr("style","margin-left:5px;");
        },
        rules : {
            t1: {
                required : true,
                remote:{
                    url: "qscpname", //后台处理程序
                    type: "post",  //数据发送方式
                    async : false,
                    dataType: "json",       //接受数据格式
                    data:{
                        "name":function(){
                            return $("#t1").val().trim();
                        },
                        "id":function(){
                            return $("#id").val().trim();
                        }//要传递的数据
                    }
                }
            },
            t4: {
                required : true,
            },
            t5: {
                required : true,
            },
            t10: {
                required : true,
            },
        },
        messages: {
            t1: {
                required: "必须填写",
                remote:"已有相同的名称"
            }
        },
        submitHandler: function(form) {
            var index = window.parent.tis("保存中");
            form.submit();
        }
    });
});

//翻页
function fanye(pageindex) {
    var isnum=/^\d+$/.test(pageindex);
    if(isnum)
        usffanye(pageindex);
    else{
        alert("格式错误");
    }
}

//翻页
function usffanye(pageindex){
    var params = [["pages",pageindex],
        ["type",$.trim($("#type").val())],
        ["date",$.trim($("#date").val())],
        ["qsid",$.trim($("#qsid").val())],
        ["name",$.trim($("#name").val())]];
    form_submit("toDi/tocpls1cp","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["type",$.trim($("#type").val())],
        ["date",$.trim($("#date").val())],
        ["qsid",$.trim($("#qsid").val())],
        ["name",$.trim($("#name").val())]];
    form_submit("toDi/tocpls1cp","post",params,"_self");
}

function xgzt(id,cpid,uname,type){
    var r = confirm("确定修改此期数菜品的状态吗？");
    if (r == true) {
        var params = [ ["id",id],["cpid",cpid], ["zt","U"], ["uname",uname],["type",type],
            ["pages",$("#pages").val()],
            ["type",$.trim($("#type").val())],
            ["date",$.trim($("#date").val())],
            ["qsid",$.trim($("#qsid").val())],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocpls1cp","get",params,"_self");
    }
}

function todc(){
    var r = confirm("确定导出模板吗？");
    if (r == true) {
        var params = [ ["type","E"],
            ["pages",$("#pages").val()],
            ["type",$.trim($("#type").val())],
            ["date",$.trim($("#date").val())],
            ["qsid",$.trim($("#qsid").val())],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocpls1cp","get",params,"_self");
    }
}

function add1(id,cpid,uname){
    var num = prompt("请输入修改数量","");
    if (num != null) {
        var params = [ ["num",num],["id",id],["cpid",cpid], ["zt","A1"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["type",$.trim($("#type").val())],
            ["date",$.trim($("#date").val())],
            ["qsid",$.trim($("#qsid").val())],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocpls1cp","get",params,"_self");
    }
}

function add(id,cpid,uname){
    var num = prompt("请输入修改数量","");
    if (num != null) {
        var params = [ ["num",num],["id",id],["cpid",cpid], ["zt","A"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["type",$.trim($("#type").val())],
            ["date",$.trim($("#date").val())],
            ["qsid",$.trim($("#qsid").val())],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocpls1cp","get",params,"_self");
    }
}

function xgztx(id,uname,type){
    var r = confirm("确定修改此期数菜品的销量状态吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","X"], ["uname",uname],["type",type],
            ["pages",$("#pages").val()],
            ["type",$.trim($("#type").val())],
            ["date",$.trim($("#date").val())],
            ["qsid",$.trim($("#qsid").val())],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocpls1cp","get",params,"_self");
    }
}


function del(id,uname){
    var r = confirm("确定删除此临时库存吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["type",$.trim($("#type").val())],
            ["date",$.trim($("#date").val())],
            ["qsid",$.trim($("#qsid").val())],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocpls1cp","get",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些期数菜品吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["pages",$("#pages").val()],
            ["type",$.trim($("#type").val())],
            ["date",$.trim($("#date").val())],
            ["qsid",$.trim($("#qsid").val())],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocpls1cp","get",params,"_self");
    } else {
    }
}

//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toDi/serachqscp?id='+id,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                $("#xq").empty(item);
                let html="";
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">菜品名称：</label>';
                html+= '<span class="jspan">'+item.usf002+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">单位：</label>';
                html+= '<span class="jspan">'+(item.usm!=null?item.usm002:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">一级分类：</label>';
                html+= '<span class="jspan">'+(item.yhe!=null?item.yhe002:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">二级分类：</label>';
                html+= '<span class="jspan">'+(item.ysa!=null?item.ysa002:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">库存数：</label>';
                html+= '<span class="jspan">'+(item.usf001!=null?item.usf010:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">原始价格：</label>';
                html+= '<span class="jspan">'+(item.usf005!=null?item.usf005:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">优惠价格：</label>';
                html+= '<span class="jspan">'+(item.usf006!=null?item.usf006:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">累计销售数量：</label>';
                html+= '<span class="jspan">'+(item.usf008!=null?item.usf008:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">累计销售金额：</label>';
                html+= '<span class="jspan">'+(item.usf009!=null?item.usf009:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">规格简介：</label>';
                html+= '<span class="jspan">'+(item.usf003!=null?item.usf003:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">详情描述：</label>';
                html+= '<span class="jspan">'+(item.usf007!=null?item.usf007:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                var list=item.usnlist;
                html+= "<div class='row'><div class='col-md-11'>";
                html+= "<div class='form-group'><label class='layui-form-label'>图片：</label>";
                html+= "<br/><div id='p4' style='display: flex;justify-content: start;align-items: center;flex-flow: row wrap;'>";
                for(var i=0;i<list.length;i++){
                    html+="<div class='item'>";
                    html+= "<img src='upload/shopimg/"+list[i].usn003+"' style='width:150px;' /></div>";
                }
                html+= "</div></div></div></div>";
                $("#xq").append(html);
            },
            error:function(){}
        });
        $("#dtitle").html("期数菜品信息详情");
    }
    $("#detail").show();
    $("#ddiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function gb(){
    $("#ddiv").removeClass("an");
    $("#detail").hide();
}

function todr(){
    $('#file1').click();
}
function daoruwj1() {
    $("#pass1").attr("onclick","xxcx()");
    var formData = new FormData();
    formData.append("file1", document.getElementById("file1").files[0]);
    formData.append("time", $("#date").val());
    // var index = layer.load(1, {
    //     content: "导入中",
    //     shade: [0.1, 'black'], //0.1透明度的白色背景
    //     success: function (layero) {
    //         layero.find('.layui-layer-content').css({
    //             'padding-top': '39px',
    //             'width': '60px'
    //         });
    //     }
    // });
    $.ajax({
        url: 'drcp',
        type: 'POST',
        data: formData,
        //async: false,                      //async 设置为 false，则所有的请求均为同步请求，在没有返回值之前，同步请求将锁住浏览器
        cache: false,                      // 不缓存
        processData: false,                // jQuery不要去处理发送的数据
        contentType: false,                // jQuery不要去设置Content-Type请求头
        dataType: 'text',
        success: function (data) {
            // layer.close(index)
            // console.log(data)
            if (data == 'A') {
                var params = [  ["pages",$("#pages").val()],
                    ["type",$.trim($("#type").val())],
                    ["date",$.trim($("#date").val())],
                    ["qsid",$.trim($("#qsid").val())],
                    ["name",$.trim($("#name").val())]];
                form_submit("toDi/tocpls1cp","post",params,"_self");
                // });
            } else if (data == 'B') {
                // layer.msg("导入失败");
                $("#file1").val("");
            } else {
                var r = confirm(data);
                var params = [  ["pages",$("#pages").val()],
                    ["type",$.trim($("#type").val())],
                    ["date",$.trim($("#date").val())],
                    ["qsid",$.trim($("#qsid").val())],
                    ["name",$.trim($("#name").val())]];
                form_submit("toDi/tocpls1cp","post",params,"_self");
               /* layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.ready(function(){
                        layer.msg(data);
                        setTimeout(function (){
                            var params = [  ["pages",$("#pages").val()],
                                ["type",$.trim($("#type").val())],
                                ["date",$.trim($("#date").val())],
                                ["qsid",$.trim($("#qsid").val())],
                                ["name",$.trim($("#name").val())]];
                            form_submit("toDi/tocpls1cp","post",params,"_self");
                        },2000);

                    });
                });*/
                $("#file1").val("");
                // deleteCookie('tab_list');
                // deleteCookie('left_menu_father');
                // deleteCookie('left_menu_son');
                // var error = "登录失效";
                // window.parent.location = 'login?error=' + error;
            }
        }
    });
}