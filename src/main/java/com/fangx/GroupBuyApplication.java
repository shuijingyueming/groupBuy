package com.fangx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.fangx.dao")
public class GroupBuyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupBuyApplication.class, args);
    }

}
