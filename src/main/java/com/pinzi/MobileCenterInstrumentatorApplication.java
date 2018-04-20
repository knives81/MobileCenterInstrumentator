package com.pinzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MobileCenterInstrumentatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileCenterInstrumentatorApplication.class, args);
	}
}
