package io.javaworkshop.coronavirustracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import io.javaworkshop.coronavirustracker.accessingdatajpa.Users;
import io.javaworkshop.coronavirustracker.models.CoronaVirsuStatSummay;
import io.javaworkshop.coronavirustracker.reposistory.UserRepository;

@EnableScheduling
@SpringBootApplication
public class CoronaVirusTrackerApplication {

	private static final Logger log = 
			LoggerFactory.getLogger(CoronaVirusTrackerApplication.class);

	@Bean
	public CoronaVirsuStatSummay getCoronaVirsuStatSummayObj() {
		return new CoronaVirsuStatSummay();
	}

	public static void main(String[] args) {
		SpringApplication.run(CoronaVirusTrackerApplication.class, args);
	}

	/*
	 * @Bean public CommandLineRunner demo(CustomerRepository repository) { return
	 * (args) -> { // save a few customers repository.save(new Users("Jack",
	 * "Bauer")); repository.save(new Users("Chloe", "O'Brian"));
	 * repository.save(new Users("Kim", "Bauer")); repository.save(new
	 * Users("David", "Palmer")); repository.save(new Users("Michelle", "Dessler"));
	 * 
	 * // fetch all customers log.info("Customers found with findAll():");
	 * log.info("-------------------------------"); for (Users customer :
	 * repository.findAll()) { log.info(customer.toString()); } log.info("");
	 * 
	 * // fetch an individual customer by ID Users customer =
	 * repository.findById(1L); log.info("Customer found with findById(1L):");
	 * log.info("--------------------------------"); log.info(customer.toString());
	 * log.info("");
	 * 
	 * // fetch customers by last name
	 * log.info("Customer found with findByLastName('Bauer'):");
	 * log.info("--------------------------------------------");
	 * repository.findByLastName("Bauer").forEach(bauer -> {
	 * log.info(bauer.toString()); }); // for (Customer bauer :
	 * repository.findByLastName("Bauer")) { // log.info(bauer.toString()); // }
	 * log.info(""); }; }
	 */

}
