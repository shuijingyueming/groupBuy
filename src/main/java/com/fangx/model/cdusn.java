package com.fangx.model;

public class cdusn {
    private Integer usn001;

    private Integer usn002;

    private String usn003;

    private String usn004;

    private String usn005;

    public Integer getUsn001() {
        return usn001;
    }

    public void setUsn001(Integer usn001) {
        this.usn001 = usn001;
    }

    public Integer getUsn002() {
        return usn002;
    }

    public void setUsn002(Integer usn002) {
        this.usn002 = usn002;
    }

    public String getUsn003() {
        return usn003;
    }

    public void setUsn003(String usn003) {
        this.usn003 = usn003 == null ? null : usn003.trim();
    }

    public String getUsn004() {
        return usn004;
    }

    public void setUsn004(String usn004) {
        this.usn004 = usn004 == null ? null : usn004.trim();
    }

    public String getUsn005() {
        return usn005;
    }

    public void setUsn005(String usn005) {
        this.usn005 = usn005 == null ? null : usn005.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usn001=").append(usn001);
        sb.append(", usn002=").append(usn002);
        sb.append(", usn003=").append(usn003);
        sb.append(", usn004=").append(usn004);
        sb.append(", usn005=").append(usn005);
        sb.append("]");
        return sb.toString();
    }
}