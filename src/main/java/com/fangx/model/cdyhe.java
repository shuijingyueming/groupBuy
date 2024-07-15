package com.fangx.model;

import java.util.List;

public class cdyhe {
    private Integer index=0;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    private List<cdusf>usflist;

    public List<cdusf> getUsflist() {
        return usflist;
    }

    public void setUsflist(List<cdusf> usflist) {
        this.usflist = usflist;
    }

    private List<cdysa> ysalist;

    public List<cdysa> getYsalist() {
        return ysalist;
    }

    public void setYsalist(List<cdysa> ysalist) {
        this.ysalist = ysalist;
    }

    private Integer yhe001;

    private String yhe002;

    private String yhe003;

    private String yhe004;

    private String yhe005;

    public Integer getYhe001() {
        return yhe001;
    }

    public void setYhe001(Integer yhe001) {
        this.yhe001 = yhe001;
    }

    public String getYhe002() {
        return yhe002;
    }

    public void setYhe002(String yhe002) {
        this.yhe002 = yhe002 == null ? null : yhe002.trim();
    }

    public String getYhe003() {
        return yhe003;
    }

    public void setYhe003(String yhe003) {
        this.yhe003 = yhe003 == null ? null : yhe003.trim();
    }

    public String getYhe004() {
        return yhe004;
    }

    public void setYhe004(String yhe004) {
        this.yhe004 = yhe004 == null ? null : yhe004.trim();
    }

    public String getYhe005() {
        return yhe005;
    }

    public void setYhe005(String yhe005) {
        this.yhe005 = yhe005 == null ? null : yhe005.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yhe001=").append(yhe001);
        sb.append(", yhe002=").append(yhe002);
        sb.append(", yhe003=").append(yhe003);
        sb.append(", yhe004=").append(yhe004);
        sb.append(", yhe005=").append(yhe005);
        sb.append("]");
        return sb.toString();
    }
}