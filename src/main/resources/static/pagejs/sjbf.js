$(function(){
    var type = $("#type").val();
    if(type=='A'){
        $("#zhid").addClass("effect-btn btn btn-success squer-btn");
        $("#zhido").show();
        $("#shodo").hide();
        $("#baocun").show();
    }else if(type=='B'){
        $("#shod").addClass("effect-btn btn btn-success squer-btn");
        $("#zhido").hide();
        $("#shodo").show();
        $("#baocun").hide();
    }
    //菜单样式
    if($("#menuName", parent.document).val()!=""){
        $("#"+$("#menuName", parent.document).val(), parent.document).removeClass("active");
    }
    $("#menuName", parent.document).val("menu_a2");
    $("#menu_a2", parent.document).addClass("active");
});

function qieh(type){
    $("#type").val(type);
    if(type=='A'){
        $("#zhid").addClass("effect-btn btn btn-success squer-btn");
        $("#shod").removeClass("effect-btn btn btn-success squer-btn");
        $("#zhido").show();
        $("#shodo").hide();
        $("#baocun").show();
    }else if(type=='B'){
        $("#zhid").removeClass("effect-btn btn btn-success squer-btn");
        $("#shod").addClass("effect-btn btn btn-success squer-btn");
        $("#zhido").hide();
        $("#shodo").show();
        $("#baocun").hide();
    }
}

$(function() {
    $("#submitForm").validate({
        rules : {
            bfts: {
                required : true,
                digits:true,
            },
        },
        submitHandler: function(form) {
            $(form).find(":submit").attr("disabled", true).html("保存中...");
            form.submit();
        }
    });
});
function bkdata(){
    var params = [];
    form_submit("toHt/backupdownload","get",params,"_black");
}