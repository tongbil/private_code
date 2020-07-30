package com.google.demoForIdea.common;


import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "hikari")
public class DBProperties {
	private HikariDataSource test1;
	private HikariDataSource osgitest;


}