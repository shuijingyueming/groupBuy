package com.fangx.model;

public class cdusa {
    private Integer usa001;

    private String usa002;

    private Integer usa003;

    private String usa004;

    private String usa005;

    private String usa006;

    public Integer getUsa001() {
        return usa001;
    }

    public void setUsa001(Integer usa001) {
        this.usa001 = usa001;
    }

    public String getUsa002() {
        return usa002;
    }

    public void setUsa002(String usa002) {
        this.usa002 = usa002 == null ? null : usa002.trim();
    }

    public Integer getUsa003() {
        return usa003;
    }

    public void setUsa003(Integer usa003) {
        this.usa003 = usa003;
    }

    public String getUsa004() {
        return usa004;
    }

    public void setUsa004(String usa004) {
        this.usa004 = usa004 == null ? null : usa004.trim();
    }

    public String getUsa005() {
        return usa005;
    }

    public void setUsa005(String usa005) {
        this.usa005 = usa005 == null ? null : usa005.trim();
    }

    public String getUsa006() {
        return usa006;
    }

    public void setUsa006(String usa006) {
        this.usa006 = usa006 == null ? null : usa006.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usa001=").append(usa001);
        sb.append(", usa002=").append(usa002);
        sb.append(", usa003=").append(usa003);
        sb.append(", usa004=").append(usa004);
        sb.append(", usa005=").append(usa005);
        sb.append(", usa006=").append(usa006);
        sb.append("]");
        return sb.toString();
    }
}