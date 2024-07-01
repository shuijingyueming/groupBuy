var checked_item="";

$(document).ready(function () {

    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_e3");
    $("#menu_e3", parent.document).addClass("active");

});

function xxcx(){
    var params = [["date",$("#date").val()]];
    form_submit("toOr/tocg","post",params,"_self");
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
        var r = confirm("确定导出采购单吗？");
        if (r == true) {
            var params = [ ["date",$("#date").val()], ["zt","DC"],];
            form_submit("toOr/tocg","get",params,"_self");
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