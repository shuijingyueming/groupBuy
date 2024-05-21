var encrypt = new JSEncrypt();
encrypt.setPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDXajYcIi2XXwXoKgH0JWxh1rgUdPjgJFAvmNitLQseMIhiF1vO+kNLHGCImQKcHScC4/UL1HJSY0dHsiOn8q5ydWFIt7UwxUddiSP5rjAoASYR6K6WKCkpUsPOk3a2/hm6t0DEyje9bLMuUjaTpylFBzkNfY1rp3iOtwNJkUd2nQIDAQAB");
var regex = new RegExp('(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{8,20}');

function login() {
    var name = $("input[type='text']").val();
    var pwd = $("input[type='password']").val();
    if(name!=""&&pwd!=""){
        $.ajax({
            url:'tologin1',
            type:'post',
            data:{'username': encrypt.encrypt(name),'userpwd': encrypt.encrypt(pwd)},
            async: false,
            dataType:'json',
            success:function(data) {
                if(data.msg!="0"){
                    if(data.msg=="1"){
                        window.parent.parent.login("D");
                    }else{
                        layui.use('layer', function(){
                            var layer = layui.layer;
                            layer.ready(function(){
                                layer.msg(data.msg);
                            });
                        });
                    }
                }else{
                    layui.use('layer', function(){
                        var layer = layui.layer;
                        layer.ready(function(){
                            layer.msg("登录成功");
                        });
                    });
                    setTimeout(function(){
                        window.parent.parent.location.href=data.url;
                    },1000);
                }
            },
            error:function(){	}
        });
    }else{
        if(name==""){
            layer.msg("用户名不能为空");
        }else if(pwd==""){
            layer.msg("密码不能为空");
        }
    }
}

function xgmima(){
    var jiumm = $("input[name='jiumm']").val();
    var xinmm = $.trim($("input[name='xinmm']").val());
    var xinmm1 = $.trim($("input[name='xinmm1']").val());
    if(jiumm!=""&&xinmm!=""&&xinmm1!=""){
        if(xinmm==xinmm1&&jiumm!=xinmm){
            $.ajax({
                url:'updatePwd',
                type:'get',
                data:{'xinmm': encrypt.encrypt(xinmm),'jiumm': encrypt.encrypt(jiumm)},
                async: false,
                dataType:'json',
                success:function(data) {
                    console.log(data.msg)
                    if(data.msg!="0"){
                        if(data.msg=="3"){
                            window.parent.parent.login("D");
                        }else if(data.msg=="2"){
                            window.parent.parent.login("登录失效");
                        }else if(data.msg=="4"){
                            layui.use('layer', function(){
                                var layer = layui.layer;
                                layer.ready(function(){
                                    layer.msg("旧密码错误");
                                });
                            });
                            $("input[name='jiumm']").val("");
                        }else if(data.msg=="1"){
                            layui.use('layer', function(){
                                var layer = layui.layer;
                                layer.ready(function(){
                                    layer.msg("修改失败");
                                });
                            });
                        }
                    }else{
                        layui.use('layer', function(){
                            var layer = layui.layer;
                            layer.ready(function(){
                                layer.msg("修改成功");
                            });
                        });
                        setTimeout(function(){
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        },1000);
                    }
                },
                error:function(){ }
            });
        }else{
            if(jiumm==xinmm){
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.ready(function(){
                        layer.msg("新旧密码不能一致");
                    });
                });
            }else if(xinmm!=xinmm1){
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.ready(function(){
                        layer.msg("两次输入的新密码不一致");
                    });
                });
            }
        }
    }else{
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.ready(function(){
                layer.msg("请填写完整");
            });
        });
    }
}
