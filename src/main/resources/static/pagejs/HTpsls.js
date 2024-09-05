var checked_item="";
function reback(){
    var params = [["fh",$("#fhlx").val()]];
    form_submit("toCo/tocp","post",params,"_self");
}
$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_d4");
    $("#menu_d4", parent.document).addClass("active");

    pdyes($("#pages").val(), $("#counts").val());

    $("#submitForm").validate({
        errorPlacement: function(error, element) {
            //替换错误显示位置，error表示错误信息
            $(element).parent("div").append(error);
            $(element).parent("div").find("label").attr("style","margin-left:5px;");
        },
        rules : {
            t3: {
                required : true,
                remote:{
                    url: "pslsname", //后台处理程序
                    type: "post",  //数据发送方式
                    async : false,
                    dataType: "json",       //接受数据格式
                    data:{
                        "name":function(){
                            return $("#t3").val().trim();
                        },
                        "id":function(){
                            return $("#id").val().trim();
                        }//要传递的数据
                    }
                }
            },
            t4: {
                required : true,
                remote:{
                    url: "pslsname", //后台处理程序
                    type: "post",  //数据发送方式
                    async : false,
                    dataType: "json",       //接受数据格式
                    data:{
                        "name1":function(){
                            return $("#t4").val().trim();
                        },
                        "id":function(){
                            return $("#id").val().trim();
                        }//要传递的数据
                    }
                }
            },
        },
        messages: {
            t3: {
                required: "必须填写",
                remote:"已有相同的原配送日期"
            },
            t4: {
                required: "必须填写",
                remote:"已有相同的配送日期"
            }
        },
        submitHandler: function(form) {
            if($("#t3").val()>=$("#t4").val()) {
                $("#t4").after('<label id="t1-error" class="error" style="margin-left:5px;margin-top:6px;color: red;" for="t4">配送日期要大于原配送日期</label>');
                return;
            }
             layui.use('layer', function(){
                var layer = layui.layer;
                var index = layer.load(1, {
                    content: "保存中",
                    shade: [0.1, 'black'], //0.1透明度的白色背景
                    success: function (layero) {
                        layero.find('.layui-layer-content').css({
                            'padding-top': '39px',
                            'width': '60px'
                        });
                    }
                });
            });
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
        ["fhlx",$.trim($("#fhlx").val())],
        ["date1",$.trim($("#date1").val())],
        ["date",$.trim($("#date").val())]];
    form_submit("toCo/topsls","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["fhlx",$.trim($("#fhlx").val())],
        ["date1",$.trim($("#date1").val())],
        ["date",$.trim($("#date").val())]];
    form_submit("toCo/topsls","post",params,"_self");
}

function todc(){
    var r = confirm("确定导出模板吗？");
    if (r == true) {
        var params = [ ["type","E"],
            ["pages",$("#pages").val()],
            ["fhlx",$.trim($("#fhlx").val())],
            ["date1",$.trim($("#date1").val())],
            ["date",$.trim($("#date").val())]];
        form_submit("toCo/topsls","post",params,"_self");
    }
}

function del(id,uname){
    var r = confirm("确定删除此临时配送日期吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["fhlx",$.trim($("#fhlx").val())],
            ["date1",$.trim($("#date1").val())],
            ["date",$.trim($("#date").val())]];
        form_submit("toCo/topsls","post",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些菜品吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["pages",$("#pages").val()],
            ["fhlx",$.trim($("#fhlx").val())],
            ["date1",$.trim($("#date1").val())],
            ["date",$.trim($("#date").val())]];
        form_submit("toCo/topsls","post",params,"_self");
    } else {
    }
}

//添加编辑
function edit(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toCo/serachpsls?id='+id,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                $("#t3").val(getTime(item.ysb003,'YY-MM-DD'));
                $("#t4").val(getTime(item.ysb004,'YY-MM-DD'));
            },
            error:function(){}
        });
        $("#id").val(id);
        $("#mtitle").html("修改临时配送日期信息");
    }else{
        $("#mtitle").html("添加临时配送日期信息");
    }
    $("#active").show();
    $("#adiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function clean(){
    $("#t3").val("");
    $("#t4").val("");
    $("#id").val("");
    $("#adiv").removeClass("an");
    $("#active").hide();
    $(".form-control").removeClass("error");
    $(".error").remove();
}

function todr(){
    $("#modal-2").show();
}

function cancel_q(){
    $("#time").val("");
    $("#file1").val("");
    $("#modal-2").hide();
}


function drkc(){
    if($("#time").val()!=""){
        $('#file1').click();
    }else {
        layui.use('layer', function () {
            var layer = layui.layer;
            layer.ready(function () {
                layer.msg("请选择配送日期");
            });
        });
    }
}
function daoruwj1() {
    $("#pass1").attr("onclick","xxcx()");
    var formData = new FormData();
    formData.append("file1", document.getElementById("file1").files[0]);
    formData.append("time", $("#time").val());
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
            if (data == 'A') {
                var params = [  ["pages",$("#pages").val()],
                    ["fhlx",$.trim($("#fhlx").val())],
                    ["date1",$.trim($("#date1").val())],
                    ["date",$.trim($("#date").val())]];
                form_submit("toCo/topsls","post",params,"_self");
                // });
            } else if (data == 'B') {
                // layer.msg("导入失败");
                $("#file1").val("");
            } else {
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.ready(function(){
                        layer.msg(data);
                    });
                });
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