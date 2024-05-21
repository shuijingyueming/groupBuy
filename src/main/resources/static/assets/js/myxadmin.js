// Array.prototype.remove = function(val) {
//     var index = this.indexOf(val);
//     if (index > -1) {
//         return  this.splice(index, 1);
//     }

// };
$(function () {
    //设定框架高度
   setTimeout(function(){
       let ud = $('#x-iframe').attr("src");
       if(ud=='toHt/indexi'){
           $('#x-iframe').css("height","1500px");
       }else{
           $('#x-iframe').css("height","1000px");
       }
   },1000);
    //左侧菜单效果
    $('#nav').on('click', 'li', function (event) {
        let urlp =  $(this).children('a').attr('_href');
        $('#x-iframe').attr("src",urlp);
        event.stopPropagation();
        setTimeout(function(){
            let mainheight =  $('#x-iframe').contents().find("#wrhead").height()+$('#x-iframe').contents().find("#wrapp").height();
            let wheight = $("#bash").css("min-height").replaceAll("px","");
            mainheight = mainheight+100;
            if(mainheight<wheight){
                $('#x-iframe').css("height",wheight);
            }else{
                $('#x-iframe').css("height",mainheight);
            }
        },1000);
    });

    //监听浏览器大小变化时
    $(window).resize(function() {
           let mainheight =  $('#x-iframe').contents().find("#wrhead").height()+$('#x-iframe').contents().find("#wrapp").height();
            mainheight = mainheight+100;
            let wheight = $("#bash").css("min-height").replaceAll("px","");
            if(mainheight<wheight){
              $('#x-iframe').css("height",wheight);
              //改变mode高度
                if($("#x-iframe").contents().find("#adiv").css("height").replaceAll("px","")>wheight){
                    $('#x-iframe').css("height",$("#x-iframe").contents().find("#adiv").css("height").replaceAll("px","")+50);
                }
                if($("#x-iframe").css("width").replaceAll("px","")<700){
                    $("#x-iframe").contents().find("#adiv").css("margin-top",30);
                }else{
                    $("#x-iframe").contents().find("#adiv").css("margin-top",0);
                }
            }else{
              $('#x-iframe').css("height",mainheight);
            }
    });


    $("textarea").each(function () {
        var len = $(this).val().length;
        $(this).next().find(".dqzs").html(len);
        $(this).next().find(".zzs").html($(this).attr("maxlength"));
    });

    $("textarea").bind('input propertychange', function () {
        textareasr(this);
    });
    layui.use(['layer'], function () {
        var layer = layui.layer;
    });

});

function textareasr(obj) {
    var len = $(obj).val().length;
    var maxlen = $(obj).attr("maxlength");
    if (parseInt(len) > parseInt(maxlen)) {
        len = maxlen;
    }
    $(obj).next().find(".dqzs").html(len);
}
