package com.fangx.model;

import java.util.Date;

public class cdysc {
    private cdusf usf;

    public cdusf getUsf() {
        return usf;
    }

    public void setUsf(cdusf usf) {
        this.usf = usf;
    }

    private Integer ysc001;

    private Integer ysc002;

    private Date ysc003;

    private Date ysc004;

    private String ysc005;

    private Integer ysc006;

    private String ysc007;

    public Integer getYsc001() {
        return ysc001;
    }

    public void setYsc001(Integer ysc001) {
        this.ysc001 = ysc001;
    }

    public Integer getYsc002() {
        return ysc002;
    }

    public void setYsc002(Integer ysc002) {
        this.ysc002 = ysc002;
    }

    public Date getYsc003() {
        return ysc003;
    }

    public void setYsc003(Date ysc003) {
        this.ysc003 = ysc003;
    }

    public Date getYsc004() {
        return ysc004;
    }

    public void setYsc004(Date ysc004) {
        this.ysc004 = ysc004;
    }

    public String getYsc005() {
        return ysc005;
    }

    public void setYsc005(String ysc005) {
        this.ysc005 = ysc005 == null ? null : ysc005.trim();
    }

    public Integer getYsc006() {
        return ysc006;
    }

    public void setYsc006(Integer ysc006) {
        this.ysc006 = ysc006;
    }

    public String getYsc007() {
        return ysc007;
    }

    public void setYsc007(String ysc007) {
        this.ysc007 = ysc007;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ysc001=").append(ysc001);
        sb.append(", ysc002=").append(ysc002);
        sb.append(", ysc003=").append(ysc003);
        sb.append(", ysc004=").append(ysc004);
        sb.append(", ysc005=").append(ysc005);
        sb.append(", ysc006=").append(ysc006);
        sb.append(", ysc007=").append(ysc007);
        sb.append("]");
        return sb.toString();
    }
}