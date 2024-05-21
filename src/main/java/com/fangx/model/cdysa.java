package com.fangx.model;

public class cdysa {
    private Integer ysa001;

    private String ysa002;

    private Integer ysa003;

    private String ysa004;

    private String ysa005;

    public Integer getYsa001() {
        return ysa001;
    }

    public void setYsa001(Integer ysa001) {
        this.ysa001 = ysa001;
    }

    public String getYsa002() {
        return ysa002;
    }

    public void setYsa002(String ysa002) {
        this.ysa002 = ysa002 == null ? null : ysa002.trim();
    }

    public Integer getYsa003() {
        return ysa003;
    }

    public void setYsa003(Integer ysa003) {
        this.ysa003 = ysa003;
    }

    public String getYsa004() {
        return ysa004;
    }

    public void setYsa004(String ysa004) {
        this.ysa004 = ysa004 == null ? null : ysa004.trim();
    }

    public String getYsa005() {
        return ysa005;
    }

    public void setYsa005(String ysa005) {
        this.ysa005 = ysa005 == null ? null : ysa005.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ysa001=").append(ysa001);
        sb.append(", ysa002=").append(ysa002);
        sb.append(", ysa003=").append(ysa003);
        sb.append(", ysa004=").append(ysa004);
        sb.append(", ysa005=").append(ysa005);
        sb.append("]");
        return sb.toString();
    }
}