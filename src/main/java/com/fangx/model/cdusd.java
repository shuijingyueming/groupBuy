package com.fangx.model;

import java.util.Date;

public class cdusd {
    private Integer usd001;

    private String usd002;

    private String usd003;

    private String usd004;

    private Integer usd005;

    private Float usd006;

    private Float usd007;

    private Integer usd008;

    private Float usd009;

    private Date usd010;

    private String usd011;

    private String usd012;

    public Integer getUsd001() {
        return usd001;
    }

    public void setUsd001(Integer usd001) {
        this.usd001 = usd001;
    }

    public String getUsd002() {
        return usd002;
    }

    public void setUsd002(String usd002) {
        this.usd002 = usd002 == null ? null : usd002.trim();
    }

    public String getUsd003() {
        return usd003;
    }

    public void setUsd003(String usd003) {
        this.usd003 = usd003 == null ? null : usd003.trim();
    }

    public String getUsd004() {
        return usd004;
    }

    public void setUsd004(String usd004) {
        this.usd004 = usd004 == null ? null : usd004.trim();
    }

    public Integer getUsd005() {
        return usd005;
    }

    public void setUsd005(Integer usd005) {
        this.usd005 = usd005;
    }

    public Float getUsd006() {
        return usd006;
    }

    public void setUsd006(Float usd006) {
        this.usd006 = usd006;
    }

    public Float getUsd007() {
        return usd007;
    }

    public void setUsd007(Float usd007) {
        this.usd007 = usd007;
    }

    public Integer getUsd008() {
        return usd008;
    }

    public void setUsd008(Integer usd008) {
        this.usd008 = usd008;
    }

    public Float getUsd009() {
        return usd009;
    }

    public void setUsd009(Float usd009) {
        this.usd009 = usd009;
    }

    public Date getUsd010() {
        return usd010;
    }

    public void setUsd010(Date usd010) {
        this.usd010 = usd010;
    }

    public String getUsd011() {
        return usd011;
    }

    public void setUsd011(String usd011) {
        this.usd011 = usd011 == null ? null : usd011.trim();
    }

    public String getUsd012() {
        return usd012;
    }

    public void setUsd012(String usd012) {
        this.usd012 = usd012 == null ? null : usd012.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usd001=").append(usd001);
        sb.append(", usd002=").append(usd002);
        sb.append(", usd003=").append(usd003);
        sb.append(", usd004=").append(usd004);
        sb.append(", usd005=").append(usd005);
        sb.append(", usd006=").append(usd006);
        sb.append(", usd007=").append(usd007);
        sb.append(", usd008=").append(usd008);
        sb.append(", usd009=").append(usd009);
        sb.append(", usd010=").append(usd010);
        sb.append(", usd011=").append(usd011);
        sb.append(", usd012=").append(usd012);
        sb.append("]");
        return sb.toString();
    }
}