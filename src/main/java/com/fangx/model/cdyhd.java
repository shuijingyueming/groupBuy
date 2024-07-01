package com.fangx.model;

import java.util.Date;

public class cdyhd {
    private cdusd usd;
    private cdusc usc;

    public cdusd getUsd() {
        return usd;
    }

    public void setUsd(cdusd usd) {
        this.usd = usd;
    }

    public cdusc getUsc() {
        return usc;
    }

    public void setUsc(cdusc usc) {
        this.usc = usc;
    }

    private String yhd001;

    private Integer yhd002;

    private Integer yhd003;

    private Float yhd004;

    private Date yhd005;

    private String yhd006;

    public String getYhd001() {
        return yhd001;
    }

    public void setYhd001(String yhd001) {
        this.yhd001 = yhd001 == null ? null : yhd001.trim();
    }

    public Integer getYhd002() {
        return yhd002;
    }

    public void setYhd002(Integer yhd002) {
        this.yhd002 = yhd002;
    }

    public Integer getYhd003() {
        return yhd003;
    }

    public void setYhd003(Integer yhd003) {
        this.yhd003 = yhd003;
    }

    public Float getYhd004() {
        return yhd004;
    }

    public void setYhd004(Float yhd004) {
        this.yhd004 = yhd004;
    }

    public Date getYhd005() {
        return yhd005;
    }

    public void setYhd005(Date yhd005) {
        this.yhd005 = yhd005;
    }

    public String getYhd006() {
        return yhd006;
    }

    public void setYhd006(String yhd006) {
        this.yhd006 = yhd006 == null ? null : yhd006.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yhd001=").append(yhd001);
        sb.append(", yhd002=").append(yhd002);
        sb.append(", yhd003=").append(yhd003);
        sb.append(", yhd004=").append(yhd004);
        sb.append(", yhd005=").append(yhd005);
        sb.append(", yhd006=").append(yhd006);
        sb.append("]");
        return sb.toString();
    }
}