package ffr.app;

import ffr.entities.Customer;
import ffr.repositories.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// FFR

@Configuration
@EnableAutoConfiguration(exclude = { WebInitializer.class })
@ComponentScan(basePackages = { "ffr.app", "ffr.services", "ffr.controllers", "ffr.security" })
@EnableJpaRepositories(basePackages = { "ffr.repositories" })
@EntityScan(basePackages = { "ffr.entities" })
@EnableTransactionManagement
public class Application {
	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class);

		CustomerRepository repository = context.getBean(CustomerRepository.class);
		repository.save(new Customer("Jack", "Bauer"));
	}
}
