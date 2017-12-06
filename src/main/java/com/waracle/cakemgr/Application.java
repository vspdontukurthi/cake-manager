package com.waracle.cakemgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages={"com.waracle.cakemgr"})
@SpringBootApplication
public class Application {
	
	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

}
