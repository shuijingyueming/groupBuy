package com.fangx.model;

import java.util.Date;

public class cdusg {
    private String usg001;

    private Integer usg002;

    private Integer usg003;

    private Integer usg004;

    private Float usg005;

    private Float usg006;

    private Date usg007;

    private String usg008;

    private String usg009;

    public String getUsg001() {
        return usg001;
    }

    public void setUsg001(String usg001) {
        this.usg001 = usg001 == null ? null : usg001.trim();
    }

    public Integer getUsg002() {
        return usg002;
    }

    public void setUsg002(Integer usg002) {
        this.usg002 = usg002;
    }

    public Integer getUsg003() {
        return usg003;
    }

    public void setUsg003(Integer usg003) {
        this.usg003 = usg003;
    }

    public Integer getUsg004() {
        return usg004;
    }

    public void setUsg004(Integer usg004) {
        this.usg004 = usg004;
    }

    public Float getUsg005() {
        return usg005;
    }

    public void setUsg005(Float usg005) {
        this.usg005 = usg005;
    }

    public Float getUsg006() {
        return usg006;
    }

    public void setUsg006(Float usg006) {
        this.usg006 = usg006;
    }

    public Date getUsg007() {
        return usg007;
    }

    public void setUsg007(Date usg007) {
        this.usg007 = usg007;
    }

    public String getUsg008() {
        return usg008;
    }

    public void setUsg008(String usg008) {
        this.usg008 = usg008 == null ? null : usg008.trim();
    }

    public String getUsg009() {
        return usg009;
    }

    public void setUsg009(String usg009) {
        this.usg009 = usg009 == null ? null : usg009.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usg001=").append(usg001);
        sb.append(", usg002=").append(usg002);
        sb.append(", usg003=").append(usg003);
        sb.append(", usg004=").append(usg004);
        sb.append(", usg005=").append(usg005);
        sb.append(", usg006=").append(usg006);
        sb.append(", usg007=").append(usg007);
        sb.append(", usg008=").append(usg008);
        sb.append(", usg009=").append(usg009);
        sb.append("]");
        return sb.toString();
    }
}