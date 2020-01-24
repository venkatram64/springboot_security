package com.venkat.jdbcsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#user-schema
@SpringBootApplication
public class JdbcSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcSecurityApplication.class, args);
	}

}
