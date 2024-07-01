var checked_item="";

$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_b1");
    $("#menu_b1", parent.document).addClass("active");

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
                    url: "flname", //后台处理程序
                    type: "post",  //数据发送方式
                    async : false,
                    dataType: "json",       //接受数据格式
                    data:{
                        "name":function(){
                            return $("#t1").val().trim();
                        },
                        "sjid":function(){
                            return $("#sjid").val().trim();
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

//翻页
function fanye(pageindex) {
    var isnum=/^\d+$/.test(pageindex);
    if(isnum)
        usdfanye(pageindex);
    else{
        alert("格式错误");
    }
}

//翻页
function usdfanye(pageindex){
    var params = [["pages",pageindex],
        ["name",$.trim($("#name").val())]];
    form_submit("toDi/tofl","post",params,"_self");
}

function xxcx(){
    var params = [["name",$.trim($("#name").val())]];
    form_submit("toDi/tofl","post",params,"_self");
}

function del(id,uname,type){
    var r = confirm("确定删除此分类吗？");
    if (r == true) {
        var params = [ ["id",id],["type",type], ["zt","D"], ["uname",uname],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tofl","get",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些分类吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tofl","get",params,"_self");
    } else {
    }
}

//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toDi/serachfl?id='+id,
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
                html+= '<div class="form-group"><label class="layui-form-label">分类名称：</label>';
                html+= '<span class="jspan">'+item.usd002+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">企业地址：</label>';
                html+= '<span class="jspan">'+(item.usd003!=null?item.usd003:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">企业电话：</label>';
                html+= '<span class="jspan">'+(item.usd004!=null?item.usd004:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">加盟日期：</label>';
                html+= '<span class="jspan">'+(item.usd008!=null?getTime(item.usd008,'YY-MM-DD'):'')+'</span></div></div>';
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
        $("#dtitle").html("分类信息详情");
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
function edit(id,sjid,type){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toDi/serachfl?id='+id+'&type='+type,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                if(type=="A"){
                    $("#t1").val(item.yhe002);
                    $("#t3").val(item.yhe003);
                    $("#shtp").attr('src','upload/cpflimg/'+item.yhe003);
                }else{
                    $("#t1").val(item.ysa002);
                }
            },
            error:function(){}
        });
        $("#id").val(id);
        $("#mtitle").html("修改分类信息");
    }else{
        $("#mtitle").html("添加分类信息");
    }
    if(type=="A"){
        $(".t3").show();
    }else{
        $(".t3").hide();
    }
    $("#sjid").val(sjid);
    $("#active").show();
    $("#adiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function clean(){
    $("#t1").val("");
    $("#t2").val("");
    $("#t3").val("");
    $(".t3").hide();
    $("#sjid").val("");
    $("#id").val("");
    $("#adiv").removeClass("an");
    $("#active").hide();
    $(".form-control").removeClass("error");
    $(".error").remove();
}

//判断图片
function showpdtpgs(){
    var filePath = ['.jpg','.png'];
    var file = document.getElementById("t2").files[0];
    if(file){
        var filename = file.name;
        var filejw = filename.substring(filename.lastIndexOf("."));
        var pd = false;
        for(var i=0;i<filePath.length;i++){
            // var imagSize =file.size;
            // if(imagSize <= 1024 * 300){
            if(filejw==filePath[i]){
                var reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onload = function(e) {
                    var data = e.target.result;
                    $("#shtp").attr("src",data);
                };
                pd =  true;
                return;
            }
            // }else{
            //     layer.msg("图片大小在300K以内");
            // }
        }
        if(!pd){
            file.value="";
            $("#file").val("");
            layer.msg("只能上传以.jpg、.png结尾的图片");
            return;
        }
    }else{
        if($("#id").val()==""){
            $("#shtp").attr("src","");
        }
    }
}