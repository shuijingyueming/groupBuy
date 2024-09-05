var checked_item="";

function reback(){
    var params = [["fh",$("#fhlx").val()]];
    form_submit("toCo/togs","post",params,"_self");
}

function reback1(){
    var params = [["fh",$("#fhlx").val()]];
    form_submit("toCo/togsyg","post",params,"_self");
}


$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_d3");
    $("#menu_d3", parent.document).addClass("active");

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
            },
            t2 :{
                required : true,
            },
            t3 :{
                required : true,
            },

        },
        messages: {
        },
        submitHandler: function(form) {
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
        uscfanye(pageindex);
    else{
        alert("格式错误");
    }
}

//翻页
function uscfanye(pageindex){
    var params = [
        ["fhlx",$("#fhlx").val()],
        ["pages",pageindex],
        ["gsid",$("#gsid").val()],
        ["ygid",$.trim($("#ygid").val())]];
    form_submit("toCo/tocz","post",params,"_self");
}

function xxcx(){
    var params = [
        ["fhlx",$("#fhlx").val()],
        ["gsid",$("#gsid").val()],
        ["pages",$("#pages").val()],
        ["ygid",$.trim($("#ygid").val())]];
    form_submit("toCo/tocz","post",params,"_self");
}


function xgzt(id,uname,type){
    var r = confirm("确定修改此充值记录的状态吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","U"], ["type",type], ["uname",uname],
            ["fhlx",$("#fhlx").val()],
            ["gsid",$("#gsid").val()],
            ["pages",$("#pages").val()],
            ["ygid",$.trim($("#ygid").val())]];
        form_submit("toCo/tocz","get",params,"_self");
    }
}

function del(id,uname){
    var r = confirm("确定删除此充值记录吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["fhlx",$("#fhlx").val()],
            ["gsid",$("#gsid").val()],
            ["pages",$("#pages").val()],
            ["ygid",$.trim($("#ygid").val())]];
        form_submit("toCo/tocz","get",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些充值记录吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["fhlx",$("#fhlx").val()],
            ["gsid",$("#gsid").val()],
            ["pages",$("#pages").val()],
            ["ygid",$.trim($("#ygid").val())]];
        form_submit("toCo/tocz","get",params,"_self");
    } else {
    }
}

//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toCo/serachgsyg?id='+id,
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
                html+= '<div class="form-group"><label class="layui-form-label">充值记录名称：</label>';
                html+= '<span class="jspan">'+item.usc002+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">企业地址：</label>';
                html+= '<span class="jspan">'+(item.usc003!=null?item.usc003:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">企业电话：</label>';
                html+= '<span class="jspan">'+(item.usc004!=null?item.usc004:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">加盟日期：</label>';
                html+= '<span class="jspan">'+(item.usc008!=null?getTime(item.usc008,'YY-MM-DD'):'')+'</span></div></div>';
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
        $("#dtitle").html("充值记录信息详情");
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
            url:'toCo/serachgsyg?id='+id,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                $("#t1").val(item.usc002);
                $("#t2").val(item.usc005);
                $("#t3").val(item.usc015);
            },
            error:function(){}
        });
        $("#id").val(id);
        $("#mtitle").html("修改充值记录信息");
    }else{
        $("#mtitle").html("添加充值记录信息");
    }
    $("#active").show();
    $("#adiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function clean(){
    $("#t1").val("");
    $("#t2").val("");
    $("#t3").val("");
    $("#id").val("");
    $("#adiv").removeClass("an");
    $("#active").hide();
    $(".form-control").removeClass("error");
    $(".error").remove();
}

