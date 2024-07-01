package com.fangx.pub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DateCon {
    public DateCon() {
    }

    private String url_name = "192.168.1.5";


    public void initcon() {
        this.url_name = "jdbc:mysql://" + url_name + ":3306/";
    }

    public Connection getcon(String sjk, String sjkm, String sjkmm) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = this.url_name + sjk + "?characterEncoding=utf8";
            System.out.println(url);
            con = DriverManager.getConnection(url, sjkm, sjkmm);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
        return con;
    }

}
