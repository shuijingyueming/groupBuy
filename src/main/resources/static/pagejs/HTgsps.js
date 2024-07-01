var checked_item="";

function tops(gsid){
    var params = [ ["gsid",gsid],
        ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/topsyg","post",params,"_self");
}


$(document).ready(function () {

    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_e4");
    $("#menu_e4", parent.document).addClass("active");

    pdyes($("#pages").val(), $("#counts").val());
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
    form_submit("toOr/tops","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/tops","post",params,"_self");
}

function todc(){
    var r = confirm("确定导出配送单吗？");
    if (r == true) {
        var params = [ ["type","E"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toOr/tops","get",params,"_self");
    }
}

function topsd(id){
    $("#gsid").val(id);
    $("#modal-2").show();
}

function cancel_q(){
    $("#date").val("");
    $("#gsid").val("");
    $("#modal-2").hide();
}


function todc(){
    if($("#date").val()!=""){
        var r = confirm("确定导出配送单吗？");
        if (r == true) {
            var params = [ ["id",$("#gsid").val()], ["date",$("#date").val()], ["zt","DC"],
                ["name",$.trim($("#name").val())]];
            form_submit("toDi/toqs","get",params,"_self");
        }
    }else{
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.ready(function(){
                layer.msg("请选择配送日期");
            });
        });
    }

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
                form_submit("toOr/tops","get",params,"_self");
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