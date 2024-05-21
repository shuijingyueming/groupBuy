package com.fangx.model;

public class cdusb {
    private Integer usb001;

    private String usb002;

    private Integer usb003;

    private Integer usb004;

    private String usb005;

    private Integer usb006;

    private String usb007;

    private String usb008;

    public Integer getUsb001() {
        return usb001;
    }

    public void setUsb001(Integer usb001) {
        this.usb001 = usb001;
    }

    public String getUsb002() {
        return usb002;
    }

    public void setUsb002(String usb002) {
        this.usb002 = usb002 == null ? null : usb002.trim();
    }

    public Integer getUsb003() {
        return usb003;
    }

    public void setUsb003(Integer usb003) {
        this.usb003 = usb003;
    }

    public Integer getUsb004() {
        return usb004;
    }

    public void setUsb004(Integer usb004) {
        this.usb004 = usb004;
    }

    public String getUsb005() {
        return usb005;
    }

    public void setUsb005(String usb005) {
        this.usb005 = usb005 == null ? null : usb005.trim();
    }

    public Integer getUsb006() {
        return usb006;
    }

    public void setUsb006(Integer usb006) {
        this.usb006 = usb006;
    }

    public String getUsb007() {
        return usb007;
    }

    public void setUsb007(String usb007) {
        this.usb007 = usb007 == null ? null : usb007.trim();
    }

    public String getUsb008() {
        return usb008;
    }

    public void setUsb008(String usb008) {
        this.usb008 = usb008 == null ? null : usb008.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", usb001=").append(usb001);
        sb.append(", usb002=").append(usb002);
        sb.append(", usb003=").append(usb003);
        sb.append(", usb004=").append(usb004);
        sb.append(", usb005=").append(usb005);
        sb.append(", usb006=").append(usb006);
        sb.append(", usb007=").append(usb007);
        sb.append(", usb008=").append(usb008);
        sb.append("]");
        return sb.toString();
    }
}