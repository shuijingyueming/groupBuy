package com.fangx.model;

import java.io.Serializable;

/**
 * @Author Sunweifeng
 * @Date 2023/3/16 11:16
 */
public class user implements Serializable {

    private static final long serialVersionUID=1L;

    private String uname;//用户名称

    private String jsqx;//角色权限

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getJsqx() {
        return jsqx;
    }

    public void setJsqx(String jsqx) {
        this.jsqx = jsqx;
    }
}
