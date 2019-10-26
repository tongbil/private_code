package com.google.demoForIdea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.google.demoForIdea.dao")
public class IdeademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdeademoApplication.class, args);
    }

}
