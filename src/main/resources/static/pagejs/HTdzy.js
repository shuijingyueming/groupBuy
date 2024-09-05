var checked_item="";

function reback(){
    var params = [["fh",$("#fhlx").val()]];
    form_submit("toCo/togs","post",params,"_self");
}

function toddjl(id){
    var params = [ ["date",id], ["fh",$("#fhlx").val()+"YDZ"],
        ["pages",$("#pages").val()],
        ["gsid",$("#gsid").val()],
        ["start",$("#start").val()],
        ["end",$("#end").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/todd","post",params,"_self");
}


$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_e4");
    $("#menu_e4", parent.document).addClass("active");

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
        ["gsid",$("#gsid").val()],
        ["pages",pageindex],
        ["start",$.trim($("#start").val())],
        ["end",$.trim($("#end").val())],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/toydz","post",params,"_self");
}

function xxcx(){
    var params = [
        ["fhlx",$("#fhlx").val()],
        ["gsid",$("#gsid").val()],
        ["pages",$("#pages").val()],
        ["start",$.trim($("#start").val())],
        ["end",$.trim($("#end").val())],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toOr/toydz","post",params,"_self");
}

function todcdz(id){
    var r = confirm("确定导出对账单吗？");
    if (r == true) {
        var params = [
            ["id", id], ["zt", "DC"],
            ["fhlx", $("#fhlx").val()],
            ["gsid", $("#gsid").val()],
            ["pages", $("#pages").val()],
            ["start", $.trim($("#start").val())],
            ["end", $.trim($("#end").val())],
            ["name", $.trim($("#name").val())],
            ["phone", $.trim($("#phone").val())]];
        form_submit("toOr/toydz", "post", params, "_self");
    }
}

