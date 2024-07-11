package com.fangx.model;

import java.util.Date;

public class cdysd {
    private cdusd usd;

    public cdusd getUsd() {
        return usd;
    }

    public void setUsd(cdusd usd) {
        this.usd = usd;
    }

    private Integer ysd001;

    private Integer ysd002;

    private Integer ysd003;

    private Date ysd004;

    private String ysd005;

    private Integer ysd006;

    public Integer getYsd001() {
        return ysd001;
    }

    public void setYsd001(Integer ysd001) {
        this.ysd001 = ysd001;
    }

    public Integer getYsd002() {
        return ysd002;
    }

    public void setYsd002(Integer ysd002) {
        this.ysd002 = ysd002;
    }

    public Integer getYsd003() {
        return ysd003;
    }

    public void setYsd003(Integer ysd003) {
        this.ysd003 = ysd003;
    }

    public Date getYsd004() {
        return ysd004;
    }

    public void setYsd004(Date ysd004) {
        this.ysd004 = ysd004;
    }

    public String getYsd005() {
        return ysd005;
    }

    public void setYsd005(String ysd005) {
        this.ysd005 = ysd005 == null ? null : ysd005.trim();
    }

    public Integer getYsd006() {
        return ysd006;
    }

    public void setYsd006(Integer ysd006) {
        this.ysd006 = ysd006;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ysd001=").append(ysd001);
        sb.append(", ysd002=").append(ysd002);
        sb.append(", ysd003=").append(ysd003);
        sb.append(", ysd004=").append(ysd004);
        sb.append(", ysd005=").append(ysd005);
        sb.append(", ysd006=").append(ysd006);
        sb.append("]");
        return sb.toString();
    }
}