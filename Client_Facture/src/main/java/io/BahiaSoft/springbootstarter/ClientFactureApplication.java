package io.BahiaSoft.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"io.BahiaSoft.springbootstarter"})

public class ClientFactureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientFactureApplication.class, args);
	}

}

