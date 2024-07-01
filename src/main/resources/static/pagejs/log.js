var checked_item="";

$(document).ready(function () {
    //表格全选/反选
    $("#chkbox").change(function(){
        if($("#chkbox").is(":checked")){
            $("[name='cbox']").prop("checked",'checked');//全选
        }else{
            $("[name='cbox']").each(function(){
                this.checked=!this.checked;
            });
        }
        checked_item = [];
        $("[name='cbox']").each(function(){
            if(this.checked) checked_item+=$(this).attr("date-id")+"#";
        });
    });
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }
    $("#menuName", parent.document).val("menu_a3");
    $("#menu_a3", parent.document).addClass("active");
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
        ["name",$.trim($("#name").val())],
        ["start",$.trim($("#start").val())],
        ["end",$.trim($("#end").val())]];
    form_submit("toHt/log","get",params,"_self");
}

//查询
function xxcx(){
    var params = [["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())],
        ["start",$.trim($("#start").val())],
        ["end",$.trim($("#end").val())]];
    form_submit("toHt/log","get",params,"_self");
}

//批量删除
function delete_item(){
    var r = confirm("确定删除这些日志吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())],
            ["jgname", $("#jgname").val()]];
        form_submit("toHt/log","get",params,"_self");
    } else {
    }
}

//最大日期限定
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}

layui.use('laydate', function(){
    var laydate = layui.laydate;
    //执行一个laydate实例
    // laydate.render({
    //     elem: '#start', //指定元素
    //     max:getNowFormatDate(),
    //     done:function checkstartTime(){
    //         var startTime =$("#start").val();
    //         if(startTime==""&&startTime==undefined) return;
    //         var endTime =$("#end").val();
    //         if(endTime==""&&endTime==undefined) return;
    //         var start=new Date(startTime.replace("-", "/").replace("-", "/"));
    //         var end=new Date(endTime.replace("-", "/").replace("-", "/"));
    //         if(end<start){
    //             $("#end").val("");
    //             return;
    //         }  return;
    //     }
    // });
    // //执行一个laydate实例
    // laydate.render({
    //     elem: '#end', //指定元素
    //     max:getNowFormatDate(),
    //     done:function checkendTime(){
    //         var startTime =$("#start").val();
    //         if(startTime==""&&startTime==undefined) return;
    //         var endTime =$("#end").val();
    //         if(endTime==""&&endTime==undefined) return;
    //         var start=new Date(startTime.replace("-", "/").replace("-", "/"));
    //         var end=new Date(endTime.replace("-", "/").replace("-", "/"));
    //         if(end<start){
    //             $("#start").val("");
    //             return;
    //         } return;
    //     }
    // });
});