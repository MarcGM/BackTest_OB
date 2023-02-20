package com.onebox.backendtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BackTestObApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackTestObApplication.class, args);
	}

}
