var checked_item="";

let listBz = [];
let listBzSet = new Set(listBz);
function toyg(gsid){
    var params = [ ["id",gsid], ["fh","GS"]
        , ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toCo/togsyg","post",params,"_self");
}
function toczjl(gsid){
    var params = [ ["id",gsid], ["fh","GS"]
        , ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toCo/tocz","post",params,"_self");
}
function todz(gsid){
    var params = [ ["id",gsid], ["fh","GS"]
        , ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/todz","post",params,"_self");
}

function tops(gsid){
    var params = [ ["id",gsid],
        , ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toCo/tops","post",params,"_self");
}

$(document).ready(function () {

    $('select[id=t4]').change(function() {
        const text = $("#t4").find("option:selected").text();
        const id =$(this).val();
        if(id!="")listBzSet=putIn(id,text,listBzSet,"#alllzbzlx",'bz',"#t8",listBz);
    });
    $('body').on('click','.bz',function(){
        const isVal = $(this).attr('id');
        const isText = $(this).parent().text();
        if(id!="")putOn(isVal,isText,listBzSet,"#alllzbzlx",'bz',"#t8",listBz);
    })

    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_d1");
    $("#menu_d1", parent.document).addClass("active");

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
                    url: "gsname", //后台处理程序
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
            t3 :{
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
        usdfanye(pageindex);
    else{
        alert("格式错误");
    }
}

//翻页
function usdfanye(pageindex){
    var params = [["pages",pageindex],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toCo/togs","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toCo/togs","post",params,"_self");
}

function todc(){
    var r = confirm("确定导出模板吗？");
    if (r == true) {
        var params = [ ["type","E"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toCo/togs","get",params,"_self");
    }
}

function del(id,uname){
    var r = confirm("确定删除此公司吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toCo/togs","get",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些公司吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toCo/togs","get",params,"_self");
    } else {
    }
}

//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toCo/serachgs?id='+id,
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
                html+= '<div class="form-group"><label class="layui-form-label">公司名称：</label>';
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
                html+= '</div>';
                html+= '';
                var list =item.yhblist;
                if(list!=null) {
                    html += '<div class="row"><div class="col-md-5">';
                    html += '<div class="form-group"><label class="layui-form-label">期数：</label>';
                    html += '<span class="jspan">';
                    for (var i = 0; i < list.length; i++) {
                        html += list[i].usb.usb002;
                    }
                    html += '</span>';
                    html += '</div></div></div>';
                }
                html+= '';
                $("#xq").append(html);
            },
            error:function(){}
        });
        $("#dtitle").html("公司信息详情");
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
            url:'toCo/serachgs?id='+id,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                $("#t1").val(item.usd002);
                $("#t2").val(item.usd003);
                $("#t3").val(item.usd004);
                $("#t4").val(item.usd008);
                $("#t5").val(getTime(item.usd010,'YY-MM-DD'));
                var list =item.yhblist;
                $("#alllzbzlx").empty();
                var html=``;
                if(list!=null&&list.length>0){
                    for(var i=0;i<list.length;i++){
                        html +=  "<div class=dpcs><image src='./static/images/delicon.png' class='bz' name='bz' id='"+list[i].usb.usb001+"' value='"+list[i].usb.usb002+"'></image>"+list[i].usb.usb002+"</div>";
                    }
                }
                $("#alllzbzlx").append(html);
                $("img[class='bz']").each(function(){
                    listBz.push($(this).attr('id')+"#"+$(this).parent().text());
                    listBzSet.add($(this).attr('id')+"#"+$(this).parent().text());
                });
            },
            error:function(){}
        });
        $("#id").val(id);
        $("#mtitle").html("修改公司信息");
    }else{
        $("#mtitle").html("添加公司信息");
    }
    $("#active").show();
    $("#adiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function clean(){
    $("#t1").val("");
    $("#t2").val("");
    $("#t3").val("");
    $("#t4").val("");
    $("#t5").val("");
    $("#id").val("");
    $("#adiv").removeClass("an");
    $("#active").hide();
    $(".form-control").removeClass("error");
    $(".error").remove();
    $("#alllzbzlx").empty();
    $("#t8").val("");
    listBz = [];
    listBzSet = new Set(listBz);
}

function dryg(id){
    $('#file1').click();
   $("#gsid").val(id);
}

function daoruwj1() {
    var formData = new FormData();
    formData.append("file1", document.getElementById("file1").files[0]);
    formData.append("gsid", $("#gsid").val());
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
        url: 'dryg',
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
                    ["name",$.trim($("#name").val())],
                    ["phone",$.trim($("#phone").val())]];
                form_submit("toCo/togs","get",params,"_self");
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