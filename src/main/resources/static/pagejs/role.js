var checked_item="";

$(document).ready(function () {
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }
    if($("#jstype").val()=="A"){
        $("#menuName", parent.document).val("menu_a4");
        $("#menu_a4", parent.document).addClass("active");
    }else{
        if($("#jtype").val()=="A"){
            $("#menuName", parent.document).val("menu_b4");
            $("#menu_b4", parent.document).addClass("active");
        }else{
            $("#menuName", parent.document).val("menu_c4");
            $("#menu_c4", parent.document).addClass("active");
        }
    }

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
        },
        messages: {
            t1: {
                required: "必须填写",
            }
        },
        submitHandler: function(form) {
            var index = window.parent.tis("保存中");
            form.submit();
        }
    });
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
        ["name",$.trim($("#name").val())]];
    form_submit("toHt/role","post",params,"_self");
}

function xxcx(){
    var params = [["pages", $("#pages").val()],["name", $("#name").val()]];
    form_submit("toHt/role","post",params,"_self");
}

function del(id,uname){
    var r = confirm("确定删除此角色吗？");
    if (r == true) {
        var params = [ ["id",id], ["zt","D"], ["uname",uname],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())]];
        form_submit("toHt/role","get",params,"_self");
    } else {
    }
}

function xz(o){
    let val=o.value;
    let flag=o.checked;
    $("input[name='qx']").each(function(){
        if($(this).val().indexOf(val)>=0){
            $(this).prop("checked",flag);
        }
    });
}

//批量删除
function delete_item(){
    var r = confirm("确定删除这些角色吗？");
    $("[name='cbox']").each(function(){
        if(this.checked) checked_item+=$(this).attr("date-id")+"#";
    });
    if (r == true) {
        var params = [ ["id",checked_item], ["zt","AD"],
            ["pages",$("#pages").val()],
            ["name",$.trim($("#name").val())],
            ["phone",$.trim($("#phone").val())],
            ["jgname", $("#jgname").val()]];
        form_submit("toHt/role","get",params,"_self");
    } else {
    }
}

//详情
function toxq(id){
    if(id!=null&&id!=''){
        $.ajax({
            url:'toHt/serachjs?id='+id,
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
                html+= '<div class="row"><div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">角色名称：</label>';
                html+= '<span class="jspan">'+item.usa002+'</span>';
                html+= '</div></div>';
                html+= '<div class="row">';
                html+= '<div class="col-md-5">';
                html+= '<div class="form-group"><label class="layui-form-label">角色权限：</label>';
                html+= '<span class="jspan">'+
                (item.usa004.indexOf("A1#")>=0)?"账户/角色查看":""+ (item.usa004.indexOf("A2#")>=0)?"账户/角色添加":""+ (item.usa004.indexOf("A3#")>=0)?"账户/角色编辑":""+
                (item.usa004.indexOf("A4#")>=0)?"账户/角色删除":""+(item.usa004.indexOf("A5#")>=0)?"账户重置密码":""+
                (item.usa004.indexOf("B1#")>=0)?"日志查看":""+ (item.usa004.indexOf("B4#")>=0)?"日志删除":""+
                (item.usa004.indexOf("C1#")>=0)?"数据备份查看":""+ (item.usa004.indexOf("C3#")>=0)?"数据备份编辑":""+
                (item.usa004.indexOf("D1#")>=0)?"平台查看":""+ (item.usa004.indexOf("D3#")>=0)?"平台信息编辑":""+
                (item.usa004.indexOf("E1#")>=0)?"街道查看":""+ (item.usa004.indexOf("E2#")>=0)?"街道添加":""+ (item.usa004.indexOf("E3#")>=0)?"街道编辑":""+
                (item.usa004.indexOf("E8#")>=0)?"街道状态":""+(item.usa004.indexOf("E5#")>=0)?"账户重置密码":""+
                (item.usa004.indexOf("F1#")>=0)?"机构查看":""+ (item.usa004.indexOf("F2#")>=0)?"机构添加":""+ (item.usa004.indexOf("F3#")>=0)?"机构编辑":""+
                (item.usa004.indexOf("F8#")>=0)?"机构状态":""+(item.usa004.indexOf("F5#")>=0)?"账户重置密码":""+
                (item.usa004.indexOf("G1#")>=0)?"学年学期查看":""+ (item.usa004.indexOf("G2#")>=0)?"学年学期添加":""+ (item.usa004.indexOf("G3#")>=0)?"学年学期编辑":""+
                (item.usa004.indexOf("H1#")>=0)?"网格查看":""+ (item.usa004.indexOf("H2#")>=0)?"网格添加":""+ (item.usa004.indexOf("H3#")>=0)?"网格编辑":""+
                (item.usa004.indexOf("H8#")>=0)?"网格状态":""+
                (item.usa004.indexOf("I1#")>=0)?($("#jtype").val()=="A"?"班级查看":"微网格查看"):""+ (item.usa004.indexOf("I2#")>=0)?($("#jtype").val()=="A"?"班级添加":"微网格添加"):""+
                (item.usa004.indexOf("I3#")>=0)?($("#jtype").val()=="A"?"班级编辑":"微网格编辑"):""+(item.usa004.indexOf("I8#")>=0)?($("#jtype").val()=="A"?"班级状态":"微网格状态"):""+(item.usa004.indexOf("I5#")>=0)?($("#jtype").val()=="A"?"班级导出":"微网格导出"):""+(item.usa004.indexOf("I6#")>=0)?($("#jtype").val()=="A"?"班级升班":""):""+
                (item.usa004.indexOf("H1#")>=0)?($("#jstype").val()=="A"?"机构人员查看":"老师查看"):""+ (item.usa004.indexOf("H2#")>=0)?"老师添加":""+ (item.usa004.indexOf("H3#")>=0)?"老师编辑":""+
                (item.usa004.indexOf("H8#")>=0)?"老师状态":""+
                (item.usa004.indexOf("K1#")>=0)?($("#jstype").val()=="A"?"学生/党员查看":($("#jtype").val()=="A"?"学生查看":"党员查看")):'' + (item.usa004.indexOf("K2#")>=0)?"学生添加":"" +
                (item.usa004.indexOf("K3#")>=0)?"学生编辑":"" +(item.usa004.indexOf("K4#")>=0)?"学生删除":""+
                (item.usa004.indexOf("L1#")>=0)?"评价分类查看":""+ (item.usa004.indexOf("L2#")>=0)?"评价分类添加":""+ (item.usa004.indexOf("L3#")>=0)?"评价分类编辑":""+
                (item.usa004.indexOf("L4#")>=0)?"评价分类删除":""+(item.usa004.indexOf("L5#")>=0)?"评价分类生成":""+(item.usa004.indexOf("S6#")>=0)?"小红花导出":""+
                (item.usa004.indexOf("M1#")>=0)?($("#jtype").val()=="A"?"教师评价查看":"街道评价查看"):""+ (item.usa004.indexOf("M2#")>=0)?($("#jtype").val()=="A"?"教师评价添加":"街道评价添加"):""+
                (item.usa004.indexOf("N1#")>=0)?($("#jtype").val()=="A"?"家长/同学评价查看":"自评/他人评价查看"):""+ (item.usa004.indexOf("N8#")>=0)?($("#jtype").val()=="A"?"家长/同学评价状态":"自评/他人评价状态"):""+
                (item.usa004.indexOf("O1#")>=0)?"奖品查看":""+ (item.usa004.indexOf("O2#")>=0)?"奖品添加":""+ (item.usa004.indexOf("O3#")>=0)?"奖品编辑":""+
                (item.usa004.indexOf("O8#")>=0)?"奖品状态":""+
                (item.usa004.indexOf("P1#")>=0)?"奖品兑换查看":""+ (item.usa004.indexOf("P8#")>=0)?"奖品兑换":""+
                (item.usa004.indexOf("Q1#")>=0)?"奖品记录查看":""+
                (item.usa004.indexOf("S1#")>=0)?"小红花查看":""+ (item.usa004.indexOf("S2#")>=0)?"小红花导出":""+
                (item.usa004.indexOf("R1#")>=0)?"观察员-类型查看":""+ (item.usa004.indexOf("R2#")>=0)?"观察员-类型添加":""+ (item.usa004.indexOf("R3#")>=0)?"观察员-类型编辑":""+
                (item.usa004.indexOf("R5#")>=0)?"观察员-类型导入":""+(item.usa004.indexOf("R6#")>=0)?"观察员-类型导出":""+ (item.usa004.indexOf("R7#")>=0)?"观察员-类型生成":""+
                (item.usa004.indexOf("W1#")>=0)?"观察员-事件管理查看":""+ (item.usa004.indexOf("W7#")>=0)?"观察员-事件管理状态":""+
                (item.usa004.indexOf("T1#")>=0)?"勋章查看":""+ (item.usa004.indexOf("T2#")>=0)?"勋章添加":""+ (item.usa004.indexOf("T3#")>=0)?"勋章编辑":""+
                (item.usa004.indexOf("T4#")>=0)?"勋章删除":""+
                '</span>';
                html+= '</div></div>';
                html+= '</div>';
                $("#xq").append(html);
            },
            error:function(){}
        });
        $("#dtitle").html("角色信息详情");
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
            url:'toHt/serachjs?id='+id,
            type:'post',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            dataType:'json',
            success:function(data) {
                var item = eval(data.item);
                // console.log(item)
                $("#t1").val(item.usa002);
                if(item.usa002=="老师"&&$("#jtype").val()=="A"){
                    $("#t1").attr("readonly","true");
                }else{
                    $("#t1").removeAttr("readonly")
                }
                if(item.usa004.indexOf("A1#A2#A3#A4#A5#")>=0)$("#A").prop("checked",true);
                if(item.usa004.indexOf("B1#B4#")>=0)$("#B").prop("checked",true);
                if(item.usa004.indexOf("C1#C3#C6#")>=0)$("#C").prop("checked",true);

                if(item.usa004.indexOf("E1#E2#E3#E4#")>=0)$("#E").prop("checked",true);
                if(item.usa004.indexOf("F1#F2#F3#")>=0)$("#F").prop("checked",true);
                if(item.usa004.indexOf("G1#G2#G3#G7#G8#")>=0)$("#G").prop("checked",true);
                if(item.usa004.indexOf("I1#I2#I3#")>=0)$("#I").prop("checked",true);
                if(item.usa004.indexOf("J1#J2#J3#J7#J6#")>=0)$("#J").prop("checked",true);

                if(item.usa004.indexOf("K1#")>=0)$("#K").prop("checked",true);

                if(item.usa004.indexOf("P1#P2#P3#P4#P5#")>=0)$("#P").prop("checked",true);
                if(item.usa004.indexOf("Q1#Q2#Q3#Q4#")>=0)$("#Q").prop("checked",true);
                if(item.usa004.indexOf("O1#O2#")>=0)$("#O").prop("checked",true);
                if(item.usa004.indexOf("N1#N2#")>=0)$("#N").prop("checked",true);
                if(item.usa004.indexOf("L1#L5#")>=0)$("#L").prop("checked",true);
                if(item.usa004.indexOf("M1#")>=0)$("#M").prop("checked",true);
                $("input[name='qx']").each(function(){
                    if(item.usa004.indexOf($(this).val())>=0){
                        $(this).prop("checked",true);
                    }else{
                        $(this).prop("checked",false);
                    }
                });
            },
            error:function(){}
        });
        $("#id").val(id);
        $("#mtitle").html("修改角色信息");
    }else{
        $("#mtitle").html("添加角色信息");
    }
    $("#active").show();
    $("#adiv").addClass("an");
    //$('#active').css("height",$('#bash', parent.document).css("height"));
}

function clean(){
    $("#t1").val("");
    $("input[type='checkbox']").each(function(){
        $(this).prop("checked",false);
    });
    $("#id").val("");
    $("#adiv").removeClass("an");
    $("#active").hide();
    $(".form-control").removeClass("error");
    $(".error").remove();
}