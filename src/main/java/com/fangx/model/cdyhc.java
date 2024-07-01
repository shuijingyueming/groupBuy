package com.fangx.model;

import java.util.Date;
import java.util.List;

public class cdyhc {

    private cdusc usc;
    private cdusd usd;

    private List<cdush> ushlist;

    public cdusc getUsc() {
        return usc;
    }

    public void setUsc(cdusc usc) {
        this.usc = usc;
    }

    public cdusd getUsd() {
        return usd;
    }

    public void setUsd(cdusd usd) {
        this.usd = usd;
    }

    public List<cdush> getUshlist() {
        return ushlist;
    }

    public void setUshlist(List<cdush> ushlist) {
        this.ushlist = ushlist;
    }

    private String yhc001;

    private Integer yhc002;

    private Integer yhc003;

    private Date yhc004;

    private String yhc005;

    private String yhc006;

    private Float yhc007;

    private Date yhc008;

    private String yhc009;

    private String yhc010;

    private String yhc011;

    private String yhc012;

    public String getYhc001() {
        return yhc001;
    }

    public void setYhc001(String yhc001) {
        this.yhc001 = yhc001 == null ? null : yhc001.trim();
    }

    public Integer getYhc002() {
        return yhc002;
    }

    public void setYhc002(Integer yhc002) {
        this.yhc002 = yhc002;
    }

    public Integer getYhc003() {
        return yhc003;
    }

    public void setYhc003(Integer yhc003) {
        this.yhc003 = yhc003;
    }

    public Date getYhc004() {
        return yhc004;
    }

    public void setYhc004(Date yhc004) {
        this.yhc004 = yhc004;
    }

    public String getYhc005() {
        return yhc005;
    }

    public void setYhc005(String yhc005) {
        this.yhc005 = yhc005 == null ? null : yhc005.trim();
    }

    public String getYhc006() {
        return yhc006;
    }

    public void setYhc006(String yhc006) {
        this.yhc006 = yhc006 == null ? null : yhc006.trim();
    }

    public Float getYhc007() {
        return yhc007;
    }

    public void setYhc007(Float yhc007) {
        this.yhc007 = yhc007;
    }

    public Date getYhc008() {
        return yhc008;
    }

    public void setYhc008(Date yhc008) {
        this.yhc008 = yhc008;
    }

    public String getYhc009() {
        return yhc009;
    }

    public void setYhc009(String yhc009) {
        this.yhc009 = yhc009 == null ? null : yhc009.trim();
    }

    public String getYhc010() {
        return yhc010;
    }

    public void setYhc010(String yhc010) {
        this.yhc010 = yhc010;
    }

    public String getYhc011() {
        return yhc011;
    }

    public void setYhc011(String yhc011) {
        this.yhc011 = yhc011 == null ? null : yhc011.trim();
    }

    public String getYhc012() {
        return yhc012;
    }

    public void setYhc012(String yhc012) {
        this.yhc012 = yhc012 == null ? null : yhc012.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yhc001=").append(yhc001);
        sb.append(", yhc002=").append(yhc002);
        sb.append(", yhc003=").append(yhc003);
        sb.append(", yhc004=").append(yhc004);
        sb.append(", yhc005=").append(yhc005);
        sb.append(", yhc006=").append(yhc006);
        sb.append(", yhc007=").append(yhc007);
        sb.append(", yhc008=").append(yhc008);
        sb.append(", yhc009=").append(yhc009);
        sb.append(", yhc010=").append(yhc010);
        sb.append(", yhc011=").append(yhc011);
        sb.append(", yhc012=").append(yhc012);
        sb.append("]");
        return sb.toString();
    }
}