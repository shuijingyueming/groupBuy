var checked_item="";

function reback(){
    var params = [ ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/tops","post",params,"_self");
}


$(document).ready(function () {

    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_e4");
    $("#menu_e4", parent.document).addClass("active");

});

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["date",$("#date").val()],
        ["gsid",$.trim($("#gsid").val())],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/topsyg","post",params,"_self");
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
            var params = [["pages",$("#pages").val()],
                ["date",$("#date").val()], ["zt","DC"],
                ["gsid",$.trim($("#gsid").val())],
                ["name",$.trim($("#name").val())],
                ["phone",$.trim($("#phone").val())]];
            form_submit("toOr/topsyg","get",params,"_self");
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