package com.fangx.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author Sunweifeng
 * @Date 2023/3/16 11:16
 */
public class time implements Serializable {

    private Date d;

    private boolean zt;

    private List<cdusd> usdlist;

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public boolean isZt() {
        return zt;
    }

    public void setZt(boolean zt) {
        this.zt = zt;
    }

    public List<cdusd> getUsdlist() {
        return usdlist;
    }

    public void setUsdlist(List<cdusd> usdlist) {
        this.usdlist = usdlist;
    }
}
