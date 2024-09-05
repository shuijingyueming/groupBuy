var checked_item="";
function reback(){
    var params = [["fh",$("#fhlx").val()]];
    form_submit("toOr/todz","post",params,"_self");
}

function rebacky(){
    var params = [["fh",$("#fhlx").val()]];
    form_submit("toOr/toydz","post",params,"_self");
}

$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }
        $("#menuName", parent.document).val("menu_e1");
        $("#menu_e1", parent.document).addClass("active");

    pdyes($("#pages").val(), $("#counts").val());
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
         ["date",$.trim($("#date").val())],["mo",$.trim($("mo").val())],
        ["start",$.trim($("#start").val())],
        ["end",$.trim($("#end").val())],
        ["zffs",$.trim($("#zffs").val())],
        ["type",$.trim($("#type").val())],
        ["gsid",$.trim($("#gsid").val())],
        ["ygid",$.trim($("#ygid").val())],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]
        ];
    form_submit("toOr/todd","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
         ["date",$.trim($("#date").val())],["mo",$.trim($("mo").val())],
        ["start",$.trim($("#start").val())],
        ["end",$.trim($("#end").val())],
        ["zffs",$.trim($("#zffs").val())],
        ["type",$.trim($("#type").val())],
        ["gsid",$.trim($("#gsid").val())],
        ["ygid",$.trim($("#ygid").val())],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/todd","post",params,"_self");
}

function totk(id,uname){
    var r = confirm("确定退货吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","T"], ["uname",uname],
            ["pages",$("#pages").val()],
             ["date",$.trim($("#date").val())],["mo",$.trim($("mo").val())],
            ["start",$.trim($("#start").val())],
            ["end",$.trim($("#end").val())],
            ["zffs",$.trim($("#zffs").val())],
            ["type",$.trim($("#type").val())],
            ["gsid",$.trim($("#gsid").val())],
            ["ygid",$.trim($("#ygid").val())],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toOr/todd","get",params,"_self");
    }
}


function del(id,uname){
    var r = confirm("确定删除此账户吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["pages",$("#pages").val()],
             ["date",$.trim($("#date").val())],["mo",$.trim($("mo").val())],
            ["start",$.trim($("#start").val())],
            ["end",$.trim($("#end").val())],
            ["zffs",$.trim($("#zffs").val())],
            ["type",$.trim($("#type").val())],
            ["gsid",$.trim($("#gsid").val())],
            ["ygid",$.trim($("#ygid").val())],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toOr/todd","get",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些订单吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["pages",$("#pages").val()],
             ["date",$.trim($("#date").val())],["mo",$.trim($("mo").val())],
            ["start",$.trim($("#start").val())],
            ["end",$.trim($("#end").val())],
            ["zffs",$.trim($("#zffs").val())],
            ["type",$.trim($("#type").val())],
            ["gsid",$.trim($("#gsid").val())],
            ["ygid",$.trim($("#ygid").val())],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toOr/todd","get",params,"_self");
    } else {
    }
}


//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toOr/serachdd?id='+id,
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
                html+= '<div class="form-group"><label class="layui-form-label">人员名称：</label>';
                html+= '<span class="jspan">'+(item.usc!=null?item.usc.usc002:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">公司名称：</label>';
                html+= '<span class="jspan">'+(item.usd!=null?item.usd.usd002:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">支付方式：</label>';
                html+= '<span class="jspan">'+(item.yhc006=='W'?'微信支付':(item.yhc006=='P'?'账户余额':''))+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">总金额：</label>';
                html+= '<span class="jspan">'+(item.yhc007!=null?item.yhc007:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">下单日期：</label>';
                html+= '<span class="jspan">'+(item.yhc004!=null?getTime(item.yhc004):'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">送货日期：</label>';
                html+= '<span class="jspan">'+(item.yhc008!=null?getTime(item.yhc008,'YY-MM-DD'):'')+'</span></div></div>';
                html+= '</div>';

                var list=item.ushlist;
                html+= "<div class='row'><div class='col-md-11'>";
                html+= "<div class='form-group'><label class='layui-form-label'></label>";
                html+= "<div id='p4' style='display: flex;justify-content: start;align-items: center;flex-flow: row wrap;'>";
                html+='<table style=\'width: 1000px;\'><thead><tr><th>菜品</th><th>数量</th><th>价格</th><th>金额</th></tr></thead> <tbody>';
                for(var i=0;i<list.length;i++){
                    html+="<tr><th>"+list[i].usf.usf002+"</th><th>"+list[i].ush004+"</th><th>"+list[i].ush005+"</th><th>"+list[i].ush006+"</th></tr>";
                }
                html+= '</tbody></table></div></div></div>';
                $("#xq").append(html);
            },
            error:function(){}
        });
        $("#dtitle").html("订单信息详情");
    }
    $("#detail").show();
    $("#ddiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function gb(){
    $("#ddiv").removeClass("an");
    $("#detail").hide();
}