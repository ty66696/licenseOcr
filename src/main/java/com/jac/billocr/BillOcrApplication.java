package com.jac.billocr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jac.billocr.mapper")
public class BillOcrApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillOcrApplication.class, args);
    }

}
