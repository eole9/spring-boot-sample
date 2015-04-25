package ffr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ffr.entities.Customer;
import ffr.repositories.CustomerRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "ffr" })
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
