package com.fangx.pub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class properConfig {
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.jdbcurl}")
    private String jdbcurl;
    @Value("${spring.datasource.jdbcdk}")
    private String jdbcdk;
    @Value("${spring.datasource.dataname}")
    private String dataname;

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }


    public String getJdbcdk() {
        return jdbcdk;
    }

    public void setJdbcdk(String jdbcdk) {
        this.jdbcdk = jdbcdk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }

    public void setJdbcurl(String jdbcurl) {
        this.jdbcurl = jdbcurl;
    }

}
