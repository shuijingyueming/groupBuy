package com.fangx.model;

import java.util.Date;

public class cdlog {
    private String log001;

    private String log002;

    private Date log003;

    private String log005;

    private String log006;

    private String log007;

    private String log008;

    private String log004;

    public String getLog001() {
        return log001;
    }

    public void setLog001(String log001) {
        this.log001 = log001 == null ? null : log001.trim();
    }

    public String getLog002() {
        return log002;
    }

    public void setLog002(String log002) {
        this.log002 = log002 == null ? null : log002.trim();
    }

    public Date getLog003() {
        return log003;
    }

    public void setLog003(Date log003) {
        this.log003 = log003;
    }

    public String getLog005() {
        return log005;
    }

    public void setLog005(String log005) {
        this.log005 = log005 == null ? null : log005.trim();
    }

    public String getLog006() {
        return log006;
    }

    public void setLog006(String log006) {
        this.log006 = log006 == null ? null : log006.trim();
    }

    public String getLog007() {
        return log007;
    }

    public void setLog007(String log007) {
        this.log007 = log007 == null ? null : log007.trim();
    }

    public String getLog008() {
        return log008;
    }

    public void setLog008(String log008) {
        this.log008 = log008 == null ? null : log008.trim();
    }

    public String getLog004() {
        return log004;
    }

    public void setLog004(String log004) {
        this.log004 = log004 == null ? null : log004.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", log001=").append(log001);
        sb.append(", log002=").append(log002);
        sb.append(", log003=").append(log003);
        sb.append(", log005=").append(log005);
        sb.append(", log006=").append(log006);
        sb.append(", log007=").append(log007);
        sb.append(", log008=").append(log008);
        sb.append(", log004=").append(log004);
        sb.append("]");
        return sb.toString();
    }
}