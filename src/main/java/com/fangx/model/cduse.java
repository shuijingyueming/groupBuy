package com.fangx.model;

public class cduse {
    private Integer use001;

    private String use002;

    private String use003;

    private String use004;

    private String use005;

    private String use006;

    private String use007;

    private Integer use008;

    private String use009;

    public Integer getUse001() {
        return use001;
    }

    public void setUse001(Integer use001) {
        this.use001 = use001;
    }

    public String getUse002() {
        return use002;
    }

    public void setUse002(String use002) {
        this.use002 = use002 == null ? null : use002.trim();
    }

    public String getUse003() {
        return use003;
    }

    public void setUse003(String use003) {
        this.use003 = use003 == null ? null : use003.trim();
    }

    public String getUse004() {
        return use004;
    }

    public void setUse004(String use004) {
        this.use004 = use004 == null ? null : use004.trim();
    }

    public String getUse005() {
        return use005;
    }

    public void setUse005(String use005) {
        this.use005 = use005 == null ? null : use005.trim();
    }

    public String getUse006() {
        return use006;
    }

    public void setUse006(String use006) {
        this.use006 = use006 == null ? null : use006.trim();
    }

    public String getUse007() {
        return use007;
    }

    public void setUse007(String use007) {
        this.use007 = use007 == null ? null : use007.trim();
    }

    public Integer getUse008() {
        return use008;
    }

    public void setUse008(Integer use008) {
        this.use008 = use008;
    }

    public String getUse009() {
        return use009;
    }

    public void setUse009(String use009) {
        this.use009 = use009 == null ? null : use009.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", use001=").append(use001);
        sb.append(", use002=").append(use002);
        sb.append(", use003=").append(use003);
        sb.append(", use004=").append(use004);
        sb.append(", use005=").append(use005);
        sb.append(", use006=").append(use006);
        sb.append(", use007=").append(use007);
        sb.append(", use008=").append(use008);
        sb.append(", use009=").append(use009);
        sb.append("]");
        return sb.toString();
    }
}