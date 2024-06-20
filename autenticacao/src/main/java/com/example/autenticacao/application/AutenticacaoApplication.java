package com.example.autenticacao.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class AutenticacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutenticacaoApplication.class, args);
	}

}
