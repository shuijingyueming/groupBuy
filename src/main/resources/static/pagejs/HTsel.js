$(document).ready(function () {
    var msg = $("#msg").val();
    if(msg!=''){
        if(msg=='D'){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.ready(function(){
                    layer.msg("删除成功");
                });
            });
        }else if(msg=='U'){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.ready(function(){
                    layer.msg("修改成功");
                });
            });
        }else if(msg=='I'){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.ready(function(){
                    layer.msg("添加成功");
                });
            });
        }else if(msg=='H'){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.ready(function(){
                    layer.msg("操作失败");
                });
            });
        }else if(msg=='C'){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.ready(function(){
                    layer.msg("操作成功");
                });
            });
        }else if(msg=='M'){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.ready(function(){
                    layer.msg("重置密码成功,重置密码为123456");
                });
            });
        }else if(msg=='DR'){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.ready(function(){
                    layer.msg("导入成功");
                });
            });
        }
    }

    //表格全选/反选
    $("#chkbox").change(function(){
        if($("#chkbox").is(":checked")){
            $("[name='cbox']").prop("checked",'checked');//全选
        }else{
            $("[name='cbox']").each(function(){
                this.checked=!this.checked;
            });
        }
        checked_item ="#";
        $("[name='cbox']").each(function(){
            if(this.checked) checked_item+=$(this).attr("date-id")+"#";
        });
        console.log(checked_item)
    });
});

function putIn(id,text,listSetName,divclassName,spanid,className,listName) {
    if(id!="")listName.push(id+"#"+text);
    //去重
    listSetName = new Set(listName);
    str = '#';
    listSetName.forEach((val) => {
        str += val.split('#')[0]+'#';
    })
    $(className).val(str);
    let html = ``;
    listSetName.forEach(val => {
        html +=  `<div class=dpcs xs='${val.split('#')[1]}'><image src=./static/images/delicon.png class=`;
        html +=spanid;
        html +=  ` name=`;
        html +=spanid;
        html +=` id=${val.split('#')[0]} value=${val.split('#')[0]} ></image>${val.split('#')[1]}</div>`
    })
    $(divclassName).empty();
    $(divclassName).append(html);
    return listSetName;
}
function putOn(isVal,isText,listSetName,divclassName,spanid,className,listName) {
    listSetName.forEach(val => {
        if(val==isVal+"#"+isText){
            listSetName.delete(val);
        }
    })
    $(className).val("");
    str="#";
    listName.splice(0,listName.length);
    listSetName.forEach((val) => {
        str += val.split('#')[0]+'#';
        listName.push(val);
    })
    $(className).val(str);
    let html = ``;
    listSetName.forEach(val => {
        html +=  `<div class=dpcs xs='${val.split('#')[1]}'><image src=./static/images/delicon.png class=`;
        html +=spanid;
        html +=  ` name=`;
        html +=spanid;
        html +=` id=${val.split('#')[0]} value=${val.split('#')[0]} ></image>${val.split('#')[1]}</div>`
    })
    $(divclassName).empty();
    $(divclassName).append(html);
}