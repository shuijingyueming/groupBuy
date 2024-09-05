var checked_item="";

$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }
    if($("#jstype").val()=="A"){
        $("#menuName", parent.document).val("menu_a5");
        $("#menu_a5", parent.document).addClass("active");
    }else{
        if($("#jtype").val()=="A"){
            $("#menuName", parent.document).val("menu_b5");
            $("#menu_b5", parent.document).addClass("active");
        }else{
            $("#menuName", parent.document).val("menu_c5");
            $("#menu_c5", parent.document).addClass("active");
        }
    }

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
                isNotChinese: true,
                remote:{
                    url: "zhname", //后台处理程序
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
            t2 :{
                required : true,
            },
            t4 :{
                required : true,
            },
        },
        messages: {
            t1: {
                required: "必须填写",
                remote:"已有相同的账号名称"
            }
        },
        submitHandler: function(form) {
            if($('input[name="t3"]:checked').val()=="B"&&$("#t6").val()==""){
                $("#jd").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t6">必须填写</label>');
                return;
            }else if($('input[name="t3"]:checked').val()=="C"&&$("#t7").val()==""){
                $("#jg").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t7">必须填写</label>');
                return;
            }else if($('input[name="t3"]:checked').val()=="D"&&$("#t7").val()==""){
                $("#jg").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t7">必须填写</label>');
                return;
            }else if($('input[name="t3"]:checked').val()=="E"){
                if($("#t6").val()==""){
                    $("#jd").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t6">必须填写</label>');
                    return;
                }else if($("#t7").val()==""){
                    $("#jg").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t7">必须填写</label>');
                    return;
                }else if($("#t8").val()==""){
                    $("#nj").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t8">必须填写</label>');
                    return;
                }
            }else if($('input[name="t3"]:checked').val()=="F"){
                if($("#t6").val()==""){
                    $("#jd").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t6">必须填写</label>');
                    return;
                }else if($("#t7").val()==""){
                    $("#jg").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t7">必须填写</label>');
                    return;
                }else if($("#t8").val()==""){
                    $("#nj").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t8">必须填写</label>');
                    return;
                }else if($("#t9").val()==""){
                    $("#bj").append('<label id="xm-error" class="error" style="margin-left:5px;margin-top:6px;" for="t9">必须填写</label>');
                    return;
                }
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
    $('input[type=radio][name=t3]').change(function() {
        if(this.value=='B'){
            $("#jg").hide();
            $("#bj").hide();
            $("#nj").hide();
            $("#tnjid").val("");
            $("#tbjid").val("");
        }else if(this.value=='C'&&($("#jstype").val()=="B"||$("#jtype").val()=="B")){
            $("#jg").show();
            $("#bj").hide();
            $("#nj").hide();
            $("#tnjid").val("");
            $("#tbjid").val("");
        }else if(this.value=='E'){
            $("#jg").show();
            $("#nj").show();
            $("#bj").hide();
            $("#tbjid").val("");
        }else if(this.value=='F'){
            $("#jg").show();
            $("#bj").show();
            $("#nj").show();
        }
    });
});

//翻页
function fanye(pageindex) {
    var isnum=/^\d+$/.test(pageindex);
    if(isnum)
        usefanye(pageindex);
    else{
        alert("格式错误");
    }
}

//翻页
function usefanye(pageindex){
    var params = [["pages",pageindex],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]
        ];
    form_submit("toHt/staff","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toHt/staff","post",params,"_self");
}

function del(id,uname){
    var r = confirm("确定删除此账户吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toHt/staff","get",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些账户吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toHt/staff","get",params,"_self");
    } else {
    }
}

function czmm(id){
    var r = confirm("确定重置此账户的密码吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","R"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toHt/staff","get",params,"_self");
    }
}


//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toHt/serachyh?id='+id,
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
                html+= '<div class="row"><div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">账户名称：</label>';
                html+= '<span class="jspan">'+item.use002+'</span>';
                html+= '</div></div><div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">真实姓名：</label>';
                html+= '<span class="jspan">'+(item.use005!=null?item.use005:'')+'</span></div></div></div>';
                html+= '</div></div>';
                html+= '';
                html+= '<div class="row"><div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">账户类型：</label>';
                html+= '<span class="jspan">'+(item.use006=='A'?'平台管理员':(item.use006=='B'?'街道管理员':(item.use006=='C'?($("#jtype").val()=="A"?'学校管理员':'机构管理员'):(item.use006=='E'?'网格管理员':(item.use006=='F'?'微网格管理员':'')))))+'</span>';
                html+= '</div></div><div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">联系手机：</label>';
                html+= '<span class="jspan">'+(item.use007!=null?item.use007:'')+'</span></div></div></div>';

                if($("#jstype").val()!="A"&&$("#jstype").val()!="D"&&$("#jtype").val()!="A") {
                    html += '<div class="row">';
                    html+= '<div class="col-md-5">';
                    html+= '<div class="form-group"><label class="layui-form-label">街道：</label>';
                    html+= '<span class="jspan">'+(item.usg==null?'':item.usg.usg002)+'</span></div></div>';
                    if(item.usd != null) {
                        html += '<div class="col-md-5">';
                        html += '<div class="form-group"><label class="layui-form-label">机构：</label>';
                        html += '<span class="jspan">' +  item.usd.usd002 + '</span></div></div>';
                    }
                    html += '</div>';

                    html += '<div class="row">';
                    if(item.usc != null){
                        html += '<div class="col-md-5">';
                        html += '<div class="form-group"><label class="layui-form-label">网格：</label>';
                        html += '<span class="jspan">' + item.usc.usc002 + '</span></div></div>';
                    }
                    if(item.usb != null) {
                        html += '<div class="col-md-5">';
                        html += '<div class="form-group"><label class="layui-form-label">微网格：</label>';
                        html += '<span class="jspan">' + item.usb.usb002 + '</span></div></div>';
                    }
                    html += '</div>';
                }
                html+= '<div class="row"><div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">角色：</label>';
                html+= '<span class="jspan">'+(item.usa==null?'':item.usa.usa002)+'</span>';
                html+= '</div></div></div>';
                $("#xq").append(html);
            },
            error:function(){}
        });
        $("#dtitle").html("账户信息详情");
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
            url:'toHt/serachyh?id='+id,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                $("#t1").val(item.use002);
                $("#t2").val(item.use005);
                $("input[name='t3']").each(function(){
                    if($(this).val()==item.use006){
                        $(this).prop("checked",true);
                    }else{
                        $(this).prop("checked",false);
                    }
                });
                $("#t4").val(item.use007);
                $("#t5").val(item.use008);
                $("#tjgid").val(item.use010);
                $("#tnjid").val(item.use014);
                $("#tbjid").val(item.use015);
                if(item.use010!=null){
                    if(item.use006=='B'){
                        $("#jg").hide();
                        $("#bj").hide();
                        $("#nj").hide();
                        $("#tnjid").val("");
                        $("#tbjid").val("");
                    }else if(item.use006=='C'&&($("#jstype").val()=="B"||$("#jtype").val()=="B")){
                        $("#jg").show();
                        $("#bj").hide();
                        $("#nj").hide();
                        $("#tnjid").val("");
                        $("#tbjid").val("");
                    }else if(item.use006=='E'){
                        $("#jg").show();
                        $("#nj").show();
                        $("#bj").hide();
                        $("#tbjid").val("");
                    }else if(item.use006=='F'){
                        $("#jg").show();
                        $("#bj").show();
                        $("#nj").show();
                    }
                }
            },
            error:function(){}
        });
        $("#id").val(id);
        $("#mtitle").html("修改账户信息");
    }else{
        $("#mtitle").html("添加账户信息");
    }
    $("#active").show();
    $("#adiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function clean(){
    $("#t1").val("");
    $("#t2").val("");
    $("input[name='t3']").each(function(){
        if($(this).val()==$("#jstype").val()){
            $(this).prop("checked",true);
        }else{
            $(this).prop("checked",false);
        }
    });
    $("#t4").val("");
    $("#t5").val("");
    $("#tjgid").val("");
    $("#tnjid").val("");
    $("#tbjid").val("");
    $("#jg").hide();
    $("#bj").hide();
    $("#nj").hide();
    $("#id").val("");
    $("#adiv").removeClass("an");
    $("#active").hide();
    $(".form-control").removeClass("error");
    $(".error").remove();
}

