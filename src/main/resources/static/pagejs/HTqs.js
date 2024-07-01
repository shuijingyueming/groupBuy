var checked_item="";

$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_c1");
    $("#menu_c1", parent.document).addClass("active");

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
                    url: "qsname", //后台处理程序
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

function tocp(id){
    var params = [["qsid",id]];
    form_submit("toDi/toqscp","post",params,"_self");
}

//翻页
function fanye(pageindex) {
    var isnum=/^\d+$/.test(pageindex);
    if(isnum)
        usbfanye(pageindex);
    else{
        alert("格式错误");
    }
}

//翻页
function usbfanye(pageindex){
    var params = [["pages",pageindex],
        ["name",$.trim($("#name").val())]];
    form_submit("toDi/toqs","post",params,"_self");
}

function xxcx(){
    var params = [ 
        ["name",$.trim($("#name").val())]];
    form_submit("toDi/toqs","post",params,"_self");
}

function del(id,uname){
    var r = confirm("确定删除此期数吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/toqs","get",params,"_self");
    }
}

function todc(id){
    var r = confirm("确定导出配送单吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","DC"],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/toqs","get",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些期数吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/toqs","get",params,"_self");
    } else {
    }
}

//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toDi/serachqs?id='+id,
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
                html+= '<div class="form-group"><label class="layui-form-label">期数名称：</label>';
                html+= '<span class="jspan">'+item.usb002+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">企业地址：</label>';
                html+= '<span class="jspan">'+(item.usb003!=null?item.usb003:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">企业电话：</label>';
                html+= '<span class="jspan">'+(item.usb004!=null?item.usb004:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">加盟日期：</label>';
                html+= '<span class="jspan">'+(item.usb008!=null?getTime(item.usb008,'YY-MM-DD'):'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">期数：</label>';
                html+= '<span class="jspan">'+(item.usb!=null?item.usb.usb002:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                $("#xq").append(html);
            },
            error:function(){}
        });
        $("#dtitle").html("期数信息详情");
    }
    $("#detail").show();
    $("#ddiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function gb(){
    $("#ddiv").removeClass("an");
    $("#detail").hide();
}

//添加编辑
function edit(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toDi/serachqs?id='+id,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                $("#t1").val(item.usb003+"#"+item.usb002);
            },
            error:function(){}
        });
        $("#id").val(id);
        $("#mtitle").html("修改期数信息");
    }else{
        $("#mtitle").html("添加期数信息");
    }
    $("#active").show();
    $("#adiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function clean(){
    $("#t1").val("");
    $("#id").val("");
    $("#adiv").removeClass("an");
    $("#active").hide();
    $(".form-control").removeClass("error");
    $(".error").remove();
}

