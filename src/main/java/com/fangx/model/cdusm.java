package com.fangx.model;

public class cdusm {
    private Integer usm001;

    private String usm002;

    public Integer getUsm001() {
        return usm001;
    }

    public void setUsm001(Integer usm001) {
        this.usm001 = usm001;
    }

    public String getUsm002() {
        return usm002;
    }

    public void setUsm002(String usm002) {
        this.usm002 = usm002 == null ? null : usm002.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usm001=").append(usm001);
        sb.append(", usm002=").append(usm002);
        sb.append("]");
        return sb.toString();
    }
}