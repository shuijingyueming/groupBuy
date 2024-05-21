var dqys = 0;

//判断页数 zys：总页数  dqy：当前页
function pdyes(zys, dqy) {
    var html = '<div class="layui-form layui-col-md12 x-so"><a href="javascript:void(0);" style="margin-left:2px;margin-right:2px;" onclick="fanye(1)">&lt;&lt;</a>';

    html += '<a href="javascript:void(0);" style="margin-left:2px;margin-right:2px;" onclick="fanye(' + ((parseInt(dqy) - 1) < 1 ? 1 : (parseInt(dqy) - 1)) + ')">&lt;</a>';

    if (zys > 5) {
        var ks = dqy > 5 ? (dqy - 4) : 1;//循环从第几个开始

        var wy = parseInt(ks) + 4;//循环到第几个结束

        for (var i = ks; i <= wy; i++) {
            if (i == dqy) {
                html += '<span class="current" style="margin-left:2px;margin-right:2px;cursor: pointer;" onclick="fanye(' + i + ')">' + i + '</span>';
            } else {
                html += '<span style="margin-left:2px;margin-right:2px;cursor: pointer;" onclick="fanye(' + i + ')">' + i + '</span>';
            }
        }

        if (dqy < zys) html += '<span style="margin-left:2px;margin-right:2px;">...</span>';
    } else {
        for (var i = 1; i <= zys; i++) {
            if (i == dqy) {
                html += '<span class="current" style="margin-left:2px;margin-right:2px;cursor: pointer;" onclick="fanye(' + i + ')">' + i + '</span>';
            } else {
                html += '<span style="margin-left:2px;margin-right:2px;cursor: pointer;" onclick="fanye(' + i + ')">' + i + '</span>';
            }
        }
    }

    html += '<a href="javascript:void(0);" style="margin-left:2px;margin-right:2px;" onclick="fanye(' + ((parseInt(dqy) + 1) > zys ? zys : (parseInt(dqy) + 1)) + ')">&gt;</a>';
    html += '<a href="javascript:void(0);" style="margin-left:2px;margin-right:2px;" onclick="fanye(' + zys + ')">&gt;&gt;</a>' +
        '共' + zys + '页，到第<input class="layui-input" style="width: 50px;margin-left:2px;margin-right:2px;text-align:center;" id="pagesize" onchange="this.value>' + zys + '?this.value=' + zys + ':this.value=this.value">页' +
        '<button class="layui-btn layui-btn-green" style="margin-left:2px;margin-right:2px;" onclick="fanye($(\'#pagesize\').val());">go</button>' +
        '</div>';
    $(".page").html(html);
}