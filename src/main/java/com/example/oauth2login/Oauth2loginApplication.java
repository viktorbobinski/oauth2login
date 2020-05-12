package com.example.oauth2login;

import com.example.oauth2login.model.User;
import com.example.oauth2login.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Oauth2loginApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2loginApplication.class, args);
	}
}
