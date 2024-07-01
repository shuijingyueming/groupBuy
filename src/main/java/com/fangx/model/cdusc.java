package com.fangx.model;

import java.util.Date;
import java.util.List;

public class cdusc {

    private String nr;
    private String bz;

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    private List<cdyhc> ddlist;
    private List<cdusf> cplist;

    public List<cdyhc> getDdlist() {
        return ddlist;
    }

    public void setDdlist(List<cdyhc> ddlist) {
        this.ddlist = ddlist;
    }

    public List<cdusf> getCplist() {
        return cplist;
    }

    public void setCplist(List<cdusf> cplist) {
        this.cplist = cplist;
    }

    private cdusd usd;

    public cdusd getUsd() {
        return usd;
    }

    public void setUsd(cdusd usd) {
        this.usd = usd;
    }

    private Integer usc001;

    private String usc002;

    private String usc003;

    private String usc004;

    private Integer usc005;

    private String usc006;

    private String usc007;

    private Float usc008;

    private Float usc009;

    private Float usc010;

    private Float usc011;

    private Float usc012;

    private Integer usc013;

    private Date usc014;

    private String usc015;

    private String usc016;

    private String usc017;

    private String usc018;

    public Integer getUsc001() {
        return usc001;
    }

    public void setUsc001(Integer usc001) {
        this.usc001 = usc001;
    }

    public String getUsc002() {
        return usc002;
    }

    public void setUsc002(String usc002) {
        this.usc002 = usc002 == null ? null : usc002.trim();
    }

    public String getUsc003() {
        return usc003;
    }

    public void setUsc003(String usc003) {
        this.usc003 = usc003 == null ? null : usc003.trim();
    }

    public String getUsc004() {
        return usc004;
    }

    public void setUsc004(String usc004) {
        this.usc004 = usc004 == null ? null : usc004.trim();
    }

    public Integer getUsc005() {
        return usc005;
    }

    public void setUsc005(Integer usc005) {
        this.usc005 = usc005;
    }

    public String getUsc006() {
        return usc006;
    }

    public void setUsc006(String usc006) {
        this.usc006 = usc006 == null ? null : usc006.trim();
    }

    public String getUsc007() {
        return usc007;
    }

    public void setUsc007(String usc007) {
        this.usc007 = usc007 == null ? null : usc007.trim();
    }

    public Float getUsc008() {
        return usc008;
    }

    public void setUsc008(Float usc008) {
        this.usc008 = usc008;
    }

    public Float getUsc009() {
        return usc009;
    }

    public void setUsc009(Float usc009) {
        this.usc009 = usc009;
    }

    public Float getUsc010() {
        return usc010;
    }

    public void setUsc010(Float usc010) {
        this.usc010 = usc010;
    }

    public Float getUsc011() {
        return usc011;
    }

    public void setUsc011(Float usc011) {
        this.usc011 = usc011;
    }

    public Float getUsc012() {
        return usc012;
    }

    public void setUsc012(Float usc012) {
        this.usc012 = usc012;
    }

    public Integer getUsc013() {
        return usc013;
    }

    public void setUsc013(Integer usc013) {
        this.usc013 = usc013;
    }

    public Date getUsc014() {
        return usc014;
    }

    public void setUsc014(Date usc014) {
        this.usc014 = usc014;
    }

    public String getUsc015() {
        return usc015;
    }

    public void setUsc015(String usc015) {
        this.usc015 = usc015 == null ? null : usc015.trim();
    }

    public String getUsc016() {
        return usc016;
    }

    public void setUsc016(String usc016) {
        this.usc016 = usc016 == null ? null : usc016.trim();
    }

    public String getUsc017() {
        return usc017;
    }

    public void setUsc017(String usc017) {
        this.usc017 = usc017 == null ? null : usc017.trim();
    }

    public String getUsc018() {
        return usc018;
    }

    public void setUsc018(String usc018) {
        this.usc018 = usc018 == null ? null : usc018.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usc001=").append(usc001);
        sb.append(", usc002=").append(usc002);
        sb.append(", usc003=").append(usc003);
        sb.append(", usc004=").append(usc004);
        sb.append(", usc005=").append(usc005);
        sb.append(", usc006=").append(usc006);
        sb.append(", usc007=").append(usc007);
        sb.append(", usc008=").append(usc008);
        sb.append(", usc009=").append(usc009);
        sb.append(", usc010=").append(usc010);
        sb.append(", usc011=").append(usc011);
        sb.append(", usc012=").append(usc012);
        sb.append(", usc013=").append(usc013);
        sb.append(", usc014=").append(usc014);
        sb.append(", usc015=").append(usc015);
        sb.append(", usc016=").append(usc016);
        sb.append(", usc017=").append(usc017);
        sb.append(", usc018=").append(usc018);
        sb.append("]");
        return sb.toString();
    }
}