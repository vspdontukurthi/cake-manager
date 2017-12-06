package com.waracle.cakemgr.test.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

@EnableAutoConfiguration
@ComponentScan(basePackages={"com.waracle.cakemgr"})
@SpringBootTest(classes = { TestApplication.class })
@TestPropertySource("classpath:application.properties")
public class TestApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(TestApplication.class, args);
	}

}
