package com.fangx.model;

public class cdxxzWithBLOBs extends cdxxz {
    private String xxz023;

    private String xxz024;

    public String getXxz023() {
        return xxz023;
    }

    public void setXxz023(String xxz023) {
        this.xxz023 = xxz023 == null ? null : xxz023.trim();
    }

    public String getXxz024() {
        return xxz024;
    }

    public void setXxz024(String xxz024) {
        this.xxz024 = xxz024 == null ? null : xxz024.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", xxz023=").append(xxz023);
        sb.append(", xxz024=").append(xxz024);
        sb.append("]");
        return sb.toString();
    }
}