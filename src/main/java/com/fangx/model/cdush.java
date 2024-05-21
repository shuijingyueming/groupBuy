package com.fangx.model;

public class cdush {
    private String ush001;

    private String ush002;

    private Integer ush003;

    private Integer ush004;

    private Float ush005;

    private Float ush006;

    private Integer ush007;

    private String ush008;

    private String ush009;

    public String getUsh001() {
        return ush001;
    }

    public void setUsh001(String ush001) {
        this.ush001 = ush001 == null ? null : ush001.trim();
    }

    public String getUsh002() {
        return ush002;
    }

    public void setUsh002(String ush002) {
        this.ush002 = ush002 == null ? null : ush002.trim();
    }

    public Integer getUsh003() {
        return ush003;
    }

    public void setUsh003(Integer ush003) {
        this.ush003 = ush003;
    }

    public Integer getUsh004() {
        return ush004;
    }

    public void setUsh004(Integer ush004) {
        this.ush004 = ush004;
    }

    public Float getUsh005() {
        return ush005;
    }

    public void setUsh005(Float ush005) {
        this.ush005 = ush005;
    }

    public Float getUsh006() {
        return ush006;
    }

    public void setUsh006(Float ush006) {
        this.ush006 = ush006;
    }

    public Integer getUsh007() {
        return ush007;
    }

    public void setUsh007(Integer ush007) {
        this.ush007 = ush007;
    }

    public String getUsh008() {
        return ush008;
    }

    public void setUsh008(String ush008) {
        this.ush008 = ush008 == null ? null : ush008.trim();
    }

    public String getUsh009() {
        return ush009;
    }

    public void setUsh009(String ush009) {
        this.ush009 = ush009 == null ? null : ush009.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ush001=").append(ush001);
        sb.append(", ush002=").append(ush002);
        sb.append(", ush003=").append(ush003);
        sb.append(", ush004=").append(ush004);
        sb.append(", ush005=").append(ush005);
        sb.append(", ush006=").append(ush006);
        sb.append(", ush007=").append(ush007);
        sb.append(", ush008=").append(ush008);
        sb.append(", ush009=").append(ush009);
        sb.append("]");
        return sb.toString();
    }
}