package com.example.oauth2login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Oauth2loginApplication {

	private static final Logger log = LoggerFactory.getLogger(Oauth2loginApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Oauth2loginApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new User(1, "Bauer"));
			repository.save(new User(2, "O'Brian"));
			repository.save(new User(3, "Bauer"));
			repository.save(new User(4, "Palmer"));
			repository.save(new User(5, "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			User customer = repository.findById(1).orElse(null);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
