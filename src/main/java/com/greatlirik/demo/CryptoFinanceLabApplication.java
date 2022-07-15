package com.greatlirik.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoFinanceLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoFinanceLabApplication.class, args);
	}

}
