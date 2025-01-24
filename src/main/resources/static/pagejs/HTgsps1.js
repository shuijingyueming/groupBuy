var checked_item="";

function rebacky(){
    var params = [["fh",$("#fhlx").val()]];
    form_submit("toOr/toydz","post",params,"_self");
}

function tops(gsid,date){
    var params = [ ["gsid",gsid],["date",date],
        ["ptime",$("#ptime").val()],["fhlx",$("#fhlx").val()],["gsid1",$("#gsid1").val()],["mo",$("#mo").val()],
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

    $("#menuName", parent.document).val("menu_e5");
    $("#menu_e5", parent.document).addClass("active");

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
        ["ptime",$("#ptime").val()],["fhlx",$("#fhlx").val()],["gsid1",$("#gsid1").val()],["mo",$("#mo").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/tops1","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["ptime",$("#ptime").val()],["fhlx",$("#fhlx").val()],["gsid1",$("#gsid1").val()],["mo",$("#mo").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/tops1","post",params,"_self");
}

function todc(id,date){
    var r = confirm("确定导出配送单吗？");
    if (r == true) {
        var params = [ ["id",id], ["date",date], ["zt","DC"],
            ["ptime",$("#ptime").val()],["fhlx",$("#fhlx").val()],["gsid1",$("#gsid1").val()],["mo",$("#mo").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toOr/tops1","get",params,"_blank");
    }
}
