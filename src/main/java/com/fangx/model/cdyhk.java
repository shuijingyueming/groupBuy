package com.fangx.model;

import java.util.Date;

public class cdyhk {
    private cdusd usd;

    public cdusd getUsd() {
        return usd;
    }

    public void setUsd(cdusd usd) {
        this.usd = usd;
    }
    private String yhk001;

    private Integer yhk002;

    private Date yhk003;

    private Float yhk004;

    private Float yhk005;

    private Float yhk006;

    private String yhk007;

    private Integer yhk008;

    private String yhk009;

    public String getYhk001() {
        return yhk001;
    }

    public void setYhk001(String yhk001) {
        this.yhk001 = yhk001 == null ? null : yhk001.trim();
    }

    public Integer getYhk002() {
        return yhk002;
    }

    public void setYhk002(Integer yhk002) {
        this.yhk002 = yhk002;
    }

    public Date getYhk003() {
        return yhk003;
    }

    public void setYhk003(Date yhk003) {
        this.yhk003 = yhk003;
    }

    public Float getYhk004() {
        return yhk004;
    }

    public void setYhk004(Float yhk004) {
        this.yhk004 = yhk004;
    }

    public Float getYhk005() {
        return yhk005;
    }

    public void setYhk005(Float yhk005) {
        this.yhk005 = yhk005;
    }

    public Float getYhk006() {
        return yhk006;
    }

    public void setYhk006(Float yhk006) {
        this.yhk006 = yhk006;
    }

    public String getYhk007() {
        return yhk007;
    }

    public void setYhk007(String yhk007) {
        this.yhk007 = yhk007 == null ? null : yhk007.trim();
    }

    public Integer getYhk008() {
        return yhk008;
    }

    public void setYhk008(Integer yhk008) {
        this.yhk008 = yhk008;
    }

    public String getYhk009() {
        return yhk009;
    }

    public void setYhk009(String yhk009) {
        this.yhk009 = yhk009 == null ? null : yhk009.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yhk001=").append(yhk001);
        sb.append(", yhk002=").append(yhk002);
        sb.append(", yhk003=").append(yhk003);
        sb.append(", yhk004=").append(yhk004);
        sb.append(", yhk005=").append(yhk005);
        sb.append(", yhk006=").append(yhk006);
        sb.append(", yhk007=").append(yhk007);
        sb.append(", yhk008=").append(yhk008);
        sb.append(", yhk009=").append(yhk009);
        sb.append("]");
        return sb.toString();
    }
}