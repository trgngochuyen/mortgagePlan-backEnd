package com.example.mortgageplan;

import com.example.mortgageplan.entity.Customer;
import com.example.mortgageplan.repository.CustomerRepository;
import com.example.mortgageplan.utils.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MortgagePlanApplication {
	private static final Logger log = LoggerFactory.getLogger(MortgagePlanApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MortgagePlanApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(FileReader fileReader, CustomerRepository repository) {
		return (args) -> {
			fileReader.readFile("./prospects.txt");
			// "/home/trgnghuyen/Workspace/Integrify/codeTest/crosskeyBankingSolutions/calculateMonthlyPayment/src/prospects.txt");
			// fetch all customers
			log.info("Customers and their payment plans");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

		};
	}
}
