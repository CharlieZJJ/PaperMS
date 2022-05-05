package com.database.paperms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.database.paperms.mapper")
@SpringBootApplication
public class PaperMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperMsApplication.class, args);
    }

}
