var checked_item="";


function tolskc(cpid){
    var params = [ ["cpid",cpid], ["fh","CP"],
        ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())]];
    form_submit("toDi/tocpls","post",params,"_self");
}

$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }

    $("#menuName", parent.document).val("menu_b3");
    $("#menu_b3", parent.document).addClass("active");

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
                    url: "cpname", //后台处理程序
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
            t4: {
                required : true,
            },
            t5: {
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

    $('select[id=t11]').change(function() {
        if( $("#t11").val()!=""){
            tofl($("#t11").val(),'t12')
        }else {
            $('select[id=t12]').empty();
            $('select[id=t12]').append("<option value=''>请选择</option>");
        }
    })
});

//翻页
function fanye(pageindex) {
    var isnum=/^\d+$/.test(pageindex);
    if(isnum)
        usffanye(pageindex);
    else{
        alert("格式错误");
    }
}

//翻页
function usffanye(pageindex){
    var params = [["pages",pageindex],
        ["name",$.trim($("#name").val())]];
    form_submit("toDi/tocp","post",params,"_self");
}

function xxcx(){
    var params = [ ["pages",$("#pages").val()],
        ["name",$.trim($("#name").val())]];
    form_submit("toDi/tocp","post",params,"_self");
}

function xgzt(id,uname,type){
    var r = confirm("确定修改此菜品的状态吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","U"], ["uname",uname],["type",type],
            // ["TK","TK"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocp","get",params,"_self");
    }
}

function xgztx(id,uname,type){
    var r = confirm("确定修改此菜品的销量状态吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","X"], ["uname",uname],["type",type],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocp","get",params,"_self");
    }
}


function del(id,uname){
    var r = confirm("确定删除此菜品吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocp","get",params,"_self");
    }
}

//批量删除
function delete_item(){
    checked_item ="#";
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    var r = confirm("确定删除这些菜品吗？");
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())]];
        form_submit("toDi/tocp","get",params,"_self");
    } else {
    }
}

//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toDi/serachcp?id='+id,
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
                html+= '<div class="form-group"><label class="layui-form-label">菜品名称：</label>';
                html+= '<span class="jspan">'+item.usf002+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">单位：</label>';
                html+= '<span class="jspan">'+(item.usm!=null?item.usm002:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">一级分类：</label>';
                html+= '<span class="jspan">'+(item.yhe!=null?item.yhe002:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">二级分类：</label>';
                html+= '<span class="jspan">'+(item.ysa!=null?item.ysa002:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">库存数：</label>';
                html+= '<span class="jspan">'+(item.usf001!=null?item.usf010:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">原始价格：</label>';
                html+= '<span class="jspan">'+(item.usf005!=null?item.usf005:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">优惠价格：</label>';
                html+= '<span class="jspan">'+(item.usf006!=null?item.usf006:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">累计销售数量：</label>';
                html+= '<span class="jspan">'+(item.usf008!=null?item.usf008:'')+'</span></div></div>';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">累计销售金额：</label>';
                html+= '<span class="jspan">'+(item.usf009!=null?item.usf009:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">规格简介：</label>';
                html+= '<span class="jspan">'+(item.usf003!=null?item.usf003:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">详情描述：</label>';
                html+= '<span class="jspan">'+(item.usf007!=null?item.usf007:'')+'</span></div></div>';
                html+= '</div>';
                html+= '';
                var list=item.usnlist;
                html+= "<div class='row'><div class='col-md-11'>";
                html+= "<div class='form-group'><label class='layui-form-label'>图片：</label>";
                html+= "<br/><div id='p4' style='display: flex;justify-content: start;align-items: center;flex-flow: row wrap;'>";
                for(var i=0;i<list.length;i++){
                    html+="<div class='item'>";
                    // html+= "<img src='upload/shopimg/"+list[i].usn003+"' style='width:150px;' /></div>";
                    html+= "<img src='https://fxtgoss.oss-cn-hangzhou.aliyuncs.com/shopimg/"+list[i].usn003+"' style='width:150px;' /></div>";
                }
                html+= "</div></div></div></div>";
                $("#xq").append(html);
            },
            error:function(){}
        });
        $("#dtitle").html("菜品信息详情");
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
            url:'toDi/serachcp?id='+id,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                $("#t1").val(item.usf002);
                $("#t8").val(item.usf003);
                $("#t4").val(item.usf004);
                $("#t5").val(item.usf005);
                $("#t6").val(item.usf006);
                // $("#t7").val(item.usf007);
                KE.html(item.usf007);
                // $("#t10").val(item.usf010);
                console.log(item.usf011)
                tofl(item.usf011,"t12")
                $("#t11").val(item.usf011);
                $("#t12").val(item.usf012);
                var list=item.usnlist;
                var html="";
                var data="";
                $("#p4").empty();
                // console.log(item)
                for(var i=0;i<list.length;i++){
                    // data="upload/shopimg/"+list[i].usn003;
                    data="https://fxtgoss.oss-cn-hangzhou.aliyuncs.com/shopimg/"+list[i].usn003;
                    imglist.push(data);
                    html="<div class='item'>";
                    html+="<img src='"+data+"' style='width:150px;'/>";
                    html+="<div class='closep' id=\'P"+i+"\' name=\'"+data+"\' onclick='imgRemove(this)'>X</div>";
                    html+="</div>";
                    $("#p4").append(html);
                }
            },
            error:function(){}
        });
        $("#id").val(id);
        $("#mtitle").html("修改菜品信息");
    }else{
        $("#mtitle").html("添加菜品信息");
    }
    $("#active").show();
    $("#adiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function clean(){
    $("#t1").val("");
    $("#t4").val("");
    $("#t5").val("");
    $("#t6").val("");
    $("#t7").val("");
    $("#t8").val("");
    // $("#t10").val("");
    $("#t11").val("");
    $("#t12").val("");
    $("#t12").empty();
    imglist=[];
    t4=[];
    KE.html("");
    $("#p4").empty();
    $("#id").val("");
    $("#adiv").removeClass("an");
    $("#active").hide();
    $(".form-control").removeClass("error");
    $(".error").remove();
}

//删除图片
function imgRemove(obj){
    let indexp = obj.getAttribute("id").replace("P","");
    //后台删除图片
    // if(obj.getAttribute("name").indexOf("upload/shopimg/")>=0){
    //     // $("#delimg").val($("#delimg").val()+"#"+(obj.getAttribute("name")).replace("upload/shopimg/",""));
    //     $("#delimg").val($("#delimg").val()+"#"+(obj.getAttribute("name")).replace("upload/shopimg/",""));
    // }
    if(obj.getAttribute("name").indexOf("https://fxtgoss.oss-cn-hangzhou.aliyuncs.com/shopimg/")>=0){
        // $("#delimg").val($("#delimg").val()+"#"+(obj.getAttribute("name")).replace("https://fxtgoss.oss-cn-hangzhou.aliyuncs.com/shopimg/",""));
        $("#delimg").val($("#delimg").val()+"#"+(obj.getAttribute("name")).replace("https://fxtgoss.oss-cn-hangzhou.aliyuncs.com/shopimg/",""));
    }
    imglist.splice(indexp,1);
    insertImg("#p4");
}

//判断图片
function showpdtpgs(id,img){
    var file = document.getElementById(id).files;
    if(file){
        for(var i=0;i<file.length;i++){
            imglist.push(file[i]);
        }
        insertImg(img);
    }
}

function insertImg(img){
    $(img).empty();
    var html="";
    t4=[];
    for(var i=0;i<imglist.length;i++){
        html="";
        var data = imglist[i];
        var data1 ="";
        if(typeof(imglist[i])=="object"){
            t4.push(imglist[i])
            var reader = new FileReader();
            reader.readAsDataURL(imglist[i]);
            reader.onload = (function(i,e) {
                data1 = e.target.result;
                const image = new Image()
                image.src = e.target.result
                return new Promise((resolve) => {
                    image.onload = () => {
                        const width = image.width
                        const height = image.height
                        // console.log(width+"---"+height)
                        // if(width==414&&height==280){
                            html="<div class='item'>";
                            html+="<img src='"+data1+"' style='width:150px;' />";
                            html+="<span class='closep' id=\'P"+i+"\' name='' onclick='imgRemove(this)'>X</span>";
                            html+="</div>";
                            $(img).append(html);
                        // }else{
                        //     layer.open({content: '分辨率必须是414*280',btn: '我知道了'});
                        // }
                    }
                })
            }).bind(reader, i);
        }else{
            html="<div class='item'>";
            html+="<img src='"+data+"' style='width:150px;' />";
            html+="<span class='closep' id=\'P"+i+"\' name=\'"+data+"\' onclick='imgRemove(this)'>X</span>";
            html+="</div>";
            $(img).append(html);
        }
    }
}

function save(id){
    var falg=true;
    $('.error').remove();
    if($.trim($("#t1").val())==""){
        $("#t1").after('<label id="t1-error" class="error" style="margin-left:5px;margin-top:6px;color: red;" for="t1">不能为空</label>');
        falg=false;
    }
    if($.trim($("#t4").val())==""){
        $("#t4").after('<label id="t2-error" class="error" style="margin-left:5px;margin-top:6px;color: red;" for="t4">不能为空</label>');
        falg=false;
    }
    if($.trim($("#t5").val())==""){
        $("#t5").after('<label id="t2-error" class="error" style="margin-left:5px;margin-top:6px;color: red;" for="t5">不能为空</label>');
        falg=false;
    }
    // if($.trim($("#t10").val())==""){
    //     $("#t10").after('<label id="t2-error" class="error" style="margin-left:5px;margin-top:6px;color: red;" for="t10">不能为空</label>');
    //     falg=false;
    // }
    if($.trim($("#t8").val())==""){
        $("#t8").after('<label id="t2-error" class="error" style="margin-left:5px;margin-top:6px;color: red;" for="t8">不能为空</label>');
        falg=false;
    }
    if($.trim(KE.html())==""){
        $("#t7").after('<label id="t3-error" class="error" style="margin-left:5px;margin-top:6px;color: red;" for="t7">不能为空</label>');
        falg=false;
    }
    if(imglist.length==0){
        $("#t2").after('<label id="t4-error" class="error" style="margin-left:5px;margin-top:6px;color: red;" for="t2">请添加图片</label>');
        falg=false;
    }
    if(falg){
        formData.delete("t2");
        for(var i=0;i<t4.length;i++){
            formData.append("t2",t4[i]);
        }
        formData.append("delimg",$("#delimg").val());
        formData.append("id",$("#id").val());
        formData.append("t1",$("#t1").val());
        formData.append("t8",$("#t8").val());
        formData.append("t4",$("#t4").val());
        formData.append("t5",$("#t5").val());
        formData.append("t6",$("#t6").val());
        formData.append("t7",KE.html());
        formData.append("t10",$("#t10").val());
        formData.append("t11",$("#t11").val());
        formData.append("t12",$("#t12").val());
        $.ajax({//jQuery方法，此处可以换成其它请求方式
            url: 'toDi/xgcp',
            type:'post',
            data: formData,
            async: false,
            cache: false, //表示上传文件不需要缓存
            processData: false,//表示不需要对数据做处理
            contentType: false,//因为前面已经声明了是‘FormData对象’
            mimeType:"multipart/form-data",
            dataType:'json',
            success: function (res) {
                var params = [["pages",$("#pages").val()],
                    ["name",$.trim($("#name").val())]];
                form_submit("toDi/tocp","post",params,"_self");
            }
        })
    }
}


function tofl(id,name){
    $.ajax({
        url: 'tofllist?id=' + id,
        type: 'post',
        async: false,
        cache: false,
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function (data) {
            var list = eval(data.list);
            console.log(list)
            $("select[id="+name+"]").empty();
            $("select[id="+name+"]").append("<option value=''>请选择</option>");
            for (var i = 0; i < list.length; i++) {
                $("select[id="+name+"]").append("<option value='" + list[i].ysa001 + "'>" + list[i].ysa002 + "</option>");
            }
            form.render();
        },
        errror: function () {
        }
    })
}

function tokc(id){
    $("#cpid").val(id);
    $("#modal-2").show();
}

function cancel_q(){
    $("#num").val("");
    $("#sdid").val("");
    $("#modal-2").hide();
}

function xgtj(){
    console.log($("input[name='t15']:checked").val())
    if($("input[name='t15']").val()=="A"||($("#t10").val()!=""&&parseInt($("#t10").val())>0)){
        var r = confirm("确定修改库存吗？");
        if (r == true) {
            var params = [ ["id",$("#cpid").val()],["lx",$("input[name='t15']:checked").val()],["num",$("#t10").val()], ["zt","K"],
                ["pages",$("#pages").val()],
                ["name",$.trim($("#name").val())]];
            form_submit("toDi/tocp","get",params,"_self");
        }
        $("#t10").val("");
        $("#sdid").val("");
        $("#modal-2").hide();
    }
}