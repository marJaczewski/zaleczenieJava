package mariuszjaczewski.repository_rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
@ComponentScan("mariuszjaczewski.*")
public class RepositoryRestApplication {



	public static void main(String[] args) {
		SpringApplication.run(RepositoryRestApplication.class, args);
	}







}
