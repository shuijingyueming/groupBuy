var checked_item="";

function tops(gsid,date){
    var params = [ ["gsid",gsid],["date",date],
        ["ptime",$("#ptime").val()],
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
        ["ptime",$("#ptime").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/tops1","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["ptime",$("#ptime").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/tops1","post",params,"_self");
}

function todc(id,date){
    var r = confirm("确定导出配送单吗？");
    if (r == true) {
        var params = [ ["id",id], ["date",date], ["zt","DC"],
            ["ptime",$("#ptime").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toOr/tops1","get",params,"_self");
    }
}
