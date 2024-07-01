package com.fangx.model;

import java.util.Date;

public class cdysb {
    private Integer ysb001;

    private Integer ysb002;

    private Date ysb003;

    private Date ysb004;

    private String ysb005;

    private Integer ysb006;

    public Integer getYsb001() {
        return ysb001;
    }

    public void setYsb001(Integer ysb001) {
        this.ysb001 = ysb001;
    }

    public Integer getYsb002() {
        return ysb002;
    }

    public void setYsb002(Integer ysb002) {
        this.ysb002 = ysb002;
    }

    public Date getYsb003() {
        return ysb003;
    }

    public void setYsb003(Date ysb003) {
        this.ysb003 = ysb003;
    }

    public Date getYsb004() {
        return ysb004;
    }

    public void setYsb004(Date ysb004) {
        this.ysb004 = ysb004;
    }

    public String getYsb005() {
        return ysb005;
    }

    public void setYsb005(String ysb005) {
        this.ysb005 = ysb005 == null ? null : ysb005.trim();
    }

    public Integer getYsb006() {
        return ysb006;
    }

    public void setYsb006(Integer ysb006) {
        this.ysb006 = ysb006;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ysb001=").append(ysb001);
        sb.append(", ysb002=").append(ysb002);
        sb.append(", ysb003=").append(ysb003);
        sb.append(", ysb004=").append(ysb004);
        sb.append(", ysb005=").append(ysb005);
        sb.append(", ysb006=").append(ysb006);
        sb.append("]");
        return sb.toString();
    }
}