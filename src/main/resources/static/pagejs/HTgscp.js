var checked_item="";

function reback(){
    var params = [ ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["phone",$.trim($("#phone").val())]];
    form_submit("toCo/togs","post",params,"_self");
}


$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_d1");
    $("#menu_d1", parent.document).addClass("active");

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

function xxcx(){
        var params = [
            ["pages",$("#pages").val()],
            ["id",$.trim($("#id").val())],
            ["cpname",$.trim($("#cpname").val())],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toCo/togscp","get",params,"_self");
}


function todc(){
    var r = confirm("确定导出模板吗？");
    if (r == true) {
        var params = [ ["type","E"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toCo/togscp","get",params,"_self");
    }
}

function del(id,uname){
    var r = confirm("确定删除此公司吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())]];
        form_submit("toCo/togscp","get",params,"_self");
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
        form_submit("toCo/togscp","get",params,"_self");
    } else {
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
        url: 'drgscp',
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

function xgjg(obj,cpid,jgid,jg){
    console.log(jgid)
    var html = '<input type="text" maxlength="50" autocomplete="off" class="layui-input" value="'+jg+'" />';
    $(obj).parent().prev().html(html);
    html = '<button onclick="bcjg(this,&quot;'+cpid+'&quot;,&quot;'+jgid+'&quot;)" type="button" class="btn btn-primary btn-sm btxz">保存</button>'+
        '<button onclick="qxjg(this,&quot;'+cpid+'&quot;,&quot;'+jgid+'&quot;,&quot;'+jg+'&quot;)" type="button" class="btn btn-primary btn-sm btxz">取消</button>';
    $(obj).parent().html(html);
}

function qxjg(obj,cpid,jgid,jg){
    var html = jg;
    $(obj).parent().prev().html(html);
    html = '<button onclick="xgjg(this,&quot;'+cpid+'&quot;,&quot;'+jgid+'&quot;,&quot;'+jg+'&quot;)" type="button" class="btn btn-primary btn-sm btxz">编辑</button>';
    $(obj).parent().html(html);
}

function bcjg(obj,cpid,jgid){
    var html =  $(obj).parent().prev().find("input").val();
    if(html==""||parseFloat(html)>=0){
        $.ajax({
            url:'toCo/addgscp?cpid='+cpid+'&gsid='+$("#id").val()+'&jgid='+jgid+'&jg='+html,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                $(obj).parent().prev().html(html);
                html = '<button onclick="xgjg(this,&quot;'+cpid+'&quot;,&quot;'+(html==""?"":jgid!=""?jgid:(item!=null?item.usg001:''))+'&quot;,&quot;'+(html==""?"":(item!=null?item.usg005:''))+'&quot;)" type="button" class="btn btn-primary btn-sm btxz">编辑</button>';
                $(obj).parent().html(html);
            }
        });
    }else{
        $(obj).parent().prev().find("div").remove();
        $(obj).parent().prev().append("<div>价格错误</div>");
    }
}