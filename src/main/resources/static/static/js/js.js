//初始验证
function SlideCheckFail() {
    $(".outer").removeClass("act");
    $(".inner").css("left", 0);
    $(".inner").html("&gt;&gt;");
    $(".filter-box").css('width', 0);
    $(".outer>span").html("按住滑块，拖拽到最右边");
    $("#CaptchaID").val("0");
    $(".outer span").addClass("txtRoll");
}

//验证成功
function SlideCheckSuccess(dx) {
    $(".outer").addClass("act");
    $(".outer>span").html("验证通过！");
    $(".inner").html('&radic;');
    $(".inner").css("left", dx);
    $(".filter-box").css('width', dx);
    $("#CaptchaID").val("1");
    $(".outer span").removeClass("txtRoll");
}

 