package com.fangx.model;

public class cdyhb {
    private String yhb001;

    private Integer yhb002;

    private Integer yhb003;

    private String yhb004;

    private String yhb005;

    public String getYhb001() {
        return yhb001;
    }

    public void setYhb001(String yhb001) {
        this.yhb001 = yhb001 == null ? null : yhb001.trim();
    }

    public Integer getYhb002() {
        return yhb002;
    }

    public void setYhb002(Integer yhb002) {
        this.yhb002 = yhb002;
    }

    public Integer getYhb003() {
        return yhb003;
    }

    public void setYhb003(Integer yhb003) {
        this.yhb003 = yhb003;
    }

    public String getYhb004() {
        return yhb004;
    }

    public void setYhb004(String yhb004) {
        this.yhb004 = yhb004 == null ? null : yhb004.trim();
    }

    public String getYhb005() {
        return yhb005;
    }

    public void setYhb005(String yhb005) {
        this.yhb005 = yhb005 == null ? null : yhb005.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yhb001=").append(yhb001);
        sb.append(", yhb002=").append(yhb002);
        sb.append(", yhb003=").append(yhb003);
        sb.append(", yhb004=").append(yhb004);
        sb.append(", yhb005=").append(yhb005);
        sb.append("]");
        return sb.toString();
    }
}