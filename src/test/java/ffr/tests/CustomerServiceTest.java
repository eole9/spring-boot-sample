package ffr.tests;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ffr.app.Application;
import ffr.entities.Customer;
import ffr.services.CustomerService;

@SpringApplicationConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void test1() {

		// Add customer
		customerService.createCustomer(new Customer("Julien", "Lepers"));

		// Display customers
		Collection<Customer> customers = customerService.getAllCustomers();
		display("Customers: ", customers);
	}

	/**
	 * display
	 * 
	 * @param message
	 * @param elements
	 */
	private void display(String message, Iterable<?> elements) {
		System.out.println(message);
		for (Object element : elements) {
			System.out.println(element);
		}
	}
}
