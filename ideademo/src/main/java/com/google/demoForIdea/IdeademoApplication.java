package com.google.demoForIdea;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@MapperScan(basePackages = "com.google.demoForIdea.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class IdeademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdeademoApplication.class, args);
    }

}
